import java.util.ArrayList;
import java.util.Collections;


public class NodeArray  {

	/*
	 *  int array that stores index of each node using the char value as index
	 */
	private int[] childIndex;
	
	/*
	 * array list that actually holds the children node
	 */
	private ArrayList<TreeNode> children;
	
	private int size;
	
	public NodeArray(){
		size = 1;
		childIndex = new int[123]; // 123 is the largest ascii value of a-z, A-Z, and 0-9
		children = new ArrayList<TreeNode>();
	}
	
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
	
	public boolean addNode(TreeNode newNode){
		return children.add(newNode);
	}
	
	/*
	 * use letter to get treenode
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
	 * get tree node using the index of array
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
