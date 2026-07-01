package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parse$1 implements Runnable {
    public final /* synthetic */ Ref$IntRef $bucketInt;
    public final /* synthetic */ Model$JsonReader $reader;

    public GuildExperimentBucketDto$Parser$parse$1(Ref$IntRef ref$IntRef, Model$JsonReader model$JsonReader) {
        this.$bucketInt = ref$IntRef;
        this.$reader = model$JsonReader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ref$IntRef ref$IntRef = this.$bucketInt;
        ref$IntRef.element = this.$reader.nextInt(ref$IntRef.element);
    }
}
