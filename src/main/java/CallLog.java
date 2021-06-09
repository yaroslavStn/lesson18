import java.util.Calendar;
import java.util.Objects;

public class CallLog {
    private String name;
    private String number;
    private Calendar date;
    private int duration;
    private Status status;

    public CallLog(String name, String number, Calendar date, int duration, Status status) {
        this.name = name;
        this.number = number;
        this.date = date;
        this.duration = duration;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public Calendar getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return name +
                number +
                date.getTime() +
                duration +
                status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallLog callLog = (CallLog) o;
        return Objects.equals(name, callLog.name) &&
                Objects.equals(number, callLog.number) &&
                Objects.equals(date, callLog.date) &&
                Objects.equals(duration, callLog.duration) &&
                status == callLog.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, date, duration, status);
    }
    public boolean equalsByDate (Calendar dateRequest) {
        return
                Objects.equals(dateRequest, this.date);

    }
}
