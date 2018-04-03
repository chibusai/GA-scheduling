public class Student{
    private final String fullName;
    private final int studentId;
    private final Pillar pillar;
    private final Year year;
    private final int cohortClass;
    private final String subjectsTaken[];


    public Student(String fullName, int studentId, Pillar pillar, Year year, int cohortClass, String[] subjectsTaken) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.pillar = pillar;
        this.year = year;
        this.cohortClass = cohortClass;
        this.subjectsTaken = subjectsTaken;
    }

    public String getFullName() {
        return fullName;
    }


    public String[] getSubjectsTaken() {
        return subjectsTaken;
    }

    public int getCohortClass() {
        return cohortClass;
    }

    public Year getYear() {
        return year;
    }

    public Pillar getPillar() {
        return pillar;
    }

    public int getStudentId() {
        return studentId;
    }
}
