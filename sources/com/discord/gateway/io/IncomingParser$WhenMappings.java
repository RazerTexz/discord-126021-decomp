package com.discord.gateway.io;

import com.discord.gateway.opcodes.Opcode;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IncomingParser$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        Opcode.values();
        int[] iArr = new int[21];
        $EnumSwitchMapping$0 = iArr;
        iArr[Opcode.HELLO.ordinal()] = 1;
        iArr[Opcode.INVALID_SESSION.ordinal()] = 2;
        iArr[Opcode.DISPATCH.ordinal()] = 3;
    }
}
