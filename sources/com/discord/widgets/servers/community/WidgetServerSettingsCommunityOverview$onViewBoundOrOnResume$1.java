package com.discord.widgets.servers.community;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsCommunityOverviewViewModel$ViewState, Unit> {
    public WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$1(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
        super(1, widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverview.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel$ViewState widgetServerSettingsCommunityOverviewViewModel$ViewState) {
        invoke2(widgetServerSettingsCommunityOverviewViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel$ViewState widgetServerSettingsCommunityOverviewViewModel$ViewState) {
        m.checkNotNullParameter(widgetServerSettingsCommunityOverviewViewModel$ViewState, "p1");
        WidgetServerSettingsCommunityOverview.access$configureUI((WidgetServerSettingsCommunityOverview) this.receiver, widgetServerSettingsCommunityOverviewViewModel$ViewState);
    }
}
