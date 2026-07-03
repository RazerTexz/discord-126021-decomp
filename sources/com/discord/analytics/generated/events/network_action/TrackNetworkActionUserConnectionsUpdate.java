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

/* JADX INFO: compiled from: TrackNetworkActionUserConnectionsUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserConnectionsUpdate implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
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
        if (!(other instanceof TrackNetworkActionUserConnectionsUpdate)) {
            return false;
        }
        TrackNetworkActionUserConnectionsUpdate trackNetworkActionUserConnectionsUpdate = (TrackNetworkActionUserConnectionsUpdate) other;
        return C12238m.areEqual(this.name, trackNetworkActionUserConnectionsUpdate.name) && C12238m.areEqual(this.friendSync, trackNetworkActionUserConnectionsUpdate.friendSync) && C12238m.areEqual(this.visibility, trackNetworkActionUserConnectionsUpdate.visibility) && C12238m.areEqual(this.showActivity, trackNetworkActionUserConnectionsUpdate.showActivity);
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
        StringBuilder sbM833U = C1643a.m833U("TrackNetworkActionUserConnectionsUpdate(name=");
        sbM833U.append(this.name);
        sbM833U.append(", friendSync=");
        sbM833U.append(this.friendSync);
        sbM833U.append(", visibility=");
        sbM833U.append(this.visibility);
        sbM833U.append(", showActivity=");
        return C1643a.m816D(sbM833U, this.showActivity, ")");
    }
}
