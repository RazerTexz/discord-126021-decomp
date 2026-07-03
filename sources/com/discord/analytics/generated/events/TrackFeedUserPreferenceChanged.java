package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.loadId, trackFeedUserPreferenceChanged.loadId) && C12238m.areEqual(this.operation, trackFeedUserPreferenceChanged.operation) && C12238m.areEqual(this.preference, trackFeedUserPreferenceChanged.preference) && C12238m.areEqual(this.entityType, trackFeedUserPreferenceChanged.entityType) && C12238m.areEqual(this.messageId, trackFeedUserPreferenceChanged.messageId) && C12238m.areEqual(this.targetUserId, trackFeedUserPreferenceChanged.targetUserId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackFeedUserPreferenceChanged(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", operation=");
        sbM833U.append(this.operation);
        sbM833U.append(", preference=");
        sbM833U.append(this.preference);
        sbM833U.append(", entityType=");
        sbM833U.append(this.entityType);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", targetUserId=");
        return C1643a.m819G(sbM833U, this.targetUserId, ")");
    }
}
