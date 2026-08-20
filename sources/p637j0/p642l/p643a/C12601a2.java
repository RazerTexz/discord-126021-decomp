package p637j0.p642l.p643a;

import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Producer;

/* JADX INFO: renamed from: j0.l.a.a2 */
/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12601a2 implements Producer {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12689y1.c f26736j;

    public C12601a2(C12689y1.c cVar) {
        this.f26736j = cVar;
    }

    @Override // p658rx.Producer
    /* JADX INFO: renamed from: j */
    public void mo10704j(long j) {
        Producer producer;
        if (j <= 0) {
            if (j < 0) {
                throw new IllegalArgumentException(C1643a.m877t("n >= 0 expected but it was ", j));
            }
            return;
        }
        C12689y1.c cVar = this.f26736j;
        synchronized (cVar) {
            producer = cVar.f27138s;
            cVar.f27137r = C3404f.m4287f(cVar.f27137r, j);
        }
        if (producer != null) {
            producer.mo10704j(j);
        }
        cVar.m10791b();
    }
}
