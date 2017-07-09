import java.util.*;

public class Driver {
	
	private static final Random RAND = new Random(42);
	private static final int bound = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        long ta = System.currentTimeMillis();
        sortRandom(1000000000);
        long tb = System.currentTimeMillis();
        System.out.println("TIME: "+(tb-ta)+" MS");
		
	}
	
	public static List<Integer> createRandomArray(int length) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < length; i++) {
			list.add(RAND.nextInt(bound));
		}
		return list;
	}
	
	public static void sortRandom(int length){

		List<Integer> a = createRandomArray(length);
		MergeSortThreadStopper sort = new MergeSortThreadStopper(a);
		
		while(sort.t.isAlive()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
