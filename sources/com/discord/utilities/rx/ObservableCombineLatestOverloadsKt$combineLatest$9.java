package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function22;
import rx.functions.Func6;

/* JADX INFO: Add missing generic type declarations: [T7, T8, T9, T10, T21, T20, T12, T11, T22, T14, T13, T16, T15, T18, T17, T19] */
/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt$combineLatest$9<T1, T2, T3, T4, T5, T6, R, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T7, T8, T9> implements Func6<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, Holder<T10, T11, T12, T13, T14, T15, T16, T17, T18>, T19, T20, T21, T22, R> {
    public final /* synthetic */ Function22 $combineFunction;

    public ObservableCombineLatestOverloadsKt$combineLatest$9(Function22 function22) {
        this.$combineFunction = function22;
    }

    public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, Holder<T10, T11, T12, T13, T14, T15, T16, T17, T18> holder2, T19 t19, T20 t20, T21 t21, T22 t22) {
        return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), holder2.getT1(), holder2.getT2(), holder2.getT3(), holder2.getT4(), holder2.getT5(), holder2.getT6(), holder2.getT7(), holder2.getT8(), holder2.getT9(), t19, t20, t21, t22);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return call((Holder) obj, (Holder) obj2, obj3, obj4, obj5, obj6);
    }
}
