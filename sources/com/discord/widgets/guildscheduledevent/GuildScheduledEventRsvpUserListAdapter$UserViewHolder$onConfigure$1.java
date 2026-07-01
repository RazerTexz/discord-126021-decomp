package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildScheduledEventRsvpUserListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventRsvpUserListAdapter$UserViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEventRsvpUserListItem$RsvpUser $item;
    public final /* synthetic */ GuildScheduledEventRsvpUserListAdapter$UserViewHolder this$0;

    public GuildScheduledEventRsvpUserListAdapter$UserViewHolder$onConfigure$1(GuildScheduledEventRsvpUserListAdapter$UserViewHolder guildScheduledEventRsvpUserListAdapter$UserViewHolder, GuildScheduledEventRsvpUserListItem$RsvpUser guildScheduledEventRsvpUserListItem$RsvpUser) {
        this.this$0 = guildScheduledEventRsvpUserListAdapter$UserViewHolder;
        this.$item = guildScheduledEventRsvpUserListItem$RsvpUser;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventRsvpUserListAdapter.access$getOnItemClick$p(this.this$0.this$0).invoke(Long.valueOf(this.$item.getUserId()));
    }
}
