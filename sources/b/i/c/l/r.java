package b.i.c.l;

/* JADX INFO: compiled from: Lazy.java */
/* JADX INFO: loaded from: classes3.dex */
public class r<T> implements b.i.c.t.a<T> {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f1670b = a;
    public volatile b.i.c.t.a<T> c;

    public r(b.i.c.t.a<T> aVar) {
        this.c = aVar;
    }

    @Override // b.i.c.t.a
    public T get() {
        T t = (T) this.f1670b;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f1670b;
                if (t == obj) {
                    t = this.c.get();
                    this.f1670b = t;
                    this.c = null;
                }
            }
        }
        return t;
    }
}
