package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$GuildViewHolder$configure$1 implements View$OnClickListener {
    public final /* synthetic */ GuildListItem$GuildItem $data;
    public final /* synthetic */ GuildListViewHolder$GuildViewHolder this$0;

    public GuildListViewHolder$GuildViewHolder$configure$1(GuildListViewHolder$GuildViewHolder guildListViewHolder$GuildViewHolder, GuildListItem$GuildItem guildListItem$GuildItem) {
        this.this$0 = guildListViewHolder$GuildViewHolder;
        this.$data = guildListItem$GuildItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildListViewHolder$GuildViewHolder.access$getOnClicked$p(this.this$0).invoke(this.$data);
    }
}
