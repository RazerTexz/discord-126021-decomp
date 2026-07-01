package com.discord.widgets.hubs;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAddServerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAddServerViewModel$1 extends k implements Function1<HubAddServerState, Unit> {
    public WidgetHubAddServerViewModel$1(WidgetHubAddServerViewModel widgetHubAddServerViewModel) {
        super(1, widgetHubAddServerViewModel, WidgetHubAddServerViewModel.class, "handleStoreUpdate", "handleStoreUpdate(Lcom/discord/widgets/hubs/HubAddServerState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HubAddServerState hubAddServerState) {
        invoke2(hubAddServerState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HubAddServerState hubAddServerState) {
        m.checkNotNullParameter(hubAddServerState, "p1");
        WidgetHubAddServerViewModel.access$handleStoreUpdate((WidgetHubAddServerViewModel) this.receiver, hubAddServerState);
    }
}
