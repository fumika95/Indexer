import java.util.ArrayList;
import java.util.HashMap;



public class IndexerTree {

	/*
	 * root of the tree; the treenode does not actually represent any letter
	 */
	private TreeNode root;
	
	
	/*
	 * Tree Map to store all words and results 
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
	
	
	public NodeArray makeList(){
		recursion(root);
		
		
		return result;
	}

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
