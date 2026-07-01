package b.o.a.n.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.o.a.m.Control;
import b.o.a.m.Facing;
import b.o.a.m.Hdr;
import b.o.a.m.WhiteBalance;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.o.a.n.q.b, reason: use source file name */
/* JADX INFO: compiled from: Camera2Mapper.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class Camera2Mapper {
    public static Camera2Mapper a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Facing, Integer> f1937b;
    public static final Map<WhiteBalance, Integer> c;
    public static final Map<Hdr, Integer> d;

    static {
        HashMap map = new HashMap();
        f1937b = map;
        HashMap map2 = new HashMap();
        c = map2;
        HashMap map3 = new HashMap();
        d = map3;
        map.put(Facing.BACK, 1);
        map.put(Facing.FRONT, 0);
        map2.put(WhiteBalance.AUTO, 1);
        map2.put(WhiteBalance.CLOUDY, 6);
        map2.put(WhiteBalance.DAYLIGHT, 5);
        map2.put(WhiteBalance.FLUORESCENT, 3);
        map2.put(WhiteBalance.INCANDESCENT, 2);
        map3.put(Hdr.OFF, 0);
        map3.put(Hdr.ON, 18);
    }

    @Nullable
    public final <C extends Control, T> C a(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c2 : map.keySet()) {
            if (t.equals(map.get(c2))) {
                return c2;
            }
        }
        return null;
    }
}
