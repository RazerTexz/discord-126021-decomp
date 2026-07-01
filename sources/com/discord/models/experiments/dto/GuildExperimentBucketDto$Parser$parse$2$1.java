package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader$ItemFactory;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parse$2$1<T> implements Model$JsonReader$ItemFactory<IntRange> {
    public final /* synthetic */ GuildExperimentBucketDto$Parser$parse$2 this$0;

    public GuildExperimentBucketDto$Parser$parse$2$1(GuildExperimentBucketDto$Parser$parse$2 guildExperimentBucketDto$Parser$parse$2) {
        this.this$0 = guildExperimentBucketDto$Parser$parse$2;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ IntRange get() {
        return get2();
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public final IntRange get2() {
        return GuildExperimentBucketDto$Parser.access$parsePosition(GuildExperimentBucketDto$Parser.INSTANCE, this.this$0.$reader);
    }
}
