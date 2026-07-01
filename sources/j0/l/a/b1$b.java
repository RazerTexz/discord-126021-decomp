package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: compiled from: OperatorOnBackpressureLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b1$b<T> extends AtomicLong implements Producer, Subscription, j0.g<T> {
    public static final Object j = new Object();
    private static final long serialVersionUID = -1364393685005146274L;
    public final Subscriber<? super T> child;
    public volatile boolean done;
    public boolean emitting;
    public boolean missed;
    public b1$c<? super T> parent;
    public Throwable terminal;
    public final AtomicReference<Object> value = new AtomicReference<>(j);

    public b1$b(Subscriber<? super T> subscriber) {
        this.child = subscriber;
        lazySet(-4611686018427387904L);
    }

    public void a() throws Throwable {
        boolean z2;
        Object obj;
        long j2;
        synchronized (this) {
            boolean z3 = true;
            if (this.emitting) {
                this.missed = true;
                return;
            }
            this.emitting = true;
            this.missed = false;
            while (true) {
                try {
                    long j3 = get();
                    if (j3 == Long.MIN_VALUE) {
                        return;
                    }
                    Object obj2 = this.value.get();
                    if (j3 > 0 && obj2 != (obj = j)) {
                        this.child.onNext(obj2);
                        this.value.compareAndSet(obj2, obj);
                        do {
                            j2 = get();
                            if (j2 < 0) {
                                break;
                            }
                        } while (!compareAndSet(j2, j2 - 1));
                        obj2 = j;
                    }
                    if (obj2 == j && this.done) {
                        Throwable th = this.terminal;
                        if (th != null) {
                            this.child.onError(th);
                        } else {
                            this.child.onCompleted();
                        }
                    }
                    try {
                        synchronized (this) {
                            try {
                                if (!this.missed) {
                                    this.emitting = false;
                                    return;
                                }
                                this.missed = false;
                            } catch (Throwable th2) {
                                th = th2;
                                z3 = false;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        z2 = z3;
                        th = th4;
                        if (!z2) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    z2 = false;
                }
            }
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return get() == Long.MIN_VALUE;
    }

    @Override // rx.Producer
    public void j(long j2) throws Throwable {
        long j3;
        long j4;
        if (j2 >= 0) {
            do {
                j3 = get();
                if (j3 == Long.MIN_VALUE) {
                    return;
                }
                if (j3 == -4611686018427387904L) {
                    j4 = j2;
                } else {
                    j4 = j3 + j2;
                    if (j4 < 0) {
                        j4 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j3, j4));
            if (j3 == -4611686018427387904L) {
                this.parent.request(RecyclerView.FOREVER_NS);
            }
            a();
        }
    }

    @Override // j0.g
    public void onCompleted() throws Throwable {
        this.done = true;
        a();
    }

    @Override // j0.g
    public void onError(Throwable th) throws Throwable {
        this.terminal = th;
        this.done = true;
        a();
    }

    @Override // j0.g
    public void onNext(T t) throws Throwable {
        this.value.lazySet(t);
        a();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (get() >= 0) {
            getAndSet(Long.MIN_VALUE);
        }
    }
}
