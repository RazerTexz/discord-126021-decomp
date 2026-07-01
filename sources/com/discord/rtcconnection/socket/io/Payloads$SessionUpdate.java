package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;
import d0.z.d.m;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$SessionUpdate {

    @b("media_session_id")
    private final String mediaSessionId;

    public Payloads$SessionUpdate(String str) {
        this.mediaSessionId = str;
    }

    public static /* synthetic */ Payloads$SessionUpdate copy$default(Payloads$SessionUpdate payloads$SessionUpdate, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payloads$SessionUpdate.mediaSessionId;
        }
        return payloads$SessionUpdate.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    public final Payloads$SessionUpdate copy(String mediaSessionId) {
        return new Payloads$SessionUpdate(mediaSessionId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Payloads$SessionUpdate) && m.areEqual(this.mediaSessionId, ((Payloads$SessionUpdate) other).mediaSessionId);
        }
        return true;
    }

    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    public int hashCode() {
        String str = this.mediaSessionId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("SessionUpdate(mediaSessionId="), this.mediaSessionId, ")");
    }
}
