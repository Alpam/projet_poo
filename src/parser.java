import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class parser {
	String motif = new String();
	ArrayList figure = new ArrayList();	
	
	public parser(String chemin ) {	
		
		/***********************************************************************************************************
		 * 
		 * 				Extraction des valeurs du .svg
		 *
		 ***********************************************************************************************************/
		
		try
		{
			int index_b;
			int index_f;
		    File f = new File (chemin);
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		    int flag=0;
		 
		    try
		    {
		    	
		        String line = br.readLine();
		 
		        while ((line != null) && (flag !=3))
		        {
		        	//recherche de la présence de d="
		        	//flag nous permet de savoir que le début a été trouvé.
		        	if (flag == 0) {
		        		if (line.indexOf("<path") != -1){
		        			flag=1;
		        		}
		        	}
		        	if (flag==1) {
		        		
		        		index_b=line.indexOf("d=\"");
		        		if(index_b!=-1) {
		        			flag=2;
		        			line=line.substring(index_b+3);
			        		index_f=line.indexOf("\"");
			        		if (index_f!=-1) {
			        			motif=line.substring(0,index_f);	
			        			flag=3;
			        			} else {
					        		motif=line.substring(index_b);	
			        			}
		        		}
		        		

		        	} 
		        	if (flag == 2){
		        		index_f=line.indexOf("\"");
		        		if (index_f!=-1) {
		        			motif=motif+line.substring(0, index_f);
		        			flag=3;
		        		} else if (flag!=3) {
		        			motif=motif+line;
		        		}
		        	}
		            line = br.readLine();
		        }
		        br.close();
		        fr.close();
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		
		/* Fin d'extraction*/
		
		
		
		/***********************************************************************************************************
		 * 
		 * 				Passage des valeurs en coordonnées absolues de points
		 *
		 ***********************************************************************************************************/
		
		int d1,d2;
		int last_x=0;
		int last_y=0;
		String digit_string = new String();
		point coord_bezier[]=new point [4];
		boolean isRelative;
		for (char c: motif.toCharArray()) {
			if (Character.isLetter(c)) {
				Arrays.fill(coord_bezier,null);
				
				if (Character.isLowerCase(c)) {
					isRelative=true;
				} else {
					isRelative=false;
				}
				
				if(Character.toLowerCase(c) == 'c') {
					
				}
				else if(Character.toLowerCase(c) == 'm') {
					
				}
				else if (c == 'z') {
					
				}
			}
			else if (Character.isDigit(c)) {
				digit_string = digit_string + c;
			}
			else if (c == ',') {
				
			}
		}
		
		
		
		
		
		
	}
	
	public void print_motif() {
        System.out.println(this.motif);
	}
	
	
	
	
	
	
}
