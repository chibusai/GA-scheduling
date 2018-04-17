public class Session {
    private final int sessionId;
    private final int duration;
    private final VenueType venueType;

    public Session(int sessionId, int duration, VenueType venueType) {
        this.sessionId = sessionId;
        this.duration = duration;
        this.venueType = venueType;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getDuration() {
        return duration;
    }

    public VenueType getVenueType() {
        return venueType;
    }
}
