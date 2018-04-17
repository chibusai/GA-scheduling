public class Duration {
    private final int durationId; // 30 = 3 hours, 15 = 1.5 hours
    private float duration;

    public Duration(int durationId, float duration) {
        this.durationId = durationId;
        this.duration = duration;
    }

    public int getDurationId() {
        return durationId;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
