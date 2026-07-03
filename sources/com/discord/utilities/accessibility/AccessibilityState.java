package com.discord.utilities.accessibility;

import java.util.EnumSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AccessibilityState {
    private final EnumSet<AccessibilityFeatureFlags> features;

    /* JADX WARN: Multi-variable type inference failed */
    public AccessibilityState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AccessibilityState(EnumSet<AccessibilityFeatureFlags> enumSet) {
        C12238m.checkNotNullParameter(enumSet, "features");
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
        C12238m.checkNotNullParameter(features, "features");
        return new AccessibilityState(features);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AccessibilityState) && C12238m.areEqual(this.features, ((AccessibilityState) other).features);
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
        StringBuilder sbM833U = C1643a.m833U("AccessibilityState(features=");
        sbM833U.append(this.features);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AccessibilityState(EnumSet enumSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            enumSet = EnumSet.of(AccessibilityFeatureFlags.NONE);
            C12238m.checkNotNullExpressionValue(enumSet, "EnumSet.of(AccessibilityFeatureFlags.NONE)");
        }
        this(enumSet);
    }
}
