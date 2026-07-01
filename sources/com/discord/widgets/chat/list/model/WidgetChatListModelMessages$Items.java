package com.discord.widgets.chat.list.model;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelMessages$Items {
    private static final WidgetChatListModelMessages$Items$Companion Companion = new WidgetChatListModelMessages$Items$Companion(null);

    @Deprecated
    private static final int LIST_CAPACITY_BUFFER = 10;
    private int concatCount;
    private List<ChatListEntry> items;
    private MGRecyclerDataPayload listItemMostRecentlyAdded;

    public WidgetChatListModelMessages$Items(int i) {
        this.items = new ArrayList(i + 10);
    }

    public final void addItem(ChatListEntry item) {
        m.checkNotNullParameter(item, "item");
        this.items.add(item);
        this.listItemMostRecentlyAdded = item;
    }

    public final void addItems(List<? extends ChatListEntry> itemList) {
        m.checkNotNullParameter(itemList, "itemList");
        if (itemList.isEmpty()) {
            return;
        }
        this.items.addAll(itemList);
        this.listItemMostRecentlyAdded = itemList.get(itemList.size() - 1);
    }

    public final int getConcatCount() {
        return this.concatCount;
    }

    public final List<ChatListEntry> getItems() {
        return this.items;
    }

    public final MGRecyclerDataPayload getListItemMostRecentlyAdded() {
        return this.listItemMostRecentlyAdded;
    }

    public final void setConcatCount(int i) {
        this.concatCount = i;
    }

    public final void setItems(List<ChatListEntry> list) {
        m.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public final void setListItemMostRecentlyAdded(MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.listItemMostRecentlyAdded = mGRecyclerDataPayload;
    }
}
