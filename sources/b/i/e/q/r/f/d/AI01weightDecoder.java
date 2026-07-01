package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.i, reason: use source file name */
/* JADX INFO: compiled from: AI01weightDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AI01weightDecoder extends AI01decoder {
    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public abstract void d(StringBuilder sb, int i);

    public abstract int e(int i);

    public final void f(StringBuilder sb, int i, int i2) {
        int iD = GeneralAppIdDecoder.d(this.f1867b.a, i, i2);
        d(sb, iD);
        int iE = e(iD);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (iE / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(iE);
    }
}
