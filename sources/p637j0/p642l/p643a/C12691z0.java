package p637j0.p642l.p643a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p645c.C12708m;
import p637j0.p642l.p647e.C12719i;
import p637j0.p642l.p647e.p648n.C12726c;
import p637j0.p642l.p647e.p649o.C12744n;
import p637j0.p642l.p647e.p649o.C12755y;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.z0 */
/* JADX INFO: compiled from: OperatorObserveOn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12691z0<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final Scheduler f27145j;

    /* JADX INFO: renamed from: k */
    public final boolean f27146k;

    /* JADX INFO: renamed from: l */
    public final int f27147l;

    /* JADX INFO: renamed from: j0.l.a.z0$a */
    /* JADX INFO: compiled from: OperatorObserveOn.java */
    public static final class a<T> extends Subscriber<T> implements Action0 {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super T> f27148j;

        /* JADX INFO: renamed from: k */
        public final Scheduler.Worker f27149k;

        /* JADX INFO: renamed from: l */
        public final boolean f27150l;

        /* JADX INFO: renamed from: m */
        public final Queue<Object> f27151m;

        /* JADX INFO: renamed from: n */
        public final int f27152n;

        /* JADX INFO: renamed from: o */
        public volatile boolean f27153o;

        /* JADX INFO: renamed from: p */
        public final AtomicLong f27154p = new AtomicLong();

        /* JADX INFO: renamed from: q */
        public final AtomicLong f27155q = new AtomicLong();

        /* JADX INFO: renamed from: r */
        public Throwable f27156r;

        /* JADX INFO: renamed from: s */
        public long f27157s;

        public a(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z2, int i) {
            this.f27148j = subscriber;
            this.f27149k = scheduler.mo10739a();
            this.f27150l = z2;
            i = i <= 0 ? C12719i.f27283j : i;
            this.f27152n = i - (i >> 2);
            if (C12755y.m10858b()) {
                this.f27151m = new C12744n(i);
            } else {
                this.f27151m = new C12726c(i);
            }
            request(i);
        }

        /* JADX INFO: renamed from: a */
        public boolean m10793a(boolean z2, boolean z3, Subscriber<? super T> subscriber, Queue<Object> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.f27150l) {
                if (!z3) {
                    return false;
                }
                Throwable th = this.f27156r;
                try {
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onCompleted();
                    }
                    this.f27149k.unsubscribe();
                    return false;
                } catch (Throwable th2) {
                    this.f27149k.unsubscribe();
                    throw th2;
                }
            }
            Throwable th3 = this.f27156r;
            if (th3 != null) {
                queue.clear();
                try {
                    subscriber.onError(th3);
                    return true;
                } finally {
                    this.f27149k.unsubscribe();
                }
            }
            if (!z3) {
                return false;
            }
            try {
                subscriber.onCompleted();
                return true;
            } finally {
                this.f27149k.unsubscribe();
            }
        }

        /* JADX INFO: renamed from: b */
        public void m10794b() {
            if (this.f27155q.getAndIncrement() == 0) {
                this.f27149k.mo10740a(this);
            }
        }

        @Override // p658rx.functions.Action0
        public void call() {
            long j = this.f27157s;
            Queue<Object> queue = this.f27151m;
            Subscriber<? super T> subscriber = this.f27148j;
            long jAddAndGet = 1;
            do {
                long jM4250U0 = this.f27154p.get();
                while (jM4250U0 != j) {
                    boolean z2 = this.f27153o;
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (m10793a(z2, z3, subscriber, queue)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext((Object) C12614e.m10745b(objPoll));
                    j++;
                    if (j == this.f27152n) {
                        jM4250U0 = C3404f.m4250U0(this.f27154p, j);
                        request(j);
                        j = 0;
                    }
                }
                if (jM4250U0 == j && m10793a(this.f27153o, queue.isEmpty(), subscriber, queue)) {
                    return;
                }
                this.f27157s = j;
                jAddAndGet = this.f27155q.addAndGet(-jAddAndGet);
            } while (jAddAndGet != 0);
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (isUnsubscribed() || this.f27153o) {
                return;
            }
            this.f27153o = true;
            m10794b();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (isUnsubscribed() || this.f27153o) {
                C12774l.m10863b(th);
                return;
            }
            this.f27156r = th;
            this.f27153o = true;
            m10794b();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            Object obj;
            if (isUnsubscribed() || this.f27153o) {
                return;
            }
            Queue<Object> queue = this.f27151m;
            if (t == null) {
                obj = t;
                obj = C12614e.f26769b;
            }
            obj = t;
            if (queue.offer(obj)) {
                m10794b();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public C12691z0(Scheduler scheduler, boolean z2, int i) {
        this.f27145j = scheduler;
        this.f27146k = z2;
        this.f27147l = i <= 0 ? C12719i.f27283j : i;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler scheduler = this.f27145j;
        if (scheduler instanceof C12708m) {
            return subscriber;
        }
        a aVar = new a(scheduler, subscriber, this.f27146k, this.f27147l);
        Subscriber<? super T> subscriber2 = aVar.f27148j;
        subscriber2.setProducer(new C12688y0(aVar));
        subscriber2.add(aVar.f27149k);
        subscriber2.add(aVar);
        return aVar;
    }
}
