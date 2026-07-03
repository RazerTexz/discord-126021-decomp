package p637j0.p651n;

import java.util.Arrays;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p652o.C12774l;
import p637j0.p652o.C12777o;
import p658rx.Subscriber;
import p658rx.exceptions.CompositeException;
import p658rx.exceptions.OnCompletedFailedException;
import p658rx.exceptions.OnErrorFailedException;
import p658rx.exceptions.OnErrorNotImplementedException;
import p658rx.exceptions.UnsubscribeFailedException;

/* JADX INFO: renamed from: j0.n.b */
/* JADX INFO: compiled from: SafeSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12759b<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final Subscriber<? super T> f27364j;

    /* JADX INFO: renamed from: k */
    public boolean f27365k;

    public C12759b(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.f27364j = subscriber;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        if (this.f27365k) {
            return;
        }
        this.f27365k = true;
        try {
            this.f27364j.onCompleted();
            try {
                unsubscribe();
            } catch (Throwable th) {
                C12774l.m10863b(th);
                throw new UnsubscribeFailedException(th.getMessage(), th);
            }
        } catch (Throwable th2) {
            try {
                C3404f.m4325o1(th2);
                C12774l.m10863b(th2);
                throw new OnCompletedFailedException(th2.getMessage(), th2);
            } catch (Throwable th3) {
                try {
                    unsubscribe();
                    throw th3;
                } catch (Throwable th4) {
                    C12774l.m10863b(th4);
                    throw new UnsubscribeFailedException(th4.getMessage(), th4);
                }
            }
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        C3404f.m4325o1(th);
        if (this.f27365k) {
            return;
        }
        this.f27365k = true;
        Objects.requireNonNull(C12777o.f27384a.m10869b());
        try {
            this.f27364j.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                C12774l.m10863b(th2);
                throw new OnErrorFailedException(th2);
            }
        } catch (OnErrorNotImplementedException e) {
            try {
                unsubscribe();
                throw e;
            } catch (Throwable th3) {
                C12774l.m10863b(th3);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            C12774l.m10863b(th4);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                C12774l.m10863b(th5);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
            }
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        try {
            if (this.f27365k) {
                return;
            }
            this.f27364j.onNext(t);
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            onError(th);
        }
    }
}
