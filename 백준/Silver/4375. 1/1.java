import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, k, i;
        
        while(sc.hasNext()) {

            n = sc.nextInt();
            k = 1;

            for (i = 1; ;i++)
            {
            	if (k%n==0)
            	{
                    System.out.println(i);
            		break;
            	}
            	k=k%n;
            	k=k*10+1;
            }
        }
        
        sc.close();
	}
}