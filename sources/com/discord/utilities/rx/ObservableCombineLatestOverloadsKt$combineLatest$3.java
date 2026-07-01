package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function12;
import rx.functions.Func4;

/* JADX INFO: Add missing generic type declarations: [T5, T6, T7, T8, T9, T10, T12, T11] */
/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt$combineLatest$3<T1, T2, T3, T4, R, T10, T11, T12, T5, T6, T7, T8, T9> implements Func4<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, R> {
    public final /* synthetic */ Function12 $combineFunction;

    public ObservableCombineLatestOverloadsKt$combineLatest$3(Function12 function12) {
        this.$combineFunction = function12;
    }

    public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12) {
        return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return call((Holder) obj, obj2, obj3, obj4);
    }
}
