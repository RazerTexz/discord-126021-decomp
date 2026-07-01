package b.i.d.q.y;

import b.i.d.q.o;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: compiled from: ReflectionAccessor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final b a;

    static {
        a = o.a < 9 ? new a() : new c();
    }

    public abstract void a(AccessibleObject accessibleObject);
}
