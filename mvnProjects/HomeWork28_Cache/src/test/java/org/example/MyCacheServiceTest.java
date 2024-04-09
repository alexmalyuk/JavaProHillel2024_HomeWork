package org.example;

import org.junit.Assert;
import org.junit.Test;

public class MyCacheServiceTest {

    @Test
    public void isCacheExists() {
        MyCacheService myCache = new MyCacheService();
        final String CACHE_NAME = "MyCache";

        Assert.assertFalse(myCache.isCacheExists(CACHE_NAME));
        myCache.put(CACHE_NAME, "Some key", "Some value");
        Assert.assertTrue(myCache.isCacheExists(CACHE_NAME));
    }

    @Test
    public void clearAllCaches() {
        MyCacheService myCache = new MyCacheService();

        final String CACHE_NAME_1 = "MyCache1";
        final String CACHE_NAME_2 = "MyCache2";

        myCache.put(CACHE_NAME_1, "Some key", "Some value");
        myCache.put(CACHE_NAME_2, "Some key", "Some value");

        myCache.clear();
        Assert.assertFalse(myCache.isCacheExists(CACHE_NAME_1));
        Assert.assertFalse(myCache.isCacheExists(CACHE_NAME_2));
    }

    @Test
    public void clearCache() {
        MyCacheService myCache = new MyCacheService();

        final String CACHE_NAME_1 = "MyCache1";
        final String CACHE_NAME_2 = "MyCache2";

        myCache.put(CACHE_NAME_1, "Some key", "Some value");
        myCache.put(CACHE_NAME_2, "Some key", "Some value");

        myCache.clear(CACHE_NAME_1);
        Assert.assertFalse(myCache.isCacheExists(CACHE_NAME_1));
        Assert.assertTrue(myCache.isCacheExists(CACHE_NAME_2));
    }

    @Test
    public void get() {
        MyCacheService myCache = new MyCacheService();

        final String CACHE_NAME_1 = "MyCache1";
        final String KEY = "Some key";
        final String VALUE = "Some value";

        myCache.put(CACHE_NAME_1, KEY, VALUE);

        Assert.assertEquals(VALUE, myCache.get(CACHE_NAME_1, KEY));
        Assert.assertNull(myCache.get(CACHE_NAME_1, "bla-bla-bla"));
        Assert.assertNull(myCache.get("zzz", KEY));
    }

    @Test
    public void put() {
        MyCacheService myCache = new MyCacheService();

        final String CACHE_NAME_1 = "MyCache1";
        final String KEY = "Some key";
        final String VALUE = "Some value";

        Assert.assertNull(myCache.get(CACHE_NAME_1, KEY));

        myCache.put(CACHE_NAME_1, KEY, VALUE);
        Assert.assertEquals(VALUE, myCache.get(CACHE_NAME_1, KEY));

    }
}