package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		rpcmsg = new byte[payload.length + 1];
		rpcmsg[0] = rpcid;
		System.arraycopy(payload, 0, rpcmsg, 1, payload.length);
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		payload = new byte[rpcmsg.length-1];
		System.arraycopy(rpcmsg, 1, payload, 0, payload.length);
		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START
		char[] charArr = str.toCharArray();
		ByteBuffer byteBuffer = ByteBuffer.allocate(charArr.length*2);
		for (char each: charArr) {
			byteBuffer.putChar(each);
		}
		encoded = byteBuffer.array();
		// TODO - END
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		// TODO - START 
		decoded = "";
		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
		for (int i = 0; i<data.length; i+=2) {
			decoded += byteBuffer.getChar();
		}
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		// TODO - START 
		
		encoded = new byte[0];
		// TODO - END
		
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		
		return;
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		// TODO - START 
		encoded = new byte[4];
		encoded[0] = (byte)(x >> 24);
		encoded[1] = (byte)(x >> 16);
		encoded[2] = (byte)(x >> 8);
		encoded[3] = (byte)x;
		// TODO - END
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		// TODO - START 
		
		decoded =
				(data[0] & 0xFF) << 24 |
				(data[1] & 0xFF) << 16 |
				(data[2] & 0xFF) << 8 |
				data[3] & 0xFF;
		// TODO - END
		
		return decoded;
		
	}
}
