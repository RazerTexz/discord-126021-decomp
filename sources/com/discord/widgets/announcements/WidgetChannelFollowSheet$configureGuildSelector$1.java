package com.discord.widgets.announcements;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.discord.widgets.guilds.WidgetGuildSelector$Companion;
import com.discord.widgets.guilds.WidgetGuildSelector$GuildFilterFunction;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet$configureGuildSelector$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelFollowSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChannelFollowSheet this$0;

    public WidgetChannelFollowSheet$configureGuildSelector$1(WidgetChannelFollowSheet widgetChannelFollowSheet, WidgetChannelFollowSheetViewModel$ViewState$Loaded widgetChannelFollowSheetViewModel$ViewState$Loaded) {
        this.this$0 = widgetChannelFollowSheet;
        this.$viewState = widgetChannelFollowSheetViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildSelector$Companion.launch$default(WidgetGuildSelector.Companion, this.this$0, null, false, 0, new WidgetGuildSelector$GuildFilterFunction(this.$viewState.getAvailableGuilds()), 14, null);
    }
}
