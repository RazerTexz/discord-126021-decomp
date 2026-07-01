package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j1$f<T> extends Subscriber<T> implements Subscription {
    public static final j1$c[] j = new j1$c[0];
    public final j1$e<T> k;
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
    public List<j1$c<T>> f3775x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3776y;
    public final j0.l.e.g<j1$c<T>> n = new j0.l.e.g<>();
    public j1$c<T>[] o = j;
    public final AtomicBoolean r = new AtomicBoolean();

    public j1$f(j1$e<T> j1_e) {
        this.k = j1_e;
        request(0L);
    }

    public j1$c<T>[] a() {
        j1$c<T>[] j1_cArr;
        synchronized (this.n) {
            j1$c<T>[] j1_cArr2 = this.n.d;
            int length = j1_cArr2.length;
            j1_cArr = new j1$c[length];
            System.arraycopy(j1_cArr2, 0, j1_cArr, 0, length);
        }
        return j1_cArr;
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

    public void c(j1$c<T> j1_c) {
        long jMax;
        List<j1$c<T>> list;
        boolean z2;
        long jMax2;
        if (isUnsubscribed()) {
            return;
        }
        synchronized (this) {
            if (this.f3774s) {
                if (j1_c != null) {
                    List arrayList = this.f3775x;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        this.f3775x = arrayList;
                    }
                    arrayList.add(j1_c);
                } else {
                    this.f3776y = true;
                }
                this.t = true;
                return;
            }
            this.f3774s = true;
            long j2 = this.u;
            if (j1_c != null) {
                jMax = Math.max(j2, j1_c.totalRequested.get());
            } else {
                long jMax3 = j2;
                for (j1$c<T> j1_c2 : a()) {
                    if (j1_c2 != null) {
                        jMax3 = Math.max(jMax3, j1_c2.totalRequested.get());
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
                    Iterator<j1$c<T>> it = list.iterator();
                    jMax2 = j3;
                    while (it.hasNext()) {
                        jMax2 = Math.max(jMax2, it.next().totalRequested.get());
                    }
                } else {
                    jMax2 = j3;
                }
                if (z2) {
                    for (j1$c<T> j1_c3 : a()) {
                        if (j1_c3 != null) {
                            jMax2 = Math.max(jMax2, j1_c3.totalRequested.get());
                        }
                    }
                }
                b(jMax2, j3);
            }
        }
    }

    public void d() {
        j1$c<T>[] j1_cArr = this.o;
        if (this.q != this.p) {
            synchronized (this.n) {
                j1_cArr = this.o;
                j1$c<T>[] j1_cArr2 = this.n.d;
                int length = j1_cArr2.length;
                if (j1_cArr.length != length) {
                    j1_cArr = new j1$c[length];
                    this.o = j1_cArr;
                }
                System.arraycopy(j1_cArr2, 0, j1_cArr, 0, length);
                this.q = this.p;
            }
        }
        j1$e<T> j1_e = this.k;
        for (j1$c<T> j1_c : j1_cArr) {
            if (j1_c != null) {
                j1_e.h(j1_c);
            }
        }
    }

    @Override // j0.g
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

    @Override // j0.g
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

    @Override // j0.g
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
