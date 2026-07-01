package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackDispatchBase;
import com.discord.analytics.generated.traits.TrackDispatchBaseReceiver;
import com.discord.analytics.generated.traits.TrackDispatchPatch;
import com.discord.analytics.generated.traits.TrackDispatchPatchReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGlVerificationFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGlVerificationFailed implements AnalyticsSchema, TrackBaseReceiver, TrackDispatchBaseReceiver, TrackDispatchPatchReceiver {
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
        return m.areEqual(this.corruptChunks, trackGlVerificationFailed.corruptChunks) && m.areEqual(this.attemptNumber, trackGlVerificationFailed.attemptNumber);
    }

    public int hashCode() {
        Long l = this.corruptChunks;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.attemptNumber;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGlVerificationFailed(corruptChunks=");
        sbU.append(this.corruptChunks);
        sbU.append(", attemptNumber=");
        return a.G(sbU, this.attemptNumber, ")");
    }
}
