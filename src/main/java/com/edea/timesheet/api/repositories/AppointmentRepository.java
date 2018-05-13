package com.edea.timesheet.api.repositories;

import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.edea.timesheet.api.entities.Appointment;

@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "AppointmentRepository.findByEmployeeId", 
				query = "SELECT apt FROM Appointment apt WHERE apt.employee.id = :employeeId") })
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByEmployeeId(@Param("employeeId") Long employeeId);

	Page<Appointment> findByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);
}
