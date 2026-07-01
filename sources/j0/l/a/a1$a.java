package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.a$b;
import j0.l.e.c$a;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a1$a<T> extends Subscriber<T> implements c$a {
    public final Subscriber<? super T> l;
    public final a$b p;
    public final ConcurrentLinkedQueue<Object> j = new ConcurrentLinkedQueue<>();
    public final AtomicBoolean m = new AtomicBoolean(false);
    public final AtomicLong k = null;
    public final Action0 o = null;
    public final j0.l.e.c n = new j0.l.e.c(this);

    public a1$a(Subscriber<? super T> subscriber, Long l, Action0 action0, a$b a_b) {
        this.l = subscriber;
        this.p = a_b;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.m.get()) {
            return;
        }
        j0.l.e.c cVar = this.n;
        cVar.terminated = true;
        cVar.a();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.m.get()) {
            return;
        }
        j0.l.e.c cVar = this.n;
        if (cVar.terminated) {
            return;
        }
        cVar.exception = th;
        cVar.terminated = true;
        cVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0040  */
    /* JADX WARN: Code duplicated, block: B:44:0x006b A[EDGE_INSN: B:44:0x006b->B:33:0x006b BREAK  A[LOOP:0: B:5:0x0008->B:46:?], SYNTHETIC] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // j0.g
    public void onNext(T t) {
        boolean z2;
        Object obj;
        boolean z3 = false;
        if (this.k == null) {
            z3 = true;
            break;
        }
        while (true) {
            long j = this.k.get();
            if (j <= 0) {
                try {
                    if (this.p.a()) {
                        Object objPoll = this.j.poll();
                        AtomicLong atomicLong = this.k;
                        if (atomicLong != null && objPoll != null) {
                            atomicLong.incrementAndGet();
                        }
                        if (objPoll != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                } catch (MissingBackpressureException e) {
                    if (this.m.compareAndSet(false, true)) {
                        unsubscribe();
                        this.l.onError(e);
                    }
                }
                Action0 action0 = this.o;
                if (action0 == null) {
                    if (z2) {
                        break;
                        break;
                    }
                    break;
                }
                try {
                    action0.call();
                    if (z2) {
                        break;
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    b.i.a.f.e.o.f.o1(th);
                    j0.l.e.c cVar = this.n;
                    if (!cVar.terminated) {
                        cVar.exception = th;
                        cVar.terminated = true;
                        cVar.a();
                    }
                }
            }
            if (this.k.compareAndSet(j, j - 1)) {
                z3 = true;
                break;
            }
        }
        if (z3) {
            ConcurrentLinkedQueue<Object> concurrentLinkedQueue = this.j;
            if (t == null) {
                obj = t;
                obj = e.f3771b;
            }
            obj = t;
            concurrentLinkedQueue.offer(obj);
            this.n.a();
        }
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
