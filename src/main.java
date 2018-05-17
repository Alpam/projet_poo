public class main {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("invalid number of args");
		}
		parser test= new parser(args[0]);
		test.print_motif();
		test.print_figure();
	}

}
