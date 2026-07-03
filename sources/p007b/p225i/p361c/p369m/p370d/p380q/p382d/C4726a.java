package p007b.p225i.p361c.p369m.p370d.p380q.p382d;

import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.C4722a;

/* JADX INFO: renamed from: b.i.c.m.d.q.d.a */
/* JADX INFO: compiled from: CompositeCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4726a implements InterfaceC4727b {

    /* JADX INFO: renamed from: a */
    public final C4728c f12716a;

    /* JADX INFO: renamed from: b */
    public final C4729d f12717b;

    public C4726a(C4728c c4728c, C4729d c4729d) {
        this.f12716a = c4728c;
        this.f12717b = c4729d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p382d.InterfaceC4727b
    /* JADX INFO: renamed from: a */
    public boolean mo6678a(C4722a c4722a, boolean z2) {
        int iM758h = C1563b.m758h(c4722a.f12711c.mo6675d());
        if (iM758h == 0) {
            this.f12716a.mo6678a(c4722a, z2);
            return true;
        }
        if (iM758h != 1) {
            return false;
        }
        this.f12717b.mo6678a(c4722a, z2);
        return true;
    }
}
