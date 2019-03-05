import java.io.*;
import java.util.*; 
  
public class Project1 { 
    
	public static void main(String[] args)throws IOException {

		if(args.length < 1) {
		System.out.println("Error, usage: java ClassName inputfile");
		System.exit(1);
		}	 
		
		Scanner fasta = new Scanner(new FileInputStream(args[0]));
		Scanner comp = new Scanner(new FileInputStream(args[1]));
		Scanner end = new Scanner(new FileInputStream(args[2]));
		Scanner start = new Scanner(new FileInputStream(args[3]));
		
		StringBuilder f = new StringBuilder();
		StringBuilder c = new StringBuilder(); 
		StringBuilder e = new StringBuilder();
		StringBuilder s = new StringBuilder(); 
		
		boolean first = true; 
		
		while(fasta.hasNextLine()) {
			
			String line = fasta.nextLine().trim();
			f.append(line);
			
		}//end while
		
		while(comp.hasNextLine()) {
			
			String line = comp.nextLine().trim();
			if(line.startsWith(">")){
				continue; 
			}
			c.append(line);
			
		}//end while
		
		while(end.hasNextLine()) {
			
			
			String line = end.nextLine().trim();
			if(line.startsWith(">")){
				continue;
			}
			e.append(line);
			
		}//end while
		
		while(start.hasNextLine()) {
			
			String line = start.nextLine().trim();
			if(line.startsWith(">")){
				continue; 
			}
			s.append(line);
			
		}//end while
		
		System.out.println(f.toString());
		System.out.println(c.toString());
		System.out.println(e.toString());
		System.out.println(s.toString());
			
	}//end main
	
	public void createTree(StringBuilder start, StringBuilder end){
		
		ArrayList<String> tree = new ArrayList<String>(); 
		
		for(int i = 0; i <= start.length(); i++) {
			for(int j = 0; j <= start.length(); j++) {
				String temp = Character.toString(start.charAt(i)); 
				if(temp == tree.get(i)) {
					//do stuff
				}
				else {
					tree.add(temp);
				}//add the thing to the thing
				
				System.out.println(tree);
			}
			
			
		}//end for 
		
	}//end create tree
	
	
	//ref- from user
	//comp- found
	public void mutationCheck(StringBuilder ref, StringBuilder comp){
		
		int score=0;
		
		//checks if there are mutations
		if(ref.toString().equals(comp.toString())){
			//prints following if there are no mutations
			System.out.println("Gene: "+ comp.toString()+ " was found in position ");
			System.out.println("Mutation Found: No mutations.");
			System.out.println("Score: N/A.");
		}else{
			//if point mutation
			
			for(int i=0; i<ref.length(); i++){
				if(comp.charAt(i)!=ref.charAt(i)){
					score--;
				}//end if
			}//end for
			
			System.out.println("Gene: "+ comp.toString()+ " was found in position ");
			System.out.println("Mutation Found: Point Mutation");
			System.out.println("Score: "+ score);
			
			
			//if insertion
			for(int i=0; i<comp.length(); i++){
				if(ref.charAt(i)=='-'){
					score--;
				}//end if
			}//end for
			
			System.out.println("Gene: "+ comp.toString()+ " was found in position ");
			System.out.println("Mutation Found: Insertion");
			System.out.println("Score: "+ score);
			
			//if deletion
			
			for(int i=0; i<ref.length(); i++){
				if(comp.charAt(i)=='-'){
					score--;
				}//end if
			}//end for
			
			System.out.println("Gene: "+ comp.toString()+ " was found in position ");
			System.out.println("Mutation Found: Deletion");
			System.out.println("Score: "+ score);
		}//end if/else
		
	}//end mutationCheck
	
	
	
}//end class 

       
    
   
