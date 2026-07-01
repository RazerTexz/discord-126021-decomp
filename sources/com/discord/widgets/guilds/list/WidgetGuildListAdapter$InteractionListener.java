package com.discord.widgets.guilds.list;

import android.view.View;

/* JADX INFO: compiled from: WidgetGuildListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WidgetGuildListAdapter$InteractionListener {
    boolean onDrop();

    void onItemClicked(View view, GuildListItem item);

    void onItemLongPressed(View view, GuildListItem item);

    void onItemMoved();

    void onOperation(WidgetGuildListAdapter$Operation operation);
}
