package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentPopulationDto$Parser$parse$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $buckets;
    public final /* synthetic */ Model$JsonReader $jsonReader;

    public GuildExperimentPopulationDto$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader) {
        this.$buckets = ref$ObjectRef;
        this.$jsonReader = model$JsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$buckets.element = this.$jsonReader.nextList(new GuildExperimentPopulationDto$Parser$parse$1$1(this));
    }
}
