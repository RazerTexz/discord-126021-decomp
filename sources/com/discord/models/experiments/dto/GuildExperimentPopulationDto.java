package com.discord.models.experiments.dto;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentBucketDto;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

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
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(jsonReader, "jsonReader");
            ref$ObjectRefC0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            jsonReader.nextListIndexed(new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentPopulationDto$Parser$parse$1
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRefC0.element = jsonReader.nextList(new Model.JsonReader.ItemFactory<GuildExperimentBucketDto>() { // from class: com.discord.models.experiments.dto.GuildExperimentPopulationDto$Parser$parse$1.1
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
            List list = (List) ref$ObjectRefC0.element;
            Intrinsics3.checkNotNull(list);
            List listEmptyList = (List) ref$ObjectRef.element;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return new GuildExperimentPopulationDto(list, listEmptyList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildExperimentPopulationDto(List<GuildExperimentBucketDto> list, List<? extends GuildExperimentFilter> list2) {
        Intrinsics3.checkNotNullParameter(list, "buckets");
        Intrinsics3.checkNotNullParameter(list2, "filters");
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
        Intrinsics3.checkNotNullParameter(buckets, "buckets");
        Intrinsics3.checkNotNullParameter(filters, "filters");
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
        return Intrinsics3.areEqual(this.buckets, guildExperimentPopulationDto.buckets) && Intrinsics3.areEqual(this.filters, guildExperimentPopulationDto.filters);
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
        StringBuilder sbU = outline.U("GuildExperimentPopulationDto(buckets=");
        sbU.append(this.buckets);
        sbU.append(", filters=");
        return outline.L(sbU, this.filters, ")");
    }
}
