package com.discord.models.experiments.dto;


/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2 implements Runnable {
    public final /* synthetic */ GuildExperimentFilter$Parser$parseGuildIdsFilter$1 this$0;

    public GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2(GuildExperimentFilter$Parser$parseGuildIdsFilter$1 guildExperimentFilter$Parser$parseGuildIdsFilter$1) {
        this.this$0 = guildExperimentFilter$Parser$parseGuildIdsFilter$1;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        GuildExperimentFilter$Parser$parseGuildIdsFilter$1 guildExperimentFilter$Parser$parseGuildIdsFilter$1 = this.this$0;
        guildExperimentFilter$Parser$parseGuildIdsFilter$1.$guildIds.element = guildExperimentFilter$Parser$parseGuildIdsFilter$1.$reader.nextList(new GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2$1(this));
    }
}
