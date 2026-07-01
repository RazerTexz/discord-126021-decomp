package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAndroidHardwareSurvey.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAndroidHardwareSurvey implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence deviceBoard = null;
    private final CharSequence deviceBrand = null;
    private final CharSequence deviceManufacturer = null;
    private final CharSequence deviceModel = null;
    private final CharSequence deviceProduct = null;
    private final CharSequence deviceSupportedAbis = null;
    private final Boolean deviceIs64Bit = null;
    private final Boolean isLowRamDevice = null;
    private final Long memoryClass = null;
    private final Long largeMemoryClass = null;
    private final Long hardwareDecoders1080 = null;
    private final Long hardwareDecoders720 = null;
    private final Long hardwareDecoders480 = null;
    private final Long decoders1080 = null;
    private final Long decoders720 = null;
    private final Long decoders480 = null;
    private final Long testDurationMs = null;
    private final transient String analyticsSchemaTypeName = "android_hardware_survey";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAndroidHardwareSurvey)) {
            return false;
        }
        TrackAndroidHardwareSurvey trackAndroidHardwareSurvey = (TrackAndroidHardwareSurvey) other;
        return Intrinsics3.areEqual(this.deviceBoard, trackAndroidHardwareSurvey.deviceBoard) && Intrinsics3.areEqual(this.deviceBrand, trackAndroidHardwareSurvey.deviceBrand) && Intrinsics3.areEqual(this.deviceManufacturer, trackAndroidHardwareSurvey.deviceManufacturer) && Intrinsics3.areEqual(this.deviceModel, trackAndroidHardwareSurvey.deviceModel) && Intrinsics3.areEqual(this.deviceProduct, trackAndroidHardwareSurvey.deviceProduct) && Intrinsics3.areEqual(this.deviceSupportedAbis, trackAndroidHardwareSurvey.deviceSupportedAbis) && Intrinsics3.areEqual(this.deviceIs64Bit, trackAndroidHardwareSurvey.deviceIs64Bit) && Intrinsics3.areEqual(this.isLowRamDevice, trackAndroidHardwareSurvey.isLowRamDevice) && Intrinsics3.areEqual(this.memoryClass, trackAndroidHardwareSurvey.memoryClass) && Intrinsics3.areEqual(this.largeMemoryClass, trackAndroidHardwareSurvey.largeMemoryClass) && Intrinsics3.areEqual(this.hardwareDecoders1080, trackAndroidHardwareSurvey.hardwareDecoders1080) && Intrinsics3.areEqual(this.hardwareDecoders720, trackAndroidHardwareSurvey.hardwareDecoders720) && Intrinsics3.areEqual(this.hardwareDecoders480, trackAndroidHardwareSurvey.hardwareDecoders480) && Intrinsics3.areEqual(this.decoders1080, trackAndroidHardwareSurvey.decoders1080) && Intrinsics3.areEqual(this.decoders720, trackAndroidHardwareSurvey.decoders720) && Intrinsics3.areEqual(this.decoders480, trackAndroidHardwareSurvey.decoders480) && Intrinsics3.areEqual(this.testDurationMs, trackAndroidHardwareSurvey.testDurationMs);
    }

    public int hashCode() {
        CharSequence charSequence = this.deviceBoard;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.deviceBrand;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.deviceManufacturer;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.deviceModel;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.deviceProduct;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.deviceSupportedAbis;
        int iHashCode6 = (iHashCode5 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool = this.deviceIs64Bit;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isLowRamDevice;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.memoryClass;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.largeMemoryClass;
        int iHashCode10 = (iHashCode9 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.hardwareDecoders1080;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.hardwareDecoders720;
        int iHashCode12 = (iHashCode11 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.hardwareDecoders480;
        int iHashCode13 = (iHashCode12 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.decoders1080;
        int iHashCode14 = (iHashCode13 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.decoders720;
        int iHashCode15 = (iHashCode14 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.decoders480;
        int iHashCode16 = (iHashCode15 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.testDurationMs;
        return iHashCode16 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAndroidHardwareSurvey(deviceBoard=");
        sbU.append(this.deviceBoard);
        sbU.append(", deviceBrand=");
        sbU.append(this.deviceBrand);
        sbU.append(", deviceManufacturer=");
        sbU.append(this.deviceManufacturer);
        sbU.append(", deviceModel=");
        sbU.append(this.deviceModel);
        sbU.append(", deviceProduct=");
        sbU.append(this.deviceProduct);
        sbU.append(", deviceSupportedAbis=");
        sbU.append(this.deviceSupportedAbis);
        sbU.append(", deviceIs64Bit=");
        sbU.append(this.deviceIs64Bit);
        sbU.append(", isLowRamDevice=");
        sbU.append(this.isLowRamDevice);
        sbU.append(", memoryClass=");
        sbU.append(this.memoryClass);
        sbU.append(", largeMemoryClass=");
        sbU.append(this.largeMemoryClass);
        sbU.append(", hardwareDecoders1080=");
        sbU.append(this.hardwareDecoders1080);
        sbU.append(", hardwareDecoders720=");
        sbU.append(this.hardwareDecoders720);
        sbU.append(", hardwareDecoders480=");
        sbU.append(this.hardwareDecoders480);
        sbU.append(", decoders1080=");
        sbU.append(this.decoders1080);
        sbU.append(", decoders720=");
        sbU.append(this.decoders720);
        sbU.append(", decoders480=");
        sbU.append(this.decoders480);
        sbU.append(", testDurationMs=");
        return outline.G(sbU, this.testDurationMs, ")");
    }
}
