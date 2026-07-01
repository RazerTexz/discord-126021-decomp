package com.discord.gateway.opcodes;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Opcode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Opcode$Companion {
    private Opcode$Companion() {
    }

    public final Opcode fromApiInt(int apiInt) {
        Opcode opcode = (Opcode) Opcode.access$getIntLookup$cp().get(Integer.valueOf(apiInt));
        return opcode != null ? opcode : Opcode.UNHANDLED;
    }

    public /* synthetic */ Opcode$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
