import java.util.ArrayList;
import java.util.HashMap;

/*
* original tree class that stores root node and array of nodes to store nodes that represent words
*
*/

public class IndexerTree {

	/*
	 * root of the tree; the treenode does not actually represent any letter
	 */
	private TreeNode root;
	
	
	/*
	 * array to store nodes that represent words
	 */
	private NodeArray result;
	
	/*
	 * size of the tree
	 */
	int size;
	
	
	public IndexerTree(){
		root = new TreeNode(' ',null, 0);
		size = 0;
		result = new NodeArray();
	}
	
	public TreeNode getRoot(){
		return root;
	}
	
	
	/*
	* method to add all nodes that represent words to result array
	*/
	public NodeArray makeList(){
		recursion(root);
		return result;
	}

	/*
	* helper recursion method to track all nodes of tree and find nodes that represen words
	*/
	private void recursion(TreeNode cur_node) {
		
		if(cur_node.getCount() >0){
			//find a word, add to map			
			result.addNode(cur_node);
		}
		
		NodeArray children = cur_node.getChildren();
		//recursive call
		if(children != null){
			for(int i = 0; i < children.size();i++){
				recursion(children.get(i));
			}
		}
		
	}

	
}
