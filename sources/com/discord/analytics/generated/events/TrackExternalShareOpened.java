package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackExternalShareOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExternalShareOpened implements AnalyticsSchema, TrackBaseReceiver {
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
        return m.areEqual(this.hasContent, trackExternalShareOpened.hasContent) && m.areEqual(this.hasAttachment, trackExternalShareOpened.hasAttachment);
    }

    public int hashCode() {
        Boolean bool = this.hasContent;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.hasAttachment;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackExternalShareOpened(hasContent=");
        sbU.append(this.hasContent);
        sbU.append(", hasAttachment=");
        return a.D(sbU, this.hasAttachment, ")");
    }
}
