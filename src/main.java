import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("invalid number of args");
		}
		parser test = new parser(args[0]);
		ArrayList<Point> best = new ArrayList<Point>();
		best = Transformation.normalise_centralise_array(test.figure);
		Afficheur aff = new Afficheur(1200,1000,200);
		aff.affiche_polygone(best);
		int score=calc_score(best);
		int tmp_score;
		System.out.println(""+score);
		int count_iteration=0;
		int count_dg=0;
		int trslt_x, trslt_y;
		ArrayList<Point> tmp = new ArrayList<Point>(best);
		while(count_iteration<1000) {
			count_iteration++;
			trslt_x = (int)(Math.random()*100)+1;
			trslt_y = (int)(Math.random()*100)+1;
			tmp = Transformation.translation(tmp,new Point(trslt_x,trslt_y));
			while(count_dg<361) {
				if(!(count_dg==0)) {
					tmp = Transformation.rotation(tmp,count_dg);
				}
				tmp_score=calc_score(tmp);
				if(tmp_score<score) {
					score = tmp_score;
					best=new ArrayList<Point>(tmp);
					aff.affiche_polygone(best);
				}
				count_dg+=5;
			}
			count_dg=0;
		}
	}
	
	public static int calc_score(ArrayList<Point> t) {
		ArrayList<Point> pav_diff = new ArrayList<Point>();
		Point tmp_p;
		boolean flag=true;
		for(Point p:t) {
			tmp_p = p.is_in_pav();
			for(Point q:pav_diff) {
				if(q.eq(tmp_p)) {flag=false;break;}
			}
			if(flag) {
				pav_diff.add(tmp_p);
			}
			flag=true;
		}
		return pav_diff.size();
	}

}
