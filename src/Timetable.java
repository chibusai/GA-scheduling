import java.util.HashMap;

/**
 * A timetable is a base case or potential solution to the scheduling problem.
 * Timetable class reads a chromosome (info, preferences), develops a base case from it,
 * and evaluates the generated base case for fitness and number of clashes.
 *
 * Key methods: createLessons and calculateClashes
 *
 * createLessons takes in an Individual, reads its chromosome and creates Lesson objects
 * from the genetic information. The Lesson objects contain information about the lessons
 * with getters and are easier to work with than the chromosome directly.
 *
 * calculateClashes is used by Algorithm.calculateFitness and requires createLessons to be
 * run first, then calculates how many hard constraints have been violated.
 */
public class Timetable {
    private final HashMap<Integer, Location> locations;
    private final HashMap<Integer, CourseInstructor> instructors;
    private final HashMap<Integer, Subject> subjects;
    private final HashMap<Integer, Group> groups;
    private final HashMap<Integer, Timeslot> timeslots;
    private final HashMap<Integer, Student> students;
    private Lesson lessons[];

    private int numLessons = 0;

    /**
     * Initialize a timetable (empty)
     */
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

    /**
     * Add new location
     * @param locationId
     * @param locationName
     * @param capacity
     * @param type
     */
    public void addLocation(int locationId, String locationName, int capacity, LocationType type) {
        this.locations.put(locationId, new Location(locationId, locationName, capacity, type));
    }

    /**
     * Add new course instructor
     * @param instructorId
     * @param fullName
     * @param subjectsTaught
     */
    public void addInstructor(int instructorId, String fullName,  int subjectsTaught[]) {
        this.instructors.put(instructorId, new CourseInstructor(instructorId, fullName, subjectsTaught));
    }

    /**
     * Add new subject
     * @param subjectId
     * @param subjectName
     * @param totalHours
     * @param pillar
     * @param instructorIds
     */
    public void addSubject(int subjectId, String subjectName, int totalHours, Pillar pillar, int[] instructorIds){
        this.subjects.put(subjectId, new Subject(subjectId, subjectName, totalHours, pillar, instructorIds));
    }

    /**
     * Add new group of students
     * @param groupId
     * @param groupName
     * @param groupSize
     * @param subjectIds
     * @param studentIds
     */
    public void addGroup(int groupId, String groupName, int groupSize, int subjectIds[], int[] studentIds) {
        this.groups.put(groupId, new Group(groupId, groupName, groupSize, subjectIds, studentIds));
        this.numLessons = 0;
    }

    /**
     * Add new time slots for lessons
     * @param timeslotId
     * @param timeslotName
     */
    public void addTimeslot(int timeslotId, String timeslotName) {
        this.timeslots.put(timeslotId, new Timeslot(timeslotId,timeslotName));
    }

    /**
     * From an Individual, take its chromosome, unpack it into an array of Lesson objects.
     * The Lesson objects will later be evaluated by calculateClashes for conflicting locations,
     * time slots, instructors etc.
     *
     * @param individual
     */
    public void createLessons(Individual individual) {

        // Array of lessons that will be derived from Individual's chromosome
        Lesson lessons[] = new Lesson[this.getNumLessons()];

        // Unpack an Individual's chromosome
        int chromosome[] = individual.getChromosome();
        int chromosomeLocus = 0;
        int lessonIndex = 0;

        for (Group group : this.getGroupsAsArray()) {
            int subjectIds[] = group.getSubjectIds();
            for (int subjectId : subjectIds) {
                lessons[lessonIndex] = new Lesson(lessonIndex, group.getGroupId(), subjectId);

                // add time slot from first locus of chromosome
                lessons[lessonIndex].addTimeslot(chromosome[chromosomeLocus]);
                chromosomeLocus++;

                // add location from second locus of chromosome
                lessons[lessonIndex].setLocationId(chromosome[chromosomeLocus]);
                chromosomeLocus++;

                // add instructor from third locus of chromosome
                lessons[lessonIndex].addInstructor(chromosome[chromosomeLocus]);
                chromosomeLocus++;

                lessonIndex++;
            }
        }

        this.lessons = lessons;
    }

    /**
     * Get location from locationId
     * @param locationId
     * @return location
     */
    public Location getLocation(int locationId) {
        if (!this.locations.containsKey(locationId)) {
            System.out.println(locationId + " is not within premise.");
        }
        return (Location) this.locations.get(locationId);
    }

    public HashMap<Integer, Location> getLocations() {
        return this.locations;
    }

    /**
     * Get a random location
     * @return location
     */
    public Location getRandomLocation() {
        Object[] locationsArray = this.locations.values().toArray();
        Location location = (Location) locationsArray[(int) (locationsArray.length * Math.random())];
        return location;
    }

    /**
     * Get course instructor from instructorId
     * @param instructorId
     * @return instructor
     */
    public CourseInstructor getInstructor(int instructorId) {
        return (CourseInstructor) this.instructors.get(instructorId);
    }

    /**
     * Get subject from subjectId
     * @param subjectId
     * @return subject
     */
    public Subject getSubject(int subjectId) {
        return (Subject) this.subjects.get(subjectId);
    }

    /**
     * Get subjectIds of a certain student group (e.g. ISTD Junior Cohort 1)
     * @param groupId
     * @return subjectId array
     */
    public int[] getGroupSubjects(int groupId) {
        Group group = (Group) this.groups.get(groupId);
        return group.getSubjectIds();
    }

    /**
     * Get student group from groupId
     * @param groupId
     * @return group
     */
    public Group getGroup(int groupId) {
        return (Group) this.groups.get(groupId);
    }

    /**
     * Get array of all student groups
     * @return array of groups
     */
    public Group[] getGroupsAsArray() {
        return (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
    }

    /**
     * Get time slot by timeslotId
     * @param timeslotId
     * @return time slot
     */
    public Timeslot getTimeslot(int timeslotId) {
        return (Timeslot) this.timeslots.get(timeslotId);
    }

    /**
     * Get a random time slot
     * @return time slot
     */
    public Timeslot getRandomTimeslot() {
        Object[] timeslotsArray = this.timeslots.values().toArray();
        Timeslot timeslot = (Timeslot) timeslotsArray[(int) (timeslotsArray.length * Math.random())];
        return timeslot;
    }

    /**
     * Get array of all lessons
     * @return array of lessons
     */
    public Lesson[] getLessons() {
        return this.lessons;
    }

    /**
     * Get number of lessons to be scheduled in a week
     * @return number of lessons
     */
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

    /**
     * createLessons has to be run first to populate this.lessons.
     *
     * calculateClashes method will evaluate and return the number of conflicts between the lessons
     * and the return value will be used by Algorithm.calculateFitness.
     *
     * @return number of clashes
     */
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
