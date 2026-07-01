package com.discord.analytics.generated.events.network_action;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNetworkActionGuildCreate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionGuildCreate implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean isCommunityIntent;
    private final CharSequence templateName;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionGuildCreate() {
        this.templateName = null;
        this.isCommunityIntent = null;
        this.analyticsSchemaTypeName = "network_action_guild_create";
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
        if (!(other instanceof TrackNetworkActionGuildCreate)) {
            return false;
        }
        TrackNetworkActionGuildCreate trackNetworkActionGuildCreate = (TrackNetworkActionGuildCreate) other;
        return Intrinsics3.areEqual(this.templateName, trackNetworkActionGuildCreate.templateName) && Intrinsics3.areEqual(this.isCommunityIntent, trackNetworkActionGuildCreate.isCommunityIntent);
    }

    public int hashCode() {
        CharSequence charSequence = this.templateName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isCommunityIntent;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkActionGuildCreate(templateName=");
        sbU.append(this.templateName);
        sbU.append(", isCommunityIntent=");
        return outline.D(sbU, this.isCommunityIntent, ")");
    }

    public TrackNetworkActionGuildCreate(CharSequence charSequence, Boolean bool) {
        this.templateName = charSequence;
        this.isCommunityIntent = null;
        this.analyticsSchemaTypeName = "network_action_guild_create";
    }
}
