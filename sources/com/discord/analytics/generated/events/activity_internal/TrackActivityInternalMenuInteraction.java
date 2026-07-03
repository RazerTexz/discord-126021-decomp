package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.menuName, trackActivityInternalMenuInteraction.menuName) && C12238m.areEqual(this.interactionType, trackActivityInternalMenuInteraction.interactionType) && C12238m.areEqual(this.phase, trackActivityInternalMenuInteraction.phase);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalMenuInteraction(menuName=");
        sbM833U.append(this.menuName);
        sbM833U.append(", interactionType=");
        sbM833U.append(this.interactionType);
        sbM833U.append(", phase=");
        return C1643a.m817E(sbM833U, this.phase, ")");
    }
}
