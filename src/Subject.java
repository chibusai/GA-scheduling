import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Subject {
    private final int subjectId;
    private final String subjectName;
    private final float hoursPerWeek;
    private final HashMap facilityHours;
    private final float minimumHoursPerLesson;
    private final Date availablePeriod;
    private final Pillar pillar;
    private final int instructorIds[];

    public Subject(int subjectId, String subjectName, float hoursPerWeek, HashMap facilityHours, float minimumHoursPerLesson, Date availablePeriod, Pillar pillar, ArrayList<String> instructors, int[] instructorIds) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.hoursPerWeek = hoursPerWeek;
        this.facilityHours = facilityHours;
        this.minimumHoursPerLesson = minimumHoursPerLesson;
        this.availablePeriod = availablePeriod;
        this.pillar = pillar;
        this.instructorIds = instructorIds;
    }


    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public float getHoursPerWeek() {
        return hoursPerWeek;
    }

    public HashMap getFacilityHours() {
        return facilityHours;
    }

    public float getMinimumHoursPerLesson() {
        return minimumHoursPerLesson;
    }

    public Date getAvailablePeriod() {
        return availablePeriod;
    }

    public Pillar getPillar() {
        return pillar;
    }

    public int getRandomInstructorId() {
        int instructorId = instructorIds[(int) (instructorIds.length * Math.random())];
        return instructorId;
    }


}
