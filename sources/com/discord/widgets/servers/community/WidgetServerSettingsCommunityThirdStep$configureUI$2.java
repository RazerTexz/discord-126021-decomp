package com.discord.widgets.servers.community;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityThirdStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityThirdStep$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ boolean $guildEveryonePermissions;
    public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetServerSettingsCommunityThirdStep this$0;

    public WidgetServerSettingsCommunityThirdStep$configureUI$2(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep, WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, boolean z2) {
        this.this$0 = widgetServerSettingsCommunityThirdStep;
        this.$viewState = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;
        this.$guildEveryonePermissions = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$viewState.getCommunityGuildConfig().getEveryonePermissions() && this.$guildEveryonePermissions) {
            m.d(this.this$0.getContext(), 2131888834, 0, WidgetServerSettingsCommunityThirdStep.access$getToastManager$p(this.this$0));
        } else {
            WidgetServerSettingsCommunityThirdStep.access$getViewModel$p(this.this$0).modifyGuildConfig(new WidgetServerSettingsCommunityThirdStep$configureUI$2$1(this));
        }
    }
}
