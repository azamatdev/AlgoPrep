package toptal;

import java.util.Arrays;

public class ToptalJuly {

    public static int solution(int[] A) {
        double totalPollution = 0.0;
        double[] B = new double[A.length];

        for (int i = 0; i < A.length; i++) {
            totalPollution += A[i];
            B[i] = A[i];
        }
        Arrays.sort(B);
        int lastIndex = B.length - 1;
        double half = totalPollution / 2.0;

        int count = 0;
        while (totalPollution > half) {
            B[lastIndex] = B[lastIndex] / 2.0;
            totalPollution -= B[lastIndex];
//
            for (int i = B.length - 1; i >= 0; i--) {
                if (B[i] < B[i - 1]) {
                    double temp = B[i];
                    B[i] = B[i - 1];
                    B[i - 1] = temp;
                } else break;
            }
            count++;
        }
        return count;
    }

    public static int solution2(int[] P, int[] S) {
        int totalP = 0;
        for (int i = 0; i < P.length; i++) {
            totalP += P[i];
        }
        Arrays.sort(S);
        int count = 0;
        for (int i = S.length - 1; i >= 0; i--) {
            if (totalP > 0) {
                totalP -= S[i];
                count++;
            } else break;
        }
        return count;
    }

    public static String solution3(String message, int K) {
        if (message.length() <= K) {
            return message;
        }
        if (message.charAt(K) == ' ')
            return message.substring(0, K);

        for (int i = K - 1; i >= 0; i--) {
            if (message.charAt(i) == ' ') {
                return message.substring(0, i);
            }
        }
        return message;
    }

}
