package com.discord.models.experiments.dto;

import com.discord.api.guild.GuildFeature;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2$1<T> implements Model$JsonReader$ItemFactory<GuildFeature> {
    public final /* synthetic */ GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2 this$0;

    public GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2$1(GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2 guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2) {
        this.this$0 = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ GuildFeature get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final GuildFeature get() {
        return (GuildFeature) InboundGatewayGsonParser.fromJson(this.this$0.this$0.$reader, GuildFeature.class);
    }
}
