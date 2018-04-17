public class StudentGroup {

    /**
     * FORMAT: xxx
     * 1st digit: pillar that student group belongs to (1,2...7)
     * (1 = FRESHMORE, 2 = ASD, 3 = EPD, 4 = ESD, 5 = ISTD, 6 = HASS, 7 = FRESHMORE_HASS)
     * 2nd digit: term that student group is in (1,2...8)
     * (1 = term 1, 2 = term 2 etc.)
     * 3rd digit: group number within batch (0,1,2...)
     * (0 = entire batch, 1 = group 1/ cohort 1, 2 = group 2/ cohort 2...)
     *
     * Examples:
     * 241: ASD student, term 4, cohort 1
     * 582: ISTD student, term 8, group 2 (of some subject)
     * 716: FRESHMORE_HASS student, term 1, group 6
     * 440: ESD student, term 4, entire batch
     */

    private final int studentGroupId;
    private final String studentGroupName; // "ASD Term 4 Cohort 1", "ISTD Term 8 Group 2"
    private final int studentGroupSize;
    private final int[] moduleIds; // only for groups having multiple core modules together in terms 1 - 5
    private final int[] studentIds;

    public StudentGroup(int studentGroupId, String studentGroupName, int studentGroupSize, int[] moduleIds, int[] studentIds) {
        this.studentGroupId = studentGroupId;
        this.studentGroupName = studentGroupName;
        this.studentGroupSize = studentGroupSize;
        this.moduleIds = moduleIds;
        this.studentIds = studentIds;
    }

    public int getStudentGroupId() {
        return studentGroupId;
    }

    public String getStudentGroupName() {
        return studentGroupName;
    }

    public int getStudentGroupSize() {
        return studentGroupSize;
    }

    public int[] getModuleIds() {
        return moduleIds;
    }

    public int[] getStudentIds() {
        return studentIds;
    }
}
