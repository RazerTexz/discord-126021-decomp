package p007b.p109f.p111b.p113b;

import com.facebook.cache.common.CacheKey;

/* JADX INFO: renamed from: b.f.b.b.i */
/* JADX INFO: compiled from: SettableCacheEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1666i {

    /* JADX INFO: renamed from: a */
    public static final Object f3072a = new Object();

    /* JADX INFO: renamed from: b */
    public static C1666i f3073b;

    /* JADX INFO: renamed from: c */
    public static int f3074c;

    /* JADX INFO: renamed from: d */
    public CacheKey f3075d;

    /* JADX INFO: renamed from: e */
    public C1666i f3076e;

    /* JADX INFO: renamed from: a */
    public static C1666i m961a() {
        synchronized (f3072a) {
            C1666i c1666i = f3073b;
            if (c1666i == null) {
                return new C1666i();
            }
            f3073b = c1666i.f3076e;
            c1666i.f3076e = null;
            f3074c--;
            return c1666i;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m962b() {
        synchronized (f3072a) {
            int i = f3074c;
            if (i < 5) {
                f3074c = i + 1;
                C1666i c1666i = f3073b;
                if (c1666i != null) {
                    this.f3076e = c1666i;
                }
                f3073b = this;
            }
        }
    }
}
