package com.discord.rtcconnection.mediaengine;

import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.a;

/* JADX INFO: compiled from: MediaEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MediaEngine$EchoCancellationInfo {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final boolean builtinAecRequested;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean builtinAecSupportedNative;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final boolean builtinAecSupportedJava;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final boolean builtinAecEnabled;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final boolean aecEnabledInSettings;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final boolean aecEnabledInNativeConfig;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final boolean aecMobileMode;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final boolean aecEnabledByDefault;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final boolean aecMobileModeByDefault;

    public MediaEngine$EchoCancellationInfo() {
        this(false, false, false, false, false, false, false, false, false, FrameMetricsAggregator.EVERY_DURATION);
    }

    public MediaEngine$EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.builtinAecRequested = z2;
        this.builtinAecSupportedNative = z3;
        this.builtinAecSupportedJava = z4;
        this.builtinAecEnabled = z5;
        this.aecEnabledInSettings = z6;
        this.aecEnabledInNativeConfig = z7;
        this.aecMobileMode = z8;
        this.aecEnabledByDefault = z9;
        this.aecMobileModeByDefault = z10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaEngine$EchoCancellationInfo)) {
            return false;
        }
        MediaEngine$EchoCancellationInfo mediaEngine$EchoCancellationInfo = (MediaEngine$EchoCancellationInfo) other;
        return this.builtinAecRequested == mediaEngine$EchoCancellationInfo.builtinAecRequested && this.builtinAecSupportedNative == mediaEngine$EchoCancellationInfo.builtinAecSupportedNative && this.builtinAecSupportedJava == mediaEngine$EchoCancellationInfo.builtinAecSupportedJava && this.builtinAecEnabled == mediaEngine$EchoCancellationInfo.builtinAecEnabled && this.aecEnabledInSettings == mediaEngine$EchoCancellationInfo.aecEnabledInSettings && this.aecEnabledInNativeConfig == mediaEngine$EchoCancellationInfo.aecEnabledInNativeConfig && this.aecMobileMode == mediaEngine$EchoCancellationInfo.aecMobileMode && this.aecEnabledByDefault == mediaEngine$EchoCancellationInfo.aecEnabledByDefault && this.aecMobileModeByDefault == mediaEngine$EchoCancellationInfo.aecMobileModeByDefault;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean z2 = this.builtinAecRequested;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.builtinAecSupportedNative;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.builtinAecSupportedJava;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.builtinAecEnabled;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.aecEnabledInSettings;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.aecEnabledInNativeConfig;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (i5 + r6) * 31;
        boolean z8 = this.aecMobileMode;
        ?? r7 = z8;
        if (z8) {
            r7 = 1;
        }
        int i7 = (i6 + r7) * 31;
        boolean z9 = this.aecEnabledByDefault;
        ?? r8 = z9;
        if (z9) {
            r8 = 1;
        }
        int i8 = (i7 + r8) * 31;
        boolean z10 = this.aecMobileModeByDefault;
        return i8 + (z10 ? 1 : z10);
    }

    public String toString() {
        StringBuilder sbU = a.U("EchoCancellationInfo(builtinAecRequested=");
        sbU.append(this.builtinAecRequested);
        sbU.append(", builtinAecSupportedNative=");
        sbU.append(this.builtinAecSupportedNative);
        sbU.append(", builtinAecSupportedJava=");
        sbU.append(this.builtinAecSupportedJava);
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
        return a.O(sbU, this.aecMobileModeByDefault, ")");
    }

    public /* synthetic */ MediaEngine$EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? false : z8, (i & 128) != 0 ? false : z9, (i & 256) == 0 ? z10 : false);
    }
}
