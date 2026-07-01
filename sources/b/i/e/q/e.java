package b.i.e.q;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: EAN13Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends p {
    public static final int[] h = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    public final int[] i = new int[4];

    @Override // b.i.e.q.p
    public int j(b.i.e.n.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = aVar.k;
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < i; i4++) {
            int iH = p.h(aVar, iArr2, i2, p.d);
            sb.append((char) ((iH % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (iH >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (i3 == h[i6]) {
                sb.insert(0, (char) (i6 + 48));
                int[] iArr3 = p.f1861b;
                int i7 = p.l(aVar, i2, true, iArr3, new int[iArr3.length])[1];
                for (int i8 = 0; i8 < 6 && i7 < i; i8++) {
                    sb.append((char) (p.h(aVar, iArr2, i7, p.c) + 48));
                    for (int i9 : iArr2) {
                        i7 += i9;
                    }
                }
                return i7;
            }
        }
        throw NotFoundException.l;
    }

    @Override // b.i.e.q.p
    public b.i.e.a n() {
        return b.i.e.a.EAN_13;
    }
}
