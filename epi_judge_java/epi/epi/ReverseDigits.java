package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseDigits {
  @EpiTest(testDataFile = "reverse_digits.tsv")
  public static long reverse(int x) {
    long rev = 0;
    long x2 = Math.abs(x);
    boolean negative = x < 0 ? true : false;
    while (x2 > 0) {
      rev = rev*10 + (x2%10);
      x2 /= 10;
    }

    return negative ? -rev : rev;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseDigits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
