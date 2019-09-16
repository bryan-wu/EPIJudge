package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class IntAsArrayIncrement {
  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    int lastIndex = A.size() - 1;
    A.set(lastIndex, A.get(lastIndex) + 1);

    for (int i = lastIndex; i >= 0 && A.get(i) == 10; --i) {
      A.set(i, 0);
      A.set(i - 1, A.get(i - 1) + 1);
    }
    if (A.get(0) == 10) {
      A.set(0, 0);
      A.add(0, 1);
    }
    return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
