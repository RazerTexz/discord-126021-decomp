package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$4 implements Runnable {
    public final /* synthetic */ Model$JsonReader $jsonReader;
    public final /* synthetic */ Ref$ObjectRef $populations;

    public GuildExperimentDto$Parser$parse$4(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader) {
        this.$populations = ref$ObjectRef;
        this.$jsonReader = model$JsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$populations.element = this.$jsonReader.nextList(new GuildExperimentDto$Parser$parse$4$1(this));
    }
}
