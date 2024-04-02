package com.employee.hr.taxdeduction.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.employee.hr.taxdeduction.model.TaxDeductionRequest;
import com.employee.hr.taxdeduction.model.TaxDeductionResponse;

@Service
public class TaxDeductionSevice {

	public TaxDeductionResponse calaculateTaxDeduction(TaxDeductionRequest deductionRequest) {
		TaxDeductionResponse deductionResponse=new TaxDeductionResponse();
		deductionResponse.setEmployeeid(deductionRequest.getEmployeeID());
		deductionResponse.setFirstName(deductionRequest.getFirstName());
		deductionResponse.setLastName(deductionRequest.getLastName());
		double yearlySalary=calculateYearSalary(deductionRequest.getDoj(), deductionRequest.getSalary());
		deductionResponse.setYearlySalary(yearlySalary);
		double totalTax=calculateTax(yearlySalary);
		deductionResponse.setTaxAmount(totalTax);
		double cessAmount=calculateCess(yearlySalary);
		deductionResponse.setCessAmount(cessAmount);		
		return deductionResponse;
	}
	
	private double calculateCess(double salaryForYear) {
		if(salaryForYear<=2500000) 
			return 0;
		else
			return ((salaryForYear-2500000)/100)*2;
	}
	
	private double calculateTax(double salaryForYear) {
		if(salaryForYear<=250000)
			return 0;
		
		salaryForYear=salaryForYear-250000;
		if(salaryForYear<=250000)
			return (salaryForYear/100)*5;
		double totalTax=(250000/100)*5;
		salaryForYear=salaryForYear-250000;
		if(salaryForYear<=500000)
			return totalTax+((salaryForYear/100)*10);
		totalTax+=((500000/100)*10);
		salaryForYear=salaryForYear-500000;
		totalTax+=((salaryForYear/100)*20);
		return totalTax;
		
	}
	
	private double calculateYearSalary(Date doj,double salaryForMon) {
		int currentYear=new Date().getYear();
		int dojYear=doj.getYear();
		int dojMonth=doj.getMonth();
		if(dojYear<(currentYear-1) || (dojYear==(currentYear-1) && dojMonth<4)) {
			return 12*salaryForMon;
		}else {
			int months;
			int days=0;
			int dojDay=doj.getDate();
			if(dojYear==(currentYear-1))
				months=11-dojMonth+3;
			else
				months=2-dojMonth;
				if(dojDay==1)
					months+=1;
				else
					days=31-dojDay;
			
			return (months*salaryForMon)+(days*(salaryForMon/30));
		}		
	}
}
