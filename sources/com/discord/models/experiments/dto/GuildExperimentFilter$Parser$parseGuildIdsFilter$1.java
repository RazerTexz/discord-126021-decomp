package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildIdsFilter$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $guildIds;
    public final /* synthetic */ Model.JsonReader $reader;

    public GuildExperimentFilter$Parser$parseGuildIdsFilter$1(Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$reader = jsonReader;
        this.$guildIds = ref$ObjectRef;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.$reader.nextListIndexed(new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildIdsFilter$1.1
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                GuildExperimentFilter$Parser$parseGuildIdsFilter$1.this.$reader.skipValue();
            }
        }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildIdsFilter$1.2
            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List] */
            @Override // java.lang.Runnable
            public final void run() {
                GuildExperimentFilter$Parser$parseGuildIdsFilter$1 guildExperimentFilter$Parser$parseGuildIdsFilter$1 = GuildExperimentFilter$Parser$parseGuildIdsFilter$1.this;
                guildExperimentFilter$Parser$parseGuildIdsFilter$1.$guildIds.element = guildExperimentFilter$Parser$parseGuildIdsFilter$1.$reader.nextList(new Model.JsonReader.ItemFactory<Long>() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter.Parser.parseGuildIdsFilter.1.2.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Long get() {
                        return GuildExperimentFilter$Parser$parseGuildIdsFilter$1.this.$reader.nextLongOrNull();
                    }
                });
            }
        });
    }
}
