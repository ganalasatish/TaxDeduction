package com.employee.hr.taxdeduction.model;

import java.util.Objects;

public class TaxDeductionResponse {
	private int employeeid;
	private String firstName;
	private String lastName; 
	private double yearlySalary;
	private double taxAmount;
	private double cessAmount;
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
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
	public double getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cessAmount, employeeid, firstName, lastName, taxAmount, yearlySalary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxDeductionResponse other = (TaxDeductionResponse) obj;
		return Double.doubleToLongBits(cessAmount) == Double.doubleToLongBits(other.cessAmount)
				&& employeeid == other.employeeid && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName)
				&& Double.doubleToLongBits(taxAmount) == Double.doubleToLongBits(other.taxAmount)
				&& Double.doubleToLongBits(yearlySalary) == Double.doubleToLongBits(other.yearlySalary);
	}
	@Override
	public String toString() {
		return "TaxDeductionResponse [employeeid=" + employeeid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", yearlySalary=" + yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}
	
}
