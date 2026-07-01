package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h1$b<T> extends Subscriber<T> implements Subscription {
    public static final h1$a[] j = new h1$a[0];
    public static final h1$a[] k = new h1$a[0];
    public final Queue<Object> l;
    public final AtomicReference<h1$b<T>> m;
    public volatile Object n;
    public final AtomicReference<h1$a[]> o;
    public final AtomicBoolean p;
    public boolean q;
    public boolean r;

    public h1$b(AtomicReference<h1$b<T>> atomicReference) {
        this.l = j0.l.e.o.y.b() ? new j0.l.e.o.n<>(j0.l.e.i.j) : new j0.l.e.n.c<>(j0.l.e.i.j);
        this.o = new AtomicReference<>(j);
        this.m = atomicReference;
        this.p = new AtomicBoolean();
    }

    public boolean a(Object obj, boolean z2) {
        int i = 0;
        if (obj != null) {
            if (!e.c(obj)) {
                Throwable th = ((e$c) obj).e;
                this.m.compareAndSet(this, null);
                try {
                    h1$a[] andSet = this.o.getAndSet(k);
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
                this.m.compareAndSet(this, null);
                try {
                    h1$a[] andSet2 = this.o.getAndSet(k);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() throws Throwable {
        boolean z2;
        long j2;
        synchronized (this) {
            if (this.q) {
                this.r = true;
                return;
            }
            this.q = true;
            this.r = false;
            while (true) {
                try {
                    Object obj = this.n;
                    boolean zIsEmpty = this.l.isEmpty();
                    if (a(obj, zIsEmpty)) {
                        return;
                    }
                    if (!zIsEmpty) {
                        h1$a[] h1_aArr = this.o.get();
                        int length = h1_aArr.length;
                        long jMin = RecyclerView.FOREVER_NS;
                        int i = 0;
                        for (h1$a h1_a : h1_aArr) {
                            long j3 = h1_a.get();
                            if (j3 >= 0) {
                                jMin = Math.min(jMin, j3);
                            } else if (j3 == Long.MIN_VALUE) {
                                i++;
                            }
                        }
                        if (length != i) {
                            int i2 = 0;
                            while (true) {
                                j2 = i2;
                                if (j2 >= jMin) {
                                    break;
                                }
                                Object obj2 = this.n;
                                Object objPoll = this.l.poll();
                                boolean z3 = objPoll == null;
                                if (a(obj2, z3)) {
                                    return;
                                }
                                if (z3) {
                                    zIsEmpty = z3;
                                    break;
                                }
                                Object objB = e.b(objPoll);
                                for (h1$a h1_a2 : h1_aArr) {
                                    if (h1_a2.get() > 0) {
                                        try {
                                            h1_a2.child.onNext(objB);
                                            h1_a2.a(1L);
                                        } catch (Throwable th) {
                                            h1_a2.unsubscribe();
                                            b.i.a.f.e.o.f.p1(th, h1_a2.child, objB);
                                        }
                                    }
                                }
                                i2++;
                                zIsEmpty = z3;
                            }
                            if (i2 > 0) {
                                request(j2);
                            }
                            if (jMin == 0 || zIsEmpty) {
                            }
                        } else if (a(this.n, this.l.poll() == null)) {
                            return;
                        } else {
                            request(1L);
                        }
                    }
                    synchronized (this) {
                        try {
                            if (this.r) {
                                this.r = false;
                            } else {
                                this.q = false;
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
                        this.q = false;
                    }
                }
                throw th;
            }
        }
    }

    @Override // j0.g
    public void onCompleted() throws Throwable {
        if (this.n == null) {
            this.n = e.a;
            b();
        }
    }

    @Override // j0.g
    public void onError(Throwable th) throws Throwable {
        if (this.n == null) {
            this.n = new e$c(th);
            b();
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // j0.g
    public void onNext(T t) throws Throwable {
        Queue<Object> queue = this.l;
        Object obj = t;
        if (t == null) {
            obj = e.f3771b;
        }
        if (queue.offer(obj)) {
            b();
            return;
        }
        MissingBackpressureException missingBackpressureException = new MissingBackpressureException();
        if (this.n == null) {
            this.n = new e$c(missingBackpressureException);
            b();
        }
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(j0.l.e.i.j);
    }
}
