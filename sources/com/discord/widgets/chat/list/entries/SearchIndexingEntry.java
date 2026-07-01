package com.discord.widgets.chat.list.entries;


/* JADX INFO: compiled from: SearchIndexingEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchIndexingEntry extends ChatListEntry {
    private final int type = 12;
    private final String key = String.valueOf(getType());

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
