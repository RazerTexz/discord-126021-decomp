package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackFeedUserPreferenceChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFeedUserPreferenceChanged implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence loadId = null;
    private final CharSequence operation = null;
    private final Long preference = null;
    private final CharSequence entityType = null;
    private final Long messageId = null;
    private final Long targetUserId = null;
    private final transient String analyticsSchemaTypeName = "feed_user_preference_changed";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFeedUserPreferenceChanged)) {
            return false;
        }
        TrackFeedUserPreferenceChanged trackFeedUserPreferenceChanged = (TrackFeedUserPreferenceChanged) other;
        return m.areEqual(this.loadId, trackFeedUserPreferenceChanged.loadId) && m.areEqual(this.operation, trackFeedUserPreferenceChanged.operation) && m.areEqual(this.preference, trackFeedUserPreferenceChanged.preference) && m.areEqual(this.entityType, trackFeedUserPreferenceChanged.entityType) && m.areEqual(this.messageId, trackFeedUserPreferenceChanged.messageId) && m.areEqual(this.targetUserId, trackFeedUserPreferenceChanged.targetUserId);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.operation;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.preference;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.entityType;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.targetUserId;
        return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackFeedUserPreferenceChanged(loadId=");
        sbU.append(this.loadId);
        sbU.append(", operation=");
        sbU.append(this.operation);
        sbU.append(", preference=");
        sbU.append(this.preference);
        sbU.append(", entityType=");
        sbU.append(this.entityType);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", targetUserId=");
        return a.G(sbU, this.targetUserId, ")");
    }
}
