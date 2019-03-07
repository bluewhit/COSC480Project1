import java.util.ArrayList;

public class Tree {
	//where in the file, index 
	
	ArrayList<Node> tree = new ArrayList(); 
	
	public void makeTree(String f) {
		
		Node root = new Node("");
		Node ptr = new Node(""); 
		Node temp = new Node(f); 
		
		ArrayList<Node> tree = new ArrayList<>(); 
		ArrayList<Integer> intys = new ArrayList<>(); 
 		
		
		for(int i = 0; i< f.length(); i++) {
			if(f.charAt(i) == 'A') {
				if(ptr.getA() == null){ 
					if(i != f.length()) {
						
						String newt = f.substring(i, f.length());
						temp = new Node(newt);
						
						ptr.setA(temp); 
						//tree.add(ptr.getA());
						ptr.addChild(temp);
						
					}//end if 
				}
				else {
				
					String temp2 = ptr.getA().toString();
					String temp3 = ""; 
					int k = i+1; 
					int counter = 1; 
					while(k < temp2.length()) {
						
						//System.out.println(f);
						//System.out.println(temp2 + " K: " +k+ " " + f.charAt(k) + " counter: " + temp2.charAt(counter) + " " + counter );
						if(temp2.charAt(counter) != f.charAt(k)) {
							
							temp3 = f.substring(k,f.length());
							temp = new Node(temp3);
							ptr.addChild(temp);
							ptr.setA(temp);
						}
						
						counter++; 
						k++;
					}
					
				}
			}//end if char == 'A'
			else if(f.charAt(i) == 'C') {
				if(ptr.getC() == null){ 
					if(i != f.length()) {
						
						String newt = f.substring(i, f.length());
						temp = new Node(newt);
						
						ptr.setC(temp); 
						tree.add(ptr.getC());
						
					}//end if 
				}
				else {
				
					String temp2 = ptr.getC().toString();
					String temp3 = ""; 
					int k = i+1; 
					int counter = 1; 
					while(k < temp2.length()) {
						
						//System.out.println(f);
						//System.out.println(temp2 + " K: " +k+ " " + f.charAt(k) + " counter: " + temp2.charAt(counter) + " " + counter );
						if(temp2.charAt(counter) != f.charAt(k)) {
							
							temp3 = f.substring(k,f.length());
							temp = new Node(temp3);
							ptr.addChildC(temp);
							ptr.setC(temp);
						}
						
						counter++; 
						k++;
					}
				}
			}
			else if(f.charAt(i) == 'G'){
				if(ptr.getG() == null){ 
					if(i != f.length()) {
						
						String newt = f.substring(i, f.length());
						temp = new Node(newt);
						
						ptr.setG(temp); 
						tree.add(ptr.getG());
						
					}//end if 
				}
				else {
				
					String temp2 = ptr.getG().toString();
					String temp3 = ""; 
					int k = i+1; 
					int counter = 1; 
					while(k < temp2.length()) {
						
						//System.out.println(f);
						//System.out.println(temp2 + " K: " +k+ " " + f.charAt(k) + " counter: " + temp2.charAt(counter) + " " + counter );
						if(temp2.charAt(counter) != f.charAt(k)) {
							
							temp3 = f.substring(k,f.length());
							temp = new Node(temp3);
							ptr.addChildG(temp);
							ptr.setG(temp);
						}
						
						counter++; 
						k++;
					}
				}
			}//end else if 
			else if(f.charAt(i) == 'T') {
				if(ptr.getT() == null){ 
					if(i != f.length()) {
						
						String newt = f.substring(i, f.length());
						temp = new Node(newt);
						
						ptr.setT(temp); 
						tree.add(ptr.getT());
						
					}//end if 
				}
				else {
				
					String temp2 = ptr.getT().toString();
					String temp3 = ""; 
					int k = i+1; 
					int counter = 1; 
					while(k < temp2.length()) {
						
						//System.out.println(f);
						//System.out.println(temp2 + " K: " +k+ " " + f.charAt(k) + " counter: " + temp2.charAt(counter) + " " + counter );
						if(temp2.charAt(counter) != f.charAt(k)) {
							
							temp3 = f.substring(k,f.length());
							temp = new Node(temp3);
							ptr.addChildT(temp);
							ptr.setT(temp);
						}
						
						counter++; 
						k++;
					}
				}
			}//end else if 
			else {
				System.out.println("I came across a letter that shouldn't be here!"); 
			}//end else 
				
		}//end for loop 
		
		System.out.println("A: " + ptr.childa);
		System.out.println("C:" + ptr.childC);
		System.out.println("G:" + ptr.childG);
		System.out.println("T: " + ptr.childT);
		//System.out.println(tree);
		
		//appendTrees(ptr.childa, ptr.childC, ptr.childG, ptr.childT); 
	}//end make tree
	
	public void appendTrees(ArrayList<Node> childa, ArrayList<Node> childC, ArrayList<Node> childG, ArrayList<Node> childT) {
		
		for(int i = 0; i < childa.size(); i ++) {
			tree.add(childa.get(i));
		}
		
		for(int i = 0; i < childC.size(); i ++) {
			tree.add(childC.get(i));
		}
		
		for(int i = 0; i < childG.size(); i ++) {
			tree.add(childG.get(i));
		}
		
		for(int i = 0; i < childT.size(); i++) {
			tree.add(childT.get(i)); 
		}
		
		System.out.println(tree);
		
	}
	
}//end Tree 
