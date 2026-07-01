package com.discord.widgets.hubs;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddServer$onViewBound$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer7 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer7(WidgetHubAddServer widgetHubAddServer) {
        super(1);
        this.this$0 = widgetHubAddServer;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        this.this$0.getViewModel().setIndex(i);
    }
}
