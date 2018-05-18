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
    ArrayList<Point> figure = new ArrayList<Point>();
    private char c;
   
    public parser(String chemin ) {
       
        /***********************************************************************************************************
         *
         *              Extraction des valeurs du .svg
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
         *              Passage des valeurs en coordonnées absolues de points
         *
         ***********************************************************************************************************/
       
        float d1=0;
        float d2=0;
        float last_x=0;
        float last_y=0;
        int flag=0;
        String digit_string = new String();
        digit_string="";
        Point coord_bezier[]=new Point [4];
        boolean isRelative=true;
       
        for (char c : motif.toCharArray()) {
            isRelative=true;
            if (Character.isLetter(c)) {
                Arrays.fill(coord_bezier,null);
               
                if (Character.isLowerCase(c)) {
                    isRelative=true;
                } else {
                    isRelative=false;
                }
               
                if(Character.toLowerCase(c) == 'c') {
                    //figure.remove(figure.get(figure.size()-1));
                    coord_bezier[0]=new Point((int)last_x,(int)last_y);
                }
                else if(Character.toLowerCase(c) == 'm') {
                    figure.add(new Point(false));
                    flag=1;
                }
                else if (c == 'z') {
                    figure.add(new Point((figure.get(0).x),(figure.get(0).y),true));
                    last_x=figure.get(0).x;
                    last_y=figure.get(0).y;
                }
            }
            else if (Character.isDigit(c) || c == '.' || c == '-') {
                digit_string = digit_string + c;   
            }
            else if (c == ',') {
                d1=Float.parseFloat(digit_string);
                digit_string="";
            } else if (c == ' ' && digit_string!="") {
                d2=Float.parseFloat(digit_string);
                digit_string="";
                if (isRelative == false) {
                    last_x=0;
                    last_y=0;
                }
                if (coord_bezier[0]!=null) {
                    last_x = coord_bezier[0].x;
                    last_y= coord_bezier[0].y;
                }
                if (coord_bezier[0]== null) {
                    if (flag==1){
                        figure.get(figure.size()-1).x = (int)(d1+last_x);
                        figure.get(figure.size()-1).y = (int)(d2+last_y);
                        last_x+=(int)d1;
                        last_y+=(int)d2;
                        flag=0;
                    } else {
                        figure.add(new Point((int)(d1+last_x),(int) (d2+last_y),true));
                    }
                } else if (coord_bezier[3]==null) {
                    for (int i=0; i<4;i++) {
                        if (coord_bezier[i] == null) {
                            coord_bezier[i] = new Point((int)(d1+last_x),(int)(d2+last_y),true);
                            last_x += (int)d1;
                            last_y += (int)d2;
                            break;
                        }
                    }
                } else {
                    //calcul des segments pour la courbe de bezier
                    for (float i=0; i<=1; i=(float) (i+0.1)) {
                        //calcul des valeurs x et y
                        int tmp_x=(int) (coord_bezier[0].x*Math.pow((1-i), 3)+3*coord_bezier[1].x*i*Math.pow(1-i, 2) + 3*coord_bezier[2].x*Math.pow(i, 2)*(1-i)+coord_bezier[3].x*Math.pow(i, 3));
                        int tmp_y=(int) (coord_bezier[0].y*Math.pow((1-i), 3)+3*coord_bezier[1].y*i*Math.pow(1-i, 2) + 3*coord_bezier[2].y*Math.pow(i, 2)*(1-i)+coord_bezier[3].y*Math.pow(i, 3));
                        //set du point
                        if (i==0) {
                            figure.get(figure.size()-1).x = tmp_x;
                            figure.get(figure.size()-1).y = tmp_y;
                        }else {
                            figure.add(new Point(tmp_x,tmp_y,true));
                        }
                    }
                    Arrays.fill(coord_bezier,null);
                    coord_bezier[0]=new Point((int)last_x,(int) last_y);
                }
            }
        }  
    }
   
    public void print_motif() {
        System.out.println(this.motif);
    }
   
    public void print_figure() {
        for(Point po : figure) {
 
            System.out.print(po.x + "   "   );
            System.out.print(po.y + "   " );
            System.out.println(po.drawable);
        }
    }
   
   
   
   
   
   
}