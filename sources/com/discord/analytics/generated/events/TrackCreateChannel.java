package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuildLfgGroup;
import com.discord.analytics.generated.traits.TrackGuildLfgGroupReceiver;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroupReceiver;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThreadReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCreateChannel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreateChannel implements AnalyticsSchema, TrackBaseReceiver, TrackLfgGroupReceiver, TrackGuildLfgGroupReceiver, TrackThreadReceiver {
    private TrackBase trackBase;
    private TrackGuildLfgGroup trackGuildLfgGroup;
    private TrackLfgGroup trackLfgGroup;
    private TrackThread trackThread;
    private final Long channelId = null;
    private final Long channelType = null;
    private final List<Long> recipientIds = null;
    private final Long originChannelId = null;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final CharSequence channelName = null;
    private final Boolean isNsfw = null;
    private final Long parentId = null;
    private final Long starterMessageAgeMinutes = null;
    private final Long activeThreadCount = null;
    private final Long activeAnnouncementThreadCount = null;
    private final transient String analyticsSchemaTypeName = "create_channel";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreateChannel)) {
            return false;
        }
        TrackCreateChannel trackCreateChannel = (TrackCreateChannel) other;
        return C12238m.areEqual(this.channelId, trackCreateChannel.channelId) && C12238m.areEqual(this.channelType, trackCreateChannel.channelType) && C12238m.areEqual(this.recipientIds, trackCreateChannel.recipientIds) && C12238m.areEqual(this.originChannelId, trackCreateChannel.originChannelId) && C12238m.areEqual(this.guildId, trackCreateChannel.guildId) && C12238m.areEqual(this.guildName, trackCreateChannel.guildName) && C12238m.areEqual(this.channelName, trackCreateChannel.channelName) && C12238m.areEqual(this.isNsfw, trackCreateChannel.isNsfw) && C12238m.areEqual(this.parentId, trackCreateChannel.parentId) && C12238m.areEqual(this.starterMessageAgeMinutes, trackCreateChannel.starterMessageAgeMinutes) && C12238m.areEqual(this.activeThreadCount, trackCreateChannel.activeThreadCount) && C12238m.areEqual(this.activeAnnouncementThreadCount, trackCreateChannel.activeAnnouncementThreadCount);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Long l3 = this.originChannelId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode6 = (iHashCode5 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.channelName;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.isNsfw;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l5 = this.parentId;
        int iHashCode9 = (iHashCode8 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.starterMessageAgeMinutes;
        int iHashCode10 = (iHashCode9 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.activeThreadCount;
        int iHashCode11 = (iHashCode10 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.activeAnnouncementThreadCount;
        return iHashCode11 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackCreateChannel(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", recipientIds=");
        sbM833U.append(this.recipientIds);
        sbM833U.append(", originChannelId=");
        sbM833U.append(this.originChannelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", channelName=");
        sbM833U.append(this.channelName);
        sbM833U.append(", isNsfw=");
        sbM833U.append(this.isNsfw);
        sbM833U.append(", parentId=");
        sbM833U.append(this.parentId);
        sbM833U.append(", starterMessageAgeMinutes=");
        sbM833U.append(this.starterMessageAgeMinutes);
        sbM833U.append(", activeThreadCount=");
        sbM833U.append(this.activeThreadCount);
        sbM833U.append(", activeAnnouncementThreadCount=");
        return C1643a.m819G(sbM833U, this.activeAnnouncementThreadCount, ")");
    }
}
