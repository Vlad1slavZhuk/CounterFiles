package App.CounterFile;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private ArrayList<String> list;
    private List<Thread> counterThread;
    private static boolean isInterrupt = false;

    public static boolean isInterrupt() {
        return isInterrupt;
    }

    public static void setInterrupt(boolean interrupt) {
        isInterrupt = interrupt;
    }

    public Controller(ArrayList<String> list) {
        this.list = list;
    }

    public void createThreadsAndStartToSearch() {
        try {
            int number = 1;
            counterThread = new ArrayList<>();
            for (String path : list) {
                counterThread.add(new Thread(new ThreadCounterFile(number, path), path));
                number++;
            }

            for (Thread thread : counterThread) {
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
