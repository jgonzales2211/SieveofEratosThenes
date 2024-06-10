import java.io.FileWriter;
import java.io.IOException;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int limit = 1000;
        boolean[] isPrime = new boolean[limit];
        for (int i = 2; i < limit; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        try (FileWriter writer = new FileWriter("primes.txt")) {
            int count = 0;
            for (int i = 2; i < limit; i++) {
                if (isPrime[i]) {
                    writer.write(i + " is prime.\n");
                    count++;
                }
            }
            writer.write(count + " primes found.");
        } catch (IOException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }
}
