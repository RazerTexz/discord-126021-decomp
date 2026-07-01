package com.discord.models.experiments.dto;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildExperimentOverridesDto {
    private final int bucket;
    private final List<Long> guilds;

    public GuildExperimentOverridesDto(int i, List<Long> list) {
        m.checkNotNullParameter(list, "guilds");
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
        m.checkNotNullParameter(guilds, "guilds");
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
        return this.bucket == guildExperimentOverridesDto.bucket && m.areEqual(this.guilds, guildExperimentOverridesDto.guilds);
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
        StringBuilder sbU = a.U("GuildExperimentOverridesDto(bucket=");
        sbU.append(this.bucket);
        sbU.append(", guilds=");
        return a.L(sbU, this.guilds, ")");
    }
}
