package com.discord.widgets.channels;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel$1 extends o implements Function1<WidgetChannelSidebarActionsViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetChannelSidebarActionsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActionsViewModel$1(WidgetChannelSidebarActionsViewModel widgetChannelSidebarActionsViewModel) {
        super(1);
        this.this$0 = widgetChannelSidebarActionsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSidebarActionsViewModel$StoreState widgetChannelSidebarActionsViewModel$StoreState) {
        invoke2(widgetChannelSidebarActionsViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelSidebarActionsViewModel$StoreState widgetChannelSidebarActionsViewModel$StoreState) {
        m.checkNotNullParameter(widgetChannelSidebarActionsViewModel$StoreState, "storeState");
        WidgetChannelSidebarActionsViewModel.access$handleStoreState(this.this$0, widgetChannelSidebarActionsViewModel$StoreState);
    }
}
