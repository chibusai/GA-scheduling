import java.util.HashMap;

public class Schedule {
    private final HashMap<Integer, Venue> venues;
    private final HashMap<Integer, StartTime> startTimes;

    public Schedule(HashMap<Integer, Venue> venues, HashMap<Integer, StartTime> startTimes) {
        this.venues = venues;
        this.startTimes = startTimes;
    }

    public Schedule() {
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

    public void addStartTime()
}
