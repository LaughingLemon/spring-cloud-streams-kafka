# Demo of Spring Clould Streams with Kafka Binder

Straighforward demo of using Spring Cloud Streams

Notable features:
1. Uses Class specific Serde to convert outgoing object into JSON string.
2. Uses Embedded Kafka for integration testing

Note: Versions earlier than 2.2.0/Hoxton seem to have a problem with binding clients to Embedded Kafka
