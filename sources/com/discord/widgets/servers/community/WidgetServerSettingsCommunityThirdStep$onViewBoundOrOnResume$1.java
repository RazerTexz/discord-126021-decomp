package com.discord.widgets.servers.community;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityThirdStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, Unit> {
    public WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$1(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
        super(1, widgetServerSettingsCommunityThirdStep, WidgetServerSettingsCommunityThirdStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        invoke2(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, "p1");
        WidgetServerSettingsCommunityThirdStep.access$configureUI((WidgetServerSettingsCommunityThirdStep) this.receiver, widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded);
    }
}
