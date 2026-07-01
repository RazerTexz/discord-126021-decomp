package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorDebounceWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public class p0<T> extends Subscriber<T> {
    public final q0$a<T> j;
    public final Subscriber<?> k;
    public final /* synthetic */ SerialSubscription l;
    public final /* synthetic */ Scheduler$Worker m;
    public final /* synthetic */ SerializedSubscriber n;
    public final /* synthetic */ q0 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(q0 q0Var, Subscriber subscriber, SerialSubscription serialSubscription, Scheduler$Worker scheduler$Worker, SerializedSubscriber serializedSubscriber) {
        super(subscriber);
        this.o = q0Var;
        this.l = serialSubscription;
        this.m = scheduler$Worker;
        this.n = serializedSubscriber;
        this.j = new q0$a<>();
        this.k = this;
    }

    @Override // j0.g
    public void onCompleted() {
        q0$a<T> q0_a = this.j;
        SerializedSubscriber serializedSubscriber = this.n;
        synchronized (q0_a) {
            if (q0_a.e) {
                q0_a.d = true;
                return;
            }
            T t = q0_a.f3778b;
            boolean z2 = q0_a.c;
            q0_a.f3778b = null;
            q0_a.c = false;
            q0_a.e = true;
            if (z2) {
                try {
                    serializedSubscriber.onNext(t);
                } catch (Throwable th) {
                    b.i.a.f.e.o.f.p1(th, this, t);
                    return;
                }
            }
            serializedSubscriber.onCompleted();
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.n.j.onError(th);
        unsubscribe();
        q0$a<T> q0_a = this.j;
        synchronized (q0_a) {
            q0_a.a++;
            q0_a.f3778b = null;
            q0_a.c = false;
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        int i;
        q0$a<T> q0_a = this.j;
        synchronized (q0_a) {
            q0_a.f3778b = t;
            q0_a.c = true;
            i = q0_a.a + 1;
            q0_a.a = i;
        }
        SerialSubscription serialSubscription = this.l;
        Scheduler$Worker scheduler$Worker = this.m;
        p0$a p0_a = new p0$a(this, i);
        q0 q0Var = this.o;
        serialSubscription.a(scheduler$Worker.b(p0_a, q0Var.j, q0Var.k));
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
