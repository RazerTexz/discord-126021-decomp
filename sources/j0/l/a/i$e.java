package j0.l.a;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeCreate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i$e<T> extends i$a<T> {
    private static final long serialVersionUID = 4023437720691792495L;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference<Object> queue;
    public final AtomicInteger wip;

    public i$e(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.queue = new AtomicReference<>();
        this.wip = new AtomicInteger();
    }

    @Override // j0.l.a.i$a
    public void a() {
        c();
    }

    @Override // j0.l.a.i$a
    public void b() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.lazySet(null);
        }
    }

    public void c() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super T> subscriber = this.actual;
        AtomicReference<Object> atomicReference = this.queue;
        int iAddAndGet = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                if (j2 == j) {
                    break;
                }
                if (subscriber.isUnsubscribed()) {
                    atomicReference.lazySet(null);
                    return;
                }
                boolean z2 = this.done;
                Object andSet = atomicReference.getAndSet(null);
                boolean z3 = andSet == null;
                if (z2 && z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        super.onError(th);
                        return;
                    } else {
                        super.onCompleted();
                        return;
                    }
                }
                if (z3) {
                    break;
                }
                subscriber.onNext((Object) e.b(andSet));
                j2++;
            }
            if (j2 == j) {
                if (subscriber.isUnsubscribed()) {
                    atomicReference.lazySet(null);
                    return;
                }
                boolean z4 = this.done;
                boolean z5 = atomicReference.get() == null;
                if (z4 && z5) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        super.onError(th2);
                        return;
                    } else {
                        super.onCompleted();
                        return;
                    }
                }
            }
            if (j2 != 0) {
                b.i.a.f.e.o.f.U0(this, j2);
            }
            iAddAndGet = this.wip.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // j0.l.a.i$a, j0.g
    public void onCompleted() {
        this.done = true;
        c();
    }

    @Override // j0.l.a.i$a, j0.g
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        c();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // j0.g
    public void onNext(T t) {
        AtomicReference<Object> atomicReference = this.queue;
        Object obj = t;
        if (t == null) {
            obj = e.f3771b;
        }
        atomicReference.set(obj);
        c();
    }
}
