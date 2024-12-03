package aoc.day01;

import aoc.Day;
import aoc.Utils;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class Day01 implements Day {

    @Override
    public String part1(String input) {
        String[] lines = input.split("\n");
        
        int[] list1 = new int[lines.length];
        int[] list2 = new int[lines.length];
        
        for (int i = 0; i < lines.length; i++) {
            String[] pair = lines[i].split("\\s+");
            list1[i] = Integer.parseInt(pair[0]);
            list2[i] = Integer.parseInt(pair[1]);
        }

        Arrays.sort(list1);
        Arrays.sort(list2);

        int runningSum = 0;
        for (int i = 0; i < list1.length; i++) {
            runningSum += Math.abs(list2[i] - list1[i]);
        }

        return String.valueOf(runningSum);
    }

    @Override
    public String part2(String input) {
        return input;
    }
        String[] lines = input.split("\n");

        int[] leftIds = new int[lines.length];
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for (int i = 0; i < lines.length; i++) {
            String[] pair = lines[i].split("\\s+");

            leftIds[i] = Integer.parseInt(pair[0]);
            int key = Integer.parseInt(pair[1]);

            if (freq.containsKey(key)) {
                int cur = freq.get(key);
                freq.put(key, cur + 1);
            } else {
                freq.put(key, 1);
            }
        }

        int runningSum = 0;
        for (int i = 0; i < leftIds.length; i++) {
            Integer count = freq.get(leftIds[i]);
            if (count != null) {
                runningSum += leftIds[i] * count;
            } else {
                runningSum += leftIds[i];
            }
        }

        return String.valueOf(runningSum);
}
