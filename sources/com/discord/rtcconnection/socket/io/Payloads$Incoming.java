package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;
import com.google.gson.JsonElement;
import d0.z.d.m;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Incoming {

    @b("d")
    private final JsonElement data;

    @b("op")
    private final int opcode;

    public Payloads$Incoming(int i, JsonElement jsonElement) {
        m.checkNotNullParameter(jsonElement, "data");
        this.opcode = i;
        this.data = jsonElement;
    }

    public static /* synthetic */ Payloads$Incoming copy$default(Payloads$Incoming payloads$Incoming, int i, JsonElement jsonElement, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = payloads$Incoming.opcode;
        }
        if ((i2 & 2) != 0) {
            jsonElement = payloads$Incoming.data;
        }
        return payloads$Incoming.copy(i, jsonElement);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOpcode() {
        return this.opcode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JsonElement getData() {
        return this.data;
    }

    public final Payloads$Incoming copy(int opcode, JsonElement data) {
        m.checkNotNullParameter(data, "data");
        return new Payloads$Incoming(opcode, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Incoming)) {
            return false;
        }
        Payloads$Incoming payloads$Incoming = (Payloads$Incoming) other;
        return this.opcode == payloads$Incoming.opcode && m.areEqual(this.data, payloads$Incoming.data);
    }

    public final JsonElement getData() {
        return this.data;
    }

    public final int getOpcode() {
        return this.opcode;
    }

    public int hashCode() {
        int i = this.opcode * 31;
        JsonElement jsonElement = this.data;
        return i + (jsonElement != null ? jsonElement.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Incoming(opcode=");
        sbU.append(this.opcode);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }
}
