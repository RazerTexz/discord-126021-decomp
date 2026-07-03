package p007b.p195g.p196a.p198b.p202r;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.g.a.b.r.b */
/* JADX INFO: compiled from: CharsToNameCanonicalizer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2136b {

    /* JADX INFO: renamed from: b.g.a.b.r.b$a */
    /* JADX INFO: compiled from: CharsToNameCanonicalizer.java */
    public static final class a {
    }

    /* JADX INFO: renamed from: b.g.a.b.r.b$b */
    /* JADX INFO: compiled from: CharsToNameCanonicalizer.java */
    public static final class b {
        public b(int i, int i2, String[] strArr, a[] aVarArr) {
        }
    }

    public C2136b(int i) {
        new AtomicReference(new b(0, 0, new String[64], new a[32]));
    }

    /* JADX INFO: renamed from: a */
    public static C2136b m1726a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new C2136b((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }
}
