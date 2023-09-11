package de.ait.timepad.repositories;

import de.ait.timepad.models.Article;
import de.ait.timepad.models.Event;

import java.util.List;

public interface EventsRepository extends CrudRepository<Event> {

    // TODO: убрать метод, как только подключим базы данных
    void clear();
}
