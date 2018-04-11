public class Student{
    private final String fullName;
    private final int studentId;
    private final Pillar pillar;
    private final Year year;
    private final int cohortClass;
    private final String subjectsTaken[];
    private final int groupId;


    public Student(String fullName, int studentId, Pillar pillar, Year year, int cohortClass, String[] subjectsTaken, int groupId) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.pillar = pillar;
        this.year = year;
        this.cohortClass = cohortClass;
        this.subjectsTaken = subjectsTaken;
        this.groupId = groupId;
    }

    public String getFullName() {
        return this.fullName;
    }


    public String[] getSubjectsTaken() {
        return this.subjectsTaken;
    }

    public int getCohortClass() {
        return this.cohortClass;
    }

    public Year getYear() {
        return this.year;
    }

    public Pillar getPillar() {
        return this.pillar;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public int getGroupId() {
        return this.groupId;
    }
}
