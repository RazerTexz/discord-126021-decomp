package com.discord.gateway;

import com.discord.gateway.opcodes.Opcode;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GatewaySocket$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        GatewaySocketLogger$LogLevel.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        iArr[GatewaySocketLogger$LogLevel.NONE.ordinal()] = 1;
        iArr[GatewaySocketLogger$LogLevel.VERBOSE.ordinal()] = 2;
        Opcode.values();
        int[] iArr2 = new int[21];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[Opcode.HELLO.ordinal()] = 1;
        iArr2[Opcode.RECONNECT.ordinal()] = 2;
        iArr2[Opcode.INVALID_SESSION.ordinal()] = 3;
        iArr2[Opcode.HEARTBEAT.ordinal()] = 4;
        iArr2[Opcode.HEARTBEAT_ACK.ordinal()] = 5;
        iArr2[Opcode.DISPATCH.ordinal()] = 6;
    }
}
