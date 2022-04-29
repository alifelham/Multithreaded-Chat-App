public class chatDriver {
    public static void main(String[] args) {
        chatThread m = new chatThread();
        new chatT1(m);
        new chatT2(m);
        new chatT3(m);
    }
}
