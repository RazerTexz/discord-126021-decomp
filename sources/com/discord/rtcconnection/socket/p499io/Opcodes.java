package com.discord.rtcconnection.socket.p499io;

import java.util.Map;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;

/* JADX INFO: compiled from: Opcodes.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Opcodes {
    public static final int CLIENT_DISCONNECT = 13;
    public static final int HEARTBEAT = 3;
    public static final int HEARTBEAT_ACK = 6;
    public static final int HELLO = 8;
    public static final int IDENTIFY = 0;
    public static final int MEDIA_SINK_WANTS = 15;
    public static final int READY = 2;
    public static final int RESUME = 7;
    public static final int RESUMED = 9;
    public static final int SELECT_PROTOCOL = 1;
    public static final int SELECT_PROTOCOL_ACK = 4;
    public static final int SESSION_UPDATE = 14;
    public static final int SPEAKING = 5;
    public static final int VIDEO = 12;
    public static final Opcodes INSTANCE = new Opcodes();
    private static final Map<Integer, String> nameLookup = C12136h0.mapOf(C12116o.m10073to(0, "IDENTIFY"), C12116o.m10073to(1, "SELECT_PROTOCOL"), C12116o.m10073to(2, "READY"), C12116o.m10073to(3, "HEARTBEAT"), C12116o.m10073to(4, "SELECT_PROTOCOL_ACK"), C12116o.m10073to(5, "SPEAKING"), C12116o.m10073to(6, "HEARTBEAT_ACK"), C12116o.m10073to(7, "RESUME"), C12116o.m10073to(8, "HELLO"), C12116o.m10073to(9, "RESUMED"), C12116o.m10073to(12, "VIDEO"), C12116o.m10073to(13, "CLIENT_DISCONNECT"), C12116o.m10073to(14, "SESSION_UPDATE"), C12116o.m10073to(15, "MEDIA_SINK_WANTS"));

    private Opcodes() {
    }

    public final String getNameOf(int opcode) {
        String str = nameLookup.get(Integer.valueOf(opcode));
        if (str == null) {
            str = "Unknown (" + opcode + ')';
        }
        return str;
    }
}
