package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentBucketDto {
    private final int bucket;
    private final List<IntRange> positions;

    /* JADX INFO: compiled from: GuildExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        private final IntRange parsePosition(final Model.JsonReader jsonReader) throws IOException {
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            ref$IntRef2.element = -1;
            jsonReader.nextObject(new Action1<String>() { // from class: com.discord.models.experiments.dto.GuildExperimentBucketDto$Parser$parsePosition$1
                @Override // p658rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        int iHashCode = str.hashCode();
                        if (iHashCode != 101) {
                            if (iHashCode == 115 && str.equals("s")) {
                                Ref$IntRef ref$IntRef3 = ref$IntRef;
                                ref$IntRef3.element = jsonReader.nextInt(ref$IntRef3.element);
                                return;
                            }
                        } else if (str.equals("e")) {
                            Ref$IntRef ref$IntRef4 = ref$IntRef2;
                            ref$IntRef4.element = jsonReader.nextInt(ref$IntRef4.element);
                            return;
                        }
                    }
                    jsonReader.skipValue();
                }
            });
            return new IntRange(ref$IntRef.element, ref$IntRef2.element);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
        public final GuildExperimentBucketDto parse(final Model.JsonReader reader) throws IOException {
            C12238m.checkNotNullParameter(reader, "reader");
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = C12147n.emptyList();
            reader.nextListIndexed(new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentBucketDto$Parser$parse$1
                @Override // java.lang.Runnable
                public final void run() {
                    Ref$IntRef ref$IntRef2 = ref$IntRef;
                    ref$IntRef2.element = reader.nextInt(ref$IntRef2.element);
                }
            }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentBucketDto$Parser$parse$2
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, java.util.List] */
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                    ?? NextList = reader.nextList(new Model.JsonReader.ItemFactory<IntRange>() { // from class: com.discord.models.experiments.dto.GuildExperimentBucketDto$Parser$parse$2.1
                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                        public final IntRange get() {
                            return GuildExperimentBucketDto.Parser.INSTANCE.parsePosition(reader);
                        }
                    });
                    C12238m.checkNotNullExpressionValue(NextList, "reader.nextList { parsePosition(reader) }");
                    ref$ObjectRef2.element = NextList;
                }
            });
            return new GuildExperimentBucketDto(ref$IntRef.element, (List) ref$ObjectRef.element);
        }
    }

    public GuildExperimentBucketDto(int i, List<IntRange> list) {
        C12238m.checkNotNullParameter(list, "positions");
        this.bucket = i;
        this.positions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentBucketDto copy$default(GuildExperimentBucketDto guildExperimentBucketDto, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildExperimentBucketDto.bucket;
        }
        if ((i2 & 2) != 0) {
            list = guildExperimentBucketDto.positions;
        }
        return guildExperimentBucketDto.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    public final List<IntRange> component2() {
        return this.positions;
    }

    public final GuildExperimentBucketDto copy(int bucket, List<IntRange> positions) {
        C12238m.checkNotNullParameter(positions, "positions");
        return new GuildExperimentBucketDto(bucket, positions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentBucketDto)) {
            return false;
        }
        GuildExperimentBucketDto guildExperimentBucketDto = (GuildExperimentBucketDto) other;
        return this.bucket == guildExperimentBucketDto.bucket && C12238m.areEqual(this.positions, guildExperimentBucketDto.positions);
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final List<IntRange> getPositions() {
        return this.positions;
    }

    public int hashCode() {
        int i = this.bucket * 31;
        List<IntRange> list = this.positions;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildExperimentBucketDto(bucket=");
        sbM833U.append(this.bucket);
        sbM833U.append(", positions=");
        return C1643a.m824L(sbM833U, this.positions, ")");
    }
}
