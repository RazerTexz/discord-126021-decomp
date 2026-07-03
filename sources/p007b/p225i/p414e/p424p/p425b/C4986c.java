package p007b.p225i.p414e.p424p.p425b;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import p007b.p225i.p414e.p418n.p420l.C4973a;
import p007b.p225i.p414e.p418n.p420l.C4975c;

/* JADX INFO: renamed from: b.i.e.p.b.c */
/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4986c {

    /* JADX INFO: renamed from: a */
    public final C4975c f13351a = new C4975c(C4973a.f13306h);

    /* JADX INFO: renamed from: a */
    public final void m6981a(byte[] bArr, int i, int i2, int i3, int i4) throws ChecksumException {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[i5 / i6];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & 255;
            }
        }
        try {
            this.f13351a.m6968a(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.m9259a();
        }
    }
}
