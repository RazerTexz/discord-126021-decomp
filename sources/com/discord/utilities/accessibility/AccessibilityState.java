package com.discord.utilities.accessibility;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.EnumSet;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AccessibilityState {
    private final EnumSet<AccessibilityFeatureFlags> features;

    public AccessibilityState() {
        this(null, 1, null);
    }

    public AccessibilityState(EnumSet<AccessibilityFeatureFlags> enumSet) {
        m.checkNotNullParameter(enumSet, "features");
        this.features = enumSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AccessibilityState copy$default(AccessibilityState accessibilityState, EnumSet enumSet, int i, Object obj) {
        if ((i & 1) != 0) {
            enumSet = accessibilityState.features;
        }
        return accessibilityState.copy(enumSet);
    }

    public final EnumSet<AccessibilityFeatureFlags> component1() {
        return this.features;
    }

    public final AccessibilityState copy(EnumSet<AccessibilityFeatureFlags> features) {
        m.checkNotNullParameter(features, "features");
        return new AccessibilityState(features);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AccessibilityState) && m.areEqual(this.features, ((AccessibilityState) other).features);
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
        StringBuilder sbU = a.U("AccessibilityState(features=");
        sbU.append(this.features);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AccessibilityState(EnumSet enumSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            enumSet = EnumSet.of(AccessibilityFeatureFlags.NONE);
            m.checkNotNullExpressionValue(enumSet, "EnumSet.of(AccessibilityFeatureFlags.NONE)");
        }
        this(enumSet);
    }
}
