package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import d0.z.d.m;
import j0.k.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreSearchInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchInput$1<T, R> implements b<List<? extends QueryNode>, Boolean> {
    public static final StoreSearchInput$1 INSTANCE = new StoreSearchInput$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(List<? extends QueryNode> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(List<? extends QueryNode> list) {
        m.checkNotNullExpressionValue(list, "it");
        boolean z2 = true;
        if ((list instanceof Collection) && list.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!(((QueryNode) it.next()) instanceof FilterNode)) {
                }
            }
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
