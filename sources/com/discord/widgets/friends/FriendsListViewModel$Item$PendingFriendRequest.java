package com.discord.widgets.friends;

import b.d.b.a.a;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Item$PendingFriendRequest extends FriendsListViewModel$Item {
    private final String key;
    private final Presence presence;
    private final int relationshipType;
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$Item$PendingFriendRequest(User user, Presence presence, int i) {
        super(1, null);
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.presence = presence;
        this.relationshipType = i;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(user.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ FriendsListViewModel$Item$PendingFriendRequest copy$default(FriendsListViewModel$Item$PendingFriendRequest friendsListViewModel$Item$PendingFriendRequest, User user, Presence presence, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            user = friendsListViewModel$Item$PendingFriendRequest.user;
        }
        if ((i2 & 2) != 0) {
            presence = friendsListViewModel$Item$PendingFriendRequest.presence;
        }
        if ((i2 & 4) != 0) {
            i = friendsListViewModel$Item$PendingFriendRequest.relationshipType;
        }
        return friendsListViewModel$Item$PendingFriendRequest.copy(user, presence, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRelationshipType() {
        return this.relationshipType;
    }

    public final FriendsListViewModel$Item$PendingFriendRequest copy(User user, Presence presence, int relationshipType) {
        m.checkNotNullParameter(user, "user");
        return new FriendsListViewModel$Item$PendingFriendRequest(user, presence, relationshipType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$Item$PendingFriendRequest)) {
            return false;
        }
        FriendsListViewModel$Item$PendingFriendRequest friendsListViewModel$Item$PendingFriendRequest = (FriendsListViewModel$Item$PendingFriendRequest) other;
        return m.areEqual(this.user, friendsListViewModel$Item$PendingFriendRequest.user) && m.areEqual(this.presence, friendsListViewModel$Item$PendingFriendRequest.presence) && this.relationshipType == friendsListViewModel$Item$PendingFriendRequest.relationshipType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final int getRelationshipType() {
        return this.relationshipType;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        Presence presence = this.presence;
        return ((iHashCode + (presence != null ? presence.hashCode() : 0)) * 31) + this.relationshipType;
    }

    public String toString() {
        StringBuilder sbU = a.U("PendingFriendRequest(user=");
        sbU.append(this.user);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", relationshipType=");
        return a.B(sbU, this.relationshipType, ")");
    }
}
