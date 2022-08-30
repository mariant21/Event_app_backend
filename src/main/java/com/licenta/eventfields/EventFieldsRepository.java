package com.licenta.eventfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventFieldsRepository extends JpaRepository<EventFields,   Long > {
}
