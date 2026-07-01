package com.discord.utilities.search.history;

import b.d.b.a.outline;
import com.discord.stores.StoreSearch;
import com.discord.utilities.error.Error;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.node.QueryNode;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGPreferenceSearchHistoryCache implements SearchHistoryCache {
    private final int MAX_SEARCH_TARGETS = 10;
    private final int MAX_QUERIES_PER_TARGET = 5;
    private final Persister<LinkedList<TargetHistory>> backingCache = new Persister<>("SEARCH_HISTORY_V2", new LinkedList());

    /* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
    public static final /* data */ class TargetHistory {
        private final LinkedList<List<QueryNode>> recentQueries;
        private final StoreSearch.SearchTarget searchTarget;

        public TargetHistory(StoreSearch.SearchTarget searchTarget, LinkedList<List<QueryNode>> linkedList) {
            Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
            Intrinsics3.checkNotNullParameter(linkedList, "recentQueries");
            this.searchTarget = searchTarget;
            this.recentQueries = linkedList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TargetHistory copy$default(TargetHistory targetHistory, StoreSearch.SearchTarget searchTarget, LinkedList linkedList, int i, Object obj) {
            if ((i & 1) != 0) {
                searchTarget = targetHistory.searchTarget;
            }
            if ((i & 2) != 0) {
                linkedList = targetHistory.recentQueries;
            }
            return targetHistory.copy(searchTarget, linkedList);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreSearch.SearchTarget getSearchTarget() {
            return this.searchTarget;
        }

        public final LinkedList<List<QueryNode>> component2() {
            return this.recentQueries;
        }

        public final TargetHistory copy(StoreSearch.SearchTarget searchTarget, LinkedList<List<QueryNode>> recentQueries) {
            Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
            Intrinsics3.checkNotNullParameter(recentQueries, "recentQueries");
            return new TargetHistory(searchTarget, recentQueries);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TargetHistory)) {
                return false;
            }
            TargetHistory targetHistory = (TargetHistory) other;
            return Intrinsics3.areEqual(this.searchTarget, targetHistory.searchTarget) && Intrinsics3.areEqual(this.recentQueries, targetHistory.recentQueries);
        }

        public final LinkedList<List<QueryNode>> getRecentQueries() {
            return this.recentQueries;
        }

        public final StoreSearch.SearchTarget getSearchTarget() {
            return this.searchTarget;
        }

        public int hashCode() {
            StoreSearch.SearchTarget searchTarget = this.searchTarget;
            int iHashCode = (searchTarget != null ? searchTarget.hashCode() : 0) * 31;
            LinkedList<List<QueryNode>> linkedList = this.recentQueries;
            return iHashCode + (linkedList != null ? linkedList.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("TargetHistory(searchTarget=");
            sbU.append(this.searchTarget);
            sbU.append(", recentQueries=");
            sbU.append(this.recentQueries);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$clear$2, reason: invalid class name */
    /* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<LinkedList<TargetHistory>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persister = MGPreferenceSearchHistoryCache.this.backingCache;
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            Persister.set$default(persister, linkedList, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$persistQuery$2, reason: invalid class name */
    /* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<LinkedList<TargetHistory>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persister = MGPreferenceSearchHistoryCache.this.backingCache;
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            Persister.set$default(persister, linkedList, false, 2, null);
        }
    }

    private final LinkedList<List<QueryNode>> find(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget) {
        Iterator<TargetHistory> it = linkedList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            TargetHistory next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "iter.next()");
            TargetHistory targetHistory = next;
            if (Intrinsics3.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                return targetHistory.getRecentQueries();
            }
        }
        return new LinkedList<>();
    }

    private final LinkedList<TargetHistory> putAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> list) {
        TargetHistory targetHistory;
        Iterator<TargetHistory> it = linkedList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator()");
        while (true) {
            if (!it.hasNext()) {
                targetHistory = null;
                break;
            }
            TargetHistory next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "targetsIter.next()");
            targetHistory = next;
            if (Intrinsics3.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        if (targetHistory == null) {
            targetHistory = new TargetHistory(searchTarget, new LinkedList());
        }
        Iterator<List<QueryNode>> it2 = targetHistory.getRecentQueries().iterator();
        Intrinsics3.checkNotNullExpressionValue(it2, "targetHistory.recentQueries.iterator()");
        while (it2.hasNext()) {
            List<QueryNode> next2 = it2.next();
            Intrinsics3.checkNotNullExpressionValue(next2, "queriesIter.next()");
            if (Intrinsics3.areEqual(next2, list)) {
                it2.remove();
            }
        }
        targetHistory.getRecentQueries().push(list);
        linkedList.push(new TargetHistory(searchTarget, new LinkedList(_Collections.take(targetHistory.getRecentQueries(), this.MAX_QUERIES_PER_TARGET))));
        return new LinkedList<>(_Collections.take(linkedList, this.MAX_SEARCH_TARGETS));
    }

    private final LinkedList<TargetHistory> removeAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget) {
        Iterator<TargetHistory> it = linkedList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            TargetHistory next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "iter.next()");
            if (Intrinsics3.areEqual(next.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        return new LinkedList<>(linkedList);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void clear(final StoreSearch.SearchTarget searchTarget) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Observable<R> observableG = this.backingCache.getObservable().Z(1).G(new Func1<LinkedList<TargetHistory>, LinkedList<TargetHistory>>() { // from class: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache.clear.1
            @Override // j0.k.Func1
            public final LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
                MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
                Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
                return mGPreferenceSearchHistoryCache.removeAndCopy(linkedList, searchTarget);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…veAndCopy(searchTarget) }");
        ObservableExtensionsKt.appSubscribe(observableG, (117 & 1) != 0 ? null : null, "clear history", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass2(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public Observable<Collection<List<QueryNode>>> getHistory(final StoreSearch.SearchTarget searchTarget) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Observable observableG = this.backingCache.getObservable().G(new Func1<LinkedList<TargetHistory>, Collection<? extends List<? extends QueryNode>>>() { // from class: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache.getHistory.1
            @Override // j0.k.Func1
            public final Collection<List<QueryNode>> call(LinkedList<TargetHistory> linkedList) {
                MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
                Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
                return mGPreferenceSearchHistoryCache.find(linkedList, searchTarget);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…{ it.find(searchTarget) }");
        return observableG;
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void persistQuery(final StoreSearch.SearchTarget searchTarget, final List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(query, "query");
        Observable<R> observableG = this.backingCache.getObservable().Z(1).G(new Func1<LinkedList<TargetHistory>, LinkedList<TargetHistory>>() { // from class: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache.persistQuery.1
            @Override // j0.k.Func1
            public final LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
                MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
                Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
                return mGPreferenceSearchHistoryCache.putAndCopy(linkedList, searchTarget, query);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…py(searchTarget, query) }");
        ObservableExtensionsKt.appSubscribe(observableG, (117 & 1) != 0 ? null : null, "persist query", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass2(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }
}
