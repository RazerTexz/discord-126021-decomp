package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentOverridesDto$Parser$parse$1$1<T> implements Model$JsonReader$ItemFactory<Long> {
    public final /* synthetic */ GuildExperimentOverridesDto$Parser$parse$1 this$0;

    public GuildExperimentOverridesDto$Parser$parse$1$1(GuildExperimentOverridesDto$Parser$parse$1 guildExperimentOverridesDto$Parser$parse$1) {
        this.this$0 = guildExperimentOverridesDto$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ Long get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Long get() {
        return Long.valueOf(this.this$0.$reader.nextLong(-1L));
    }
}
