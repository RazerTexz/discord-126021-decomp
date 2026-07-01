package com.discord.widgets.servers.community;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsEnableCommunityViewModel$ViewState, Unit> {
    public WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$1(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        super(1, widgetServerSettingsEnableCommunitySteps, WidgetServerSettingsEnableCommunitySteps.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel$ViewState widgetServerSettingsEnableCommunityViewModel$ViewState) {
        invoke2(widgetServerSettingsEnableCommunityViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsEnableCommunityViewModel$ViewState widgetServerSettingsEnableCommunityViewModel$ViewState) {
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$ViewState, "p1");
        WidgetServerSettingsEnableCommunitySteps.access$configureUI((WidgetServerSettingsEnableCommunitySteps) this.receiver, widgetServerSettingsEnableCommunityViewModel$ViewState);
    }
}
