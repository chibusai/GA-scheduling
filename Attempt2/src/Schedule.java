import java.util.HashMap;

public class Schedule {
    private final HashMap<Integer, Module> modules;
    private final HashMap<Integer, Session> sessions;
    private final HashMap<Integer, StudentGroup> studentGroups;
    private final HashMap<Integer, Professor> professors;
    private final HashMap<Integer, Duration> durations;
    private final HashMap<Integer, Venue> venues;
    private final HashMap<Integer, StartTime> startTimes;

    public Schedule(HashMap<Integer, Module> modules, HashMap<Integer, Session> sessions, HashMap<Integer, StudentGroup> studentGroups, HashMap<Integer, Professor> professors, HashMap<Integer, Duration> durations, HashMap<Integer, Venue> venues, HashMap<Integer, StartTime> startTimes) {
        this.modules = modules;
        this.sessions = sessions;
        this.studentGroups = studentGroups;
        this.professors = professors;
        this.durations = durations;
        this.venues = venues;
        this.startTimes = startTimes;
    }

    public Schedule() {
        this.modules = new HashMap<Integer, Module>();
        this.sessions = new HashMap<Integer, Session>();
        this.studentGroups = new HashMap<Integer, StudentGroup>();
        this.professors = new HashMap<Integer, Professor>();
        this.durations = new HashMap<Integer, Duration>();
        this.venues = new HashMap<Integer, Venue>();
        this.startTimes = new HashMap<Integer, StartTime>();
    }

    public HashMap<Integer, Venue> getVenues() {
        return venues;
    }

    public HashMap<Integer, StartTime> getStartTimes() {
        return startTimes;
    }

    public void addVenue(int venueId, String venueName, int capacity, VenueType venueType) {
        this.venues.put(venueId, new Venue(venueId, venueName, capacity, venueType));
    }

    public void addStartTime(int startTimeId, float startTiming) {
        this.startTimes.put(startTimeId, new StartTime(startTimeId, startTiming));
    }

    public void createLessons(Chromosome chromosome) {

        // Array of lessons derived from individuals's chromosome

    }
}
