import java.io.IOException;

/*
 * a class that run the indexer and test results
 */

public class IndexerTester{

	public static boolean debug_on;
	public static String file_name;

	public static void main(String args[]) throws IOException{

		file_name = "";
		debug_on = false;
		// check argument
		if(args != null){
			if(args[0].equals("test")){
				debug_on = true;
			}else{
				file_name = args[0];
			}
		}


		if(debug_on){
			run_test();
		}else{
			run(file_name);
		}
	}

	public static void run_test() throws IOException{
		//test 1: testing correctness of result
		Indexer test1 = new Indexer("test1.txt");
		NodeArray result1 = test1.getResult();
		String[] result = {"i", "eat", "eggs", "and", "potatos", "bananas", 
			"apples", "peaches", "watermelons", "cookies"};
		boolean is_false = false;
		for(int i = 0; i < 10; i++){
			if(!result[i].equals(test1.recursive_print(result1.get(i)))){
				is_false = true;
				System.out.println("Failed correctness of result test: ");
			}
		}
		if(!is_false)
			System.out.println("Passed correctness of result test");
		else{
			for(int i = 0; i < 10; i++){
				System.out.println("Expected: " + result[i] + 
					" Actual: " + test1.recursive_print(result1.get(i)));
			}
		}


		//test 2: testing output: small file
		run("test2.txt");

		//test 3: testing output: large file
		run("test3.txt");
	}

	public static void run(String file_name) throws IOException{
		Indexer target = new Indexer(file_name);
		NodeArray result = target.getResult();

		System.out.println("\nFile name: " + file_name);
		for(int i = 0; i < 10; i++){
			System.out.printf("No.%2d: %10s\n",  i+1, target.recursive_print(result.get(i)));
		}
	}
}
