package com.employee.hr.taxdeduction.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TaxDeductionRequest {
	@NotNull(message = "employeeID cannot be 0")
	@Range(min = 1)
	private int employeeID;

	@NotBlank(message = "firstName cannot be empty")
	private String firstName;

	@NotBlank(message = "lastName cannot be empty")
	private String lastName;

	@Email(message = "Email is not valid", regexp="[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}")
	@NotNull(message = "Email cannot be empty")
	private String email;
	@NotEmpty(message = "phoneNumber cannot be empty")
	private List<String> phoneNumber;

	@NotNull(message = "Invalid date formate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date doj;

	@NotNull(message = "salary cannot be empty")
	@Range(min = 1000)
	private double Salary;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Salary, doj, email, employeeID, firstName, lastName, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxDeductionRequest other = (TaxDeductionRequest) obj;
		return Double.doubleToLongBits(Salary) == Double.doubleToLongBits(other.Salary)
				&& Objects.equals(doj, other.doj) && Objects.equals(email, other.email)
				&& employeeID == other.employeeID && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "TaxDeductionRequest [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", dOJ=" + doj + ", Salary=" + Salary + "]";
	}
	
	
}
