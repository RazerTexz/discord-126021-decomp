package com.discord.models.experiments.dto;

import b.d.b.a.a;
import com.discord.api.guild.GuildFeature;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentFilter$GuildHasFeatureFilter extends GuildExperimentFilter {
    private final Set<GuildFeature> features;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildExperimentFilter$GuildHasFeatureFilter(Set<? extends GuildFeature> set) {
        super(null);
        m.checkNotNullParameter(set, "features");
        this.features = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentFilter$GuildHasFeatureFilter copy$default(GuildExperimentFilter$GuildHasFeatureFilter guildExperimentFilter$GuildHasFeatureFilter, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = guildExperimentFilter$GuildHasFeatureFilter.features;
        }
        return guildExperimentFilter$GuildHasFeatureFilter.copy(set);
    }

    public final Set<GuildFeature> component1() {
        return this.features;
    }

    public final GuildExperimentFilter$GuildHasFeatureFilter copy(Set<? extends GuildFeature> features) {
        m.checkNotNullParameter(features, "features");
        return new GuildExperimentFilter$GuildHasFeatureFilter(features);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildExperimentFilter$GuildHasFeatureFilter) && m.areEqual(this.features, ((GuildExperimentFilter$GuildHasFeatureFilter) other).features);
        }
        return true;
    }

    public final Set<GuildFeature> getFeatures() {
        return this.features;
    }

    public int hashCode() {
        Set<GuildFeature> set = this.features;
        if (set != null) {
            return set.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.N(a.U("GuildHasFeatureFilter(features="), this.features, ")");
    }
}
