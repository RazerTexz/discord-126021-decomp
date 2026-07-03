package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackHardwareDetected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackHardwareDetected implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long wave = null;
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
    private final Long cameraCount = null;
    private final CharSequence cameraDefaultName = null;
    private final Long cameraDefaultMaxWidth = null;
    private final Long cameraDefaultMaxHeight = null;
    private final Boolean cameraDefaultHasI420 = null;
    private final Boolean cameraDefaultHasNv12 = null;
    private final Boolean cameraDefaultHasYuy2 = null;
    private final Boolean cameraDefaultHasMjpg = null;
    private final CharSequence cameraDefaultBus = null;
    private final Long cameraDefaultVendorId = null;
    private final Long cameraDefaultProductId = null;
    private final transient String analyticsSchemaTypeName = "hardware_detected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackHardwareDetected)) {
            return false;
        }
        TrackHardwareDetected trackHardwareDetected = (TrackHardwareDetected) other;
        return C12238m.areEqual(this.wave, trackHardwareDetected.wave) && C12238m.areEqual(this.cpuBrand, trackHardwareDetected.cpuBrand) && C12238m.areEqual(this.cpuVendor, trackHardwareDetected.cpuVendor) && C12238m.areEqual(this.cpuMemory, trackHardwareDetected.cpuMemory) && C12238m.areEqual(this.gpuBrand, trackHardwareDetected.gpuBrand) && C12238m.areEqual(this.gpuCount, trackHardwareDetected.gpuCount) && C12238m.areEqual(this.gpuMemory, trackHardwareDetected.gpuMemory) && C12238m.areEqual(this.batteries, trackHardwareDetected.batteries) && C12238m.areEqual(this.displayMonitors, trackHardwareDetected.displayMonitors) && C12238m.areEqual(this.displayPrimaryWidth, trackHardwareDetected.displayPrimaryWidth) && C12238m.areEqual(this.displayPrimaryHeight, trackHardwareDetected.displayPrimaryHeight) && C12238m.areEqual(this.displayDesktopWidth, trackHardwareDetected.displayDesktopWidth) && C12238m.areEqual(this.displayDesktopHeight, trackHardwareDetected.displayDesktopHeight) && C12238m.areEqual(this.cameraCount, trackHardwareDetected.cameraCount) && C12238m.areEqual(this.cameraDefaultName, trackHardwareDetected.cameraDefaultName) && C12238m.areEqual(this.cameraDefaultMaxWidth, trackHardwareDetected.cameraDefaultMaxWidth) && C12238m.areEqual(this.cameraDefaultMaxHeight, trackHardwareDetected.cameraDefaultMaxHeight) && C12238m.areEqual(this.cameraDefaultHasI420, trackHardwareDetected.cameraDefaultHasI420) && C12238m.areEqual(this.cameraDefaultHasNv12, trackHardwareDetected.cameraDefaultHasNv12) && C12238m.areEqual(this.cameraDefaultHasYuy2, trackHardwareDetected.cameraDefaultHasYuy2) && C12238m.areEqual(this.cameraDefaultHasMjpg, trackHardwareDetected.cameraDefaultHasMjpg) && C12238m.areEqual(this.cameraDefaultBus, trackHardwareDetected.cameraDefaultBus) && C12238m.areEqual(this.cameraDefaultVendorId, trackHardwareDetected.cameraDefaultVendorId) && C12238m.areEqual(this.cameraDefaultProductId, trackHardwareDetected.cameraDefaultProductId);
    }

    public int hashCode() {
        Long l = this.wave;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.cpuBrand;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.cpuVendor;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.cpuMemory;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gpuBrand;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l3 = this.gpuCount;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.gpuMemory;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.batteries;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.displayMonitors;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.displayPrimaryWidth;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.displayPrimaryHeight;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.displayDesktopWidth;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.displayDesktopHeight;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.cameraCount;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.cameraDefaultName;
        int iHashCode15 = (iHashCode14 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l12 = this.cameraDefaultMaxWidth;
        int iHashCode16 = (iHashCode15 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.cameraDefaultMaxHeight;
        int iHashCode17 = (iHashCode16 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Boolean bool = this.cameraDefaultHasI420;
        int iHashCode18 = (iHashCode17 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.cameraDefaultHasNv12;
        int iHashCode19 = (iHashCode18 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.cameraDefaultHasYuy2;
        int iHashCode20 = (iHashCode19 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.cameraDefaultHasMjpg;
        int iHashCode21 = (iHashCode20 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.cameraDefaultBus;
        int iHashCode22 = (iHashCode21 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l14 = this.cameraDefaultVendorId;
        int iHashCode23 = (iHashCode22 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.cameraDefaultProductId;
        return iHashCode23 + (l15 != null ? l15.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackHardwareDetected(wave=");
        sbM833U.append(this.wave);
        sbM833U.append(", cpuBrand=");
        sbM833U.append(this.cpuBrand);
        sbM833U.append(", cpuVendor=");
        sbM833U.append(this.cpuVendor);
        sbM833U.append(", cpuMemory=");
        sbM833U.append(this.cpuMemory);
        sbM833U.append(", gpuBrand=");
        sbM833U.append(this.gpuBrand);
        sbM833U.append(", gpuCount=");
        sbM833U.append(this.gpuCount);
        sbM833U.append(", gpuMemory=");
        sbM833U.append(this.gpuMemory);
        sbM833U.append(", batteries=");
        sbM833U.append(this.batteries);
        sbM833U.append(", displayMonitors=");
        sbM833U.append(this.displayMonitors);
        sbM833U.append(", displayPrimaryWidth=");
        sbM833U.append(this.displayPrimaryWidth);
        sbM833U.append(", displayPrimaryHeight=");
        sbM833U.append(this.displayPrimaryHeight);
        sbM833U.append(", displayDesktopWidth=");
        sbM833U.append(this.displayDesktopWidth);
        sbM833U.append(", displayDesktopHeight=");
        sbM833U.append(this.displayDesktopHeight);
        sbM833U.append(", cameraCount=");
        sbM833U.append(this.cameraCount);
        sbM833U.append(", cameraDefaultName=");
        sbM833U.append(this.cameraDefaultName);
        sbM833U.append(", cameraDefaultMaxWidth=");
        sbM833U.append(this.cameraDefaultMaxWidth);
        sbM833U.append(", cameraDefaultMaxHeight=");
        sbM833U.append(this.cameraDefaultMaxHeight);
        sbM833U.append(", cameraDefaultHasI420=");
        sbM833U.append(this.cameraDefaultHasI420);
        sbM833U.append(", cameraDefaultHasNv12=");
        sbM833U.append(this.cameraDefaultHasNv12);
        sbM833U.append(", cameraDefaultHasYuy2=");
        sbM833U.append(this.cameraDefaultHasYuy2);
        sbM833U.append(", cameraDefaultHasMjpg=");
        sbM833U.append(this.cameraDefaultHasMjpg);
        sbM833U.append(", cameraDefaultBus=");
        sbM833U.append(this.cameraDefaultBus);
        sbM833U.append(", cameraDefaultVendorId=");
        sbM833U.append(this.cameraDefaultVendorId);
        sbM833U.append(", cameraDefaultProductId=");
        return C1643a.m819G(sbM833U, this.cameraDefaultProductId, ")");
    }
}
