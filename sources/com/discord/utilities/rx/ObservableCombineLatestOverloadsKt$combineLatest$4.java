package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function13;
import rx.functions.Func5;

/* JADX INFO: Add missing generic type declarations: [T6, T7, T8, T9, T10, T12, T11, T13] */
/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt$combineLatest$4<T1, T2, T3, T4, T5, R, T10, T11, T12, T13, T6, T7, T8, T9> implements Func5<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, R> {
    public final /* synthetic */ Function13 $combineFunction;

    public ObservableCombineLatestOverloadsKt$combineLatest$4(Function13 function13) {
        this.$combineFunction = function13;
    }

    public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13) {
        return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return call((Holder) obj, obj2, obj3, obj4, obj5);
    }
}
