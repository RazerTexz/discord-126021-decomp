package j0.l.a;

import android.R$anim;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y1$c<T> extends Subscriber<Observable<? extends T>> {
    public static final Throwable j = new Throwable("Terminal error");
    public final Subscriber<? super T> k;
    public final boolean m;
    public boolean p;
    public boolean q;
    public long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Producer f3783s;
    public volatile boolean t;
    public Throwable u;
    public boolean v;
    public final SerialSubscription l = new SerialSubscription();
    public final AtomicLong n = new AtomicLong();
    public final j0.l.e.n.e<Object> o = new j0.l.e.n.e<>(j0.l.e.i.j);

    public y1$c(Subscriber<? super T> subscriber, boolean z2) {
        this.k = subscriber;
        this.m = z2;
    }

    public boolean a(boolean z2, boolean z3, Throwable th, j0.l.e.n.e<Object> eVar, Subscriber<? super T> subscriber, boolean z4) {
        if (this.m) {
            if (!z2 || z3 || !z4) {
                return false;
            }
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onCompleted();
            }
            return true;
        }
        if (th != null) {
            eVar.clear();
            subscriber.onError(th);
            return true;
        }
        if (!z2 || z3 || !z4) {
            return false;
        }
        subscriber.onCompleted();
        return true;
    }

    public void b() {
        Throwable th;
        Throwable th2;
        synchronized (this) {
            if (this.p) {
                this.q = true;
                return;
            }
            this.p = true;
            boolean z2 = this.v;
            long j2 = this.r;
            Throwable th3 = this.u;
            if (th3 != null && th3 != (th2 = j) && !this.m) {
                this.u = th2;
            }
            j0.l.e.n.e<Object> eVar = this.o;
            AtomicLong atomicLong = this.n;
            Subscriber<? super T> subscriber = this.k;
            long j3 = j2;
            Throwable th4 = th3;
            boolean z3 = this.t;
            while (true) {
                long j4 = 0;
                while (j4 != j3) {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    boolean zIsEmpty = eVar.isEmpty();
                    if (a(z3, z2, th4, eVar, subscriber, zIsEmpty)) {
                        return;
                    }
                    if (zIsEmpty) {
                        break;
                    }
                    y1$b y1_b = (y1$b) eVar.poll();
                    R$anim r$anim = (Object) e.b(eVar.poll());
                    if (atomicLong.get() == y1_b.j) {
                        subscriber.onNext(r$anim);
                        j4++;
                    }
                }
                if (j4 == j3) {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    if (a(this.t, z2, th4, eVar, subscriber, eVar.isEmpty())) {
                        return;
                    }
                }
                synchronized (this) {
                    long j5 = this.r;
                    if (j5 != RecyclerView.FOREVER_NS) {
                        j5 -= j4;
                        this.r = j5;
                    }
                    j3 = j5;
                    if (!this.q) {
                        this.p = false;
                        return;
                    }
                    this.q = false;
                    z3 = this.t;
                    z2 = this.v;
                    th4 = this.u;
                    if (th4 != null && th4 != (th = j) && !this.m) {
                        this.u = th;
                    }
                }
            }
        }
    }

    public boolean c(Throwable th) {
        Throwable th2 = this.u;
        if (th2 == j) {
            return false;
        }
        if (th2 == null) {
            this.u = th;
        } else if (th2 instanceof CompositeException) {
            ArrayList arrayList = new ArrayList(((CompositeException) th2).b());
            arrayList.add(th);
            this.u = new CompositeException(arrayList);
        } else {
            this.u = new CompositeException(th2, th);
        }
        return true;
    }

    @Override // j0.g
    public void onCompleted() {
        this.t = true;
        b();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        boolean zC;
        synchronized (this) {
            zC = c(th);
        }
        if (!zC) {
            j0.o.l.b(th);
        } else {
            this.t = true;
            b();
        }
    }

    @Override // j0.g
    public void onNext(Object obj) {
        y1$b y1_b;
        Observable observable = (Observable) obj;
        long jIncrementAndGet = this.n.incrementAndGet();
        Subscription subscription = this.l.j.get();
        if (subscription == j0.l.d.b.INSTANCE) {
            subscription = j0.r.c.a;
        }
        if (subscription != null) {
            subscription.unsubscribe();
        }
        synchronized (this) {
            y1_b = new y1$b(jIncrementAndGet, this);
            this.v = true;
            this.f3783s = null;
        }
        this.l.a(y1_b);
        observable.i0(y1_b);
    }
}
