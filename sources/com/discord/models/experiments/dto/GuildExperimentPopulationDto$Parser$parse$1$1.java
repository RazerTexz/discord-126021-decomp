package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentPopulationDto$Parser$parse$1$1<T> implements Model$JsonReader$ItemFactory<GuildExperimentBucketDto> {
    public final /* synthetic */ GuildExperimentPopulationDto$Parser$parse$1 this$0;

    public GuildExperimentPopulationDto$Parser$parse$1$1(GuildExperimentPopulationDto$Parser$parse$1 guildExperimentPopulationDto$Parser$parse$1) {
        this.this$0 = guildExperimentPopulationDto$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ GuildExperimentBucketDto get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final GuildExperimentBucketDto get() {
        return GuildExperimentBucketDto$Parser.INSTANCE.parse(this.this$0.$jsonReader);
    }
}
