package com.discord.utilities.search.history;

import b.d.b.a.a;
import com.discord.stores.StoreSearch$SearchTarget;
import com.discord.utilities.search.query.node.QueryNode;
import d0.z.d.m;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MGPreferenceSearchHistoryCache$TargetHistory {
    private final LinkedList<List<QueryNode>> recentQueries;
    private final StoreSearch$SearchTarget searchTarget;

    public MGPreferenceSearchHistoryCache$TargetHistory(StoreSearch$SearchTarget storeSearch$SearchTarget, LinkedList<List<QueryNode>> linkedList) {
        m.checkNotNullParameter(storeSearch$SearchTarget, "searchTarget");
        m.checkNotNullParameter(linkedList, "recentQueries");
        this.searchTarget = storeSearch$SearchTarget;
        this.recentQueries = linkedList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MGPreferenceSearchHistoryCache$TargetHistory copy$default(MGPreferenceSearchHistoryCache$TargetHistory mGPreferenceSearchHistoryCache$TargetHistory, StoreSearch$SearchTarget storeSearch$SearchTarget, LinkedList linkedList, int i, Object obj) {
        if ((i & 1) != 0) {
            storeSearch$SearchTarget = mGPreferenceSearchHistoryCache$TargetHistory.searchTarget;
        }
        if ((i & 2) != 0) {
            linkedList = mGPreferenceSearchHistoryCache$TargetHistory.recentQueries;
        }
        return mGPreferenceSearchHistoryCache$TargetHistory.copy(storeSearch$SearchTarget, linkedList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreSearch$SearchTarget getSearchTarget() {
        return this.searchTarget;
    }

    public final LinkedList<List<QueryNode>> component2() {
        return this.recentQueries;
    }

    public final MGPreferenceSearchHistoryCache$TargetHistory copy(StoreSearch$SearchTarget searchTarget, LinkedList<List<QueryNode>> recentQueries) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        m.checkNotNullParameter(recentQueries, "recentQueries");
        return new MGPreferenceSearchHistoryCache$TargetHistory(searchTarget, recentQueries);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MGPreferenceSearchHistoryCache$TargetHistory)) {
            return false;
        }
        MGPreferenceSearchHistoryCache$TargetHistory mGPreferenceSearchHistoryCache$TargetHistory = (MGPreferenceSearchHistoryCache$TargetHistory) other;
        return m.areEqual(this.searchTarget, mGPreferenceSearchHistoryCache$TargetHistory.searchTarget) && m.areEqual(this.recentQueries, mGPreferenceSearchHistoryCache$TargetHistory.recentQueries);
    }

    public final LinkedList<List<QueryNode>> getRecentQueries() {
        return this.recentQueries;
    }

    public final StoreSearch$SearchTarget getSearchTarget() {
        return this.searchTarget;
    }

    public int hashCode() {
        StoreSearch$SearchTarget storeSearch$SearchTarget = this.searchTarget;
        int iHashCode = (storeSearch$SearchTarget != null ? storeSearch$SearchTarget.hashCode() : 0) * 31;
        LinkedList<List<QueryNode>> linkedList = this.recentQueries;
        return iHashCode + (linkedList != null ? linkedList.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TargetHistory(searchTarget=");
        sbU.append(this.searchTarget);
        sbU.append(", recentQueries=");
        sbU.append(this.recentQueries);
        sbU.append(")");
        return sbU.toString();
    }
}
