/*
 * Whitney Trovinger
 * COSC480 - Bioinformatics 
 * 
 * Project1 class. Main class.
 * All of the command line stuff works but is commented out for testing purposes. 
 */

import java.io.*;
import java.util.*; 
  
public class Project1 { 
	
	public List<String> seqList = new ArrayList<>();
	
		public static void main(String args[]) throws FileNotFoundException{	 
		
		/*Scanner fasta = new Scanner(new FileInputStream(argss[0]));
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
		*/
			
		String f = "ACCTATCGAGTTATCGCGATAAGAATCCCAACTGTCTATATCGCCTCCCTTTATTTAGGTAGCCTGCGATAGCATTCCA";
		String e = "TCC";
		String s = "CCT";
		
		String c = "ACCTATCGAGTTATCGCGATAAGAATCCCAATCTGTCTATATCGCCTCCCTTTATTTGAGAGTTAGGTAGCCTGCGATAGCATTCCA";
		//String c = "ACCATCGAGTTATCGCGATAAGAATCCAACTGTCATATCCTCCCTTTATTTAGGTAGCCTGCGATAGCATCCA";
		//String c = "ACTTATCGAGTCATCGCGATAAGAAACCCAACTGTCTATATCGCCTCCCTTTACTTAGGTAGCCTGCGTTAGCAATCCA";
		
		Project1 p = new Project1();
		Tree t = new Tree(); 
		Node n = new Node(""); //node to access the trees
		
		//p.sequencer(f.toString(), e.toString(), s.toString());
		//p.sequencer(f, e, s); 
		//p.compare(c,f);
		t.makeTree(f);
		
		//t.treeA(childa)
	}//end main
	
		/*
		 * Method to find the comparison string, is not implemented for the tree. 
		 * I was thinking i had to have one tree, and then search through that...
		 * Otherwise this works for testing purposes. 
		 */
	public void sequencer(String f, String e, String s) {
		
		int counter = 0; 
		//int counter2 = 0;
		int icounter = 0; 
		
		String seq = ""; 
		
		System.out.println("f" + f.length());
		
		for(int i = 0; i < f.length(); i ++) {
			
			//temporary values 
			String temp = "";
			icounter = i;
			String temp2 = "";
			String temp3 = ""; 
			
			if(f.charAt(i) == s.charAt(0)) {
				//System.out.println("True");
				for(int j = 0; j < s.length(); j++) {
					
					//System.out.println("J: " + j + "loop " + "icounter " + icounter + " entire: "+ f.charAt(icounter) + " start:" + s.charAt(j));
					if(f.charAt(icounter) == s.charAt(j)) {
						//System.out.println("true");
						temp = temp + f.charAt(icounter); 
						//System.out.println(temp + "temp");
						
						if(s.equals(temp)){
							
							int icounter2 = 0;
							
							//loop until end point and take everything inbetween to a string
							//System.out.println(icounter2 + "icounter2" + f.charAt(icounter2));
							icounter2 = icounter;
							icounter2++;
							//System.out.println(icounter2 + " icounter2 after " + f.charAt(icounter2));
							
							while( icounter2 < f.length()) {
								//if it does equal end 
								//icounter2 = icounter;
								temp2 = temp2 + f.charAt(icounter2); 
								icounter2++;
								if(temp2.endsWith(e)) {
									//System.out.println("true shit");
									temp3 = temp2;
									temp3 = temp3.substring(0, temp3.length() - e.length());
									
									//System.out.println(temp3 + "Temp3");
									seqList.add(temp3);
									break; 
								}//end else 
							}//end while 
						}//end if 
						
						icounter++;
					}
					else {
						//System.out.println("false");
						break;
					}//end else
					
					//System.out.println(temp+ "temp");
					//System.out.println(temp2+ " temp2");
				}//end if 
			}
		}
		
		System.out.println(seqList);
		
	}//end sequencer 
	
	/*
	 * This method was suppose to compare the comparison string to the reference string... 
	 * I had to implement the suffix tree to the sequencer first. Otherwise this works for testing purposes. 
	 * if my C string would be the reference here, the F string would be the comparison string. 
	 */
	public void compare(String c, String f) {
		
		int score = 0;
		
		//insertions 
		if(c.length() > f.length()) {
			System.out.println("Searching for insertions...");
			
			
			int lengthStr = c.length() - f.length();
			
			System.out.println("f " + f);
			System.out.println("c " + c);
			
			StringBuilder comp = new StringBuilder(c);
			for(int i = 0; i < comp.length(); i++) {
				if(comp.charAt(i) == f.charAt(i)) {
					score++; 
				}
				else {
					
					System.out.println(comp);
					comp.deleteCharAt(i);
					System.out.println(comp);
					score--;
				}
			}
			
			System.out.println("f\n" + f);
			System.out.println("comp\n" + comp);
			System.out.println("Mutation Found: Insertion\nScore: "+ score);
			
		}
		//deletions 
		else if(c.length() < f.length()) {
			System.out.println("Searching for deletions....");
			
			String newf = f; 
			String comp = c; 
			
			int lengthStr = newf.length() - comp.length();
			
			for(int i = 0; i <= lengthStr; i++) {
				comp = comp + "-";
			}
			
			System.out.println(comp);
			System.out.println(f);
			
			for(int i = 0; i < f.length(); i++) {
				if(comp.charAt(i) == f.charAt(i)) {
					score++; 
				}
				else {
					comp = comp.substring(0, i) + "-" + comp.substring(i, comp.length());
					score--;
					System.out.println(comp);
					System.out.println(f);
				}
			
			}//end for 
			comp = comp.substring(0, comp.length() - lengthStr-1);
			System.out.println(comp);
			System.out.println("Mutation Found: Deletion\nScore: "+ score);
			
		}
		//mutations 
		else if(c.length() == f.length()){
			System.out.println("Searching for mutations....");
			
			for(int i = 0; i < f.length(); i++) {
				if(c.charAt(i) == f.charAt(i)) {
					score++; 
				}
				else {
					score--;
				}
			}
			
			System.out.println("Mutation Found: Point Mutation\nScore: "+ score);
		}
		else {
			System.out.println("Error! Goodbye.");
			System.exit(0);
		}
	}
	
}//end class  