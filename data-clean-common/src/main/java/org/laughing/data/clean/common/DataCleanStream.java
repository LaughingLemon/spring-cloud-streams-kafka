package org.laughing.data.clean.common;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@Slf4j
public class DataCleanStream<T> {

    @Setter
    private DataVerifier<T> verifier;
    @Setter
    private Class<T> dataTypeClass;

    @StreamListener("input")
    @SendTo("output")
    public KStream<String, T> handle(KStream<String, String> inStream){
        return inStream.mapValues(this::createBean).filter((k, v) -> v != null);
    }

    private T createBean(final String csvText) {
        try (final StringReader reader = new StringReader(csvText);
             final CSVReader csvReader = new CSVReader(reader)) {
            final List<T> dataClassList = new CsvToBeanBuilder(csvReader)
                    .withType(dataTypeClass).withVerifier(verifier).build().parse();
            return (T) dataClassList.stream().findAny().orElse(null);
        } catch (IOException e) {
            log.error("Unable to create %s object from csv %s", dataTypeClass.getName(), csvText);
            return null;
        }
    }

}
