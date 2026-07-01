package b.g.a.b.r;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CharsToNameCanonicalizer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public b(int i) {
        new AtomicReference(new b$b(0, 0, new String[64], new b$a[32]));
    }

    public static b a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new b((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }
}
