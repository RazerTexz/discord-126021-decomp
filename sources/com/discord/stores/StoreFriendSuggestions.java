package com.discord.stores;

import com.discord.api.friendsuggestions.FriendSuggestionDelete;
import com.discord.api.friendsuggestions.FriendSuggestionReason;
import com.discord.models.domain.ModelPayload;
import com.discord.models.friendsuggestions.FriendSuggestion;
import com.discord.models.user.CoreUser;
import com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StoreFriendSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreFriendSuggestions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final FriendSuggestionsFetcher friendSuggestionsFetcher;
    private final StoreStream storeStream;
    private final Map<Long, FriendSuggestion> suggestions;
    private Map<Long, FriendSuggestion> suggestionsSnapshot;

    public StoreFriendSuggestions(StoreStream storeStream, Dispatcher dispatcher, FriendSuggestionsFetcher friendSuggestionsFetcher) {
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(friendSuggestionsFetcher, "friendSuggestionsFetcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.friendSuggestionsFetcher = friendSuggestionsFetcher;
        this.suggestions = new HashMap();
        this.suggestionsSnapshot = h0.emptyMap();
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreFriendSuggestions storeFriendSuggestions) {
        return storeFriendSuggestions.storeStream;
    }

    private final FriendSuggestion convertApiFriendSuggestion(com.discord.api.friendsuggestions.FriendSuggestion apiFriendSuggestion) {
        CoreUser coreUser = new CoreUser(apiFriendSuggestion.getSuggestedUser());
        FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) u.firstOrNull((List) apiFriendSuggestion.a());
        return new FriendSuggestion(coreUser, friendSuggestionReason != null ? friendSuggestionReason.getName() : null);
    }

    public final Map<Long, FriendSuggestion> getFriendSuggestions() {
        return this.suggestionsSnapshot;
    }

    public final FriendSuggestionsFetcher getFriendSuggestionsFetcher() {
        return this.friendSuggestionsFetcher;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload readyPayload) {
        m.checkNotNullParameter(readyPayload, "readyPayload");
        this.suggestions.clear();
        if (readyPayload.getFriendSuggestionCount() > 0) {
            this.friendSuggestionsFetcher.maybeFetch();
        }
        markChanged();
    }

    @StoreThread
    public final void handleFriendSuggestionCreate(com.discord.api.friendsuggestions.FriendSuggestion friendSuggestionCreate) {
        m.checkNotNullParameter(friendSuggestionCreate, "friendSuggestionCreate");
        CoreUser coreUser = new CoreUser(friendSuggestionCreate.getSuggestedUser());
        FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) u.firstOrNull((List) friendSuggestionCreate.a());
        FriendSuggestion friendSuggestion = new FriendSuggestion(coreUser, friendSuggestionReason != null ? friendSuggestionReason.getName() : null);
        this.suggestions.put(Long.valueOf(friendSuggestion.getUser().getId()), friendSuggestion);
        markChanged();
    }

    @StoreThread
    public final void handleFriendSuggestionDelete(FriendSuggestionDelete friendSuggestionDelete) {
        m.checkNotNullParameter(friendSuggestionDelete, "friendSuggestionDelete");
        if (this.suggestions.remove(Long.valueOf(friendSuggestionDelete.getSuggestedUserId())) != null) {
            markChanged();
        }
    }

    @StoreThread
    public final void handleFriendSuggestionsLoadFailure() {
        this.suggestions.clear();
        markChanged();
    }

    @StoreThread
    public final void handleFriendSuggestionsLoaded(List<com.discord.api.friendsuggestions.FriendSuggestion> loadedSuggestions) {
        m.checkNotNullParameter(loadedSuggestions, "loadedSuggestions");
        this.suggestions.clear();
        Map<Long, FriendSuggestion> map = this.suggestions;
        for (com.discord.api.friendsuggestions.FriendSuggestion friendSuggestion : loadedSuggestions) {
            map.put(Long.valueOf(friendSuggestion.getSuggestedUser().getId()), convertApiFriendSuggestion(friendSuggestion));
        }
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.suggestionsSnapshot = new HashMap(this.suggestions);
    }

    public final void updateFriendSuggestions(List<com.discord.api.friendsuggestions.FriendSuggestion> suggestions) {
        m.checkNotNullParameter(suggestions, "suggestions");
        this.dispatcher.schedule(new StoreFriendSuggestions$updateFriendSuggestions$1(this, suggestions));
    }
}
