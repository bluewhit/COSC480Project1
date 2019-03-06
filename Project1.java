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
		//String c = "ACCATCGAGTTATCGCGATAAGAATCCAACTGTCATATCCTCCCTTTATTTAGGTAGCCTGCGATAGCATCCA";
		String c = "ACCTATCGAGTTATCGCGATAAGAATCCCAATCTGTCTATATCGCCTCCCTTTATTTGAGAGTTAGGTAGCCTGCGATAGCATTCCA";
		//String c = "ACTTATCGAGTCATCGCGATAAGAAACCCAACTGTCTATATCGCCTCCCTTTACTTAGGTAGCCTGCGTTAGCAATCCA";
		Project1 p = new Project1();
		
		//p.sequencer(f.toString(), e.toString(), s.toString());
		p.sequencer(f, e, s); 
		p.compare(c,f);
		
	}//end main
	
	
	public void sequencer(String f, String e, String s) {
		
		int counter = 0; 
		//int counter2 = 0;
		int icounter = 0; 
		
		String seq = ""; 
		
		ArrayList<Character> end = new ArrayList(); 
		ArrayList<Character> start = new ArrayList(); 
		ArrayList<Character> entire = new ArrayList();
		
		System.out.println("f" + f.length());
		
		/*for(int i = 0; i < f.length(); i++) {
			entire.add(f.charAt(i)); 		
		}//end for
		
		for(int i = 0; i < s.length(); i++) {
			start.add(s.charAt(i)); 		
		}//end for
		
		for(int i = 0; i < e.length(); i++) {
			 end.add(e.charAt(i)); 
		}
		*/
		
		for(int i = 0; i < f.length(); i ++) {
			
			String temp = "";
			icounter = i;
			System.out.println(i + "loop " + f.charAt(i) + s.charAt(0));
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
							
							//loop untill end point and tke everything inbetween to a string
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
									
									//System.out.println(temp3 + " Temp 3");
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
	
	public void compare(String c, String f) {
		
		int score = 0;
		int found = 0;
		
		if(c.length() > f.length()) {
			System.out.println("Searching for insertions...");
			
			String comp = c; 
			
			int lengthStr = comp.length() - f.length();
			
			for(int i = 0; i <= lengthStr; i++) {
				f = f + "-";
			}//end for 
			
			System.out.println(f);
			System.out.println(c);
			
			StringBuilder newf = new StringBuilder(f);
			for(int i = 0; i < newf.length(); i++) {
				if(comp.charAt(i) == newf.charAt(i)) {
					score++; 
				}
				else {
					newf.deleteCharAt(i);
					
				}
			}
			
			System.out.println(newf);
			
		}
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
			
		}
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

       
    
   