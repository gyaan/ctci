import java.util.Arrays;

/**
 * Created by gyaneshwar on 17/02/2017.
 */
public class MyString {


    /*
     question 1.
     */
    public static boolean isUniqueCharacter(String s) {
        if (s.length() > 256)
            return false;
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (charSet[s.charAt(i)]) {
                return false;
            }
            charSet[s.charAt(i)] = true;
        }
        return true;
    }

    /*
     question 2
     */
    public static String reversString(String s) {
        if (s.length() == 0)
            return s;
        char[] sArray = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = temp;
            i++;
            j--;
        }
        return Arrays.toString(sArray);
    }

    /*
    question 3
     */
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        //create one int array
        int[] arr = new int[256];
        //form one string.
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)]++;
        }
        //check using another string.
        for (int j = 0; j < s2.length(); j++) {
            if (--arr[s2.charAt(j)] < 0) {
                return false;
            }
        }
        //traversed both string
        return true;
    }


    /*
    question 4
     */
    public static String replaceSpaceWithWord(char[] s) {
        String replaceWord = "02%";
        int spaceCount = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ')
                spaceCount++;
        }
        int newLength = s.length + (replaceWord.length() - 1) * spaceCount;
        char[] chars = new char[300];
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] == ' ') {
                chars[newLength - 1] = '0';
                chars[newLength - 2] = '2';
                chars[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                chars[newLength - 1] = s[i];
                newLength = newLength - 1;
            }
        }
        return Arrays.toString(chars);
    }

    /*
    question 5
     */

    public static String halfManEncoding(String s) {
        String newString = "";
        char current = ' ';
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            current = s.charAt(i);
            if (current == s.charAt(i + 1)) {
                count++;
            } else { //form the String
                newString = newString + current + count;
                count = 1;
                current = s.charAt(i + 1);
            }
        }
        //add the last char and count
        newString = newString + current + count;
        if (newString.length() == s.length())
            return s;
        return newString;
    }

    /*
    question 6
     */
    public static int[][] rotateMatrix(int[][] matrix, int n) {

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {

                int offset = i - first;
                int top = matrix[first][i];

                //left -> top
                matrix[first][i] = matrix[last - offset][first];

                //bottom->left
                matrix[last - offset][first] = matrix[last][last - offset];

                //right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                //top->right
                matrix[i][last] = top;

            }
        }
        return matrix;
    }

    /*
    question 7 todo write separate programme for this
     */
    public static void NullifyMatrix(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                row[i] = true;
                column[i] = true;
            }
        }

        for (int i = 0; i < row.length; i++) {

            if (row[i]) {
                nullifyRow(matrix, i);
            }

        }

        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }


    }

    private static void nullifyRow(int[][] matrix, int i) {
        for (int k = 0; k < matrix.length; k++) {
            matrix[i][k] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int j) {
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[k][j] = 0;
        }
    }


    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "--");
            }
            System.out.println();
        }


    }

    ;


    public static void main(String[] args) {
        boolean check = MyString.isUniqueCharacter("ABCD");
        System.out.println(check);

        String s = MyString.reversString("ABCD");
        System.out.println(s.toString());

        boolean r = MyString.isPermutation("ABCE", "ECAB");
        System.out.println(r);

        System.out.println(MyString.halfManEncoding("aaaabbcddd"));

    }

}
