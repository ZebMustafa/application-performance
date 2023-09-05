package com.project.performance.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.performance.domain.Code;
import com.project.performance.service.RecordService;

@RestController
@RequestMapping(value = "/application/performance")
public class RecordController {

	@Autowired
	private RecordService recordService;

	@PostMapping(value = "/insertion")
	public List<Code> insertRecords(@RequestParam String noOfRec) {
		if(!recordService.isNumeric(noOfRec)) {
			System.out.println("The value should be Integer in request parameter (noOfRec).");
			return new ArrayList<>();
		}
		List<Code> resourceCodeList = recordService.insert(Integer.parseInt(noOfRec));
		return resourceCodeList;
	}
}
