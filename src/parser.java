import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class parser {
	String motif = new String();

	
	
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
		        	if (flag == 2 && flag != 3){
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
		
		
		
		
		
		
		
		
		
		
	}
	
	public void print_motif() {
        System.out.println(this.motif);
	}
	
	
	
	
	
	
}
