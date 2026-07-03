package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.b */
/* JADX INFO: compiled from: AI01320xDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5013b extends AbstractC5017f {
    public C5013b(C4962a c4962a) {
        super(c4962a);
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractC5020i
    /* JADX INFO: renamed from: d */
    public void mo7028d(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractC5020i
    /* JADX INFO: renamed from: e */
    public int mo7029e(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
