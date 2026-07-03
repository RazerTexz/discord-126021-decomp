package com.discord.models.experiments.dto;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildHubType;
import com.discord.models.domain.Model;
import com.discord.models.experiments.domain.ExperimentHash;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.LongRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(set, "features");
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
            C12238m.checkNotNullParameter(features, "features");
            return new GuildHasFeatureFilter(features);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildHasFeatureFilter) && C12238m.areEqual(this.features, ((GuildHasFeatureFilter) other).features);
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
            return C1643a.m826N(C1643a.m833U("GuildHasFeatureFilter(features="), this.features, ")");
        }
    }

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildHubTypesFeatureFilter extends GuildExperimentFilter {
        private final Set<GuildHubType> hubTypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildHubTypesFeatureFilter(Set<? extends GuildHubType> set) {
            super(null);
            C12238m.checkNotNullParameter(set, "hubTypes");
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
            C12238m.checkNotNullParameter(hubTypes, "hubTypes");
            return new GuildHubTypesFeatureFilter(hubTypes);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildHubTypesFeatureFilter) && C12238m.areEqual(this.hubTypes, ((GuildHubTypesFeatureFilter) other).hubTypes);
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
            return C1643a.m826N(C1643a.m833U("GuildHubTypesFeatureFilter(hubTypes="), this.hubTypes, ")");
        }
    }

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildIdRangeFilter extends GuildExperimentFilter {
        private final LongRange range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildIdRangeFilter(LongRange longRange) {
            super(null);
            C12238m.checkNotNullParameter(longRange, "range");
            this.range = longRange;
        }

        public static /* synthetic */ GuildIdRangeFilter copy$default(GuildIdRangeFilter guildIdRangeFilter, LongRange longRange, int i, Object obj) {
            if ((i & 1) != 0) {
                longRange = guildIdRangeFilter.range;
            }
            return guildIdRangeFilter.copy(longRange);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LongRange getRange() {
            return this.range;
        }

        public final GuildIdRangeFilter copy(LongRange range) {
            C12238m.checkNotNullParameter(range, "range");
            return new GuildIdRangeFilter(range);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildIdRangeFilter) && C12238m.areEqual(this.range, ((GuildIdRangeFilter) other).range);
            }
            return true;
        }

        public final LongRange getRange() {
            return this.range;
        }

        public int hashCode() {
            LongRange longRange = this.range;
            if (longRange != null) {
                return longRange.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("GuildIdRangeFilter(range=");
            sbM833U.append(this.range);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildIdsFilter extends GuildExperimentFilter {
        private final Set<Long> guildIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildIdsFilter(Set<Long> set) {
            super(null);
            C12238m.checkNotNullParameter(set, "guildIds");
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
            C12238m.checkNotNullParameter(guildIds, "guildIds");
            return new GuildIdsFilter(guildIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildIdsFilter) && C12238m.areEqual(this.guildIds, ((GuildIdsFilter) other).guildIds);
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
            return C1643a.m826N(C1643a.m833U("GuildIdsFilter(guildIds="), this.guildIds, ")");
        }
    }

    /* JADX INFO: compiled from: GuildExperimentFilter.kt */
    public static final /* data */ class GuildMemberCountRangeFilter extends GuildExperimentFilter {
        private final LongRange range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMemberCountRangeFilter(LongRange longRange) {
            super(null);
            C12238m.checkNotNullParameter(longRange, "range");
            this.range = longRange;
        }

        public static /* synthetic */ GuildMemberCountRangeFilter copy$default(GuildMemberCountRangeFilter guildMemberCountRangeFilter, LongRange longRange, int i, Object obj) {
            if ((i & 1) != 0) {
                longRange = guildMemberCountRangeFilter.range;
            }
            return guildMemberCountRangeFilter.copy(longRange);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LongRange getRange() {
            return this.range;
        }

        public final GuildMemberCountRangeFilter copy(LongRange range) {
            C12238m.checkNotNullParameter(range, "range");
            return new GuildMemberCountRangeFilter(range);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildMemberCountRangeFilter) && C12238m.areEqual(this.range, ((GuildMemberCountRangeFilter) other).range);
            }
            return true;
        }

        public final LongRange getRange() {
            return this.range;
        }

        public int hashCode() {
            LongRange longRange = this.range;
            if (longRange != null) {
                return longRange.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("GuildMemberCountRangeFilter(range=");
            sbM833U.append(this.range);
            sbM833U.append(")");
            return sbM833U.toString();
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
            parsers = C12136h0.mapOf(C12116o.m10073to(Long.valueOf(experimentHash.from("guild_ids")), new GuildExperimentFilter$Parser$parsers$1(parser)), C12116o.m10073to(Long.valueOf(experimentHash.from("guild_id_range")), new GuildExperimentFilter$Parser$parsers$2(parser)), C12116o.m10073to(Long.valueOf(experimentHash.from("guild_member_count_range")), new GuildExperimentFilter$Parser$parsers$3(parser)), C12116o.m10073to(Long.valueOf(experimentHash.from("guild_has_feature")), new GuildExperimentFilter$Parser$parsers$4(parser)), C12116o.m10073to(Long.valueOf(experimentHash.from("guild_hub_types")), new GuildExperimentFilter$Parser$parsers$5(parser)));
            MIN_ID_HASH = experimentHash.from("min_id");
            MAX_ID_HASH = experimentHash.from("max_id");
        }

        private Parser() {
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
        private final GuildHasFeatureFilter parseGuildHasFeatureFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = C12148n0.emptySet();
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1(reader, ref$ObjectRef));
            return new GuildHasFeatureFilter((Set) ref$ObjectRef.element);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
        private final GuildHubTypesFeatureFilter parseGuildHubTypesFeatureFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = C12148n0.emptySet();
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
            C12238m.checkNotNull(list);
            return new GuildIdsFilter(C12163u.toSet(list));
        }

        private final GuildMemberCountRangeFilter parseGuildMemberCountRangeFilter(Model.JsonReader reader) {
            return new GuildMemberCountRangeFilter(parseRange(reader));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final LongRange parseRange(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextList(new Model.JsonReader.ItemFactory<Unit>() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseRange$1
                @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                public /* bridge */ /* synthetic */ Unit get() throws IOException {
                    get2();
                    return Unit.f27425a;
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
            return new LongRange(jLongValue, l2 != null ? l2.longValue() : RecyclerView.FOREVER_NS);
        }

        public final Map<Long, Function1<Model.JsonReader, GuildExperimentFilter>> getParsers() {
            return parsers;
        }

        public final List<GuildExperimentFilter> parseFilters(final Model.JsonReader reader) throws IOException {
            C12238m.checkNotNullParameter(reader, "reader");
            final ArrayList arrayList = new ArrayList();
            reader.nextList(new Model.JsonReader.ItemFactory<Unit>() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseFilters$1
                @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                public /* bridge */ /* synthetic */ Unit get() throws IOException {
                    get2();
                    return Unit.f27425a;
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
