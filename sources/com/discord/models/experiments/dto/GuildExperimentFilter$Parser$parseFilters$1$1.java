package com.discord.models.experiments.dto;

import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseFilters$1$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $filterHash;
    public final /* synthetic */ GuildExperimentFilter$Parser$parseFilters$1 this$0;

    public GuildExperimentFilter$Parser$parseFilters$1$1(GuildExperimentFilter$Parser$parseFilters$1 guildExperimentFilter$Parser$parseFilters$1, Ref$ObjectRef ref$ObjectRef) {
        this.this$0 = guildExperimentFilter$Parser$parseFilters$1;
        this.$filterHash = ref$ObjectRef;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Long] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$filterHash.element = this.this$0.$reader.nextLongOrNull();
    }
}
