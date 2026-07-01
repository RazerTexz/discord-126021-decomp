package com.discord.widgets.friends;

import b.d.b.a.a;
import com.discord.api.presence.ClientStatus;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.t.n0;
import d0.z.d.m;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Item$Friend extends FriendsListViewModel$Item {
    private final boolean isApplicationStreaming;
    private final String key;
    private final Presence presence;
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$Item$Friend(User user, Presence presence, boolean z2) {
        super(0, null);
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.presence = presence;
        this.isApplicationStreaming = z2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(user.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ FriendsListViewModel$Item$Friend copy$default(FriendsListViewModel$Item$Friend friendsListViewModel$Item$Friend, User user, Presence presence, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = friendsListViewModel$Item$Friend.user;
        }
        if ((i & 2) != 0) {
            presence = friendsListViewModel$Item$Friend.presence;
        }
        if ((i & 4) != 0) {
            z2 = friendsListViewModel$Item$Friend.isApplicationStreaming;
        }
        return friendsListViewModel$Item$Friend.copy(user, presence, z2);
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
    public final boolean getIsApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    public final FriendsListViewModel$Item$Friend copy(User user, Presence presence, boolean isApplicationStreaming) {
        m.checkNotNullParameter(user, "user");
        return new FriendsListViewModel$Item$Friend(user, presence, isApplicationStreaming);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$Item$Friend)) {
            return false;
        }
        FriendsListViewModel$Item$Friend friendsListViewModel$Item$Friend = (FriendsListViewModel$Item$Friend) other;
        return m.areEqual(this.user, friendsListViewModel$Item$Friend.user) && m.areEqual(this.presence, friendsListViewModel$Item$Friend.presence) && this.isApplicationStreaming == friendsListViewModel$Item$Friend.isApplicationStreaming;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        Presence presence = this.presence;
        int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
        boolean z2 = this.isApplicationStreaming;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    public final boolean isOnline() {
        return this.presence != null && n0.setOf((Object[]) new ClientStatus[]{ClientStatus.ONLINE, ClientStatus.IDLE, ClientStatus.DND}).contains(this.presence.getStatus());
    }

    public String toString() {
        StringBuilder sbU = a.U("Friend(user=");
        sbU.append(this.user);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", isApplicationStreaming=");
        return a.O(sbU, this.isApplicationStreaming, ")");
    }
}
