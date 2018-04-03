public class Timeslot {
    private final int timeslotId; // 101 for Monday 8:30AM-9:00AM
    private final String timeslotName;

    public Timeslot(int timeslotId, String timeslotName) {
        this.timeslotId = timeslotId;
        this.timeslotName = timeslotName;
    }

    public String getTimeslotName() {
        return timeslotName;
    }

    public int getTimeslotId() {
        return timeslotId;
    }
}
