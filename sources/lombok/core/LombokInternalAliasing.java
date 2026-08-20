package lombok.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/LombokInternalAliasing.SCL.lombok */
public class LombokInternalAliasing {
    public static final Map<String, String> ALIASES;
    public static final Map<String, Collection<String>> REVERSE_ALIASES;

    public static String processAliases(String in) {
        if (in == null) {
            return null;
        }
        String ret = ALIASES.get(in);
        return ret == null ? in : ret;
    }

    static {
        Map<String, String> m1 = new HashMap<>();
        m1.put("lombok.experimental.Value", "lombok.Value");
        m1.put("lombok.experimental.Builder", "lombok.Builder");
        m1.put("lombok.experimental.var", "lombok.var");
        m1.put("lombok.Delegate", "lombok.experimental.Delegate");
        m1.put("lombok.experimental.Wither", "lombok.With");
        ALIASES = Collections.unmodifiableMap(m1);
        Map<String, Collection<String>> m2 = new HashMap<>();
        for (Map.Entry<String, String> e : m1.entrySet()) {
            Collection<String> c = m2.get(e.getValue());
            if (c == null) {
                m2.put(e.getValue(), Collections.singleton(e.getKey()));
            } else if (c.size() == 1) {
                Collection<String> newC = new ArrayList<>(2);
                newC.addAll(c);
                m2.put(e.getValue(), c);
            } else {
                c.add(e.getKey());
            }
        }
        for (Map.Entry<String, Collection<String>> e2 : m2.entrySet()) {
            Collection<String> c2 = e2.getValue();
            if (c2.size() > 1) {
                e2.setValue(Collections.unmodifiableList((ArrayList) c2));
            }
        }
        REVERSE_ALIASES = Collections.unmodifiableMap(m2);
    }
}
