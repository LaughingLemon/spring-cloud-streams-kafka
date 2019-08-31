# Demo of Spring Clould Streams with Kafka Binder

Straighforward demo of using Spring Cloud Streams

Notable features:
1. Uses Class specific Serde to convert outgoing object into JSON string.
2. Uses Embedded Kafka for integration testing
3. While the streams Kafka binder requires "spring.cloud.stream.kafka.binder.brokers" to be set to the broker URL, the Embedded Kafka broker has to have "spring.kafka.bootstrap-servers" also to be set. 
