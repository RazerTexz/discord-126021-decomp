package com.discord.analytics.generated.events.network_action;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNetworkActionGuildCreate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionGuildCreate implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
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
        if (!(other instanceof TrackNetworkActionGuildCreate)) {
            return false;
        }
        TrackNetworkActionGuildCreate trackNetworkActionGuildCreate = (TrackNetworkActionGuildCreate) other;
        return C12238m.areEqual(this.templateName, trackNetworkActionGuildCreate.templateName) && C12238m.areEqual(this.isCommunityIntent, trackNetworkActionGuildCreate.isCommunityIntent);
    }

    public int hashCode() {
        CharSequence charSequence = this.templateName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isCommunityIntent;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNetworkActionGuildCreate(templateName=");
        sbM833U.append(this.templateName);
        sbM833U.append(", isCommunityIntent=");
        return C1643a.m816D(sbM833U, this.isCommunityIntent, ")");
    }

    public TrackNetworkActionGuildCreate(CharSequence charSequence, Boolean bool) {
        this.templateName = charSequence;
        this.isCommunityIntent = null;
        this.analyticsSchemaTypeName = "network_action_guild_create";
    }
}
