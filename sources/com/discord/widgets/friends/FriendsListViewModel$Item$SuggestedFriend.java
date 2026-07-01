package com.discord.widgets.friends;

import b.d.b.a.a;
import com.discord.models.friendsuggestions.FriendSuggestion;
import d0.z.d.m;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Item$SuggestedFriend extends FriendsListViewModel$Item {
    private final String key;
    private final FriendSuggestion suggestion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$Item$SuggestedFriend(FriendSuggestion friendSuggestion) {
        super(5, null);
        m.checkNotNullParameter(friendSuggestion, "suggestion");
        this.suggestion = friendSuggestion;
        this.key = getType() + " -- " + friendSuggestion.getUser().getId();
    }

    public static /* synthetic */ FriendsListViewModel$Item$SuggestedFriend copy$default(FriendsListViewModel$Item$SuggestedFriend friendsListViewModel$Item$SuggestedFriend, FriendSuggestion friendSuggestion, int i, Object obj) {
        if ((i & 1) != 0) {
            friendSuggestion = friendsListViewModel$Item$SuggestedFriend.suggestion;
        }
        return friendsListViewModel$Item$SuggestedFriend.copy(friendSuggestion);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FriendSuggestion getSuggestion() {
        return this.suggestion;
    }

    public final FriendsListViewModel$Item$SuggestedFriend copy(FriendSuggestion suggestion) {
        m.checkNotNullParameter(suggestion, "suggestion");
        return new FriendsListViewModel$Item$SuggestedFriend(suggestion);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FriendsListViewModel$Item$SuggestedFriend) && m.areEqual(this.suggestion, ((FriendsListViewModel$Item$SuggestedFriend) other).suggestion);
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final FriendSuggestion getSuggestion() {
        return this.suggestion;
    }

    public int hashCode() {
        FriendSuggestion friendSuggestion = this.suggestion;
        if (friendSuggestion != null) {
            return friendSuggestion.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("SuggestedFriend(suggestion=");
        sbU.append(this.suggestion);
        sbU.append(")");
        return sbU.toString();
    }
}
