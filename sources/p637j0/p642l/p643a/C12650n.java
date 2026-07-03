package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12662q;
import p637j0.p642l.p647e.C12719i;
import p637j0.p642l.p647e.EnumC12714d;
import p637j0.p642l.p647e.p648n.C12726c;
import p637j0.p642l.p647e.p648n.C12728e;
import p637j0.p642l.p647e.p649o.C12744n;
import p637j0.p642l.p647e.p649o.C12755y;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;

/* JADX INFO: renamed from: j0.l.a.n */
/* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12650n<T, R> implements Observable.InterfaceC13005a<R> {

    /* JADX INFO: renamed from: j */
    public final Observable<? extends T> f26916j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC12589b<? super T, ? extends Iterable<? extends R>> f26917k;

    /* JADX INFO: renamed from: l */
    public final int f26918l;

    /* JADX INFO: renamed from: j0.l.a.n$a */
    /* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
    public static final class a<T, R> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super R> f26919j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC12589b<? super T, ? extends Iterable<? extends R>> f26920k;

        /* JADX INFO: renamed from: l */
        public final long f26921l;

        /* JADX INFO: renamed from: m */
        public final Queue<Object> f26922m;

        /* JADX INFO: renamed from: q */
        public volatile boolean f26926q;

        /* JADX INFO: renamed from: r */
        public long f26927r;

        /* JADX INFO: renamed from: s */
        public Iterator<? extends R> f26928s;

        /* JADX INFO: renamed from: n */
        public final AtomicReference<Throwable> f26923n = new AtomicReference<>();

        /* JADX INFO: renamed from: p */
        public final AtomicInteger f26925p = new AtomicInteger();

        /* JADX INFO: renamed from: o */
        public final AtomicLong f26924o = new AtomicLong();

        public a(Subscriber<? super R> subscriber, InterfaceC12589b<? super T, ? extends Iterable<? extends R>> interfaceC12589b, int i) {
            this.f26919j = subscriber;
            this.f26920k = interfaceC12589b;
            if (i == Integer.MAX_VALUE) {
                this.f26921l = RecyclerView.FOREVER_NS;
                this.f26922m = new C12728e(C12719i.f27283j);
            } else {
                this.f26921l = i - (i >> 2);
                if (C12755y.m10858b()) {
                    this.f26922m = new C12744n(i);
                } else {
                    this.f26922m = new C12726c(i);
                }
            }
            request(i);
        }

        /* JADX INFO: renamed from: a */
        public boolean m10772a(boolean z2, boolean z3, Subscriber<?> subscriber, Queue<?> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                this.f26928s = null;
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.f26923n.get() == null) {
                if (!z3) {
                    return false;
                }
                subscriber.onCompleted();
                return true;
            }
            Throwable thM10813h = EnumC12714d.m10813h(this.f26923n);
            unsubscribe();
            queue.clear();
            this.f26928s = null;
            subscriber.onError(thM10813h);
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0063  */
        /* JADX WARN: Code duplicated, block: B:28:0x0066  */
        /* JADX WARN: Code duplicated, block: B:31:0x0072  */
        /* JADX WARN: Code duplicated, block: B:38:0x008b  */
        /* JADX WARN: Code duplicated, block: B:49:0x00af  */
        /* JADX WARN: Code duplicated, block: B:58:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:64:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:72:0x007a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:73:0x008a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:74:0x00c0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:75:0x00cc A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:76:0x00d8 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:77:0x00cf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:78:0x00cf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:81:0x0010 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x0092 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:? A[LOOP:1: B:29:0x006d->B:84:?, LOOP_END, SYNTHETIC] */
        /* JADX INFO: renamed from: b */
        public void m10773b() {
            int i;
            long j;
            long j2;
            boolean z2;
            if (this.f26925p.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.f26919j;
            Queue<?> queue = this.f26922m;
            int iAddAndGet = 1;
            while (true) {
                Iterator<? extends R> it = this.f26928s;
                boolean z3 = false;
                if (it == null) {
                    boolean z4 = this.f26926q;
                    Object objPoll = queue.poll();
                    boolean z5 = objPoll == null;
                    if (m10772a(z4, z5, subscriber, queue)) {
                        return;
                    }
                    if (z5) {
                        i = iAddAndGet;
                    } else {
                        long j3 = this.f26927r + 1;
                        i = iAddAndGet;
                        if (j3 == this.f26921l) {
                            this.f26927r = 0L;
                            request(j3);
                        } else {
                            this.f26927r = j3;
                        }
                        try {
                            it = this.f26920k.call((Object) C12614e.m10745b(objPoll)).iterator();
                            if (it.hasNext()) {
                                this.f26928s = it;
                            }
                        } catch (Throwable th) {
                            C3404f.m4325o1(th);
                            onError(th);
                        }
                    }
                    if (it != null) {
                        j = this.f26924o.get();
                        j2 = 0;
                        while (j2 != j) {
                            if (m10772a(this.f26926q, false, subscriber, queue)) {
                                return;
                            }
                            try {
                                subscriber.onNext(it.next());
                                if (m10772a(this.f26926q, false, subscriber, queue)) {
                                    return;
                                }
                                j2++;
                                try {
                                    if (!it.hasNext()) {
                                        this.f26928s = null;
                                        it = null;
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    C3404f.m4325o1(th2);
                                    this.f26928s = null;
                                    onError(th2);
                                }
                            } catch (Throwable th3) {
                                C3404f.m4325o1(th3);
                                this.f26928s = null;
                                onError(th3);
                            }
                        }
                        if (j2 == j) {
                            z2 = this.f26926q;
                            if (queue.isEmpty() && it == null) {
                                z3 = true;
                            }
                            if (m10772a(z2, z3, subscriber, queue)) {
                                return;
                            }
                        }
                        if (j2 != 0) {
                            C3404f.m4250U0(this.f26924o, j2);
                        }
                        if (it == null) {
                        }
                    }
                    iAddAndGet = this.f26925p.addAndGet(-i);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    i = iAddAndGet;
                    if (it != null) {
                        j = this.f26924o.get();
                        j2 = 0;
                        while (j2 != j) {
                            if (m10772a(this.f26926q, false, subscriber, queue)) {
                                return;
                            }
                            subscriber.onNext(it.next());
                            if (m10772a(this.f26926q, false, subscriber, queue)) {
                                return;
                            }
                            j2++;
                            if (!it.hasNext()) {
                                this.f26928s = null;
                                it = null;
                                break;
                            }
                        }
                        if (j2 == j) {
                            z2 = this.f26926q;
                            if (queue.isEmpty()) {
                                z3 = true;
                            }
                            if (m10772a(z2, z3, subscriber, queue)) {
                                return;
                            }
                        }
                        if (j2 != 0) {
                            C3404f.m4250U0(this.f26924o, j2);
                        }
                        if (it == null) {
                        }
                    }
                    iAddAndGet = this.f26925p.addAndGet(-i);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
                iAddAndGet = i;
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            this.f26926q = true;
            m10773b();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (!EnumC12714d.m10811f(this.f26923n, th)) {
                C12774l.m10863b(th);
            } else {
                this.f26926q = true;
                m10773b();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            Queue<Object> queue = this.f26922m;
            Object obj = t;
            if (t == null) {
                obj = C12614e.f26769b;
            }
            if (queue.offer(obj)) {
                m10773b();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.n$b */
    /* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
    public static final class b<T, R> implements Observable.InterfaceC13005a<R> {

        /* JADX INFO: renamed from: j */
        public final T f26929j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC12589b<? super T, ? extends Iterable<? extends R>> f26930k;

        public b(T t, InterfaceC12589b<? super T, ? extends Iterable<? extends R>> interfaceC12589b) {
            this.f26929j = t;
            this.f26930k = interfaceC12589b;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            try {
                Iterator<? extends R> it = this.f26930k.call(this.f26929j).iterator();
                if (it.hasNext()) {
                    subscriber.setProducer(new C12662q.a(subscriber, it));
                } else {
                    subscriber.onCompleted();
                }
            } catch (Throwable th) {
                C3404f.m4329p1(th, subscriber, this.f26929j);
            }
        }
    }

    public C12650n(Observable<? extends T> observable, InterfaceC12589b<? super T, ? extends Iterable<? extends R>> interfaceC12589b, int i) {
        this.f26916j = observable;
        this.f26917k = interfaceC12589b;
        this.f26918l = i;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.f26917k, this.f26918l);
        subscriber.add(aVar);
        subscriber.setProducer(new C12646m(this, aVar));
        this.f26916j.m11107i0(aVar);
    }
}
