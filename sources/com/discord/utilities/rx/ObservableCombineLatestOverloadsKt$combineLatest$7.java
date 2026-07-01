package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function16;
import rx.functions.Func8;

/* JADX INFO: Add missing generic type declarations: [T9, T10, T12, T11, T14, T13, T16, T15] */
/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt$combineLatest$7<T1, T2, T3, T4, T5, T6, T7, T8, R, T10, T11, T12, T13, T14, T15, T16, T9> implements Func8<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, R> {
    public final /* synthetic */ Function16 $combineFunction;

    public ObservableCombineLatestOverloadsKt$combineLatest$7(Function16 function16) {
        this.$combineFunction = function16;
    }

    public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16) {
        return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14, t15, t16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return call((Holder) obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }
}
