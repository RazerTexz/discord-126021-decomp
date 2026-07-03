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

/* JADX INFO: compiled from: TrackGlPatchComplete.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGlPatchComplete implements AnalyticsSchema, TrackBaseReceiver, TrackDispatchBaseReceiver, TrackDispatchPatchReceiver {
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
            return (other instanceof TrackGlPatchComplete) && C12238m.areEqual(this.bytesDownloaded, ((TrackGlPatchComplete) other).bytesDownloaded);
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
        return C1643a.m819G(C1643a.m833U("TrackGlPatchComplete(bytesDownloaded="), this.bytesDownloaded, ")");
    }
}
