package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import d0.t.n;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentOverridesDto$Parser {
    public static final GuildExperimentOverridesDto$Parser INSTANCE = new GuildExperimentOverridesDto$Parser();

    private GuildExperimentOverridesDto$Parser() {
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
    public final GuildExperimentOverridesDto parse(Model$JsonReader reader) throws IOException {
        m.checkNotNullParameter(reader, "reader");
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = n.emptyList();
        reader.nextObject(new GuildExperimentOverridesDto$Parser$parse$1(ref$IntRef, reader, ref$ObjectRef));
        return new GuildExperimentOverridesDto(ref$IntRef.element, (List) ref$ObjectRef.element);
    }
}
