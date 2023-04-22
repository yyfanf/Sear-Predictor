package me.seat.fb.util;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {
    public static List decompile(List list){
        List newList = (List) list.stream().distinct().collect(Collectors.toList());
        list.clear();
        list.addAll(newList);
        return newList;
    }
}
