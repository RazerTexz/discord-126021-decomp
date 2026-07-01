package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parse$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $positions;
    public final /* synthetic */ Model$JsonReader $reader;

    public GuildExperimentBucketDto$Parser$parse$2(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader) {
        this.$positions = ref$ObjectRef;
        this.$reader = model$JsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Ref$ObjectRef ref$ObjectRef = this.$positions;
        ?? NextList = this.$reader.nextList(new GuildExperimentBucketDto$Parser$parse$2$1(this));
        m.checkNotNullExpressionValue(NextList, "reader.nextList { parsePosition(reader) }");
        ref$ObjectRef.element = NextList;
    }
}
