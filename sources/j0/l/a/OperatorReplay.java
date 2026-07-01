package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import j0.l.a.NotificationLite;
import j0.l.e.OpenHashSet;
import j0.m.ConnectableObservable;
import j0.r.BooleanSubscription;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action1;
import rx.functions.Func0;

/* JADX INFO: renamed from: j0.l.a.j1, reason: use source file name */
/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorReplay<T> extends ConnectableObservable<T> implements Subscription {
    public static final Func0 k = new a();
    public final Observable<? extends T> l;
    public final AtomicReference<f<T>> m;
    public final Func0<? extends e<T>> n;

    /* JADX INFO: renamed from: j0.l.a.j1$a */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public static class a implements Func0 {
        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Object call() {
            return new h(16);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.j1$b */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public static class b<T> extends AtomicReference<d> implements e<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public long index;
        public int size;
        public d tail;

        public b() {
            d dVar = new d(null, 0L);
            this.tail = dVar;
            set(dVar);
        }

        public void a() {
        }

        @Override // j0.l.a.OperatorReplay.e
        public final void complete() {
            Object obj = NotificationLite.a;
            long j = this.index + 1;
            this.index = j;
            d dVar = new d(obj, j);
            this.tail.set(dVar);
            this.tail = dVar;
            this.size++;
        }

        @Override // j0.l.a.OperatorReplay.e
        public final void g(T t) {
            if (t == null) {
                t = (T) NotificationLite.f3771b;
            }
            long j = this.index + 1;
            this.index = j;
            d dVar = new d(t, j);
            this.tail.set(dVar);
            this.tail = dVar;
            this.size++;
            a();
        }

        @Override // j0.l.a.OperatorReplay.e
        public final void h(c<T> cVar) {
            Subscriber<? super T> subscriber;
            d dVar;
            synchronized (cVar) {
                if (cVar.emitting) {
                    cVar.missed = true;
                    return;
                }
                cVar.emitting = true;
                while (!cVar.isUnsubscribed()) {
                    d dVar2 = (d) cVar.index;
                    if (dVar2 == null) {
                        dVar2 = get();
                        cVar.index = dVar2;
                        cVar.a(dVar2.index);
                    }
                    if (cVar.isUnsubscribed() || (subscriber = cVar.child) == null) {
                        return;
                    }
                    long j = cVar.get();
                    long j2 = 0;
                    while (j2 != j && (dVar = dVar2.get()) != null) {
                        Object obj = dVar.value;
                        try {
                            if (NotificationLite.a(subscriber, obj)) {
                                cVar.index = null;
                                return;
                            }
                            j2++;
                            if (cVar.isUnsubscribed()) {
                                return;
                            } else {
                                dVar2 = dVar;
                            }
                        } catch (Throwable th) {
                            cVar.index = null;
                            b.i.a.f.e.o.f.o1(th);
                            cVar.unsubscribe();
                            if ((obj instanceof NotificationLite.c) || NotificationLite.c(obj)) {
                                return;
                            }
                            subscriber.onError(OnErrorThrowable.a(th, NotificationLite.b(obj)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        cVar.index = dVar2;
                        if (j != RecyclerView.FOREVER_NS) {
                            cVar.b(j2);
                        }
                    }
                    synchronized (cVar) {
                        if (!cVar.missed) {
                            cVar.emitting = false;
                            return;
                        }
                        cVar.missed = false;
                    }
                }
            }
        }

        @Override // j0.l.a.OperatorReplay.e
        public final void i(Throwable th) {
            NotificationLite.c cVar = new NotificationLite.c(th);
            long j = this.index + 1;
            this.index = j;
            d dVar = new d(cVar, j);
            this.tail.set(dVar);
            this.tail = dVar;
            this.size++;
        }
    }

    /* JADX INFO: renamed from: j0.l.a.j1$c */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public static final class c<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        public Subscriber<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final f<T> parent;
        public final AtomicLong totalRequested = new AtomicLong();

        public c(f<T> fVar, Subscriber<? super T> subscriber) {
            this.parent = fVar;
            this.child = subscriber;
        }

        public void a(long j) {
            long j2;
            long j3;
            do {
                j2 = this.totalRequested.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = RecyclerView.FOREVER_NS;
                }
            } while (!this.totalRequested.compareAndSet(j2, j3));
        }

        public long b(long j) {
            long j2;
            long j3;
            if (j <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("More produced (");
                    sb.append(j);
                    sb.append(") than requested (");
                    throw new IllegalStateException(outline.C(sb, j2, ")"));
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.Producer
        public void j(long j) {
            long j2;
            long j3;
            if (j < 0) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && j == 0) {
                    return;
                }
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = RecyclerView.FOREVER_NS;
                }
            } while (!compareAndSet(j2, j3));
            a(j);
            this.parent.c(this);
            this.parent.k.h(this);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            f<T> fVar = this.parent;
            if (!fVar.m) {
                synchronized (fVar.n) {
                    if (!fVar.m) {
                        OpenHashSet<c<T>> openHashSet = fVar.n;
                        c<T>[] cVarArr = openHashSet.d;
                        int i = openHashSet.a;
                        int iB = OpenHashSet.b(hashCode()) & i;
                        c<T> cVar = cVarArr[iB];
                        boolean z2 = true;
                        if (cVar != null) {
                            if (!cVar.equals(this)) {
                                while (true) {
                                    iB = (iB + 1) & i;
                                    c<T> cVar2 = cVarArr[iB];
                                    if (cVar2 == null) {
                                        break;
                                    } else if (cVar2.equals(this)) {
                                        openHashSet.c(iB, cVarArr, i);
                                        break;
                                    }
                                }
                            } else {
                                openHashSet.c(iB, cVarArr, i);
                            }
                        }
                        if (fVar.n.f3794b != 0) {
                            z2 = false;
                        }
                        if (z2) {
                            fVar.o = f.j;
                        }
                        fVar.p++;
                    }
                }
            }
            this.parent.c(this);
            this.child = null;
        }
    }

    /* JADX INFO: renamed from: j0.l.a.j1$d */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public static final class d extends AtomicReference<d> {
        private static final long serialVersionUID = 245354315435971818L;
        public final long index;
        public final Object value;

        public d(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    /* JADX INFO: renamed from: j0.l.a.j1$e */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public interface e<T> {
        void complete();

        void g(T t);

        void h(c<T> cVar);

        void i(Throwable th);
    }

    /* JADX INFO: renamed from: j0.l.a.j1$f */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public static final class f<T> extends Subscriber<T> implements Subscription {
        public static final c[] j = new c[0];
        public final e<T> k;
        public boolean l;
        public volatile boolean m;
        public volatile long p;
        public long q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f3774s;
        public boolean t;
        public long u;
        public long v;
        public volatile Producer w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public List<c<T>> f3775x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f3776y;
        public final OpenHashSet<c<T>> n = new OpenHashSet<>();
        public c<T>[] o = j;
        public final AtomicBoolean r = new AtomicBoolean();

        public f(e<T> eVar) {
            this.k = eVar;
            request(0L);
        }

        public c<T>[] a() {
            c<T>[] cVarArr;
            synchronized (this.n) {
                c<T>[] cVarArr2 = this.n.d;
                int length = cVarArr2.length;
                cVarArr = new c[length];
                System.arraycopy(cVarArr2, 0, cVarArr, 0, length);
            }
            return cVarArr;
        }

        public void b(long j2, long j3) {
            long j4 = this.v;
            Producer producer = this.w;
            long j5 = j2 - j3;
            if (j5 == 0) {
                if (j4 == 0 || producer == null) {
                    return;
                }
                this.v = 0L;
                producer.j(j4);
                return;
            }
            this.u = j2;
            if (producer == null) {
                long j6 = j4 + j5;
                if (j6 < 0) {
                    j6 = RecyclerView.FOREVER_NS;
                }
                this.v = j6;
                return;
            }
            if (j4 == 0) {
                producer.j(j5);
            } else {
                this.v = 0L;
                producer.j(j4 + j5);
            }
        }

        public void c(c<T> cVar) {
            long jMax;
            List<c<T>> list;
            boolean z2;
            long jMax2;
            if (isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.f3774s) {
                    if (cVar != null) {
                        List arrayList = this.f3775x;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            this.f3775x = arrayList;
                        }
                        arrayList.add(cVar);
                    } else {
                        this.f3776y = true;
                    }
                    this.t = true;
                    return;
                }
                this.f3774s = true;
                long j2 = this.u;
                if (cVar != null) {
                    jMax = Math.max(j2, cVar.totalRequested.get());
                } else {
                    long jMax3 = j2;
                    for (c<T> cVar2 : a()) {
                        if (cVar2 != null) {
                            jMax3 = Math.max(jMax3, cVar2.totalRequested.get());
                        }
                    }
                    jMax = jMax3;
                }
                b(jMax, j2);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.t) {
                            this.f3774s = false;
                            return;
                        }
                        this.t = false;
                        list = this.f3775x;
                        this.f3775x = null;
                        z2 = this.f3776y;
                        this.f3776y = false;
                    }
                    long j3 = this.u;
                    if (list != null) {
                        Iterator<c<T>> it = list.iterator();
                        jMax2 = j3;
                        while (it.hasNext()) {
                            jMax2 = Math.max(jMax2, it.next().totalRequested.get());
                        }
                    } else {
                        jMax2 = j3;
                    }
                    if (z2) {
                        for (c<T> cVar3 : a()) {
                            if (cVar3 != null) {
                                jMax2 = Math.max(jMax2, cVar3.totalRequested.get());
                            }
                        }
                    }
                    b(jMax2, j3);
                }
            }
        }

        public void d() {
            c<T>[] cVarArr = this.o;
            if (this.q != this.p) {
                synchronized (this.n) {
                    cVarArr = this.o;
                    c<T>[] cVarArr2 = this.n.d;
                    int length = cVarArr2.length;
                    if (cVarArr.length != length) {
                        cVarArr = new c[length];
                        this.o = cVarArr;
                    }
                    System.arraycopy(cVarArr2, 0, cVarArr, 0, length);
                    this.q = this.p;
                }
            }
            e<T> eVar = this.k;
            for (c<T> cVar : cVarArr) {
                if (cVar != null) {
                    eVar.h(cVar);
                }
            }
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.l) {
                return;
            }
            this.l = true;
            try {
                this.k.complete();
                d();
            } finally {
                unsubscribe();
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (this.l) {
                return;
            }
            this.l = true;
            try {
                this.k.i(th);
                d();
            } finally {
                unsubscribe();
            }
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            if (this.l) {
                return;
            }
            this.k.g(t);
            d();
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            if (this.w != null) {
                throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
            }
            this.w = producer;
            c(null);
            d();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.j1$g */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public static final class g<T> extends b<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public g(int i) {
            this.limit = i;
        }

        @Override // j0.l.a.OperatorReplay.b
        public void a() {
            if (this.size > this.limit) {
                d dVar = get().get();
                if (dVar == null) {
                    throw new IllegalStateException("Empty list!");
                }
                this.size--;
                set(dVar);
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.j1$h */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public static final class h<T> extends ArrayList<Object> implements e<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public h(int i) {
            super(i);
        }

        @Override // j0.l.a.OperatorReplay.e
        public void complete() {
            add(NotificationLite.a);
            this.size++;
        }

        @Override // j0.l.a.OperatorReplay.e
        public void g(T t) {
            if (t == null) {
                t = (T) NotificationLite.f3771b;
            }
            add(t);
            this.size++;
        }

        @Override // j0.l.a.OperatorReplay.e
        public void h(c<T> cVar) {
            synchronized (cVar) {
                if (cVar.emitting) {
                    cVar.missed = true;
                    return;
                }
                cVar.emitting = true;
                while (!cVar.isUnsubscribed()) {
                    int i = this.size;
                    Integer num = (Integer) cVar.index;
                    int iIntValue = num != null ? num.intValue() : 0;
                    Subscriber<? super T> subscriber = cVar.child;
                    if (subscriber == null) {
                        return;
                    }
                    long j = cVar.get();
                    long j2 = 0;
                    while (j2 != j && iIntValue < i) {
                        Object obj = get(iIntValue);
                        try {
                            if (NotificationLite.a(subscriber, obj) || cVar.isUnsubscribed()) {
                                return;
                            }
                            iIntValue++;
                            j2++;
                        } catch (Throwable th) {
                            b.i.a.f.e.o.f.o1(th);
                            cVar.unsubscribe();
                            if ((obj instanceof NotificationLite.c) || NotificationLite.c(obj)) {
                                return;
                            }
                            subscriber.onError(OnErrorThrowable.a(th, NotificationLite.b(obj)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        cVar.index = Integer.valueOf(iIntValue);
                        if (j != RecyclerView.FOREVER_NS) {
                            cVar.b(j2);
                        }
                    }
                    synchronized (cVar) {
                        if (!cVar.missed) {
                            cVar.emitting = false;
                            return;
                        }
                        cVar.missed = false;
                    }
                }
            }
        }

        @Override // j0.l.a.OperatorReplay.e
        public void i(Throwable th) {
            add(new NotificationLite.c(th));
            this.size++;
        }
    }

    public OperatorReplay(Observable.a<T> aVar, Observable<? extends T> observable, AtomicReference<f<T>> atomicReference, Func0<? extends e<T>> func0) {
        super(aVar);
        this.l = observable;
        this.m = atomicReference;
        this.n = func0;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        f<T> fVar = this.m.get();
        return fVar == null || fVar.isUnsubscribed();
    }

    @Override // j0.m.ConnectableObservable
    public void k0(Action1<? super Subscription> action1) {
        f<T> fVar;
        while (true) {
            fVar = this.m.get();
            if (fVar != null && !fVar.isUnsubscribed()) {
                break;
            }
            f<T> fVar2 = new f<>(this.n.call());
            fVar2.add(new BooleanSubscription(new OperatorReplay4(fVar2)));
            if (this.m.compareAndSet(fVar, fVar2)) {
                fVar = fVar2;
                break;
            }
        }
        boolean z2 = !fVar.r.get() && fVar.r.compareAndSet(false, true);
        ((OnSubscribeRefCount4) action1).call(fVar);
        if (z2) {
            this.l.i0(fVar);
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.m.lazySet(null);
    }
}
