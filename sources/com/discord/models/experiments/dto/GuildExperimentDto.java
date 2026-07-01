package com.discord.models.experiments.dto;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentOverridesDto;
import com.discord.models.experiments.dto.GuildExperimentPopulationDto;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentDto {
    private final long experimentIdHash;
    private final String hashKey;
    private final List<GuildExperimentOverridesDto> overrides;
    private final List<GuildExperimentPopulationDto> populations;
    private final int revision;

    /* JADX INFO: compiled from: GuildExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, java.util.List] */
        public static final GuildExperimentDto parse(final Model.JsonReader jsonReader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(jsonReader, "jsonReader");
            ref$ObjectRefC0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            final Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            ref$ObjectRef4.element = Collections2.emptyList();
            jsonReader.nextListIndexed(new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$1
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Long] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRefC0.element = jsonReader.nextLongOrNull();
                }
            }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$2
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRef.element = jsonReader.nextStringOrNull();
                }
            }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$3
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRef2.element = jsonReader.nextIntOrNull();
                }
            }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$4
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRef3.element = jsonReader.nextList(new Model.JsonReader.ItemFactory<GuildExperimentPopulationDto>() { // from class: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$4.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                        public final GuildExperimentPopulationDto get() {
                            return GuildExperimentPopulationDto.Parser.INSTANCE.parse(jsonReader);
                        }
                    });
                }
            }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$5
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, java.util.List] */
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    Ref$ObjectRef ref$ObjectRef5 = ref$ObjectRef4;
                    ?? NextList = jsonReader.nextList(new Model.JsonReader.ItemFactory<GuildExperimentOverridesDto>() { // from class: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$5.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                        public final GuildExperimentOverridesDto get() {
                            return GuildExperimentOverridesDto.Parser.INSTANCE.parse(jsonReader);
                        }
                    });
                    Intrinsics3.checkNotNullExpressionValue(NextList, "jsonReader.nextList { Gu…arser.parse(jsonReader) }");
                    ref$ObjectRef5.element = NextList;
                }
            });
            Long l = (Long) ref$ObjectRefC0.element;
            Intrinsics3.checkNotNull(l);
            long jLongValue = l.longValue();
            String str = (String) ref$ObjectRef.element;
            Integer num = (Integer) ref$ObjectRef2.element;
            Intrinsics3.checkNotNull(num);
            int iIntValue = num.intValue();
            List list = (List) ref$ObjectRef4.element;
            List list2 = (List) ref$ObjectRef3.element;
            Intrinsics3.checkNotNull(list2);
            return new GuildExperimentDto(jLongValue, str, iIntValue, list2, list);
        }
    }

    public GuildExperimentDto(long j, String str, int i, List<GuildExperimentPopulationDto> list, List<GuildExperimentOverridesDto> list2) {
        Intrinsics3.checkNotNullParameter(list, "populations");
        Intrinsics3.checkNotNullParameter(list2, "overrides");
        this.experimentIdHash = j;
        this.hashKey = str;
        this.revision = i;
        this.populations = list;
        this.overrides = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentDto copy$default(GuildExperimentDto guildExperimentDto, long j, String str, int i, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = guildExperimentDto.experimentIdHash;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = guildExperimentDto.hashKey;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            i = guildExperimentDto.revision;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = guildExperimentDto.populations;
        }
        List list3 = list;
        if ((i2 & 16) != 0) {
            list2 = guildExperimentDto.overrides;
        }
        return guildExperimentDto.copy(j2, str2, i3, list3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getExperimentIdHash() {
        return this.experimentIdHash;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHashKey() {
        return this.hashKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    public final List<GuildExperimentPopulationDto> component4() {
        return this.populations;
    }

    public final List<GuildExperimentOverridesDto> component5() {
        return this.overrides;
    }

    public final GuildExperimentDto copy(long experimentIdHash, String hashKey, int revision, List<GuildExperimentPopulationDto> populations, List<GuildExperimentOverridesDto> overrides) {
        Intrinsics3.checkNotNullParameter(populations, "populations");
        Intrinsics3.checkNotNullParameter(overrides, "overrides");
        return new GuildExperimentDto(experimentIdHash, hashKey, revision, populations, overrides);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentDto)) {
            return false;
        }
        GuildExperimentDto guildExperimentDto = (GuildExperimentDto) other;
        return this.experimentIdHash == guildExperimentDto.experimentIdHash && Intrinsics3.areEqual(this.hashKey, guildExperimentDto.hashKey) && this.revision == guildExperimentDto.revision && Intrinsics3.areEqual(this.populations, guildExperimentDto.populations) && Intrinsics3.areEqual(this.overrides, guildExperimentDto.overrides);
    }

    public final long getExperimentIdHash() {
        return this.experimentIdHash;
    }

    public final String getHashKey() {
        return this.hashKey;
    }

    public final List<GuildExperimentOverridesDto> getOverrides() {
        return this.overrides;
    }

    public final List<GuildExperimentPopulationDto> getPopulations() {
        return this.populations;
    }

    public final int getRevision() {
        return this.revision;
    }

    public int hashCode() {
        long j = this.experimentIdHash;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.hashKey;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.revision) * 31;
        List<GuildExperimentPopulationDto> list = this.populations;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<GuildExperimentOverridesDto> list2 = this.overrides;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildExperimentDto(experimentIdHash=");
        sbU.append(this.experimentIdHash);
        sbU.append(", hashKey=");
        sbU.append(this.hashKey);
        sbU.append(", revision=");
        sbU.append(this.revision);
        sbU.append(", populations=");
        sbU.append(this.populations);
        sbU.append(", overrides=");
        return outline.L(sbU, this.overrides, ")");
    }
}
