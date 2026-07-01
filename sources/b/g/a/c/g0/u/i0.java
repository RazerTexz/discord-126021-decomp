package b.g.a.c.g0.u;

import java.util.HashMap;

/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class i0 {
    public static final HashMap<String, b.g.a.c.n<?>> a;

    static {
        HashMap<String, b.g.a.c.n<?>> map = new HashMap<>();
        a = map;
        map.put(boolean[].class.getName(), new i0$a());
        map.put(byte[].class.getName(), new f());
        map.put(char[].class.getName(), new i0$b());
        map.put(short[].class.getName(), new i0$g());
        map.put(int[].class.getName(), new i0$e());
        map.put(long[].class.getName(), new i0$f());
        map.put(float[].class.getName(), new i0$d());
        map.put(double[].class.getName(), new i0$c());
    }
}
