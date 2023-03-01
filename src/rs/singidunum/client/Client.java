package rs.singidunum.client;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(new RequestSender());
            thread.start();
        }
    }
}
