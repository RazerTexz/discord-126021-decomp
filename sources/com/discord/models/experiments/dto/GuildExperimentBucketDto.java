package com.discord.models.experiments.dto;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentBucketDto {
    private final int bucket;
    private final List<IntRange> positions;

    public GuildExperimentBucketDto(int i, List<IntRange> list) {
        m.checkNotNullParameter(list, "positions");
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
        m.checkNotNullParameter(positions, "positions");
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
        return this.bucket == guildExperimentBucketDto.bucket && m.areEqual(this.positions, guildExperimentBucketDto.positions);
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
        StringBuilder sbU = a.U("GuildExperimentBucketDto(bucket=");
        sbU.append(this.bucket);
        sbU.append(", positions=");
        return a.L(sbU, this.positions, ")");
    }
}
