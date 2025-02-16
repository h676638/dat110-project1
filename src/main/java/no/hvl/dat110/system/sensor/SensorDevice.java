package no.hvl.dat110.system.sensor;

import java.io.IOException;
import java.net.UnknownHostException;

import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;

public class SensorDevice {

	public static void main(String[] args) throws UnknownHostException, IOException {

		System.out.println("Sensor server starting ...");
		
		RPCServer sensorserver = new RPCServer(Common.SENSORPORT);

		SensorImpl sensor = new SensorImpl((byte)Common.READ_RPCID,sensorserver);
		
		sensorserver.run();
		
		sensorserver.stop();
		
		System.out.println("Sensor server stopping ...");
		
	}
}
