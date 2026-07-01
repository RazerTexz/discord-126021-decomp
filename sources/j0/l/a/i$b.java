package j0.l.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeCreate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i$b<T> extends i$a<T> {
    private static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    public i$b(Subscriber<? super T> subscriber, int i) {
        super(subscriber);
        this.queue = j0.l.e.o.y.b() ? new j0.l.e.o.t<>(i) : new j0.l.e.n.g<>(i);
        this.wip = new AtomicInteger();
    }

    @Override // j0.l.a.i$a
    public void a() {
        c();
    }

    @Override // j0.l.a.i$a
    public void b() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void c() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super T> subscriber = this.actual;
        Queue<Object> queue = this.queue;
        int iAddAndGet = 1;
        do {
            long j = get();
            long j2 = 0;
            while (j2 != j) {
                if (subscriber.isUnsubscribed()) {
                    queue.clear();
                    return;
                }
                boolean z2 = this.done;
                Object objPoll = queue.poll();
                boolean z3 = objPoll == null;
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
                subscriber.onNext((Object) e.b(objPoll));
                j2++;
            }
            if (j2 == j) {
                if (subscriber.isUnsubscribed()) {
                    queue.clear();
                    return;
                }
                boolean z4 = this.done;
                boolean zIsEmpty = queue.isEmpty();
                if (z4 && zIsEmpty) {
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
        Queue<Object> queue = this.queue;
        Object obj = t;
        if (t == null) {
            obj = e.f3771b;
        }
        queue.offer(obj);
        c();
    }
}
