public class Timer {
    private long time;
    private long startTime;

    public Timer (long t) {
        time = t;
    }

    public void start () {
        startTime = System.currentTimeMillis();
    }

    public boolean isActive () {
        if (System.currentTimeMillis() - startTime > time) {
            return false;
        } else {
            return true;
        }
    }
}