package com.discord.analytics.generated.events.network_action;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNetworkActionUserCommunicationDisabledUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserCommunicationDisabledUpdate implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
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

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadata2
    public void b(TrackNetworkMetadata trackNetworkMetadata) {
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
        return Intrinsics3.areEqual(this.guildId, trackNetworkActionUserCommunicationDisabledUpdate.guildId) && Intrinsics3.areEqual(this.targetUserId, trackNetworkActionUserCommunicationDisabledUpdate.targetUserId) && Intrinsics3.areEqual(this.duration, trackNetworkActionUserCommunicationDisabledUpdate.duration) && Intrinsics3.areEqual(this.reason, trackNetworkActionUserCommunicationDisabledUpdate.reason) && Intrinsics3.areEqual(this.communicationDisabledUntil, trackNetworkActionUserCommunicationDisabledUpdate.communicationDisabledUntil);
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
        StringBuilder sbU = outline.U("TrackNetworkActionUserCommunicationDisabledUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", targetUserId=");
        sbU.append(this.targetUserId);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", communicationDisabledUntil=");
        return outline.G(sbU, this.communicationDisabledUntil, ")");
    }

    public TrackNetworkActionUserCommunicationDisabledUpdate() {
        this(null, null, null, null, null);
    }
}
