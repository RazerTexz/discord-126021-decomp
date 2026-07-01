package com.discord.utilities.search.history;

import android.content.Context;
import com.discord.stores.StoreSearch$SearchTarget;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.node.QueryNode;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGPreferenceSearchHistoryCache implements SearchHistoryCache {
    private final int MAX_SEARCH_TARGETS = 10;
    private final int MAX_QUERIES_PER_TARGET = 5;
    private final Persister<LinkedList<MGPreferenceSearchHistoryCache$TargetHistory>> backingCache = new Persister<>("SEARCH_HISTORY_V2", new LinkedList());

    public static final /* synthetic */ LinkedList access$find(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, LinkedList linkedList, StoreSearch$SearchTarget storeSearch$SearchTarget) {
        return mGPreferenceSearchHistoryCache.find(linkedList, storeSearch$SearchTarget);
    }

    public static final /* synthetic */ Persister access$getBackingCache$p(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache) {
        return mGPreferenceSearchHistoryCache.backingCache;
    }

    public static final /* synthetic */ LinkedList access$putAndCopy(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, LinkedList linkedList, StoreSearch$SearchTarget storeSearch$SearchTarget, List list) {
        return mGPreferenceSearchHistoryCache.putAndCopy(linkedList, storeSearch$SearchTarget, list);
    }

    public static final /* synthetic */ LinkedList access$removeAndCopy(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, LinkedList linkedList, StoreSearch$SearchTarget storeSearch$SearchTarget) {
        return mGPreferenceSearchHistoryCache.removeAndCopy(linkedList, storeSearch$SearchTarget);
    }

    private final LinkedList<List<QueryNode>> find(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList, StoreSearch$SearchTarget storeSearch$SearchTarget) {
        Iterator<MGPreferenceSearchHistoryCache$TargetHistory> it = linkedList.iterator();
        m.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            MGPreferenceSearchHistoryCache$TargetHistory next = it.next();
            m.checkNotNullExpressionValue(next, "iter.next()");
            MGPreferenceSearchHistoryCache$TargetHistory mGPreferenceSearchHistoryCache$TargetHistory = next;
            if (m.areEqual(mGPreferenceSearchHistoryCache$TargetHistory.getSearchTarget(), storeSearch$SearchTarget)) {
                return mGPreferenceSearchHistoryCache$TargetHistory.getRecentQueries();
            }
        }
        return new LinkedList<>();
    }

    private final LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> putAndCopy(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList, StoreSearch$SearchTarget storeSearch$SearchTarget, List<? extends QueryNode> list) {
        MGPreferenceSearchHistoryCache$TargetHistory mGPreferenceSearchHistoryCache$TargetHistory;
        Iterator<MGPreferenceSearchHistoryCache$TargetHistory> it = linkedList.iterator();
        m.checkNotNullExpressionValue(it, "iterator()");
        while (true) {
            if (!it.hasNext()) {
                mGPreferenceSearchHistoryCache$TargetHistory = null;
                break;
            }
            MGPreferenceSearchHistoryCache$TargetHistory next = it.next();
            m.checkNotNullExpressionValue(next, "targetsIter.next()");
            mGPreferenceSearchHistoryCache$TargetHistory = next;
            if (m.areEqual(mGPreferenceSearchHistoryCache$TargetHistory.getSearchTarget(), storeSearch$SearchTarget)) {
                it.remove();
                break;
            }
        }
        if (mGPreferenceSearchHistoryCache$TargetHistory == null) {
            mGPreferenceSearchHistoryCache$TargetHistory = new MGPreferenceSearchHistoryCache$TargetHistory(storeSearch$SearchTarget, new LinkedList());
        }
        Iterator<List<QueryNode>> it2 = mGPreferenceSearchHistoryCache$TargetHistory.getRecentQueries().iterator();
        m.checkNotNullExpressionValue(it2, "targetHistory.recentQueries.iterator()");
        while (it2.hasNext()) {
            List<QueryNode> next2 = it2.next();
            m.checkNotNullExpressionValue(next2, "queriesIter.next()");
            if (m.areEqual(next2, list)) {
                it2.remove();
            }
        }
        mGPreferenceSearchHistoryCache$TargetHistory.getRecentQueries().push(list);
        linkedList.push(new MGPreferenceSearchHistoryCache$TargetHistory(storeSearch$SearchTarget, new LinkedList(u.take(mGPreferenceSearchHistoryCache$TargetHistory.getRecentQueries(), this.MAX_QUERIES_PER_TARGET))));
        return new LinkedList<>(u.take(linkedList, this.MAX_SEARCH_TARGETS));
    }

    private final LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> removeAndCopy(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList, StoreSearch$SearchTarget storeSearch$SearchTarget) {
        Iterator<MGPreferenceSearchHistoryCache$TargetHistory> it = linkedList.iterator();
        m.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            MGPreferenceSearchHistoryCache$TargetHistory next = it.next();
            m.checkNotNullExpressionValue(next, "iter.next()");
            if (m.areEqual(next.getSearchTarget(), storeSearch$SearchTarget)) {
                it.remove();
                break;
            }
        }
        return new LinkedList<>(linkedList);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void clear(StoreSearch$SearchTarget searchTarget) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        Observable<R> observableG = this.backingCache.getObservable().Z(1).G(new MGPreferenceSearchHistoryCache$clear$1(this, searchTarget));
        m.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…veAndCopy(searchTarget) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, (Context) null, "clear history", (Function1) null, new MGPreferenceSearchHistoryCache$clear$2(this), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public Observable<Collection<List<QueryNode>>> getHistory(StoreSearch$SearchTarget searchTarget) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        Observable observableG = this.backingCache.getObservable().G(new MGPreferenceSearchHistoryCache$getHistory$1(this, searchTarget));
        m.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…{ it.find(searchTarget) }");
        return observableG;
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void persistQuery(StoreSearch$SearchTarget searchTarget, List<? extends QueryNode> query) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        m.checkNotNullParameter(query, "query");
        Observable<R> observableG = this.backingCache.getObservable().Z(1).G(new MGPreferenceSearchHistoryCache$persistQuery$1(this, searchTarget, query));
        m.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…py(searchTarget, query) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, (Context) null, "persist query", (Function1) null, new MGPreferenceSearchHistoryCache$persistQuery$2(this), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }
}
