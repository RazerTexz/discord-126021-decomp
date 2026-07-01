package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackActivityInternalMenuInteraction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalMenuInteraction implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence menuName = null;
    private final CharSequence interactionType = null;
    private final CharSequence phase = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_menu_interaction";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalMenuInteraction)) {
            return false;
        }
        TrackActivityInternalMenuInteraction trackActivityInternalMenuInteraction = (TrackActivityInternalMenuInteraction) other;
        return m.areEqual(this.menuName, trackActivityInternalMenuInteraction.menuName) && m.areEqual(this.interactionType, trackActivityInternalMenuInteraction.interactionType) && m.areEqual(this.phase, trackActivityInternalMenuInteraction.phase);
    }

    public int hashCode() {
        CharSequence charSequence = this.menuName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.interactionType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.phase;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackActivityInternalMenuInteraction(menuName=");
        sbU.append(this.menuName);
        sbU.append(", interactionType=");
        sbU.append(this.interactionType);
        sbU.append(", phase=");
        return a.E(sbU, this.phase, ")");
    }
}
