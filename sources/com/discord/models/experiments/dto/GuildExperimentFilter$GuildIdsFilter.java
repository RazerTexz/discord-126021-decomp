package com.discord.models.experiments.dto;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentFilter$GuildIdsFilter extends GuildExperimentFilter {
    private final Set<Long> guildIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildExperimentFilter$GuildIdsFilter(Set<Long> set) {
        super(null);
        m.checkNotNullParameter(set, "guildIds");
        this.guildIds = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentFilter$GuildIdsFilter copy$default(GuildExperimentFilter$GuildIdsFilter guildExperimentFilter$GuildIdsFilter, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = guildExperimentFilter$GuildIdsFilter.guildIds;
        }
        return guildExperimentFilter$GuildIdsFilter.copy(set);
    }

    public final Set<Long> component1() {
        return this.guildIds;
    }

    public final GuildExperimentFilter$GuildIdsFilter copy(Set<Long> guildIds) {
        m.checkNotNullParameter(guildIds, "guildIds");
        return new GuildExperimentFilter$GuildIdsFilter(guildIds);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildExperimentFilter$GuildIdsFilter) && m.areEqual(this.guildIds, ((GuildExperimentFilter$GuildIdsFilter) other).guildIds);
        }
        return true;
    }

    public final Set<Long> getGuildIds() {
        return this.guildIds;
    }

    public int hashCode() {
        Set<Long> set = this.guildIds;
        if (set != null) {
            return set.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.N(a.U("GuildIdsFilter(guildIds="), this.guildIds, ")");
    }
}
