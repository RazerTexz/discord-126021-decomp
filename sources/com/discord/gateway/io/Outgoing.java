package com.discord.gateway.io;

import com.discord.gateway.opcodes.Opcode;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Outgoing {
    private final Object d;
    private final int op;

    public Outgoing(int i, Object obj) {
        this.op = i;
        this.d = obj;
    }

    public final int getOp() {
        return this.op;
    }

    public /* synthetic */ Outgoing(int i, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Outgoing(Opcode opcode, Object obj) {
        this(opcode.getApiInt(), obj);
        Intrinsics3.checkNotNullParameter(opcode, "opcode");
    }

    public /* synthetic */ Outgoing(Opcode opcode, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(opcode, (i & 2) != 0 ? null : obj);
    }
}
