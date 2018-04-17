public class Professor {
    private final int professorId;
    private final String professorName;
    private final int[] moduleIds;

    public Professor(int professorId, String professorName, int[] moduleIds) {
        this.professorId = professorId;
        this.professorName = professorName;
        this.moduleIds = moduleIds;
    }

    public int getProfessorId() {
        return professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public int[] getModuleIds() {
        return moduleIds;
    }
}
