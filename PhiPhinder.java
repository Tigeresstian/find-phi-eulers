package AbsMath;

import java.util.*;

/*Exercise 11.4
 * Catherine Yue, a bad agent of the 7th period Abstract Math Society
 * Early November, Late 2022
 */

public class PhiPhinder {
	

	    public static void main(String[] args) {
	        boolean repeat;
	       
	        do{
	            // lists that will be used
	            ArrayList<Long> listPrime = new ArrayList<Long>();
	            // take user input; an integer
	            System.out.println("To solve for Φ(n), please input a positive integer n: ");
	            Scanner rawNum = new Scanner(System.in);
	            String strNum = rawNum.nextLine();
	            long num = Long.valueOf(strNum);

	            // PRIME FACTORIZATION
	                    System.out.println();
	                    System.out.print("Φ(n) = ");
	                    primeFactors(num, listPrime);
	                   
	                    LinkedHashSet<Long> intermediary = new LinkedHashSet<>(listPrime);
	                    ArrayList<Long> betterListPrime = new ArrayList<>(intermediary);
	                    long bigPhi = 1;

	                    for (long i : betterListPrime){
	                        long primeRepeats = Collections.frequency(listPrime, i);
	                        bigPhi *= littlePhi(i, primeRepeats);
	                       
	                    }
	               
	                    //System.out.println(listPrime);
	                    System.out.println(bigPhi);
	                    System.out.println();

	            System.out.println("Would you like to solve something else? ( yes[1] or no[2] )");
	            Scanner rawContinue = new Scanner(System.in);
	            String strContinue = rawContinue.nextLine();
	            Integer inputContinue = Integer.valueOf(strContinue);
	            System.out.println();
	            System.out.println();
	            if(inputContinue == 1){
	                repeat = true;
	            }
	            else{
	                repeat = false;
	            }
	        } while(repeat==true);
	    }
	   
	    // PRIME FACTORIZATION FUNCTION
	    public static void primeFactors(long number, List<Long> list){
	        for (long i = 2; i<= number; i++) {
	            if (number % i == 0) {
	                number = number/i;
	                list.add(i);
	                i--;
	            }
	        }
	    }
	   
	    // CALCULATE PHI FOR A PRIME (or powers of a prime)
	    public static long littlePhi(long prime, long n){
	        if(n==1){
	            return prime-1;
	        }
	        else{
	            return ((prime-1)*((long)(Math.pow(prime, n-1))));
	        }
	    }
	

}
