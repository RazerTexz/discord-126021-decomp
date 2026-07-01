package j0.l.a;

import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

/* JADX INFO: compiled from: OperatorDebounceWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public class p0$a implements Action0 {
    public final /* synthetic */ int j;
    public final /* synthetic */ p0 k;

    public p0$a(p0 p0Var, int i) {
        this.k = p0Var;
        this.j = i;
    }

    @Override // rx.functions.Action0
    public void call() {
        p0 p0Var = this.k;
        q0$a<T> q0_a = p0Var.j;
        int i = this.j;
        SerializedSubscriber serializedSubscriber = p0Var.n;
        Subscriber<?> subscriber = p0Var.k;
        synchronized (q0_a) {
            if (!q0_a.e && q0_a.c && i == q0_a.a) {
                T t = q0_a.f3778b;
                q0_a.f3778b = null;
                q0_a.c = false;
                q0_a.e = true;
                try {
                    serializedSubscriber.onNext(t);
                    synchronized (q0_a) {
                        if (q0_a.d) {
                            serializedSubscriber.onCompleted();
                        } else {
                            q0_a.e = false;
                        }
                    }
                } catch (Throwable th) {
                    b.i.a.f.e.o.f.p1(th, subscriber, t);
                }
            }
        }
    }
}
