package com.discord.samsung;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: SamsungConnectActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SamsungConnectActivity$Result$Success extends SamsungConnectActivity$Result {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String authCode;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String serverUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnectActivity$Result$Success(String str, String str2) {
        super(null);
        m.checkNotNullParameter(str, "authCode");
        m.checkNotNullParameter(str2, "serverUrl");
        this.authCode = str;
        this.serverUrl = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SamsungConnectActivity$Result$Success)) {
            return false;
        }
        SamsungConnectActivity$Result$Success samsungConnectActivity$Result$Success = (SamsungConnectActivity$Result$Success) other;
        return m.areEqual(this.authCode, samsungConnectActivity$Result$Success.authCode) && m.areEqual(this.serverUrl, samsungConnectActivity$Result$Success.serverUrl);
    }

    public int hashCode() {
        String str = this.authCode;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.serverUrl;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Success(authCode=");
        sbU.append(this.authCode);
        sbU.append(", serverUrl=");
        return a.J(sbU, this.serverUrl, ")");
    }
}
