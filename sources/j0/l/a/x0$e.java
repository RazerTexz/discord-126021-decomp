package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: OperatorMerge.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x0$e<T> extends Subscriber<Observable<? extends T>> {
    public static final x0$c<?>[] j = new x0$c[0];
    public int A;
    public final Subscriber<? super T> k;
    public final boolean l;
    public final int m;
    public x0$d<T> n;
    public volatile Queue<Object> o;
    public volatile CompositeSubscription p;
    public volatile ConcurrentLinkedQueue<Throwable> q;
    public volatile boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3779s;
    public boolean t;
    public final Object u = new Object();
    public volatile x0$c<?>[] v = j;
    public long w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f3780x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3781y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f3782z;

    public x0$e(Subscriber<? super T> subscriber, boolean z2, int i) {
        this.k = subscriber;
        this.l = z2;
        this.m = i;
        if (i == Integer.MAX_VALUE) {
            this.f3782z = Integer.MAX_VALUE;
            request(RecyclerView.FOREVER_NS);
        } else {
            this.f3782z = Math.max(1, i >> 1);
            request(i);
        }
    }

    public boolean a() {
        if (this.k.isUnsubscribed()) {
            return true;
        }
        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.q;
        if (this.l || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return false;
        }
        try {
            h();
            return true;
        } finally {
            unsubscribe();
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f3779s) {
                this.t = true;
            } else {
                this.f3779s = true;
                c();
            }
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x01b6 */
    /* JADX WARN: Code duplicated, block: B:132:0x0169 A[Catch: all -> 0x01b8, TryCatch #7 {all -> 0x01b8, blocks: (B:3:0x0002, B:4:0x0004, B:7:0x000b, B:17:0x002f, B:22:0x003f, B:36:0x0066, B:27:0x004a, B:29:0x004e, B:35:0x005f, B:40:0x0076, B:47:0x008a, B:50:0x0095, B:53:0x009d, B:55:0x00a1, B:58:0x00a8, B:59:0x00ac, B:62:0x00b2, B:64:0x00b8, B:80:0x00e3, B:83:0x00ea, B:87:0x00f2, B:90:0x00f9, B:93:0x00fe, B:96:0x0105, B:112:0x012e, B:114:0x013e, B:121:0x0151, B:124:0x0159, B:126:0x015d, B:132:0x0169, B:135:0x0173, B:143:0x0186, B:146:0x0194, B:149:0x019e, B:138:0x0179, B:141:0x017e, B:70:0x00c6, B:73:0x00cf, B:76:0x00d4, B:77:0x00d7, B:23:0x0043), top: B:196:0x0002, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0173 A[Catch: all -> 0x01b8, TryCatch #7 {all -> 0x01b8, blocks: (B:3:0x0002, B:4:0x0004, B:7:0x000b, B:17:0x002f, B:22:0x003f, B:36:0x0066, B:27:0x004a, B:29:0x004e, B:35:0x005f, B:40:0x0076, B:47:0x008a, B:50:0x0095, B:53:0x009d, B:55:0x00a1, B:58:0x00a8, B:59:0x00ac, B:62:0x00b2, B:64:0x00b8, B:80:0x00e3, B:83:0x00ea, B:87:0x00f2, B:90:0x00f9, B:93:0x00fe, B:96:0x0105, B:112:0x012e, B:114:0x013e, B:121:0x0151, B:124:0x0159, B:126:0x015d, B:132:0x0169, B:135:0x0173, B:143:0x0186, B:146:0x0194, B:149:0x019e, B:138:0x0179, B:141:0x017e, B:70:0x00c6, B:73:0x00cf, B:76:0x00d4, B:77:0x00d7, B:23:0x0043), top: B:196:0x0002, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:205:0x0172 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() throws Throwable {
        boolean z2;
        long jA;
        int i;
        boolean z3;
        try {
            Subscriber<? super T> subscriber = this.k;
            while (!a()) {
                Queue<Object> queue = this.o;
                long j2 = this.n.get();
                boolean z4 = j2 == RecyclerView.FOREVER_NS;
                if (queue != null) {
                    int i2 = 0;
                    while (true) {
                        jA = j2;
                        int i3 = 0;
                        i = i2;
                        Object obj = null;
                        while (jA > 0) {
                            Object objPoll = queue.poll();
                            if (a()) {
                                return;
                            }
                            if (objPoll == null) {
                                obj = objPoll;
                                break;
                            }
                            try {
                                subscriber.onNext((Object) e.b(objPoll));
                            } catch (Throwable th) {
                                if (!this.l) {
                                    b.i.a.f.e.o.f.o1(th);
                                    unsubscribe();
                                    subscriber.onError(th);
                                    return;
                                }
                                d().offer(th);
                            }
                            i++;
                            i3++;
                            jA--;
                            obj = objPoll;
                        }
                        if (i3 > 0) {
                            jA = z4 ? Long.MAX_VALUE : this.n.a(i3);
                        }
                        if (jA == 0 || obj == null) {
                            break;
                            break;
                        } else {
                            i2 = i;
                            j2 = jA;
                        }
                    }
                } else {
                    jA = j2;
                    i = 0;
                }
                boolean z5 = this.r;
                Queue<Object> queue2 = this.o;
                x0$c<?>[] x0_cArr = this.v;
                int length = x0_cArr.length;
                if (z5 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                    ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.q;
                    if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                        h();
                        return;
                    }
                    subscriber.onCompleted();
                    return;
                }
                if (length > 0) {
                    long j3 = this.f3780x;
                    int i4 = this.f3781y;
                    if (length <= i4 || x0_cArr[i4].l != j3) {
                        if (length <= i4) {
                            i4 = 0;
                        }
                        for (int i5 = 0; i5 < length && x0_cArr[i4].l != j3; i5++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.f3781y = i4;
                        this.f3780x = x0_cArr[i4].l;
                    }
                    int i6 = 0;
                    z3 = false;
                    while (true) {
                        if (i6 >= length) {
                            subscriber = subscriber;
                            break;
                        }
                        if (a()) {
                            return;
                        }
                        x0$c<?> x0_c = x0_cArr[i4];
                        Object objC = null;
                        while (true) {
                            int i7 = 0;
                            while (jA > 0) {
                                if (a()) {
                                    return;
                                }
                                j0.l.e.i iVar = x0_c.n;
                                if (iVar != null && (objC = iVar.c()) != null) {
                                    try {
                                        try {
                                            subscriber.onNext((Object) e.b(objC));
                                            jA--;
                                            i7++;
                                        } catch (Throwable th2) {
                                            b.i.a.f.e.o.f.o1(th2);
                                            try {
                                                subscriber.onError(th2);
                                                return;
                                            } finally {
                                                unsubscribe();
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z2 = true;
                                    }
                                }
                                if (!z2) {
                                    synchronized (this) {
                                        this.f3779s = false;
                                    }
                                }
                                throw th;
                            }
                            if (i7 > 0) {
                                long jA2 = !z4 ? this.n.a(i7) : RecyclerView.FOREVER_NS;
                                x0_c.a(i7);
                                jA = jA2;
                            } else {
                                subscriber = subscriber;
                            }
                            if (jA == 0 || objC == null) {
                                break;
                                break;
                            }
                            subscriber = subscriber;
                        }
                        boolean z6 = x0_c.m;
                        j0.l.e.i iVar2 = x0_c.n;
                        if (z6) {
                            if (iVar2 == null) {
                                g(x0_c);
                                if (a()) {
                                    return;
                                }
                                i++;
                                z3 = true;
                            } else {
                                Queue<Object> queue3 = iVar2.k;
                                if (queue3 == null || queue3.isEmpty()) {
                                    g(x0_c);
                                    if (a()) {
                                        return;
                                    }
                                    i++;
                                    z3 = true;
                                }
                            }
                        }
                        if (jA == 0) {
                            break;
                        }
                        i4++;
                        if (i4 == length) {
                            i4 = 0;
                        }
                        i6++;
                        subscriber = subscriber;
                    }
                    this.f3781y = i4;
                    this.f3780x = x0_cArr[i4].l;
                } else {
                    subscriber = subscriber;
                    z3 = false;
                }
                if (i > 0) {
                    request(i);
                }
                if (!z3) {
                    try {
                        synchronized (this) {
                            try {
                                if (this.t) {
                                    this.t = false;
                                } else {
                                    try {
                                        this.f3779s = false;
                                        return;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        z2 = true;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                z2 = false;
                            }
                            while (true) {
                            }
                            throw th;
                        }
                        throw th;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
                subscriber = subscriber;
            }
        } catch (Throwable th7) {
            th = th7;
            z2 = false;
        }
    }

    public Queue<Throwable> d() {
        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.q;
        if (concurrentLinkedQueue == null) {
            synchronized (this) {
                concurrentLinkedQueue = this.q;
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                    this.q = concurrentLinkedQueue;
                }
            }
        }
        return concurrentLinkedQueue;
    }

    public void e(T t) {
        Queue<Object> dVar;
        Queue<Object> gVar = this.o;
        if (gVar == null) {
            int i = this.m;
            if (i == Integer.MAX_VALUE) {
                gVar = new j0.l.e.n.g<>(j0.l.e.i.j);
            } else {
                if (((i + (-1)) & i) == 0) {
                    dVar = j0.l.e.o.y.b() ? new j0.l.e.o.n<>(i) : new j0.l.e.n.c<>(i);
                } else {
                    dVar = new j0.l.e.n.d<>(i);
                }
                gVar = dVar;
            }
            this.o = gVar;
        }
        if (gVar.offer(t == null ? e.f3771b : t)) {
            return;
        }
        unsubscribe();
        d().offer(OnErrorThrowable.a(new MissingBackpressureException(), t));
        this.r = true;
        b();
    }

    public void f(x0$c<T> x0_c, T t) {
        j0.l.e.i iVar = x0_c.n;
        if (iVar == null) {
            iVar = j0.l.e.o.y.b() ? new j0.l.e.i(false, j0.l.e.i.j) : new j0.l.e.i();
            x0_c.add(iVar);
            x0_c.n = iVar;
        }
        if (t == null) {
            try {
                t = (T) e.f3771b;
            } catch (IllegalStateException e) {
                if (x0_c.isUnsubscribed()) {
                    return;
                }
                x0_c.unsubscribe();
                x0_c.onError(e);
                return;
            } catch (MissingBackpressureException e2) {
                x0_c.unsubscribe();
                x0_c.onError(e2);
                return;
            }
        }
        iVar.a(t);
    }

    public void g(x0$c<T> x0_c) {
        j0.l.e.i iVar = x0_c.n;
        if (iVar != null) {
            synchronized (iVar) {
            }
        }
        this.p.c(x0_c);
        synchronized (this.u) {
            x0$c<?>[] x0_cArr = this.v;
            int length = x0_cArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (x0_c.equals(x0_cArr[i])) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                this.v = j;
                return;
            }
            x0$c<?>[] x0_cArr2 = new x0$c[length - 1];
            System.arraycopy(x0_cArr, 0, x0_cArr2, 0, i);
            System.arraycopy(x0_cArr, i + 1, x0_cArr2, i, (length - i) - 1);
            this.v = x0_cArr2;
        }
    }

    public final void h() {
        ArrayList arrayList = new ArrayList(this.q);
        if (arrayList.size() == 1) {
            this.k.onError((Throwable) arrayList.get(0));
        } else {
            this.k.onError(new CompositeException(arrayList));
        }
    }

    @Override // j0.g
    public void onCompleted() {
        this.r = true;
        b();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        d().offer(th);
        this.r = true;
        b();
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    @Override // j0.g
    public void onNext(Object obj) throws Throwable {
        boolean z2;
        Observable<Object> observable = (Observable) obj;
        if (observable == null) {
            return;
        }
        boolean z3 = true;
        if (observable == c.k) {
            int i = this.A + 1;
            if (i != this.f3782z) {
                this.A = i;
                return;
            } else {
                this.A = 0;
                request(i);
                return;
            }
        }
        if (!(observable instanceof j0.l.e.k)) {
            long j2 = this.w;
            this.w = 1 + j2;
            x0$c<?> x0_c = new x0$c<>(this, j2);
            CompositeSubscription compositeSubscription = this.p;
            if (compositeSubscription == null) {
                synchronized (this) {
                    compositeSubscription = this.p;
                    if (compositeSubscription == null) {
                        compositeSubscription = new CompositeSubscription();
                        this.p = compositeSubscription;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    add(compositeSubscription);
                }
            }
            compositeSubscription.a(x0_c);
            synchronized (this.u) {
                x0$c<?>[] x0_cArr = this.v;
                int length = x0_cArr.length;
                x0$c<?>[] x0_cArr2 = new x0$c[length + 1];
                System.arraycopy(x0_cArr, 0, x0_cArr2, 0, length);
                x0_cArr2[length] = x0_c;
                this.v = x0_cArr2;
            }
            observable.i0(x0_c);
            b();
            return;
        }
        T t = ((j0.l.e.k) observable).l;
        long j3 = this.n.get();
        if (j3 != 0) {
            synchronized (this) {
                j3 = this.n.get();
                if (this.f3779s || j3 == 0) {
                    z2 = false;
                } else {
                    this.f3779s = true;
                    z2 = true;
                }
            }
        } else {
            z2 = false;
        }
        if (!z2) {
            e(t);
            b();
            return;
        }
        Queue<Object> queue = this.o;
        if (queue != null && !queue.isEmpty()) {
            e(t);
            c();
            return;
        }
        try {
            try {
                this.k.onNext(t);
            } catch (Throwable th) {
                try {
                    if (!this.l) {
                        b.i.a.f.e.o.f.o1(th);
                        unsubscribe();
                        d().offer(th);
                        this.r = true;
                        b();
                        return;
                    }
                    d().offer(th);
                } catch (Throwable th2) {
                    th = th2;
                    z3 = false;
                    if (!z3) {
                        synchronized (this) {
                            this.f3779s = false;
                        }
                    }
                    throw th;
                }
            }
            if (j3 != RecyclerView.FOREVER_NS) {
                this.n.a(1);
            }
            int i2 = this.A + 1;
            if (i2 == this.f3782z) {
                this.A = 0;
                request(i2);
            } else {
                this.A = i2;
            }
            synchronized (this) {
                if (this.t) {
                    this.t = false;
                    c();
                } else {
                    this.f3779s = false;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (!z3) {
                synchronized (this) {
                    this.f3779s = false;
                }
            }
            throw th;
        }
    }
}
