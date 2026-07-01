package com.discord.analytics.generated.events.network_action;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNetworkActionHubEmailVerifySend.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionHubEmailVerifySend implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Boolean hasMatchingGuild;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionHubEmailVerifySend(Boolean bool) {
        this.hasMatchingGuild = bool;
        this.analyticsSchemaTypeName = "network_action_hub_email_verify_send";
    }

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver
    public void b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackNetworkActionHubEmailVerifySend) && m.areEqual(this.hasMatchingGuild, ((TrackNetworkActionHubEmailVerifySend) other).hasMatchingGuild);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.hasMatchingGuild;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.D(a.U("TrackNetworkActionHubEmailVerifySend(hasMatchingGuild="), this.hasMatchingGuild, ")");
    }

    public TrackNetworkActionHubEmailVerifySend() {
        this(null);
    }
}
