package com.discord.widgets.servers.community;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.channels.WidgetChannelSelector$Companion;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview$configureValidUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetServerSettingsCommunityOverview this$0;

    public WidgetServerSettingsCommunityOverview$configureValidUI$2(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded) {
        this.this$0 = widgetServerSettingsCommunityOverview;
        this.$viewState = widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSelector$Companion.launchForText$default(WidgetChannelSelector.Companion, this.this$0, this.$viewState.getGuild().getId(), "REQUEST_KEY_UPDATES_CHANNEL", false, 0, 24, null);
    }
}
