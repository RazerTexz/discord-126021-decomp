package com.discord.widgets.channels.memberlist.adapter;

import b.d.b.a.a;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelMembersListAdapter$Item$PlaceholderMember extends ChannelMembersListAdapter$Item {
    private final float placeholderSize;

    public ChannelMembersListAdapter$Item$PlaceholderMember(float f) {
        super(ChannelMembersListAdapter$ViewType.LOADING, "", null);
        this.placeholderSize = f;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final float getPlaceholderSize() {
        return this.placeholderSize;
    }

    public static /* synthetic */ ChannelMembersListAdapter$Item$PlaceholderMember copy$default(ChannelMembersListAdapter$Item$PlaceholderMember channelMembersListAdapter$Item$PlaceholderMember, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = channelMembersListAdapter$Item$PlaceholderMember.placeholderSize;
        }
        return channelMembersListAdapter$Item$PlaceholderMember.copy(f);
    }

    public final ChannelMembersListAdapter$Item$PlaceholderMember copy(float placeholderSize) {
        return new ChannelMembersListAdapter$Item$PlaceholderMember(placeholderSize);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChannelMembersListAdapter$Item$PlaceholderMember) && Float.compare(this.placeholderSize, ((ChannelMembersListAdapter$Item$PlaceholderMember) other).placeholderSize) == 0;
        }
        return true;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.placeholderSize);
    }

    public String toString() {
        StringBuilder sbU = a.U("PlaceholderMember(placeholderSize=");
        sbU.append(this.placeholderSize);
        sbU.append(")");
        return sbU.toString();
    }
}
