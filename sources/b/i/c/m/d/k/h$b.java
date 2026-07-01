package b.i.c.m.d.k;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CommonUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public enum h$b {
    X86_32,
    X86_64,
    ARM_UNKNOWN,
    PPC,
    PPC64,
    ARMV6,
    ARMV7,
    UNKNOWN,
    ARMV7S,
    ARM64;

    public static final Map<String, h$b> t;

    static {
        h$b h_b = X86_32;
        h$b h_b2 = ARMV6;
        h$b h_b3 = ARMV7;
        h$b h_b4 = ARM64;
        HashMap map = new HashMap(4);
        t = map;
        map.put("armeabi-v7a", h_b3);
        map.put("armeabi", h_b2);
        map.put("arm64-v8a", h_b4);
        map.put("x86", h_b);
    }
}
