package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Stack;

public class EvaluateRpn {
  @EpiTest(testDataFile = "evaluate_rpn.tsv")

  public static int eval(String expression) {
    String[] vals = expression.split(",");
    Stack<Integer> numbers =  new Stack<Integer>();
    int op1 = 0, op2 = 0;
    for (String str : vals) {

      switch (str) {
        case ("-"):
          op1 = numbers.pop();
          op2 = numbers.pop();
          numbers.push(op2 - op1);
          break;
        case ("+"):
          op1 = numbers.pop();
          op2 = numbers.pop();
          numbers.push(op2 + op1);
          break;
        case ("*"):
          op1 = numbers.pop();
          op2 = numbers.pop();
          numbers.push(op2 * op1);
          break;
        case ("/"):
          op1 = numbers.pop();
          op2 = numbers.pop();
          numbers.push(op2 / op1);
          break;
        default:
          numbers.push(Integer.parseInt(str));
      }
    }
    return numbers.pop();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvaluateRpn.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
