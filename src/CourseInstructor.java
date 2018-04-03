public class CourseInstructor{
    private final String fullName;
    private final int instructorId;
    private final int subjectsTaught[];

    public CourseInstructor(int instructorId, String fullName, int[] subjectsTaught) {
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

    public int[] getSubjectsTaught() {
        return subjectsTaught;
    }
}
