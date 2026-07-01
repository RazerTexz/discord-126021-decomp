package com.discord.models.experiments.dto;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: UnauthenticatedUserExperimentsDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UnauthenticatedUserExperimentsDto {
    private final List<UserExperimentDto> assignments;
    private final String fingerprint;

    public UnauthenticatedUserExperimentsDto(String str, List<UserExperimentDto> list) {
        Intrinsics3.checkNotNullParameter(str, "fingerprint");
        Intrinsics3.checkNotNullParameter(list, "assignments");
        this.fingerprint = str;
        this.assignments = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UnauthenticatedUserExperimentsDto copy$default(UnauthenticatedUserExperimentsDto unauthenticatedUserExperimentsDto, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unauthenticatedUserExperimentsDto.fingerprint;
        }
        if ((i & 2) != 0) {
            list = unauthenticatedUserExperimentsDto.assignments;
        }
        return unauthenticatedUserExperimentsDto.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final List<UserExperimentDto> component2() {
        return this.assignments;
    }

    public final UnauthenticatedUserExperimentsDto copy(String fingerprint, List<UserExperimentDto> assignments) {
        Intrinsics3.checkNotNullParameter(fingerprint, "fingerprint");
        Intrinsics3.checkNotNullParameter(assignments, "assignments");
        return new UnauthenticatedUserExperimentsDto(fingerprint, assignments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnauthenticatedUserExperimentsDto)) {
            return false;
        }
        UnauthenticatedUserExperimentsDto unauthenticatedUserExperimentsDto = (UnauthenticatedUserExperimentsDto) other;
        return Intrinsics3.areEqual(this.fingerprint, unauthenticatedUserExperimentsDto.fingerprint) && Intrinsics3.areEqual(this.assignments, unauthenticatedUserExperimentsDto.assignments);
    }

    public final List<UserExperimentDto> getAssignments() {
        return this.assignments;
    }

    public final String getFingerprint() {
        return this.fingerprint;
    }

    public int hashCode() {
        String str = this.fingerprint;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<UserExperimentDto> list = this.assignments;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("UnauthenticatedUserExperimentsDto(fingerprint=");
        sbU.append(this.fingerprint);
        sbU.append(", assignments=");
        return outline.L(sbU, this.assignments, ")");
    }
}
