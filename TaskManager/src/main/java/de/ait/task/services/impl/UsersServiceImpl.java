package de.ait.task.services.impl;

import de.ait.task.dto.*;
import de.ait.task.dto.pages.TasksDto;
import de.ait.task.dto.pages.UsersDto;
import de.ait.task.exceptions.ForbiddenUpdateUserOperationException;
import de.ait.task.exceptions.NotFoundException;
import de.ait.task.models.User;
import de.ait.task.repositories.TasksRepository;
import de.ait.task.repositories.UsersRepository;
import de.ait.task.services.UsersService;
import de.ait.task.utils.PageRequestsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.task.dto.UserDto.from;
import static de.ait.task.dto.TaskDto.from;


@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    private final TasksRepository tasksRepository;

    private final PageRequestsUtil pageRequestsUtil;

    private final PasswordEncoder passwordEncoder;

    @Value("${users.sort.fields}")
    private List<String> sortFields;

    @Value("${users.filter.fields}")
    private List<String> filterFields;

    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .hashPassword(passwordEncoder.encode(newUser.getPassword()))
                .role(User.Role.USER)
                .state(User.State.NOT_CONFIRMED).build();

        usersRepository.save(user);

        return from(user);
    }


    @Override
    public UsersDto getAllUsers(UsersRequest request) {

        // получаем запрос на страницу с пользователями с помощью класса-утилиты
        PageRequest pageRequest = pageRequestsUtil.getPageRequest(request.getPage(), request.getOrderBy(), request.getDesc(), sortFields);
        // получаем страницу с пользователями на основе запроса на страницу
        Page<User> page = getUsersPage(request.getFilterBy(), request.getFilterValue(), request.getArticles(), pageRequest);
        // формируем результат, который превратиться в JSON
        UsersDto result = UsersDto.builder()
                .count(page.getTotalElements()) // берем количество пользователей в базе
                .pagesCount(page.getTotalPages()) // берем общее количество страниц
                .build();


        result.setUsers(from(page.getContent())); // не берем статьи

        return result;
    }

    private Page<User> getUsersPage(String filterBy, String filterValue, String articles, PageRequest pageRequest) {
        // создаем пустую страницу, если запрос был сформирован не правильно - можем просто вернуть пустую страницу
        Page<User> page = Page.empty();
        if (filterBy == null || filterBy.equals("")) { // если не указали параметр фильтрации
            page = usersRepository.findAll(pageRequest); // пока возвращаем все, что есть
        } else { // если не просили статьи и при этом указали параметры фильтрации
            pageRequestsUtil.checkField(filterFields, filterBy); // проверяем, что по этим полям можно фильтровать
            if (filterBy.equals("role")) { // если хотят получить по роли
                User.Role role = User.Role.valueOf(filterValue); // преобразуем строку в enum
                page = usersRepository.findAllByRole(role, pageRequest); // запрашиваем по роли из репозитория
            } else if (filterBy.equals("state")) { // если хотят получить по состоянию
                User.State state = User.State.valueOf(filterValue); // преобразуем строку в enum
                page = usersRepository.findAllByState(state, pageRequest); // запрашиваем по состоянию из репозитория
            }
        }
        return page; // возвращаем страницу
    }

    @Override
    public UserDto deleteUser(Long userId) {
        User user = getUserOrThrow(userId);

        usersRepository.delete(user);

        return from(user);
    }

    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {

        User user = getUserOrThrow(userId);

        if (updateUser.getNewRole().equals("ADMIN")) {
            throw new ForbiddenUpdateUserOperationException("role", "ADMIN");
        }

        if (updateUser.getNewState().equals("BANNED")) {
            throw new ForbiddenUpdateUserOperationException("state", "BANNED");
        }

        user.setState(User.State.valueOf(updateUser.getNewState()));
        user.setRole(User.Role.valueOf(updateUser.getNewRole()));

        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    @Override
    public TasksDto getTasksOfUser(Long userId) {
        User user = getUserOrThrow(userId);

        return TasksDto.builder()
                .tasks(from(user.getTasks()))
                .count(user.getTasks().size())
                .build();
    }

    private User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User", userId));
    }
}
