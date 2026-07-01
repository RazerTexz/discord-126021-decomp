package i0.d0.a;

import b.d.b.a.outline;
import i0.Call3;
import j0.o.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Response;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: renamed from: i0.d0.a.b, reason: use source file name */
/* JADX INFO: compiled from: CallArbiter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CallArbiter<T> extends AtomicInteger implements Subscription, Producer {
    private final Call3<T> call;
    private volatile Response<T> response;
    private final Subscriber<? super Response<T>> subscriber;
    private volatile boolean unsubscribed;

    public CallArbiter(Call3<T> call3, Subscriber<? super Response<T>> subscriber) {
        super(0);
        this.call = call3;
        this.subscriber = subscriber;
    }

    public final void a(Response<T> response) {
        try {
            if (!this.unsubscribed) {
                this.subscriber.onNext(response);
            }
            try {
                if (this.unsubscribed) {
                    return;
                }
                this.subscriber.onCompleted();
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused) {
                Objects.requireNonNull(RxJavaPlugins.a.b());
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                Objects.requireNonNull(RxJavaPlugins.a.b());
            }
        } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused2) {
            Objects.requireNonNull(RxJavaPlugins.a.b());
        } catch (Throwable th2) {
            b.i.a.f.e.o.f.o1(th2);
            try {
                this.subscriber.onError(th2);
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused3) {
                Objects.requireNonNull(RxJavaPlugins.a.b());
            } catch (Throwable th3) {
                b.i.a.f.e.o.f.o1(th3);
                new CompositeException(th2, th3);
                Objects.requireNonNull(RxJavaPlugins.a.b());
            }
        }
    }

    public void b(Throwable th) {
        set(3);
        if (this.unsubscribed) {
            return;
        }
        try {
            this.subscriber.onError(th);
        } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused) {
            Objects.requireNonNull(RxJavaPlugins.a.b());
        } catch (Throwable th2) {
            b.i.a.f.e.o.f.o1(th2);
            new CompositeException(th, th2);
            Objects.requireNonNull(RxJavaPlugins.a.b());
        }
    }

    public void c(Response<T> response) {
        while (true) {
            int i = get();
            if (i == 0) {
                this.response = response;
                if (compareAndSet(0, 2)) {
                    return;
                }
            } else {
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException(outline.q("Unknown state: ", i));
                    }
                    throw new AssertionError();
                }
                if (compareAndSet(1, 3)) {
                    a(response);
                    return;
                }
            }
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j == 0) {
            return;
        }
        while (true) {
            int i = get();
            if (i != 0) {
                if (i == 1) {
                    return;
                }
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException(outline.q("Unknown state: ", i));
                    }
                    return;
                } else if (compareAndSet(2, 3)) {
                    a(this.response);
                    return;
                }
            } else if (compareAndSet(0, 1)) {
                return;
            }
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.unsubscribed = true;
        this.call.cancel();
    }
}
