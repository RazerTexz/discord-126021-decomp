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

/* JADX INFO: compiled from: TrackNetworkActionUserConnectionsUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserConnectionsUpdate implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean friendSync;
    private final CharSequence name;
    private final Boolean showActivity;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final Boolean visibility;

    public TrackNetworkActionUserConnectionsUpdate() {
        this(null, null, null, null, 15);
    }

    public TrackNetworkActionUserConnectionsUpdate(CharSequence charSequence, Boolean bool, Boolean bool2, Boolean bool3, int i) {
        charSequence = (i & 1) != 0 ? null : charSequence;
        bool = (i & 2) != 0 ? null : bool;
        int i2 = i & 4;
        int i3 = i & 8;
        this.name = charSequence;
        this.friendSync = bool;
        this.visibility = null;
        this.showActivity = null;
        this.analyticsSchemaTypeName = "network_action_user_connections_update";
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
        if (!(other instanceof TrackNetworkActionUserConnectionsUpdate)) {
            return false;
        }
        TrackNetworkActionUserConnectionsUpdate trackNetworkActionUserConnectionsUpdate = (TrackNetworkActionUserConnectionsUpdate) other;
        return Intrinsics3.areEqual(this.name, trackNetworkActionUserConnectionsUpdate.name) && Intrinsics3.areEqual(this.friendSync, trackNetworkActionUserConnectionsUpdate.friendSync) && Intrinsics3.areEqual(this.visibility, trackNetworkActionUserConnectionsUpdate.visibility) && Intrinsics3.areEqual(this.showActivity, trackNetworkActionUserConnectionsUpdate.showActivity);
    }

    public int hashCode() {
        CharSequence charSequence = this.name;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.friendSync;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.visibility;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.showActivity;
        return iHashCode3 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkActionUserConnectionsUpdate(name=");
        sbU.append(this.name);
        sbU.append(", friendSync=");
        sbU.append(this.friendSync);
        sbU.append(", visibility=");
        sbU.append(this.visibility);
        sbU.append(", showActivity=");
        return outline.D(sbU, this.showActivity, ")");
    }
}
