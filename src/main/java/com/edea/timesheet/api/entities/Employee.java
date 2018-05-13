package com.edea.timesheet.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.edea.timesheet.api.enums.ProfileEnum;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -9156970455457675357L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "time_value", nullable = false)
	private BigDecimal timeValue;

	@Column(name = "working_time", nullable = false)
	private Float workingTime;

	@Column(name = "lunch_time", nullable = false)
	private Float lunchTime;

	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	private ProfileEnum profile;

	@Column(name = "creation_date", nullable = false)
	private Date creationDate;

	@Column(name = "update_date", nullable = false)
	private Date updateDate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Appointment> appointments;

	public Employee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getTimeValue() {
		return timeValue;
	}

	@Transient
	public Optional<BigDecimal> getTimeValueOptional() {
		return Optional.ofNullable(timeValue);
	}

	public void setTimeValue(BigDecimal timeValue) {
		this.timeValue = timeValue;
	}

	public Float getWorkingTime() {
		return workingTime;
	}

	@Transient
	public Optional<Float> getWorkingTimeOptional() {
		return Optional.ofNullable(workingTime);
	}

	public void setWorkingTime(Float workingTime) {
		this.workingTime = workingTime;
	}

	public Float getLunchTime() {
		return lunchTime;
	}

	@Transient
	public Optional<Float> getLunchTimeOptional() {
		return Optional.ofNullable(lunchTime);
	}

	public void setLunchTime(Float lunchTime) {
		this.lunchTime = lunchTime;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
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
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", timeValue=" + timeValue + ", workingTime=" + workingTime + ", launchTime=" + lunchTime
				+ ", profile=" + profile + ", creationDate=" + creationDate + ", updateDate=" + updateDate
				+ ", company=" + company + "]";
	}

}
