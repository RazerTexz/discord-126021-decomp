package j0.l.a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorScan.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o1$b<R> implements Producer, j0.g<R> {
    public final Subscriber<? super R> j;
    public final Queue<Object> k;
    public boolean l;
    public boolean m;
    public long n;
    public final AtomicLong o;
    public volatile Producer p;
    public volatile boolean q;
    public Throwable r;

    public o1$b(R r, Subscriber<? super R> subscriber) {
        this.j = subscriber;
        Queue<Object> sVar = j0.l.e.o.y.b() ? new j0.l.e.o.s<>() : new j0.l.e.n.f<>();
        this.k = sVar;
        sVar.offer(r == null ? (R) e.f3771b : r);
        this.o = new AtomicLong();
    }

    public boolean a(boolean z2, boolean z3, Subscriber<? super R> subscriber) {
        if (subscriber.isUnsubscribed()) {
            return true;
        }
        if (!z2) {
            return false;
        }
        Throwable th = this.r;
        if (th != null) {
            subscriber.onError(th);
            return true;
        }
        if (!z3) {
            return false;
        }
        subscriber.onCompleted();
        return true;
    }

    public void b() {
        synchronized (this) {
            if (this.l) {
                this.m = true;
                return;
            }
            this.l = true;
            Subscriber<? super R> subscriber = this.j;
            Queue<Object> queue = this.k;
            AtomicLong atomicLong = this.o;
            long jU0 = atomicLong.get();
            while (!a(this.q, queue.isEmpty(), subscriber)) {
                long j = 0;
                while (j != jU0) {
                    boolean z2 = this.q;
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (a(z2, z3, subscriber)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    R r = (Object) e.b(objPoll);
                    try {
                        subscriber.onNext(r);
                        j++;
                    } catch (Throwable th) {
                        b.i.a.f.e.o.f.p1(th, subscriber, r);
                        return;
                    }
                }
                if (j != 0 && jU0 != RecyclerView.FOREVER_NS) {
                    jU0 = b.i.a.f.e.o.f.U0(atomicLong, j);
                }
                synchronized (this) {
                    if (!this.m) {
                        this.l = false;
                        return;
                    }
                    this.m = false;
                }
            }
        }
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(b.d.b.a.a.t("n >= required but it was ", j));
        }
        if (j != 0) {
            b.i.a.f.e.o.f.c0(this.o, j);
            Producer producer = this.p;
            if (producer == null) {
                synchronized (this.o) {
                    producer = this.p;
                    if (producer == null) {
                        this.n = b.i.a.f.e.o.f.f(this.n, j);
                    }
                }
            }
            if (producer != null) {
                producer.j(j);
            }
            b();
        }
    }

    @Override // j0.g
    public void onCompleted() {
        this.q = true;
        b();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.r = th;
        this.q = true;
        b();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // j0.g
    public void onNext(R r) {
        Queue<Object> queue = this.k;
        Object obj = r;
        if (r == null) {
            obj = e.f3771b;
        }
        queue.offer(obj);
        b();
    }
}
