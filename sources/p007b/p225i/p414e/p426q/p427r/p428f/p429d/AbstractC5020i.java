package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.i */
/* JADX INFO: compiled from: AI01weightDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5020i extends AbstractC5019h {
    public AbstractC5020i(C4962a c4962a) {
        super(c4962a);
    }

    /* JADX INFO: renamed from: d */
    public abstract void mo7028d(StringBuilder sb, int i);

    /* JADX INFO: renamed from: e */
    public abstract int mo7029e(int i);

    /* JADX INFO: renamed from: f */
    public final void m7033f(StringBuilder sb, int i, int i2) {
        int iM7038d = C5030s.m7038d(this.f13440b.f13457a, i, i2);
        mo7028d(sb, iM7038d);
        int iMo7029e = mo7029e(iM7038d);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (iMo7029e / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(iMo7029e);
    }
}
