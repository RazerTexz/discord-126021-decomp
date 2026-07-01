package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GuildExperimentFilter$Parser$parsers$1 extends k implements Function1<Model$JsonReader, GuildExperimentFilter$GuildIdsFilter> {
    public GuildExperimentFilter$Parser$parsers$1(GuildExperimentFilter$Parser guildExperimentFilter$Parser) {
        super(1, guildExperimentFilter$Parser, GuildExperimentFilter$Parser.class, "parseGuildIdsFilter", "parseGuildIdsFilter(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdsFilter;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildExperimentFilter$GuildIdsFilter invoke(Model$JsonReader model$JsonReader) {
        return invoke2(model$JsonReader);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildExperimentFilter$GuildIdsFilter invoke2(Model$JsonReader model$JsonReader) {
        m.checkNotNullParameter(model$JsonReader, "p1");
        return GuildExperimentFilter$Parser.access$parseGuildIdsFilter((GuildExperimentFilter$Parser) this.receiver, model$JsonReader);
    }
}
