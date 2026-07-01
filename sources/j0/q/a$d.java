package j0.q;

import b.i.a.f.e.o.f;
import j0.g;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: ReplaySubject.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$d<T> extends AtomicReference<a$b<T>[]> implements Observable$a<T>, g<T> {
    public static final a$b[] j = new a$b[0];
    public static final a$b[] k = new a$b[0];
    private static final long serialVersionUID = 5952362471246910544L;
    public final a$a<T> buffer;

    public a$d(a$a<T> a_a) {
        this.buffer = a_a;
        lazySet(j);
    }

    public void a(a$b<T> a_b) {
        a$b<T>[] a_bArr;
        a$b[] a_bArr2;
        do {
            a_bArr = get();
            if (a_bArr == k || a_bArr == j) {
                return;
            }
            int length = a_bArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (a_bArr[i] == a_b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                a_bArr2 = j;
            } else {
                a$b[] a_bArr3 = new a$b[length - 1];
                System.arraycopy(a_bArr, 0, a_bArr3, 0, i);
                System.arraycopy(a_bArr, i + 1, a_bArr3, i, (length - i) - 1);
                a_bArr2 = a_bArr3;
            }
        } while (!compareAndSet(a_bArr, a_bArr2));
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        a$b<T> a_b = new a$b<>(subscriber, this);
        subscriber.add(a_b);
        subscriber.setProducer(a_b);
        while (true) {
            a$b<T>[] a_bArr = get();
            z2 = false;
            if (a_bArr == k) {
                break;
            }
            int length = a_bArr.length;
            a$b[] a_bArr2 = new a$b[length + 1];
            System.arraycopy(a_bArr, 0, a_bArr2, 0, length);
            a_bArr2[length] = a_b;
            if (compareAndSet(a_bArr, a_bArr2)) {
                z2 = true;
                break;
            }
        }
        if (z2 && a_b.isUnsubscribed()) {
            a(a_b);
        } else {
            ((a$c) this.buffer).a(a_b);
        }
    }

    @Override // j0.g
    public void onCompleted() {
        a$a<T> a_a = this.buffer;
        ((a$c) a_a).e = true;
        for (a$b<T> a_b : getAndSet(k)) {
            ((a$c) a_a).a(a_b);
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        a$a<T> a_a = this.buffer;
        a$c a_c = (a$c) a_a;
        a_c.f = th;
        a_c.e = true;
        ArrayList arrayList = null;
        for (a$b<T> a_b : getAndSet(k)) {
            try {
                ((a$c) a_a).a(a_b);
            } catch (Throwable th2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
            }
        }
        f.n1(arrayList);
    }

    @Override // j0.g
    public void onNext(T t) {
        a$a<T> a_a = this.buffer;
        a$c a_c = (a$c) a_a;
        Objects.requireNonNull(a_c);
        a$c$a<T> a_c_a = new a$c$a<>(t);
        a_c.c.set(a_c_a);
        a_c.c = a_c_a;
        int i = a_c.d;
        if (i == a_c.a) {
            a_c.f3804b = a_c.f3804b.get();
        } else {
            a_c.d = i + 1;
        }
        for (a$b<T> a_b : get()) {
            ((a$c) a_a).a(a_b);
        }
    }
}
