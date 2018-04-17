public class Venue {
    private final int venueId;
    private final String venueName;
    private final int capacity;
    private final VenueType venueType;

    public Venue(int venueId, String venueName, int capacity, VenueType venueType) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.capacity = capacity;
        this.venueType = venueType;
    }

    public int getVenueId() {
        return venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getCapacity() {
        return capacity;
    }

    public VenueType getVenueType() {
        return venueType;
    }
}
