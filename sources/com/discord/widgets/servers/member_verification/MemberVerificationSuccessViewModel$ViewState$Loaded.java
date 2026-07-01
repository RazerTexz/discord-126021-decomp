package com.discord.widgets.servers.member_verification;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberVerificationSuccessViewModel$ViewState$Loaded extends MemberVerificationSuccessViewModel$ViewState {
    private final String guildName;

    public MemberVerificationSuccessViewModel$ViewState$Loaded(String str) {
        super(null);
        this.guildName = str;
    }

    public static /* synthetic */ MemberVerificationSuccessViewModel$ViewState$Loaded copy$default(MemberVerificationSuccessViewModel$ViewState$Loaded memberVerificationSuccessViewModel$ViewState$Loaded, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = memberVerificationSuccessViewModel$ViewState$Loaded.guildName;
        }
        return memberVerificationSuccessViewModel$ViewState$Loaded.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final MemberVerificationSuccessViewModel$ViewState$Loaded copy(String guildName) {
        return new MemberVerificationSuccessViewModel$ViewState$Loaded(guildName);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MemberVerificationSuccessViewModel$ViewState$Loaded) && m.areEqual(this.guildName, ((MemberVerificationSuccessViewModel$ViewState$Loaded) other).guildName);
        }
        return true;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public int hashCode() {
        String str = this.guildName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("Loaded(guildName="), this.guildName, ")");
    }
}
