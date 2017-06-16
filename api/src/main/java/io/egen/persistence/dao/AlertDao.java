package io.egen.persistence.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.egen.persistence.model.Alert;
import io.egen.persistence.model.Vehicle;

public interface AlertDao extends JpaRepository<Alert, Long> {

	@Query("select a from Alert a where a.priority = :priority and a.timestamp between :lessThan2hrsDate and :currentTimeStamp")
	List<Alert> findByPriorityLessThan2Hrs(@Param("priority")String priority,@Param("lessThan2hrsDate")Timestamp lessThan2hrsDate,@Param("currentTimeStamp")Timestamp currentTimeStamp);

	List<Alert> findByPriority(String priority);

	List<Alert> findByVin(Vehicle vehicle);
}
