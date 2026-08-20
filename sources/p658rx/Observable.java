package p658rx;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.C12588a;
import p637j0.p641k.C12590c;
import p637j0.p641k.C12591d;
import p637j0.p641k.C12592e;
import p637j0.p641k.C12593f;
import p637j0.p641k.C12594g;
import p637j0.p641k.C12595h;
import p637j0.p641k.C12596i;
import p637j0.p641k.C12597j;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12600a1;
import p637j0.p642l.p643a.C12604b1;
import p637j0.p642l.p643a.C12608c1;
import p637j0.p642l.p643a.C12609c2;
import p637j0.p642l.p643a.C12618f;
import p637j0.p642l.p643a.C12619f0;
import p637j0.p642l.p643a.C12620f1;
import p637j0.p642l.p643a.C12621f2;
import p637j0.p642l.p643a.C12623g0;
import p637j0.p642l.p643a.C12626h;
import p637j0.p642l.p643a.C12629h2;
import p637j0.p642l.p643a.C12630i;
import p637j0.p642l.p643a.C12631i0;
import p637j0.p642l.p643a.C12636j1;
import p637j0.p642l.p643a.C12638k;
import p637j0.p642l.p643a.C12639k0;
import p637j0.p642l.p643a.C12640k1;
import p637j0.p642l.p643a.C12642l;
import p637j0.p642l.p643a.C12643l0;
import p637j0.p642l.p643a.C12644l1;
import p637j0.p642l.p643a.C12651n0;
import p637j0.p642l.p643a.C12652n1;
import p637j0.p642l.p643a.C12653n2;
import p637j0.p642l.p643a.C12654o;
import p637j0.p642l.p643a.C12656o1;
import p637j0.p642l.p643a.C12658p;
import p637j0.p642l.p643a.C12662q;
import p637j0.p642l.p643a.C12663q0;
import p637j0.p642l.p643a.C12665q2;
import p637j0.p642l.p643a.C12666r;
import p637j0.p642l.p643a.C12668r1;
import p637j0.p642l.p643a.C12669s;
import p637j0.p642l.p643a.C12670s0;
import p637j0.p642l.p643a.C12674t1;
import p637j0.p642l.p643a.C12676u0;
import p637j0.p642l.p643a.C12679v0;
import p637j0.p642l.p643a.C12682w0;
import p637j0.p642l.p643a.C12685x0;
import p637j0.p642l.p643a.C12686x1;
import p637j0.p642l.p643a.C12687y;
import p637j0.p642l.p643a.C12689y1;
import p637j0.p642l.p643a.C12691z0;
import p637j0.p642l.p643a.EnumC12606c;
import p637j0.p642l.p645c.C12708m;
import p637j0.p642l.p647e.C12711a;
import p637j0.p642l.p647e.C12712b;
import p637j0.p642l.p647e.C12719i;
import p637j0.p642l.p647e.C12721k;
import p637j0.p642l.p647e.C12723m;
import p637j0.p642l.p647e.EnumC12715e;
import p637j0.p650m.AbstractC12757b;
import p637j0.p651n.C12759b;
import p637j0.p652o.C12774l;
import p637j0.p653p.C12781a;
import p637j0.p655r.C12787c;
import p658rx.exceptions.OnErrorFailedException;
import p658rx.functions.Action0;
import p658rx.functions.Action1;
import p658rx.functions.Func0;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.functions.Func4;
import p658rx.functions.Func5;
import p658rx.functions.Func6;
import p658rx.functions.Func7;
import p658rx.functions.Func8;
import p658rx.functions.Func9;
import p658rx.functions.FuncN;

/* JADX INFO: loaded from: classes3.dex */
public class Observable<T> {

    /* JADX INFO: renamed from: j */
    public final InterfaceC13005a<T> f27640j;

    /* JADX INFO: renamed from: rx.Observable$a */
    public interface InterfaceC13005a<T> extends Action1<Subscriber<? super T>> {
    }

    /* JADX INFO: renamed from: rx.Observable$b */
    public interface InterfaceC13006b<R, T> extends InterfaceC12589b<Subscriber<? super R>, Subscriber<? super T>> {
    }

