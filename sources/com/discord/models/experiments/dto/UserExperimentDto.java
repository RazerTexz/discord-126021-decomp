package com.discord.models.experiments.dto;

import b.d.b.a.a;

/* JADX INFO: compiled from: UserExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserExperimentDto {
    private final int bucket;
    private final long nameHash;
    private final int population;
    private final int revision;

    public UserExperimentDto(long j, int i, int i2, int i3) {
        this.nameHash = j;
        this.revision = i;
        this.bucket = i2;
        this.population = i3;
    }

    public static /* synthetic */ UserExperimentDto copy$default(UserExperimentDto userExperimentDto, long j, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = userExperimentDto.nameHash;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            i = userExperimentDto.revision;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = userExperimentDto.bucket;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = userExperimentDto.population;
        }
        return userExperimentDto.copy(j2, i5, i6, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getNameHash() {
        return this.nameHash;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPopulation() {
        return this.population;
    }

    public final UserExperimentDto copy(long nameHash, int revision, int bucket, int population) {
        return new UserExperimentDto(nameHash, revision, bucket, population);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserExperimentDto)) {
            return false;
        }
        UserExperimentDto userExperimentDto = (UserExperimentDto) other;
        return this.nameHash == userExperimentDto.nameHash && this.revision == userExperimentDto.revision && this.bucket == userExperimentDto.bucket && this.population == userExperimentDto.population;
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final long getNameHash() {
        return this.nameHash;
    }

    public final int getPopulation() {
        return this.population;
    }

    public final int getRevision() {
        return this.revision;
    }

    public int hashCode() {
        long j = this.nameHash;
        return (((((((int) (j ^ (j >>> 32))) * 31) + this.revision) * 31) + this.bucket) * 31) + this.population;
    }

    public String toString() {
        StringBuilder sbU = a.U("UserExperimentDto(nameHash=");
        sbU.append(this.nameHash);
        sbU.append(", revision=");
        sbU.append(this.revision);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", population=");
        return a.B(sbU, this.population, ")");
    }
}
