package com.discord.widgets.chat.input.models;

import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: OptionRange.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class OptionRange {
    private final IntRange param;
    private final IntRange value;

    public OptionRange(IntRange intRange, IntRange intRange2) {
        C12238m.checkNotNullParameter(intRange, "param");
        C12238m.checkNotNullParameter(intRange2, "value");
        this.param = intRange;
        this.value = intRange2;
    }

    public static /* synthetic */ OptionRange copy$default(OptionRange optionRange, IntRange intRange, IntRange intRange2, int i, Object obj) {
        if ((i & 1) != 0) {
            intRange = optionRange.param;
        }
        if ((i & 2) != 0) {
            intRange2 = optionRange.value;
        }
        return optionRange.copy(intRange, intRange2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IntRange getParam() {
        return this.param;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IntRange getValue() {
        return this.value;
    }

    public final OptionRange copy(IntRange param, IntRange value) {
        C12238m.checkNotNullParameter(param, "param");
        C12238m.checkNotNullParameter(value, "value");
        return new OptionRange(param, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OptionRange)) {
            return false;
        }
        OptionRange optionRange = (OptionRange) other;
        return C12238m.areEqual(this.param, optionRange.param) && C12238m.areEqual(this.value, optionRange.value);
    }

    public final IntRange getParam() {
        return this.param;
    }

    public final IntRange getValue() {
        return this.value;
    }

    public int hashCode() {
        IntRange intRange = this.param;
        int iHashCode = (intRange != null ? intRange.hashCode() : 0) * 31;
        IntRange intRange2 = this.value;
        return iHashCode + (intRange2 != null ? intRange2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("OptionRange(param=");
        sbM833U.append(this.param);
        sbM833U.append(", value=");
        sbM833U.append(this.value);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
