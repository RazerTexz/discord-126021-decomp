package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseFilters$1$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $filterHash;
    public final /* synthetic */ GuildExperimentFilter$Parser$parseFilters$1 this$0;

    public GuildExperimentFilter$Parser$parseFilters$1$2(GuildExperimentFilter$Parser$parseFilters$1 guildExperimentFilter$Parser$parseFilters$1, Ref$ObjectRef ref$ObjectRef) {
        this.this$0 = guildExperimentFilter$Parser$parseFilters$1;
        this.$filterHash = ref$ObjectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        GuildExperimentFilter guildExperimentFilterInvoke;
        Function1<Model$JsonReader, GuildExperimentFilter> function1 = GuildExperimentFilter$Parser.INSTANCE.getParsers().get((Long) this.$filterHash.element);
        if (function1 != null && (guildExperimentFilterInvoke = function1.invoke(this.this$0.$reader)) != null) {
            this.this$0.$filters.add(guildExperimentFilterInvoke);
        }
        this.$filterHash.element = null;
    }
}
