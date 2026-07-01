package b.i.a.b.j.r.a;

import c0.a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.r.a.a, reason: use source file name */
/* JADX INFO: compiled from: DoubleCheck.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DoubleCheck<T> implements Provider3<T> {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Provider3<T> f779b;
    public volatile Object c = a;

    public DoubleCheck(Provider3<T> provider3) {
        this.f779b = provider3;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // c0.a.Provider3
    public T get() {
        T t = (T) this.c;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.c;
                if (t == obj) {
                    t = this.f779b.get();
                    a(this.c, t);
                    this.c = t;
                    this.f779b = null;
                }
            }
        }
        return t;
    }
}
