package com.discord.utilities.search.network.state;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadMember;
import com.discord.models.message.Message;
import com.discord.utilities.search.network.SearchQuery;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SearchState {
    private final boolean hasMore;
    private final List<Message> hits;
    private final QueryFetchState queryFetchState;
    private final SearchQuery searchQuery;
    private final List<ThreadMember> threadMembers;
    private final List<Channel> threads;
    private final int totalResults;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchState(QueryFetchState queryFetchState, SearchQuery searchQuery, List<Channel> list, List<? extends ThreadMember> list2, List<Message> list3, boolean z2, int i) {
        Intrinsics3.checkNotNullParameter(queryFetchState, "queryFetchState");
        this.queryFetchState = queryFetchState;
        this.searchQuery = searchQuery;
        this.threads = list;
        this.threadMembers = list2;
        this.hits = list3;
        this.hasMore = z2;
        this.totalResults = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchState copy$default(SearchState searchState, QueryFetchState queryFetchState, SearchQuery searchQuery, List list, List list2, List list3, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            queryFetchState = searchState.queryFetchState;
        }
        if ((i2 & 2) != 0) {
            searchQuery = searchState.searchQuery;
        }
        SearchQuery searchQuery2 = searchQuery;
        if ((i2 & 4) != 0) {
            list = searchState.threads;
        }
        List list4 = list;
        if ((i2 & 8) != 0) {
            list2 = searchState.threadMembers;
        }
        List list5 = list2;
        if ((i2 & 16) != 0) {
            list3 = searchState.hits;
        }
        List list6 = list3;
        if ((i2 & 32) != 0) {
            z2 = searchState.hasMore;
        }
        boolean z3 = z2;
        if ((i2 & 64) != 0) {
            i = searchState.totalResults;
        }
        return searchState.copy(queryFetchState, searchQuery2, list4, list5, list6, z3, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final QueryFetchState getQueryFetchState() {
        return this.queryFetchState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SearchQuery getSearchQuery() {
        return this.searchQuery;
    }

    public final List<Channel> component3() {
        return this.threads;
    }

    public final List<ThreadMember> component4() {
        return this.threadMembers;
    }

    public final List<Message> component5() {
        return this.hits;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getTotalResults() {
        return this.totalResults;
    }

    public final SearchState copy(QueryFetchState queryFetchState, SearchQuery searchQuery, List<Channel> threads, List<? extends ThreadMember> threadMembers, List<Message> hits, boolean hasMore, int totalResults) {
        Intrinsics3.checkNotNullParameter(queryFetchState, "queryFetchState");
        return new SearchState(queryFetchState, searchQuery, threads, threadMembers, hits, hasMore, totalResults);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchState)) {
            return false;
        }
        SearchState searchState = (SearchState) other;
        return Intrinsics3.areEqual(this.queryFetchState, searchState.queryFetchState) && Intrinsics3.areEqual(this.searchQuery, searchState.searchQuery) && Intrinsics3.areEqual(this.threads, searchState.threads) && Intrinsics3.areEqual(this.threadMembers, searchState.threadMembers) && Intrinsics3.areEqual(this.hits, searchState.hits) && this.hasMore == searchState.hasMore && this.totalResults == searchState.totalResults;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<Message> getHits() {
        return this.hits;
    }

    public final QueryFetchState getQueryFetchState() {
        return this.queryFetchState;
    }

    public final SearchQuery getSearchQuery() {
        return this.searchQuery;
    }

    public final List<ThreadMember> getThreadMembers() {
        return this.threadMembers;
    }

    public final List<Channel> getThreads() {
        return this.threads;
    }

    public final int getTotalResults() {
        return this.totalResults;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        QueryFetchState queryFetchState = this.queryFetchState;
        int iHashCode = (queryFetchState != null ? queryFetchState.hashCode() : 0) * 31;
        SearchQuery searchQuery = this.searchQuery;
        int iHashCode2 = (iHashCode + (searchQuery != null ? searchQuery.hashCode() : 0)) * 31;
        List<Channel> list = this.threads;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<ThreadMember> list2 = this.threadMembers;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Message> list3 = this.hits;
        int iHashCode5 = (iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z2 = this.hasMore;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return ((iHashCode5 + r1) * 31) + this.totalResults;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SearchState(queryFetchState=");
        sbU.append(this.queryFetchState);
        sbU.append(", searchQuery=");
        sbU.append(this.searchQuery);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", threadMembers=");
        sbU.append(this.threadMembers);
        sbU.append(", hits=");
        sbU.append(this.hits);
        sbU.append(", hasMore=");
        sbU.append(this.hasMore);
        sbU.append(", totalResults=");
        return outline.B(sbU, this.totalResults, ")");
    }

    public /* synthetic */ SearchState(QueryFetchState queryFetchState, SearchQuery searchQuery, List list, List list2, List list3, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(queryFetchState, (i2 & 2) != 0 ? null : searchQuery, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : list2, (i2 & 16) == 0 ? list3 : null, (i2 & 32) != 0 ? false : z2, (i2 & 64) == 0 ? i : 0);
    }
}
