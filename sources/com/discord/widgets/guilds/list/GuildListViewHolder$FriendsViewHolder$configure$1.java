package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$FriendsViewHolder$configure$1 implements View$OnClickListener {
    public final /* synthetic */ GuildListItem$FriendsItem $data;
    public final /* synthetic */ GuildListViewHolder$FriendsViewHolder this$0;

    public GuildListViewHolder$FriendsViewHolder$configure$1(GuildListViewHolder$FriendsViewHolder guildListViewHolder$FriendsViewHolder, GuildListItem$FriendsItem guildListItem$FriendsItem) {
        this.this$0 = guildListViewHolder$FriendsViewHolder;
        this.$data = guildListItem$FriendsItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildListViewHolder$FriendsViewHolder.access$getOnClicked$p(this.this$0).invoke(this.$data);
    }
}
