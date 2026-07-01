package com.discord.models.experiments.dto;

import b.d.b.a.a;
import com.discord.api.guild.GuildHubType;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentFilter$GuildHubTypesFeatureFilter extends GuildExperimentFilter {
    private final Set<GuildHubType> hubTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildExperimentFilter$GuildHubTypesFeatureFilter(Set<? extends GuildHubType> set) {
        super(null);
        m.checkNotNullParameter(set, "hubTypes");
        this.hubTypes = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentFilter$GuildHubTypesFeatureFilter copy$default(GuildExperimentFilter$GuildHubTypesFeatureFilter guildExperimentFilter$GuildHubTypesFeatureFilter, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = guildExperimentFilter$GuildHubTypesFeatureFilter.hubTypes;
        }
        return guildExperimentFilter$GuildHubTypesFeatureFilter.copy(set);
    }

    public final Set<GuildHubType> component1() {
        return this.hubTypes;
    }

    public final GuildExperimentFilter$GuildHubTypesFeatureFilter copy(Set<? extends GuildHubType> hubTypes) {
        m.checkNotNullParameter(hubTypes, "hubTypes");
        return new GuildExperimentFilter$GuildHubTypesFeatureFilter(hubTypes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildExperimentFilter$GuildHubTypesFeatureFilter) && m.areEqual(this.hubTypes, ((GuildExperimentFilter$GuildHubTypesFeatureFilter) other).hubTypes);
        }
        return true;
    }

    public final Set<GuildHubType> getHubTypes() {
        return this.hubTypes;
    }

    public int hashCode() {
        Set<GuildHubType> set = this.hubTypes;
        if (set != null) {
            return set.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.N(a.U("GuildHubTypesFeatureFilter(hubTypes="), this.hubTypes, ")");
    }
}
