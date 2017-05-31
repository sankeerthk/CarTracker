package io.egen.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import io.egen.persistence.model.Alert;

public interface AlertDao extends CrudRepository<Alert, Long> {

}
