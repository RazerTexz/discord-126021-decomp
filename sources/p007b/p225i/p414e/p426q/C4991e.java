package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.e */
/* JADX INFO: compiled from: EAN13Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4991e extends AbstractC5002p {

    /* JADX INFO: renamed from: h */
    public static final int[] f13368h = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* JADX INFO: renamed from: i */
    public final int[] f13369i = new int[4];

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: j */
    public int mo6989j(C4962a c4962a, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f13369i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = c4962a.f13228k;
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < i; i4++) {
            int iM7004h = AbstractC5002p.m7004h(c4962a, iArr2, i2, AbstractC5002p.f13392d);
            sb.append((char) ((iM7004h % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (iM7004h >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (i3 == f13368h[i6]) {
                sb.insert(0, (char) (i6 + 48));
                int[] iArr3 = AbstractC5002p.f13390b;
                int i7 = AbstractC5002p.m7005l(c4962a, i2, true, iArr3, new int[iArr3.length])[1];
                for (int i8 = 0; i8 < 6 && i7 < i; i8++) {
                    sb.append((char) (AbstractC5002p.m7004h(c4962a, iArr2, i7, AbstractC5002p.f13391c) + 48));
                    for (int i9 : iArr2) {
                        i7 += i9;
                    }
                }
                return i7;
            }
        }
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: n */
    public EnumC4946a mo6990n() {
        return EnumC4946a.EAN_13;
    }
}
