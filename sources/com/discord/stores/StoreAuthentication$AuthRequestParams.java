package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreAuthentication$AuthRequestParams {
    private final String guildTemplateCode;
    private final StoreInviteSettings$InviteCode inviteCode;

    public StoreAuthentication$AuthRequestParams(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, String str) {
        this.inviteCode = storeInviteSettings$InviteCode;
        this.guildTemplateCode = str;
    }

    public static /* synthetic */ StoreAuthentication$AuthRequestParams copy$default(StoreAuthentication$AuthRequestParams storeAuthentication$AuthRequestParams, StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            storeInviteSettings$InviteCode = storeAuthentication$AuthRequestParams.inviteCode;
        }
        if ((i & 2) != 0) {
            str = storeAuthentication$AuthRequestParams.guildTemplateCode;
        }
        return storeAuthentication$AuthRequestParams.copy(storeInviteSettings$InviteCode, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreInviteSettings$InviteCode getInviteCode() {
        return this.inviteCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
    }

    public final StoreAuthentication$AuthRequestParams copy(StoreInviteSettings$InviteCode inviteCode, String guildTemplateCode) {
        return new StoreAuthentication$AuthRequestParams(inviteCode, guildTemplateCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreAuthentication$AuthRequestParams)) {
            return false;
        }
        StoreAuthentication$AuthRequestParams storeAuthentication$AuthRequestParams = (StoreAuthentication$AuthRequestParams) other;
        return m.areEqual(this.inviteCode, storeAuthentication$AuthRequestParams.inviteCode) && m.areEqual(this.guildTemplateCode, storeAuthentication$AuthRequestParams.guildTemplateCode);
    }

    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
    }

    public final StoreInviteSettings$InviteCode getInviteCode() {
        return this.inviteCode;
    }

    public int hashCode() {
        StoreInviteSettings$InviteCode storeInviteSettings$InviteCode = this.inviteCode;
        int iHashCode = (storeInviteSettings$InviteCode != null ? storeInviteSettings$InviteCode.hashCode() : 0) * 31;
        String str = this.guildTemplateCode;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AuthRequestParams(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildTemplateCode=");
        return a.J(sbU, this.guildTemplateCode, ")");
    }
}
