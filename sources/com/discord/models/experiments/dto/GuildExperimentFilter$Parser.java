package com.discord.models.experiments.dto;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.experiments.domain.ExperimentHash;
import d0.o;
import d0.t.h0;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.LongRange;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser {
    public static final GuildExperimentFilter$Parser INSTANCE;
    private static final long MAX_ID_HASH;
    private static final long MIN_ID_HASH;
    private static final Map<Long, Function1<Model$JsonReader, GuildExperimentFilter>> parsers;

    static {
        GuildExperimentFilter$Parser guildExperimentFilter$Parser = new GuildExperimentFilter$Parser();
        INSTANCE = guildExperimentFilter$Parser;
        ExperimentHash experimentHash = ExperimentHash.INSTANCE;
        parsers = h0.mapOf(o.to(Long.valueOf(experimentHash.from("guild_ids")), new GuildExperimentFilter$Parser$parsers$1(guildExperimentFilter$Parser)), o.to(Long.valueOf(experimentHash.from("guild_id_range")), new GuildExperimentFilter$Parser$parsers$2(guildExperimentFilter$Parser)), o.to(Long.valueOf(experimentHash.from("guild_member_count_range")), new GuildExperimentFilter$Parser$parsers$3(guildExperimentFilter$Parser)), o.to(Long.valueOf(experimentHash.from("guild_has_feature")), new GuildExperimentFilter$Parser$parsers$4(guildExperimentFilter$Parser)), o.to(Long.valueOf(experimentHash.from("guild_hub_types")), new GuildExperimentFilter$Parser$parsers$5(guildExperimentFilter$Parser)));
        MIN_ID_HASH = experimentHash.from("min_id");
        MAX_ID_HASH = experimentHash.from("max_id");
    }

    private GuildExperimentFilter$Parser() {
    }

    public static final /* synthetic */ long access$getMAX_ID_HASH$p(GuildExperimentFilter$Parser guildExperimentFilter$Parser) {
        return MAX_ID_HASH;
    }

    public static final /* synthetic */ long access$getMIN_ID_HASH$p(GuildExperimentFilter$Parser guildExperimentFilter$Parser) {
        return MIN_ID_HASH;
    }

    public static final /* synthetic */ GuildExperimentFilter$GuildHasFeatureFilter access$parseGuildHasFeatureFilter(GuildExperimentFilter$Parser guildExperimentFilter$Parser, Model$JsonReader model$JsonReader) {
        return guildExperimentFilter$Parser.parseGuildHasFeatureFilter(model$JsonReader);
    }

    public static final /* synthetic */ GuildExperimentFilter$GuildHubTypesFeatureFilter access$parseGuildHubTypesFeatureFilter(GuildExperimentFilter$Parser guildExperimentFilter$Parser, Model$JsonReader model$JsonReader) {
        return guildExperimentFilter$Parser.parseGuildHubTypesFeatureFilter(model$JsonReader);
    }

    public static final /* synthetic */ GuildExperimentFilter$GuildIdRangeFilter access$parseGuildIdRangeFilter(GuildExperimentFilter$Parser guildExperimentFilter$Parser, Model$JsonReader model$JsonReader) {
        return guildExperimentFilter$Parser.parseGuildIdRangeFilter(model$JsonReader);
    }

    public static final /* synthetic */ GuildExperimentFilter$GuildIdsFilter access$parseGuildIdsFilter(GuildExperimentFilter$Parser guildExperimentFilter$Parser, Model$JsonReader model$JsonReader) {
        return guildExperimentFilter$Parser.parseGuildIdsFilter(model$JsonReader);
    }

    public static final /* synthetic */ GuildExperimentFilter$GuildMemberCountRangeFilter access$parseGuildMemberCountRangeFilter(GuildExperimentFilter$Parser guildExperimentFilter$Parser, Model$JsonReader model$JsonReader) {
        return guildExperimentFilter$Parser.parseGuildMemberCountRangeFilter(model$JsonReader);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
    private final GuildExperimentFilter$GuildHasFeatureFilter parseGuildHasFeatureFilter(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = n0.emptySet();
        reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1(reader, ref$ObjectRef));
        return new GuildExperimentFilter$GuildHasFeatureFilter((Set) ref$ObjectRef.element);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
    private final GuildExperimentFilter$GuildHubTypesFeatureFilter parseGuildHubTypesFeatureFilter(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = n0.emptySet();
        reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1(reader, ref$ObjectRef));
        return new GuildExperimentFilter$GuildHubTypesFeatureFilter((Set) ref$ObjectRef.element);
    }

    private final GuildExperimentFilter$GuildIdRangeFilter parseGuildIdRangeFilter(Model$JsonReader reader) {
        return new GuildExperimentFilter$GuildIdRangeFilter(parseRange(reader));
    }

    private final GuildExperimentFilter$GuildIdsFilter parseGuildIdsFilter(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildIdsFilter$1(reader, ref$ObjectRef));
        List list = (List) ref$ObjectRef.element;
        m.checkNotNull(list);
        return new GuildExperimentFilter$GuildIdsFilter(u.toSet(list));
    }

    private final GuildExperimentFilter$GuildMemberCountRangeFilter parseGuildMemberCountRangeFilter(Model$JsonReader reader) {
        return new GuildExperimentFilter$GuildMemberCountRangeFilter(parseRange(reader));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LongRange parseRange(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        reader.nextList(new GuildExperimentFilter$Parser$parseRange$1(reader, ref$ObjectRef, ref$ObjectRef2));
        Long l = (Long) ref$ObjectRef.element;
        long jLongValue = l != null ? l.longValue() : 0L;
        Long l2 = (Long) ref$ObjectRef2.element;
        return new LongRange(jLongValue, l2 != null ? l2.longValue() : RecyclerView.FOREVER_NS);
    }

    public final Map<Long, Function1<Model$JsonReader, GuildExperimentFilter>> getParsers() {
        return parsers;
    }

    public final List<GuildExperimentFilter> parseFilters(Model$JsonReader reader) throws IOException {
        m.checkNotNullParameter(reader, "reader");
        ArrayList arrayList = new ArrayList();
        reader.nextList(new GuildExperimentFilter$Parser$parseFilters$1(reader, arrayList));
        return arrayList;
    }
}
