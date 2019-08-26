package org.laughing.data.clean.data;

import org.laughing.data.clean.common.DataCleanStream;
import org.laughing.data.clean.common.DataVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsProcessor;
import org.springframework.context.annotation.Bean;

@EnableBinding(KafkaStreamsProcessor.class)
public class DataCleanStreamDataClass extends DataCleanStream<DataClass> {

    @Autowired
    public void setupClass(DataVerifier<DataClass> verifier) {
        this.setVerifier(verifier);
        this.setDataTypeClass(DataClass.class);
    }

    @Bean
    public DataVerifier<DataClass> createVerifier() {
        return new DataVerifierDataClass();
    }

}
