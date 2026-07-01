package com.discord.widgets.servers;

import androidx.recyclerview.widget.DiffUtil$Callback;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: NotificationsOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationsOverridesAdapter$DiffCallback extends DiffUtil$Callback {
    private final List<NotificationsOverridesAdapter$Item> newItems;
    private final List<NotificationsOverridesAdapter$Item> oldItems;

    public NotificationsOverridesAdapter$DiffCallback(List<NotificationsOverridesAdapter$Item> list, List<NotificationsOverridesAdapter$Item> list2) {
        m.checkNotNullParameter(list, "newItems");
        m.checkNotNullParameter(list2, "oldItems");
        this.newItems = list;
        this.oldItems = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return m.areEqual(this.newItems.get(newItemPosition), this.oldItems.get(oldItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return this.newItems.get(newItemPosition).getChannel().getId() == this.oldItems.get(oldItemPosition).getChannel().getId();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getNewListSize() {
        return this.newItems.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getOldListSize() {
        return this.oldItems.size();
    }
}
