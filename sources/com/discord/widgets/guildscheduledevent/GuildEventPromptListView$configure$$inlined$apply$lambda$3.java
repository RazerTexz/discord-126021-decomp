package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildEventPromptListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildEventPromptListView$configure$$inlined$apply$lambda$3 implements View$OnClickListener {
    public final /* synthetic */ GuildEventPromptListView$ScheduledEventData $scheduledEventData$inlined;

    public GuildEventPromptListView$configure$$inlined$apply$lambda$3(GuildEventPromptListView$ScheduledEventData guildEventPromptListView$ScheduledEventData) {
        this.$scheduledEventData$inlined = guildEventPromptListView$ScheduledEventData;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$scheduledEventData$inlined.getOnScheduledEventClick().invoke();
    }
}
