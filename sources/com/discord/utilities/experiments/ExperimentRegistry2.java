package com.discord.utilities.experiments;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: com.discord.utilities.experiments.RegisteredExperiment, reason: use source file name */
/* JADX INFO: compiled from: ExperimentRegistry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ExperimentRegistry2 {
    private final List<String> buckets;
    private final boolean cacheExperiment;
    private final String name;
    private final String readableName;
    private final Type type;

    /* JADX INFO: renamed from: com.discord.utilities.experiments.RegisteredExperiment$Type */
    /* JADX INFO: compiled from: ExperimentRegistry.kt */
    public enum Type {
        GUILD,
        USER
    }

    public ExperimentRegistry2(String str, String str2, Type type, List<String> list, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, "readableName");
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(list, "buckets");
        this.readableName = str;
        this.name = str2;
        this.type = type;
        this.buckets = list;
        this.cacheExperiment = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExperimentRegistry2 copy$default(ExperimentRegistry2 experimentRegistry2, String str, String str2, Type type, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = experimentRegistry2.readableName;
        }
        if ((i & 2) != 0) {
            str2 = experimentRegistry2.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            type = experimentRegistry2.type;
        }
        Type type2 = type;
        if ((i & 8) != 0) {
            list = experimentRegistry2.buckets;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            z2 = experimentRegistry2.cacheExperiment;
        }
        return experimentRegistry2.copy(str, str3, type2, list2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getReadableName() {
        return this.readableName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public final List<String> component4() {
        return this.buckets;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCacheExperiment() {
        return this.cacheExperiment;
    }

    public final ExperimentRegistry2 copy(String readableName, String name, Type type, List<String> buckets, boolean cacheExperiment) {
        Intrinsics3.checkNotNullParameter(readableName, "readableName");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(buckets, "buckets");
        return new ExperimentRegistry2(readableName, name, type, buckets, cacheExperiment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExperimentRegistry2)) {
            return false;
        }
        ExperimentRegistry2 experimentRegistry2 = (ExperimentRegistry2) other;
        return Intrinsics3.areEqual(this.readableName, experimentRegistry2.readableName) && Intrinsics3.areEqual(this.name, experimentRegistry2.name) && Intrinsics3.areEqual(this.type, experimentRegistry2.type) && Intrinsics3.areEqual(this.buckets, experimentRegistry2.buckets) && this.cacheExperiment == experimentRegistry2.cacheExperiment;
    }

    public final List<String> getBuckets() {
        return this.buckets;
    }

    public final boolean getCacheExperiment() {
        return this.cacheExperiment;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReadableName() {
        return this.readableName;
    }

    public final Type getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.readableName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Type type = this.type;
        int iHashCode3 = (iHashCode2 + (type != null ? type.hashCode() : 0)) * 31;
        List<String> list = this.buckets;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.cacheExperiment;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    public String toString() {
        StringBuilder sbU = outline.U("RegisteredExperiment(readableName=");
        sbU.append(this.readableName);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", buckets=");
        sbU.append(this.buckets);
        sbU.append(", cacheExperiment=");
        return outline.O(sbU, this.cacheExperiment, ")");
    }
}
