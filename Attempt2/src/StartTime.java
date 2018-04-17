public class StartTime {
    private final int startTimeId;
    private final int startTiming;
    private final int endTiming;

    public StartTime(int startTimeId, int startTiming, int endTiming) {
        this.startTimeId = startTimeId;
        this.startTiming = startTiming;
        this.endTiming = endTiming;
    }

    public int getStartTimeId() {
        return startTimeId;
    }


    public int getStartTiming() {
        return startTiming;
    }

    public int getEndTiming() {
        return endTiming;
    }
}
