package com.discord.widgets.channels.invite;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GroupInviteFriendsSheetViewModel$StoreState {
    private final Channel channel;
    private final Map<Long, User> friendUsersMap;

    public GroupInviteFriendsSheetViewModel$StoreState() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GroupInviteFriendsSheetViewModel$StoreState(Map<Long, ? extends User> map, Channel channel) {
        m.checkNotNullParameter(map, "friendUsersMap");
        this.friendUsersMap = map;
        this.channel = channel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupInviteFriendsSheetViewModel$StoreState copy$default(GroupInviteFriendsSheetViewModel$StoreState groupInviteFriendsSheetViewModel$StoreState, Map map, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            map = groupInviteFriendsSheetViewModel$StoreState.friendUsersMap;
        }
        if ((i & 2) != 0) {
            channel = groupInviteFriendsSheetViewModel$StoreState.channel;
        }
        return groupInviteFriendsSheetViewModel$StoreState.copy(map, channel);
    }

    public final Map<Long, User> component1() {
        return this.friendUsersMap;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final GroupInviteFriendsSheetViewModel$StoreState copy(Map<Long, ? extends User> friendUsersMap, Channel channel) {
        m.checkNotNullParameter(friendUsersMap, "friendUsersMap");
        return new GroupInviteFriendsSheetViewModel$StoreState(friendUsersMap, channel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupInviteFriendsSheetViewModel$StoreState)) {
            return false;
        }
        GroupInviteFriendsSheetViewModel$StoreState groupInviteFriendsSheetViewModel$StoreState = (GroupInviteFriendsSheetViewModel$StoreState) other;
        return m.areEqual(this.friendUsersMap, groupInviteFriendsSheetViewModel$StoreState.friendUsersMap) && m.areEqual(this.channel, groupInviteFriendsSheetViewModel$StoreState.channel);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, User> getFriendUsersMap() {
        return this.friendUsersMap;
    }

    public int hashCode() {
        Map<Long, User> map = this.friendUsersMap;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Channel channel = this.channel;
        return iHashCode + (channel != null ? channel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(friendUsersMap=");
        sbU.append(this.friendUsersMap);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ GroupInviteFriendsSheetViewModel$StoreState(Map map, Channel channel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? h0.emptyMap() : map, (i & 2) != 0 ? null : channel);
    }
}
