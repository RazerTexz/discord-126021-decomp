package b.i.e.r.d;

import b.i.e.r.PDF417Common;
import java.lang.reflect.Array;

/* JADX INFO: renamed from: b.i.e.r.d.i, reason: use source file name */
/* JADX INFO: compiled from: PDF417CodewordDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PDF417CodewordDecoder {
    public static final float[][] a = (float[][]) Array.newInstance((Class<?>) float.class, PDF417Common.f1875b.length, 8);

    static {
        int i;
        int i2 = 0;
        while (true) {
            int[] iArr = PDF417Common.f1875b;
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
                a[i2][(8 - i5) - 1] = f / 17.0f;
                i5++;
                i4 = i;
            }
            i2++;
        }
    }
}
