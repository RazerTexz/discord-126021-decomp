package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.loadId, trackAfCustomizationSaved.loadId) && C12238m.areEqual(this.addedMemberCount, trackAfCustomizationSaved.addedMemberCount) && C12238m.areEqual(this.removedMemberCount, trackAfCustomizationSaved.removedMemberCount) && C12238m.areEqual(this.selectedFriendCount, trackAfCustomizationSaved.selectedFriendCount) && C12238m.areEqual(this.selectedTotalCount, trackAfCustomizationSaved.selectedTotalCount) && C12238m.areEqual(this.selectedSuggestedCount, trackAfCustomizationSaved.selectedSuggestedCount);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAfCustomizationSaved(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", addedMemberCount=");
        sbM833U.append(this.addedMemberCount);
        sbM833U.append(", removedMemberCount=");
        sbM833U.append(this.removedMemberCount);
        sbM833U.append(", selectedFriendCount=");
        sbM833U.append(this.selectedFriendCount);
        sbM833U.append(", selectedTotalCount=");
        sbM833U.append(this.selectedTotalCount);
        sbM833U.append(", selectedSuggestedCount=");
        return C1643a.m819G(sbM833U, this.selectedSuggestedCount, ")");
    }
}
