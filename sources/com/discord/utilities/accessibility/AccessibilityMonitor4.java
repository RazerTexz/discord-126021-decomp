package com.discord.utilities.accessibility;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.EnumSet;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.utilities.accessibility.AccessibilityState, reason: use source file name */
/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AccessibilityMonitor4 {
    private final EnumSet<AccessibilityFeatureFlags> features;

    /* JADX WARN: Multi-variable type inference failed */
    public AccessibilityMonitor4() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AccessibilityMonitor4(EnumSet<AccessibilityFeatureFlags> enumSet) {
        Intrinsics3.checkNotNullParameter(enumSet, "features");
        this.features = enumSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AccessibilityMonitor4 copy$default(AccessibilityMonitor4 accessibilityMonitor4, EnumSet enumSet, int i, Object obj) {
        if ((i & 1) != 0) {
            enumSet = accessibilityMonitor4.features;
        }
        return accessibilityMonitor4.copy(enumSet);
    }

    public final EnumSet<AccessibilityFeatureFlags> component1() {
        return this.features;
    }

    public final AccessibilityMonitor4 copy(EnumSet<AccessibilityFeatureFlags> features) {
        Intrinsics3.checkNotNullParameter(features, "features");
        return new AccessibilityMonitor4(features);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AccessibilityMonitor4) && Intrinsics3.areEqual(this.features, ((AccessibilityMonitor4) other).features);
        }
        return true;
    }

    public final EnumSet<AccessibilityFeatureFlags> getFeatures() {
        return this.features;
    }

    public int hashCode() {
        EnumSet<AccessibilityFeatureFlags> enumSet = this.features;
        if (enumSet != null) {
            return enumSet.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("AccessibilityState(features=");
        sbU.append(this.features);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AccessibilityMonitor4(EnumSet enumSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            enumSet = EnumSet.of(AccessibilityFeatureFlags.NONE);
            Intrinsics3.checkNotNullExpressionValue(enumSet, "EnumSet.of(AccessibilityFeatureFlags.NONE)");
        }
        this(enumSet);
    }
}
