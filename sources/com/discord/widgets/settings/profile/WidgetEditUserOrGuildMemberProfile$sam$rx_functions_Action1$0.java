package com.discord.widgets.settings.profile;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 implements Action1 {
    private final /* synthetic */ Function1 function;

    public WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0(Function1 function1) {
        this.function = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
