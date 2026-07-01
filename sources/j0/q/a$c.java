package j0.q;

import androidx.recyclerview.widget.RecyclerView;
import b.i.a.f.e.o.f;
import rx.Subscriber;

/* JADX INFO: compiled from: ReplaySubject.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c<T> implements a$a<T> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile a$c$a<T> f3804b;
    public a$c$a<T> c;
    public int d;
    public volatile boolean e;
    public Throwable f;

    public a$c(int i) {
        this.a = i;
        a$c$a<T> a_c_a = new a$c$a<>(null);
        this.c = a_c_a;
        this.f3804b = a_c_a;
    }

    public void a(a$b<T> a_b) {
        if (a_b.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super T> subscriber = a_b.actual;
        int iAddAndGet = 1;
        do {
            long j = a_b.requested.get();
            a$c$a<T> a_c_a = (a$c$a) a_b.node;
            if (a_c_a == null) {
                a_c_a = this.f3804b;
            }
            long j2 = 0;
            while (true) {
                if (j2 == j) {
                    break;
                }
                if (subscriber.isUnsubscribed()) {
                    a_b.node = null;
                    return;
                }
                boolean z2 = this.e;
                a$c$a<T> a_c_a2 = a_c_a.get();
                boolean z3 = a_c_a2 == null;
                if (z2 && z3) {
                    a_b.node = null;
                    Throwable th = this.f;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onCompleted();
                        return;
                    }
                }
                if (z3) {
                    break;
                }
                subscriber.onNext(a_c_a2.value);
                j2++;
                a_c_a = a_c_a2;
            }
            if (j2 == j) {
                if (subscriber.isUnsubscribed()) {
                    a_b.node = null;
                    return;
                }
                boolean z4 = this.e;
                boolean z5 = a_c_a.get() == null;
                if (z4 && z5) {
                    a_b.node = null;
                    Throwable th2 = this.f;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onCompleted();
                        return;
                    }
                }
            }
            if (j2 != 0 && j != RecyclerView.FOREVER_NS) {
                f.U0(a_b.requested, j2);
            }
            a_b.node = a_c_a;
            iAddAndGet = a_b.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }
}
