public class Group {

    /*
    Freshmore: 10xx
    ASD: 20xx
    EPD: 30xx
    ESD: 40xx
    ISTD: 50xx
    HASS: 2xx
     */
    private final int groupId;
    private final String groupName; // ISTD_C01, F04
    private final int groupSize;
    private final int subjectIds[];
    private int[] studentIds;

    public Group(int groupId, String groupName, int groupSize, int[] subjectId, int[] studentIds) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupSize = groupSize;
        this.subjectIds = subjectId;
        this.studentIds = studentIds;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public int[] getSubjectIds() {
        return subjectIds;
    }

    public int getGroupId() {
        return groupId;
    }
}
