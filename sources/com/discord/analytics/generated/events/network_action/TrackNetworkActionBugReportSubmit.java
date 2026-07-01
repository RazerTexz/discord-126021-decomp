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

/* JADX INFO: compiled from: TrackNetworkActionBugReportSubmit.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionBugReportSubmit implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final Long priority = null;
    private final CharSequence asanaInboxId = null;
    private final transient String analyticsSchemaTypeName = "network_action_bug_report_submit";

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
        if (!(other instanceof TrackNetworkActionBugReportSubmit)) {
            return false;
        }
        TrackNetworkActionBugReportSubmit trackNetworkActionBugReportSubmit = (TrackNetworkActionBugReportSubmit) other;
        return m.areEqual(this.priority, trackNetworkActionBugReportSubmit.priority) && m.areEqual(this.asanaInboxId, trackNetworkActionBugReportSubmit.asanaInboxId);
    }

    public int hashCode() {
        Long l = this.priority;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.asanaInboxId;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNetworkActionBugReportSubmit(priority=");
        sbU.append(this.priority);
        sbU.append(", asanaInboxId=");
        return a.E(sbU, this.asanaInboxId, ")");
    }
}
