public class Lesson {
    private final int lessonId;
    private String lessonName; // e.g. CBL1, LT2, Lab
    private final int session;
    private String subjectId;
    private int instructorId;
    private String groupName;
    private int timeslotId;
    private int locationId;

    public Lesson(int lessonId, int session, int instructorId) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.session = session;
        this.subjectId = subjectId;
        this.instructorId = instructorId;
        this.groupName = groupName;
    }

    public String getLessonName() {
        return lessonName;
    }

    public int getSession() {
        return session;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void addTimeslot(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public int getTimeslotId() {
        return timeslotId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public void addInstructor(int instructorId) {
        this.instructorId = instructorId;
    }
}


