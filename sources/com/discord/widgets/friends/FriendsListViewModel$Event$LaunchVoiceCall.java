package com.discord.widgets.friends;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Event$LaunchVoiceCall extends FriendsListViewModel$Event {
    private final long channelId;

    public FriendsListViewModel$Event$LaunchVoiceCall(long j) {
        super(null);
        this.channelId = j;
    }

    public static /* synthetic */ FriendsListViewModel$Event$LaunchVoiceCall copy$default(FriendsListViewModel$Event$LaunchVoiceCall friendsListViewModel$Event$LaunchVoiceCall, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = friendsListViewModel$Event$LaunchVoiceCall.channelId;
        }
        return friendsListViewModel$Event$LaunchVoiceCall.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final FriendsListViewModel$Event$LaunchVoiceCall copy(long channelId) {
        return new FriendsListViewModel$Event$LaunchVoiceCall(channelId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FriendsListViewModel$Event$LaunchVoiceCall) && this.channelId == ((FriendsListViewModel$Event$LaunchVoiceCall) other).channelId;
        }
        return true;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public int hashCode() {
        return b.a(this.channelId);
    }

    public String toString() {
        return a.C(a.U("LaunchVoiceCall(channelId="), this.channelId, ")");
    }
}
