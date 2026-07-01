package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$4$1<T> implements Model$JsonReader$ItemFactory<GuildExperimentPopulationDto> {
    public final /* synthetic */ GuildExperimentDto$Parser$parse$4 this$0;

    public GuildExperimentDto$Parser$parse$4$1(GuildExperimentDto$Parser$parse$4 guildExperimentDto$Parser$parse$4) {
        this.this$0 = guildExperimentDto$Parser$parse$4;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ GuildExperimentPopulationDto get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final GuildExperimentPopulationDto get() {
        return GuildExperimentPopulationDto$Parser.INSTANCE.parse(this.this$0.$jsonReader);
    }
}
