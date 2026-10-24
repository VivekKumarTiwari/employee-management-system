package com.employee.management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "employees")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(length = 15)
	private String phone;

/*
	@Column
	private String designation;
*/

	@Column
	private Double salary;

	@Column
	private Long departmentId;

	@Column(updatable = false)
	@CreatedDate
	private LocalDateTime createdAt;

	@Column
	@LastModifiedDate
	private LocalDateTime updatedAt;

	/*@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}*/

}
