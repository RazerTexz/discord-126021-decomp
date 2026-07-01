package b.i.e.q;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: EAN8Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends p {
    public final int[] h = new int[4];

    @Override // b.i.e.q.p
    public int j(b.i.e.n.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = aVar.k;
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < i; i3++) {
            sb.append((char) (p.h(aVar, iArr2, i2, p.c) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int[] iArr3 = p.f1861b;
        int i5 = p.l(aVar, i2, true, iArr3, new int[iArr3.length])[1];
        for (int i6 = 0; i6 < 4 && i5 < i; i6++) {
            sb.append((char) (p.h(aVar, iArr2, i5, p.c) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // b.i.e.q.p
    public b.i.e.a n() {
        return b.i.e.a.EAN_8;
    }
}
