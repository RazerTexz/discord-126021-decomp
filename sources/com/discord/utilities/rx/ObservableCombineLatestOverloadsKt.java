package com.discord.utilities.rx;

import d0.z.d.m;
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

/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt {
    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(function10, "combineFunction");
        Observable<R> observableJ = Observable.j(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, new ObservableCombineLatestOverloadsKt$combineLatest$1(function10));
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…t10\n          )\n        }");
        return observableJ;
    }

    private static final <T1, T2, T3, T4, T5, T6, T7, T8, T9> Observable<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>> createHolderObservable(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9) {
        Observable<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>> observableC = Observable.c(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, ObservableCombineLatestOverloadsKt$createHolderObservable$1.INSTANCE);
        m.checkNotNullExpressionValue(observableC, "Observable\n    .combineL…t5, t6, t7, t8, t9)\n    }");
        return observableC;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(function11, "combineFunction");
        Observable<R> observableI = Observable.i(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, new ObservableCombineLatestOverloadsKt$combineLatest$2(function11));
        m.checkNotNullExpressionValue(observableI, "Observable\n        .comb…t11\n          )\n        }");
        return observableI;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(function12, "combineFunction");
        Observable<R> observableH = Observable.h(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, new ObservableCombineLatestOverloadsKt$combineLatest$3(function12));
        m.checkNotNullExpressionValue(observableH, "Observable\n        .comb…t12\n          )\n        }");
        return observableH;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(function13, "combineFunction");
        Observable<R> observableG = Observable.g(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, new ObservableCombineLatestOverloadsKt$combineLatest$4(function13));
        m.checkNotNullExpressionValue(observableG, "Observable\n        .comb…t13\n          )\n        }");
        return observableG;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(function14, "combineFunction");
        Observable<R> observableF = Observable.f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, new ObservableCombineLatestOverloadsKt$combineLatest$5(function14));
        m.checkNotNullExpressionValue(observableF, "Observable\n        .comb…t14\n          )\n        }");
        return observableF;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(observable15, "o15");
        m.checkNotNullParameter(function15, "combineFunction");
        Observable<R> observableE = Observable.e(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, new ObservableCombineLatestOverloadsKt$combineLatest$6(function15));
        m.checkNotNullExpressionValue(observableE, "Observable\n        .comb…t15\n          )\n        }");
        return observableE;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(observable15, "o15");
        m.checkNotNullParameter(observable16, "o16");
        m.checkNotNullParameter(function16, "combineFunction");
        Observable<R> observableD = Observable.d(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, new ObservableCombineLatestOverloadsKt$combineLatest$7(function16));
        m.checkNotNullExpressionValue(observableD, "Observable\n        .comb…t16\n          )\n        }");
        return observableD;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(observable15, "o15");
        m.checkNotNullParameter(observable16, "o16");
        m.checkNotNullParameter(observable17, "o17");
        m.checkNotNullParameter(function17, "combineFunction");
        Observable<R> observableC = Observable.c(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, new ObservableCombineLatestOverloadsKt$combineLatest$8(function17));
        m.checkNotNullExpressionValue(observableC, "Observable\n        .comb…t17\n          )\n        }");
        return observableC;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Observable<T18> observable18, Observable<T19> observable19, Observable<T20> observable20, Observable<T21> observable21, Observable<T22> observable22, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(observable15, "o15");
        m.checkNotNullParameter(observable16, "o16");
        m.checkNotNullParameter(observable17, "o17");
        m.checkNotNullParameter(observable18, "o18");
        m.checkNotNullParameter(observable19, "o19");
        m.checkNotNullParameter(observable20, "o20");
        m.checkNotNullParameter(observable21, "o21");
        m.checkNotNullParameter(observable22, "o22");
        m.checkNotNullParameter(function22, "combineFunction");
        Observable<R> observableF = Observable.f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), createHolderObservable(observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, observable18), observable19, observable20, observable21, observable22, new ObservableCombineLatestOverloadsKt$combineLatest$9(function22));
        m.checkNotNullExpressionValue(observableF, "Observable\n        .comb…22,\n          )\n        }");
        return observableF;
    }
}
