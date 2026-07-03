package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.f */
/* JADX INFO: compiled from: EAN8Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4992f extends AbstractC5002p {

    /* JADX INFO: renamed from: h */
    public final int[] f13370h = new int[4];

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: j */
    public int mo6989j(C4962a c4962a, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f13370h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = c4962a.f13228k;
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < i; i3++) {
            sb.append((char) (AbstractC5002p.m7004h(c4962a, iArr2, i2, AbstractC5002p.f13391c) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int[] iArr3 = AbstractC5002p.f13390b;
        int i5 = AbstractC5002p.m7005l(c4962a, i2, true, iArr3, new int[iArr3.length])[1];
        for (int i6 = 0; i6 < 4 && i5 < i; i6++) {
            sb.append((char) (AbstractC5002p.m7004h(c4962a, iArr2, i5, AbstractC5002p.f13391c) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: n */
    public EnumC4946a mo6990n() {
        return EnumC4946a.EAN_8;
    }
}
