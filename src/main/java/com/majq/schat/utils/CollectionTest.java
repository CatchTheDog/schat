package com.majq.schat.utils;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "");
        map.put("2", "");
        //更新项   方法一
        map.put("3", map.getOrDefault("3", "3").concat("1"));
        //更新项  方法二
        map.putIfAbsent("3", "0");
        map.putIfAbsent("3", map.get("3").concat("1"));
        //更新项 方法三
        map.merge("3", "1", String::concat);
        map.computeIfPresent("3", String::concat);
        map.replaceAll(String::concat);

        EnumSet<WeekDay> always = EnumSet.allOf(WeekDay.class);
        EnumSet<WeekDay> never = EnumSet.noneOf(WeekDay.class);
        EnumSet<WeekDay> workDay = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        EnumSet<WeekDay> mwf = EnumSet.of(WeekDay.MONDAY, WeekDay.WEDNESDAY, WeekDay.FRIDAY);

        EnumMap<WeekDay, Integer> personNumInCharge = new EnumMap<>(WeekDay.class);
        String[] strings = {"1", "2"};
        List<String> strs = Arrays.asList(strings);
    }

    enum WeekDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }


}
