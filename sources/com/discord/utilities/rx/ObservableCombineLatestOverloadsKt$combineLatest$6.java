package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function15;
import rx.functions.Func7;

/* JADX INFO: Add missing generic type declarations: [T8, T9, T10, T12, T11, T14, T13, T15] */
/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt$combineLatest$6<T1, T2, T3, T4, T5, T6, T7, R, T10, T11, T12, T13, T14, T15, T8, T9> implements Func7<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, R> {
    public final /* synthetic */ Function15 $combineFunction;

    public ObservableCombineLatestOverloadsKt$combineLatest$6(Function15 function15) {
        this.$combineFunction = function15;
    }

    public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15) {
        return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14, t15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return call((Holder) obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }
}
