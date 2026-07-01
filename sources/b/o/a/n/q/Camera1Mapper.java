package b.o.a.n.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.m.Control;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.m.Hdr;
import b.o.a.m.WhiteBalance;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.o.a.n.q.a, reason: use source file name */
/* JADX INFO: compiled from: Camera1Mapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class Camera1Mapper {
    public static Camera1Mapper a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Flash, String> f1936b;
    public static final Map<WhiteBalance, String> c;
    public static final Map<Facing, Integer> d;
    public static final Map<Hdr, String> e;

    static {
        HashMap map = new HashMap();
        f1936b = map;
        HashMap map2 = new HashMap();
        c = map2;
        HashMap map3 = new HashMap();
        d = map3;
        HashMap map4 = new HashMap();
        e = map4;
        map.put(Flash.OFF, "off");
        map.put(Flash.ON, "on");
        map.put(Flash.AUTO, "auto");
        map.put(Flash.TORCH, "torch");
        map3.put(Facing.BACK, 0);
        map3.put(Facing.FRONT, 1);
        map2.put(WhiteBalance.AUTO, "auto");
        map2.put(WhiteBalance.INCANDESCENT, "incandescent");
        map2.put(WhiteBalance.FLUORESCENT, "fluorescent");
        map2.put(WhiteBalance.DAYLIGHT, "daylight");
        map2.put(WhiteBalance.CLOUDY, "cloudy-daylight");
        map4.put(Hdr.OFF, "auto");
        map4.put(Hdr.ON, "hdr");
    }

    @NonNull
    public static Camera1Mapper a() {
        if (a == null) {
            a = new Camera1Mapper();
        }
        return a;
    }

    @Nullable
    public final <C extends Control, T> C b(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c2 : map.keySet()) {
            if (t.equals(map.get(c2))) {
                return c2;
            }
        }
        return null;
    }
}
