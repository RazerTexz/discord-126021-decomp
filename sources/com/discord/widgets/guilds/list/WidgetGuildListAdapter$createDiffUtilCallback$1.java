package com.discord.widgets.guilds.list;

import androidx.recyclerview.widget.DiffUtil$Callback;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildListAdapter$createDiffUtilCallback$1 extends DiffUtil$Callback {
    public final /* synthetic */ List $newItems;
    public final /* synthetic */ List $oldItems;

    public WidgetGuildListAdapter$createDiffUtilCallback$1(List list, List list2) {
        this.$oldItems = list;
        this.$newItems = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return m.areEqual((GuildListItem) this.$oldItems.get(oldItemPosition), (GuildListItem) this.$newItems.get(newItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return ((GuildListItem) this.$oldItems.get(oldItemPosition)).getItemId() == ((GuildListItem) this.$newItems.get(newItemPosition)).getItemId();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getNewListSize() {
        return this.$newItems.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getOldListSize() {
        return this.$oldItems.size();
    }
}
