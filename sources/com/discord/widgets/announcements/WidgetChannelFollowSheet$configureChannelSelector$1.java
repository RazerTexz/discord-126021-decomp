package com.discord.widgets.announcements;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.guild.Guild;
import com.discord.widgets.channels.WidgetChannelSelector;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet$configureChannelSelector$1 implements View$OnClickListener {
    public final /* synthetic */ Guild $selectedGuild;
    public final /* synthetic */ WidgetChannelFollowSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChannelFollowSheet this$0;

    public WidgetChannelFollowSheet$configureChannelSelector$1(WidgetChannelFollowSheet widgetChannelFollowSheet, Guild guild, WidgetChannelFollowSheetViewModel$ViewState$Loaded widgetChannelFollowSheetViewModel$ViewState$Loaded) {
        this.this$0 = widgetChannelFollowSheet;
        this.$selectedGuild = guild;
        this.$viewState = widgetChannelFollowSheetViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSelector.Companion.launch(this.this$0, this.$selectedGuild.getId(), "REQUEST_KEY_CHANNEL_FOLLOW_CHANNEL", false, 2131893305, new WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction(this.$selectedGuild.getId(), this.$viewState.getAvailableChannels()));
    }
}
