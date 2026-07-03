package com.discord.analytics.generated.events.impression;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.generated.traits.TrackImpressionMetadataReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackImpressionInviteAccept.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImpressionInviteAccept implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver, TrackImpressionMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence deeplinkAttemptId;
    private final CharSequence inviteCode;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;

    public TrackImpressionInviteAccept() {
        this(null, null, 3);
    }

    public TrackImpressionInviteAccept(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2 = i & 2;
        this.inviteCode = (i & 1) != 0 ? null : charSequence;
        this.deeplinkAttemptId = null;
        this.analyticsSchemaTypeName = "impression_invite_accept";
    }

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
        if (!(other instanceof TrackImpressionInviteAccept)) {
            return false;
        }
        TrackImpressionInviteAccept trackImpressionInviteAccept = (TrackImpressionInviteAccept) other;
        return C12238m.areEqual(this.inviteCode, trackImpressionInviteAccept.inviteCode) && C12238m.areEqual(this.deeplinkAttemptId, trackImpressionInviteAccept.deeplinkAttemptId);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.deeplinkAttemptId;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackImpressionInviteAccept(inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", deeplinkAttemptId=");
        return C1643a.m817E(sbM833U, this.deeplinkAttemptId, ")");
    }
}
