public class Module {
    private final int moduleId;
    private final String moduleName;
    private final int[] sessionIds;
    private final int[] studentGroupIds;
    private final int[] professorIds;

    public Module(int moduleId, String moduleName, int[] sessionIds, int[] studentGroupIds, int[] professorIds) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.sessionIds = sessionIds;
        this.studentGroupIds = studentGroupIds;
        this.professorIds = professorIds;
    }

    public int getModuleId() {
        return moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int[] getSessionIds() {
        return sessionIds;
    }

    public int[] getStudentGroupIds() {
        return studentGroupIds;
    }

    public int[] getProfessorIds() {
        return professorIds;
    }
}
