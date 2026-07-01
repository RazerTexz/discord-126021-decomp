package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public class j1$b<T> extends AtomicReference<j1$d> implements j1$e<T> {
    private static final long serialVersionUID = 2346567790059478686L;
    public long index;
    public int size;
    public j1$d tail;

    public j1$b() {
        j1$d j1_d = new j1$d(null, 0L);
        this.tail = j1_d;
        set(j1_d);
    }

    public void a() {
    }

    @Override // j0.l.a.j1$e
    public final void complete() {
        Object obj = e.a;
        long j = this.index + 1;
        this.index = j;
        j1$d j1_d = new j1$d(obj, j);
        this.tail.set(j1_d);
        this.tail = j1_d;
        this.size++;
    }

    @Override // j0.l.a.j1$e
    public final void g(T t) {
        if (t == null) {
            t = (T) e.f3771b;
        }
        long j = this.index + 1;
        this.index = j;
        j1$d j1_d = new j1$d(t, j);
        this.tail.set(j1_d);
        this.tail = j1_d;
        this.size++;
        a();
    }

    @Override // j0.l.a.j1$e
    public final void h(j1$c<T> j1_c) {
        Subscriber<? super T> subscriber;
        j1$d j1_d;
        synchronized (j1_c) {
            if (j1_c.emitting) {
                j1_c.missed = true;
                return;
            }
            j1_c.emitting = true;
            while (!j1_c.isUnsubscribed()) {
                j1$d j1_d2 = (j1$d) j1_c.index;
                if (j1_d2 == null) {
                    j1_d2 = get();
                    j1_c.index = j1_d2;
                    j1_c.a(j1_d2.index);
                }
                if (j1_c.isUnsubscribed() || (subscriber = j1_c.child) == null) {
                    return;
                }
                long j = j1_c.get();
                long j2 = 0;
                while (j2 != j && (j1_d = j1_d2.get()) != null) {
                    Object obj = j1_d.value;
                    try {
                        if (e.a(subscriber, obj)) {
                            j1_c.index = null;
                            return;
                        }
                        j2++;
                        if (j1_c.isUnsubscribed()) {
                            return;
                        } else {
                            j1_d2 = j1_d;
                        }
                    } catch (Throwable th) {
                        j1_c.index = null;
                        b.i.a.f.e.o.f.o1(th);
                        j1_c.unsubscribe();
                        if ((obj instanceof e$c) || e.c(obj)) {
                            return;
                        }
                        subscriber.onError(OnErrorThrowable.a(th, e.b(obj)));
                        return;
                    }
                }
                if (j2 != 0) {
                    j1_c.index = j1_d2;
                    if (j != RecyclerView.FOREVER_NS) {
                        j1_c.b(j2);
                    }
                }
                synchronized (j1_c) {
                    if (!j1_c.missed) {
                        j1_c.emitting = false;
                        return;
                    }
                    j1_c.missed = false;
                }
            }
        }
    }

    @Override // j0.l.a.j1$e
    public final void i(Throwable th) {
        e$c e_c = new e$c(th);
        long j = this.index + 1;
        this.index = j;
        j1$d j1_d = new j1$d(e_c, j);
        this.tail.set(j1_d);
        this.tail = j1_d;
        this.size++;
    }
}
