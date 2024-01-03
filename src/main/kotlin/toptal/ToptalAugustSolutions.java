package toptal;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ToptalAugustSolutions {

    static int totalRemainingTime = 0;
    public static String solution4(int X) {
//        totalRemainingTime = X;
//        if (X < 0) {
//            return "";
//        } else if (X == 0) {
//            return "0s";
//        } else if x < 60 {
//            return
//        } else {
//            String form = "";
//            StringBuilder result = new StringBuilder();
//            result.append(getTime(totalRemainingTime, false));
//            result.append(getTime(totalRemainingTime, true));
//            return result.toString();
//        }
        return "";
    }

    private static String getTime(int X, boolean flag) {
        if ((X - 60 * 60 * 24 * 7) >= 0) {
            int time = X / (60 * 60 * 24 * 7);
            totalRemainingTime -= 60 * 60 * 24 * 7;
            return (time + "w" );
        } else if (X - 60 * 60 * 24 >= 0) {
            if (flag && (X - 60 * 60 * 24 > 0)) {
                int time = X / (60 * 60 * 24);
                totalRemainingTime -= 60 * 60 * 24;
                return ((time + 1) + "d" );
            } else {
                int time = X / (60 * 60 * 24);
                totalRemainingTime -= 60 * 60 * 24;
                return ((time) + "d" );
            }
        } else if (X - 60 * 60 >= 0) {
            if (flag && (X - 60 * 60 > 0)) {
                int time = X / (60 * 60);
                totalRemainingTime -= 60 * 60;
                return ((time + 1) + "h" );
            } else {
                int time = X / (60 * 60);
                return ((time) + "h" );
            }
        } else if (X - 60 >= 0) {
            if (flag && (X - 60 > 0)) {
                int time = X / (60);
                totalRemainingTime -= 60;
                return ((time + 1) + "m");
            } else {
                int time = X / (60);
                totalRemainingTime -= 60;
                return ((time) + "m" );
            }
        } else {
            return (X + "s");
        }
    }

    public static String[] solution2(String S, String[] B) {
        double[] billings = new double[B.length];
        double totalBill = 0;
        double excess = Double.parseDouble(S);
        for (int i = 0; i < B.length; i++) {
            billings[i] = Double.parseDouble(B[i]);
            totalBill += billings[i];
        }
        Arrays.sort(billings);

        double result = 0.0;
        for (int i = billings.length - 1; i >= 0; i--) {
            result = (billings[i] * excess) / totalBill;
            excess -= result;
            totalBill -= billings[i];
            B[i] = new DecimalFormat("####0.00").format(result);
        }
        return B;
    }

    public static int solution1(int X, int[] B, int Z) {
        if (B.length == 0 || Z == 0)
            return -1;

        double totalBytes = 0.0;
        for (int i = 0; i < B.length; i++) {
            totalBytes += B[i];
        }
        double remainingBytes = X - totalBytes;

        if (remainingBytes == 0)
            return 0;
        int averageRemainingTime = 0;
        int averageBytes = 0;

        if (Z > B.length) {
            averageBytes = (int) Math.ceil(totalBytes / B.length);
            averageRemainingTime = (int) Math.ceil(remainingBytes / averageBytes);
            return averageRemainingTime;
        }
        double averageZBytes = 0.0;
        for (int i = B.length - 1; i >= B.length - Z; i--) {
            averageZBytes += B[i];
        }

        averageBytes = (int) Math.ceil(averageZBytes / Z);
        averageRemainingTime = (int) Math.ceil(remainingBytes / averageBytes);

        return averageRemainingTime;
    }
}
