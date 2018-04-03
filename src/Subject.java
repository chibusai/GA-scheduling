import java.util.HashMap;

public class Subject {
    private final int subjectId;
    private final String subjectName;
    private final int totalHours;
//    private final HashMap venueAndDuration;
    private final Pillar pillar;
    private final int instructorIds[];

    public Subject(int subjectId, String subjectName, int totalHours, Pillar pillar, int[] instructorIds) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.totalHours = totalHours;
//        this.venueAndDuration = venueAndDuration;
        this.pillar = pillar;
        this.instructorIds = instructorIds;
    }


    public int getSubjectId() {
        return this.subjectId;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

//    public HashMap getVenueAndDuration() {
//        return this.venueAndDuration;
//    }

    public Pillar getPillar() {
        return this.pillar;
    }

    public int getRandomInstructorId() {
        return instructorIds[(int) (instructorIds.length * Math.random())];
    }


    public int getTotalHours() {
        return totalHours;
    }
}
