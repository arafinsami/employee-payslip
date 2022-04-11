package com.employee.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	protected Date createdAt;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_AT")
	protected Date updatedAt;

	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedAt = new Date();
	}
}