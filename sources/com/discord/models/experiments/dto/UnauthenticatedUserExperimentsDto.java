package com.discord.models.experiments.dto;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UnauthenticatedUserExperimentsDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UnauthenticatedUserExperimentsDto {
    private final List<UserExperimentDto> assignments;
    private final String fingerprint;

    public UnauthenticatedUserExperimentsDto(String str, List<UserExperimentDto> list) {
        C12238m.checkNotNullParameter(str, "fingerprint");
        C12238m.checkNotNullParameter(list, "assignments");
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
        C12238m.checkNotNullParameter(fingerprint, "fingerprint");
        C12238m.checkNotNullParameter(assignments, "assignments");
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
        return C12238m.areEqual(this.fingerprint, unauthenticatedUserExperimentsDto.fingerprint) && C12238m.areEqual(this.assignments, unauthenticatedUserExperimentsDto.assignments);
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
        StringBuilder sbM833U = C1643a.m833U("UnauthenticatedUserExperimentsDto(fingerprint=");
        sbM833U.append(this.fingerprint);
        sbM833U.append(", assignments=");
        return C1643a.m824L(sbM833U, this.assignments, ")");
    }
}
