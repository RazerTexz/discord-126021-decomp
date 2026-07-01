package com.discord.utilities.search.network;

import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchQuery {
    private final boolean includeNsfw;
    private final Map<String, List<String>> params;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchQuery(Map<String, ? extends List<String>> map, boolean z2) {
        m.checkNotNullParameter(map, "params");
        this.params = map;
        this.includeNsfw = z2;
    }

    public final boolean getIncludeNsfw() {
        return this.includeNsfw;
    }

    public final Map<String, List<String>> getParams() {
        return this.params;
    }

    public final boolean isValid() {
        return !this.params.isEmpty();
    }
}
