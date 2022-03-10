import com.github.jeanadrien.gatling.mqtt.Predef._
import io.gatling.core.Predef._

import scala.concurrent.duration._

class AnotherMqttScenarioExample extends Simulation {

    val mqttConf = mqtt.host("tcp://localhost:1883")

    val scn = scenario("MQTT Test")
        .exec(connect)
        .exec(subscribe("anotherTopic"))
        .during(30 seconds) {
            pace(1 second).exec(publish("anotherTopic", "myPayload"))
        }

    setUp(
        scn.inject(rampUsers(10) over (10 seconds)))
        .protocols(mqttConf)
}
