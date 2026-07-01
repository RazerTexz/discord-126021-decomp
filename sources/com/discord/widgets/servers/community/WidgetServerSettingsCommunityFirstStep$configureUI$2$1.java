package com.discord.widgets.servers.community;

import com.discord.views.CheckedSetting;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityFirstStep$configureUI$2$1 extends o implements Function1<WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig> {
    public final /* synthetic */ WidgetServerSettingsCommunityFirstStep$configureUI$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityFirstStep$configureUI$2$1(WidgetServerSettingsCommunityFirstStep$configureUI$2 widgetServerSettingsCommunityFirstStep$configureUI$2) {
        super(1);
        this.this$0 = widgetServerSettingsCommunityFirstStep$configureUI$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig) {
        return invoke2(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig) {
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, "it");
        CheckedSetting checkedSetting = WidgetServerSettingsCommunityFirstStep.access$getBinding$p(this.this$0.this$0).f2554b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsScanMessagesSwitch");
        return WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.copy$default(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, null, null, null, null, false, false, false, !checkedSetting.isChecked(), null, false, null, null, 3967, null);
    }
}
