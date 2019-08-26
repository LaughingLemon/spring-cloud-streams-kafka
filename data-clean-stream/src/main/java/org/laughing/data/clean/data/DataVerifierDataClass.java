package org.laughing.data.clean.data;

import com.opencsv.exceptions.CsvConstraintViolationException;
import org.laughing.data.clean.common.DataVerifier;

public class DataVerifierDataClass extends DataVerifier<DataClass> {
    @Override
    public boolean verifyBean(final DataClass dataClass) throws CsvConstraintViolationException {
        return !dataClass.getName().isEmpty();
    }
}
