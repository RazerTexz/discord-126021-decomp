package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$FolderViewHolder$configure$2 implements View$OnClickListener {
    public final /* synthetic */ GuildListItem$FolderItem $data;
    public final /* synthetic */ GuildListViewHolder$FolderViewHolder this$0;

    public GuildListViewHolder$FolderViewHolder$configure$2(GuildListViewHolder$FolderViewHolder guildListViewHolder$FolderViewHolder, GuildListItem$FolderItem guildListItem$FolderItem) {
        this.this$0 = guildListViewHolder$FolderViewHolder;
        this.$data = guildListItem$FolderItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildListViewHolder$FolderViewHolder.access$getOnClicked$p(this.this$0).invoke(this.$data);
    }
}
