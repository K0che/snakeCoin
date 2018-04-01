package snakeCoin;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.LinkedList;
import snakeCoin.Block;
public class Blockchain {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	
	LinkedList blockChain = new LinkedList();
	Block blockToAdd = new Block();
	blockChain.add(blockToAdd);
	Block previousBlock = (Block) blockChain.get(0);
	int numOfBlocksToAdd=20;
	for (int i = 0; i < numOfBlocksToAdd; i++)
		{
		blockToAdd    = previousBlock.nextBlock(previousBlock);
		blockChain.add(blockToAdd);
		previousBlock = blockToAdd;
		System.out.println("Block "+blockToAdd.index+" has been added to the blockchain!");
		System.out.println("Hash: "+blockToAdd.hash+"\n");
		}
	
	}
	
}
