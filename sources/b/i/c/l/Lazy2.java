package b.i.c.l;

import b.i.c.t.Provider2;

/* JADX INFO: renamed from: b.i.c.l.r, reason: use source file name */
/* JADX INFO: compiled from: Lazy.java */
/* JADX INFO: loaded from: classes3.dex */
public class Lazy2<T> implements Provider2<T> {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f1670b = a;
    public volatile Provider2<T> c;

    public Lazy2(Provider2<T> provider2) {
        this.c = provider2;
    }

    @Override // b.i.c.t.Provider2
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
