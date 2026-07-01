package j0.l.a;

import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: compiled from: OnSubscribeTimerOnce.java */
/* JADX INFO: loaded from: classes3.dex */
public class h0 implements Action0 {
    public final /* synthetic */ Subscriber j;

    public h0(i0 i0Var, Subscriber subscriber) {
        this.j = subscriber;
    }

    @Override // rx.functions.Action0
    public void call() {
        try {
            this.j.onNext(0L);
            this.j.onCompleted();
        } catch (Throwable th) {
            Subscriber subscriber = this.j;
            b.i.a.f.e.o.f.o1(th);
            subscriber.onError(th);
        }
    }
}
