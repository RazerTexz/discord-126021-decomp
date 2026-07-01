package j0.l.a;

import rx.Producer;

/* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes3.dex */
public class g2 implements Producer {
    public final /* synthetic */ h2$a j;

    public g2(h2 h2Var, h2$a h2_a) {
        this.j = h2_a;
    }

    @Override // rx.Producer
    public void j(long j) {
        this.j.request(j);
    }
}
