package com.discord.widgets.hubs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer$onViewBoundOrOnResume$1 extends o implements Function1<HubAddServerState, Unit> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer$onViewBoundOrOnResume$1(WidgetHubAddServer widgetHubAddServer) {
        super(1);
        this.this$0 = widgetHubAddServer;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HubAddServerState hubAddServerState) {
        invoke2(hubAddServerState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HubAddServerState hubAddServerState) {
        m.checkNotNullParameter(hubAddServerState, "viewState");
        WidgetHubAddServer.access$configureUI(this.this$0, hubAddServerState);
    }
}
