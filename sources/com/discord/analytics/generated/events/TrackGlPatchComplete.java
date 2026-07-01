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

/* JADX INFO: compiled from: TrackGlPatchComplete.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGlPatchComplete implements AnalyticsSchema, TrackBase2, TrackDispatchBase2, TrackDispatchPatch2 {
    private TrackBase trackBase;
    private TrackDispatchBase trackDispatchBase;
    private TrackDispatchPatch trackDispatchPatch;
    private final Long bytesDownloaded = null;
    private final transient String analyticsSchemaTypeName = "gl_patch_complete";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGlPatchComplete) && Intrinsics3.areEqual(this.bytesDownloaded, ((TrackGlPatchComplete) other).bytesDownloaded);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.bytesDownloaded;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackGlPatchComplete(bytesDownloaded="), this.bytesDownloaded, ")");
    }
}
