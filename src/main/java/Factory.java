import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Factory {

        private static final String[] names = {"vasia", "petya", "jake", "masha"};
        private static final String[] numbers = {"+111", "+222", "+333", "+444", "+555", "+666","+11", "+22", "+33", "+44", "+000", "+55", "+66", "+00"};
        private static Status[] status = Status.values();

        public CallLog randomCallLog (){
            int r = (int) (Math.random() * names.length);
            String randomName = names[r];
            r = (int) (Math.random() * numbers.length);
            String randomNumber = numbers[r];
            Status randomStatus = status[(int) (Math.random() * status.length)];
            r = (int) (Math.random() * 600);
            if (randomStatus == Status.missed) r = 0;
            Calendar randomDate = new GregorianCalendar(2021,
                    Calendar.APRIL,
                    (int) (Math.random() * 30),
                    (int) (Math.random() * 24),
                    (int) (Math.random() * 60),
                    (int) (Math.random() * 60));

            return  (new CallLog(
                    randomName,
                    randomNumber,
                    randomDate,
                    r,
                    randomStatus));
        }

    public List<CallLog> createCallLogsList(int num) {
        List<CallLog> result = new ArrayList<>();
        for (int i = 0; i < num; i++) result.add(randomCallLog());
        return result;
    }


}
