package xyz.wagyourtail.jvmdg.j9.stub.java_base;


import xyz.wagyourtail.jvmdg.version.Ref;
import xyz.wagyourtail.jvmdg.version.Stub;

import java.util.*;

public class J_U_Map {

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of() {
        return Collections.emptyMap();
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1) {
        return Collections.singletonMap(k1, v1);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        Map<K, V> map = new HashMap<>(toExpectedSize(2));
        map.put(k1, v1);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = new HashMap<>(toExpectedSize(3));
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return Collections.unmodifiableMap(map);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> map = new HashMap<>(toExpectedSize(4));
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return Collections.unmodifiableMap(map);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> map = new HashMap<>(toExpectedSize(5));
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return Collections.unmodifiableMap(map);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map<K, V> map = new HashMap<>(toExpectedSize(6));
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return Collections.unmodifiableMap(map);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        Map<K, V> map = new HashMap<>(toExpectedSize(7));
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        return Collections.unmodifiableMap(map);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        Map<K, V> map = new HashMap<>(toExpectedSize(8));
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        return Collections.unmodifiableMap(map);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        Map<K, V> map = new HashMap<>(toExpectedSize(9));
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        return Collections.unmodifiableMap(map);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        Map<K, V> map = new HashMap<>(toExpectedSize(10));
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        return Collections.unmodifiableMap(map);
    }

    @SafeVarargs
    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries) {
        if (entries.length == 0) {
            return Collections.emptyMap();
        }
        if (entries.length == 1) {
            return Collections.singletonMap(entries[0].getKey(), entries[0].getValue());
        }
        Map<K, V> map = new HashMap<>(toExpectedSize(entries.length));
        for (Map.Entry<? extends K, ? extends V> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return Collections.unmodifiableMap(map);
    }

    @Stub(ref = @Ref("Ljava/util/Map;"))
    public static <K, V> Map.Entry<K, V> entry(K k, V v) {
        return new AbstractMap.SimpleImmutableEntry<>(Objects.requireNonNull(k), Objects.requireNonNull(v));
    }

    /**
     * @see HashMap#DEFAULT_LOAD_FACTOR
     */
    private static int toExpectedSize(int elementCount) {
        assert elementCount >= 0;
        return (int) (elementCount / 0.75f) + 1;
    }
}
