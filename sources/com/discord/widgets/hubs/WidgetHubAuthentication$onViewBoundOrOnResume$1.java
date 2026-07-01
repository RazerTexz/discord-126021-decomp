package com.discord.widgets.hubs;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAuthentication$onViewBoundOrOnResume$1 extends k implements Function1<HubAuthenticationState, Unit> {
    public WidgetHubAuthentication$onViewBoundOrOnResume$1(WidgetHubAuthentication widgetHubAuthentication) {
        super(1, widgetHubAuthentication, WidgetHubAuthentication.class, "configureUi", "configureUi(Lcom/discord/widgets/hubs/HubAuthenticationState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HubAuthenticationState hubAuthenticationState) {
        invoke2(hubAuthenticationState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HubAuthenticationState hubAuthenticationState) {
        m.checkNotNullParameter(hubAuthenticationState, "p1");
        WidgetHubAuthentication.access$configureUi((WidgetHubAuthentication) this.receiver, hubAuthenticationState);
    }
}
