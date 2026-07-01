package com.discord.models.experiments.dto;

import d0.t.u;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2 implements Runnable {
    public final /* synthetic */ GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 this$0;

    public GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2(GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1) {
        this.this$0 = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.Set] */
    @Override // java.lang.Runnable
    public final void run() throws IOException {
        GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 = this.this$0;
        Ref$ObjectRef ref$ObjectRef = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.$features;
        List listNextList = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.$reader.nextList(new GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2$1(this));
        m.checkNotNullExpressionValue(listNextList, "reader.nextList {\n      …ass.java)\n              }");
        ref$ObjectRef.element = u.toSet(listNextList);
    }
}
