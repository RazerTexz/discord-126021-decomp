package com.discord.widgets.status;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatStatus$onViewBoundOrOnResume$1 extends o implements Function1<WidgetChatStatus$Model, Unit> {
    public final /* synthetic */ WidgetChatStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatStatus$onViewBoundOrOnResume$1(WidgetChatStatus widgetChatStatus) {
        super(1);
        this.this$0 = widgetChatStatus;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatStatus$Model widgetChatStatus$Model) {
        invoke2(widgetChatStatus$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatStatus$Model widgetChatStatus$Model) {
        m.checkNotNullParameter(widgetChatStatus$Model, "it");
        WidgetChatStatus.access$configureUI(this.this$0, widgetChatStatus$Model);
    }
}
