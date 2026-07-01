package d0.e0.p.d;

import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: d0.e0.p.d.k0, reason: use source file name */
/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class moduleByClassLoader2 {
    public final WeakReference<ClassLoader> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3201b;

    public moduleByClassLoader2(ClassLoader classLoader) {
        Intrinsics3.checkNotNullParameter(classLoader, "classLoader");
        this.a = new WeakReference<>(classLoader);
        this.f3201b = System.identityHashCode(classLoader);
    }

    public boolean equals(Object obj) {
        return (obj instanceof moduleByClassLoader2) && this.a.get() == ((moduleByClassLoader2) obj).a.get();
    }

    public int hashCode() {
        return this.f3201b;
    }

    public final void setTemporaryStrongRef(ClassLoader classLoader) {
    }

    public String toString() {
        String string;
        ClassLoader classLoader = this.a.get();
        return (classLoader == null || (string = classLoader.toString()) == null) ? "<null>" : string;
    }
}
