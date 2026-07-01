package b.i.d.q.y;

import b.i.d.q.JavaVersion;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: renamed from: b.i.d.q.y.b, reason: use source file name */
/* JADX INFO: compiled from: ReflectionAccessor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectionAccessor {
    public static final ReflectionAccessor a;

    static {
        a = JavaVersion.a < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
    }

    public abstract void a(AccessibleObject accessibleObject);
}
