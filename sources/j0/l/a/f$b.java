package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.FuncN;

/* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b<T, R> extends AtomicInteger implements Producer, Subscription {
    public static final Object j = new Object();
    private static final long serialVersionUID = 8567835998786448817L;
    public int active;
    public final Subscriber<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final FuncN<? extends R> combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final AtomicReference<Throwable> error;
    public final Object[] latest;
    public final j0.l.e.n.e<Object> queue;
    public final AtomicLong requested;
    public final f$a<T, R>[] subscribers;

    public f$b(Subscriber<? super R> subscriber, FuncN<? extends R> funcN, int i, int i2, boolean z2) {
        this.actual = subscriber;
        this.combiner = funcN;
        this.bufferSize = i2;
        this.delayError = z2;
        Object[] objArr = new Object[i];
        this.latest = objArr;
        Arrays.fill(objArr, j);
        this.subscribers = new f$a[i];
        this.queue = new j0.l.e.n.e<>(i2);
        this.requested = new AtomicLong();
        this.error = new AtomicReference<>();
    }

    public void a(Queue<?> queue) {
        queue.clear();
        for (f$a<T, R> f_a : this.subscribers) {
            f_a.unsubscribe();
        }
    }

    public boolean b(boolean z2, boolean z3, Subscriber<?> subscriber, Queue<?> queue, boolean z4) {
        if (this.cancelled) {
            a(queue);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (z4) {
            if (!z3) {
                return false;
            }
            Throwable th = this.error.get();
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onCompleted();
            }
            return true;
        }
        Throwable th2 = this.error.get();
        if (th2 != null) {
            a(queue);
            subscriber.onError(th2);
            return true;
        }
        if (!z3) {
            return false;
        }
        subscriber.onCompleted();
        return true;
    }

    public void c(Object obj, int i) {
        boolean z2;
        f$a<T, R> f_a = this.subscribers[i];
        synchronized (this) {
            Object[] objArr = this.latest;
            int length = objArr.length;
            Object obj2 = objArr[i];
            int i2 = this.active;
            Object obj3 = j;
            if (obj2 == obj3) {
                i2++;
                this.active = i2;
            }
            int i3 = this.complete;
            if (obj == null) {
                i3++;
                this.complete = i3;
            } else {
                objArr[i] = e.b(obj);
            }
            boolean z3 = false;
            z2 = i2 == length;
            if (i3 == length || (obj == null && obj2 == obj3)) {
                z3 = true;
            }
            if (z3) {
                this.done = true;
            } else if (obj != null && z2) {
                this.queue.e(f_a, this.latest.clone());
            } else if (obj == null && this.error.get() != null && (obj2 == obj3 || !this.delayError)) {
                this.done = true;
            }
        }
        if (z2 || obj == null) {
            d();
        } else {
            f_a.request(1L);
        }
    }

    public void d() {
        long j2;
        if (getAndIncrement() != 0) {
            return;
        }
        j0.l.e.n.e<Object> eVar = this.queue;
        Subscriber<? super R> subscriber = this.actual;
        boolean z2 = this.delayError;
        AtomicLong atomicLong = this.requested;
        int iAddAndGet = 1;
        while (!b(this.done, eVar.isEmpty(), subscriber, eVar, z2)) {
            long j3 = atomicLong.get();
            long j4 = 0;
            while (true) {
                if (j4 == j3) {
                    j2 = j4;
                    break;
                }
                boolean z3 = this.done;
                f$a f_a = (f$a) eVar.peek();
                boolean z4 = f_a == null;
                long j5 = j4;
                if (b(z3, z4, subscriber, eVar, z2)) {
                    return;
                }
                if (z4) {
                    j2 = j5;
                    break;
                }
                eVar.poll();
                Object[] objArr = (Object[]) eVar.poll();
                if (objArr == null) {
                    this.cancelled = true;
                    a(eVar);
                    subscriber.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                    return;
                }
                try {
                    subscriber.onNext(this.combiner.call(objArr));
                    f_a.request(1L);
                    j4 = j5 + 1;
                } catch (Throwable th) {
                    this.cancelled = true;
                    a(eVar);
                    subscriber.onError(th);
                    return;
                }
            }
            if (j2 != 0 && j3 != RecyclerView.FOREVER_NS) {
                b.i.a.f.e.o.f.U0(atomicLong, j2);
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.cancelled;
    }

    @Override // rx.Producer
    public void j(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException(b.d.b.a.a.t("n >= required but it was ", j2));
        }
        if (j2 != 0) {
            b.i.a.f.e.o.f.c0(this.requested, j2);
            d();
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        if (getAndIncrement() == 0) {
            a(this.queue);
        }
    }
}
