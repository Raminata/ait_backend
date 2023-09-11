package de.ait.task.utils;

import de.ait.task.exceptions.ForbiddenFieldException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PageRequestsUtil {

    @Value("${global.page.size}")
    private Integer pageSize;


    public PageRequest getPageRequest(Integer pageNumber, String orderByField, Boolean desc, List<String> sortFields) {

        if (orderByField != null && !orderByField.equals("")) { // проверяем, задал ли клиент поле для сортировки?

            // sortFields мы берем из application.properties
            checkField(sortFields, orderByField); // проверяем, доступно ли нам поле для сортировки в sortFields

            Sort.Direction direction = Sort.Direction.ASC; // предполагаем, что сортировка будет в прямом порядке

            if (desc != null && desc) { // если клиент задал сортировку в обратном порядке
                direction = Sort.Direction.DESC; // задаем обратный порядок сортировки
            }

            Sort sort = Sort.by(direction, orderByField); // создаем объект для сортировки направление + поле

            return PageRequest.of(pageNumber, pageSize, sort); // создаем запрос на получение страницы пользователей с сортировкой
        } else {
            // если клиент не указал в запросе данные для сортировки - то создаем "запрос по умолчанию"
            return getDefaultPageRequest(pageNumber);
        }
    }


    public void checkField(List<String> allowedFields, String field) {
        if (!allowedFields.contains(field)) {
            throw new ForbiddenFieldException(field);
        }
    }


    public PageRequest getDefaultPageRequest(Integer pageNumber) {
        // если запрашиваем страницу по умолчанию, то будем использовать сортировку в прямом порядке по id
        return PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
    }
}