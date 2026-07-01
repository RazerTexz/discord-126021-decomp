package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackDispatchBase;
import com.discord.analytics.generated.traits.TrackDispatchBaseReceiver;
import com.discord.analytics.generated.traits.TrackDispatchPatch;
import com.discord.analytics.generated.traits.TrackDispatchPatchReceiver;
import com.discord.analytics.generated.traits.TrackDispatchStats;
import com.discord.analytics.generated.traits.TrackDispatchStatsReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGlPatchFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGlPatchFailed implements AnalyticsSchema, TrackBaseReceiver, TrackDispatchBaseReceiver, TrackDispatchPatchReceiver, TrackDispatchStatsReceiver {
    private TrackBase trackBase;
    private TrackDispatchBase trackDispatchBase;
    private TrackDispatchPatch trackDispatchPatch;
    private TrackDispatchStats trackDispatchStats;
    private final Long errorCode = null;
    private final transient String analyticsSchemaTypeName = "gl_patch_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGlPatchFailed) && m.areEqual(this.errorCode, ((TrackGlPatchFailed) other).errorCode);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.errorCode;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackGlPatchFailed(errorCode="), this.errorCode, ")");
    }
}
