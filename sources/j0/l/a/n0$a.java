package j0.l.a;

import java.util.ArrayList;
import java.util.List;
import rx.Scheduler$Worker;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorBufferWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n0$a<T> extends Subscriber<T> {
    public final Subscriber<? super List<T>> j;
    public final Scheduler$Worker k;
    public List<T> l = new ArrayList();
    public boolean m;
    public final /* synthetic */ n0 n;

    public n0$a(n0 n0Var, Subscriber<? super List<T>> subscriber, Scheduler$Worker scheduler$Worker) {
        this.n = n0Var;
        this.j = subscriber;
        this.k = scheduler$Worker;
    }

    @Override // j0.g
    public void onCompleted() {
        try {
            this.k.unsubscribe();
            synchronized (this) {
                if (this.m) {
                    return;
                }
                this.m = true;
                List<T> list = this.l;
                this.l = null;
                this.j.onNext(list);
                this.j.onCompleted();
                unsubscribe();
            }
        } catch (Throwable th) {
            Subscriber<? super List<T>> subscriber = this.j;
            b.i.a.f.e.o.f.o1(th);
            subscriber.onError(th);
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        synchronized (this) {
            if (this.m) {
                return;
            }
            this.m = true;
            this.l = null;
            this.j.onError(th);
            unsubscribe();
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        List<T> list;
        synchronized (this) {
            if (this.m) {
                return;
            }
            this.l.add(t);
            if (this.l.size() == this.n.m) {
                list = this.l;
                this.l = new ArrayList();
            } else {
                list = null;
            }
            if (list != null) {
                this.j.onNext(list);
            }
        }
    }
}
