package org.example;


// import java.io.*;
import java.util.Map;
import java.util.*;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Uber interview 2020-12-14-1616
 *
 */
public class App {
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//    }
}



// Implement Timestamp Dictionary
// put value for key
// get latest value for a given key
// get value which is active in a certain point in time
// - Traverse all values and check if it contains the searched value at a point in time / Min Heap
//
// put k1, b (at 2014)
// put k1. c (at 2016)
// get (k1, at 2015) -> b
// get (k1, at 2013) -> null
// get (k1, at 2016) -> c
// get (k1, at 2019) -> c
// k1 -> String
// Obj -> k -> [ {value, timestamps}, ... ]
// ---
// -- example: current dict state: ["k1", "2014-10-10-1055"]
// input ["k1", "2015"] -->
// - Value is not present
class Solution {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        long millis = System.currentTimeMillis() % 1000;

        String millisString = Long.toString(millis);

        TimestampDictionary tsd = new TimestampDictionary();
        tsd.put("k1", "b", 2L);
        tsd.put("k1", "c", 3L);
        tsd.put("k2", "a", 3L);

        System.out.println(tsd.getLatest("k1"));
        System.out.println(tsd.getAt("k1", 1L));
        System.out.println(tsd.getAt("k1", 2L));
        System.out.println(tsd.getAt("k1", 3L));
        System.out.println(tsd.getAt("k1", 4L));

         System.out.println(tsd.getLatest("k2"));
         System.out.println(tsd.getAt("k2", 1L));
         System.out.println(tsd.getAt("k2", 2L));
         System.out.println(tsd.getAt("k2", 3L));
         System.out.println(tsd.getAt("k2", 4L));

         /*
         Current output:
         Hello, World
            c
            null
            b
            c
            c
            a
            null
            null
            a
            a
          */
    }
}

class TimestampDictionary {
    // todo: exception handling etc.
    Map<String, String> timeStampMap = new TreeMap<>();
    List<EventEntity> eventList = new ArrayList<>();

    // todo: default constructor?

    public void put(final String key, final String value, final long t) {
        timeStampMap.put(key, value);
        // long timeStamp = System.currentTimeMillis() % 1000;
        long timeStamp = t;
        eventList.add(new EventEntity(key, value, timeStamp));
    }

    // todo: unhappy path unit testing
    public String getAt(final String key, final long pointInTime) {
        if(timeStampMap.containsKey(key)) {
            // String searched = timeStampMap.get(key); // latest
            String searched = null;
            for(EventEntity e : eventList) {
                if(e.timeStamp <= pointInTime && e.key.equals(key)) {
                    searched = e.value;
                }
            }
            return searched;
        } else {
            return null;
        }
    }

    public String getLatest(final String key) {
        return timeStampMap.get(key);
    }
}

class EventEntity {
    // todo: concurrency / atomic ?
    // private
    String key;
    String value;
    Long timeStamp;

    public EventEntity(String k, String v, Long t) {
        this.key = k;
        this.value = v;
        this.timeStamp = t;
    }

    //
}

