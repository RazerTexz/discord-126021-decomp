package j0.l.a;

import b.d.b.a.outline;
import j0.l.a.OperatorSwitch2;
import rx.Producer;

/* JADX INFO: renamed from: j0.l.a.a2, reason: use source file name */
/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorSwitch implements Producer {
    public final /* synthetic */ OperatorSwitch2.c j;

    public OperatorSwitch(OperatorSwitch2.c cVar) {
        this.j = cVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        Producer producer;
        if (j <= 0) {
            if (j < 0) {
                throw new IllegalArgumentException(outline.t("n >= 0 expected but it was ", j));
            }
            return;
        }
        OperatorSwitch2.c cVar = this.j;
        synchronized (cVar) {
            producer = cVar.f3783s;
            cVar.r = b.i.a.f.e.o.f.f(cVar.r, j);
        }
        if (producer != null) {
            producer.j(j);
        }
        cVar.b();
    }
}
