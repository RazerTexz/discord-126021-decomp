package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackConnectedAccountInitiated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackConnectedAccountInitiated implements AnalyticsSchema, TrackBaseReceiver {
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

    /* JADX INFO: renamed from: e */
    public void m7510e(TrackBase trackBase) {
        this.trackBase = trackBase;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackConnectedAccountInitiated) && C12238m.areEqual(this.platformType, ((TrackConnectedAccountInitiated) other).platformType);
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
        return C1643a.m817E(C1643a.m833U("TrackConnectedAccountInitiated(platformType="), this.platformType, ")");
    }

    public TrackConnectedAccountInitiated(CharSequence charSequence) {
        this.platformType = charSequence;
        this.analyticsSchemaTypeName = "connected_account_initiated";
    }
}
