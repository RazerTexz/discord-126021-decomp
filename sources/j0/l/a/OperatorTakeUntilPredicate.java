package j0.l.a;

import j0.l.a.OperatorTakeUntilPredicate2;
import rx.Producer;

/* JADX INFO: renamed from: j0.l.a.g2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorTakeUntilPredicate implements Producer {
    public final /* synthetic */ OperatorTakeUntilPredicate2.a j;

    public OperatorTakeUntilPredicate(OperatorTakeUntilPredicate2 operatorTakeUntilPredicate2, OperatorTakeUntilPredicate2.a aVar) {
        this.j = aVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        this.j.request(j);
    }
}
