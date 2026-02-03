public class Binary_Treee {
    static char [] arr = {'1','2','3','4','5','6','7','8','9','0'};
	static int n = arr.length;
	// static int activeCalls = 0;
	// static int totalCall = 0;
		
	static void visit(int i){
		// System.out.println("Active Call Number : " + activeCalls);
		// activeCalls++;
		// totalCall++;
		// System.out.println("i visited this : "+i);
	    if(i>=n){
			// activeCalls--;
			return;
	    }
		System.out.print("  "+arr[i]);
	    visit(2*i+1);
		visit(2*i+2);
		// activeCalls--;
	}
	// static void totalActiveCalls(){
	// 	System.out.println("Total Active Calls Made : " + activeCalls);
	// }
	// static void TotalCalls(){
	// 	System.out.println("Total Calls Made : " + totalCall);
	// }
	public static void main(String[] args) {
		visit(0);
		// totalActiveCalls();
		// TotalCalls();
	}
}
