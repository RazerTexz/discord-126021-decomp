package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j1$h<T> extends ArrayList<Object> implements j1$e<T> {
    private static final long serialVersionUID = 7063189396499112664L;
    public volatile int size;

    public j1$h(int i) {
        super(i);
    }

    @Override // j0.l.a.j1$e
    public void complete() {
        add(e.a);
        this.size++;
    }

    @Override // j0.l.a.j1$e
    public void g(T t) {
        if (t == null) {
            t = (T) e.f3771b;
        }
        add(t);
        this.size++;
    }

    @Override // j0.l.a.j1$e
    public void h(j1$c<T> j1_c) {
        synchronized (j1_c) {
            if (j1_c.emitting) {
                j1_c.missed = true;
                return;
            }
            j1_c.emitting = true;
            while (!j1_c.isUnsubscribed()) {
                int i = this.size;
                Integer num = (Integer) j1_c.index;
                int iIntValue = num != null ? num.intValue() : 0;
                Subscriber<? super T> subscriber = j1_c.child;
                if (subscriber == null) {
                    return;
                }
                long j = j1_c.get();
                long j2 = 0;
                while (j2 != j && iIntValue < i) {
                    Object obj = get(iIntValue);
                    try {
                        if (e.a(subscriber, obj) || j1_c.isUnsubscribed()) {
                            return;
                        }
                        iIntValue++;
                        j2++;
                    } catch (Throwable th) {
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
                    j1_c.index = Integer.valueOf(iIntValue);
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
    public void i(Throwable th) {
        add(new e$c(th));
        this.size++;
    }
}
