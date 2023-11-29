
/**
 * Aaron Kang
 */
import java.util.*;
public class ArrayList_Problems {
    public static ArrayList<Integer> Sieve_Of_Eratosthenes(int n) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 3; i <= n; i+= 2) {
            primes.add(i);
        }
        int p = 2;
        while (p <= n) {
            for (int i = p+1; i < primes.size(); i++) {
                if (primes.get(i)%p==0) primes.remove(i);
            }
            p++;
        }
        return primes;
    }

    public static void Goldbach_Conjucture(int n) {
        boolean found = false;
        ArrayList<Integer> primes = Sieve_Of_Eratosthenes(n);
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                if (primes.get(i) + primes.get(j) == n) {
                   System.out.println(primes.get(i) + "+" + primes.get(j) + "=" + n);
                   found = true;
                   break;
                }
            }
            if (found) break;
        }
    }

    public static ArrayList<Integer> BigInts(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> sum = new ArrayList<Integer>();
        int temp = 0;
        int size = Math.max(a.size(), b.size());
        if (size != a.size()) {
            for (int i = 0; i < b.size()-a.size(); i++) {
                a.add(0, 0);
            }
        }
        else {
            for (int i = 0; i < a.size()-b.size(); i++) {
                b.add(0, 0);
            }
        }
        Collections.reverse(a);
        Collections.reverse(b);

        for (int i = 0; i < size; i++) {
            int A = (i < a.size()) ? a.get(i) : 0;
            int B = (i < b.size()) ? b.get(i) : 0;

            int element = (A + B + temp) % 10;
            sum.add(element);
            temp = (A + B + temp) / 10;
        }

        if (temp > 0) {
            sum.add(temp);
        }

        Collections.reverse(sum);
        return sum;
    }
}

