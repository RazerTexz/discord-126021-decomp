package p507d0.p513e0.p514p.p515d;

import java.lang.ref.WeakReference;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.k0 */
/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11267k0 {

    /* JADX INFO: renamed from: a */
    public final WeakReference<ClassLoader> f22400a;

    /* JADX INFO: renamed from: b */
    public final int f22401b;

    public C11267k0(ClassLoader classLoader) {
        C12238m.checkNotNullParameter(classLoader, "classLoader");
        this.f22400a = new WeakReference<>(classLoader);
        this.f22401b = System.identityHashCode(classLoader);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C11267k0) && this.f22400a.get() == ((C11267k0) obj).f22400a.get();
    }

    public int hashCode() {
        return this.f22401b;
    }

    public final void setTemporaryStrongRef(ClassLoader classLoader) {
    }

    public String toString() {
        String string;
        ClassLoader classLoader = this.f22400a.get();
        return (classLoader == null || (string = classLoader.toString()) == null) ? "<null>" : string;
    }
}
