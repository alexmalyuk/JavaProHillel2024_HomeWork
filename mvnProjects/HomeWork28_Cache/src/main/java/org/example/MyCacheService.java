package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * Клас реалізує просте кешування значень in-memory
 * @author  Oleksandr Malyuk
 * @version 0.0.1
 * @since 09.04.2024*/
@Slf4j
public class MyCacheService {
    private final HashMap<String, HashMap<String, Object>> cachesMap = new HashMap<>();

    /**
     * перевіряє існування кешу
     * @param cache ім'я кешу
     * @return true якщо існує кеш false якщо ні
     */
    public boolean isCacheExists(String cache) {
        log.info("isCacheExists <" + cache + ">");
        return cachesMap.get(cache) != null;
    }

    /**
     * видаляє всі збережені значення з кешу
     * @param cache ім'я кешу
     */
    public void clear(String cache) {
        log.info("clear <" + cache + ">");
        cachesMap.remove(cache);
    }

    /**
     * видаляє всі наявні кеші
     */
    public void clear() {
        log.info("clear all caches");
        cachesMap.clear();
    }

    /**
     * отримуе значення із кешу
     * @param cache ім'я кешу
     * @param key ім'я значення
     * @return збережене значення
     */
    public Object get(String cache, String key) {
        log.info("get <" + cache + "> <" + key + ">");
        HashMap<String, Object> currentCache = cachesMap.getOrDefault(cache, new HashMap<String, Object>());
        return currentCache.getOrDefault(key, null);
    }

    /**
     * додає значенния до кешу
     * @param cache ім'я кешу
     * @param key ім'я значення
     * @param value додане значенния
     * @return true, завжди true :)
     */
    boolean put(String cache, String key, Object value) {
        log.info("put <" + cache + "> <" + key + "> <" + value + ">");
        HashMap<String, Object> currentCache = cachesMap.getOrDefault(cache, new HashMap<String, Object>());
        currentCache.put(key, value);
        cachesMap.putIfAbsent(cache, currentCache);
        return true;
    }
}
