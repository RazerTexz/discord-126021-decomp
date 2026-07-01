package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;
import d0.z.d.m;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Outgoing {

    @b("d")
    private final Object data;

    @b("op")
    private final int opcode;

    public Payloads$Outgoing(int i, Object obj) {
        m.checkNotNullParameter(obj, "data");
        this.opcode = i;
        this.data = obj;
    }

    public static /* synthetic */ Payloads$Outgoing copy$default(Payloads$Outgoing payloads$Outgoing, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = payloads$Outgoing.opcode;
        }
        if ((i2 & 2) != 0) {
            obj = payloads$Outgoing.data;
        }
        return payloads$Outgoing.copy(i, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOpcode() {
        return this.opcode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public final Payloads$Outgoing copy(int opcode, Object data) {
        m.checkNotNullParameter(data, "data");
        return new Payloads$Outgoing(opcode, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Outgoing)) {
            return false;
        }
        Payloads$Outgoing payloads$Outgoing = (Payloads$Outgoing) other;
        return this.opcode == payloads$Outgoing.opcode && m.areEqual(this.data, payloads$Outgoing.data);
    }

    public final Object getData() {
        return this.data;
    }

    public final int getOpcode() {
        return this.opcode;
    }

    public int hashCode() {
        int i = this.opcode * 31;
        Object obj = this.data;
        return i + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Outgoing(opcode=");
        sbU.append(this.opcode);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }
}
