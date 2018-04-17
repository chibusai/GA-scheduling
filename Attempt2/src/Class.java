public class Class {

    /**
     * fixed parameters
     */
    private final int classId;
    private final int sessionId;
    private final int studentGroupId;
    private final int professorId;
    private final int durationId;

    /**
     * variable parameters
     */
    private int venueId;
    private int startTimeId;

    public Class(int classId, int sessionId, int studentGroupId, int professorId, int durationId, int venueId, int startTimeId) {
        this.classId = classId;
        this.sessionId = sessionId;
        this.studentGroupId = studentGroupId;
        this.professorId = professorId;
        this.durationId = durationId;
        this.venueId = venueId;
        this.startTimeId = startTimeId;
    }


    public int getClassId() {
        return classId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getStudentGroupId() {
        return studentGroupId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public int getDurationId() {
        return durationId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getStartTimeId() {
        return startTimeId;
    }

    public void setStartTimeId(int startTimeId) {
        this.startTimeId = startTimeId;
    }
}
