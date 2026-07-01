package com.discord.models.experiments.dto;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentOverridesDto {
    private final int bucket;
    private final List<Long> guilds;

    /* JADX INFO: compiled from: GuildExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
        public final GuildExperimentOverridesDto parse(final Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Collections2.emptyList();
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.experiments.dto.GuildExperimentOverridesDto$Parser$parse$1
                @Override // rx.functions.Action1
                public final void call(String str) {
                    if (str == null) {
                        return;
                    }
                    int iHashCode = str.hashCode();
                    if (iHashCode == 98) {
                        if (str.equals("b")) {
                            Ref$IntRef ref$IntRef2 = ref$IntRef;
                            ref$IntRef2.element = reader.nextInt(ref$IntRef2.element);
                            return;
                        }
                        return;
                    }
                    if (iHashCode == 107 && str.equals("k")) {
                        Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                        T t = (T) reader.nextList(new Model.JsonReader.ItemFactory<Long>() { // from class: com.discord.models.experiments.dto.GuildExperimentOverridesDto$Parser$parse$1.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                            public final Long get() {
                                return Long.valueOf(reader.nextLong(-1L));
                            }
                        });
                        Intrinsics3.checkNotNullExpressionValue(t, "reader.nextList { reader.nextLong(-1L) }");
                        ref$ObjectRef2.element = t;
                    }
                }
            });
            return new GuildExperimentOverridesDto(ref$IntRef.element, (List) ref$ObjectRef.element);
        }
    }

    public GuildExperimentOverridesDto(int i, List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "guilds");
        this.bucket = i;
        this.guilds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentOverridesDto copy$default(GuildExperimentOverridesDto guildExperimentOverridesDto, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildExperimentOverridesDto.bucket;
        }
        if ((i2 & 2) != 0) {
            list = guildExperimentOverridesDto.guilds;
        }
        return guildExperimentOverridesDto.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    public final List<Long> component2() {
        return this.guilds;
    }

    public final GuildExperimentOverridesDto copy(int bucket, List<Long> guilds) {
        Intrinsics3.checkNotNullParameter(guilds, "guilds");
        return new GuildExperimentOverridesDto(bucket, guilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentOverridesDto)) {
            return false;
        }
        GuildExperimentOverridesDto guildExperimentOverridesDto = (GuildExperimentOverridesDto) other;
        return this.bucket == guildExperimentOverridesDto.bucket && Intrinsics3.areEqual(this.guilds, guildExperimentOverridesDto.guilds);
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final List<Long> getGuilds() {
        return this.guilds;
    }

    public int hashCode() {
        int i = this.bucket * 31;
        List<Long> list = this.guilds;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildExperimentOverridesDto(bucket=");
        sbU.append(this.bucket);
        sbU.append(", guilds=");
        return outline.L(sbU, this.guilds, ")");
    }
}
