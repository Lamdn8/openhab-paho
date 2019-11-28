import data_input.CsvReader;
import openhab_mqtt_client.OpenhabClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttSubscribe;

public class Main {
    public static void main(String[] args) {
//        csvReaderTest();
        openhabClientTest();
    }

    private static void csvReaderTest(){
        CsvReader data = new CsvReader();
        data.readDataByLine("/home/lamdao/Documents/iot/debs40houses16h/house-0.csv");
    }

    private static void openhabClientTest(){
        try{
//            OpenhabClient client = new OpenhabClient("tcp://168.0.0.10:5007",
//                    "mqtt:topic:1a287dd1:a1",
//                    "javasample");
            OpenhabClient client = new OpenhabClient("tcp://test.mosquitto.org:1883",
                    "openhab",
                    "mypasswd");

            client.publishMessage("this is data");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
