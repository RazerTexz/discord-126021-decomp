package j0.l.a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.o, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeFromArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeFromArray<T> implements Observable.a<T> {
    public final T[] j;

    /* JADX INFO: renamed from: j0.l.a.o$a */
    /* JADX INFO: compiled from: OnSubscribeFromArray.java */
    public static final class a<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = 3534218984725836979L;
        public final T[] array;
        public final Subscriber<? super T> child;
        public int index;

        public a(Subscriber<? super T> subscriber, T[] tArr) {
            this.child = subscriber;
            this.array = tArr;
        }

        @Override // rx.Producer
        public void j(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(outline.t("n >= 0 required but it was ", j));
            }
            if (j == RecyclerView.FOREVER_NS) {
                if (b.i.a.f.e.o.f.c0(this, j) == 0) {
                    Subscriber<? super T> subscriber = this.child;
                    for (R.anim animVar : this.array) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onNext(animVar);
                    }
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onCompleted();
                    return;
                }
                return;
            }
            if (j == 0 || b.i.a.f.e.o.f.c0(this, j) != 0) {
                return;
            }
            Subscriber<? super T> subscriber2 = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            do {
                long j2 = 0;
                while (true) {
                    if (j == 0 || i == length) {
                        j = get() + j2;
                        if (j == 0) {
                            break;
                        }
                    } else {
                        if (subscriber2.isUnsubscribed()) {
                            return;
                        }
                        subscriber2.onNext(tArr[i]);
                        i++;
                        if (i == length) {
                            if (subscriber2.isUnsubscribed()) {
                                return;
                            }
                            subscriber2.onCompleted();
                            return;
                        }
                        j--;
                        j2--;
                    }
                }
                this.index = i;
                j = addAndGet(j2);
            } while (j != 0);
        }
    }

    public OnSubscribeFromArray(T[] tArr) {
        this.j = tArr;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.setProducer(new a(subscriber, this.j));
    }
}
