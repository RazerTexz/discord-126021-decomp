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

/* JADX INFO: compiled from: TrackNetworkActionDirectoryGuildEntryDelete.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionDirectoryGuildEntryDelete implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long directoryChannelId;
    private final Long guildId;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionDirectoryGuildEntryDelete() {
        this.directoryChannelId = null;
        this.guildId = null;
        this.analyticsSchemaTypeName = "network_action_directory_guild_entry_delete";
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
        if (!(other instanceof TrackNetworkActionDirectoryGuildEntryDelete)) {
            return false;
        }
        TrackNetworkActionDirectoryGuildEntryDelete trackNetworkActionDirectoryGuildEntryDelete = (TrackNetworkActionDirectoryGuildEntryDelete) other;
        return m.areEqual(this.directoryChannelId, trackNetworkActionDirectoryGuildEntryDelete.directoryChannelId) && m.areEqual(this.guildId, trackNetworkActionDirectoryGuildEntryDelete.guildId);
    }

    public int hashCode() {
        Long l = this.directoryChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNetworkActionDirectoryGuildEntryDelete(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", guildId=");
        return a.G(sbU, this.guildId, ")");
    }

    public TrackNetworkActionDirectoryGuildEntryDelete(Long l, Long l2) {
        this.directoryChannelId = l;
        this.guildId = l2;
        this.analyticsSchemaTypeName = "network_action_directory_guild_entry_delete";
    }
}
