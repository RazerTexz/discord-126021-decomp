package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GuildExperimentFilter$Parser$parsers$2 extends C12236k implements Function1<Model.JsonReader, GuildExperimentFilter.GuildIdRangeFilter> {
    public GuildExperimentFilter$Parser$parsers$2(GuildExperimentFilter.Parser parser) {
        super(1, parser, GuildExperimentFilter.Parser.class, "parseGuildIdRangeFilter", "parseGuildIdRangeFilter(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdRangeFilter;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final GuildExperimentFilter.GuildIdRangeFilter invoke(Model.JsonReader jsonReader) {
        C12238m.checkNotNullParameter(jsonReader, "p1");
        return ((GuildExperimentFilter.Parser) this.receiver).parseGuildIdRangeFilter(jsonReader);
    }
}
