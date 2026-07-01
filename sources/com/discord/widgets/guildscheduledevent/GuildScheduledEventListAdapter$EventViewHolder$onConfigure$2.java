package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildScheduledEventListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventListAdapter$EventViewHolder$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEventListItem$Event $item;
    public final /* synthetic */ GuildScheduledEventListAdapter$EventViewHolder this$0;

    public GuildScheduledEventListAdapter$EventViewHolder$onConfigure$2(GuildScheduledEventListAdapter$EventViewHolder guildScheduledEventListAdapter$EventViewHolder, GuildScheduledEventListItem$Event guildScheduledEventListItem$Event) {
        this.this$0 = guildScheduledEventListAdapter$EventViewHolder;
        this.$item = guildScheduledEventListItem$Event;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventListAdapter$EventViewHolder.access$getAdapter$p(this.this$0).getOnRsvpClicked().invoke(this.$item);
    }
}
