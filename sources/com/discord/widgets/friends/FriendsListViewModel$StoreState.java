package com.discord.widgets.friends;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.friendsuggestions.FriendSuggestion;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreUserRelationships$UserRelationshipsState;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$StoreState {
    private final Map<Long, ModelApplicationStream> applicationStreams;
    private final long channelId;
    private final Map<Long, FriendSuggestion> friendSuggestions;
    private final Map<Long, Presence> presences;
    private final StoreUserRelationships$UserRelationshipsState relationshipsState;
    private final boolean showContactSyncIcon;
    private final boolean showContactSyncUpsell;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public FriendsListViewModel$StoreState(boolean z2, boolean z3, long j, StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsState, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, Map<Long, FriendSuggestion> map4) {
        m.checkNotNullParameter(storeUserRelationships$UserRelationshipsState, "relationshipsState");
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(map2, "presences");
        m.checkNotNullParameter(map3, "applicationStreams");
        m.checkNotNullParameter(map4, "friendSuggestions");
        this.showContactSyncIcon = z2;
        this.showContactSyncUpsell = z3;
        this.channelId = j;
        this.relationshipsState = storeUserRelationships$UserRelationshipsState;
        this.users = map;
        this.presences = map2;
        this.applicationStreams = map3;
        this.friendSuggestions = map4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FriendsListViewModel$StoreState copy$default(FriendsListViewModel$StoreState friendsListViewModel$StoreState, boolean z2, boolean z3, long j, StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsState, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
        return friendsListViewModel$StoreState.copy((i & 1) != 0 ? friendsListViewModel$StoreState.showContactSyncIcon : z2, (i & 2) != 0 ? friendsListViewModel$StoreState.showContactSyncUpsell : z3, (i & 4) != 0 ? friendsListViewModel$StoreState.channelId : j, (i & 8) != 0 ? friendsListViewModel$StoreState.relationshipsState : storeUserRelationships$UserRelationshipsState, (i & 16) != 0 ? friendsListViewModel$StoreState.users : map, (i & 32) != 0 ? friendsListViewModel$StoreState.presences : map2, (i & 64) != 0 ? friendsListViewModel$StoreState.applicationStreams : map3, (i & 128) != 0 ? friendsListViewModel$StoreState.friendSuggestions : map4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowContactSyncIcon() {
        return this.showContactSyncIcon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowContactSyncUpsell() {
        return this.showContactSyncUpsell;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreUserRelationships$UserRelationshipsState getRelationshipsState() {
        return this.relationshipsState;
    }

    public final Map<Long, User> component5() {
        return this.users;
    }

    public final Map<Long, Presence> component6() {
        return this.presences;
    }

    public final Map<Long, ModelApplicationStream> component7() {
        return this.applicationStreams;
    }

    public final Map<Long, FriendSuggestion> component8() {
        return this.friendSuggestions;
    }

    public final FriendsListViewModel$StoreState copy(boolean showContactSyncIcon, boolean showContactSyncUpsell, long channelId, StoreUserRelationships$UserRelationshipsState relationshipsState, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, Map<Long, FriendSuggestion> friendSuggestions) {
        m.checkNotNullParameter(relationshipsState, "relationshipsState");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(presences, "presences");
        m.checkNotNullParameter(applicationStreams, "applicationStreams");
        m.checkNotNullParameter(friendSuggestions, "friendSuggestions");
        return new FriendsListViewModel$StoreState(showContactSyncIcon, showContactSyncUpsell, channelId, relationshipsState, users, presences, applicationStreams, friendSuggestions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$StoreState)) {
            return false;
        }
        FriendsListViewModel$StoreState friendsListViewModel$StoreState = (FriendsListViewModel$StoreState) other;
        return this.showContactSyncIcon == friendsListViewModel$StoreState.showContactSyncIcon && this.showContactSyncUpsell == friendsListViewModel$StoreState.showContactSyncUpsell && this.channelId == friendsListViewModel$StoreState.channelId && m.areEqual(this.relationshipsState, friendsListViewModel$StoreState.relationshipsState) && m.areEqual(this.users, friendsListViewModel$StoreState.users) && m.areEqual(this.presences, friendsListViewModel$StoreState.presences) && m.areEqual(this.applicationStreams, friendsListViewModel$StoreState.applicationStreams) && m.areEqual(this.friendSuggestions, friendsListViewModel$StoreState.friendSuggestions);
    }

    public final Map<Long, ModelApplicationStream> getApplicationStreams() {
        return this.applicationStreams;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Map<Long, FriendSuggestion> getFriendSuggestions() {
        return this.friendSuggestions;
    }

    public final Map<Long, Presence> getPresences() {
        return this.presences;
    }

    public final StoreUserRelationships$UserRelationshipsState getRelationshipsState() {
        return this.relationshipsState;
    }

    public final boolean getShowContactSyncIcon() {
        return this.showContactSyncIcon;
    }

    public final boolean getShowContactSyncUpsell() {
        return this.showContactSyncUpsell;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        boolean z2 = this.showContactSyncIcon;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.showContactSyncUpsell;
        int iA = (b.a(this.channelId) + ((i + (z3 ? 1 : z3)) * 31)) * 31;
        StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsState = this.relationshipsState;
        int iHashCode = (iA + (storeUserRelationships$UserRelationshipsState != null ? storeUserRelationships$UserRelationshipsState.hashCode() : 0)) * 31;
        Map<Long, User> map = this.users;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Presence> map2 = this.presences;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, FriendSuggestion> map4 = this.friendSuggestions;
        return iHashCode4 + (map4 != null ? map4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(showContactSyncIcon=");
        sbU.append(this.showContactSyncIcon);
        sbU.append(", showContactSyncUpsell=");
        sbU.append(this.showContactSyncUpsell);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", relationshipsState=");
        sbU.append(this.relationshipsState);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", presences=");
        sbU.append(this.presences);
        sbU.append(", applicationStreams=");
        sbU.append(this.applicationStreams);
        sbU.append(", friendSuggestions=");
        return a.M(sbU, this.friendSuggestions, ")");
    }
}
