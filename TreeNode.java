import java.util.ArrayList;

/*
* original tree node class that is comparable according to it's count
*
*/
public class TreeNode implements Comparable<TreeNode> {

	/*
	 * char value that represents the letter of the node
	 */
	private int letter;
	
	/*
	 * own array list of tree node that store children for each node, which contains a-z abd 0-9
	 */
 	private NodeArray children;
 	
 	
 	/*
 	 * parent node 
 	 */
 	private TreeNode parent;
 	 
 	 /*
 	  * variable that count how many times the word appear in the text
 	  */
 	 int count;
 	 public TreeNode(){
 		 letter = ' ';
 		 count = 0;
 		 children = new NodeArray();
 	 }
 	 
 	 public TreeNode(int letter, TreeNode parent, int count){
 		 this.letter = letter;
 		 this.count = count;
 		 children = new NodeArray();
 		 this.parent = parent;
 	 }
 	 
 	 
 	 public char getLetter(){
 		 return (char)letter;
 	 }
 	 
 	 /*
 	 * get a child node using the matching char value
 	 */
 	 public TreeNode getchild(char letter){
 		 return children.getNode(letter);
 	 }
 	 
 	 /*
 	 * add a new node to child array in appropriate way
 	 */
 	 public boolean setChild(TreeNode newNod){
 		 return children.add(newNod);
 	 }
 	 
 	 /*
 	 * increment count value of the node
 	 */
 	 public int count(){
 		 count++;
 		 return count;
 	 }
 	 
 	 public int getCount(){
 		 return count;
 	 }
 	 
 	 public TreeNode getParent(){
 		 return parent;
 	 }
 	 
 	 /*
 	 * get the node array of children
 	 */
 	 public NodeArray getChildren(){
 		 return children;
 	 }

	/*
	* make the tree node comparable by it's count value
	*/
	@Override
	public int compareTo(TreeNode o) {
		return o.count-this.count;
	}
	
}
