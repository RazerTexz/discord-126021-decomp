package com.discord.widgets.servers.community;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityOverviewViewModel$1 extends k implements Function1<WidgetServerSettingsCommunityOverviewViewModel$StoreState, Unit> {
    public WidgetServerSettingsCommunityOverviewViewModel$1(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel) {
        super(1, widgetServerSettingsCommunityOverviewViewModel, WidgetServerSettingsCommunityOverviewViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel$StoreState widgetServerSettingsCommunityOverviewViewModel$StoreState) {
        invoke2(widgetServerSettingsCommunityOverviewViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel$StoreState widgetServerSettingsCommunityOverviewViewModel$StoreState) {
        m.checkNotNullParameter(widgetServerSettingsCommunityOverviewViewModel$StoreState, "p1");
        WidgetServerSettingsCommunityOverviewViewModel.access$handleStoreState((WidgetServerSettingsCommunityOverviewViewModel) this.receiver, widgetServerSettingsCommunityOverviewViewModel$StoreState);
    }
}
