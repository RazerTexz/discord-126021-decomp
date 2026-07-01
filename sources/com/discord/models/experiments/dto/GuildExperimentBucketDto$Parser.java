package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import d0.t.n;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser {
    public static final GuildExperimentBucketDto$Parser INSTANCE = new GuildExperimentBucketDto$Parser();

    private GuildExperimentBucketDto$Parser() {
    }

    public static final /* synthetic */ IntRange access$parsePosition(GuildExperimentBucketDto$Parser guildExperimentBucketDto$Parser, Model$JsonReader model$JsonReader) {
        return guildExperimentBucketDto$Parser.parsePosition(model$JsonReader);
    }

    private final IntRange parsePosition(Model$JsonReader jsonReader) throws IOException {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = -1;
        jsonReader.nextObject(new GuildExperimentBucketDto$Parser$parsePosition$1(ref$IntRef, jsonReader, ref$IntRef2));
        return new IntRange(ref$IntRef.element, ref$IntRef2.element);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
    public final GuildExperimentBucketDto parse(Model$JsonReader reader) throws IOException {
        m.checkNotNullParameter(reader, "reader");
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = n.emptyList();
        reader.nextListIndexed(new GuildExperimentBucketDto$Parser$parse$1(ref$IntRef, reader), new GuildExperimentBucketDto$Parser$parse$2(ref$ObjectRef, reader));
        return new GuildExperimentBucketDto(ref$IntRef.element, (List) ref$ObjectRef.element);
    }
}
