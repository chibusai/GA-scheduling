public class StartTime {
    private final int startTimeId; // 8AM = 800, 5PM = 1700
    private final float startTiming; // 8AM = 8.5, 5PM = 17.0

    private float duration; // to be read from class[4]
    private float endTiming; // to be calculated based on duration given

    public StartTime(int startTimeId, float startTiming, float duration, float endTiming) {
        this.startTimeId = startTimeId;
        this.startTiming = startTiming;
        this.duration = duration;
        this.endTiming = endTiming;
    }

    public int getStartTimeId() {
        return startTimeId;
    }

    public float getStartTiming() {
        return startTiming;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = ;
    }

    public float getEndTiming() {
        return endTiming;
    }

    public void setEndTiming(float endTiming) {
        this.endTiming = startTiming + duration;
    }


}
