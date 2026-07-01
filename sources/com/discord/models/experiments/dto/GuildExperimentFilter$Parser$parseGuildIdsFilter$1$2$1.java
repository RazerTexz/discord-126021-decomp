package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2$1<T> implements Model$JsonReader$ItemFactory<Long> {
    public final /* synthetic */ GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2 this$0;

    public GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2$1(GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2 guildExperimentFilter$Parser$parseGuildIdsFilter$1$2) {
        this.this$0 = guildExperimentFilter$Parser$parseGuildIdsFilter$1$2;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ Long get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Long get() {
        return this.this$0.this$0.$reader.nextLongOrNull();
    }
}
