package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAfCustomizationSaved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfCustomizationSaved implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final Long addedMemberCount = null;
    private final Long removedMemberCount = null;
    private final Long selectedFriendCount = null;
    private final Long selectedTotalCount = null;
    private final Long selectedSuggestedCount = null;
    private final transient String analyticsSchemaTypeName = "af_customization_saved";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfCustomizationSaved)) {
            return false;
        }
        TrackAfCustomizationSaved trackAfCustomizationSaved = (TrackAfCustomizationSaved) other;
        return m.areEqual(this.loadId, trackAfCustomizationSaved.loadId) && m.areEqual(this.addedMemberCount, trackAfCustomizationSaved.addedMemberCount) && m.areEqual(this.removedMemberCount, trackAfCustomizationSaved.removedMemberCount) && m.areEqual(this.selectedFriendCount, trackAfCustomizationSaved.selectedFriendCount) && m.areEqual(this.selectedTotalCount, trackAfCustomizationSaved.selectedTotalCount) && m.areEqual(this.selectedSuggestedCount, trackAfCustomizationSaved.selectedSuggestedCount);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.addedMemberCount;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.removedMemberCount;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.selectedFriendCount;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.selectedTotalCount;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.selectedSuggestedCount;
        return iHashCode5 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAfCustomizationSaved(loadId=");
        sbU.append(this.loadId);
        sbU.append(", addedMemberCount=");
        sbU.append(this.addedMemberCount);
        sbU.append(", removedMemberCount=");
        sbU.append(this.removedMemberCount);
        sbU.append(", selectedFriendCount=");
        sbU.append(this.selectedFriendCount);
        sbU.append(", selectedTotalCount=");
        sbU.append(this.selectedTotalCount);
        sbU.append(", selectedSuggestedCount=");
        return a.G(sbU, this.selectedSuggestedCount, ")");
    }
}
