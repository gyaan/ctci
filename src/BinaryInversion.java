/**
 * Created by lenskart on 22/03/2017.
 */
public class BinaryInversion {


    public static Long getBinaryInv(Long a) {
        Long temp = a;
        String binary = "";
        while (temp != 0) {

            int t;
            Long v = temp % 2;

            if (v == 0) {
                t = 1;
            } else {
                t = 0;
            }
            binary = t + binary;
            temp = temp / 2;
        }
        return Long.parseLong(binary);
    }

    public static Long getDecimal(Long binary) {

        Long number = Long.valueOf(0);
        Long i = Long.valueOf(0);
        Long temp = binary;

        while (temp != 0) {
            number = number + Long.valueOf((long) ((temp % 10) * Math.pow(2, i)));
            temp = temp / 10;
            i++;
        }
        return number;
    }


    public static void main(String[] args) {
        System.out.println(getDecimal(getBinaryInv(Long.valueOf(5000))));
    }
}
