package com.discord.widgets.servers.community;

import com.discord.views.CheckedSetting;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityThirdStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityThirdStep$configureUI$3$1 extends o implements Function1<WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig> {
    public final /* synthetic */ WidgetServerSettingsCommunityThirdStep$configureUI$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityThirdStep$configureUI$3$1(WidgetServerSettingsCommunityThirdStep$configureUI$3 widgetServerSettingsCommunityThirdStep$configureUI$3) {
        super(1);
        this.this$0 = widgetServerSettingsCommunityThirdStep$configureUI$3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig) {
        return invoke2(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig) {
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, "it");
        CheckedSetting checkedSetting = WidgetServerSettingsCommunityThirdStep.access$getBinding$p(this.this$0.this$0).f2556b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingCommunityGuidelinesSwitch");
        return WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.copy$default(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, null, null, null, null, !checkedSetting.isChecked(), false, false, false, null, false, null, null, 4079, null);
    }
}
