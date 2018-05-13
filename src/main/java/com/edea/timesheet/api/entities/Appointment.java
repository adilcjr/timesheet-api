package com.edea.timesheet.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.edea.timesheet.api.enums.TypeEnum;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {

	private static final long serialVersionUID = -5869132199030125995L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "appointment_date", nullable = false)
	private Date appointmentDate;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "location", nullable = false)
	private String location;

	@Column(name = "creation_date", nullable = false)
	private Date creationDate;

	@Column(name = "update_date", nullable = false)
	private Date updateDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TypeEnum type;

	@ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;

	public Appointment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@PreUpdate
	public void preUpdate() {
		creationDate = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date now = new Date();
		creationDate = now;
		updateDate = now;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentDate=" + appointmentDate + ", description=" + description
				+ ", location=" + location + ", creationDate=" + creationDate + ", updateDate=" + updateDate + ", type="
				+ type + ", employee=" + employee + "]";
	}
}
