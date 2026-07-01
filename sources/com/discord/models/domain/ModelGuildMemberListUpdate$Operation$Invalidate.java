package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate$Operation$Invalidate extends ModelGuildMemberListUpdate$Operation {
    private final IntRange range;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelGuildMemberListUpdate$Operation$Invalidate(IntRange intRange) {
        super(null, null, 3, null);
        m.checkNotNullParameter(intRange, "range");
        this.range = intRange;
    }

    public static /* synthetic */ ModelGuildMemberListUpdate$Operation$Invalidate copy$default(ModelGuildMemberListUpdate$Operation$Invalidate modelGuildMemberListUpdate$Operation$Invalidate, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            intRange = modelGuildMemberListUpdate$Operation$Invalidate.range;
        }
        return modelGuildMemberListUpdate$Operation$Invalidate.copy(intRange);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    public final ModelGuildMemberListUpdate$Operation$Invalidate copy(IntRange range) {
        m.checkNotNullParameter(range, "range");
        return new ModelGuildMemberListUpdate$Operation$Invalidate(range);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelGuildMemberListUpdate$Operation$Invalidate) && m.areEqual(this.range, ((ModelGuildMemberListUpdate$Operation$Invalidate) other).range);
        }
        return true;
    }

    public final IntRange getRange() {
        return this.range;
    }

    public int hashCode() {
        IntRange intRange = this.range;
        if (intRange != null) {
            return intRange.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Invalidate(range=");
        sbU.append(this.range);
        sbU.append(")");
        return sbU.toString();
    }
}
