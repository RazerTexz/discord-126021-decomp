package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.query.node.QueryNode;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: StoreSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearch$init$3<T, R> implements b<List<? extends QueryNode>, StoreSearch$DisplayState> {
    public static final StoreSearch$init$3 INSTANCE = new StoreSearch$init$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreSearch$DisplayState call(List<? extends QueryNode> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreSearch$DisplayState call2(List<? extends QueryNode> list) {
        return StoreSearch$DisplayState.SUGGESTIONS;
    }
}
