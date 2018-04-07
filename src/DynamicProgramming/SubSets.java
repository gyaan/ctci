package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gyaneshwar on 26/02/2017.
 */
public class SubSets {
    private List<String> subSets = new ArrayList<>();

    public void createSubSet(String s) {
        createSubsetRecursively(s, 0);
    }

    public void createSubsetRecursively(String s, int currentCharacterIndex) {
        if (currentCharacterIndex < s.length()) {
            if (currentCharacterIndex == 0) {
                this.subSets.add("{}");
                this.subSets.add("{" + s.charAt(currentCharacterIndex) + "}");
            } else {
                List<String> temp = this.subSets.stream().map(s1 -> {
                    String s2 = "";
                    if (s1 != "{}")
                        s2 = ",";
                    return s1.substring(0, s1.length() - 1) + s2 + s.charAt(currentCharacterIndex) + "}";
                }).collect(Collectors.toList());
                this.subSets.addAll(temp);
            }
            createSubsetRecursively(s, currentCharacterIndex + 1);
        }
    }

    public void printSubset() {
        System.out.println("Total subsets:" + this.subSets.size());
        this.subSets.forEach(System.out::println);
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        subSets.createSubSet("12345");
        subSets.printSubset();
    }
}
