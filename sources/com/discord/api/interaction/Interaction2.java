package com.discord.api.interaction;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: com.discord.api.interaction.Member, reason: use source file name */
/* JADX INFO: compiled from: Interaction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Interaction2 {
    private final boolean deaf;
    private final String joinedAt;
    private final boolean mute;
    private final List<Long> roles;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Interaction2)) {
            return false;
        }
        Interaction2 interaction2 = (Interaction2) other;
        return Intrinsics3.areEqual(this.roles, interaction2.roles) && Intrinsics3.areEqual(this.joinedAt, interaction2.joinedAt) && this.mute == interaction2.mute && this.deaf == interaction2.deaf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        List<Long> list = this.roles;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.joinedAt;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.mute;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.deaf;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Member(roles=");
        sbU.append(this.roles);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", mute=");
        sbU.append(this.mute);
        sbU.append(", deaf=");
        return outline.O(sbU, this.deaf, ")");
    }
}
