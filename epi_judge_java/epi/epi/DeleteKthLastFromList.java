package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class DeleteKthLastFromList {
  @EpiTest(testDataFile = "delete_kth_last_from_list.tsv")

  // Assumes L has at least k nodes, deletes the k-th last node in L.
  public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {
    ListNode<Integer> dum = new ListNode<>(0, L);
    ListNode<Integer> right = dum.next, left = dum;
    // move right to k-th ndoe from head
    while (k-- > 0) {
      right = right.next;
    }

    // move both in tandem
    while (right != null) {
      left = left.next;
      right = right.next;
    }

    left.next = left.next.next;

    return dum.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DeleteKthLastFromList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
