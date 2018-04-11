import java.util.Date;
import java.util.HashMap;

public class Scheduler {

    public static void main(String[] args) {
        Timetable timetable = uploadTermInfo();
    }

    private static Timetable uploadTermInfo() {
        Timetable timetable = new Timetable();

        /*

         */
        /* *
         * Set up locations
         * locationId = int form of location code
         */
        timetable.addLocation(2506, "Cohort Classroom 13", 50, LocationType.COHORT_CLASSROOM);
        timetable.addLocation(2505, "Lecture Theatre 5", 60, LocationType.LECTURE_THEATRE);

        /* *
         * Set up time slots (each half an hour)
         * 1st digit - day of week (e.g. 1 = Monday)
         * 2nd and 3rd digit - Nth slot of the day, from 0830 to 1800
         */
        timetable.addTimeslot(101, "Monday 0830 - 0900");
        timetable.addTimeslot(304, "Wednesday 1000 - 1030");

        /* *
         * Set up instructors
         * instructorId: random for now
         */
        timetable.addInstructor(5, "Dr Christine Anne Habbard", new int[] {2003,2109});
        timetable.addInstructor(13, "Dr Sudiptac Chattopadhyay", new int[] {50003});

        /* *
         * Set up subjects
         */
        timetable.addSubject(10001, "Advanced Math I", 7, Pillar.FRESHMORE, new int[] {32,24,26});

        return timetable;
    }
}
