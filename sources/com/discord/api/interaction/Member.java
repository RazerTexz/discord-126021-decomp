package com.discord.api.interaction;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Interaction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Member {
    private final boolean deaf;
    private final String joinedAt;
    private final boolean mute;
    private final List<Long> roles;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Member)) {
            return false;
        }
        Member member = (Member) other;
        return C12238m.areEqual(this.roles, member.roles) && C12238m.areEqual(this.joinedAt, member.joinedAt) && this.mute == member.mute && this.deaf == member.deaf;
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
        StringBuilder sbM833U = C1643a.m833U("Member(roles=");
        sbM833U.append(this.roles);
        sbM833U.append(", joinedAt=");
        sbM833U.append(this.joinedAt);
        sbM833U.append(", mute=");
        sbM833U.append(this.mute);
        sbM833U.append(", deaf=");
        return C1643a.m827O(sbM833U, this.deaf, ")");
    }
}
