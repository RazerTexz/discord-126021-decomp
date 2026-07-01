package rx;

import b.d.b.a.outline;
import j0.k.Actions2;
import j0.k.Func1;
import j0.k.d;
import j0.k.e;
import j0.k.f;
import j0.k.g;
import j0.k.h;
import j0.k.i;
import j0.k.j;
import j0.l.a.EmptyObservableHolder;
import j0.l.a.OnSubscribeCombineLatest;
import j0.l.a.OnSubscribeConcatMap2;
import j0.l.a.OnSubscribeCreate;
import j0.l.a.OnSubscribeDoOnEach;
import j0.l.a.OnSubscribeFilter;
import j0.l.a.OnSubscribeFromArray;
import j0.l.a.OnSubscribeFromCallable;
import j0.l.a.OnSubscribeFromIterable;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OnSubscribeMap;
import j0.l.a.OnSubscribeRedo6;
import j0.l.a.OnSubscribeThrow;
import j0.l.a.OnSubscribeTimeoutTimedWithFallback;
import j0.l.a.OnSubscribeTimerOnce2;
import j0.l.a.OnSubscribeTimerPeriodically2;
import j0.l.a.OnSubscribeToMap;
import j0.l.a.OperatorBufferWithTime2;
import j0.l.a.OperatorDebounceWithTime2;
import j0.l.a.OperatorDelay2;
import j0.l.a.OperatorDistinctUntilChanged2;
import j0.l.a.OperatorDoOnSubscribe;
import j0.l.a.OperatorDoOnUnsubscribe;
import j0.l.a.OperatorMerge;
import j0.l.a.OperatorObserveOn2;
import j0.l.a.OperatorOnBackpressureBuffer;
import j0.l.a.OperatorOnBackpressureLatest;
import j0.l.a.OperatorOnErrorResumeNextViaFunction;
import j0.l.a.OperatorOnErrorResumeNextViaFunction4;
import j0.l.a.OperatorReplay;
import j0.l.a.OperatorReplay2;
import j0.l.a.OperatorReplay3;
import j0.l.a.OperatorSampleWithTime;
import j0.l.a.OperatorScan;
import j0.l.a.OperatorSingle;
import j0.l.a.OperatorSkip2;
import j0.l.a.OperatorSubscribeOn;
import j0.l.a.OperatorSwitch2;
import j0.l.a.OperatorTake2;
import j0.l.a.OperatorTakeUntil3;
import j0.l.a.OperatorTakeUntilPredicate2;
import j0.l.a.OperatorToObservableList2;
import j0.l.a.OperatorZip;
import j0.l.c.TrampolineScheduler;
import j0.l.e.ActionObserver;
import j0.l.e.ActionSubscriber;
import j0.l.e.InternalObservableUtils;
import j0.l.e.RxRingBuffer;
import j0.l.e.ScalarSynchronousObservable;
import j0.l.e.UtilityFunctions;
import j0.m.ConnectableObservable;
import j0.n.SafeSubscriber;
import j0.o.l;
import j0.p.Schedulers2;
import j0.r.Subscriptions;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
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
    public final a<T> j;

    public interface a<T> extends Action1<Subscriber<? super T>> {
    }

    public interface b<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
    }

    public interface c<T, R> extends Func1<Observable<T>, Observable<R>> {
    }

    public Observable(a<T> aVar) {
        this.j = aVar;
    }

    public static <T> Observable<T> B(Iterable<? extends T> iterable) {
        return h0(new OnSubscribeFromIterable(iterable));
    }

    public static <T> Observable<T> C(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return (Observable<T>) EmptyObservableHolder.k;
        }
        return length == 1 ? new ScalarSynchronousObservable(tArr[0]) : h0(new OnSubscribeFromArray(tArr));
    }

    public static <T> Observable<T> D(Callable<? extends T> callable) {
        return h0(new OnSubscribeFromCallable(callable));
    }

    public static Observable<Long> E(long j, long j2, TimeUnit timeUnit) {
        return F(j, j2, timeUnit, Schedulers2.a());
    }

    public static Observable<Long> F(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return h0(new OnSubscribeTimerPeriodically2(j, j2, timeUnit, scheduler));
    }

    public static <T> Observable<T> H(Observable<? extends Observable<? extends T>> observable) {
        if (observable.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) observable).k0(UtilityFunctions.a.INSTANCE);
        }
        return h0(new OnSubscribeLift(observable.j, OperatorMerge.b.a));
    }

    public static <T> Observable<T> I(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return H(C(new Observable[]{observable, observable2}));
    }

    public static <T, R> Observable<R> b(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN) {
        return h0(new OnSubscribeCombineLatest(list, funcN));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> c(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), new j0.k.c(func9));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> d(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), new j(func8));
    }

    public static Observable<Long> d0(long j, TimeUnit timeUnit) {
        return e0(j, timeUnit, Schedulers2.a());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> e(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), new i(func7));
    }

    public static Observable<Long> e0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return h0(new OnSubscribeTimerOnce2(j, timeUnit, scheduler));
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> f(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), new h(func6));
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> g(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return b(Arrays.asList(observable, observable2, observable3, observable4, observable5), new g(func5));
    }

    public static <T1, T2, T3, T4, R> Observable<R> h(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return b(Arrays.asList(observable, observable2, observable3, observable4), new f(func4));
    }

    public static <T> Observable<T> h0(a<T> aVar) {
        return new Observable<>(l.a(aVar));
    }

    public static <T1, T2, T3, R> Observable<R> i(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return b(Arrays.asList(observable, observable2, observable3), new e(func3));
    }

    public static <T1, T2, R> Observable<R> j(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return b(Arrays.asList(observable, observable2), new d(func2));
    }

    public static <T1, T2, R> Observable<R> j0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return h0(new OnSubscribeLift(new ScalarSynchronousObservable(new Observable[]{observable, observable2}).j, new OperatorZip(func2)));
    }

    public static <T> Observable<T> l(Iterable<? extends Observable<? extends T>> iterable) {
        return h0(new OnSubscribeFromIterable(iterable)).n(UtilityFunctions.a.INSTANCE);
    }

    public static <T> Observable<T> m(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return C(new Object[]{observable, observable2}).n(UtilityFunctions.a.INSTANCE);
    }

    public static <T> Observable<T> o(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        return h0(new OnSubscribeCreate(action1, backpressureMode));
    }

    public static <T> Observable<T> x(Throwable th) {
        return h0(new OnSubscribeThrow(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> A(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) this).k0(func1) : H(G(func1));
    }

    public final <R> Observable<R> G(Func1<? super T, ? extends R> func1) {
        return h0(new OnSubscribeMap(this, func1));
    }

    public final Observable<T> J(Scheduler scheduler) {
        int i = RxRingBuffer.j;
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).l0(scheduler);
        }
        return h0(new OnSubscribeLift(this.j, new OperatorObserveOn2(scheduler, false, i)));
    }

    public final Observable<T> K() {
        return h0(new OnSubscribeLift(this.j, OperatorOnBackpressureBuffer.b.a));
    }

    public final Observable<T> L() {
        return h0(new OnSubscribeLift(this.j, OperatorOnBackpressureLatest.a.a));
    }

    public final Observable<T> M(Func1<? super Throwable, ? extends T> func1) {
        return h0(new OnSubscribeLift(this.j, new OperatorOnErrorResumeNextViaFunction4(new OperatorOnErrorResumeNextViaFunction(func1))));
    }

    public final ConnectableObservable<T> N(int i) {
        if (i == Integer.MAX_VALUE) {
            Func0 func0 = OperatorReplay.k;
            AtomicReference atomicReference = new AtomicReference();
            return new OperatorReplay(new OperatorReplay3(atomicReference, func0), this, atomicReference, func0);
        }
        OperatorReplay2 operatorReplay2 = new OperatorReplay2(i);
        AtomicReference atomicReference2 = new AtomicReference();
        return new OperatorReplay(new OperatorReplay3(atomicReference2, operatorReplay2), this, atomicReference2, operatorReplay2);
    }

    public final Observable<T> O(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        InternalObservableUtils.d dVar = new InternalObservableUtils.d(func1);
        AtomicReference<Schedulers2> atomicReference = Schedulers2.a;
        return h0(new OnSubscribeRedo6(this, dVar, true, false, TrampolineScheduler.a));
    }

    public final Observable<T> P(long j, TimeUnit timeUnit) {
        return h0(new OnSubscribeLift(this.j, new OperatorSampleWithTime(j, timeUnit, Schedulers2.a())));
    }

    public final <R> Observable<R> Q(R r, Func2<R, ? super T, R> func2) {
        return h0(new OnSubscribeLift(this.j, new OperatorScan(r, func2)));
    }

    public final Observable<T> R() {
        return h0(new OnSubscribeLift(this.j, OperatorSingle.a.a));
    }

    public final Observable<T> S(int i) {
        return h0(new OnSubscribeLift(this.j, new OperatorSkip2(i)));
    }

    public final Observable<T> T(T t) {
        return m(new ScalarSynchronousObservable(t), this);
    }

    public final Subscription U(Subscriber<? super T> subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (this.j == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        subscriber.onStart();
        if (!(subscriber instanceof SafeSubscriber)) {
            subscriber = new SafeSubscriber(subscriber);
        }
        try {
            a aVarCall = this.j;
            Func2<Observable, a, a> func2 = l.e;
            if (func2 != null) {
                aVarCall = func2.call(this, aVarCall);
            }
            aVarCall.call(subscriber);
            Func1<Subscription, Subscription> func1 = l.g;
            return func1 != null ? func1.call(subscriber) : subscriber;
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            if (subscriber.isUnsubscribed()) {
                l.b(l.c(th));
            } else {
                try {
                    subscriber.onError(l.c(th));
                } catch (Throwable th2) {
                    b.i.a.f.e.o.f.o1(th2);
                    StringBuilder sbU = outline.U("Error occurred attempting to subscribe [");
                    sbU.append(th.getMessage());
                    sbU.append("] and then again while trying to pass to onError.");
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException(sbU.toString(), th2);
                    l.c(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
            return Subscriptions.a;
        }
    }

    public final Subscription V(Action1<? super T> action1) {
        return U(new ActionSubscriber(action1, InternalObservableUtils.l, Actions2.a));
    }

    public final Subscription W(Action1<? super T> action1, Action1<Throwable> action2) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (action2 != null) {
            return U(new ActionSubscriber(action1, action2, Actions2.a));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final Observable<T> X(Scheduler scheduler) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).l0(scheduler) : h0(new OperatorSubscribeOn(this, scheduler, !(this.j instanceof OnSubscribeCreate)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> Y(Func1<? super T, ? extends Observable<? extends R>> func1) {
        Observable<R> observableG = G(func1);
        return h0(new OnSubscribeLift(observableG.j, OperatorSwitch2.a.a));
    }

    public final Observable<T> Z(int i) {
        return h0(new OnSubscribeLift(this.j, new OperatorTake2(i)));
    }

    public final Observable<List<T>> a(long j, TimeUnit timeUnit) {
        return h0(new OnSubscribeLift(this.j, new OperatorBufferWithTime2(j, j, timeUnit, Integer.MAX_VALUE, Schedulers2.a())));
    }

    public final <E> Observable<T> a0(Observable<? extends E> observable) {
        return h0(new OnSubscribeLift(this.j, new OperatorTakeUntil3(observable)));
    }

    public final Observable<T> b0(Func1<? super T, Boolean> func1) {
        return h0(new OnSubscribeLift(this.j, new OperatorTakeUntilPredicate2(func1)));
    }

    public final Observable<T> c0(long j, TimeUnit timeUnit) {
        return h0(new OnSubscribeTimeoutTimedWithFallback(this, j, timeUnit, Schedulers2.a(), null));
    }

    public final Observable<List<T>> f0() {
        return h0(new OnSubscribeLift(this.j, OperatorToObservableList2.a.a));
    }

    public final <K, V> Observable<Map<K, V>> g0(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func2) {
        return h0(new OnSubscribeToMap(this, func1, func2));
    }

    public final Subscription i0(Subscriber<? super T> subscriber) {
        try {
            subscriber.onStart();
            a aVarCall = this.j;
            Func2<Observable, a, a> func2 = l.e;
            if (func2 != null) {
                aVarCall = func2.call(this, aVarCall);
            }
            aVarCall.call(subscriber);
            Func1<Subscription, Subscription> func1 = l.g;
            return func1 != null ? func1.call(subscriber) : subscriber;
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            try {
                subscriber.onError(l.c(th));
                return Subscriptions.a;
            } catch (Throwable th2) {
                b.i.a.f.e.o.f.o1(th2);
                StringBuilder sbU = outline.U("Error occurred attempting to subscribe [");
                sbU.append(th.getMessage());
                sbU.append("] and then again while trying to pass to onError.");
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException(sbU.toString(), th2);
                l.c(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public <R> Observable<R> k(c<? super T, ? extends R> cVar) {
        return (Observable) cVar.call(this);
    }

    public final <R> Observable<R> n(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).k0(func1) : h0(new OnSubscribeConcatMap2(this, func1, 2, 0));
    }

    public final Observable<T> p(long j, TimeUnit timeUnit) {
        return h0(new OnSubscribeLift(this.j, new OperatorDebounceWithTime2(j, timeUnit, Schedulers2.a())));
    }

    public final Observable<T> q(long j, TimeUnit timeUnit) {
        return h0(new OnSubscribeLift(this.j, new OperatorDelay2(j, timeUnit, Schedulers2.a())));
    }

    public final Observable<T> r() {
        return h0(new OnSubscribeLift(this.j, OperatorDistinctUntilChanged2.a.a));
    }

    public final Observable<T> s(Func2<? super T, ? super T, Boolean> func2) {
        return h0(new OnSubscribeLift(this.j, new OperatorDistinctUntilChanged2(func2)));
    }

    public final Observable<T> t(Action1<? super Throwable> action1) {
        Actions2.a aVar = Actions2.a;
        return h0(new OnSubscribeDoOnEach(this, new ActionObserver(aVar, action1, aVar)));
    }

    public final Observable<T> u(Action1<? super T> action1) {
        Actions2.a aVar = Actions2.a;
        return h0(new OnSubscribeDoOnEach(this, new ActionObserver(action1, aVar, aVar)));
    }

    public final Observable<T> v(Action0 action0) {
        return h0(new OnSubscribeLift(this.j, new OperatorDoOnSubscribe(action0)));
    }

    public final Observable<T> w(Action0 action0) {
        return h0(new OnSubscribeLift(this.j, new OperatorDoOnUnsubscribe(action0)));
    }

    public final Observable<T> y(Func1<? super T, Boolean> func1) {
        return h0(new OnSubscribeFilter(this, func1));
    }

    public final Observable<T> z() {
        return Z(1).R();
    }
}
