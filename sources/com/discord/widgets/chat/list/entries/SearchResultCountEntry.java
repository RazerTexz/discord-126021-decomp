package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;

/* JADX INFO: compiled from: SearchResultCountEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SearchResultCountEntry extends ChatListEntry {
    private final int totalResults;
    private final int type = 11;
    private final String key = String.valueOf(getType());

    public SearchResultCountEntry(int i) {
        this.totalResults = i;
    }

    public static /* synthetic */ SearchResultCountEntry copy$default(SearchResultCountEntry searchResultCountEntry, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = searchResultCountEntry.totalResults;
        }
        return searchResultCountEntry.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalResults() {
        return this.totalResults;
    }

    public final SearchResultCountEntry copy(int totalResults) {
        return new SearchResultCountEntry(totalResults);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SearchResultCountEntry) && this.totalResults == ((SearchResultCountEntry) other).totalResults;
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getTotalResults() {
        return this.totalResults;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.totalResults;
    }

    public String toString() {
        return outline.B(outline.U("SearchResultCountEntry(totalResults="), this.totalResults, ")");
    }
}
