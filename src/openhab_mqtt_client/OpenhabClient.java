package openhab_mqtt_client;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class OpenhabClient {
    private MqttClient client;
    private MqttConnectOptions mqttConnectOptions;
    private String topic = "topic1";
    private String url;
    private String clientId;
    private String username;
    private String password;
    private int qos = 1;
    private boolean retain = true;
    private boolean async = false;

    public OpenhabClient (String url, String username, String password) throws MqttException {
        this.url = url;
        this.username = username;
        this.password = password;
        this.client = new MqttClient(this.url, MqttClient.generateClientId());
        this.connectionStart();
    }

    private static MqttConnectOptions setMqttConnectOptions(String username, String password){
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
//        connOpts.setUserName(username);
//        connOpts.setPassword(password.toCharArray());
        return connOpts;
    }

    private void connectionStart() throws MqttException {
        this.mqttConnectOptions = setMqttConnectOptions(this.username, this.password);

        System.out.println("Connecting to broker: "+ this.url);
        this.client.connect(this.mqttConnectOptions);
        System.out.println("Connected");
    }

    public void publishMessage(String data) throws MqttException {
        System.out.println("Publishing message: " + data);
        MqttMessage message = new MqttMessage(data.getBytes());
        message.setQos(2);
        this.client.publish(this.topic, message);
    }

    public void closeConnection() throws MqttException {
        this.client.disconnect();
    }
}
