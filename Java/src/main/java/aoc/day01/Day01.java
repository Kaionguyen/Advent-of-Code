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
        String[] lines = input.split("\n");

        int[] list1 = new int[lines.length];
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for (int i = 0; i < lines.length; i++) {
            String[] pair = lines[i].split(" +");

            list1[i] = Integer.parseInt(pair[0]);
            freq.put(Integer.parseInt(pair[1]), freq.getOrDefault(Integer.parseInt(pair[1]), 0) + 1);
        }

        int runningSum = 0;
        for (int i = 0; i < list1.length; i++) {
            runningSum += list1[i] * freq.getOrDefault(list1[i], 0);
        }

        return String.valueOf(runningSum);
    }
}
