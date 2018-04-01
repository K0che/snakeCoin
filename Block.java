package snakeCoin;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
public class Block {

	public  int index;
	public  String timestamp;
	public  String data;
	public  String previous_hash;
	public  String hash;
	
	public Block (int index, String timestamp, String data, String previous_hash) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		this.index=index;
		this.timestamp=timestamp;
		this.data= data;
		this.previous_hash=previous_hash;
		this.hash=createHash(this.index,this.timestamp, this.data, this.previous_hash);	
	}

public Block() throws UnsupportedEncodingException, NoSuchAlgorithmException {
	
	createGenesisBlock();
	}

private String createHash(int index, String timestamp, String data, String previous_hash) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest((String.valueOf(index)+timestamp+data+previous_hash).getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
		return String.valueOf(encoded);	
}

public  Block nextBlock(Block last_block) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	Block next = new Block(last_block.index+1, new Date().toString(), ("Hey i'm block "+(last_block.index+1)), last_block.hash);
	  return next;
}
public  Block createGenesisBlock() throws UnsupportedEncodingException, NoSuchAlgorithmException {
	 Block  genesis = new Block(0,  new Date().toString(),"this is block 0","0");
	 System.out.println(new Date().toString());
	 return genesis;
}
}

