package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gyaneshwar on 26/02/2017.
 */
public class Parentheses {
    /*
     *  insert from left side till middle parentheses
     *  and insert one pair at the front of the previous parentheses;
     */

    public Set<String> generateParen(int n) {
        Set<String> set = new HashSet<String>();
        if (n == 0) {
            set.add("");
            return set;
        } else {
            Set<String> previous = generateParen(n - 1);
            for (String s : previous) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        String s1 = insertParen(s, i);
                        set.add(s1);
                    }
                }
                set.add("()" + s);
            }
            return set;
        }
    }

    private String insertParen(String s, int i) {
        String left = s.substring(0, i + 1);
        String right = s.substring(i + 1, s.length());
        return left + "()" + right;
    }

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();

        Parentheses parentheses1 = parentheses;


        Set<String> set = parentheses.generateParen(3);
        set.forEach(System.out::println);
    }

}
