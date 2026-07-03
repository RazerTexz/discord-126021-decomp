package p007b.p225i.p361c.p368l;

import p007b.p225i.p361c.p400t.InterfaceC4836a;

/* JADX INFO: renamed from: b.i.c.l.r */
/* JADX INFO: compiled from: Lazy.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4586r<T> implements InterfaceC4836a<T> {

    /* JADX INFO: renamed from: a */
    public static final Object f12209a = new Object();

    /* JADX INFO: renamed from: b */
    public volatile Object f12210b = f12209a;

    /* JADX INFO: renamed from: c */
    public volatile InterfaceC4836a<T> f12211c;

    public C4586r(InterfaceC4836a<T> interfaceC4836a) {
        this.f12211c = interfaceC4836a;
    }

    @Override // p007b.p225i.p361c.p400t.InterfaceC4836a
    public T get() {
        T t = (T) this.f12210b;
        Object obj = f12209a;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f12210b;
                if (t == obj) {
                    t = this.f12211c.get();
                    this.f12210b = t;
                    this.f12211c = null;
                }
            }
        }
        return t;
    }
}
