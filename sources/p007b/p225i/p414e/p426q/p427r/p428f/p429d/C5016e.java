package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.e */
/* JADX INFO: compiled from: AI013x0x1xDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5016e extends AbstractC5020i {

    /* JADX INFO: renamed from: c */
    public final String f13437c;

    /* JADX INFO: renamed from: d */
    public final String f13438d;

    public C5016e(C4962a c4962a, String str, String str2) {
        super(c4962a);
        this.f13437c = str2;
        this.f13438d = str;
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractC5021j
    /* JADX INFO: renamed from: a */
    public String mo7030a() throws NotFoundException {
        if (this.f13439a.f13228k != 84) {
            throw NotFoundException.f21665l;
        }
        StringBuilder sb = new StringBuilder();
        m7031b(sb, 8);
        m7033f(sb, 48, 20);
        int iM7038d = C5030s.m7038d(this.f13440b.f13457a, 68, 16);
        if (iM7038d != 38400) {
            sb.append('(');
            sb.append(this.f13437c);
            sb.append(')');
            int i = iM7038d % 32;
            int i2 = iM7038d / 32;
            int i3 = (i2 % 12) + 1;
            int i4 = i2 / 12;
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i3);
            if (i / 10 == 0) {
                sb.append('0');
            }
            sb.append(i);
        }
        return sb.toString();
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractC5020i
    /* JADX INFO: renamed from: d */
    public void mo7028d(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.f13438d);
        sb.append(i / 100000);
        sb.append(')');
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractC5020i
    /* JADX INFO: renamed from: e */
    public int mo7029e(int i) {
        return i % 100000;
    }
}
