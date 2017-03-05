import java.util.ArrayList;

/**
 * Implements a recursive, depth first search to find the node with
 * the specified searchValue.
 * 
 * @author Brenna Gardner
 *
 */
public class TreeSearchExample {
	
	static ArrayList<Node> visited = new ArrayList<Node>();
	
	public static void main(String[] args) {
		
		String searchValue = "Find Me";		
		Node tree = buildSampleTree();	
		Node match = searchTree(tree, searchValue);
		displayCompletionMessage(match, searchValue);
		System.out.println("Unique nodes visited: " + visited.size());
	}
	
	/**
	 * Returns the head node of the tree constructed to the example
	 * specifications (see ReadMe)
	 * 
	 * @return head node of the tree
	 * @see Node
	 */
	private static Node buildSampleTree() {
		
		Node start = new Node("Start");
		
		Node a1 = new Node("A1");
		Node a2 = new Node("A2");
		ArrayList<Node> levelOne = new ArrayList<Node>();
		levelOne.add(a1);
		levelOne.add(a2);
		start.setChildren(levelOne);
		
		Node b1 = new Node("B1");
		ArrayList<Node> level2Left = new ArrayList<Node>();
		level2Left.add(b1);
		a1.setChildren(level2Left);
		
		Node b2 = new Node("B2");
		Node b3 = new Node("B3");
		ArrayList<Node> level2Right = new ArrayList<Node>();
		level2Right.add(b2);
		level2Right.add(b3);
		a2.setChildren(level2Right);
		
		Node c1 = new Node("C1");
		ArrayList<Node> level3Left = new ArrayList<Node>();
		level3Left.add(c1);
		b1.setChildren(level3Left);		
		
		Node findMe = new Node("Find Me");
		ArrayList<Node> level3RightLeft = new ArrayList<Node>();
		level3RightLeft.add(findMe);
		b2.setChildren(level3RightLeft);
		
		Node c2 = new Node("C2");
		ArrayList<Node> level3RightRight = new ArrayList<Node>();
		level3RightRight.add(c2);
		b3.setChildren(level3RightRight);
		
		Node d1 = new Node("D1");
		ArrayList<Node> level4 = new ArrayList<Node>();
		level4.add(d1);
		findMe.setChildren(level4);
		
		return start;
	}
	
	/**
	 * Recursively search the current Node and it's children for the
	 * name supplied in matchName
	 * 
	 * @param node The current code to use in the search
	 * @param matchName The name of the node to find
	 * @return Node with a name of matchName or null if not found
	 * @see Node
	 */
	private static Node searchTree(Node node, String matchName){
		
		Node currentNode = node;
			
		if(currentNode != null) {
			
			String name = currentNode.getName();
			visited.add(currentNode);
			System.out.println("Node " + name + " visited.");
			
			if(name.equals(matchName)) {
				return currentNode;
			}
			
			ArrayList<Node> currentChildren = currentNode.getChildren();
			Node found = null;
			
			for (Node child : currentChildren) {
				found = searchTree(child, matchName);
				if (found  != null) {
					return found;
				}
			}
			return found;
		}else{
			return null;
		}
	}
	
	/**
	 * Display completion message based on whether or not a match was
	 * found
	 * 
	 * @param match Result of search, a matching Node or null
	 * @param nameToFind String name value to compare in search
	 * @see Node
	 */
	public static void displayCompletionMessage(Node match, String nameToFind) {
	
		String message = "";
		
		if (match != null) {
			message = "Search complete!";
		}else{
			message = "Node " + nameToFind + " not found.";
		}
		
		System.out.println(message);
	}
}
