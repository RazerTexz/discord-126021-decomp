package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$ClientDisconnect {

    @b("user_id")
    private final long userId;

    public Payloads$ClientDisconnect(long j) {
        this.userId = j;
    }

    public static /* synthetic */ Payloads$ClientDisconnect copy$default(Payloads$ClientDisconnect payloads$ClientDisconnect, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = payloads$ClientDisconnect.userId;
        }
        return payloads$ClientDisconnect.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public final Payloads$ClientDisconnect copy(long userId) {
        return new Payloads$ClientDisconnect(userId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Payloads$ClientDisconnect) && this.userId == ((Payloads$ClientDisconnect) other).userId;
        }
        return true;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return a0.a.a.b.a(this.userId);
    }

    public String toString() {
        return a.C(a.U("ClientDisconnect(userId="), this.userId, ")");
    }
}
