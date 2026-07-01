package com.discord.models.experiments.dto;

import b.d.b.a.a;
import com.discord.models.domain.Model$JsonReader;
import d0.t.n;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentPopulationDto$Parser {
    public static final GuildExperimentPopulationDto$Parser INSTANCE = new GuildExperimentPopulationDto$Parser();

    private GuildExperimentPopulationDto$Parser() {
    }

    public final GuildExperimentPopulationDto parse(Model$JsonReader jsonReader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(jsonReader, "jsonReader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        jsonReader.nextListIndexed(new GuildExperimentPopulationDto$Parser$parse$1(ref$ObjectRefC0, jsonReader), new GuildExperimentPopulationDto$Parser$parse$2(ref$ObjectRef, jsonReader));
        List list = (List) ref$ObjectRefC0.element;
        m.checkNotNull(list);
        List listEmptyList = (List) ref$ObjectRef.element;
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        return new GuildExperimentPopulationDto(list, listEmptyList);
    }
}
