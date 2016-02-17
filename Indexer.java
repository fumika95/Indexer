
import java.io.BufferedInputStream;

import java.io.FileInputStream;

import java.io.IOException;


/*
* main of the program that takes file name fromm commanline and run the program to get output
*/
public class Indexer {

	/*
	 * tree to store words and count each time
	 */
	private static IndexerTree tree;
	
	/*
	 * array of node that store the final result;
	 */
	private static NodeArray result;
	
	public static void main(String args[]) throws IOException{
		
		tree = new IndexerTree();
		
		FileInputStream file = new FileInputStream(args[0]);
		BufferedInputStream buff = new BufferedInputStream(file);
		int next = buff.read();
		
		while(next!=-1){
			//start from root node
			TreeNode cur_node = tree.getRoot();
			//skip invalid characters
			while(next != -1 && !isValid(next)){
				next = buff.read();
			}
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
				//
				//
				//System.out.println(letter + " " + (char)next + " " + loop);
				TreeNode nextChild = cur_node.getchild(Character.toLowerCase(letter));
				if(nextChild == null){
					TreeNode child = new TreeNode(Character.toLowerCase(letter), cur_node, count);
					cur_node.setChild(child);
					cur_node = child;
				}else if(count ==1){
					nextChild.count();
					cur_node = nextChild;
				}else
					cur_node = nextChild;
			}
			}
		}
		buff.close()
		
		result = tree.makeList();
		result.sort();
		
		
		//test1  correct output
		String[] answer= {"i", "eat", "eggs", "and", "potatos", "bananas", "apples", "peaches", "watermelons", "cookies"};
		int i = 0;
		int correct = 0;
		while(i < 10 && i < result.size()){
			String user = recursive_print(result.get(i));
			if(answer[i].equals(user)){
				correct++;
			}else{
				System.out.println("failed correct output  correct:" + answer[i] + " yours: " + user);
			}
			i++;
		}
		
		if(correct == i){
			System.out.println("passed correct output");
			for(int j = 0; j < 10 ; j++)
				System.out.println(j+1 + ":  " + answer[j]);
		}
		
	}

	

	



	private static boolean isValid(int next) {
		if(next >= 48 && next<= 57) //is number
			return true;
		if(next>=65 && next <= 90) // A-Z
			return true;
		if(next >= 97 && next <=122) //a-z
			return true;
		
		return false;
	}



	private static String recursive_print(TreeNode cur_node) {
		
		String result = "";
		if(cur_node.getParent() != null){
			result = recursive_print(cur_node.getParent());
			result += cur_node.getLetter();
		}
		
		
		return result;
		
	}



	
	
	
	
	
	
}
