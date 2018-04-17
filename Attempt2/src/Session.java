public class Session {
    private final int sessionId; // specific to module
    private final int professorId;
    private final int duration;
    private final VenueType venueType;

    public Session(int sessionId, int professorId, int duration, VenueType venueType) {
        this.sessionId = sessionId;
        this.professorId = professorId;
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

    public int getProfessorId() {
        return professorId;
    }
}
