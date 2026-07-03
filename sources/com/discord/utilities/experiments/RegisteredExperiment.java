package com.discord.utilities.experiments;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ExperimentRegistry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class RegisteredExperiment {
    private final List<String> buckets;
    private final boolean cacheExperiment;
    private final String name;
    private final String readableName;
    private final Type type;

    /* JADX INFO: compiled from: ExperimentRegistry.kt */
    public enum Type {
        GUILD,
        USER
    }

    public RegisteredExperiment(String str, String str2, Type type, List<String> list, boolean z2) {
        C12238m.checkNotNullParameter(str, "readableName");
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(type, "type");
        C12238m.checkNotNullParameter(list, "buckets");
        this.readableName = str;
        this.name = str2;
        this.type = type;
        this.buckets = list;
        this.cacheExperiment = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegisteredExperiment copy$default(RegisteredExperiment registeredExperiment, String str, String str2, Type type, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registeredExperiment.readableName;
        }
        if ((i & 2) != 0) {
            str2 = registeredExperiment.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            type = registeredExperiment.type;
        }
        Type type2 = type;
        if ((i & 8) != 0) {
            list = registeredExperiment.buckets;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            z2 = registeredExperiment.cacheExperiment;
        }
        return registeredExperiment.copy(str, str3, type2, list2, z2);
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

    public final RegisteredExperiment copy(String readableName, String name, Type type, List<String> buckets, boolean cacheExperiment) {
        C12238m.checkNotNullParameter(readableName, "readableName");
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(type, "type");
        C12238m.checkNotNullParameter(buckets, "buckets");
        return new RegisteredExperiment(readableName, name, type, buckets, cacheExperiment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisteredExperiment)) {
            return false;
        }
        RegisteredExperiment registeredExperiment = (RegisteredExperiment) other;
        return C12238m.areEqual(this.readableName, registeredExperiment.readableName) && C12238m.areEqual(this.name, registeredExperiment.name) && C12238m.areEqual(this.type, registeredExperiment.type) && C12238m.areEqual(this.buckets, registeredExperiment.buckets) && this.cacheExperiment == registeredExperiment.cacheExperiment;
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
        StringBuilder sbM833U = C1643a.m833U("RegisteredExperiment(readableName=");
        sbM833U.append(this.readableName);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", buckets=");
        sbM833U.append(this.buckets);
        sbM833U.append(", cacheExperiment=");
        return C1643a.m827O(sbM833U, this.cacheExperiment, ")");
    }
}
