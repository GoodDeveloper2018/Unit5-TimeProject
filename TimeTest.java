public class TimeTest {
    public static void main(String[] args) {
        // Create a Time object and test toString()
        Time time1 = new Time(8, 9, 58);
        System.out.println("Initial time1: " + time1); // uses toString()

        // Test tick()
        time1.tick();
        System.out.println("After tick time1: " + time1);

        // Test accessor methods
        System.out.println("Hour: " + time1.getHour());
        System.out.println("Minute: " + time1.getMinute());
        System.out.println("Second: " + time1.getSecond());

        // Test multiple ticks to roll over minutes
        for (int i = 0; i < 3; i++) {
            time1.tick();
        }
        System.out.println("After multiple ticks time1: " + time1);

        // Create another Time object and test add()
        Time time2 = new Time(0, 50, 30);
        System.out.println("Initial time2: " + time2);

        time1.add(time2);
        System.out.println("After adding time2 to time1: " + time1);

        // Check accessor methods again after changes
        System.out.println("Hour after add: " + time1.getHour());
        System.out.println("Minute after add: " + time1.getMinute());
        System.out.println("Second after add: " + time1.getSecond());

        // Add enough time to roll over to next day
        Time time3 = new Time(10, 30, 40);
        time1.add(time3);
        System.out.println("After adding time3 to time1: " + time1);

        // Final check of all methods usage
        System.out.println("Final Hour: " + time1.getHour());
        System.out.println("Final Minute: " + time1.getMinute());
        System.out.println("Final Second: " + time1.getSecond());
        System.out.println("Final toString: " + time1.toString());
    }
}
