package de.ait.task.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Users request")
public class UsersRequest {
    @Parameter(description = "Page number", example = "1")
    private Integer page;
    @Parameter(description = "The field by which we want to sort. Available: email, role, state, id")
    private String orderBy;
    @Parameter(description = "Set to true if you want to sort in reverse order")
    private Boolean desc;
    private String filterBy;
    private String filterValue;
    private String articles;
}
