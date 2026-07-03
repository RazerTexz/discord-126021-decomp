package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNativeEchoCancellationConfigured.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNativeEchoCancellationConfigured implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.builtinAecSupportedJava, trackNativeEchoCancellationConfigured.builtinAecSupportedJava) && C12238m.areEqual(this.builtinAecSupportedNative, trackNativeEchoCancellationConfigured.builtinAecSupportedNative) && C12238m.areEqual(this.builtinAecRequested, trackNativeEchoCancellationConfigured.builtinAecRequested) && C12238m.areEqual(this.builtinAecEnabled, trackNativeEchoCancellationConfigured.builtinAecEnabled) && C12238m.areEqual(this.aecEnabledInSettings, trackNativeEchoCancellationConfigured.aecEnabledInSettings) && C12238m.areEqual(this.aecEnabledInNativeConfig, trackNativeEchoCancellationConfigured.aecEnabledInNativeConfig) && C12238m.areEqual(this.aecMobileMode, trackNativeEchoCancellationConfigured.aecMobileMode) && C12238m.areEqual(this.aecEnabledByDefault, trackNativeEchoCancellationConfigured.aecEnabledByDefault) && C12238m.areEqual(this.aecMobileModeByDefault, trackNativeEchoCancellationConfigured.aecMobileModeByDefault);
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
        StringBuilder sbM833U = C1643a.m833U("TrackNativeEchoCancellationConfigured(builtinAecSupportedJava=");
        sbM833U.append(this.builtinAecSupportedJava);
        sbM833U.append(", builtinAecSupportedNative=");
        sbM833U.append(this.builtinAecSupportedNative);
        sbM833U.append(", builtinAecRequested=");
        sbM833U.append(this.builtinAecRequested);
        sbM833U.append(", builtinAecEnabled=");
        sbM833U.append(this.builtinAecEnabled);
        sbM833U.append(", aecEnabledInSettings=");
        sbM833U.append(this.aecEnabledInSettings);
        sbM833U.append(", aecEnabledInNativeConfig=");
        sbM833U.append(this.aecEnabledInNativeConfig);
        sbM833U.append(", aecMobileMode=");
        sbM833U.append(this.aecMobileMode);
        sbM833U.append(", aecEnabledByDefault=");
        sbM833U.append(this.aecEnabledByDefault);
        sbM833U.append(", aecMobileModeByDefault=");
        return C1643a.m816D(sbM833U, this.aecMobileModeByDefault, ")");
    }
}
