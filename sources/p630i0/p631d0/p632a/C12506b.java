package p630i0.p631d0.p632a;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p630i0.InterfaceC12504d;
import p637j0.p652o.C12777o;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.exceptions.CompositeException;
import p658rx.exceptions.OnCompletedFailedException;
import p658rx.exceptions.OnErrorFailedException;
import p658rx.exceptions.OnErrorNotImplementedException;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.d0.a.b */
/* JADX INFO: compiled from: CallArbiter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12506b<T> extends AtomicInteger implements Subscription, Producer {
    private final InterfaceC12504d<T> call;
    private volatile Response<T> response;
    private final Subscriber<? super Response<T>> subscriber;
    private volatile boolean unsubscribed;

    public C12506b(InterfaceC12504d<T> interfaceC12504d, Subscriber<? super Response<T>> subscriber) {
        super(0);
        this.call = interfaceC12504d;
        this.subscriber = subscriber;
    }

    /* JADX INFO: renamed from: a */
    public final void m10701a(Response<T> response) {
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
                Objects.requireNonNull(C12777o.f27384a.m10869b());
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                Objects.requireNonNull(C12777o.f27384a.m10869b());
            }
        } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused2) {
            Objects.requireNonNull(C12777o.f27384a.m10869b());
        } catch (Throwable th2) {
            C3404f.m4325o1(th2);
            try {
                this.subscriber.onError(th2);
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused3) {
                Objects.requireNonNull(C12777o.f27384a.m10869b());
            } catch (Throwable th3) {
                C3404f.m4325o1(th3);
                new CompositeException(th2, th3);
                Objects.requireNonNull(C12777o.f27384a.m10869b());
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10702b(Throwable th) {
        set(3);
        if (this.unsubscribed) {
            return;
        }
        try {
            this.subscriber.onError(th);
        } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused) {
            Objects.requireNonNull(C12777o.f27384a.m10869b());
        } catch (Throwable th2) {
            C3404f.m4325o1(th2);
            new CompositeException(th, th2);
            Objects.requireNonNull(C12777o.f27384a.m10869b());
        }
    }

    /* JADX INFO: renamed from: c */
    public void m10703c(Response<T> response) {
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
                        throw new IllegalStateException(C1643a.m871q("Unknown state: ", i));
                    }
                    throw new AssertionError();
                }
                if (compareAndSet(1, 3)) {
                    m10701a(response);
                    return;
                }
            }
        }
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    @Override // p658rx.Producer
    /* JADX INFO: renamed from: j */
    public void mo10704j(long j) {
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
                        throw new IllegalStateException(C1643a.m871q("Unknown state: ", i));
                    }
                    return;
                } else if (compareAndSet(2, 3)) {
                    m10701a(this.response);
                    return;
                }
            } else if (compareAndSet(0, 1)) {
                return;
            }
        }
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        this.unsubscribed = true;
        this.call.cancel();
    }
}
