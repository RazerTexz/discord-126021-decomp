package j0.l.a;

import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: OperatorZip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q2$a$a extends Subscriber {
    public final j0.l.e.i j;
    public final /* synthetic */ q2$a k;

    public q2$a$a(q2$a q2_a) {
        this.k = q2_a;
        int i = j0.l.e.i.j;
        this.j = j0.l.e.o.y.b() ? new j0.l.e.i(true, j0.l.e.i.j) : new j0.l.e.i();
    }

    @Override // j0.g
    public void onCompleted() {
        j0.l.e.i iVar = this.j;
        if (iVar.l == null) {
            iVar.l = e.a;
        }
        this.k.b();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.child.onError(th);
    }

    @Override // j0.g
    public void onNext(Object obj) {
        try {
            this.j.a(obj);
        } catch (MissingBackpressureException e) {
            this.k.child.onError(e);
        }
        this.k.b();
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(j0.l.e.i.j);
    }
}
