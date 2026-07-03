package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.C12614e;
import p637j0.p642l.p647e.C12719i;
import p637j0.p642l.p647e.p648n.C12726c;
import p637j0.p642l.p647e.p649o.C12744n;
import p637j0.p642l.p647e.p649o.C12755y;
import p637j0.p650m.AbstractC12757b;
import p637j0.p655r.C12785a;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: j0.l.a.h1 */
/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12628h1<T> extends AbstractC12757b<T> {

    /* JADX INFO: renamed from: k */
    public final Observable<? extends T> f26830k;

    /* JADX INFO: renamed from: l */
    public final AtomicReference<b<T>> f26831l;

    /* JADX INFO: renamed from: j0.l.a.h1$a */
    /* JADX INFO: compiled from: OperatorPublish.java */
    public static final class a<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        public final Subscriber<? super T> child;
        public final b<T> parent;

        public a(b<T> bVar, Subscriber<? super T> subscriber) {
            this.parent = bVar;
            this.child = subscriber;
            lazySet(-4611686018427387904L);
        }

        /* JADX INFO: renamed from: a */
        public long m10754a(long j) {
            long j2;
            long j3;
            if (j <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j2 = get();
                if (j2 == -4611686018427387904L) {
                    throw new IllegalStateException("Produced without request");
                }
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
        public void mo10704j(long j) throws Throwable {
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
                if (j2 == -4611686018427387904L) {
                    j3 = j;
                } else {
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = RecyclerView.FOREVER_NS;
                    }
                }
            } while (!compareAndSet(j2, j3));
            this.parent.m10756b();
        }

        @Override // p658rx.Subscription
        public void unsubscribe() throws Throwable {
            a[] aVarArr;
            a[] aVarArr2;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            b<T> bVar = this.parent;
            do {
                aVarArr = bVar.f26837o.get();
                if (aVarArr != b.f26832j && aVarArr != b.f26833k) {
                    int length = aVarArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (aVarArr[i].equals(this)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i < 0) {
                        break;
                    }
                    if (length == 1) {
                        aVarArr2 = b.f26832j;
                    } else {
                        a[] aVarArr3 = new a[length - 1];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                        System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    break;
                }
            } while (!bVar.f26837o.compareAndSet(aVarArr, aVarArr2));
            this.parent.m10756b();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.h1$b */
    /* JADX INFO: compiled from: OperatorPublish.java */
    public static final class b<T> extends Subscriber<T> implements Subscription {

        /* JADX INFO: renamed from: j */
        public static final a[] f26832j = new a[0];

        /* JADX INFO: renamed from: k */
        public static final a[] f26833k = new a[0];

        /* JADX INFO: renamed from: l */
        public final Queue<Object> f26834l;

        /* JADX INFO: renamed from: m */
        public final AtomicReference<b<T>> f26835m;

        /* JADX INFO: renamed from: n */
        public volatile Object f26836n;

        /* JADX INFO: renamed from: o */
        public final AtomicReference<a[]> f26837o;

        /* JADX INFO: renamed from: p */
        public final AtomicBoolean f26838p;

        /* JADX INFO: renamed from: q */
        public boolean f26839q;

        /* JADX INFO: renamed from: r */
        public boolean f26840r;

        public b(AtomicReference<b<T>> atomicReference) {
            this.f26834l = C12755y.m10858b() ? new C12744n<>(C12719i.f27283j) : new C12726c<>(C12719i.f27283j);
            this.f26837o = new AtomicReference<>(f26832j);
            this.f26835m = atomicReference;
            this.f26838p = new AtomicBoolean();
        }

        /* JADX INFO: renamed from: a */
        public boolean m10755a(Object obj, boolean z2) {
            int i = 0;
            if (obj != null) {
                if (!C12614e.m10746c(obj)) {
                    Throwable th = ((C12614e.c) obj).f26770e;
                    this.f26835m.compareAndSet(this, null);
                    try {
                        a[] andSet = this.f26837o.getAndSet(f26833k);
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(th);
                            i++;
                        }
                        unsubscribe();
                        return true;
                    } catch (Throwable th2) {
                        unsubscribe();
                        throw th2;
                    }
                }
                if (z2) {
                    this.f26835m.compareAndSet(this, null);
                    try {
                        a[] andSet2 = this.f26837o.getAndSet(f26833k);
                        int length2 = andSet2.length;
                        while (i < length2) {
                            andSet2[i].child.onCompleted();
                            i++;
                        }
                        unsubscribe();
                        return true;
                    } catch (Throwable th3) {
                        unsubscribe();
                        throw th3;
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x00de */
        /* JADX INFO: renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void m10756b() throws Throwable {
            boolean z2;
            long j;
            synchronized (this) {
                if (this.f26839q) {
                    this.f26840r = true;
                    return;
                }
                this.f26839q = true;
                this.f26840r = false;
                while (true) {
                    try {
                        Object obj = this.f26836n;
                        boolean zIsEmpty = this.f26834l.isEmpty();
                        if (m10755a(obj, zIsEmpty)) {
                            return;
                        }
                        if (!zIsEmpty) {
                            a[] aVarArr = this.f26837o.get();
                            int length = aVarArr.length;
                            long jMin = RecyclerView.FOREVER_NS;
                            int i = 0;
                            for (a aVar : aVarArr) {
                                long j2 = aVar.get();
                                if (j2 >= 0) {
                                    jMin = Math.min(jMin, j2);
                                } else if (j2 == Long.MIN_VALUE) {
                                    i++;
                                }
                            }
                            if (length != i) {
                                int i2 = 0;
                                while (true) {
                                    j = i2;
                                    if (j >= jMin) {
                                        break;
                                    }
                                    Object obj2 = this.f26836n;
                                    Object objPoll = this.f26834l.poll();
                                    boolean z3 = objPoll == null;
                                    if (m10755a(obj2, z3)) {
                                        return;
                                    }
                                    if (z3) {
                                        zIsEmpty = z3;
                                        break;
                                    }
                                    Object objM10745b = C12614e.m10745b(objPoll);
                                    for (a aVar2 : aVarArr) {
                                        if (aVar2.get() > 0) {
                                            try {
                                                aVar2.child.onNext(objM10745b);
                                                aVar2.m10754a(1L);
                                            } catch (Throwable th) {
                                                aVar2.unsubscribe();
                                                C3404f.m4329p1(th, aVar2.child, objM10745b);
                                            }
                                        }
                                    }
                                    i2++;
                                    zIsEmpty = z3;
                                }
                                if (i2 > 0) {
                                    request(j);
                                }
                                if (jMin == 0 || zIsEmpty) {
                                }
                            } else if (m10755a(this.f26836n, this.f26834l.poll() == null)) {
                                return;
                            } else {
                                request(1L);
                            }
                        }
                        synchronized (this) {
                            try {
                                if (this.f26840r) {
                                    this.f26840r = false;
                                } else {
                                    this.f26839q = false;
                                    try {
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z2 = true;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = false;
                            }
                            while (true) {
                            }
                        }
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z2 = false;
                    }
                    if (!z2) {
                        synchronized (this) {
                            this.f26839q = false;
                        }
                    }
                    throw th;
                }
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() throws Throwable {
            if (this.f26836n == null) {
                this.f26836n = C12614e.f26768a;
                m10756b();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) throws Throwable {
            if (this.f26836n == null) {
                this.f26836n = new C12614e.c(th);
                m10756b();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) throws Throwable {
            Queue<Object> queue = this.f26834l;
            Object obj = t;
            if (t == null) {
                obj = C12614e.f26769b;
            }
            if (queue.offer(obj)) {
                m10756b();
                return;
            }
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException();
            if (this.f26836n == null) {
                this.f26836n = new C12614e.c(missingBackpressureException);
                m10756b();
            }
        }

        @Override // p658rx.Subscriber
        public void onStart() {
            request(C12719i.f27283j);
        }
    }

    public C12628h1(Observable.InterfaceC13005a<T> interfaceC13005a, Observable<? extends T> observable, AtomicReference<b<T>> atomicReference) {
        super(interfaceC13005a);
        this.f26830k = observable;
        this.f26831l = atomicReference;
    }

    @Override // p637j0.p650m.AbstractC12757b
    /* JADX INFO: renamed from: k0 */
    public void mo10753k0(Action1<? super Subscription> action1) {
        b<T> bVar;
        while (true) {
            bVar = this.f26831l.get();
            if (bVar != null && !bVar.isUnsubscribed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f26831l);
            bVar2.add(new C12785a(new C12632i1(bVar2)));
            if (this.f26831l.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z2 = !bVar.f26838p.get() && bVar.f26838p.compareAndSet(false, true);
        ((C12690z) action1).call(bVar);
        if (z2) {
            this.f26830k.m11107i0(bVar);
        }
    }
}
