package com.discord.widgets.chat.list;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateThreadsFeatureFlag$Companion {
    private CreateThreadsFeatureFlag$Companion() {
    }

    public final boolean computeIsEnabled(Experiment createExperiment, Experiment rolloutExperiment, Guild guild) {
        if (guild == null) {
            return false;
        }
        if (guild.hasFeature(GuildFeature.THREADS_ENABLED)) {
            return true;
        }
        return ((rolloutExperiment != null && rolloutExperiment.getBucket() == 2) || !guild.hasFeature(GuildFeature.COMMUNITY)) && createExperiment != null && createExperiment.getBucket() == 1;
    }

    public final CreateThreadsFeatureFlag getINSTANCE() {
        Lazy lazyAccess$getINSTANCE$cp = CreateThreadsFeatureFlag.access$getINSTANCE$cp();
        CreateThreadsFeatureFlag$Companion createThreadsFeatureFlag$Companion = CreateThreadsFeatureFlag.Companion;
        return (CreateThreadsFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
    }

    public /* synthetic */ CreateThreadsFeatureFlag$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
