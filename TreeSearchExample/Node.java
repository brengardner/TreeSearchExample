import java.util.ArrayList;

public class Node {

	String name;
	ArrayList<Node> children;
	
	public Node(String name, ArrayList<Node> children) {
		this.name = name;
		this.children = children;
	}
	
	public Node(String name) {
		this.name = name;
		this.children = new ArrayList<Node>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public ArrayList<Node> getChildren() {
		return this.children;
	}
	
	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
	
}
