package rx.subjects;

import b.i.a.f.e.o.f;
import j0.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public final class PublishSubject$b<T> extends AtomicReference<PublishSubject$a<T>[]> implements Observable$a<T>, g<T> {
    public static final PublishSubject$a[] j = new PublishSubject$a[0];
    public static final PublishSubject$a[] k = new PublishSubject$a[0];
    private static final long serialVersionUID = -7568940796666027140L;
    public Throwable error;

    public PublishSubject$b() {
        lazySet(j);
    }

    public void a(PublishSubject$a<T> publishSubject$a) {
        PublishSubject$a<T>[] publishSubject$aArr;
        PublishSubject$a[] publishSubject$aArr2;
        do {
            publishSubject$aArr = get();
            if (publishSubject$aArr == k || publishSubject$aArr == j) {
                return;
            }
            int length = publishSubject$aArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (publishSubject$aArr[i] == publishSubject$a) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishSubject$aArr2 = j;
            } else {
                PublishSubject$a[] publishSubject$aArr3 = new PublishSubject$a[length - 1];
                System.arraycopy(publishSubject$aArr, 0, publishSubject$aArr3, 0, i);
                System.arraycopy(publishSubject$aArr, i + 1, publishSubject$aArr3, i, (length - i) - 1);
                publishSubject$aArr2 = publishSubject$aArr3;
            }
        } while (!compareAndSet(publishSubject$aArr, publishSubject$aArr2));
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        PublishSubject$a<T> publishSubject$a = new PublishSubject$a<>(this, subscriber);
        subscriber.add(publishSubject$a);
        subscriber.setProducer(publishSubject$a);
        while (true) {
            PublishSubject$a<T>[] publishSubject$aArr = get();
            z2 = false;
            if (publishSubject$aArr == k) {
                break;
            }
            int length = publishSubject$aArr.length;
            PublishSubject$a[] publishSubject$aArr2 = new PublishSubject$a[length + 1];
            System.arraycopy(publishSubject$aArr, 0, publishSubject$aArr2, 0, length);
            publishSubject$aArr2[length] = publishSubject$a;
            if (compareAndSet(publishSubject$aArr, publishSubject$aArr2)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            if (publishSubject$a.isUnsubscribed()) {
                a(publishSubject$a);
            }
        } else {
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onCompleted();
            }
        }
    }

    @Override // j0.g
    public void onCompleted() {
        for (PublishSubject$a<T> publishSubject$a : getAndSet(k)) {
            publishSubject$a.onCompleted();
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.error = th;
        ArrayList arrayList = null;
        for (PublishSubject$a<T> publishSubject$a : getAndSet(k)) {
            try {
                publishSubject$a.onError(th);
            } catch (Throwable th2) {
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                }
                arrayList.add(th2);
            }
        }
        f.n1(arrayList);
    }

    @Override // j0.g
    public void onNext(T t) {
        for (PublishSubject$a<T> publishSubject$a : get()) {
            publishSubject$a.onNext(t);
        }
    }
}
