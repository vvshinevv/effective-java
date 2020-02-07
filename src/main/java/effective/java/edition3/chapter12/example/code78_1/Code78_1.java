package effective.java.edition3.chapter12.example.code78_1;

import java.util.concurrent.TimeUnit;

public class Code78_1 {

    private static boolean stopRequested;

    public static void main(String[] args) throws Exception {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
