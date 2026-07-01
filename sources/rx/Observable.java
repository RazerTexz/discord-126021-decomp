package rx;

import j0.k.a$a;
import j0.k.b;
import j0.k.d;
import j0.k.e;
import j0.k.g;
import j0.k.h;
import j0.k.i;
import j0.k.j;
import j0.l.a.a1$b;
import j0.l.a.b1$a;
import j0.l.a.c;
import j0.l.a.c1;
import j0.l.a.c2;
import j0.l.a.f;
import j0.l.a.f0;
import j0.l.a.f1;
import j0.l.a.f2;
import j0.l.a.g0;
import j0.l.a.h2;
import j0.l.a.i0;
import j0.l.a.j1;
import j0.l.a.k0;
import j0.l.a.k1;
import j0.l.a.l0;
import j0.l.a.l1;
import j0.l.a.n0;
import j0.l.a.n1;
import j0.l.a.n2$a;
import j0.l.a.o;
import j0.l.a.o1;
import j0.l.a.p;
import j0.l.a.q;
import j0.l.a.q0;
import j0.l.a.q2;
import j0.l.a.r;
import j0.l.a.r1$a;
import j0.l.a.s;
import j0.l.a.s0;
import j0.l.a.t1;
import j0.l.a.u0;
import j0.l.a.u0$a;
import j0.l.a.v0;
import j0.l.a.w0;
import j0.l.a.x0$b;
import j0.l.a.x1;
import j0.l.a.y;
import j0.l.a.y1$a;
import j0.l.a.z0;
import j0.l.c.m;
import j0.l.e.e$d;
import j0.l.e.k;
import j0.l.e.m$a;
import j0.o.l;
import j0.p.a;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.FuncN;

/* JADX INFO: loaded from: classes3.dex */
public class Observable<T> {
    public final Observable$a<T> j;

    public Observable(Observable$a<T> observable$a) {
        this.j = observable$a;
    }

    public static <T> Observable<T> B(Iterable<? extends T> iterable) {
        return h0(new q(iterable));
    }

