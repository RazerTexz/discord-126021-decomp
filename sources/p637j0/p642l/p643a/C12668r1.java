package p637j0.p642l.p643a;

import java.util.NoSuchElementException;
import p637j0.p642l.p644b.C12695c;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.r1 */
/* JADX INFO: compiled from: OperatorSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12668r1<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j0.l.a.r1$a */
    /* JADX INFO: compiled from: OperatorSingle.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final C12668r1<?> f27024a = new C12668r1<>();
    }

    /* JADX INFO: renamed from: j0.l.a.r1$b */
    /* JADX INFO: compiled from: OperatorSingle.java */
    public static final class b<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super T> f27025j;

        /* JADX INFO: renamed from: k */
        public final boolean f27026k;

        /* JADX INFO: renamed from: l */
        public final T f27027l;

        /* JADX INFO: renamed from: m */
        public T f27028m;

        /* JADX INFO: renamed from: n */
        public boolean f27029n;

        /* JADX INFO: renamed from: o */
        public boolean f27030o;

        public b(Subscriber<? super T> subscriber, boolean z2, T t) {
            this.f27025j = subscriber;
            this.f27026k = z2;
            this.f27027l = t;
            request(2L);
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (this.f27030o) {
                return;
            }
            if (this.f27029n) {
                this.f27025j.setProducer(new C12695c(this.f27025j, this.f27028m));
            } else if (this.f27026k) {
                this.f27025j.setProducer(new C12695c(this.f27025j, this.f27027l));
            } else {
                this.f27025j.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (this.f27030o) {
                C12774l.m10863b(th);
            } else {
                this.f27025j.onError(th);
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            if (this.f27030o) {
                return;
            }
            if (!this.f27029n) {
                this.f27028m = t;
                this.f27029n = true;
            } else {
                this.f27030o = true;
                this.f27025j.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            }
        }
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        b bVar = new b(subscriber, false, null);
        subscriber.add(bVar);
        return bVar;
    }
}
