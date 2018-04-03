public class Location {
    private final int locationId; // 1.207 becomes 1207
    private final String locationName;
    private final int capacity;
    private final LocationType type;

    /**
     * Initialize new Location (e.g. think tanks, classrooms, lecture theaters)
     * @param locationId e.g. 2.107, 1.512
     * @param locationName e.g. Lecture Theater 1, Cohort Classroom 7
     * @param capacity e.g. 40 pax, 500 pax
     * @param type
     */
    public Location(int locationId, String locationName, int capacity, LocationType type) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.capacity = capacity;
        this.type = type;
    }

    /**
     * Return locationId
     * @return locationId
     */
    public int getLocationId() {
        return this.locationId;
    }

    /*
    Return locationName
    @return locationName
     */
    public String getLocationName() {
        return this.locationName;
    }

        /*
    Return capacity
    @return capacity
     */
    public int getLocationCapacity() {
        return this.capacity;
    }
}
