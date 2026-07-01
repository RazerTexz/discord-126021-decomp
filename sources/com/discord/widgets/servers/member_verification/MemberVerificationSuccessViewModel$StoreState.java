package com.discord.widgets.servers.member_verification;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberVerificationSuccessViewModel$StoreState {
    private final String guildName;
    private final String lastSeen;

    public MemberVerificationSuccessViewModel$StoreState(String str, String str2) {
        this.lastSeen = str;
        this.guildName = str2;
    }

    public static /* synthetic */ MemberVerificationSuccessViewModel$StoreState copy$default(MemberVerificationSuccessViewModel$StoreState memberVerificationSuccessViewModel$StoreState, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = memberVerificationSuccessViewModel$StoreState.lastSeen;
        }
        if ((i & 2) != 0) {
            str2 = memberVerificationSuccessViewModel$StoreState.guildName;
        }
        return memberVerificationSuccessViewModel$StoreState.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLastSeen() {
        return this.lastSeen;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final MemberVerificationSuccessViewModel$StoreState copy(String lastSeen, String guildName) {
        return new MemberVerificationSuccessViewModel$StoreState(lastSeen, guildName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationSuccessViewModel$StoreState)) {
            return false;
        }
        MemberVerificationSuccessViewModel$StoreState memberVerificationSuccessViewModel$StoreState = (MemberVerificationSuccessViewModel$StoreState) other;
        return m.areEqual(this.lastSeen, memberVerificationSuccessViewModel$StoreState.lastSeen) && m.areEqual(this.guildName, memberVerificationSuccessViewModel$StoreState.guildName);
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final String getLastSeen() {
        return this.lastSeen;
    }

    public int hashCode() {
        String str = this.lastSeen;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.guildName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(lastSeen=");
        sbU.append(this.lastSeen);
        sbU.append(", guildName=");
        return a.J(sbU, this.guildName, ")");
    }
}
