package p637j0.p642l.p643a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.o */
/* JADX INFO: compiled from: OnSubscribeFromArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12654o<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final T[] f26955j;

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

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(C1643a.m877t("n >= 0 required but it was ", j));
            }
            if (j == RecyclerView.FOREVER_NS) {
                if (C3404f.m4276c0(this, j) == 0) {
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
            if (j == 0 || C3404f.m4276c0(this, j) != 0) {
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

    public C12654o(T[] tArr) {
        this.f26955j = tArr;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.setProducer(new a(subscriber, this.f26955j));
    }
}
