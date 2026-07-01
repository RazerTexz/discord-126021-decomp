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

/* JADX INFO: compiled from: TrackNetworkActionDirectoryGuildEntryCreate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionDirectoryGuildEntryCreate implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long directoryChannelId;
    private final Long guildId;
    private final Long primaryCategoryId;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionDirectoryGuildEntryCreate() {
        this.directoryChannelId = null;
        this.guildId = null;
        this.primaryCategoryId = null;
        this.analyticsSchemaTypeName = "network_action_directory_guild_entry_create";
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
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkActionDirectoryGuildEntryCreate)) {
            return false;
        }
        TrackNetworkActionDirectoryGuildEntryCreate trackNetworkActionDirectoryGuildEntryCreate = (TrackNetworkActionDirectoryGuildEntryCreate) other;
        return m.areEqual(this.directoryChannelId, trackNetworkActionDirectoryGuildEntryCreate.directoryChannelId) && m.areEqual(this.guildId, trackNetworkActionDirectoryGuildEntryCreate.guildId) && m.areEqual(this.primaryCategoryId, trackNetworkActionDirectoryGuildEntryCreate.primaryCategoryId);
    }

    public int hashCode() {
        Long l = this.directoryChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.primaryCategoryId;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNetworkActionDirectoryGuildEntryCreate(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", primaryCategoryId=");
        return a.G(sbU, this.primaryCategoryId, ")");
    }

    public TrackNetworkActionDirectoryGuildEntryCreate(Long l, Long l2, Long l3) {
        this.directoryChannelId = l;
        this.guildId = l2;
        this.primaryCategoryId = l3;
        this.analyticsSchemaTypeName = "network_action_directory_guild_entry_create";
    }
}
