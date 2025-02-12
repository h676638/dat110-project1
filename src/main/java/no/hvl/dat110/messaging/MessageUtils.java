package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;
	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";


	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		// TODO - START
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer
		byte messageLength = (byte)message.getData().length;
		segment = new byte[128];
		segment[0] = messageLength;
		System.arraycopy(message.getData(), 0, segment, 1, messageLength);
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		byte[] newSegment;
		
		// TODO - START
		// decapsulate segment and put received payload data into a message
		int segmentLength = segment[0];
		newSegment = new byte[segment[0]];
		System.arraycopy(segment, 1, newSegment, 0, segmentLength);
		message = new Message(newSegment);
		// TODO - END
		
		return message;
		
	}
	
}
