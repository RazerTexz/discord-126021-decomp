package com.discord.utilities.rx;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function22;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;

/* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt, reason: use source file name */
/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloads2 {
    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, final Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(function10, "combineFunction");
        Observable<R> observableJ = Observable.j(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, new Func2<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.1
            @Override // rx.functions.Func2
            public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10) {
                return (R) function10.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…t10\n          )\n        }");
        return observableJ;
    }

    private static final <T1, T2, T3, T4, T5, T6, T7, T8, T9> Observable<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>> createHolderObservable(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9) {
        Observable<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>> observableC = Observable.c(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, new Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.createHolderObservable.1
            @Override // rx.functions.Func9
            public final ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
                return new ObservableCombineLatestOverloads<>(t1, t2, t3, t4, t5, t6, t7, t8, t9);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableC, "Observable\n    .combineL…t5, t6, t7, t8, t9)\n    }");
        return observableC;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, final Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(function11, "combineFunction");
        Observable<R> observableI = Observable.i(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, new Func3<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.2
            @Override // rx.functions.Func3
            public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11) {
                return (R) function11.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n        .comb…t11\n          )\n        }");
        return observableI;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, final Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(function12, "combineFunction");
        Observable<R> observableH = Observable.h(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, new Func4<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.3
            @Override // rx.functions.Func4
            public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12) {
                return (R) function12.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableH, "Observable\n        .comb…t12\n          )\n        }");
        return observableH;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, final Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(function13, "combineFunction");
        Observable<R> observableG = Observable.g(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, new Func5<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.4
            @Override // rx.functions.Func5
            public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13) {
                return (R) function13.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "Observable\n        .comb…t13\n          )\n        }");
        return observableG;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, final Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(function14, "combineFunction");
        Observable<R> observableF = Observable.f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, new Func6<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.5
            @Override // rx.functions.Func6
            public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14) {
                return (R) function14.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n        .comb…t14\n          )\n        }");
        return observableF;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, final Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(function15, "combineFunction");
        Observable<R> observableE = Observable.e(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, new Func7<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.6
            @Override // rx.functions.Func7
            public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15) {
                return (R) function15.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14, t15);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n        .comb…t15\n          )\n        }");
        return observableE;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, final Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(observable16, "o16");
        Intrinsics3.checkNotNullParameter(function16, "combineFunction");
        Observable<R> observableD = Observable.d(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, new Func8<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.7
            @Override // rx.functions.Func8
            public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16) {
                return (R) function16.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14, t15, t16);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableD, "Observable\n        .comb…t16\n          )\n        }");
        return observableD;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, final Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(observable16, "o16");
        Intrinsics3.checkNotNullParameter(observable17, "o17");
        Intrinsics3.checkNotNullParameter(function17, "combineFunction");
        Observable<R> observableC = Observable.c(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, new Func9<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, T17, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.8
            @Override // rx.functions.Func9
            public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16, T17 t17) {
                return (R) function17.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14, t15, t16, t17);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableC, "Observable\n        .comb…t17\n          )\n        }");
        return observableC;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Observable<T18> observable18, Observable<T19> observable19, Observable<T20> observable20, Observable<T21> observable21, Observable<T22> observable22, final Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(observable16, "o16");
        Intrinsics3.checkNotNullParameter(observable17, "o17");
        Intrinsics3.checkNotNullParameter(observable18, "o18");
        Intrinsics3.checkNotNullParameter(observable19, "o19");
        Intrinsics3.checkNotNullParameter(observable20, "o20");
        Intrinsics3.checkNotNullParameter(observable21, "o21");
        Intrinsics3.checkNotNullParameter(observable22, "o22");
        Intrinsics3.checkNotNullParameter(function22, "combineFunction");
        Observable<R> observableF = Observable.f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), createHolderObservable(observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, observable18), observable19, observable20, observable21, observable22, new Func6<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, ObservableCombineLatestOverloads<T10, T11, T12, T13, T14, T15, T16, T17, T18>, T19, T20, T21, T22, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.9
            @Override // rx.functions.Func6
            public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, ObservableCombineLatestOverloads<T10, T11, T12, T13, T14, T15, T16, T17, T18> observableCombineLatestOverloads2, T19 t19, T20 t20, T21 t21, T22 t22) {
                return (R) function22.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), observableCombineLatestOverloads2.getT1(), observableCombineLatestOverloads2.getT2(), observableCombineLatestOverloads2.getT3(), observableCombineLatestOverloads2.getT4(), observableCombineLatestOverloads2.getT5(), observableCombineLatestOverloads2.getT6(), observableCombineLatestOverloads2.getT7(), observableCombineLatestOverloads2.getT8(), observableCombineLatestOverloads2.getT9(), t19, t20, t21, t22);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n        .comb…22,\n          )\n        }");
        return observableF;
    }
}
