package b.i.c.p.h;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements b.i.c.p.g.b<e> {
    public static final e$a a = new e$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, b.i.c.p.c<?>> f1761b;
    public final Map<Class<?>, b.i.c.p.e<?>> c;
    public b.i.c.p.c<Object> d;
    public boolean e;

    public e() {
        HashMap map = new HashMap();
        this.f1761b = map;
        HashMap map2 = new HashMap();
        this.c = map2;
        this.d = a.a;
        this.e = false;
        map2.put(String.class, b.a);
        map.remove(String.class);
        map2.put(Boolean.class, c.a);
        map.remove(Boolean.class);
        map2.put(Date.class, a);
        map.remove(Date.class);
    }
}
