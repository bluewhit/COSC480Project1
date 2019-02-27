import java.util.ArrayList;
import java.util.List;

//https://stackoverflow.com/questions/19330731/tree-implementation-in-java-root-parents-and-children
public class Node<String> {
	
    private List<Node<String>> children = new ArrayList<Node<String>>();
    private Node<String> parent = null;
    private String data = null;

    public Node(String data) {
        this.data = data;
    }

    public Node(String data, Node<String> parent) {
        this.data = data;
        this.parent = parent;
    }

    public List<Node<String>> getChildren() {
        return children;
    }

    public void setParent(Node<String> parent) {
        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(String data) {
        Node<String> child = new Node<String>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<String> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent() {
        this.parent = null;
    }
}