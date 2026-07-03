package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p637j0.InterfaceC12581g;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;

/* JADX INFO: renamed from: j0.l.a.b1 */
/* JADX INFO: compiled from: OperatorOnBackpressureLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12604b1<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j0.l.a.b1$a */
    /* JADX INFO: compiled from: OperatorOnBackpressureLatest.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final C12604b1<Object> f26740a = new C12604b1<>();
    }

    /* JADX INFO: renamed from: j0.l.a.b1$b */
    /* JADX INFO: compiled from: OperatorOnBackpressureLatest.java */
    public static final class b<T> extends AtomicLong implements Producer, Subscription, InterfaceC12581g<T> {

        /* JADX INFO: renamed from: j */
        public static final Object f26741j = new Object();
        private static final long serialVersionUID = -1364393685005146274L;
        public final Subscriber<? super T> child;
        public volatile boolean done;
        public boolean emitting;
        public boolean missed;
        public c<? super T> parent;
        public Throwable terminal;
        public final AtomicReference<Object> value = new AtomicReference<>(f26741j);

        public b(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            lazySet(-4611686018427387904L);
        }

        /* JADX INFO: renamed from: a */
        public void m10743a() throws Throwable {
            boolean z2;
            Object obj;
            long j;
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
                        long j2 = get();
                        if (j2 == Long.MIN_VALUE) {
                            return;
                        }
                        Object obj2 = this.value.get();
                        if (j2 > 0 && obj2 != (obj = f26741j)) {
                            this.child.onNext(obj2);
                            this.value.compareAndSet(obj2, obj);
                            do {
                                j = get();
                                if (j < 0) {
                                    break;
                                }
                            } while (!compareAndSet(j, j - 1));
                            obj2 = f26741j;
                        }
                        if (obj2 == f26741j && this.done) {
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

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) throws Throwable {
            long j2;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j2 == -4611686018427387904L) {
                        j3 = j;
                    } else {
                        j3 = j2 + j;
                        if (j3 < 0) {
                            j3 = Long.MAX_VALUE;
                        }
                    }
                } while (!compareAndSet(j2, j3));
                if (j2 == -4611686018427387904L) {
                    this.parent.request(RecyclerView.FOREVER_NS);
                }
                m10743a();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() throws Throwable {
            this.done = true;
            m10743a();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) throws Throwable {
            this.terminal = th;
            this.done = true;
            m10743a();
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) throws Throwable {
            this.value.lazySet(t);
            m10743a();
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.b1$c */
    /* JADX INFO: compiled from: OperatorOnBackpressureLatest.java */
    public static final class c<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final b<T> f26742j;

        public c(b<T> bVar) {
            this.f26742j = bVar;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() throws Throwable {
            this.f26742j.onCompleted();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) throws Throwable {
            b<T> bVar = this.f26742j;
            bVar.terminal = th;
            bVar.done = true;
            bVar.m10743a();
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) throws Throwable {
            b<T> bVar = this.f26742j;
            bVar.value.lazySet(t);
            bVar.m10743a();
        }

        @Override // p658rx.Subscriber
        public void onStart() {
            request(0L);
        }
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        b bVar = new b(subscriber);
        c<? super T> cVar = new c<>(bVar);
        bVar.parent = cVar;
        subscriber.add(cVar);
        subscriber.add(bVar);
        subscriber.setProducer(bVar);
        return cVar;
    }
}
