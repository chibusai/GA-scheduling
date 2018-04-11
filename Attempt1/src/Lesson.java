public class Lesson {
    private final int lessonId;
    private int subjectId;
    private int instructorId;
    private int groupId;
    private int timeslotId;
    private int locationId;

    public Lesson(int lessonId, int session, int instructorId) {
        this.lessonId = lessonId;
        this.subjectId = subjectId;
        this.instructorId = instructorId;
        this.groupId = groupId;
    }

    public void addInstructor(int instructorId) {
        this.instructorId = instructorId;
    }

    public void addTimeslot(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getLessonId() {
        return this.lessonId;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public int getInstructorId() {
        return this.instructorId;
    }

    public int getTimeslotId() {
        return this.timeslotId;
    }

    public int getLocationId(){
        return this.locationId;
    }

}


