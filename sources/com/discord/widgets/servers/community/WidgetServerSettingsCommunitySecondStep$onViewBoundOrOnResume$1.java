package com.discord.widgets.servers.community;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, Unit> {
    public WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$1(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep) {
        super(1, widgetServerSettingsCommunitySecondStep, WidgetServerSettingsCommunitySecondStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        invoke2(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, "p1");
        WidgetServerSettingsCommunitySecondStep.access$configureUI((WidgetServerSettingsCommunitySecondStep) this.receiver, widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded);
    }
}
