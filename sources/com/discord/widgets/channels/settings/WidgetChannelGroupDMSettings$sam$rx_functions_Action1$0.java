package com.discord.widgets.channels.settings;

import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings$sam$rx_functions_Action1$0 implements Action1 {
    private final /* synthetic */ Function1 function;

    public WidgetChannelGroupDMSettings$sam$rx_functions_Action1$0(Function1 function1) {
        this.function = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        m.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
