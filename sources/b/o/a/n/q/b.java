package b.o.a.n.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.o.a.m.c;
import b.o.a.m.e;
import b.o.a.m.h;
import b.o.a.m.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Camera2Mapper.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class b {
    public static b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<e, Integer> f1937b;
    public static final Map<m, Integer> c;
    public static final Map<h, Integer> d;

    static {
        HashMap map = new HashMap();
        f1937b = map;
        HashMap map2 = new HashMap();
        c = map2;
        HashMap map3 = new HashMap();
        d = map3;
        map.put(e.BACK, 1);
        map.put(e.FRONT, 0);
        map2.put(m.AUTO, 1);
        map2.put(m.CLOUDY, 6);
        map2.put(m.DAYLIGHT, 5);
        map2.put(m.FLUORESCENT, 3);
        map2.put(m.INCANDESCENT, 2);
        map3.put(h.OFF, 0);
        map3.put(h.ON, 18);
    }

    @Nullable
    public final <C extends c, T> C a(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c2 : map.keySet()) {
            if (t.equals(map.get(c2))) {
                return c2;
            }
        }
        return null;
    }
}
