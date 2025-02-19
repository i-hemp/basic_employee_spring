package com.example.demo.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "EMPLOYEEID")
	public Long   employeeId;
	@Column(name = "EMPLOYEENAME")
	public String employeeName;
	@Column(name = "EMPLOYEEADDRESS")
	public String employeeAddress;
	@Column(name = "EMPLOYEESALARY")
	public Long employeeSalary;
    
}
