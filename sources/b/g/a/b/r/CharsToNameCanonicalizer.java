package b.g.a.b.r;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.g.a.b.r.b, reason: use source file name */
/* JADX INFO: compiled from: CharsToNameCanonicalizer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CharsToNameCanonicalizer {

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

    public CharsToNameCanonicalizer(int i) {
        new AtomicReference(new b(0, 0, new String[64], new a[32]));
    }

    public static CharsToNameCanonicalizer a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new CharsToNameCanonicalizer((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }
}
