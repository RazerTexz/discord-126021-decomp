package d0.e0.p.d;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 {
    public final WeakReference<ClassLoader> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3201b;

    public k0(ClassLoader classLoader) {
        d0.z.d.m.checkNotNullParameter(classLoader, "classLoader");
        this.a = new WeakReference<>(classLoader);
        this.f3201b = System.identityHashCode(classLoader);
    }

    public boolean equals(Object obj) {
        return (obj instanceof k0) && this.a.get() == ((k0) obj).a.get();
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
