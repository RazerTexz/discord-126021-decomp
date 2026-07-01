package com.discord.gateway.opcodes;

import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Opcode.kt */
/* JADX INFO: loaded from: classes.dex */
public enum Opcode {
    UNHANDLED(-1),
    DISPATCH(0),
    HEARTBEAT(1),
    IDENTIFY(2),
    PRESENCE_UPDATE(3),
    VOICE_STATE_UPDATE(4),
    VOICE_SERVER_PING(5),
    RESUME(6),
    RECONNECT(7),
    REQUEST_GUILD_MEMBERS(8),
    INVALID_SESSION(9),
    HELLO(10),
    HEARTBEAT_ACK(11),
    CALL_CONNECT(13),
    GUILD_SUBSCRIPTIONS(14),
    STREAM_CREATE(18),
    STREAM_DELETE(19),
    STREAM_WATCH(20),
    OPCODE_STREAM_PING(21),
    REQUEST_GUILD_APPLICATION_COMMANDS(24),
    REQUEST_FORUM_UNREADS(28);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<Integer, Opcode> intLookup;
    private final int apiInt;

    /* JADX INFO: compiled from: Opcode.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Opcode fromApiInt(int apiInt) {
            Opcode opcode = (Opcode) Opcode.intLookup.get(Integer.valueOf(apiInt));
            return opcode != null ? opcode : Opcode.UNHANDLED;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        HashMap<Integer, Opcode> map = new HashMap<>();
        Opcode[] opcodeArrValues = values();
        for (int i = 0; i < 21; i++) {
            Opcode opcode = opcodeArrValues[i];
            map.put(Integer.valueOf(opcode.apiInt), opcode);
        }
        intLookup = map;
    }

    Opcode(int i) {
        this.apiInt = i;
    }

    public final int getApiInt() {
        return this.apiInt;
    }
}
