package com.discord.models.experiments.dto;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.ranges.LongRange;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentFilter$GuildMemberCountRangeFilter extends GuildExperimentFilter {
    private final LongRange range;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildExperimentFilter$GuildMemberCountRangeFilter(LongRange longRange) {
        super(null);
        m.checkNotNullParameter(longRange, "range");
        this.range = longRange;
    }

    public static /* synthetic */ GuildExperimentFilter$GuildMemberCountRangeFilter copy$default(GuildExperimentFilter$GuildMemberCountRangeFilter guildExperimentFilter$GuildMemberCountRangeFilter, LongRange longRange, int i, Object obj) {
        if ((i & 1) != 0) {
            longRange = guildExperimentFilter$GuildMemberCountRangeFilter.range;
        }
        return guildExperimentFilter$GuildMemberCountRangeFilter.copy(longRange);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LongRange getRange() {
        return this.range;
    }

    public final GuildExperimentFilter$GuildMemberCountRangeFilter copy(LongRange range) {
        m.checkNotNullParameter(range, "range");
        return new GuildExperimentFilter$GuildMemberCountRangeFilter(range);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildExperimentFilter$GuildMemberCountRangeFilter) && m.areEqual(this.range, ((GuildExperimentFilter$GuildMemberCountRangeFilter) other).range);
        }
        return true;
    }

    public final LongRange getRange() {
        return this.range;
    }

    public int hashCode() {
        LongRange longRange = this.range;
        if (longRange != null) {
            return longRange.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildMemberCountRangeFilter(range=");
        sbU.append(this.range);
        sbU.append(")");
        return sbU.toString();
    }
}