    /* JADX INFO: renamed from: rx.Observable$c */
    public interface InterfaceC13007c<T, R> extends InterfaceC12589b<Observable<T>, Observable<R>> {
    }

    public Observable(InterfaceC13005a<T> interfaceC13005a) {
        this.f27640j = interfaceC13005a;
    }

    /* JADX INFO: renamed from: B */
    public static <T> Observable<T> m11058B(Iterable<? extends T> iterable) {
        return m11074h0(new C12662q(iterable));
    }

    /* JADX INFO: renamed from: C */
    public static <T> Observable<T> m11059C(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return (Observable<T>) EnumC12606c.f26751k;
        }
        return length == 1 ? new C12721k(tArr[0]) : m11074h0(new C12654o(tArr));
    }

    /* JADX INFO: renamed from: D */
    public static <T> Observable<T> m11060D(Callable<? extends T> callable) {
        return m11074h0(new C12658p(callable));
    }

    /* JADX INFO: renamed from: E */
    public static Observable<Long> m11061E(long j, long j2, TimeUnit timeUnit) {
        return m11062F(j, j2, timeUnit, C12781a.m10873a());
    }

    /* JADX INFO: renamed from: F */
    public static Observable<Long> m11062F(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return m11074h0(new C12639k0(j, j2, timeUnit, scheduler));
    }

    /* JADX INFO: renamed from: H */
    public static <T> Observable<T> m11063H(Observable<? extends Observable<? extends T>> observable) {
        if (observable.getClass() == C12721k.class) {
            return ((C12721k) observable).m10820k0(C12723m.a.INSTANCE);
        }
        return m11074h0(new C12666r(observable.f27640j, C12685x0.b.f27083a));
    }

    /* JADX INFO: renamed from: I */
    public static <T> Observable<T> m11064I(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m11063H(m11059C(new Observable[]{observable, observable2}));
    }

    /* JADX INFO: renamed from: b */
    public static <T, R> Observable<R> m11065b(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN) {
        return m11074h0(new C12618f(list, funcN));
    }

    /* JADX INFO: renamed from: c */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> m11066c(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), new C12590c(func9));
    }

    /* JADX INFO: renamed from: d */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> m11067d(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), new C12597j(func8));
    }

    /* JADX INFO: renamed from: d0 */
    public static Observable<Long> m11068d0(long j, TimeUnit timeUnit) {
        return m11070e0(j, timeUnit, C12781a.m10873a());
    }

    /* JADX INFO: renamed from: e */
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> m11069e(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), new C12596i(func7));
    }

    /* JADX INFO: renamed from: e0 */
    public static Observable<Long> m11070e0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m11074h0(new C12631i0(j, timeUnit, scheduler));
    }

    /* JADX INFO: renamed from: f */
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> m11071f(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), new C12595h(func6));
    }

    /* JADX INFO: renamed from: g */
    public static <T1, T2, T3, T4, T5, R> Observable<R> m11072g(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5), new C12594g(func5));
    }

    /* JADX INFO: renamed from: h */
    public static <T1, T2, T3, T4, R> Observable<R> m11073h(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4), new C12593f(func4));
    }

    /* JADX INFO: renamed from: h0 */
    public static <T> Observable<T> m11074h0(InterfaceC13005a<T> interfaceC13005a) {
        return new Observable<>(C12774l.m10862a(interfaceC13005a));
    }

    /* JADX INFO: renamed from: i */
    public static <T1, T2, T3, R> Observable<R> m11075i(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return m11065b(Arrays.asList(observable, observable2, observable3), new C12592e(func3));
    }

    /* JADX INFO: renamed from: j */
    public static <T1, T2, R> Observable<R> m11076j(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return m11065b(Arrays.asList(observable, observable2), new C12591d(func2));
    }

    /* JADX INFO: renamed from: j0 */
    public static <T1, T2, R> Observable<R> m11077j0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return m11074h0(new C12666r(new C12721k(new Observable[]{observable, observable2}).f27640j, new C12665q2(func2)));
    }

    /* JADX INFO: renamed from: l */
    public static <T> Observable<T> m11078l(Iterable<? extends Observable<? extends T>> iterable) {
        return m11074h0(new C12662q(iterable)).m11109n(C12723m.a.INSTANCE);
    }

    /* JADX INFO: renamed from: m */
    public static <T> Observable<T> m11079m(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m11059C(new Object[]{observable, observable2}).m11109n(C12723m.a.INSTANCE);
    }

    /* JADX INFO: renamed from: o */
    public static <T> Observable<T> m11080o(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        return m11074h0(new C12630i(action1, backpressureMode));
    }

    /* JADX INFO: renamed from: x */
    public static <T> Observable<T> m11081x(Throwable th) {
        return m11074h0(new C12619f0(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: A */
    public final <R> Observable<R> m11082A(InterfaceC12589b<? super T, ? extends Observable<? extends R>> interfaceC12589b) {
        return getClass() == C12721k.class ? ((C12721k) this).m10820k0(interfaceC12589b) : m11063H(m11083G(interfaceC12589b));
    }

    /* JADX INFO: renamed from: G */
    public final <R> Observable<R> m11083G(InterfaceC12589b<? super T, ? extends R> interfaceC12589b) {
        return m11074h0(new C12669s(this, interfaceC12589b));
    }

    /* JADX INFO: renamed from: J */
    public final Observable<T> m11084J(Scheduler scheduler) {
        int i = C12719i.f27283j;
        if (this instanceof C12721k) {
            return ((C12721k) this).m10821l0(scheduler);
        }
        return m11074h0(new C12666r(this.f27640j, new C12691z0(scheduler, false, i)));
    }

    /* JADX INFO: renamed from: K */
    public final Observable<T> m11085K() {
        return m11074h0(new C12666r(this.f27640j, C12600a1.b.f26735a));
    }

    /* JADX INFO: renamed from: L */
    public final Observable<T> m11086L() {
        return m11074h0(new C12666r(this.f27640j, C12604b1.a.f26740a));
    }

    /* JADX INFO: renamed from: M */
    public final Observable<T> m11087M(InterfaceC12589b<? super Throwable, ? extends T> interfaceC12589b) {
        return m11074h0(new C12666r(this.f27640j, new C12620f1(new C12608c1(interfaceC12589b))));
    }

    /* JADX INFO: renamed from: N */
    public final AbstractC12757b<T> m11088N(int i) {
        if (i == Integer.MAX_VALUE) {
            Func0 func0 = C12636j1.f26857k;
            AtomicReference atomicReference = new AtomicReference();
            return new C12636j1(new C12644l1(atomicReference, func0), this, atomicReference, func0);
        }
        C12640k1 c12640k1 = new C12640k1(i);
        AtomicReference atomicReference2 = new AtomicReference();
        return new C12636j1(new C12644l1(atomicReference2, c12640k1), this, atomicReference2, c12640k1);
    }

    /* JADX INFO: renamed from: O */
    public final Observable<T> m11089O(InterfaceC12589b<? super Observable<? extends Throwable>, ? extends Observable<?>> interfaceC12589b) {
        EnumC12715e.d dVar = new EnumC12715e.d(interfaceC12589b);
        AtomicReference<C12781a> atomicReference = C12781a.f27393a;
        return m11074h0(new C12687y(this, dVar, true, false, C12708m.f27250a));
    }

    /* JADX INFO: renamed from: P */
    public final Observable<T> m11090P(long j, TimeUnit timeUnit) {
        return m11074h0(new C12666r(this.f27640j, new C12652n1(j, timeUnit, C12781a.m10873a())));
    }

    /* JADX INFO: renamed from: Q */
    public final <R> Observable<R> m11091Q(R r, Func2<R, ? super T, R> func2) {
        return m11074h0(new C12666r(this.f27640j, new C12656o1(r, func2)));
    }

    /* JADX INFO: renamed from: R */
    public final Observable<T> m11092R() {
        return m11074h0(new C12666r(this.f27640j, C12668r1.a.f27024a));
    }

    /* JADX INFO: renamed from: S */
    public final Observable<T> m11093S(int i) {
        return m11074h0(new C12666r(this.f27640j, new C12674t1(i)));
    }

    /* JADX INFO: renamed from: T */
    public final Observable<T> m11094T(T t) {
        return m11079m(new C12721k(t), this);
    }

    /* JADX INFO: renamed from: U */
    public final Subscription m11095U(Subscriber<? super T> subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (this.f27640j == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        subscriber.onStart();
        if (!(subscriber instanceof C12759b)) {
            subscriber = new C12759b(subscriber);
        }
        try {
            InterfaceC13005a interfaceC13005aCall = this.f27640j;
            Func2<Observable, InterfaceC13005a, InterfaceC13005a> func2 = C12774l.f27378e;
            if (func2 != null) {
                interfaceC13005aCall = func2.call(this, interfaceC13005aCall);
            }
            interfaceC13005aCall.call(subscriber);
            InterfaceC12589b<Subscription, Subscription> interfaceC12589b = C12774l.f27380g;
            return interfaceC12589b != null ? interfaceC12589b.call(subscriber) : subscriber;
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            if (subscriber.isUnsubscribed()) {
                C12774l.m10863b(C12774l.m10864c(th));
            } else {
                try {
                    subscriber.onError(C12774l.m10864c(th));
                } catch (Throwable th2) {
                    C3404f.m4325o1(th2);
                    StringBuilder sbM833U = C1643a.m833U("Error occurred attempting to subscribe [");
                    sbM833U.append(th.getMessage());
                    sbM833U.append("] and then again while trying to pass to onError.");
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException(sbM833U.toString(), th2);
                    C12774l.m10864c(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
            return C12787c.f27422a;
        }
    }

    /* JADX INFO: renamed from: V */
    public final Subscription m11096V(Action1<? super T> action1) {
        return m11095U(new C12712b(action1, EnumC12715e.f27272l, C12588a.f26710a));
    }

    /* JADX INFO: renamed from: W */
    public final Subscription m11097W(Action1<? super T> action1, Action1<Throwable> action2) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (action2 != null) {
            return m11095U(new C12712b(action1, action2, C12588a.f26710a));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    /* JADX INFO: renamed from: X */
    public final Observable<T> m11098X(Scheduler scheduler) {
        return this instanceof C12721k ? ((C12721k) this).m10821l0(scheduler) : m11074h0(new C12686x1(this, scheduler, !(this.f27640j instanceof C12630i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: Y */
    public final <R> Observable<R> m11099Y(InterfaceC12589b<? super T, ? extends Observable<? extends R>> interfaceC12589b) {
        Observable<R> observableM11083G = m11083G(interfaceC12589b);
        return m11074h0(new C12666r(observableM11083G.f27640j, C12689y1.a.f27126a));
    }

    /* JADX INFO: renamed from: Z */
    public final Observable<T> m11100Z(int i) {
        return m11074h0(new C12666r(this.f27640j, new C12609c2(i)));
    }

    /* JADX INFO: renamed from: a */
    public final Observable<List<T>> m11101a(long j, TimeUnit timeUnit) {
        return m11074h0(new C12666r(this.f27640j, new C12651n0(j, j, timeUnit, Integer.MAX_VALUE, C12781a.m10873a())));
    }

    /* JADX INFO: renamed from: a0 */
    public final <E> Observable<T> m11102a0(Observable<? extends E> observable) {
        return m11074h0(new C12666r(this.f27640j, new C12621f2(observable)));
    }

    /* JADX INFO: renamed from: b0 */
    public final Observable<T> m11103b0(InterfaceC12589b<? super T, Boolean> interfaceC12589b) {
        return m11074h0(new C12666r(this.f27640j, new C12629h2(interfaceC12589b)));
    }

    /* JADX INFO: renamed from: c0 */
    public final Observable<T> m11104c0(long j, TimeUnit timeUnit) {
        return m11074h0(new C12623g0(this, j, timeUnit, C12781a.m10873a(), null));
    }

    /* JADX INFO: renamed from: f0 */
    public final Observable<List<T>> m11105f0() {
        return m11074h0(new C12666r(this.f27640j, C12653n2.a.f26954a));
    }

    /* JADX INFO: renamed from: g0 */
    public final <K, V> Observable<Map<K, V>> m11106g0(InterfaceC12589b<? super T, ? extends K> interfaceC12589b, InterfaceC12589b<? super T, ? extends V> interfaceC12589b2) {
        return m11074h0(new C12643l0(this, interfaceC12589b, interfaceC12589b2));
    }

    /* JADX INFO: renamed from: i0 */
    public final Subscription m11107i0(Subscriber<? super T> subscriber) {
        try {
            subscriber.onStart();
            InterfaceC13005a interfaceC13005aCall = this.f27640j;
            Func2<Observable, InterfaceC13005a, InterfaceC13005a> func2 = C12774l.f27378e;
            if (func2 != null) {
                interfaceC13005aCall = func2.call(this, interfaceC13005aCall);
            }
            interfaceC13005aCall.call(subscriber);
            InterfaceC12589b<Subscription, Subscription> interfaceC12589b = C12774l.f27380g;
            return interfaceC12589b != null ? interfaceC12589b.call(subscriber) : subscriber;
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            try {
                subscriber.onError(C12774l.m10864c(th));
                return C12787c.f27422a;
            } catch (Throwable th2) {
                C3404f.m4325o1(th2);
                StringBuilder sbM833U = C1643a.m833U("Error occurred attempting to subscribe [");
                sbM833U.append(th.getMessage());
                sbM833U.append("] and then again while trying to pass to onError.");
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException(sbM833U.toString(), th2);
                C12774l.m10864c(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public <R> Observable<R> m11108k(InterfaceC13007c<? super T, ? extends R> interfaceC13007c) {
        return (Observable) interfaceC13007c.call(this);
    }

    /* JADX INFO: renamed from: n */
    public final <R> Observable<R> m11109n(InterfaceC12589b<? super T, ? extends Observable<? extends R>> interfaceC12589b) {
        return this instanceof C12721k ? ((C12721k) this).m10820k0(interfaceC12589b) : m11074h0(new C12626h(this, interfaceC12589b, 2, 0));
    }

    /* JADX INFO: renamed from: p */
    public final Observable<T> m11110p(long j, TimeUnit timeUnit) {
        return m11074h0(new C12666r(this.f27640j, new C12663q0(j, timeUnit, C12781a.m10873a())));
    }

    /* JADX INFO: renamed from: q */
    public final Observable<T> m11111q(long j, TimeUnit timeUnit) {
        return m11074h0(new C12666r(this.f27640j, new C12670s0(j, timeUnit, C12781a.m10873a())));
    }

    /* JADX INFO: renamed from: r */
    public final Observable<T> m11112r() {
        return m11074h0(new C12666r(this.f27640j, C12676u0.a.f27059a));
    }

    /* JADX INFO: renamed from: s */
    public final Observable<T> m11113s(Func2<? super T, ? super T, Boolean> func2) {
        return m11074h0(new C12666r(this.f27640j, new C12676u0(func2)));
    }

    /* JADX INFO: renamed from: t */
    public final Observable<T> m11114t(Action1<? super Throwable> action1) {
        C12588a.a aVar = C12588a.f26710a;
        return m11074h0(new C12638k(this, new C12711a(aVar, action1, aVar)));
    }

    /* JADX INFO: renamed from: u */
    public final Observable<T> m11115u(Action1<? super T> action1) {
        C12588a.a aVar = C12588a.f26710a;
        return m11074h0(new C12638k(this, new C12711a(action1, aVar, aVar)));
    }

    /* JADX INFO: renamed from: v */
    public final Observable<T> m11116v(Action0 action0) {
        return m11074h0(new C12666r(this.f27640j, new C12679v0(action0)));
    }

    /* JADX INFO: renamed from: w */
    public final Observable<T> m11117w(Action0 action0) {
        return m11074h0(new C12666r(this.f27640j, new C12682w0(action0)));
    }

    /* JADX INFO: renamed from: y */
    public final Observable<T> m11118y(InterfaceC12589b<? super T, Boolean> interfaceC12589b) {
        return m11074h0(new C12642l(this, interfaceC12589b));
    }

    /* JADX INFO: renamed from: z */
    public final Observable<T> m11119z() {
        return m11100Z(1).m11092R();
    }
}
