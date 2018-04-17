public class StartTime {
    private final int startTimeId; // 8AM = 800, 5PM = 1700
    private final float startTiming; // 8AM = 8.5, 5PM = 17.0

    public StartTime(int startTimeId, float startTiming) {
        this.startTimeId = startTimeId;
        this.startTiming = startTiming;
    }

    public int getStartTimeId() {
        return startTimeId;
    }


    public float getStartTiming() {
        return startTiming;
    }
}
