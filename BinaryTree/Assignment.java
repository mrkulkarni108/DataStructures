import java.time.LocalDateTime;
import java.util.Scanner;
public class Assignment{

    public static void calcDuration(int MAX){
          
        int[] arr = new int[MAX];
        int i = 0;

        long T1 = System.nanoTime();   
        if( i < MAX){ 
            for (int j = 0; j<MAX; j++){
                arr[i] = i;
            }
            i++;
        }
        
        long T2 = System.nanoTime();   
        
        long Duration = T2 - T1;
        System.out.println(Duration);
        MAX = 0;
        
    }
    public static void main(String[] args){
        int MAX = 10;
        while(MAX <= 200){
            calcDuration(MAX);
            MAX = MAX + 10;
        }
    }
}