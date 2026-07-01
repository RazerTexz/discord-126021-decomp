package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNudgeDisplayed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNudgeDisplayed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Long stickerId = null;
    private final transient String analyticsSchemaTypeName = "nudge_displayed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackNudgeDisplayed) && m.areEqual(this.stickerId, ((TrackNudgeDisplayed) other).stickerId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.stickerId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackNudgeDisplayed(stickerId="), this.stickerId, ")");
    }
}
