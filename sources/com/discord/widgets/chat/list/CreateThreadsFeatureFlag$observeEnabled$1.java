package com.discord.widgets.chat.list;

import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import d0.z.d.k;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class CreateThreadsFeatureFlag$observeEnabled$1 extends k implements Function3<Experiment, Experiment, Guild, Boolean> {
    public CreateThreadsFeatureFlag$observeEnabled$1(CreateThreadsFeatureFlag$Companion createThreadsFeatureFlag$Companion) {
        super(3, createThreadsFeatureFlag$Companion, CreateThreadsFeatureFlag$Companion.class, "computeIsEnabled", "computeIsEnabled(Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/guild/Guild;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(Experiment experiment, Experiment experiment2, Guild guild) {
        return Boolean.valueOf(invoke2(experiment, experiment2, guild));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Experiment experiment, Experiment experiment2, Guild guild) {
        return ((CreateThreadsFeatureFlag$Companion) this.receiver).computeIsEnabled(experiment, experiment2, guild);
    }
}
