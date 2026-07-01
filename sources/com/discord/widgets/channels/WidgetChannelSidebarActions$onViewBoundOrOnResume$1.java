package com.discord.widgets.channels;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions$onViewBoundOrOnResume$1 extends o implements Function1<WidgetChannelSidebarActionsViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetChannelSidebarActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActions$onViewBoundOrOnResume$1(WidgetChannelSidebarActions widgetChannelSidebarActions) {
        super(1);
        this.this$0 = widgetChannelSidebarActions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSidebarActionsViewModel$ViewState widgetChannelSidebarActionsViewModel$ViewState) {
        invoke2(widgetChannelSidebarActionsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelSidebarActionsViewModel$ViewState widgetChannelSidebarActionsViewModel$ViewState) {
        m.checkNotNullParameter(widgetChannelSidebarActionsViewModel$ViewState, "viewState");
        WidgetChannelSidebarActions.access$configureUI(this.this$0, widgetChannelSidebarActionsViewModel$ViewState);
    }
}
