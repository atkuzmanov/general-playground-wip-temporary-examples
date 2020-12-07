package org.example;

import java.util.*;

/**
 * int [] = {1, 2, 3, 4, 5, 3, 2}
 * return duplicate number
 *
 * int x = 4;
 * return index of first number which is less than 'x'
 */
public class App {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 3, 2, 2};
        int x = 4;

        System.out.println(finDuplicates(arr, x));
    }


    public static ResultObj finDuplicates(final int[] arr, int x) {
//        arr = new int[]{1};
//        arr[0] = 1;
        List<Integer> resultList = new ArrayList<>();
        ResultObj resultObj = new ResultObj();
        if(arr == null) {
//            return resultList;
            return resultObj;
        }
        Set<Integer> dedup = new HashSet<>();
//        int[] result = new int[arr.length];

        Map<Integer, Integer> resultMap = new HashMap<>();


        Set<Integer> resultSet = new HashSet<>();

//        int resultPointer = 0;
//        for(int i = 0; i < arr.length; i++) {
//            if (dedup.contains(arr[i])) {
////                result[resultPointer++] = arr[i];
//                resultSet.add(arr[i]);
//            } else {
//                dedup.add(arr[i]);
//            }
//        }
////        result.stream().filter()



        for (int i = 0; i < arr.length; i++) {
            if(resultObj.indexOfX == -1 && arr[i] < x) {
                resultObj.indexOfX = i;
            }
//            if (resultMap.containsKey(arr[i])) {
            Integer value = resultMap.get(arr[i]);
            if (value != null) {
                resultMap.put(arr[i], value + 1);
                if (value == 1) {
                    resultList.add(arr[i]);
                }
            } else {
                resultMap.put(arr[i], 1);
            }
        }

//        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
//            if (entry.getValue() > 1) {
//                resultList.add(entry.getKey());
//            }
//        }

//        resultList = new ArrayList<>(resultSet);

//        return resultList;

        resultObj.duplicates = resultList;

        return resultObj;
    }
}

class ResultObj {
    public List<Integer> duplicates = new ArrayList<>();
    public int indexOfX = -1;

    ResultObj(){}

    ResultObj(List<Integer> dups, int xIndex) {
        duplicates = dups;
        indexOfX  = xIndex;
    }

    @Override
    public String toString() {
        return "Duplicates: " + duplicates + " | Index of X: " + indexOfX;
    }
}
