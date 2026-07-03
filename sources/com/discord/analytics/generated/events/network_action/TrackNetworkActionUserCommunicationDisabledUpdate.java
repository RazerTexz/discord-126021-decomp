package com.discord.analytics.generated.events.network_action;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNetworkActionUserCommunicationDisabledUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserCommunicationDisabledUpdate implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long communicationDisabledUntil;
    private final Float duration;
    private final Long guildId;
    private final CharSequence reason;
    private final Long targetUserId;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionUserCommunicationDisabledUpdate(Long l, Long l2, Float f, CharSequence charSequence, Long l3) {
        this.guildId = l;
        this.targetUserId = l2;
        this.duration = f;
        this.reason = charSequence;
        this.communicationDisabledUntil = l3;
        this.analyticsSchemaTypeName = "network_action_user_communication_disabled_update";
    }

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver
    /* JADX INFO: renamed from: b */
    public void mo7529b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
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
        if (!(other instanceof TrackNetworkActionUserCommunicationDisabledUpdate)) {
            return false;
        }
        TrackNetworkActionUserCommunicationDisabledUpdate trackNetworkActionUserCommunicationDisabledUpdate = (TrackNetworkActionUserCommunicationDisabledUpdate) other;
        return C12238m.areEqual(this.guildId, trackNetworkActionUserCommunicationDisabledUpdate.guildId) && C12238m.areEqual(this.targetUserId, trackNetworkActionUserCommunicationDisabledUpdate.targetUserId) && C12238m.areEqual(this.duration, trackNetworkActionUserCommunicationDisabledUpdate.duration) && C12238m.areEqual(this.reason, trackNetworkActionUserCommunicationDisabledUpdate.reason) && C12238m.areEqual(this.communicationDisabledUntil, trackNetworkActionUserCommunicationDisabledUpdate.communicationDisabledUntil);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.targetUserId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Float f = this.duration;
        int iHashCode3 = (iHashCode2 + (f != null ? f.hashCode() : 0)) * 31;
        CharSequence charSequence = this.reason;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.communicationDisabledUntil;
        return iHashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNetworkActionUserCommunicationDisabledUpdate(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", targetUserId=");
        sbM833U.append(this.targetUserId);
        sbM833U.append(", duration=");
        sbM833U.append(this.duration);
        sbM833U.append(", reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", communicationDisabledUntil=");
        return C1643a.m819G(sbM833U, this.communicationDisabledUntil, ")");
    }

    public TrackNetworkActionUserCommunicationDisabledUpdate() {
        this(null, null, null, null, null);
    }
}
