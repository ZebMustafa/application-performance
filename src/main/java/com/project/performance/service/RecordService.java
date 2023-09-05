package com.project.performance.service;

import java.util.List;

import com.project.performance.domain.Code;

public interface RecordService {
	List<Code> insert(int numberOfRows);

	boolean isNumeric(String value);
}
