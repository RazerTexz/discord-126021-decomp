package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $hubTypes;
    public final /* synthetic */ Model$JsonReader $reader;

    public GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1(Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$reader = model$JsonReader;
        this.$hubTypes = ref$ObjectRef;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.$reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1$1(this), new GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1$2(this));
    }
}
