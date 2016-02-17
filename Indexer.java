
import java.io.BufferedInputStream;

import java.io.FileInputStream;

import java.io.IOException;



public class Indexer {

	/*
	 * tree to store words and count each time
	 */
	private static IndexerTree tree;
	
	/*
	 * map that store the final result;
	 */
	private static NodeArray result;
	
	public static void main(String args[]) throws IOException{
		
		tree = new IndexerTree();
		
		FileInputStream file = new FileInputStream(args[0]);
		BufferedInputStream buff = new BufferedInputStream(file);
		
		//start reading file
		int next = buff.read();
		while(next!=-1){
			//start from root node
			TreeNode cur_node = tree.getRoot();
			//skip invalid characters
			while(next != -1 && !isValid(next)){
				next = buff.read();
			}
			//not end of file
			if(next != -1){
				boolean loop = true;
				while(loop){
					char letter = (char)next;
					next = buff.read();
					//continue adding to child if next is still same word
					if(next == -1 || !isValid(next))
						loop = false;
					//add new node to children
					int count;
					if(loop) //is not last char of a word
						count = 0;
					else //last
						count = 1;
					TreeNode nextChild = cur_node.getchild(Character.toLowerCase(letter));
					if(nextChild == null){//the letter does not exit yet; add new child
						TreeNode child = new TreeNode(Character.toLowerCase(letter), cur_node, count);
						cur_node.setChild(child);
						cur_node = child;
					}else if(count ==1){//child exist and end of the word; increment count of word
						nextChild.count();
						cur_node = nextChild;
					}else // child exist but not end of the word yet, keep reading
						cur_node = nextChild;
				}
			}
		}
		buff.close();
		
		//make a list of treenode and sort from 1st to last
		result = tree.makeList();
		result.sort();
		
		//print out result
		int i = 0;
		while(i < 10 && i < result.size()){
			System.out.println(i+1 + ": " + recursive_print(result.get(i), i, 1));
			i++;
		}
		
	}

	

	/*
	*helper method to check is the char value is a valid character or not
	*/
	private static boolean isValid(int next) {
		if(next >= 48 && next<= 57) //is number
			return true;
		if(next>=65 && next <= 90) // A-Z
			return true;
		if(next >= 97 && next <=122) //a-z
			return true;
		
		return false;
	}



	/*
	* helper method to recursively track each node and get result string to print out
	*/
	private static String recursive_print(TreeNode cur_node, int i, int doPrint) {
		
		String result = "";
		if(cur_node.getParent() != null){
			result = recursive_print(cur_node.getParent(), i, 0);
		}
		
		result += cur_node.getLetter();
		return result;
		
	}



	
	
	
	
	
	
}
