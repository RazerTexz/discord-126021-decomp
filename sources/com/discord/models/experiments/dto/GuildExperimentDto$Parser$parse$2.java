package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $hashKey;
    public final /* synthetic */ Model$JsonReader $jsonReader;

    public GuildExperimentDto$Parser$parse$2(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader) {
        this.$hashKey = ref$ObjectRef;
        this.$jsonReader = model$JsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$hashKey.element = this.$jsonReader.nextStringOrNull();
    }
}
