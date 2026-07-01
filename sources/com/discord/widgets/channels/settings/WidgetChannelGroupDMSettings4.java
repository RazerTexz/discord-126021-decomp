package com.discord.widgets.channels.settings;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$sam$rx_functions_Action1$0, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings4 implements Action1 {
    private final /* synthetic */ Function1 function;

    public WidgetChannelGroupDMSettings4(Function1 function1) {
        this.function = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
