package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.C12614e;
import p637j0.p642l.p647e.C12717g;
import p637j0.p650m.AbstractC12757b;
import p637j0.p655r.C12785a;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.exceptions.OnErrorThrowable;
import p658rx.functions.Action1;
import p658rx.functions.Func0;

/* JADX INFO: renamed from: j0.l.a.j1 */
/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12636j1<T> extends AbstractC12757b<T> implements Subscription {

    /* JADX INFO: renamed from: k */
    public static final Func0 f26857k = new a();

    /* JADX INFO: renamed from: l */
    public final Observable<? extends T> f26858l;

    /* JADX INFO: renamed from: m */
    public final AtomicReference<f<T>> f26859m;

    /* JADX INFO: renamed from: n */
    public final Func0<? extends e<T>> f26860n;

    /* JADX INFO: renamed from: j0.l.a.j1$a */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public static class a implements Func0 {
        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
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

        /* JADX INFO: renamed from: a */
        public void mo10762a() {
        }

        @Override // p637j0.p642l.p643a.C12636j1.e
        public final void complete() {
            Object obj = C12614e.f26768a;
            long j = this.index + 1;
            this.index = j;
            d dVar = new d(obj, j);
            this.tail.set(dVar);
            this.tail = dVar;
            this.size++;
        }

        @Override // p637j0.p642l.p643a.C12636j1.e
        /* JADX INFO: renamed from: g */
        public final void mo10763g(T t) {
            if (t == null) {
                t = (T) C12614e.f26769b;
            }
            long j = this.index + 1;
            this.index = j;
            d dVar = new d(t, j);
            this.tail.set(dVar);
            this.tail = dVar;
            this.size++;
            mo10762a();
        }

        @Override // p637j0.p642l.p643a.C12636j1.e
        /* JADX INFO: renamed from: h */
        public final void mo10764h(c<T> cVar) {
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
                        cVar.m10766a(dVar2.index);
                    }
                    if (cVar.isUnsubscribed() || (subscriber = cVar.child) == null) {
                        return;
                    }
                    long j = cVar.get();
                    long j2 = 0;
                    while (j2 != j && (dVar = dVar2.get()) != null) {
                        Object obj = dVar.value;
                        try {
                            if (C12614e.m10744a(subscriber, obj)) {
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
                            C3404f.m4325o1(th);
                            cVar.unsubscribe();
                            if ((obj instanceof C12614e.c) || C12614e.m10746c(obj)) {
                                return;
                            }
                            subscriber.onError(OnErrorThrowable.m11126a(th, C12614e.m10745b(obj)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        cVar.index = dVar2;
                        if (j != RecyclerView.FOREVER_NS) {
                            cVar.m10767b(j2);
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

        @Override // p637j0.p642l.p643a.C12636j1.e
        /* JADX INFO: renamed from: i */
        public final void mo10765i(Throwable th) {
            C12614e.c cVar = new C12614e.c(th);
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

        /* JADX INFO: renamed from: a */
        public void m10766a(long j) {
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

        /* JADX INFO: renamed from: b */
        public long m10767b(long j) {
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
                    throw new IllegalStateException(C1643a.m815C(sb, j2, ")"));
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
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
            m10766a(j);
            this.parent.m10770c(this);
            this.parent.f26862k.mo10764h(this);
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            f<T> fVar = this.parent;
            if (!fVar.f26864m) {
                synchronized (fVar.f26865n) {
                    if (!fVar.f26864m) {
                        C12717g<c<T>> c12717g = fVar.f26865n;
                        c<T>[] cVarArr = c12717g.f27280d;
                        int i = c12717g.f27277a;
                        int iM10814b = C12717g.m10814b(hashCode()) & i;
                        c<T> cVar = cVarArr[iM10814b];
                        boolean z2 = true;
                        if (cVar != null) {
                            if (!cVar.equals(this)) {
                                while (true) {
                                    iM10814b = (iM10814b + 1) & i;
                                    c<T> cVar2 = cVarArr[iM10814b];
                                    if (cVar2 == null) {
                                        break;
                                    } else if (cVar2.equals(this)) {
                                        c12717g.m10816c(iM10814b, cVarArr, i);
                                        break;
                                    }
                                }
                            } else {
                                c12717g.m10816c(iM10814b, cVarArr, i);
                            }
                        }
                        if (fVar.f26865n.f27278b != 0) {
                            z2 = false;
                        }
                        if (z2) {
                            fVar.f26866o = f.f26861j;
                        }
                        fVar.f26867p++;
                    }
                }
            }
            this.parent.m10770c(this);
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

        /* JADX INFO: renamed from: g */
        void mo10763g(T t);

        /* JADX INFO: renamed from: h */
        void mo10764h(c<T> cVar);

        /* JADX INFO: renamed from: i */
        void mo10765i(Throwable th);
    }

    /* JADX INFO: renamed from: j0.l.a.j1$f */
    /* JADX INFO: compiled from: OperatorReplay.java */
    public static final class f<T> extends Subscriber<T> implements Subscription {

        /* JADX INFO: renamed from: j */
        public static final c[] f26861j = new c[0];

        /* JADX INFO: renamed from: k */
        public final e<T> f26862k;

        /* JADX INFO: renamed from: l */
        public boolean f26863l;

        /* JADX INFO: renamed from: m */
        public volatile boolean f26864m;

        /* JADX INFO: renamed from: p */
        public volatile long f26867p;

        /* JADX INFO: renamed from: q */
        public long f26868q;

        /* JADX INFO: renamed from: s */
        public boolean f26870s;

        /* JADX INFO: renamed from: t */
        public boolean f26871t;

        /* JADX INFO: renamed from: u */
        public long f26872u;

        /* JADX INFO: renamed from: v */
        public long f26873v;

        /* JADX INFO: renamed from: w */
        public volatile Producer f26874w;

        /* JADX INFO: renamed from: x */
        public List<c<T>> f26875x;

        /* JADX INFO: renamed from: y */
        public boolean f26876y;

        /* JADX INFO: renamed from: n */
        public final C12717g<c<T>> f26865n = new C12717g<>();

        /* JADX INFO: renamed from: o */
        public c<T>[] f26866o = f26861j;

        /* JADX INFO: renamed from: r */
        public final AtomicBoolean f26869r = new AtomicBoolean();

        public f(e<T> eVar) {
            this.f26862k = eVar;
            request(0L);
        }

        /* JADX INFO: renamed from: a */
        public c<T>[] m10768a() {
            c<T>[] cVarArr;
            synchronized (this.f26865n) {
                c<T>[] cVarArr2 = this.f26865n.f27280d;
                int length = cVarArr2.length;
                cVarArr = new c[length];
                System.arraycopy(cVarArr2, 0, cVarArr, 0, length);
            }
            return cVarArr;
        }

        /* JADX INFO: renamed from: b */
        public void m10769b(long j, long j2) {
            long j3 = this.f26873v;
            Producer producer = this.f26874w;
            long j4 = j - j2;
            if (j4 == 0) {
                if (j3 == 0 || producer == null) {
                    return;
                }
                this.f26873v = 0L;
                producer.mo10704j(j3);
                return;
            }
            this.f26872u = j;
            if (producer == null) {
                long j5 = j3 + j4;
                if (j5 < 0) {
                    j5 = RecyclerView.FOREVER_NS;
                }
                this.f26873v = j5;
                return;
            }
            if (j3 == 0) {
                producer.mo10704j(j4);
            } else {
                this.f26873v = 0L;
                producer.mo10704j(j3 + j4);
            }
        }

        /* JADX INFO: renamed from: c */
        public void m10770c(c<T> cVar) {
            long jMax;
            List<c<T>> list;
            boolean z2;
            long jMax2;
            if (isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.f26870s) {
                    if (cVar != null) {
                        List arrayList = this.f26875x;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            this.f26875x = arrayList;
                        }
                        arrayList.add(cVar);
                    } else {
                        this.f26876y = true;
                    }
                    this.f26871t = true;
                    return;
                }
                this.f26870s = true;
                long j = this.f26872u;
                if (cVar != null) {
                    jMax = Math.max(j, cVar.totalRequested.get());
                } else {
                    long jMax3 = j;
                    for (c<T> cVar2 : m10768a()) {
                        if (cVar2 != null) {
                            jMax3 = Math.max(jMax3, cVar2.totalRequested.get());
                        }
                    }
                    jMax = jMax3;
                }
                m10769b(jMax, j);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.f26871t) {
                            this.f26870s = false;
                            return;
                        }
                        this.f26871t = false;
                        list = this.f26875x;
                        this.f26875x = null;
                        z2 = this.f26876y;
                        this.f26876y = false;
                    }
                    long j2 = this.f26872u;
                    if (list != null) {
                        Iterator<c<T>> it = list.iterator();
                        jMax2 = j2;
                        while (it.hasNext()) {
                            jMax2 = Math.max(jMax2, it.next().totalRequested.get());
                        }
                    } else {
                        jMax2 = j2;
                    }
                    if (z2) {
                        for (c<T> cVar3 : m10768a()) {
                            if (cVar3 != null) {
                                jMax2 = Math.max(jMax2, cVar3.totalRequested.get());
                            }
                        }
                    }
                    m10769b(jMax2, j2);
                }
            }
        }

        /* JADX INFO: renamed from: d */
        public void m10771d() {
            c<T>[] cVarArr = this.f26866o;
            if (this.f26868q != this.f26867p) {
                synchronized (this.f26865n) {
                    cVarArr = this.f26866o;
                    c<T>[] cVarArr2 = this.f26865n.f27280d;
                    int length = cVarArr2.length;
                    if (cVarArr.length != length) {
                        cVarArr = new c[length];
                        this.f26866o = cVarArr;
                    }
                    System.arraycopy(cVarArr2, 0, cVarArr, 0, length);
                    this.f26868q = this.f26867p;
                }
            }
            e<T> eVar = this.f26862k;
            for (c<T> cVar : cVarArr) {
                if (cVar != null) {
                    eVar.mo10764h(cVar);
                }
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (this.f26863l) {
                return;
            }
            this.f26863l = true;
            try {
                this.f26862k.complete();
                m10771d();
            } finally {
                unsubscribe();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (this.f26863l) {
                return;
            }
            this.f26863l = true;
            try {
                this.f26862k.mo10765i(th);
                m10771d();
            } finally {
                unsubscribe();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            if (this.f26863l) {
                return;
            }
            this.f26862k.mo10763g(t);
            m10771d();
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            if (this.f26874w != null) {
                throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
            }
            this.f26874w = producer;
            m10770c(null);
            m10771d();
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

        @Override // p637j0.p642l.p643a.C12636j1.b
        /* JADX INFO: renamed from: a */
        public void mo10762a() {
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

        @Override // p637j0.p642l.p643a.C12636j1.e
        public void complete() {
            add(C12614e.f26768a);
            this.size++;
        }

        @Override // p637j0.p642l.p643a.C12636j1.e
        /* JADX INFO: renamed from: g */
        public void mo10763g(T t) {
            if (t == null) {
                t = (T) C12614e.f26769b;
            }
            add(t);
            this.size++;
        }

        @Override // p637j0.p642l.p643a.C12636j1.e
        /* JADX INFO: renamed from: h */
        public void mo10764h(c<T> cVar) {
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
                            if (C12614e.m10744a(subscriber, obj) || cVar.isUnsubscribed()) {
                                return;
                            }
                            iIntValue++;
                            j2++;
                        } catch (Throwable th) {
                            C3404f.m4325o1(th);
                            cVar.unsubscribe();
                            if ((obj instanceof C12614e.c) || C12614e.m10746c(obj)) {
                                return;
                            }
                            subscriber.onError(OnErrorThrowable.m11126a(th, C12614e.m10745b(obj)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        cVar.index = Integer.valueOf(iIntValue);
                        if (j != RecyclerView.FOREVER_NS) {
                            cVar.m10767b(j2);
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

        @Override // p637j0.p642l.p643a.C12636j1.e
        /* JADX INFO: renamed from: i */
        public void mo10765i(Throwable th) {
            add(new C12614e.c(th));
            this.size++;
        }
    }

    public C12636j1(Observable.InterfaceC13005a<T> interfaceC13005a, Observable<? extends T> observable, AtomicReference<f<T>> atomicReference, Func0<? extends e<T>> func0) {
        super(interfaceC13005a);
        this.f26858l = observable;
        this.f26859m = atomicReference;
        this.f26860n = func0;
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        f<T> fVar = this.f26859m.get();
        return fVar == null || fVar.isUnsubscribed();
    }

    @Override // p637j0.p650m.AbstractC12757b
    /* JADX INFO: renamed from: k0 */
    public void mo10753k0(Action1<? super Subscription> action1) {
        f<T> fVar;
        while (true) {
            fVar = this.f26859m.get();
            if (fVar != null && !fVar.isUnsubscribed()) {
                break;
            }
            f<T> fVar2 = new f<>(this.f26860n.call());
            fVar2.add(new C12785a(new C12648m1(fVar2)));
            if (this.f26859m.compareAndSet(fVar, fVar2)) {
                fVar = fVar2;
                break;
            }
        }
        boolean z2 = !fVar.f26869r.get() && fVar.f26869r.compareAndSet(false, true);
        ((C12690z) action1).call(fVar);
        if (z2) {
            this.f26858l.m11107i0(fVar);
        }
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        this.f26859m.lazySet(null);
    }
}
