package com.discord.widgets.chat.list.entries;


/* JADX INFO: compiled from: SearchEmptyEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchEmptyEntry extends ChatListEntry {
    private final int type = 13;
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
