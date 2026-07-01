package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function10;
import rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T4, T5, T6, T10, T7, T8, T9, T3] */
/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt$combineLatest$1<T1, T2, R, T10, T3, T4, T5, T6, T7, T8, T9> implements Func2<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, R> {
    public final /* synthetic */ Function10 $combineFunction;

    public ObservableCombineLatestOverloadsKt$combineLatest$1(Function10 function10) {
        this.$combineFunction = function10;
    }

    public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10) {
        return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
        return call((Holder) obj, obj2);
    }
}
