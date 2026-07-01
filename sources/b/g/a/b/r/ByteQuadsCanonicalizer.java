package b.g.a.b.r;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.g.a.b.r.a, reason: use source file name */
/* JADX INFO: compiled from: ByteQuadsCanonicalizer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ByteQuadsCanonicalizer {

    /* JADX INFO: renamed from: b.g.a.b.r.a$a */
    /* JADX INFO: compiled from: ByteQuadsCanonicalizer.java */
    public static final class a {
        public a(int i, int i2, int i3, int[] iArr, String[] strArr, int i4, int i5) {
        }
    }

    public ByteQuadsCanonicalizer(int i, boolean z2, int i2, boolean z3) {
        int i3;
        int i4 = 16;
        if (i < 16) {
            i3 = 16;
        } else if (((i - 1) & i) != 0) {
            while (i4 < i) {
                i4 += i4;
            }
            i3 = i4;
        } else {
            i3 = i;
        }
        int i5 = i3 << 3;
        int i6 = i3 >> 2;
        new AtomicReference(new a(i3, 0, i6 < 64 ? 4 : i6 <= 256 ? 5 : i6 <= 1024 ? 6 : 7, new int[i5], new String[i3 << 1], i5 - i3, i5));
    }

    public static ByteQuadsCanonicalizer a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new ByteQuadsCanonicalizer(64, true, (((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1, true);
    }

    public String toString() {
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", ByteQuadsCanonicalizer.class.getName(), 0, 0, 0, 0, 0, 0, 0, 0);
    }
}
