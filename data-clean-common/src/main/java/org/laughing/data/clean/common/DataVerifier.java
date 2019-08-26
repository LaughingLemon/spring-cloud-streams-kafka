package org.laughing.data.clean.common;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;

public abstract class DataVerifier<T> implements BeanVerifier<T> {
    @Override
    public abstract boolean verifyBean(final T dataClass) throws CsvConstraintViolationException;
}
