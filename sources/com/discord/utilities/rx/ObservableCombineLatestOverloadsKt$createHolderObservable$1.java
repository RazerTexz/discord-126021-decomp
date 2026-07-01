package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import rx.functions.Func9;

/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt$createHolderObservable$1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    public static final ObservableCombineLatestOverloadsKt$createHolderObservable$1 INSTANCE = new ObservableCombineLatestOverloadsKt$createHolderObservable$1();

    @Override // rx.functions.Func9
    public final Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
        return new Holder<>(t1, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }
}
