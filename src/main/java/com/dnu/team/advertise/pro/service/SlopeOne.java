package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.model.Mark;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SlopeOne {

    private Map<String, Map<String, Float>> data;
    private Map<String, Map<String, Float>> diffMap;
    private Map<String, Map<String, Integer>> freqMap;

    public void setData(List<Mark> marks) {
        data = new HashMap<>();

        List<String> users = new ArrayList<>();
        List<Map<String, Float>> marksOfPlaces = new ArrayList<>();

        for (Mark mark : marks) {
            if (!users.contains(mark.getUserId())) {
                users.add(mark.getUserId());
                marksOfPlaces.add(new HashMap<String, Float>());
            }
            marksOfPlaces.get(users.indexOf(mark.getUserId())).put(mark.getPlaceId(), (float) mark.getMark());
        }

        for (int i = 0; i < users.size(); i++) {
            data.put(users.get(i), marksOfPlaces.get(i));
        }

        buildDiffMap();
    }

    private void buildDiffMap() {
        diffMap = new HashMap<>();
        freqMap = new HashMap<>();

        for (Map<String, Float> user : data.values()) {
            for (Map.Entry<String, Float> firstEntry: user.entrySet()) {
                if (!diffMap.containsKey(firstEntry.getKey())) {
                    diffMap.put(firstEntry.getKey(), new HashMap<String, Float>());
                    freqMap.put(firstEntry.getKey(), new HashMap<String, Integer>());
                }
                for (Map.Entry<String, Float> secondEntry: user.entrySet()) {
                    int oldCount = 0;
                    if (freqMap.get(firstEntry.getKey()).containsKey(secondEntry.getKey()))
                        oldCount = freqMap.get(firstEntry.getKey()).get(secondEntry.getKey());
                    float oldDiff = 0.0F;
                    if (diffMap.get(firstEntry.getKey()).containsKey(secondEntry.getKey()))
                        oldDiff = diffMap.get(firstEntry.getKey()).get(secondEntry.getKey());
                    float observedDiff = firstEntry.getValue() - secondEntry.getValue();
                    freqMap.get(firstEntry.getKey()).put(secondEntry.getKey(), oldCount + 1);
                    diffMap.get(firstEntry.getKey()).put(secondEntry.getKey(), oldDiff + observedDiff);
                }
            }
        }

        for (String j : diffMap.keySet()) {
            for (String i : diffMap.get(j).keySet()) {
                float oldValue = diffMap.get(j).get(i);
                int count = freqMap.get(j).get(i);
                diffMap.get(j).put(i, oldValue / count);
            }
        }
    }

    public Map<String, Float> predict(Map<String, Float> user) {
        HashMap<String, Float> predictions = new HashMap<>();
        HashMap<String, Integer> frequencies = new HashMap<>();

        for (String j : diffMap.keySet()) {
            frequencies.put(j, 0);
            predictions.put(j, 0.0F);
        }

        for (String j : user.keySet()) {
            for (String k : diffMap.keySet()) {
                try {
                    float newVal = (diffMap.get(k).get(j) + user.get(j)) * freqMap.get(k).get(j);
                    predictions.put(k, predictions.get(k) + newVal);
                    frequencies.put(k, frequencies.get(k) + freqMap.get(k).get(j));
                } catch(NullPointerException ignored) {}
            }
        }

        HashMap<String, Float> cleanPredictions = new HashMap<>();
        for (String j : predictions.keySet()) {
            if (frequencies.get(j) > 0) {
                cleanPredictions.put(j, predictions.get(j) / frequencies.get(j));
            }
        }

        for (String j : user.keySet()) {
            cleanPredictions.put(j, user.get(j));
        }

        return cleanPredictions;
    }
}