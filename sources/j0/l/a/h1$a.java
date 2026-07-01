package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h1$a<T> extends AtomicLong implements Producer, Subscription {
    private static final long serialVersionUID = -4453897557930727610L;
    public final Subscriber<? super T> child;
    public final h1$b<T> parent;

    public h1$a(h1$b<T> h1_b, Subscriber<? super T> subscriber) {
        this.parent = h1_b;
        this.child = subscriber;
        lazySet(-4611686018427387904L);
    }

    public long a(long j) {
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
    public void j(long j) throws Throwable {
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
        this.parent.b();
    }

    @Override // rx.Subscription
    public void unsubscribe() throws Throwable {
        h1$a[] h1_aArr;
        h1$a[] h1_aArr2;
        if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
            return;
        }
        h1$b<T> h1_b = this.parent;
        do {
            h1_aArr = h1_b.o.get();
            if (h1_aArr != h1$b.j && h1_aArr != h1$b.k) {
                int length = h1_aArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (h1_aArr[i].equals(this)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    break;
                }
                if (length == 1) {
                    h1_aArr2 = h1$b.j;
                } else {
                    h1$a[] h1_aArr3 = new h1$a[length - 1];
                    System.arraycopy(h1_aArr, 0, h1_aArr3, 0, i);
                    System.arraycopy(h1_aArr, i + 1, h1_aArr3, i, (length - i) - 1);
                    h1_aArr2 = h1_aArr3;
                }
            } else {
                break;
            }
        } while (!h1_b.o.compareAndSet(h1_aArr, h1_aArr2));
        this.parent.b();
    }
}
