public class CourseInstructor{
    private final String fullName;
    private final int instructorId;
    private final String subjectsTaught[];

    public CourseInstructor(int fullName, String instructorId, String[] subjectsTaught) {
        this.fullName = fullName;
        this.instructorId = instructorId;

        this.subjectsTaught = subjectsTaught;
    }

    public String getFullName() {
        return fullName;
    }


    public int getInstructorId() {
        return instructorId;
    }

    public String[] getSubjectsTaught() {
        return subjectsTaught;
    }
}
