package j0.l.a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import j0.Observer2;
import j0.l.e.n.SpscLinkedAtomicQueue;
import j0.l.e.o.SpscLinkedQueue;
import j0.l.e.o.UnsafeAccess;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.o1, reason: use source file name */
/* JADX INFO: compiled from: OperatorScan.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorScan<R, T> implements Observable.b<R, T> {
    public static final Object j = new Object();
    public final Func0<R> k;
    public final Func2<R, ? super T, R> l;

    /* JADX INFO: renamed from: j0.l.a.o1$a */
    /* JADX INFO: compiled from: OperatorScan.java */
    public class a implements Func0<R> {
        public final /* synthetic */ Object j;

        public a(Object obj) {
            this.j = obj;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public R call() {
            return (R) this.j;
        }
    }

    /* JADX INFO: renamed from: j0.l.a.o1$b */
    /* JADX INFO: compiled from: OperatorScan.java */
    public static final class b<R> implements Producer, Observer2<R> {
        public final Subscriber<? super R> j;
        public final Queue<Object> k;
        public boolean l;
        public boolean m;
        public long n;
        public final AtomicLong o;
        public volatile Producer p;
        public volatile boolean q;
        public Throwable r;

        public b(R r, Subscriber<? super R> subscriber) {
            this.j = subscriber;
            Queue<Object> spscLinkedQueue = UnsafeAccess.b() ? new SpscLinkedQueue<>() : new SpscLinkedAtomicQueue<>();
            this.k = spscLinkedQueue;
            spscLinkedQueue.offer(r == null ? (R) NotificationLite.f3771b : r);
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
                        R r = (Object) NotificationLite.b(objPoll);
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
                throw new IllegalArgumentException(outline.t("n >= required but it was ", j));
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

        @Override // j0.Observer2
        public void onCompleted() {
            this.q = true;
            b();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            this.r = th;
            this.q = true;
            b();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j0.Observer2
        public void onNext(R r) {
            Queue<Object> queue = this.k;
            Object obj = r;
            if (r == null) {
                obj = NotificationLite.f3771b;
            }
            queue.offer(obj);
            b();
        }
    }

    public OperatorScan(R r, Func2<R, ? super T, R> func2) {
        this.k = new a(r);
        this.l = func2;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        R rCall = this.k.call();
        if (rCall == j) {
            return new OperatorScan2(this, subscriber, subscriber);
        }
        b bVar = new b(rCall, subscriber);
        OperatorScan3 operatorScan3 = new OperatorScan3(this, rCall, bVar);
        subscriber.add(operatorScan3);
        subscriber.setProducer(bVar);
        return operatorScan3;
    }
}
