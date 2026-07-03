package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.hasContent, trackExternalShareOpened.hasContent) && C12238m.areEqual(this.hasAttachment, trackExternalShareOpened.hasAttachment);
    }

    public int hashCode() {
        Boolean bool = this.hasContent;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.hasAttachment;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackExternalShareOpened(hasContent=");
        sbM833U.append(this.hasContent);
        sbM833U.append(", hasAttachment=");
        return C1643a.m816D(sbM833U, this.hasAttachment, ")");
    }
}
