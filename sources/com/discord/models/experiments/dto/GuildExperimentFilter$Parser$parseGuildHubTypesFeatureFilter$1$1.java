package com.discord.models.experiments.dto;

import java.io.IOException;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1$1 implements Runnable {
    public final /* synthetic */ GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1 this$0;

    public GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1$1(GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1 guildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1) {
        this.this$0 = guildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.this$0.$reader.skipValue();
    }
}
