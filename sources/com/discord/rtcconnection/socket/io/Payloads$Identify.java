package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;
import d0.z.d.m;
import java.util.List;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Identify {

    @b("server_id")
    private final String serverId;

    @b("session_id")
    private final String sessionId;
    private final List<Payloads$Stream> streams;
    private final String token;

    @b("user_id")
    private final long userId;
    private final boolean video;

    public Payloads$Identify(String str, long j, String str2, String str3, boolean z2, List<Payloads$Stream> list) {
        m.checkNotNullParameter(str, "serverId");
        m.checkNotNullParameter(str2, "sessionId");
        m.checkNotNullParameter(str3, "token");
        m.checkNotNullParameter(list, "streams");
        this.serverId = str;
        this.userId = j;
        this.sessionId = str2;
        this.token = str3;
        this.video = z2;
        this.streams = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Payloads$Identify copy$default(Payloads$Identify payloads$Identify, String str, long j, String str2, String str3, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payloads$Identify.serverId;
        }
        if ((i & 2) != 0) {
            j = payloads$Identify.userId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = payloads$Identify.sessionId;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = payloads$Identify.token;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            z2 = payloads$Identify.video;
        }
        boolean z3 = z2;
        if ((i & 32) != 0) {
            list = payloads$Identify.streams;
        }
        return payloads$Identify.copy(str, j2, str4, str5, z3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getServerId() {
        return this.serverId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getVideo() {
        return this.video;
    }

    public final List<Payloads$Stream> component6() {
        return this.streams;
    }

    public final Payloads$Identify copy(String serverId, long userId, String sessionId, String token, boolean video, List<Payloads$Stream> streams) {
        m.checkNotNullParameter(serverId, "serverId");
        m.checkNotNullParameter(sessionId, "sessionId");
        m.checkNotNullParameter(token, "token");
        m.checkNotNullParameter(streams, "streams");
        return new Payloads$Identify(serverId, userId, sessionId, token, video, streams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Identify)) {
            return false;
        }
        Payloads$Identify payloads$Identify = (Payloads$Identify) other;
        return m.areEqual(this.serverId, payloads$Identify.serverId) && this.userId == payloads$Identify.userId && m.areEqual(this.sessionId, payloads$Identify.sessionId) && m.areEqual(this.token, payloads$Identify.token) && this.video == payloads$Identify.video && m.areEqual(this.streams, payloads$Identify.streams);
    }

    public final String getServerId() {
        return this.serverId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<Payloads$Stream> getStreams() {
        return this.streams;
    }

    public final String getToken() {
        return this.token;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final boolean getVideo() {
        return this.video;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public int hashCode() {
        String str = this.serverId;
        int iA = (a0.a.a.b.a(this.userId) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        String str2 = this.sessionId;
        int iHashCode = (iA + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.token;
        int iHashCode2 = (iHashCode + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z2 = this.video;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode2 + r0) * 31;
        List<Payloads$Stream> list = this.streams;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Identify(serverId=");
        sbU.append(this.serverId);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", video=");
        sbU.append(this.video);
        sbU.append(", streams=");
        return a.L(sbU, this.streams, ")");
    }
}
