package j0.l.a;

import rx.Producer;

/* JADX INFO: compiled from: OperatorSubscribeOn.java */
/* JADX INFO: loaded from: classes3.dex */
public class x1$a$a implements Producer {
    public final /* synthetic */ Producer j;
    public final /* synthetic */ x1$a k;

    public x1$a$a(x1$a x1_a, Producer producer) {
        this.k = x1_a;
        this.j = producer;
    }

    @Override // rx.Producer
    public void j(long j) {
        if (this.k.n != Thread.currentThread()) {
            x1$a x1_a = this.k;
            if (x1_a.k) {
                x1_a.l.a(new x1$a$a$a(this, j));
                return;
            }
        }
        this.j.j(j);
    }
}
