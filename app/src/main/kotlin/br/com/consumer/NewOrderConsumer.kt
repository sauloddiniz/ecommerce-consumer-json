package consumer

import org.apache.kafka.clients.consumer.KafkaConsumer
import to.Order
import java.time.Duration
import java.util.Collections

class NewOrderConsumer {

    private val topic = "ECOMMERCE_NEW_ORDER";
    private val deserializerClass: String = "deserializers.OrderDeserializer";

    fun createConsumer() {
        val properties = ConsumerProperties(
            NewOrderConsumer::class.java.simpleName,
            deserializerClass
        ).createProperties();
        val consumer: KafkaConsumer<String, Order> = KafkaConsumer<String, Order>(properties as Map<String, Any>?);
        consumer.subscribe(Collections.singletonList(topic));

        while (true) {
            var records = consumer.poll(Duration.ofMillis(100))
            if (!records.isEmpty) {
                for (record in records) {
                    println("item : ${record.value()}")
                    Thread.sleep(2000);
                }
            }
        }
    }

}