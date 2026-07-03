package com.discord.utilities.search.history;

import com.discord.stores.StoreSearch;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.search.query.node.QueryNode;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

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
            C12238m.checkNotNullParameter(searchTarget, "searchTarget");
            C12238m.checkNotNullParameter(linkedList, "recentQueries");
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
            C12238m.checkNotNullParameter(searchTarget, "searchTarget");
            C12238m.checkNotNullParameter(recentQueries, "recentQueries");
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
            return C12238m.areEqual(this.searchTarget, targetHistory.searchTarget) && C12238m.areEqual(this.recentQueries, targetHistory.recentQueries);
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
            StringBuilder sbM833U = C1643a.m833U("TargetHistory(searchTarget=");
            sbM833U.append(this.searchTarget);
            sbM833U.append(", recentQueries=");
            sbM833U.append(this.recentQueries);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$clear$2 */
    /* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
    public static final class C69002 extends AbstractC12240o implements Function1<LinkedList<TargetHistory>, Unit> {
        public C69002() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persister = MGPreferenceSearchHistoryCache.this.backingCache;
            C12238m.checkNotNullExpressionValue(linkedList, "it");
            Persister.set$default(persister, linkedList, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$persistQuery$2 */
    /* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
    public static final class C69032 extends AbstractC12240o implements Function1<LinkedList<TargetHistory>, Unit> {
        public C69032() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persister = MGPreferenceSearchHistoryCache.this.backingCache;
            C12238m.checkNotNullExpressionValue(linkedList, "it");
            Persister.set$default(persister, linkedList, false, 2, null);
        }
    }

    private final LinkedList<List<QueryNode>> find(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget) {
        Iterator<TargetHistory> it = linkedList.iterator();
        C12238m.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            TargetHistory next = it.next();
            C12238m.checkNotNullExpressionValue(next, "iter.next()");
            TargetHistory targetHistory = next;
            if (C12238m.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                return targetHistory.getRecentQueries();
            }
        }
        return new LinkedList<>();
    }

    private final LinkedList<TargetHistory> putAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> list) {
        TargetHistory targetHistory;
        Iterator<TargetHistory> it = linkedList.iterator();
        C12238m.checkNotNullExpressionValue(it, "iterator()");
        while (true) {
            if (!it.hasNext()) {
                targetHistory = null;
                break;
            }
            TargetHistory next = it.next();
            C12238m.checkNotNullExpressionValue(next, "targetsIter.next()");
            targetHistory = next;
            if (C12238m.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        if (targetHistory == null) {
            targetHistory = new TargetHistory(searchTarget, new LinkedList());
        }
        Iterator<List<QueryNode>> it2 = targetHistory.getRecentQueries().iterator();
        C12238m.checkNotNullExpressionValue(it2, "targetHistory.recentQueries.iterator()");
        while (it2.hasNext()) {
            List<QueryNode> next2 = it2.next();
            C12238m.checkNotNullExpressionValue(next2, "queriesIter.next()");
            if (C12238m.areEqual(next2, list)) {
                it2.remove();
            }
        }
        targetHistory.getRecentQueries().push(list);
        linkedList.push(new TargetHistory(searchTarget, new LinkedList(C12163u.take(targetHistory.getRecentQueries(), this.MAX_QUERIES_PER_TARGET))));
        return new LinkedList<>(C12163u.take(linkedList, this.MAX_SEARCH_TARGETS));
    }

    private final LinkedList<TargetHistory> removeAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget) {
        Iterator<TargetHistory> it = linkedList.iterator();
        C12238m.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            TargetHistory next = it.next();
            C12238m.checkNotNullExpressionValue(next, "iter.next()");
            if (C12238m.areEqual(next.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        return new LinkedList<>(linkedList);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void clear(final StoreSearch.SearchTarget searchTarget) {
        C12238m.checkNotNullParameter(searchTarget, "searchTarget");
        Observable<R> observableM11083G = this.backingCache.getObservable().m11100Z(1).m11083G(new InterfaceC12589b<LinkedList<TargetHistory>, LinkedList<TargetHistory>>() { // from class: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache.clear.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
                MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
                C12238m.checkNotNullExpressionValue(linkedList, "it");
                return mGPreferenceSearchHistoryCache.removeAndCopy(linkedList, searchTarget);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "backingCache\n        .ge…veAndCopy(searchTarget) }");
        ObservableExtensionsKt.appSubscribe(observableM11083G, (117 & 1) != 0 ? null : null, "clear history", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C69002(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public Observable<Collection<List<QueryNode>>> getHistory(final StoreSearch.SearchTarget searchTarget) {
        C12238m.checkNotNullParameter(searchTarget, "searchTarget");
        Observable observableM11083G = this.backingCache.getObservable().m11083G(new InterfaceC12589b<LinkedList<TargetHistory>, Collection<? extends List<? extends QueryNode>>>() { // from class: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache.getHistory.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Collection<List<QueryNode>> call(LinkedList<TargetHistory> linkedList) {
                MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
                C12238m.checkNotNullExpressionValue(linkedList, "it");
                return mGPreferenceSearchHistoryCache.find(linkedList, searchTarget);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "backingCache\n        .ge…{ it.find(searchTarget) }");
        return observableM11083G;
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void persistQuery(final StoreSearch.SearchTarget searchTarget, final List<? extends QueryNode> query) {
        C12238m.checkNotNullParameter(searchTarget, "searchTarget");
        C12238m.checkNotNullParameter(query, "query");
        Observable<R> observableM11083G = this.backingCache.getObservable().m11100Z(1).m11083G(new InterfaceC12589b<LinkedList<TargetHistory>, LinkedList<TargetHistory>>() { // from class: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache.persistQuery.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
                MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
                C12238m.checkNotNullExpressionValue(linkedList, "it");
                return mGPreferenceSearchHistoryCache.putAndCopy(linkedList, searchTarget, query);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "backingCache\n        .ge…py(searchTarget, query) }");
        ObservableExtensionsKt.appSubscribe(observableM11083G, (117 & 1) != 0 ? null : null, "persist query", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C69032(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }
}
