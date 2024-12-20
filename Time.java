import java.text.DecimalFormat;

/**
 * The Time class represents a time in 24-hour format (military time),
 * with hours ranging from 00 to 23, minutes and seconds from 00 to 59.
 */
public class Time {

    private int hour;   // 0-23
    private int minute; // 0-59
    private int second; // 0-59

    /**
     * Constructs a new Time object with the specified hour, minute, and second.
     */
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * Advances this time by one second, adjusting for minute and hour rollover.
     */
    public void tick() {
        second++;
        if (second == 60) {
            second = 0;
            minute++;
            if (minute == 60) {
                minute = 0;
                hour++;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
    }

    /**
     * Adds the specified Time object's hours, minutes, and seconds to this time,
     * with time rollover at 60 seconds, 60 minutes, and 24 hours.
     */
    public void add(Time other) {
        this.second += other.second;
        if (this.second >= 60) {
            this.second -= 60;
            this.minute++;
        }

        this.minute += other.minute;
        if (this.minute >= 60) {
            this.minute -= 60;
            this.hour++;
        }

        this.hour += other.hour;
        if (this.hour >= 24) {
            this.hour %= 24;
        }
    }

    /**
     * Returns the time as a string in HH:MM:SS format, also zero-padded
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("00");
        return df.format(hour) + ":" + df.format(minute) + ":" + df.format(second);
    }

    /**
     * Returns the current hour (0-23).
     */
    public int getHour() {
        return hour;
    }

    /**
     * Returns the current minute (0-59).
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Returns the current second (0-59).
     */
    public int getSecond() {
        return second;
    }
}
