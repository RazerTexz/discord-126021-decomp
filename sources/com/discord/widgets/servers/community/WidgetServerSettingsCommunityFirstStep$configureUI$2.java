package com.discord.widgets.servers.community;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityFirstStep$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ boolean $guildExplicitContentFilter;
    public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetServerSettingsCommunityFirstStep this$0;

    public WidgetServerSettingsCommunityFirstStep$configureUI$2(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep, WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, boolean z2) {
        this.this$0 = widgetServerSettingsCommunityFirstStep;
        this.$viewState = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;
        this.$guildExplicitContentFilter = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$viewState.getCommunityGuildConfig().getExplicitContentFilter() && this.$guildExplicitContentFilter) {
            m.d(this.this$0.getContext(), 2131888834, 0, WidgetServerSettingsCommunityFirstStep.access$getToastManager$p(this.this$0));
        } else {
            WidgetServerSettingsCommunityFirstStep.access$getViewModel$p(this.this$0).modifyGuildConfig(new WidgetServerSettingsCommunityFirstStep$configureUI$2$1(this));
        }
    }
}
