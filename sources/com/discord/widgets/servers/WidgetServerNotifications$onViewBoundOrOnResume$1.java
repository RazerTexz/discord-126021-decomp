package com.discord.widgets.servers;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$onViewBoundOrOnResume$1 extends o implements Function1<WidgetServerNotifications$Model, Unit> {
    public final /* synthetic */ WidgetServerNotifications this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerNotifications$onViewBoundOrOnResume$1(WidgetServerNotifications widgetServerNotifications) {
        super(1);
        this.this$0 = widgetServerNotifications;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerNotifications$Model widgetServerNotifications$Model) {
        invoke2(widgetServerNotifications$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerNotifications$Model widgetServerNotifications$Model) {
        WidgetServerNotifications.access$configureUI(this.this$0, widgetServerNotifications$Model);
    }
}
