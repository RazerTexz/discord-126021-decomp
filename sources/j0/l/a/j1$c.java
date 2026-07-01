package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j1$c<T> extends AtomicLong implements Producer, Subscription {
    private static final long serialVersionUID = -4453897557930727610L;
    public Subscriber<? super T> child;
    public boolean emitting;
    public Object index;
    public boolean missed;
    public final j1$f<T> parent;
    public final AtomicLong totalRequested = new AtomicLong();

    public j1$c(j1$f<T> j1_f, Subscriber<? super T> subscriber) {
        this.parent = j1_f;
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
                throw new IllegalStateException(b.d.b.a.a.C(sb, j2, ")"));
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
        j1$f<T> j1_f = this.parent;
        if (!j1_f.m) {
            synchronized (j1_f.n) {
                if (!j1_f.m) {
                    j0.l.e.g<j1$c<T>> gVar = j1_f.n;
                    j1$c<T>[] j1_cArr = gVar.d;
                    int i = gVar.a;
                    int iB = j0.l.e.g.b(hashCode()) & i;
                    j1$c<T> j1_c = j1_cArr[iB];
                    boolean z2 = true;
                    if (j1_c != null) {
                        if (!j1_c.equals(this)) {
                            while (true) {
                                iB = (iB + 1) & i;
                                j1$c<T> j1_c2 = j1_cArr[iB];
                                if (j1_c2 == null) {
                                    break;
                                } else if (j1_c2.equals(this)) {
                                    gVar.c(iB, j1_cArr, i);
                                    break;
                                }
                            }
                        } else {
                            gVar.c(iB, j1_cArr, i);
                        }
                    }
                    if (j1_f.n.f3794b != 0) {
                        z2 = false;
                    }
                    if (z2) {
                        j1_f.o = j1$f.j;
                    }
                    j1_f.p++;
                }
            }
        }
        this.parent.c(this);
        this.child = null;
    }
}
