package com.discord.utilities.p501rx;

import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function22;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.functions.Func4;
import p658rx.functions.Func5;
import p658rx.functions.Func6;
import p658rx.functions.Func7;
import p658rx.functions.Func8;
import p658rx.functions.Func9;

/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt {
    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, final Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
        C12238m.checkNotNullParameter(observable, "o1");
        C12238m.checkNotNullParameter(observable2, "o2");
        C12238m.checkNotNullParameter(observable3, "o3");
        C12238m.checkNotNullParameter(observable4, "o4");
        C12238m.checkNotNullParameter(observable5, "o5");
        C12238m.checkNotNullParameter(observable6, "o6");
        C12238m.checkNotNullParameter(observable7, "o7");
        C12238m.checkNotNullParameter(observable8, "o8");
        C12238m.checkNotNullParameter(observable9, "o9");
        C12238m.checkNotNullParameter(observable10, "o10");
        C12238m.checkNotNullParameter(function10, "combineFunction");
        Observable<R> observableM11076j = Observable.m11076j(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, new Func2<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.1
            @Override // p658rx.functions.Func2
            public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10) {
                return (R) function10.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…t10\n          )\n        }");
        return observableM11076j;
    }

    private static final <T1, T2, T3, T4, T5, T6, T7, T8, T9> Observable<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>> createHolderObservable(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9) {
        Observable<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>> observableM11066c = Observable.m11066c(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, new Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.createHolderObservable.1
            @Override // p658rx.functions.Func9
            public final Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
                return new Holder<>(t1, t2, t3, t4, t5, t6, t7, t8, t9);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11066c, "Observable\n    .combineL…t5, t6, t7, t8, t9)\n    }");
        return observableM11066c;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, final Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11) {
        C12238m.checkNotNullParameter(observable, "o1");
        C12238m.checkNotNullParameter(observable2, "o2");
        C12238m.checkNotNullParameter(observable3, "o3");
        C12238m.checkNotNullParameter(observable4, "o4");
        C12238m.checkNotNullParameter(observable5, "o5");
        C12238m.checkNotNullParameter(observable6, "o6");
        C12238m.checkNotNullParameter(observable7, "o7");
        C12238m.checkNotNullParameter(observable8, "o8");
        C12238m.checkNotNullParameter(observable9, "o9");
        C12238m.checkNotNullParameter(observable10, "o10");
        C12238m.checkNotNullParameter(observable11, "o11");
        C12238m.checkNotNullParameter(function11, "combineFunction");
        Observable<R> observableM11075i = Observable.m11075i(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, new Func3<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.2
            @Override // p658rx.functions.Func3
            public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11) {
                return (R) function11.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11075i, "Observable\n        .comb…t11\n          )\n        }");
        return observableM11075i;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, final Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12) {
        C12238m.checkNotNullParameter(observable, "o1");
        C12238m.checkNotNullParameter(observable2, "o2");
        C12238m.checkNotNullParameter(observable3, "o3");
        C12238m.checkNotNullParameter(observable4, "o4");
        C12238m.checkNotNullParameter(observable5, "o5");
        C12238m.checkNotNullParameter(observable6, "o6");
        C12238m.checkNotNullParameter(observable7, "o7");
        C12238m.checkNotNullParameter(observable8, "o8");
        C12238m.checkNotNullParameter(observable9, "o9");
        C12238m.checkNotNullParameter(observable10, "o10");
        C12238m.checkNotNullParameter(observable11, "o11");
        C12238m.checkNotNullParameter(observable12, "o12");
        C12238m.checkNotNullParameter(function12, "combineFunction");
        Observable<R> observableM11073h = Observable.m11073h(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, new Func4<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.3
            @Override // p658rx.functions.Func4
            public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12) {
                return (R) function12.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11073h, "Observable\n        .comb…t12\n          )\n        }");
        return observableM11073h;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, final Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13) {
        C12238m.checkNotNullParameter(observable, "o1");
        C12238m.checkNotNullParameter(observable2, "o2");
        C12238m.checkNotNullParameter(observable3, "o3");
        C12238m.checkNotNullParameter(observable4, "o4");
        C12238m.checkNotNullParameter(observable5, "o5");
        C12238m.checkNotNullParameter(observable6, "o6");
        C12238m.checkNotNullParameter(observable7, "o7");
        C12238m.checkNotNullParameter(observable8, "o8");
        C12238m.checkNotNullParameter(observable9, "o9");
        C12238m.checkNotNullParameter(observable10, "o10");
        C12238m.checkNotNullParameter(observable11, "o11");
        C12238m.checkNotNullParameter(observable12, "o12");
        C12238m.checkNotNullParameter(observable13, "o13");
        C12238m.checkNotNullParameter(function13, "combineFunction");
        Observable<R> observableM11072g = Observable.m11072g(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, new Func5<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.4
            @Override // p658rx.functions.Func5
            public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13) {
                return (R) function13.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11072g, "Observable\n        .comb…t13\n          )\n        }");
        return observableM11072g;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, final Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14) {
        C12238m.checkNotNullParameter(observable, "o1");
        C12238m.checkNotNullParameter(observable2, "o2");
        C12238m.checkNotNullParameter(observable3, "o3");
        C12238m.checkNotNullParameter(observable4, "o4");
        C12238m.checkNotNullParameter(observable5, "o5");
        C12238m.checkNotNullParameter(observable6, "o6");
        C12238m.checkNotNullParameter(observable7, "o7");
        C12238m.checkNotNullParameter(observable8, "o8");
        C12238m.checkNotNullParameter(observable9, "o9");
        C12238m.checkNotNullParameter(observable10, "o10");
        C12238m.checkNotNullParameter(observable11, "o11");
        C12238m.checkNotNullParameter(observable12, "o12");
        C12238m.checkNotNullParameter(observable13, "o13");
        C12238m.checkNotNullParameter(observable14, "o14");
        C12238m.checkNotNullParameter(function14, "combineFunction");
        Observable<R> observableM11071f = Observable.m11071f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, new Func6<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.5
            @Override // p658rx.functions.Func6
            public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14) {
                return (R) function14.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11071f, "Observable\n        .comb…t14\n          )\n        }");
        return observableM11071f;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, final Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15) {
        C12238m.checkNotNullParameter(observable, "o1");
        C12238m.checkNotNullParameter(observable2, "o2");
        C12238m.checkNotNullParameter(observable3, "o3");
        C12238m.checkNotNullParameter(observable4, "o4");
        C12238m.checkNotNullParameter(observable5, "o5");
        C12238m.checkNotNullParameter(observable6, "o6");
        C12238m.checkNotNullParameter(observable7, "o7");
        C12238m.checkNotNullParameter(observable8, "o8");
        C12238m.checkNotNullParameter(observable9, "o9");
        C12238m.checkNotNullParameter(observable10, "o10");
        C12238m.checkNotNullParameter(observable11, "o11");
        C12238m.checkNotNullParameter(observable12, "o12");
        C12238m.checkNotNullParameter(observable13, "o13");
        C12238m.checkNotNullParameter(observable14, "o14");
        C12238m.checkNotNullParameter(observable15, "o15");
        C12238m.checkNotNullParameter(function15, "combineFunction");
        Observable<R> observableM11069e = Observable.m11069e(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, new Func7<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.6
            @Override // p658rx.functions.Func7
            public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15) {
                return (R) function15.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14, t15);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11069e, "Observable\n        .comb…t15\n          )\n        }");
        return observableM11069e;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, final Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16) {
        C12238m.checkNotNullParameter(observable, "o1");
        C12238m.checkNotNullParameter(observable2, "o2");
        C12238m.checkNotNullParameter(observable3, "o3");
        C12238m.checkNotNullParameter(observable4, "o4");
        C12238m.checkNotNullParameter(observable5, "o5");
        C12238m.checkNotNullParameter(observable6, "o6");
        C12238m.checkNotNullParameter(observable7, "o7");
        C12238m.checkNotNullParameter(observable8, "o8");
        C12238m.checkNotNullParameter(observable9, "o9");
        C12238m.checkNotNullParameter(observable10, "o10");
        C12238m.checkNotNullParameter(observable11, "o11");
        C12238m.checkNotNullParameter(observable12, "o12");
        C12238m.checkNotNullParameter(observable13, "o13");
        C12238m.checkNotNullParameter(observable14, "o14");
        C12238m.checkNotNullParameter(observable15, "o15");
        C12238m.checkNotNullParameter(observable16, "o16");
        C12238m.checkNotNullParameter(function16, "combineFunction");
        Observable<R> observableM11067d = Observable.m11067d(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, new Func8<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.7
            @Override // p658rx.functions.Func8
            public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16) {
                return (R) function16.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14, t15, t16);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11067d, "Observable\n        .comb…t16\n          )\n        }");
        return observableM11067d;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, final Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17) {
        C12238m.checkNotNullParameter(observable, "o1");
        C12238m.checkNotNullParameter(observable2, "o2");
        C12238m.checkNotNullParameter(observable3, "o3");
        C12238m.checkNotNullParameter(observable4, "o4");
        C12238m.checkNotNullParameter(observable5, "o5");
        C12238m.checkNotNullParameter(observable6, "o6");
        C12238m.checkNotNullParameter(observable7, "o7");
        C12238m.checkNotNullParameter(observable8, "o8");
        C12238m.checkNotNullParameter(observable9, "o9");
        C12238m.checkNotNullParameter(observable10, "o10");
        C12238m.checkNotNullParameter(observable11, "o11");
        C12238m.checkNotNullParameter(observable12, "o12");
        C12238m.checkNotNullParameter(observable13, "o13");
        C12238m.checkNotNullParameter(observable14, "o14");
        C12238m.checkNotNullParameter(observable15, "o15");
        C12238m.checkNotNullParameter(observable16, "o16");
        C12238m.checkNotNullParameter(observable17, "o17");
        C12238m.checkNotNullParameter(function17, "combineFunction");
        Observable<R> observableM11066c = Observable.m11066c(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, new Func9<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, T17, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.8
            @Override // p658rx.functions.Func9
            public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16, T17 t17) {
                return (R) function17.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14, t15, t16, t17);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11066c, "Observable\n        .comb…t17\n          )\n        }");
        return observableM11066c;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Observable<T18> observable18, Observable<T19> observable19, Observable<T20> observable20, Observable<T21> observable21, Observable<T22> observable22, final Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22) {
        C12238m.checkNotNullParameter(observable, "o1");
        C12238m.checkNotNullParameter(observable2, "o2");
        C12238m.checkNotNullParameter(observable3, "o3");
        C12238m.checkNotNullParameter(observable4, "o4");
        C12238m.checkNotNullParameter(observable5, "o5");
        C12238m.checkNotNullParameter(observable6, "o6");
        C12238m.checkNotNullParameter(observable7, "o7");
        C12238m.checkNotNullParameter(observable8, "o8");
        C12238m.checkNotNullParameter(observable9, "o9");
        C12238m.checkNotNullParameter(observable10, "o10");
        C12238m.checkNotNullParameter(observable11, "o11");
        C12238m.checkNotNullParameter(observable12, "o12");
        C12238m.checkNotNullParameter(observable13, "o13");
        C12238m.checkNotNullParameter(observable14, "o14");
        C12238m.checkNotNullParameter(observable15, "o15");
        C12238m.checkNotNullParameter(observable16, "o16");
        C12238m.checkNotNullParameter(observable17, "o17");
        C12238m.checkNotNullParameter(observable18, "o18");
        C12238m.checkNotNullParameter(observable19, "o19");
        C12238m.checkNotNullParameter(observable20, "o20");
        C12238m.checkNotNullParameter(observable21, "o21");
        C12238m.checkNotNullParameter(observable22, "o22");
        C12238m.checkNotNullParameter(function22, "combineFunction");
        Observable<R> observableM11071f = Observable.m11071f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), createHolderObservable(observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, observable18), observable19, observable20, observable21, observable22, new Func6<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, Holder<T10, T11, T12, T13, T14, T15, T16, T17, T18>, T19, T20, T21, T22, R>() { // from class: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt.combineLatest.9
            @Override // p658rx.functions.Func6
            public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, Holder<T10, T11, T12, T13, T14, T15, T16, T17, T18> holder2, T19 t19, T20 t20, T21 t21, T22 t22) {
                return (R) function22.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), holder2.getT1(), holder2.getT2(), holder2.getT3(), holder2.getT4(), holder2.getT5(), holder2.getT6(), holder2.getT7(), holder2.getT8(), holder2.getT9(), t19, t20, t21, t22);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11071f, "Observable\n        .comb…22,\n          )\n        }");
        return observableM11071f;
    }
}
