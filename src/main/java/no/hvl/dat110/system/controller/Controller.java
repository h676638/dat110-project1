package no.hvl.dat110.system.controller;

import java.io.IOException;
import java.net.UnknownHostException;

import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCClientStopStub;

public class Controller  {
	
	private static int N = 5;
	
	public static void main (String[] args) throws UnknownHostException, IOException  {
		
		DisplayStub display;
		SensorStub sensor;
		
		RPCClient displayclient,sensorclient;
		
		System.out.println("Controller starting ...");
				
		// create RPC clients for the system
		displayclient = new RPCClient(Common.DISPLAYHOST,Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST,Common.SENSORPORT);
		
		// setup stop methods in the RPC middleware
		RPCClientStopStub stopdisplay = new RPCClientStopStub(displayclient);
		RPCClientStopStub stopsensor = new RPCClientStopStub(sensorclient);
				
		// create local display and sensor stub objects
		// connect to sensor and display RPC servers
		// read value from sensor using RPC and write to display using RPC
		displayclient.connect();
		sensorclient.connect();
		display = new DisplayStub(displayclient);
		sensor = new SensorStub(sensorclient);
		for (int i = 1; i <= 10; i++) {
			display.write(Integer.toString(sensor.read()));
		}
		
		stopdisplay.stop();
		stopsensor.stop();
	
		displayclient.disconnect();
		sensorclient.disconnect();
		
		System.out.println("Controller stopping ...");
		
	}
}
