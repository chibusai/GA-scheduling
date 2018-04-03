import java.util.HashMap;

public class Timetable {
    private final HashMap<Integer, Location> locations;
    private final HashMap<Integer, CourseInstructor> instructors;
    private final HashMap<Integer, Subject> subjects;
    private final HashMap<Integer, Group> groups;
    private final HashMap<Integer, Timeslot> timeslots;
    private final HashMap<Integer, Student> students;
    private Lesson lessons[];

    private int numLessons = 0;

    public Timetable() {
        this.locations = new HashMap<Integer, Location>();
        this.instructors = new HashMap<Integer, CourseInstructor>();
        this.subjects = new HashMap<Integer, Subject>();
        this.groups = new HashMap<Integer, Group>();
        this.timeslots = new HashMap<Integer, Timeslot>();
        this.students = new HashMap<Integer, Student>();
    }

    public Timetable(Timetable cloneTimetable) {
        this.locations = cloneTimetable.getLocations();
        this.instructors = cloneTimetable.getInstructors();
        this.subjects = cloneTimetable.getSubjects();
        this.groups = cloneTimetable.getGroups();
        this.timeslots = cloneTimetable.getTimeslots();
        this.students = cloneTimetable.getStudents();
        this.lessons = cloneTimetable.getLessons();
        this.numLessons = cloneTimetable.getNumLessons();
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

    public HashMap<Integer, Student> getStudents() {
        return this.students;
    }

    public void addLocation(int locationId, String locationName, int capacity, LocationType type) {
        this.locations.put(locationId, new Location(locationId, locationName, capacity, type));
    }

    public void addInstructor(int instructorId, String fullName,  int subjectsTaught[]) {
        this.instructors.put(instructorId, new CourseInstructor(instructorId, fullName, subjectsTaught));
    }

    public void addSubject(int subjectId, String subjectName, int totalHours, Pillar pillar, int[] instructorIds){
        this.subjects.put(subjectId, new Subject(subjectId, subjectName, totalHours, pillar, instructorIds));
    }

    public void addGroup(int groupId, String groupName, int groupSize, int subjectIds[], int[] studentIds) {
        this.groups.put(groupId, new Group(groupId, groupName, groupSize, subjectIds, studentIds));
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
        return this.locations;
    }

    public Location getRandomLocation() {
        Object[] locationsArray = this.locations.values().toArray();
        Location location = (Location) locationsArray[(int) (locationsArray.length * Math.random())];
        return location;
    }

    public CourseInstructor getInstructor(int instructorId) {
        return (CourseInstructor) this.instructors.get(instructorId);
    }

    public Subject getSubject(int subjectId) {
        return (Subject) this.subjects.get(subjectId);
    }

    public int[] getGroupSubjects(int groupId) {
        Group group = (Group) this.groups.get(groupId);
        return group.getSubjectIds();
    }

    public Group getGroup(int groupId) {
        return (Group) this.groups.get(groupId);
    }

    public Group[] getGroupsAsArray() {
        return (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
    }

    public Timeslot getTimeslot(int timeslotId) {
        return (Timeslot) this.timeslots.get(timeslotId);
    }

    public Timeslot getRandomTimeslot() {
        Object[] timeslotsArray = this.timeslots.values().toArray();
        Timeslot timeslot = (Timeslot) timeslotsArray[(int) (timeslotsArray.length * Math.random())];
        return timeslot;
    }

    public Lesson[] getLessons() {
        return this.lessons;
    }

    public int getNumLessons() {
        if (this.numLessons > 0) {
            return this.numLessons;
        }

        int numLessons = 0;
        Group groups[] = (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
        for (Group group : groups) {
            numLessons += group.getSubjectIds().length;
        }
        this.numLessons = numLessons;

        return this.numLessons;
    }

    public int calculateClashes() {
        int clashes = 0;

        for (Lesson lesson1 : this.lessons) {

            // check location capacity
            int groupSize = this.getGroup(lesson1.getGroupId()).getGroupSize();
            int locationCapacity = this.getLocation(lesson1.getLocationId()).getLocationCapacity();

            if (groupSize > locationCapacity) {
                clashes++;
            }

            // check location availability
            for (Lesson lesson2 : this.lessons) {
                if (lesson1.getSubjectId() != lesson2.getSubjectId() && lesson1.getLocationId() == lesson2.getLocationId() && lesson1.getTimeslotId() == lesson2.getTimeslotId()) {
                    clashes++;
                    break;
                }
            }

            // check instructor availability
            for (Lesson lesson2 : this.lessons) {
                if (lesson1.getSubjectId() != lesson2.getSubjectId() && lesson1.getInstructorId() == lesson2.getInstructorId() && lesson1.getTimeslotId() == lesson2.getTimeslotId()) {
                    clashes++;
                    break;
                }
            }
        }
        return clashes;
    }


}
