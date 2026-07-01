package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreChannelsSelected$UserChannelSelection$SelectedChannel extends StoreChannelsSelected$UserChannelSelection {
    private final SelectedChannelAnalyticsLocation analyticsLocation;
    private final long channelId;
    private final Long peekParent;

    public /* synthetic */ StoreChannelsSelected$UserChannelSelection$SelectedChannel(long j, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : selectedChannelAnalyticsLocation);
    }

    public static /* synthetic */ StoreChannelsSelected$UserChannelSelection$SelectedChannel copy$default(StoreChannelsSelected$UserChannelSelection$SelectedChannel storeChannelsSelected$UserChannelSelection$SelectedChannel, long j, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeChannelsSelected$UserChannelSelection$SelectedChannel.channelId;
        }
        if ((i & 2) != 0) {
            l = storeChannelsSelected$UserChannelSelection$SelectedChannel.peekParent;
        }
        if ((i & 4) != 0) {
            selectedChannelAnalyticsLocation = storeChannelsSelected$UserChannelSelection$SelectedChannel.analyticsLocation;
        }
        return storeChannelsSelected$UserChannelSelection$SelectedChannel.copy(j, l, selectedChannelAnalyticsLocation);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getPeekParent() {
        return this.peekParent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SelectedChannelAnalyticsLocation getAnalyticsLocation() {
        return this.analyticsLocation;
    }

    public final StoreChannelsSelected$UserChannelSelection$SelectedChannel copy(long channelId, Long peekParent, SelectedChannelAnalyticsLocation analyticsLocation) {
        return new StoreChannelsSelected$UserChannelSelection$SelectedChannel(channelId, peekParent, analyticsLocation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreChannelsSelected$UserChannelSelection$SelectedChannel)) {
            return false;
        }
        StoreChannelsSelected$UserChannelSelection$SelectedChannel storeChannelsSelected$UserChannelSelection$SelectedChannel = (StoreChannelsSelected$UserChannelSelection$SelectedChannel) other;
        return this.channelId == storeChannelsSelected$UserChannelSelection$SelectedChannel.channelId && m.areEqual(this.peekParent, storeChannelsSelected$UserChannelSelection$SelectedChannel.peekParent) && m.areEqual(this.analyticsLocation, storeChannelsSelected$UserChannelSelection$SelectedChannel.analyticsLocation);
    }

    public final SelectedChannelAnalyticsLocation getAnalyticsLocation() {
        return this.analyticsLocation;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getPeekParent() {
        return this.peekParent;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        Long l = this.peekParent;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation = this.analyticsLocation;
        return iHashCode + (selectedChannelAnalyticsLocation != null ? selectedChannelAnalyticsLocation.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SelectedChannel(channelId=");
        sbU.append(this.channelId);
        sbU.append(", peekParent=");
        sbU.append(this.peekParent);
        sbU.append(", analyticsLocation=");
        sbU.append(this.analyticsLocation);
        sbU.append(")");
        return sbU.toString();
    }

    public StoreChannelsSelected$UserChannelSelection$SelectedChannel(long j, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
        super(null);
        this.channelId = j;
        this.peekParent = l;
        this.analyticsLocation = selectedChannelAnalyticsLocation;
    }
}
