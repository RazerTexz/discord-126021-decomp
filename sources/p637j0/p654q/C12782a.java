package p637j0.p654q;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.InterfaceC12581g;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.subjects.Subject;

/* JADX INFO: renamed from: j0.q.a */
/* JADX INFO: compiled from: ReplaySubject.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12782a<T> extends Subject<T, T> {

    /* JADX INFO: renamed from: k */
    public static final Object[] f27397k = new Object[0];

    /* JADX INFO: renamed from: l */
    public final d<T> f27398l;

    /* JADX INFO: renamed from: j0.q.a$a */
    /* JADX INFO: compiled from: ReplaySubject.java */
    public interface a<T> {
    }

    /* JADX INFO: renamed from: j0.q.a$b */
    /* JADX INFO: compiled from: ReplaySubject.java */
    public static final class b<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        public final Subscriber<? super T> actual;
        public int index;
        public Object node;
        public final AtomicLong requested = new AtomicLong();
        public final d<T> state;
        public int tailIndex;

        public b(Subscriber<? super T> subscriber, d<T> dVar) {
            this.actual = subscriber;
            this.state = dVar;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            if (j > 0) {
                C3404f.m4276c0(this.requested, j);
                ((c) this.state.buffer).m10876a(this);
            } else if (j < 0) {
                throw new IllegalArgumentException(C1643a.m877t("n >= required but it was ", j));
            }
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.state.m10877a(this);
        }
    }

    /* JADX INFO: renamed from: j0.q.a$c */
    /* JADX INFO: compiled from: ReplaySubject.java */
    public static final class c<T> implements a<T> {

        /* JADX INFO: renamed from: a */
        public final int f27399a;

        /* JADX INFO: renamed from: b */
        public volatile a<T> f27400b;

        /* JADX INFO: renamed from: c */
        public a<T> f27401c;

        /* JADX INFO: renamed from: d */
        public int f27402d;

        /* JADX INFO: renamed from: e */
        public volatile boolean f27403e;

        /* JADX INFO: renamed from: f */
        public Throwable f27404f;

        /* JADX INFO: renamed from: j0.q.a$c$a */
        /* JADX INFO: compiled from: ReplaySubject.java */
        public static final class a<T> extends AtomicReference<a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            public final T value;

            public a(T t) {
                this.value = t;
            }
        }

        public c(int i) {
            this.f27399a = i;
            a<T> aVar = new a<>(null);
            this.f27401c = aVar;
            this.f27400b = aVar;
        }

        /* JADX INFO: renamed from: a */
        public void m10876a(b<T> bVar) {
            if (bVar.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = bVar.actual;
            int iAddAndGet = 1;
            do {
                long j = bVar.requested.get();
                a<T> aVar = (a) bVar.node;
                if (aVar == null) {
                    aVar = this.f27400b;
                }
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        bVar.node = null;
                        return;
                    }
                    boolean z2 = this.f27403e;
                    a<T> aVar2 = aVar.get();
                    boolean z3 = aVar2 == null;
                    if (z2 && z3) {
                        bVar.node = null;
                        Throwable th = this.f27404f;
                        if (th != null) {
                            subscriber.onError(th);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext(aVar2.value);
                    j2++;
                    aVar = aVar2;
                }
                if (j2 == j) {
                    if (subscriber.isUnsubscribed()) {
                        bVar.node = null;
                        return;
                    }
                    boolean z4 = this.f27403e;
                    boolean z5 = aVar.get() == null;
                    if (z4 && z5) {
                        bVar.node = null;
                        Throwable th2 = this.f27404f;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != RecyclerView.FOREVER_NS) {
                    C3404f.m4250U0(bVar.requested, j2);
                }
                bVar.node = aVar;
                iAddAndGet = bVar.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    /* JADX INFO: renamed from: j0.q.a$d */
    /* JADX INFO: compiled from: ReplaySubject.java */
    public static final class d<T> extends AtomicReference<b<T>[]> implements Observable.InterfaceC13005a<T>, InterfaceC12581g<T> {

        /* JADX INFO: renamed from: j */
        public static final b[] f27405j = new b[0];

        /* JADX INFO: renamed from: k */
        public static final b[] f27406k = new b[0];
        private static final long serialVersionUID = 5952362471246910544L;
        public final a<T> buffer;

        public d(a<T> aVar) {
            this.buffer = aVar;
            lazySet(f27405j);
        }

        /* JADX INFO: renamed from: a */
        public void m10877a(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = get();
                if (bVarArr == f27406k || bVarArr == f27405j) {
                    return;
                }
                int length = bVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (bVarArr[i] == bVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f27405j;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i);
                    System.arraycopy(bVarArr, i + 1, bVarArr3, i, (length - i) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!compareAndSet(bVarArr, bVarArr2));
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            boolean z2;
            Subscriber subscriber = (Subscriber) obj;
            b<T> bVar = new b<>(subscriber, this);
            subscriber.add(bVar);
            subscriber.setProducer(bVar);
            while (true) {
                b<T>[] bVarArr = get();
                z2 = false;
                if (bVarArr == f27406k) {
                    break;
                }
                int length = bVarArr.length;
                b[] bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
                if (compareAndSet(bVarArr, bVarArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2 && bVar.isUnsubscribed()) {
                m10877a(bVar);
            } else {
                ((c) this.buffer).m10876a(bVar);
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            a<T> aVar = this.buffer;
            ((c) aVar).f27403e = true;
            for (b<T> bVar : getAndSet(f27406k)) {
                ((c) aVar).m10876a(bVar);
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            a<T> aVar = this.buffer;
            c cVar = (c) aVar;
            cVar.f27404f = th;
            cVar.f27403e = true;
            ArrayList arrayList = null;
            for (b<T> bVar : getAndSet(f27406k)) {
                try {
                    ((c) aVar).m10876a(bVar);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            C3404f.m4321n1(arrayList);
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            a<T> aVar = this.buffer;
            c cVar = (c) aVar;
            Objects.requireNonNull(cVar);
            c.a<T> aVar2 = new c.a<>(t);
            cVar.f27401c.set(aVar2);
            cVar.f27401c = aVar2;
            int i = cVar.f27402d;
            if (i == cVar.f27399a) {
                cVar.f27400b = cVar.f27400b.get();
            } else {
                cVar.f27402d = i + 1;
            }
            for (b<T> bVar : get()) {
                ((c) aVar).m10876a(bVar);
            }
        }
    }

    public C12782a(d<T> dVar) {
        super(dVar);
        this.f27398l = dVar;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27398l.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27398l.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f27398l.onNext(t);
    }
}
