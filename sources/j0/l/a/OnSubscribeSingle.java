package j0.l.a;

import j0.SingleSubscriber;
import java.util.NoSuchElementException;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.d0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeSingle<T> extends Subscriber<T> {
    public boolean j;
    public boolean k;
    public T l;
    public final /* synthetic */ SingleSubscriber m;

    public OnSubscribeSingle(OnSubscribeSingle2 onSubscribeSingle2, SingleSubscriber singleSubscriber) {
        this.m = singleSubscriber;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        if (this.j) {
            return;
        }
        if (this.k) {
            this.m.b(this.l);
        } else {
            this.m.a(new NoSuchElementException("Observable emitted no items"));
        }
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.m.a(th);
        unsubscribe();
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        if (!this.k) {
            this.k = true;
            this.l = t;
        } else {
            this.j = true;
            this.m.a(new IllegalArgumentException("Observable emitted too many elements"));
            unsubscribe();
        }
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(2L);
    }
}
