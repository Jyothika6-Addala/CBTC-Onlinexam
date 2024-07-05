public class Timer {
    private long duration; // duration in milliseconds
    private long endTime;
    private boolean timeUp = false;
    public Timer(long duration) {
        this.duration = duration;
    }
    public void start() {
        endTime = System.currentTimeMillis() + duration;
        new Thread(() -> {
            try {
                Thread.sleep(duration);
                timeUp = true;
                System.out.println("Time is up!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public boolean isTimeUp() {
        return timeUp;
    }
}
