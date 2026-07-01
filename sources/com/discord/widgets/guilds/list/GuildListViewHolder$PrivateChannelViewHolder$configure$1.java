package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$PrivateChannelViewHolder$configure$1 implements View$OnClickListener {
    public final /* synthetic */ GuildListItem$PrivateChannelItem $data;
    public final /* synthetic */ GuildListViewHolder$PrivateChannelViewHolder this$0;

    public GuildListViewHolder$PrivateChannelViewHolder$configure$1(GuildListViewHolder$PrivateChannelViewHolder guildListViewHolder$PrivateChannelViewHolder, GuildListItem$PrivateChannelItem guildListItem$PrivateChannelItem) {
        this.this$0 = guildListViewHolder$PrivateChannelViewHolder;
        this.$data = guildListItem$PrivateChannelItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildListViewHolder$PrivateChannelViewHolder.access$getOnClicked$p(this.this$0).invoke(this.$data);
    }
}
