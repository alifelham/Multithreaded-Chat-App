import java.util.Scanner;

public class chatThread extends Thread {
    String flag = "a"; //the chat begins with a
    int users = 3;     //number of users

    public synchronized void speakerA() throws InterruptedException {

        if (!flag.equals("a")) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (flag.equals("a")) {
            Scanner inpA = new Scanner(System.in);
            System.out.print("a: ");
            String msgA = inpA.nextLine();
            if (msgA.equalsIgnoreCase("stop")) {
                users -= 1;
                currentThread().interrupt();
            } else {
                String[] partsA = msgA.split("@");
                flag = partsA[1].toLowerCase().trim();
            }
            notifyAll();
        }
    }

    public synchronized void speakerB() throws InterruptedException {
        if (!flag.equals("b")) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (flag.equals("b")) {
            Scanner inpB = new Scanner(System.in);
            System.out.print("b: ");
            String msgB = inpB.nextLine();

            if (msgB.equalsIgnoreCase("stop")) {
                users -= 1;
                currentThread().interrupt();
            } else {
                String[] partsB = msgB.split("@");
                flag = partsB[1].toLowerCase().trim();
            }
            notifyAll();
        }
    }

    public synchronized void speakerC() throws InterruptedException {
        if (!flag.equals("c")) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (flag.equals("c")) {
            Scanner inpC = new Scanner(System.in);
            System.out.print("c: ");
            String msgC = inpC.nextLine();

            if (msgC.equalsIgnoreCase("stop")) {
                users -= 1;
                currentThread().interrupt();
            } else {
                String[] partsC = msgC.split("@");
                flag = partsC[1].toLowerCase().trim();
            }
            notifyAll();
        }
    }
}
