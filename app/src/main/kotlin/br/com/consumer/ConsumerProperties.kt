package consumer

open class ConsumerProperties(private val idClass: String, val deserializerClass: String) {

    private val properties = mutableMapOf<String, String>()

    open fun createProperties(): MutableMap<String, String> {
        properties["key.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer";
        properties["value.deserializer"] = deserializerClass
        properties["bootstrap.servers"] = "127.0.0.1:9092";
        properties["max.poll.records"] = "1";
        properties["group.id"] = idClass;
        return properties;
    }

}