package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackConnectedAccountInitiated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackConnectedAccountInitiated implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence platformType;
    private TrackBase trackBase;

    public TrackConnectedAccountInitiated() {
        this.platformType = null;
        this.analyticsSchemaTypeName = "connected_account_initiated";
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public void e(TrackBase trackBase) {
        this.trackBase = trackBase;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackConnectedAccountInitiated) && Intrinsics3.areEqual(this.platformType, ((TrackConnectedAccountInitiated) other).platformType);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.platformType;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackConnectedAccountInitiated(platformType="), this.platformType, ")");
    }

    public TrackConnectedAccountInitiated(CharSequence charSequence) {
        this.platformType = charSequence;
        this.analyticsSchemaTypeName = "connected_account_initiated";
    }
}
