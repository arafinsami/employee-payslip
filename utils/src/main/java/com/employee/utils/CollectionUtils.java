package com.employee.utils;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils<T> {

	public static <T> List<T> nullSafe(List<T> c) {
		return isNull(c) ? new ArrayList<>() : c;
	}
}
