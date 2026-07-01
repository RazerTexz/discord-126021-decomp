package com.discord.widgets.chat.input.models;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: OptionRange.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class OptionRange {
    private final IntRange param;
    private final IntRange value;

    public OptionRange(IntRange intRange, IntRange intRange2) {
        m.checkNotNullParameter(intRange, "param");
        m.checkNotNullParameter(intRange2, "value");
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
        m.checkNotNullParameter(param, "param");
        m.checkNotNullParameter(value, "value");
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
        return m.areEqual(this.param, optionRange.param) && m.areEqual(this.value, optionRange.value);
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
        StringBuilder sbU = a.U("OptionRange(param=");
        sbU.append(this.param);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(")");
        return sbU.toString();
    }
}
