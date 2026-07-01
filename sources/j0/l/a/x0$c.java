package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Queue;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorMerge.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x0$c<T> extends Subscriber<T> {
    public static final int j = j0.l.e.i.j / 4;
    public final x0$e<T> k;
    public final long l;
    public volatile boolean m;
    public volatile j0.l.e.i n;
    public int o;

    public x0$c(x0$e<T> x0_e, long j2) {
        this.k = x0_e;
        this.l = j2;
    }

    public void a(long j2) {
        int i = this.o - ((int) j2);
        if (i > j) {
            this.o = i;
            return;
        }
        int i2 = j0.l.e.i.j;
        this.o = i2;
        int i3 = i2 - i;
        if (i3 > 0) {
            request(i3);
        }
    }

    @Override // j0.g
    public void onCompleted() {
        this.m = true;
        this.k.b();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.d().offer(th);
        this.m = true;
        this.k.b();
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0090  */
    /* JADX WARN: Code duplicated, block: B:70:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // j0.g
    public void onNext(T t) throws Throwable {
        boolean z2;
        x0$e<T> x0_e = this.k;
        long j2 = x0_e.n.get();
        boolean z3 = true;
        if (j2 != 0) {
            synchronized (x0_e) {
                j2 = x0_e.n.get();
                if (x0_e.f3779s || j2 == 0) {
                    z2 = false;
                } else {
                    x0_e.f3779s = true;
                    z2 = true;
                }
            }
        } else {
            z2 = false;
        }
        if (!z2) {
            x0_e.f(this, t);
            x0_e.b();
            return;
        }
        j0.l.e.i iVar = this.n;
        if (iVar != null) {
            Queue<Object> queue = iVar.k;
            if (!(queue == null || queue.isEmpty())) {
                x0_e.f(this, t);
                x0_e.c();
                return;
            }
        }
        try {
            try {
                try {
                    x0_e.k.onNext(t);
                } catch (Throwable th) {
                    th = th;
                    z3 = false;
                    if (!z3) {
                        synchronized (x0_e) {
                            x0_e.f3779s = false;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (!z3) {
                    synchronized (x0_e) {
                        x0_e.f3779s = false;
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (!x0_e.l) {
                b.i.a.f.e.o.f.o1(th3);
                unsubscribe();
                onError(th3);
                return;
            }
            x0_e.d().offer(th3);
        }
        if (j2 != RecyclerView.FOREVER_NS) {
            x0_e.n.a(1);
        }
        a(1L);
        synchronized (x0_e) {
            if (x0_e.t) {
                x0_e.t = false;
                x0_e.c();
            } else {
                x0_e.f3779s = false;
            }
        }
    }

    @Override // rx.Subscriber
    public void onStart() {
        int i = j0.l.e.i.j;
        this.o = i;
        request(i);
    }
}
