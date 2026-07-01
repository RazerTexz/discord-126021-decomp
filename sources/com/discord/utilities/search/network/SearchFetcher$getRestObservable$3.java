package com.discord.utilities.search.network;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.stores.StoreSearch$SearchTarget;
import com.discord.utilities.rest.RestAPI;
import j0.k.b;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* JADX INFO: compiled from: SearchFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchFetcher$getRestObservable$3<T, R> implements b<Integer, Observable<? extends ModelSearchResponse>> {
    public final /* synthetic */ Long $oldestMessageId;
    public final /* synthetic */ Map $queryParams;
    public final /* synthetic */ SearchQuery $searchQuery;
    public final /* synthetic */ StoreSearch$SearchTarget $searchTarget;

    public SearchFetcher$getRestObservable$3(StoreSearch$SearchTarget storeSearch$SearchTarget, Long l, Map map, SearchQuery searchQuery) {
        this.$searchTarget = storeSearch$SearchTarget;
        this.$oldestMessageId = l;
        this.$queryParams = map;
        this.$searchQuery = searchQuery;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ModelSearchResponse> call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModelSearchResponse> call2(Integer num) {
        int iOrdinal = this.$searchTarget.getType().ordinal();
        if (iOrdinal == 0) {
            return RestAPI.Companion.getApi().searchGuildMessages(this.$searchTarget.getId(), this.$oldestMessageId, (List) this.$queryParams.get("author_id"), (List) this.$queryParams.get("mentions"), (List) this.$queryParams.get(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID), (List) this.$queryParams.get("has"), (List) this.$queryParams.get("content"), num, Boolean.valueOf(this.$searchQuery.getIncludeNsfw()));
        }
        if (iOrdinal == 1) {
            return RestAPI.Companion.getApi().searchChannelMessages(this.$searchTarget.getId(), this.$oldestMessageId, (List) this.$queryParams.get("author_id"), (List) this.$queryParams.get("mentions"), (List) this.$queryParams.get("has"), (List) this.$queryParams.get("content"), num, Boolean.valueOf(this.$searchQuery.getIncludeNsfw()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
