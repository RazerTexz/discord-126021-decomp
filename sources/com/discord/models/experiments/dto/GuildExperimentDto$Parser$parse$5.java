package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$5 implements Runnable {
    public final /* synthetic */ Model$JsonReader $jsonReader;
    public final /* synthetic */ Ref$ObjectRef $overrides;

    public GuildExperimentDto$Parser$parse$5(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader) {
        this.$overrides = ref$ObjectRef;
        this.$jsonReader = model$JsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Ref$ObjectRef ref$ObjectRef = this.$overrides;
        ?? NextList = this.$jsonReader.nextList(new GuildExperimentDto$Parser$parse$5$1(this));
        m.checkNotNullExpressionValue(NextList, "jsonReader.nextList { Gu…arser.parse(jsonReader) }");
        ref$ObjectRef.element = NextList;
    }
}
