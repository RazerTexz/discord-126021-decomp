package com.discord.widgets.hubs;

import com.discord.api.hubs.EmailVerification;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainsViewModel$onGuildClicked$2 extends o implements Function1<RestCallState<? extends EmailVerification>, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetHubDomainsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomainsViewModel$onGuildClicked$2(WidgetHubDomainsViewModel widgetHubDomainsViewModel, long j) {
        super(1);
        this.this$0 = widgetHubDomainsViewModel;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification> restCallState) {
        invoke2((RestCallState<EmailVerification>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<EmailVerification> restCallState) {
        m.checkNotNullParameter(restCallState, "it");
        WidgetHubDomainsViewModel widgetHubDomainsViewModel = this.this$0;
        WidgetHubDomainsViewModel.access$updateViewState(widgetHubDomainsViewModel, WidgetHubDomainsViewModel.access$requireViewState(widgetHubDomainsViewModel).copy(Long.valueOf(this.$guildId), restCallState));
    }
}
