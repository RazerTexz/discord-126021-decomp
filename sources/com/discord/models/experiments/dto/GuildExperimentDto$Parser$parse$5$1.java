package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$5$1<T> implements Model$JsonReader$ItemFactory<GuildExperimentOverridesDto> {
    public final /* synthetic */ GuildExperimentDto$Parser$parse$5 this$0;

    public GuildExperimentDto$Parser$parse$5$1(GuildExperimentDto$Parser$parse$5 guildExperimentDto$Parser$parse$5) {
        this.this$0 = guildExperimentDto$Parser$parse$5;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ GuildExperimentOverridesDto get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final GuildExperimentOverridesDto get() {
        return GuildExperimentOverridesDto$Parser.INSTANCE.parse(this.this$0.$jsonReader);
    }
}
