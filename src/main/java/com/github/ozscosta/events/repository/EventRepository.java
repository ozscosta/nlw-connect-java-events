package com.github.ozscosta.events.repository;

import com.github.ozscosta.events.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByPrettyName(String prettyName);
}
