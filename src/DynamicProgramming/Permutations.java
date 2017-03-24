package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenskart on 26/02/2017.
 */
public class Permutations {
    public List<String> getPermutation(String s) {
        return recursivePermutationCalculation(s);
    }

    public List<String> recursivePermutationCalculation(String s) {
        List<String> permutation = new ArrayList<>();
        if (s.length() == 0) {
            permutation.add("");
            return permutation;
        }
        char first = s.charAt(0);
        String remainder = s.substring(1);
        ArrayList<String> words = (ArrayList<String>) recursivePermutationCalculation(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s1 = insertCharAt(word, first, j);
                permutation.add(s1);
            }
        }
        return permutation;
    }

    private String insertCharAt(String word, char first, int j) {
        String start = word.substring(0, j);
        String end = word.substring(j);
        return start + first + end;
    }

    public static void printArray(List<String> arr) {
        arr.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<String> arr = permutations.getPermutation("ABCD");
        System.out.println(arr.size());
        Permutations.printArray(arr);
    }
}
