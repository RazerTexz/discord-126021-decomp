package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.wave, trackHardwareDetected.wave) && m.areEqual(this.cpuBrand, trackHardwareDetected.cpuBrand) && m.areEqual(this.cpuVendor, trackHardwareDetected.cpuVendor) && m.areEqual(this.cpuMemory, trackHardwareDetected.cpuMemory) && m.areEqual(this.gpuBrand, trackHardwareDetected.gpuBrand) && m.areEqual(this.gpuCount, trackHardwareDetected.gpuCount) && m.areEqual(this.gpuMemory, trackHardwareDetected.gpuMemory) && m.areEqual(this.batteries, trackHardwareDetected.batteries) && m.areEqual(this.displayMonitors, trackHardwareDetected.displayMonitors) && m.areEqual(this.displayPrimaryWidth, trackHardwareDetected.displayPrimaryWidth) && m.areEqual(this.displayPrimaryHeight, trackHardwareDetected.displayPrimaryHeight) && m.areEqual(this.displayDesktopWidth, trackHardwareDetected.displayDesktopWidth) && m.areEqual(this.displayDesktopHeight, trackHardwareDetected.displayDesktopHeight) && m.areEqual(this.cameraCount, trackHardwareDetected.cameraCount) && m.areEqual(this.cameraDefaultName, trackHardwareDetected.cameraDefaultName) && m.areEqual(this.cameraDefaultMaxWidth, trackHardwareDetected.cameraDefaultMaxWidth) && m.areEqual(this.cameraDefaultMaxHeight, trackHardwareDetected.cameraDefaultMaxHeight) && m.areEqual(this.cameraDefaultHasI420, trackHardwareDetected.cameraDefaultHasI420) && m.areEqual(this.cameraDefaultHasNv12, trackHardwareDetected.cameraDefaultHasNv12) && m.areEqual(this.cameraDefaultHasYuy2, trackHardwareDetected.cameraDefaultHasYuy2) && m.areEqual(this.cameraDefaultHasMjpg, trackHardwareDetected.cameraDefaultHasMjpg) && m.areEqual(this.cameraDefaultBus, trackHardwareDetected.cameraDefaultBus) && m.areEqual(this.cameraDefaultVendorId, trackHardwareDetected.cameraDefaultVendorId) && m.areEqual(this.cameraDefaultProductId, trackHardwareDetected.cameraDefaultProductId);
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
        StringBuilder sbU = a.U("TrackHardwareDetected(wave=");
        sbU.append(this.wave);
        sbU.append(", cpuBrand=");
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
        sbU.append(this.displayDesktopHeight);
        sbU.append(", cameraCount=");
        sbU.append(this.cameraCount);
        sbU.append(", cameraDefaultName=");
        sbU.append(this.cameraDefaultName);
        sbU.append(", cameraDefaultMaxWidth=");
        sbU.append(this.cameraDefaultMaxWidth);
        sbU.append(", cameraDefaultMaxHeight=");
        sbU.append(this.cameraDefaultMaxHeight);
        sbU.append(", cameraDefaultHasI420=");
        sbU.append(this.cameraDefaultHasI420);
        sbU.append(", cameraDefaultHasNv12=");
        sbU.append(this.cameraDefaultHasNv12);
        sbU.append(", cameraDefaultHasYuy2=");
        sbU.append(this.cameraDefaultHasYuy2);
        sbU.append(", cameraDefaultHasMjpg=");
        sbU.append(this.cameraDefaultHasMjpg);
        sbU.append(", cameraDefaultBus=");
        sbU.append(this.cameraDefaultBus);
        sbU.append(", cameraDefaultVendorId=");
        sbU.append(this.cameraDefaultVendorId);
        sbU.append(", cameraDefaultProductId=");
        return a.G(sbU, this.cameraDefaultProductId, ")");
    }
}
