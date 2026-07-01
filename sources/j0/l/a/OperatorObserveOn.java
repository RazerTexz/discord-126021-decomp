package j0.l.a;

import j0.l.a.OperatorObserveOn2;
import rx.Producer;

/* JADX INFO: renamed from: j0.l.a.y0, reason: use source file name */
/* JADX INFO: compiled from: OperatorObserveOn.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorObserveOn implements Producer {
    public final /* synthetic */ OperatorObserveOn2.a j;

    public OperatorObserveOn(OperatorObserveOn2.a aVar) {
        this.j = aVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j > 0) {
            b.i.a.f.e.o.f.c0(this.j.p, j);
            this.j.b();
        }
    }
}
