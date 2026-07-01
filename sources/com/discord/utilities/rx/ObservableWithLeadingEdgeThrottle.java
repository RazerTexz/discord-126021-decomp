package com.discord.utilities.rx;

import j0.k.Func1;
import j0.k.c;
import j0.k.d;
import j0.k.e;
import j0.k.f;
import j0.k.g;
import j0.k.h;
import j0.k.i;
import j0.k.j;
import j0.l.a.OnSubscribeLift;
import j0.p.Schedulers2;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.FuncN;

/* JADX INFO: loaded from: classes2.dex */
public class ObservableWithLeadingEdgeThrottle {
    private static final FuncN IDENTITY_FUNC_N = new FuncN() { // from class: com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle.1
        @Override // rx.functions.FuncN
        public Object call(Object... objArr) {
            return objArr;
        }
    };

    public static <T1, T2, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2), new d(func2), j, timeUnit);
    }

    public static <T1, T2, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2), new d(func2), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3), new e(func3), j, timeUnit);
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3), new e(func3), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4), new f(func4), j, timeUnit);
    }

    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4), new f(func4), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5), new g(func5), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5), new g(func5), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), new h(func6), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), new h(func6), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), new i(func7), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), new i(func7), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), new j(func8), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), new j(func8), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), new c(func9), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), new c(func9), j, timeUnit, scheduler);
    }

    private static <T, R> Observable<R> combineLatest(List<? extends Observable<? extends T>> list, final FuncN<? extends R> funcN, long j, TimeUnit timeUnit, Scheduler scheduler) {
        Observable observableB = Observable.b(list, IDENTITY_FUNC_N);
        return Observable.h0(new OnSubscribeLift(observableB.j, new LeadingEdgeThrottle(j, timeUnit, scheduler))).G(new Func1() { // from class: com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle.2
            @Override // j0.k.Func1
            public Object call(Object obj) {
                return funcN.call((Object[]) obj);
            }
        });
    }

    private static <T, R> Observable<R> combineLatest(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN, long j, TimeUnit timeUnit) {
        return combineLatest(list, funcN, j, timeUnit, Schedulers2.a());
    }
}
