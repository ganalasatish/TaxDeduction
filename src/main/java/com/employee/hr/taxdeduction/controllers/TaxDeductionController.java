package com.employee.hr.taxdeduction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.hr.taxdeduction.model.TaxDeductionRequest;
import com.employee.hr.taxdeduction.model.TaxDeductionResponse;
import com.employee.hr.taxdeduction.service.TaxDeductionSevice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/taxdeduction")
public class TaxDeductionController {

	@Autowired
	private TaxDeductionSevice deductionSevice;
	
	@GetMapping("/getTaxDeduction")
	public TaxDeductionResponse getTaxDeduction(@Valid TaxDeductionRequest deductionRequest) {
		
		return deductionSevice.calaculateTaxDeduction(deductionRequest);
	}
}
