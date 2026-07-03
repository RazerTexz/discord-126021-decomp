package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.h */
/* JADX INFO: compiled from: AI01decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5019h extends AbstractC5021j {
    public AbstractC5019h(C4962a c4962a) {
        super(c4962a);
    }

    /* JADX INFO: renamed from: b */
    public final void m7031b(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        m7032c(sb, i, length);
    }

    /* JADX INFO: renamed from: c */
    public final void m7032c(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int iM7041c = this.f13440b.m7041c((i3 * 10) + i, 10);
            if (iM7041c / 100 == 0) {
                sb.append('0');
            }
            if (iM7041c / 10 == 0) {
                sb.append('0');
            }
            sb.append(iM7041c);
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 13; i5++) {
            int iCharAt = sb.charAt(i5 + i2) - '0';
            if ((i5 & 1) == 0) {
                iCharAt *= 3;
            }
            i4 += iCharAt;
        }
        int i6 = 10 - (i4 % 10);
        sb.append(i6 != 10 ? i6 : 0);
    }
}
