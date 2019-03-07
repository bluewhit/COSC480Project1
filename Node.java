import java.util.ArrayList;

class Node {
	
    private String seq;
    private Node a;
    private Node c;
    private Node g; 
    private Node t; 
    
    //constructor takes in seq, null for all
    //gets and sets for all 
    
    ArrayList<Node> childa = new ArrayList(); 
    ArrayList<Node> childC = new ArrayList();
    ArrayList<Node> childT = new ArrayList();
    ArrayList<Node> childG = new ArrayList();
    
    public Node(String s) {
    	
    	seq = s; 
    	a = null;
    	c = null;
    	g = null;
    	t = null; 
    	childa = new ArrayList(); 
    	
    }//end constructor 

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public Node getA() {
		return a;
	}

	public void setA(Node a) {
		this.a = a;
	}

	public Node getC() {
		return c;
	}

	public void setC(Node c) {
		this.c = c;
	}

	public Node getG() {
		return g;
	}

	public void setG(Node g) {
		this.g = g;
	}

	public Node getT() {
		return t;
	}

	public void setT(Node t) {
		this.t = t;
	}
	
	public String toString() {
		return seq; 
	}
	
	public void addChild(Node n) {
		childa.add(n); 
	}
	
	public void addChildC(Node n) {
		childC.add(n); 
	}
	
	public void addChildT(Node n) {
		childT.add(n); 
	}
	
	public void addChildG(Node n) {
		childG.add(n); 
	}
    
}