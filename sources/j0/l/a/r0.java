package j0.l.a;

import rx.Scheduler$Worker;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public class r0<T> extends Subscriber<T> {
    public boolean j;
    public final /* synthetic */ Scheduler$Worker k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ s0 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(s0 s0Var, Subscriber subscriber, Scheduler$Worker scheduler$Worker, Subscriber subscriber2) {
        super(subscriber);
        this.m = s0Var;
        this.k = scheduler$Worker;
        this.l = subscriber2;
    }

    @Override // j0.g
    public void onCompleted() {
        Scheduler$Worker scheduler$Worker = this.k;
        r0$a r0_a = new r0$a(this);
        s0 s0Var = this.m;
        scheduler$Worker.b(r0_a, s0Var.j, s0Var.k);
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.a(new r0$b(this, th));
    }

    @Override // j0.g
    public void onNext(T t) {
        Scheduler$Worker scheduler$Worker = this.k;
        r0$c r0_c = new r0$c(this, t);
        s0 s0Var = this.m;
        scheduler$Worker.b(r0_c, s0Var.j, s0Var.k);
    }
}
