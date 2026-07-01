package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.network.state.SearchState;
import j0.k.b;

/* JADX INFO: compiled from: StoreSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearch$init$2<T, R> implements b<SearchState, StoreSearch$DisplayState> {
    public static final StoreSearch$init$2 INSTANCE = new StoreSearch$init$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreSearch$DisplayState call(SearchState searchState) {
        return call2(searchState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreSearch$DisplayState call2(SearchState searchState) {
        return StoreSearch$DisplayState.RESULTS;
    }
}
