package de.ait.task.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ait.task.dto.NewTaskDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("ArticlesController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
class TasksIntegrationTest {

    private static final NewTaskDto NEW_ARTICLE = NewTaskDto.builder()
            .title("Test Title")
            .description("Description Test")
            .executorUserId(1L)
            .startDate("2022-02-02")
            .finishDate("2022-02-03")
            .build();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("POST /api/articles is works: ")
    class AddArticleTest {

        @Test
        @Sql(scripts = "/sql/data_for_tasks.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void add_task_for_exist_user() throws Exception {

            String body = objectMapper.writeValueAsString(NEW_ARTICLE);

            mockMvc.perform(post("/api/tasks")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.title", is("Test Title")))
                    .andExpect(jsonPath("$.description", is("Description Test")))
                    .andExpect(jsonPath("$.startDate", is("2022-02-02")))
                    .andExpect(jsonPath("$.finishDate", is("2022-02-03")))
                    .andExpect(jsonPath("$.executor.id", is(1)))
                    .andExpect(jsonPath("$.executor.email", is("test@mail.com")));
        }

        @Test
        public void add_task_for_not_exist_user() throws Exception {
            String body = objectMapper.writeValueAsString(NEW_ARTICLE);

            mockMvc.perform(post("/api/tasks")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isUnprocessableEntity());
        }
    }
}