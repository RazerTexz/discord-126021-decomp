package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackDispatchBase;
import com.discord.analytics.generated.traits.TrackDispatchBase2;
import com.discord.analytics.generated.traits.TrackDispatchPatch;
import com.discord.analytics.generated.traits.TrackDispatchPatch2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGlVerificationFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGlVerificationFailed implements AnalyticsSchema, TrackBase2, TrackDispatchBase2, TrackDispatchPatch2 {
    private TrackBase trackBase;
    private TrackDispatchBase trackDispatchBase;
    private TrackDispatchPatch trackDispatchPatch;
    private final Long corruptChunks = null;
    private final Long attemptNumber = null;
    private final transient String analyticsSchemaTypeName = "gl_verification_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGlVerificationFailed)) {
            return false;
        }
        TrackGlVerificationFailed trackGlVerificationFailed = (TrackGlVerificationFailed) other;
        return Intrinsics3.areEqual(this.corruptChunks, trackGlVerificationFailed.corruptChunks) && Intrinsics3.areEqual(this.attemptNumber, trackGlVerificationFailed.attemptNumber);
    }

    public int hashCode() {
        Long l = this.corruptChunks;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.attemptNumber;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGlVerificationFailed(corruptChunks=");
        sbU.append(this.corruptChunks);
        sbU.append(", attemptNumber=");
        return outline.G(sbU, this.attemptNumber, ")");
    }
}
