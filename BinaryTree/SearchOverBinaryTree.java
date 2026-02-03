import java.util.*;

public class SearchOverBinaryTree {
    static char [] arr = {'1','2','3','4','5','6','7','8','9','0'};
	static int n = arr.length;
	static char key = '9';

	static boolean visit(int i){
		long t1 = System.nanoTime();
		boolean flag = false;
		if(i>=n){
			return flag;
		}
		visit(2*i+1);
		if(arr[i] == key){
			System.out.println("Element found: " + key);
			System.out.println("Element found at index: " + i);
			flag=true;
		}else if(key != arr[i] && i >= n){
			System.out.println("Element not found at index: " + i);
			flag=false;
		}
		// System.out.println("arr[i] = " + arr[i]);
		visit(2*i+2);
		long t2 = System.nanoTime();
		long timecomplexity = t2 - t1;
		System.out.println("Time Complexity for index " + i + " is: " + timecomplexity + " ns");
		return flag;
	}
	

	public static void main(String[] args) {
		visit(0);
	}
}
