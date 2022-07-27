package deserializers

import com.fasterxml.jackson.databind.json.JsonMapper
import org.apache.kafka.common.serialization.Deserializer
import to.Order

class OrderDeserializer() : Deserializer<Order> {

    val jsonMapper: JsonMapper = JsonMapper();

    override fun deserialize(topic: String?, data: ByteArray?): Order {
        return jsonMapper.readValue(data, Order::class.java);
    }

    override fun close() {}

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {}
}