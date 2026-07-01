package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import j0.k.b;

/* JADX INFO: compiled from: StoreSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearch$init$1<T, R> implements b<SearchState, Boolean> {
    public static final StoreSearch$init$1 INSTANCE = new StoreSearch$init$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(SearchState searchState) {
        return call2(searchState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(SearchState searchState) {
        return Boolean.valueOf(searchState.getQueryFetchState() != QueryFetchState.NONE);
    }
}
