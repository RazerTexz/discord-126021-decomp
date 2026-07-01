package com.discord.stores;

import com.discord.api.friendsuggestions.FriendSuggestionDelete;
import com.discord.api.friendsuggestions.FriendSuggestionReason;
import com.discord.models.domain.ModelPayload;
import com.discord.models.friendsuggestions.FriendSuggestion;
import com.discord.models.user.CoreUser;
import com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreFriendSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreFriendSuggestions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final FriendSuggestionsFetcher friendSuggestionsFetcher;
    private final StoreStream storeStream;
    private final Map<Long, FriendSuggestion> suggestions;
    private Map<Long, FriendSuggestion> suggestionsSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreFriendSuggestions$updateFriendSuggestions$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreFriendSuggestions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $suggestions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$suggestions = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreFriendSuggestions.this.storeStream.handleFriendSuggestionsLoaded(this.$suggestions);
        }
    }

    public StoreFriendSuggestions(StoreStream storeStream, Dispatcher dispatcher, FriendSuggestionsFetcher friendSuggestionsFetcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(friendSuggestionsFetcher, "friendSuggestionsFetcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.friendSuggestionsFetcher = friendSuggestionsFetcher;
        this.suggestions = new HashMap();
        this.suggestionsSnapshot = Maps6.emptyMap();
    }

    private final FriendSuggestion convertApiFriendSuggestion(com.discord.api.friendsuggestions.FriendSuggestion apiFriendSuggestion) {
        CoreUser coreUser = new CoreUser(apiFriendSuggestion.getSuggestedUser());
        FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) _Collections.firstOrNull((List) apiFriendSuggestion.a());
        return new FriendSuggestion(coreUser, friendSuggestionReason != null ? friendSuggestionReason.getName() : null);
    }

    public final Map<Long, FriendSuggestion> getFriendSuggestions() {
        return this.suggestionsSnapshot;
    }

    public final FriendSuggestionsFetcher getFriendSuggestionsFetcher() {
        return this.friendSuggestionsFetcher;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload readyPayload) {
        Intrinsics3.checkNotNullParameter(readyPayload, "readyPayload");
        this.suggestions.clear();
        if (readyPayload.getFriendSuggestionCount() > 0) {
            this.friendSuggestionsFetcher.maybeFetch();
        }
        markChanged();
    }

    @Store3
    public final void handleFriendSuggestionCreate(com.discord.api.friendsuggestions.FriendSuggestion friendSuggestionCreate) {
        Intrinsics3.checkNotNullParameter(friendSuggestionCreate, "friendSuggestionCreate");
        CoreUser coreUser = new CoreUser(friendSuggestionCreate.getSuggestedUser());
        FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) _Collections.firstOrNull((List) friendSuggestionCreate.a());
        FriendSuggestion friendSuggestion = new FriendSuggestion(coreUser, friendSuggestionReason != null ? friendSuggestionReason.getName() : null);
        this.suggestions.put(Long.valueOf(friendSuggestion.getUser().getId()), friendSuggestion);
        markChanged();
    }

    @Store3
    public final void handleFriendSuggestionDelete(FriendSuggestionDelete friendSuggestionDelete) {
        Intrinsics3.checkNotNullParameter(friendSuggestionDelete, "friendSuggestionDelete");
        if (this.suggestions.remove(Long.valueOf(friendSuggestionDelete.getSuggestedUserId())) != null) {
            markChanged();
        }
    }

    @Store3
    public final void handleFriendSuggestionsLoadFailure() {
        this.suggestions.clear();
        markChanged();
    }

    @Store3
    public final void handleFriendSuggestionsLoaded(List<com.discord.api.friendsuggestions.FriendSuggestion> loadedSuggestions) {
        Intrinsics3.checkNotNullParameter(loadedSuggestions, "loadedSuggestions");
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
        Intrinsics3.checkNotNullParameter(suggestions, "suggestions");
        this.dispatcher.schedule(new AnonymousClass1(suggestions));
    }
}
