package com.spring.schedule;

public interface IMR {

    /**
     * mapper 方法
     *
     * @param filename
     * @param content
     * @return
     */
    KeyValue[] mapper(String filename, String content);

    /**
     * reduce方法
     *
     * @param key
     * @param values
     * @return
     */
    String reduce(String key, String[] values);
}
