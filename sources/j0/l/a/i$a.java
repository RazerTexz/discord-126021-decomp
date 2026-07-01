package j0.l.a;

import java.util.concurrent.atomic.AtomicLong;
import rx.Emitter;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: compiled from: OnSubscribeCreate.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i$a<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
    private static final long serialVersionUID = 7326289992464377023L;
    public final Subscriber<? super T> actual;
    public final SerialSubscription serial = new SerialSubscription();

    public i$a(Subscriber<? super T> subscriber) {
        this.actual = subscriber;
    }

    public void a() {
    }

    public void b() {
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.serial.isUnsubscribed();
    }

    @Override // rx.Producer
    public final void j(long j) {
        if (b.i.a.f.e.o.f.A1(j)) {
            b.i.a.f.e.o.f.c0(this, j);
            a();
        }
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        try {
            this.actual.onCompleted();
        } finally {
            this.serial.unsubscribe();
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        try {
            this.actual.onError(th);
        } finally {
            this.serial.unsubscribe();
        }
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.serial.j.unsubscribe();
        b();
    }
}
