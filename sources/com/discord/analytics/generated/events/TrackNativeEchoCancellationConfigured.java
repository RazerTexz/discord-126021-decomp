package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNativeEchoCancellationConfigured.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNativeEchoCancellationConfigured implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean builtinAecSupportedJava = null;
    private final Boolean builtinAecSupportedNative = null;
    private final Boolean builtinAecRequested = null;
    private final Boolean builtinAecEnabled = null;
    private final Boolean aecEnabledInSettings = null;
    private final Boolean aecEnabledInNativeConfig = null;
    private final Boolean aecMobileMode = null;
    private final Boolean aecEnabledByDefault = null;
    private final Boolean aecMobileModeByDefault = null;
    private final transient String analyticsSchemaTypeName = "native_echo_cancellation_configured";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNativeEchoCancellationConfigured)) {
            return false;
        }
        TrackNativeEchoCancellationConfigured trackNativeEchoCancellationConfigured = (TrackNativeEchoCancellationConfigured) other;
        return Intrinsics3.areEqual(this.builtinAecSupportedJava, trackNativeEchoCancellationConfigured.builtinAecSupportedJava) && Intrinsics3.areEqual(this.builtinAecSupportedNative, trackNativeEchoCancellationConfigured.builtinAecSupportedNative) && Intrinsics3.areEqual(this.builtinAecRequested, trackNativeEchoCancellationConfigured.builtinAecRequested) && Intrinsics3.areEqual(this.builtinAecEnabled, trackNativeEchoCancellationConfigured.builtinAecEnabled) && Intrinsics3.areEqual(this.aecEnabledInSettings, trackNativeEchoCancellationConfigured.aecEnabledInSettings) && Intrinsics3.areEqual(this.aecEnabledInNativeConfig, trackNativeEchoCancellationConfigured.aecEnabledInNativeConfig) && Intrinsics3.areEqual(this.aecMobileMode, trackNativeEchoCancellationConfigured.aecMobileMode) && Intrinsics3.areEqual(this.aecEnabledByDefault, trackNativeEchoCancellationConfigured.aecEnabledByDefault) && Intrinsics3.areEqual(this.aecMobileModeByDefault, trackNativeEchoCancellationConfigured.aecMobileModeByDefault);
    }

    public int hashCode() {
        Boolean bool = this.builtinAecSupportedJava;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.builtinAecSupportedNative;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.builtinAecRequested;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.builtinAecEnabled;
        int iHashCode4 = (iHashCode3 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.aecEnabledInSettings;
        int iHashCode5 = (iHashCode4 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.aecEnabledInNativeConfig;
        int iHashCode6 = (iHashCode5 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.aecMobileMode;
        int iHashCode7 = (iHashCode6 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.aecEnabledByDefault;
        int iHashCode8 = (iHashCode7 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.aecMobileModeByDefault;
        return iHashCode8 + (bool9 != null ? bool9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNativeEchoCancellationConfigured(builtinAecSupportedJava=");
        sbU.append(this.builtinAecSupportedJava);
        sbU.append(", builtinAecSupportedNative=");
        sbU.append(this.builtinAecSupportedNative);
        sbU.append(", builtinAecRequested=");
        sbU.append(this.builtinAecRequested);
        sbU.append(", builtinAecEnabled=");
        sbU.append(this.builtinAecEnabled);
        sbU.append(", aecEnabledInSettings=");
        sbU.append(this.aecEnabledInSettings);
        sbU.append(", aecEnabledInNativeConfig=");
        sbU.append(this.aecEnabledInNativeConfig);
        sbU.append(", aecMobileMode=");
        sbU.append(this.aecMobileMode);
        sbU.append(", aecEnabledByDefault=");
        sbU.append(this.aecEnabledByDefault);
        sbU.append(", aecMobileModeByDefault=");
        return outline.D(sbU, this.aecMobileModeByDefault, ")");
    }
}
