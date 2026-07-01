package com.discord.models.experiments.dto;

import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseRange$1$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $fieldHash;
    public final /* synthetic */ GuildExperimentFilter$Parser$parseRange$1 this$0;

    public GuildExperimentFilter$Parser$parseRange$1$1(GuildExperimentFilter$Parser$parseRange$1 guildExperimentFilter$Parser$parseRange$1, Ref$ObjectRef ref$ObjectRef) {
        this.this$0 = guildExperimentFilter$Parser$parseRange$1;
        this.$fieldHash = ref$ObjectRef;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Long] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$fieldHash.element = this.this$0.$reader.nextLongOrNull();
    }
}
