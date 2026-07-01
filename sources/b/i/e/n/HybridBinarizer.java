package b.i.e.n;

import b.i.e.Binarizer;
import b.i.e.LuminanceSource;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.n.h, reason: use source file name */
/* JADX INFO: compiled from: HybridBinarizer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class HybridBinarizer extends Binarizer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1837b = new byte[0];
    public byte[] c;
    public final int[] d;
    public BitMatrix e;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.c = f1837b;
        this.d = new int[32];
    }

    public static int a(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i6) {
                i5 = i7;
                i6 = i9;
            }
        }
        if (i3 <= i5) {
            int i10 = i3;
            i3 = i5;
            i5 = i10;
        }
        if (i3 - i5 <= length / 16) {
            throw NotFoundException.l;
        }
        int i11 = i3 - 1;
        int i12 = i11;
        int i13 = -1;
        while (i11 > i5) {
            int i14 = i11 - i5;
            int i15 = (i2 - iArr[i11]) * (i3 - i11) * i14 * i14;
            if (i15 > i13) {
                i12 = i11;
                i13 = i15;
            }
            i11--;
        }
        return i12 << 3;
    }

    public final void b(int i) {
        if (this.c.length < i) {
            this.c = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.d[i2] = 0;
        }
    }
}
