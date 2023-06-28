package com.haemimont.cars.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiReceivingMessages {
    private static List<String> map;

    public List<String> getMap() {
        return map;
    }

    public void setMap(List<String> map) {
        this.map = map;
    }

    public List<String> getReceivingMessages(){
        return map;
    }

    public void setReceivingMessages(String message){
        map = new ArrayList<>();
            map.add(message);
    }
}
