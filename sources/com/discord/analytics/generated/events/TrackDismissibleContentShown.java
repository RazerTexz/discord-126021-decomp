package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDismissibleContentShown.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDismissibleContentShown implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final Long contentCount = null;
    private final CharSequence groupName = null;
    private final Boolean bypassFatigue = null;
    private final transient String analyticsSchemaTypeName = "dismissible_content_shown";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDismissibleContentShown)) {
            return false;
        }
        TrackDismissibleContentShown trackDismissibleContentShown = (TrackDismissibleContentShown) other;
        return C12238m.areEqual(this.type, trackDismissibleContentShown.type) && C12238m.areEqual(this.contentCount, trackDismissibleContentShown.contentCount) && C12238m.areEqual(this.groupName, trackDismissibleContentShown.groupName) && C12238m.areEqual(this.bypassFatigue, trackDismissibleContentShown.bypassFatigue);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.contentCount;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.groupName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.bypassFatigue;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDismissibleContentShown(type=");
        sbM833U.append(this.type);
        sbM833U.append(", contentCount=");
        sbM833U.append(this.contentCount);
        sbM833U.append(", groupName=");
        sbM833U.append(this.groupName);
        sbM833U.append(", bypassFatigue=");
        return C1643a.m816D(sbM833U, this.bypassFatigue, ")");
    }
}
