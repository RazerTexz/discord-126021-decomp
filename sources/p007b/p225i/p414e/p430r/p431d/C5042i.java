package p007b.p225i.p414e.p430r.p431d;

import java.lang.reflect.Array;
import p007b.p225i.p414e.p430r.C5031a;

/* JADX INFO: renamed from: b.i.e.r.d.i */
/* JADX INFO: compiled from: PDF417CodewordDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5042i {

    /* JADX INFO: renamed from: a */
    public static final float[][] f13494a = (float[][]) Array.newInstance((Class<?>) float.class, C5031a.f13461b.length, 8);

    static {
        int i;
        int i2 = 0;
        while (true) {
            int[] iArr = C5031a.f13461b;
            if (i2 >= iArr.length) {
                return;
            }
            int i3 = iArr[i2];
            int i4 = i3 & 1;
            int i5 = 0;
            while (i5 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i3 & 1;
                    if (i == i4) {
                        f += 1.0f;
                        i3 >>= 1;
                    }
                }
                f13494a[i2][(8 - i5) - 1] = f / 17.0f;
                i5++;
                i4 = i;
            }
            i2++;
        }
    }
}
