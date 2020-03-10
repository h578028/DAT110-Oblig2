package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to

		// - connect to the broker
		// - publish the temperature(s)
		// - disconnect from the broker

		Client client = new Client("temperature device", Common.BROKERHOST, Common.BROKERPORT);
		
		System.out.println("Connecting");
		while(!client.connect()) {
			System.out.println("Reatempting to connect");
		}
		
		for(int i = 0; i < COUNT; i++) {
			client.publish(Common.TEMPTOPIC, "Temperature: " + sn.read());
		}
		
		client.disconnect();
		
		// TODO - end

		System.out.println("Temperature device stopping ... ");

	}
}
