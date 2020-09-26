package com.spring.schedule;

public class MRImpl implements IMR {

    public KeyValue[] mapper(String filename, String content) {

        if (content == null || content.length() == 0) {
            return null;
        }

        String[] words = content.split("\n");

        KeyValue[] keyValues = new KeyValue[words.length];

        int index = 0;
        for (String word : words) {
            keyValues[index++] = new KeyValue(word, "1");
        }

        return keyValues;
    }

    public String reduce(String key, String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        int sum = 0;
        for (String value : values) {
            sum += Integer.valueOf(value);
        }

        return String.valueOf(sum);
    }
}
