package com.project.performance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.performance.domain.Code;
import com.project.performance.repository.CodeRepository;

@Service
public class RecordserviceImp implements RecordService {
	@Autowired
	private CodeRepository codeRepository;

	@Override
	@Transactional
	public List<Code> insert(int numberOfRows) {
		List<Code> sourceCodeList = buildAllCodesBasedOnNumberOfRecord(numberOfRows);
		boolean listHaveUniqueCodes =   isAllCodesAreUniqueInList(sourceCodeList);
		System.out.println("Is list have all unique codes ? " +listHaveUniqueCodes);
		if(listHaveUniqueCodes) {
			return codeRepository.saveAll(sourceCodeList);
		}
		System.out.println("List is not unique, so unable to insert the record.");
		return new ArrayList<>();
	}

	@Override
	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	private List<Code> buildAllCodesBasedOnNumberOfRecord(int numberOfRows) {
		List<Code> sourceCodeList = IntStream.range(0, numberOfRows).mapToObj(code -> new Code(UUID.randomUUID())).toList();
		System.out.println("Is list have all unique codes ? " + isAllCodesAreUniqueInList(sourceCodeList));
		return sourceCodeList;
	}

	private boolean isAllCodesAreUniqueInList(List<Code> list) {
		long uniqueRecords = list.stream().distinct().count();
		System.out.println("Unique Records: " + uniqueRecords);
		System.out.println("Total Records" + list.size());
		return uniqueRecords == list.size();
	}

	
}
