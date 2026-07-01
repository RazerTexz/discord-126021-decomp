package j0.l.a;

import rx.Producer;

/* JADX INFO: compiled from: OperatorObserveOn.java */
/* JADX INFO: loaded from: classes3.dex */
public class y0 implements Producer {
    public final /* synthetic */ z0$a j;

    public y0(z0$a z0_a) {
        this.j = z0_a;
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j > 0) {
            b.i.a.f.e.o.f.c0(this.j.p, j);
            this.j.b();
        }
    }
}