    public static <T> Observable<T> C(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return (Observable<T>) c.k;
        }
        return length == 1 ? new k(tArr[0]) : h0(new o(tArr));
    }

    public static <T> Observable<T> D(Callable<? extends T> callable) {
        return h0(new p(callable));
    }

    public static Observable<Long> E(long j, long j2, TimeUnit timeUnit) {
        return F(j, j2, timeUnit, a.a());
    }

    public static Observable<Long> F(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return h0(new k0(j, j2, timeUnit, scheduler));
    }

    public static <T> Observable<T> H(Observable<? extends Observable<? extends T>> observable) {
        if (observable.getClass() == k.class) {
            return ((k) observable).k0(m$a.INSTANCE);
        }
        return h0(new r(observable.j, x0$b.a));
    }

    public static <T> Observable<T> I(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return H(C(new Observable[]{observable, observable2}));
    }

    public static <T, R> Observable<R> b(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN) {
        return h0(new f(list, funcN));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> c(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), new j0.k.c(func9));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> d(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), new j(func8));
    }

    public static Observable<Long> d0(long j, TimeUnit timeUnit) {
        return e0(j, timeUnit, a.a());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> e(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), new i(func7));
    }

    public static Observable<Long> e0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return h0(new i0(j, timeUnit, scheduler));
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> f(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), new h(func6));
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> g(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5), new g(func5));
    }

    public static <T1, T2, T3, T4, R> Observable<R> h(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return b(Arrays.asList(observable, observable2, observable3, observable4), new j0.k.f(func4));
    }

    public static <T> Observable<T> h0(Observable$a<T> observable$a) {
        return new Observable<>(l.a(observable$a));
    }

    public static <T1, T2, T3, R> Observable<R> i(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return b(Arrays.asList(observable, observable2, observable3), new e(func3));
    }

    public static <T1, T2, R> Observable<R> j(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return b(Arrays.asList(observable, observable2), new d(func2));
    }

    public static <T1, T2, R> Observable<R> j0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return h0(new r(new k(new Observable[]{observable, observable2}).j, new q2(func2)));
    }

    public static <T> Observable<T> l(Iterable<? extends Observable<? extends T>> iterable) {
        return h0(new q(iterable)).n(m$a.INSTANCE);
    }

    public static <T> Observable<T> m(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return C(new Object[]{observable, observable2}).n(m$a.INSTANCE);
    }

    public static <T> Observable<T> o(Action1<Emitter<T>> action1, Emitter$BackpressureMode emitter$BackpressureMode) {
        return h0(new j0.l.a.i(action1, emitter$BackpressureMode));
    }

    public static <T> Observable<T> x(Throwable th) {
        return h0(new f0(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> A(b<? super T, ? extends Observable<? extends R>> bVar) {
        return getClass() == k.class ? ((k) this).k0(bVar) : H(G(bVar));
    }

    public final <R> Observable<R> G(b<? super T, ? extends R> bVar) {
        return h0(new s(this, bVar));
    }

    public final Observable<T> J(Scheduler scheduler) {
        int i = j0.l.e.i.j;
        if (this instanceof k) {
            return ((k) this).l0(scheduler);
        }
        return h0(new r(this.j, new z0(scheduler, false, i)));
    }

    public final Observable<T> K() {
        return h0(new r(this.j, a1$b.a));
    }

    public final Observable<T> L() {
        return h0(new r(this.j, b1$a.a));
    }

    public final Observable<T> M(b<? super Throwable, ? extends T> bVar) {
        return h0(new r(this.j, new f1(new c1(bVar))));
    }

    public final j0.m.b<T> N(int i) {
        if (i == Integer.MAX_VALUE) {
            Func0 func0 = j1.k;
            AtomicReference atomicReference = new AtomicReference();
            return new j1(new l1(atomicReference, func0), this, atomicReference, func0);
        }
        k1 k1Var = new k1(i);
        AtomicReference atomicReference2 = new AtomicReference();
        return new j1(new l1(atomicReference2, k1Var), this, atomicReference2, k1Var);
    }

    public final Observable<T> O(b<? super Observable<? extends Throwable>, ? extends Observable<?>> bVar) {
        e$d e_d = new e$d(bVar);
        AtomicReference<a> atomicReference = a.a;
        return h0(new y(this, e_d, true, false, m.a));
    }

    public final Observable<T> P(long j, TimeUnit timeUnit) {
        return h0(new r(this.j, new n1(j, timeUnit, a.a())));
    }

    public final <R> Observable<R> Q(R r, Func2<R, ? super T, R> func2) {
        return h0(new r(this.j, new o1(r, func2)));
    }

    public final Observable<T> R() {
        return h0(new r(this.j, r1$a.a));
    }

    public final Observable<T> S(int i) {
        return h0(new r(this.j, new t1(i)));
    }

    public final Observable<T> T(T t) {
        return m(new k(t), this);
    }

    public final Subscription U(Subscriber<? super T> subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (this.j == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        subscriber.onStart();
        if (!(subscriber instanceof j0.n.b)) {
            subscriber = new j0.n.b(subscriber);
        }
        try {
            Observable$a observable$aCall = this.j;
            Func2<Observable, Observable$a, Observable$a> func2 = l.e;
            if (func2 != null) {
                observable$aCall = func2.call(this, observable$aCall);
            }
            observable$aCall.call(subscriber);
            b<Subscription, Subscription> bVar = l.g;
            return bVar != null ? bVar.call(subscriber) : subscriber;
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            if (subscriber.isUnsubscribed()) {
                l.b(l.c(th));
            } else {
                try {
                    subscriber.onError(l.c(th));
                } catch (Throwable th2) {
                    b.i.a.f.e.o.f.o1(th2);
                    StringBuilder sbU = b.d.b.a.a.U("Error occurred attempting to subscribe [");
                    sbU.append(th.getMessage());
                    sbU.append("] and then again while trying to pass to onError.");
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException(sbU.toString(), th2);
                    l.c(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
            return j0.r.c.a;
        }
    }

    public final Subscription V(Action1<? super T> action1) {
        return U(new j0.l.e.b(action1, j0.l.e.e.l, j0.k.a.a));
    }

    public final Subscription W(Action1<? super T> action1, Action1<Throwable> action2) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (action2 != null) {
            return U(new j0.l.e.b(action1, action2, j0.k.a.a));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final Observable<T> X(Scheduler scheduler) {
        return this instanceof k ? ((k) this).l0(scheduler) : h0(new x1(this, scheduler, !(this.j instanceof j0.l.a.i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> Y(b<? super T, ? extends Observable<? extends R>> bVar) {
        Observable<R> observableG = G(bVar);
        return h0(new r(observableG.j, y1$a.a));
    }

    public final Observable<T> Z(int i) {
        return h0(new r(this.j, new c2(i)));
    }

    public final Observable<List<T>> a(long j, TimeUnit timeUnit) {
        return h0(new r(this.j, new n0(j, j, timeUnit, Integer.MAX_VALUE, a.a())));
    }

    public final <E> Observable<T> a0(Observable<? extends E> observable) {
        return h0(new r(this.j, new f2(observable)));
    }

    public final Observable<T> b0(b<? super T, Boolean> bVar) {
        return h0(new r(this.j, new h2(bVar)));
    }

    public final Observable<T> c0(long j, TimeUnit timeUnit) {
        return h0(new g0(this, j, timeUnit, a.a(), null));
    }

    public final Observable<List<T>> f0() {
        return h0(new r(this.j, n2$a.a));
    }

    public final <K, V> Observable<Map<K, V>> g0(b<? super T, ? extends K> bVar, b<? super T, ? extends V> bVar2) {
        return h0(new l0(this, bVar, bVar2));
    }

    public final Subscription i0(Subscriber<? super T> subscriber) {
        try {
            subscriber.onStart();
            Observable$a observable$aCall = this.j;
            Func2<Observable, Observable$a, Observable$a> func2 = l.e;
            if (func2 != null) {
                observable$aCall = func2.call(this, observable$aCall);
            }
            observable$aCall.call(subscriber);
            b<Subscription, Subscription> bVar = l.g;
            return bVar != null ? bVar.call(subscriber) : subscriber;
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            try {
                subscriber.onError(l.c(th));
                return j0.r.c.a;
            } catch (Throwable th2) {
                b.i.a.f.e.o.f.o1(th2);
                StringBuilder sbU = b.d.b.a.a.U("Error occurred attempting to subscribe [");
                sbU.append(th.getMessage());
                sbU.append("] and then again while trying to pass to onError.");
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException(sbU.toString(), th2);
                l.c(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public <R> Observable<R> k(Observable$c<? super T, ? extends R> observable$c) {
        return (Observable) observable$c.call(this);
    }

    public final <R> Observable<R> n(b<? super T, ? extends Observable<? extends R>> bVar) {
        return this instanceof k ? ((k) this).k0(bVar) : h0(new j0.l.a.h(this, bVar, 2, 0));
    }

    public final Observable<T> p(long j, TimeUnit timeUnit) {
        return h0(new r(this.j, new q0(j, timeUnit, a.a())));
    }

    public final Observable<T> q(long j, TimeUnit timeUnit) {
        return h0(new r(this.j, new s0(j, timeUnit, a.a())));
    }

    public final Observable<T> r() {
        return h0(new r(this.j, u0$a.a));
    }

    public final Observable<T> s(Func2<? super T, ? super T, Boolean> func2) {
        return h0(new r(this.j, new u0(func2)));
    }

    public final Observable<T> t(Action1<? super Throwable> action1) {
        a$a a_a = j0.k.a.a;
        return h0(new j0.l.a.k(this, new j0.l.e.a(a_a, action1, a_a)));
    }

    public final Observable<T> u(Action1<? super T> action1) {
        a$a a_a = j0.k.a.a;
        return h0(new j0.l.a.k(this, new j0.l.e.a(action1, a_a, a_a)));
    }

    public final Observable<T> v(Action0 action0) {
        return h0(new r(this.j, new v0(action0)));
    }

    public final Observable<T> w(Action0 action0) {
        return h0(new r(this.j, new w0(action0)));
    }

    public final Observable<T> y(b<? super T, Boolean> bVar) {
        return h0(new j0.l.a.l(this, bVar));
    }

    public final Observable<T> z() {
        return Z(1).R();
    }
}
