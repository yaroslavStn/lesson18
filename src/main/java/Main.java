import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class Main {
    private static final int count = 5;

    public static void main(String[] args) {
        new Main().run(args);
    }

    private void run(String[] args) {


        BidiMap bidiMap = new TreeBidiMap();

        for (int i = 0; i < 10; i++) {
            String name = new Factory().randomCallLog().getName();
            bidiMap.put(i,name);
        }
         bidiMap = bidiMap.inverseBidiMap();

        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("key", "A");
        map.put("key", "B");
        map.put("key", "C5");
        map.put("ky", "C1");
        map.put("ky", "C2");
        Collection<String> coll = map.get("ky");


        try {
            int i = Integer.parseInt(args[0]);
            if (i < 1) throw new NumberFormatException();
            gsonRun(i);
            System.out.println("value 10");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect argument, default value: " + count);
            gsonRun(count);
        }

    }

    private void gsonRun(int i) {
        List<CallLog> callLogs = new Factory().createCallLogsList(i);
        Gson gson = new Gson();
        // task3
        CallLog in = new Factory().randomCallLog();
        String json = gson.toJson(in);
        CallLog callLog = gson.fromJson(json,CallLog.class);

        String toJson = gson.toJson(callLogs);
        Type collectionType = new TypeToken<Collection<CallLog>>(){}.getType();
        callLogs.clear();
        callLogs = gson.fromJson(toJson, collectionType);

    }

}
