package b.o.a.n.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.m.c;
import b.o.a.m.e;
import b.o.a.m.f;
import b.o.a.m.h;
import b.o.a.m.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Camera1Mapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<f, String> f1936b;
    public static final Map<m, String> c;
    public static final Map<e, Integer> d;
    public static final Map<h, String> e;

    static {
        HashMap map = new HashMap();
        f1936b = map;
        HashMap map2 = new HashMap();
        c = map2;
        HashMap map3 = new HashMap();
        d = map3;
        HashMap map4 = new HashMap();
        e = map4;
        map.put(f.OFF, "off");
        map.put(f.ON, "on");
        map.put(f.AUTO, "auto");
        map.put(f.TORCH, "torch");
        map3.put(e.BACK, 0);
        map3.put(e.FRONT, 1);
        map2.put(m.AUTO, "auto");
        map2.put(m.INCANDESCENT, "incandescent");
        map2.put(m.FLUORESCENT, "fluorescent");
        map2.put(m.DAYLIGHT, "daylight");
        map2.put(m.CLOUDY, "cloudy-daylight");
        map4.put(h.OFF, "auto");
        map4.put(h.ON, "hdr");
    }

    @NonNull
    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    @Nullable
    public final <C extends c, T> C b(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c2 : map.keySet()) {
            if (t.equals(map.get(c2))) {
                return c2;
            }
        }
        return null;
    }
}
