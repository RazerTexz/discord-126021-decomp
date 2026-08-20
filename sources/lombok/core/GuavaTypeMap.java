package lombok.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/GuavaTypeMap.SCL.lombok */
public final class GuavaTypeMap {
    private static final Map<String, String> TYPE_TO_GUAVA_TYPE;

    static {
        Map<String, String> m = new HashMap<>();
        m.put("java.util.NavigableSet", "ImmutableSortedSet");
        m.put("java.util.NavigableMap", "ImmutableSortedMap");
        m.put("java.util.SortedSet", "ImmutableSortedSet");
        m.put("java.util.SortedMap", "ImmutableSortedMap");
        m.put("java.util.Set", "ImmutableSet");
        m.put("java.util.Map", "ImmutableMap");
        m.put("java.util.Collection", "ImmutableList");
        m.put("java.util.List", "ImmutableList");
        m.put("com.google.common.collect.ImmutableSet", "ImmutableSet");
        m.put("com.google.common.collect.ImmutableSortedSet", "ImmutableSortedSet");
        m.put("com.google.common.collect.ImmutableMap", "ImmutableMap");
        m.put("com.google.common.collect.ImmutableBiMap", "ImmutableBiMap");
        m.put("com.google.common.collect.ImmutableSortedMap", "ImmutableSortedMap");
        m.put("com.google.common.collect.ImmutableList", "ImmutableList");
        m.put("com.google.common.collect.ImmutableCollection", "ImmutableList");
        m.put("com.google.common.collect.ImmutableTable", "ImmutableTable");
        TYPE_TO_GUAVA_TYPE = Collections.unmodifiableMap(m);
    }

    public static String getGuavaTypeName(String fqn) {
        String target = TYPE_TO_GUAVA_TYPE.get(fqn);
        return target != null ? target : "ImmutableList";
    }

    private GuavaTypeMap() {
    }
}
