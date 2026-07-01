package b.i.a.b.j.r.a;

/* JADX INFO: compiled from: DoubleCheck.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements c0.a.a<T> {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c0.a.a<T> f779b;
    public volatile Object c = a;

    public a(c0.a.a<T> aVar) {
        this.f779b = aVar;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // c0.a.a
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
