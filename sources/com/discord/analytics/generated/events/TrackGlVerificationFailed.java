package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackDispatchBase;
import com.discord.analytics.generated.traits.TrackDispatchBaseReceiver;
import com.discord.analytics.generated.traits.TrackDispatchPatch;
import com.discord.analytics.generated.traits.TrackDispatchPatchReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.corruptChunks, trackGlVerificationFailed.corruptChunks) && C12238m.areEqual(this.attemptNumber, trackGlVerificationFailed.attemptNumber);
    }

    public int hashCode() {
        Long l = this.corruptChunks;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.attemptNumber;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGlVerificationFailed(corruptChunks=");
        sbM833U.append(this.corruptChunks);
        sbM833U.append(", attemptNumber=");
        return C1643a.m819G(sbM833U, this.attemptNumber, ")");
    }
}
