package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentPopulationDto {
    private final List<GuildExperimentBucketDto> buckets;
    private final List<GuildExperimentFilter> filters;

    /* JADX INFO: compiled from: GuildExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        public final GuildExperimentPopulationDto parse(final Model.JsonReader jsonReader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(jsonReader, "jsonReader");
            ref$ObjectRefM844c0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            jsonReader.nextListIndexed(new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentPopulationDto$Parser$parse$1
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRefM844c0.element = jsonReader.nextList(new Model.JsonReader.ItemFactory<GuildExperimentBucketDto>() { // from class: com.discord.models.experiments.dto.GuildExperimentPopulationDto$Parser$parse$1.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                        public final GuildExperimentBucketDto get() {
                            return GuildExperimentBucketDto.Parser.INSTANCE.parse(jsonReader);
                        }
                    });
                }
            }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentPopulationDto$Parser$parse$2
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRef.element = GuildExperimentFilter.Parser.INSTANCE.parseFilters(jsonReader);
                }
            });
            List list = (List) ref$ObjectRefM844c0.element;
            C12238m.checkNotNull(list);
            List listEmptyList = (List) ref$ObjectRef.element;
            if (listEmptyList == null) {
                listEmptyList = C12147n.emptyList();
            }
            return new GuildExperimentPopulationDto(list, listEmptyList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildExperimentPopulationDto(List<GuildExperimentBucketDto> list, List<? extends GuildExperimentFilter> list2) {
        C12238m.checkNotNullParameter(list, "buckets");
        C12238m.checkNotNullParameter(list2, "filters");
        this.buckets = list;
        this.filters = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentPopulationDto copy$default(GuildExperimentPopulationDto guildExperimentPopulationDto, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = guildExperimentPopulationDto.buckets;
        }
        if ((i & 2) != 0) {
            list2 = guildExperimentPopulationDto.filters;
        }
        return guildExperimentPopulationDto.copy(list, list2);
    }

    public final List<GuildExperimentBucketDto> component1() {
        return this.buckets;
    }

    public final List<GuildExperimentFilter> component2() {
        return this.filters;
    }

    public final GuildExperimentPopulationDto copy(List<GuildExperimentBucketDto> buckets, List<? extends GuildExperimentFilter> filters) {
        C12238m.checkNotNullParameter(buckets, "buckets");
        C12238m.checkNotNullParameter(filters, "filters");
        return new GuildExperimentPopulationDto(buckets, filters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentPopulationDto)) {
            return false;
        }
        GuildExperimentPopulationDto guildExperimentPopulationDto = (GuildExperimentPopulationDto) other;
        return C12238m.areEqual(this.buckets, guildExperimentPopulationDto.buckets) && C12238m.areEqual(this.filters, guildExperimentPopulationDto.filters);
    }

    public final List<GuildExperimentBucketDto> getBuckets() {
        return this.buckets;
    }

    public final List<GuildExperimentFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        List<GuildExperimentBucketDto> list = this.buckets;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<GuildExperimentFilter> list2 = this.filters;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildExperimentPopulationDto(buckets=");
        sbM833U.append(this.buckets);
        sbM833U.append(", filters=");
        return C1643a.m824L(sbM833U, this.filters, ")");
    }
}
