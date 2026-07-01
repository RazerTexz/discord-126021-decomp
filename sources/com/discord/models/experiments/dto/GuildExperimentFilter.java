package com.discord.models.experiments.dto;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildHubType;
import com.discord.models.domain.Model;
import com.discord.models.experiments.domain.ExperimentHash;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges3;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class GuildExperimentFilter {

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildHasFeatureFilter extends GuildExperimentFilter {
        private final Set<GuildFeature> features;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildHasFeatureFilter(Set<? extends GuildFeature> set) {
            super(null);
            Intrinsics3.checkNotNullParameter(set, "features");
            this.features = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildHasFeatureFilter copy$default(GuildHasFeatureFilter guildHasFeatureFilter, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildHasFeatureFilter.features;
            }
            return guildHasFeatureFilter.copy(set);
        }

        public final Set<GuildFeature> component1() {
            return this.features;
        }

        public final GuildHasFeatureFilter copy(Set<? extends GuildFeature> features) {
            Intrinsics3.checkNotNullParameter(features, "features");
            return new GuildHasFeatureFilter(features);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildHasFeatureFilter) && Intrinsics3.areEqual(this.features, ((GuildHasFeatureFilter) other).features);
            }
            return true;
        }

        public final Set<GuildFeature> getFeatures() {
            return this.features;
        }

        public int hashCode() {
            Set<GuildFeature> set = this.features;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.N(outline.U("GuildHasFeatureFilter(features="), this.features, ")");
        }
    }

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildHubTypesFeatureFilter extends GuildExperimentFilter {
        private final Set<GuildHubType> hubTypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildHubTypesFeatureFilter(Set<? extends GuildHubType> set) {
            super(null);
            Intrinsics3.checkNotNullParameter(set, "hubTypes");
            this.hubTypes = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildHubTypesFeatureFilter copy$default(GuildHubTypesFeatureFilter guildHubTypesFeatureFilter, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildHubTypesFeatureFilter.hubTypes;
            }
            return guildHubTypesFeatureFilter.copy(set);
        }

        public final Set<GuildHubType> component1() {
            return this.hubTypes;
        }

        public final GuildHubTypesFeatureFilter copy(Set<? extends GuildHubType> hubTypes) {
            Intrinsics3.checkNotNullParameter(hubTypes, "hubTypes");
            return new GuildHubTypesFeatureFilter(hubTypes);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildHubTypesFeatureFilter) && Intrinsics3.areEqual(this.hubTypes, ((GuildHubTypesFeatureFilter) other).hubTypes);
            }
            return true;
        }

        public final Set<GuildHubType> getHubTypes() {
            return this.hubTypes;
        }

        public int hashCode() {
            Set<GuildHubType> set = this.hubTypes;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.N(outline.U("GuildHubTypesFeatureFilter(hubTypes="), this.hubTypes, ")");
        }
    }

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildIdRangeFilter extends GuildExperimentFilter {
        private final Ranges3 range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildIdRangeFilter(Ranges3 ranges3) {
            super(null);
            Intrinsics3.checkNotNullParameter(ranges3, "range");
            this.range = ranges3;
        }

        public static /* synthetic */ GuildIdRangeFilter copy$default(GuildIdRangeFilter guildIdRangeFilter, Ranges3 ranges3, int i, Object obj) {
            if ((i & 1) != 0) {
                ranges3 = guildIdRangeFilter.range;
            }
            return guildIdRangeFilter.copy(ranges3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Ranges3 getRange() {
            return this.range;
        }

        public final GuildIdRangeFilter copy(Ranges3 range) {
            Intrinsics3.checkNotNullParameter(range, "range");
            return new GuildIdRangeFilter(range);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildIdRangeFilter) && Intrinsics3.areEqual(this.range, ((GuildIdRangeFilter) other).range);
            }
            return true;
        }

        public final Ranges3 getRange() {
            return this.range;
        }

        public int hashCode() {
            Ranges3 ranges3 = this.range;
            if (ranges3 != null) {
                return ranges3.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildIdRangeFilter(range=");
            sbU.append(this.range);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildIdsFilter extends GuildExperimentFilter {
        private final Set<Long> guildIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildIdsFilter(Set<Long> set) {
            super(null);
            Intrinsics3.checkNotNullParameter(set, "guildIds");
            this.guildIds = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildIdsFilter copy$default(GuildIdsFilter guildIdsFilter, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildIdsFilter.guildIds;
            }
            return guildIdsFilter.copy(set);
        }

        public final Set<Long> component1() {
            return this.guildIds;
        }

        public final GuildIdsFilter copy(Set<Long> guildIds) {
            Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
            return new GuildIdsFilter(guildIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildIdsFilter) && Intrinsics3.areEqual(this.guildIds, ((GuildIdsFilter) other).guildIds);
            }
            return true;
        }

        public final Set<Long> getGuildIds() {
            return this.guildIds;
        }

        public int hashCode() {
            Set<Long> set = this.guildIds;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.N(outline.U("GuildIdsFilter(guildIds="), this.guildIds, ")");
        }
    }

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildMemberCountRangeFilter extends GuildExperimentFilter {
        private final Ranges3 range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMemberCountRangeFilter(Ranges3 ranges3) {
            super(null);
            Intrinsics3.checkNotNullParameter(ranges3, "range");
            this.range = ranges3;
        }

        public static /* synthetic */ GuildMemberCountRangeFilter copy$default(GuildMemberCountRangeFilter guildMemberCountRangeFilter, Ranges3 ranges3, int i, Object obj) {
            if ((i & 1) != 0) {
                ranges3 = guildMemberCountRangeFilter.range;
            }
            return guildMemberCountRangeFilter.copy(ranges3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Ranges3 getRange() {
            return this.range;
        }

        public final GuildMemberCountRangeFilter copy(Ranges3 range) {
            Intrinsics3.checkNotNullParameter(range, "range");
            return new GuildMemberCountRangeFilter(range);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildMemberCountRangeFilter) && Intrinsics3.areEqual(this.range, ((GuildMemberCountRangeFilter) other).range);
            }
            return true;
        }

        public final Ranges3 getRange() {
            return this.range;
        }

        public int hashCode() {
            Ranges3 ranges3 = this.range;
            if (ranges3 != null) {
                return ranges3.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildMemberCountRangeFilter(range=");
            sbU.append(this.range);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final class Parser {
        public static final Parser INSTANCE;
        private static final long MAX_ID_HASH;
        private static final long MIN_ID_HASH;
        private static final Map<Long, Function1<Model.JsonReader, GuildExperimentFilter>> parsers;

        static {
            Parser parser = new Parser();
            INSTANCE = parser;
            ExperimentHash experimentHash = ExperimentHash.INSTANCE;
            parsers = Maps6.mapOf(Tuples.to(Long.valueOf(experimentHash.from("guild_ids")), new GuildExperimentFilter$Parser$parsers$1(parser)), Tuples.to(Long.valueOf(experimentHash.from("guild_id_range")), new GuildExperimentFilter$Parser$parsers$2(parser)), Tuples.to(Long.valueOf(experimentHash.from("guild_member_count_range")), new GuildExperimentFilter$Parser$parsers$3(parser)), Tuples.to(Long.valueOf(experimentHash.from("guild_has_feature")), new GuildExperimentFilter$Parser$parsers$4(parser)), Tuples.to(Long.valueOf(experimentHash.from("guild_hub_types")), new GuildExperimentFilter$Parser$parsers$5(parser)));
            MIN_ID_HASH = experimentHash.from("min_id");
            MAX_ID_HASH = experimentHash.from("max_id");
        }

        private Parser() {
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
        private final GuildHasFeatureFilter parseGuildHasFeatureFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Sets5.emptySet();
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1(reader, ref$ObjectRef));
            return new GuildHasFeatureFilter((Set) ref$ObjectRef.element);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
        private final GuildHubTypesFeatureFilter parseGuildHubTypesFeatureFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Sets5.emptySet();
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1(reader, ref$ObjectRef));
            return new GuildHubTypesFeatureFilter((Set) ref$ObjectRef.element);
        }

        private final GuildIdRangeFilter parseGuildIdRangeFilter(Model.JsonReader reader) {
            return new GuildIdRangeFilter(parseRange(reader));
        }

        private final GuildIdsFilter parseGuildIdsFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildIdsFilter$1(reader, ref$ObjectRef));
            List list = (List) ref$ObjectRef.element;
            Intrinsics3.checkNotNull(list);
            return new GuildIdsFilter(_Collections.toSet(list));
        }

        private final GuildMemberCountRangeFilter parseGuildMemberCountRangeFilter(Model.JsonReader reader) {
            return new GuildMemberCountRangeFilter(parseRange(reader));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final Ranges3 parseRange(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextList(new Model.JsonReader.ItemFactory<Unit>() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseRange$1
                @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                public /* bridge */ /* synthetic */ Unit get() throws IOException {
                    get2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
                public final void get2() throws IOException {
                    final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                    ref$ObjectRef3.element = null;
                    reader.nextListIndexed(new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseRange$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ref$ObjectRef3.element = (T) reader.nextLongOrNull();
                        }
                    }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseRange$1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Long l = (Long) ref$ObjectRef3.element;
                            GuildExperimentFilter.Parser parser = GuildExperimentFilter.Parser.INSTANCE;
                            long j = GuildExperimentFilter.Parser.MIN_ID_HASH;
                            if (l != null && l.longValue() == j) {
                                GuildExperimentFilter$Parser$parseRange$1 guildExperimentFilter$Parser$parseRange$1 = GuildExperimentFilter$Parser$parseRange$1.this;
                                ref$ObjectRef.element = (T) reader.nextLongOrNull();
                            } else {
                                Long l2 = (Long) ref$ObjectRef3.element;
                                long j2 = GuildExperimentFilter.Parser.MAX_ID_HASH;
                                if (l2 != null && l2.longValue() == j2) {
                                    GuildExperimentFilter$Parser$parseRange$1 guildExperimentFilter$Parser$parseRange$2 = GuildExperimentFilter$Parser$parseRange$1.this;
                                    ref$ObjectRef2.element = (T) reader.nextLongOrNull();
                                }
                            }
                            ref$ObjectRef3.element = null;
                        }
                    });
                }
            });
            Long l = (Long) ref$ObjectRef.element;
            long jLongValue = l != null ? l.longValue() : 0L;
            Long l2 = (Long) ref$ObjectRef2.element;
            return new Ranges3(jLongValue, l2 != null ? l2.longValue() : RecyclerView.FOREVER_NS);
        }

        public final Map<Long, Function1<Model.JsonReader, GuildExperimentFilter>> getParsers() {
            return parsers;
        }

        public final List<GuildExperimentFilter> parseFilters(final Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            final ArrayList arrayList = new ArrayList();
            reader.nextList(new Model.JsonReader.ItemFactory<Unit>() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseFilters$1
                @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                public /* bridge */ /* synthetic */ Unit get() throws IOException {
                    get2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
                public final void get2() throws IOException {
                    final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    ref$ObjectRef.element = null;
                    reader.nextListIndexed(new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseFilters$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ref$ObjectRef.element = (T) reader.nextLongOrNull();
                        }
                    }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseFilters$1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildExperimentFilter guildExperimentFilterInvoke;
                            Function1<Model.JsonReader, GuildExperimentFilter> function1 = GuildExperimentFilter.Parser.INSTANCE.getParsers().get((Long) ref$ObjectRef.element);
                            if (function1 != null && (guildExperimentFilterInvoke = function1.invoke(reader)) != null) {
                                arrayList.add(guildExperimentFilterInvoke);
                            }
                            ref$ObjectRef.element = null;
                        }
                    });
                }
            });
            return arrayList;
        }
    }

    private GuildExperimentFilter() {
    }

    public /* synthetic */ GuildExperimentFilter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
