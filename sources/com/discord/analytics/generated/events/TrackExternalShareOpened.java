package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackExternalShareOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExternalShareOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean hasContent = null;
    private final Boolean hasAttachment = null;
    private final transient String analyticsSchemaTypeName = "external_share_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExternalShareOpened)) {
            return false;
        }
        TrackExternalShareOpened trackExternalShareOpened = (TrackExternalShareOpened) other;
        return Intrinsics3.areEqual(this.hasContent, trackExternalShareOpened.hasContent) && Intrinsics3.areEqual(this.hasAttachment, trackExternalShareOpened.hasAttachment);
    }

    public int hashCode() {
        Boolean bool = this.hasContent;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.hasAttachment;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExternalShareOpened(hasContent=");
        sbU.append(this.hasContent);
        sbU.append(", hasAttachment=");
        return outline.D(sbU, this.hasAttachment, ")");
    }
}
