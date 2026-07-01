package com.discord.utilities.search.suggestion.entries;


/* JADX INFO: compiled from: SearchSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface SearchSuggestion {

    /* JADX INFO: compiled from: SearchSuggestion.kt */
    public enum Category {
        FILTER,
        MENTIONS_USER,
        FROM_USER,
        HAS,
        BEFORE_DATE,
        IN_CHANNEL,
        RECENT_QUERY
    }

    Category getCategory();
}
