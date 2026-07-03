package p007b.p225i.p226a.p228b.p231j.p233r.p234a;

import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.r.a.a */
/* JADX INFO: compiled from: DoubleCheck.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2463a<T> implements InterfaceC5318a<T> {

    /* JADX INFO: renamed from: a */
    public static final Object f5325a = new Object();

    /* JADX INFO: renamed from: b */
    public volatile InterfaceC5318a<T> f5326b;

    /* JADX INFO: renamed from: c */
    public volatile Object f5327c = f5325a;

    public C2463a(InterfaceC5318a<T> interfaceC5318a) {
        this.f5326b = interfaceC5318a;
    }

    /* JADX INFO: renamed from: a */
    public static Object m2372a(Object obj, Object obj2) {
        if (!(obj != f5325a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public T get() {
        T t = (T) this.f5327c;
        Object obj = f5325a;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f5327c;
                if (t == obj) {
                    t = this.f5326b.get();
                    m2372a(this.f5327c, t);
                    this.f5327c = t;
                    this.f5326b = null;
                }
            }
        }
        return t;
    }
}
