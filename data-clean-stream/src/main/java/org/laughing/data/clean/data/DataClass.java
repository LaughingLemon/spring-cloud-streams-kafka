package org.laughing.data.clean.data;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class DataClass {
    @CsvBindByPosition(position = 0)
    private String name;
}
