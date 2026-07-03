package com.discord.utilities.p501rx;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$sam$rx_functions_Action1$0 implements Action1 {
    private final /* synthetic */ Function1 function;

    public ObservableExtensionsKt$sam$rx_functions_Action1$0(Function1 function1) {
        this.function = function1;
    }

    @Override // p658rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        C12238m.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
