package meteordevelopment.meteorclient.utils.misc;

public class PanicState {
    private static boolean panicMode = false;

    public static boolean isPanicMode() {
        return panicMode;
    }

    public static void setPanicMode(boolean value) {
        panicMode = value;
    }
}
