import java.util.HashMap;

public class Timetable {
    private final HashMap<Integer, Location> locations;
    private final HashMap<Integer, CourseInstructor> instructors;
    private final HashMap<Integer, Subject> subjects;
    private final HashMap<Integer, Group> groups;
    private final HashMap<Integer, Timeslot> timeslots;
    private Lesson lessons[];

    private int numLessons = 0;

    public Timetable(HashMap<Integer, Location> locations, HashMap<Integer, CourseInstructor> instructors, HashMap<Integer, Subject> subjects, HashMap<Integer, Group> groups, HashMap<Integer, Timeslot> timeslots, Lesson[] lessons, int numLessons) {
        this.locations = locations;
        this.instructors = instructors;
        this.subjects = subjects;
        this.groups = groups;
        this.timeslots = timeslots;
        this.lessons = lessons;
        this.numLessons = numLessons;
    }

    public HashMap<Integer, CourseInstructor> getInstructors() {
        return instructors;
    }

    public HashMap<Integer, Subject> getSubjects() {
        return subjects;
    }

    public HashMap<Integer, Group> getGroups() {
        return groups;
    }

    public HashMap<Integer, Timeslot> getTimeslots() {
        return timeslots;
    }

    public void addLocation(int locationId, String locationName, int capacity, LocationType type) {
        this.locations.put(locationId, new Location(locationId, locationName, capacity, type));
    }

    public void addInstructor(int instructorId, String fullName,  String subjectsTaught[]) {
        this.instructors.put(instructorId, new CourseInstructor(instructorId, fullName, subjectsTaught));
    }

    public void addGroup(int groupId, String groupName, int groupSize, int subjectIds[]) {
        this.groups.put(groupId, new Group(groupId, groupName, groupSize, subjectIds));
        this.numLessons = 0;
    }

    public void addTimeslot(int timeslotId, String timeslotName) {
        this.timeslots.put(timeslotId, new Timeslot(timeslotId,timeslotName));
    }

    public void createLessons(Individual individual) {

        Lesson lessons[] = new Lesson[this.getNumLessons()];

        int chromosome[] = individual.getChromosome();
        int chromosomeLocus = 0;
        int lessonIndex = 0;

        for (Group group : this.getGroupsAsArray()) {
            int subjectIds[] = group.getSubjectIds();
            for (int subjectId : subjectIds) {
                lessons[lessonIndex] = new Lesson(lessonIndex, group.getGroupId(), subjectId);

                // add time slot
                lessons[lessonIndex].addTimeslot(chromosome[chromosomeLocus]);
                chromosomeLocus++;

                // add location
                lessons[lessonIndex].setLocationId(chromosome[chromosomeLocus]);
                chromosomeLocus++;

                // add instructor
                lessons[lessonIndex].addInstructor(chromosome[chromosomeLocus]);
                chromosomeLocus++;

                lessonIndex++;
            }
        }

        this.lessons = lessons;
    }

    public Location getLocation(int locationId) {
        if (!this.locations.containsKey(locationId)) {
            System.out.println(locationId + " is not within premise.");
        }
        return (Location) this.locations.get(locationId);
    }

    public HashMap<Integer, Location> getLocations() {
        return locations;
    }

    public Location getRandomLocation() {
        Object[] locationsArray = this.locations.values().toArray();
        Location location = (Location) locationsArray[(int) (locationsArray.length * Math.random())];
        return location;
    }

    public CourseInstructor getInstructor(int instructorId) {
        
    }

    public int getNumLessons() {
        return numLessons;
    }

    public Group[] getGroupsAsArray() {

    }

    public Timeslot getRandomTimeslot() {

    }



    public Subject getSubject(int subjectId) {
    }
}
