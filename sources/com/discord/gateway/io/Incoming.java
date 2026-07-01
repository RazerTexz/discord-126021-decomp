package com.discord.gateway.io;

import com.discord.gateway.opcodes.Opcode;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: Incoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Incoming {
    private final Object data;
    private final Opcode opcode;
    private final Integer seq;
    private final String type;

    public Incoming(String str, Integer num, Opcode opcode, Object obj) {
        Intrinsics3.checkNotNullParameter(opcode, "opcode");
        this.type = str;
        this.seq = num;
        this.opcode = opcode;
        this.data = obj;
    }

    public final Object getData() {
        return this.data;
    }

    public final Opcode getOpcode() {
        return this.opcode;
    }

    public final Integer getSeq() {
        return this.seq;
    }

    public final String getType() {
        return this.type;
    }
}
