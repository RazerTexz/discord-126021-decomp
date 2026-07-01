package com.discord.widgets.servers.community;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEnableCommunityViewModel$1 extends k implements Function1<WidgetServerSettingsEnableCommunityViewModel$StoreState, Unit> {
    public WidgetServerSettingsEnableCommunityViewModel$1(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel) {
        super(1, widgetServerSettingsEnableCommunityViewModel, WidgetServerSettingsEnableCommunityViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel$StoreState widgetServerSettingsEnableCommunityViewModel$StoreState) {
        invoke2(widgetServerSettingsEnableCommunityViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsEnableCommunityViewModel$StoreState widgetServerSettingsEnableCommunityViewModel$StoreState) {
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$StoreState, "p1");
        WidgetServerSettingsEnableCommunityViewModel.access$handleStoreState((WidgetServerSettingsEnableCommunityViewModel) this.receiver, widgetServerSettingsEnableCommunityViewModel$StoreState);
    }
}
