package com.discord.widgets.hubs;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer$onViewBound$$inlined$apply$lambda$1 extends AbstractC12240o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer$onViewBound$$inlined$apply$lambda$1(WidgetHubAddServer widgetHubAddServer) {
        super(1);
        this.this$0 = widgetHubAddServer;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(int i) {
        this.this$0.getViewModel().setIndex(i);
    }
}
