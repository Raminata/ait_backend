package de.ait.tracker.repositories;

import de.ait.tracker.models.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class EventRepositoryJdbcTemplateImpl implements EventRepository {
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from event;";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Event> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, (row, rowNumber) -> Event.builder()
                .id(row.getLong("id"))
                .title(row.getString("title"))
                .description(row.getString("description"))
                .build());
    }
}
