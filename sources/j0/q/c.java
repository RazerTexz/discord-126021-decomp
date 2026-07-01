package j0.q;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable$a;
import rx.Subscriber;
import rx.functions.Action1;

/* JADX INFO: compiled from: SubjectSubscriptionManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> extends AtomicReference<c$a<T>> implements Observable$a<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    public boolean active;
    public volatile Object latest;
    public Action1<c$b<T>> onAdded;
    public Action1<c$b<T>> onStart;
    public Action1<c$b<T>> onTerminated;

    public c() {
        super(c$a.c);
        this.active = true;
        j0.k.a$a a_a = j0.k.a.a;
        this.onStart = a_a;
        this.onAdded = a_a;
        this.onTerminated = a_a;
    }

    public void a(c$b<T> c_b) {
        c$a<T> c_a;
        c$a<T> c_a2;
        do {
            c_a = get();
            if (c_a.d) {
                return;
            }
            c$b<T>[] c_bArr = c_a.e;
            int length = c_bArr.length;
            if (length != 1 || c_bArr[0] != c_b) {
                if (length != 0) {
                    int i = length - 1;
                    c$b[] c_bArr2 = new c$b[i];
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        if (i2 >= length) {
                            if (i3 != 0) {
                                if (i3 < i) {
                                    c$b[] c_bArr3 = new c$b[i3];
                                    System.arraycopy(c_bArr2, 0, c_bArr3, 0, i3);
                                    c_bArr2 = c_bArr3;
                                }
                                c_a2 = new c$a<>(c_a.d, c_bArr2);
                                break;
                            }
                            c_a2 = c$a.c;
                            break;
                        }
                        c$b<T> c_b2 = c_bArr[i2];
                        if (c_b2 != c_b) {
                            if (i3 == i) {
                                c_a2 = c_a;
                                break;
                            } else {
                                c_bArr2[i3] = c_b2;
                                i3++;
                            }
                        }
                        i2++;
                    }
                } else {
                    c_a2 = c_a;
                    break;
                }
            } else {
                c_a2 = c$a.c;
            }
            if (c_a2 == c_a) {
                return;
            }
        } while (!compareAndSet(c_a, c_a2));
    }

    public c$b<T>[] b(Object obj) {
        this.latest = obj;
        this.active = false;
        return get().d ? c$a.a : getAndSet(c$a.f3805b).e;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        c$b<T> c_b = new c$b<>(subscriber);
        subscriber.add(new j0.r.a(new b(this, c_b)));
        this.onStart.call(c_b);
        if (subscriber.isUnsubscribed()) {
            return;
        }
        while (true) {
            c$a<T> c_a = get();
            z2 = false;
            if (c_a.d) {
                this.onTerminated.call(c_b);
                break;
            }
            c$b[] c_bArr = c_a.e;
            int length = c_bArr.length;
            c$b[] c_bArr2 = new c$b[length + 1];
            System.arraycopy(c_bArr, 0, c_bArr2, 0, length);
            c_bArr2[length] = c_b;
            if (compareAndSet(c_a, new c$a(c_a.d, c_bArr2))) {
                this.onAdded.call(c_b);
                z2 = true;
                break;
            }
        }
        if (z2 && subscriber.isUnsubscribed()) {
            a(c_b);
        }
    }
}
