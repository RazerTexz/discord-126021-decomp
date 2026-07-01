package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;
import d0.z.d.m;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Resume {

    @b("server_id")
    private final String serverId;

    @b("session_id")
    private final String sessionId;
    private final String token;

    public Payloads$Resume(String str, String str2, String str3) {
        a.q0(str, "token", str2, "sessionId", str3, "serverId");
        this.token = str;
        this.sessionId = str2;
        this.serverId = str3;
    }

    public static /* synthetic */ Payloads$Resume copy$default(Payloads$Resume payloads$Resume, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payloads$Resume.token;
        }
        if ((i & 2) != 0) {
            str2 = payloads$Resume.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = payloads$Resume.serverId;
        }
        return payloads$Resume.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getServerId() {
        return this.serverId;
    }

    public final Payloads$Resume copy(String token, String sessionId, String serverId) {
        m.checkNotNullParameter(token, "token");
        m.checkNotNullParameter(sessionId, "sessionId");
        m.checkNotNullParameter(serverId, "serverId");
        return new Payloads$Resume(token, sessionId, serverId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Resume)) {
            return false;
        }
        Payloads$Resume payloads$Resume = (Payloads$Resume) other;
        return m.areEqual(this.token, payloads$Resume.token) && m.areEqual(this.sessionId, payloads$Resume.sessionId) && m.areEqual(this.serverId, payloads$Resume.serverId);
    }

    public final String getServerId() {
        return this.serverId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sessionId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.serverId;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Resume(token=");
        sbU.append(this.token);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", serverId=");
        return a.J(sbU, this.serverId, ")");
    }
}
