package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSystemSurvey.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSystemSurvey implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence cpuBrand = null;
    private final CharSequence cpuVendor = null;
    private final Long cpuMemory = null;
    private final CharSequence gpuBrand = null;
    private final Long gpuCount = null;
    private final Long gpuMemory = null;
    private final Long batteries = null;
    private final Long displayMonitors = null;
    private final Long displayPrimaryWidth = null;
    private final Long displayPrimaryHeight = null;
    private final Long displayDesktopWidth = null;
    private final Long displayDesktopHeight = null;
    private final transient String analyticsSchemaTypeName = "system_survey";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSystemSurvey)) {
            return false;
        }
        TrackSystemSurvey trackSystemSurvey = (TrackSystemSurvey) other;
        return Intrinsics3.areEqual(this.cpuBrand, trackSystemSurvey.cpuBrand) && Intrinsics3.areEqual(this.cpuVendor, trackSystemSurvey.cpuVendor) && Intrinsics3.areEqual(this.cpuMemory, trackSystemSurvey.cpuMemory) && Intrinsics3.areEqual(this.gpuBrand, trackSystemSurvey.gpuBrand) && Intrinsics3.areEqual(this.gpuCount, trackSystemSurvey.gpuCount) && Intrinsics3.areEqual(this.gpuMemory, trackSystemSurvey.gpuMemory) && Intrinsics3.areEqual(this.batteries, trackSystemSurvey.batteries) && Intrinsics3.areEqual(this.displayMonitors, trackSystemSurvey.displayMonitors) && Intrinsics3.areEqual(this.displayPrimaryWidth, trackSystemSurvey.displayPrimaryWidth) && Intrinsics3.areEqual(this.displayPrimaryHeight, trackSystemSurvey.displayPrimaryHeight) && Intrinsics3.areEqual(this.displayDesktopWidth, trackSystemSurvey.displayDesktopWidth) && Intrinsics3.areEqual(this.displayDesktopHeight, trackSystemSurvey.displayDesktopHeight);
    }

    public int hashCode() {
        CharSequence charSequence = this.cpuBrand;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.cpuVendor;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.cpuMemory;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gpuBrand;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.gpuCount;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.gpuMemory;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.batteries;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.displayMonitors;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.displayPrimaryWidth;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.displayPrimaryHeight;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.displayDesktopWidth;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.displayDesktopHeight;
        return iHashCode11 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSystemSurvey(cpuBrand=");
        sbU.append(this.cpuBrand);
        sbU.append(", cpuVendor=");
        sbU.append(this.cpuVendor);
        sbU.append(", cpuMemory=");
        sbU.append(this.cpuMemory);
        sbU.append(", gpuBrand=");
        sbU.append(this.gpuBrand);
        sbU.append(", gpuCount=");
        sbU.append(this.gpuCount);
        sbU.append(", gpuMemory=");
        sbU.append(this.gpuMemory);
        sbU.append(", batteries=");
        sbU.append(this.batteries);
        sbU.append(", displayMonitors=");
        sbU.append(this.displayMonitors);
        sbU.append(", displayPrimaryWidth=");
        sbU.append(this.displayPrimaryWidth);
        sbU.append(", displayPrimaryHeight=");
        sbU.append(this.displayPrimaryHeight);
        sbU.append(", displayDesktopWidth=");
        sbU.append(this.displayDesktopWidth);
        sbU.append(", displayDesktopHeight=");
        return outline.G(sbU, this.displayDesktopHeight, ")");
    }
}
