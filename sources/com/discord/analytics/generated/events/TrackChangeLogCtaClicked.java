package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackChangeLogCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChangeLogCtaClicked implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence changeLogId = null;
    private final Float secondsOpen = null;
    private final Float maxScrolledPercentage = null;
    private final CharSequence ctaType = null;
    private final CharSequence target = null;
    private final transient String analyticsSchemaTypeName = "change_log_cta_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChangeLogCtaClicked)) {
            return false;
        }
        TrackChangeLogCtaClicked trackChangeLogCtaClicked = (TrackChangeLogCtaClicked) other;
        return C12238m.areEqual(this.changeLogId, trackChangeLogCtaClicked.changeLogId) && C12238m.areEqual(this.secondsOpen, trackChangeLogCtaClicked.secondsOpen) && C12238m.areEqual(this.maxScrolledPercentage, trackChangeLogCtaClicked.maxScrolledPercentage) && C12238m.areEqual(this.ctaType, trackChangeLogCtaClicked.ctaType) && C12238m.areEqual(this.target, trackChangeLogCtaClicked.target);
    }

    public int hashCode() {
        CharSequence charSequence = this.changeLogId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Float f = this.secondsOpen;
        int iHashCode2 = (iHashCode + (f != null ? f.hashCode() : 0)) * 31;
        Float f2 = this.maxScrolledPercentage;
        int iHashCode3 = (iHashCode2 + (f2 != null ? f2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.ctaType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.target;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackChangeLogCtaClicked(changeLogId=");
        sbM833U.append(this.changeLogId);
        sbM833U.append(", secondsOpen=");
        sbM833U.append(this.secondsOpen);
        sbM833U.append(", maxScrolledPercentage=");
        sbM833U.append(this.maxScrolledPercentage);
        sbM833U.append(", ctaType=");
        sbM833U.append(this.ctaType);
        sbM833U.append(", target=");
        return C1643a.m817E(sbM833U, this.target, ")");
    }
}
