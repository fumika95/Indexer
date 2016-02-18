import java.util.ArrayList;
import java.util.Collections;

/*
* original array class that stores tree nodes and manage values of tree nodes
*
*/

public class NodeArray  {

	/*
	 *  int array that stores index of each node using the char value as index
	 */
	private int[] childIndex;
	
	/*
	 * array list that actually holds the children nodes
	 */
	private ArrayList<TreeNode> children;
	
	private int size;
	
	
	public NodeArray(){
		size = 1;
		childIndex = new int[123]; // 123 is the largest ascii value of a-z, A-Z, and 0-9
		children = new ArrayList<TreeNode>();
	}
	
	/*
	* add new tree node only if the letter does not exist yet
	*/
	public boolean add(TreeNode newNode){
		char letter = newNode.getLetter();
		boolean addSuccess = (childIndex[letter]==0);
		if(addSuccess){
			children.add(newNode);
			childIndex[letter] = size;
			size++;
		}
		return addSuccess;
	}
	
	/*
	* simply add tree nodes to the list
	*/
	public boolean addNode(TreeNode newNode){
		return children.add(newNode);
	}
	
	/*
	 * use letter to get treenode by hash indexing
	 */
	public TreeNode getNode(int index) {
		if(index <= 0 || index >= 123)
			return null;
		int ind = childIndex[index];
		TreeNode target;
		if(ind >= 1){
			target = children.get(ind-1);
		}else{
			target = null;
		}
		
		return target;
	}
	
	/*
	 * get tree node using the index of arraylist
	 */
	public TreeNode get(int index){
		if(index < 0 || index >= children.size())
			return null;
		return children.get(index);
	}

	public int size() {
		return children.size();
	}
	
	public void sort(){
		Collections.sort(children);
	}

}
