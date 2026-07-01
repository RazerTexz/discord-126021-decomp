package com.discord.rtcconnection.socket.io;

import d0.Tuples;
import d0.t.Maps6;
import java.util.Map;

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
    private static final Map<Integer, String> nameLookup = Maps6.mapOf(Tuples.to(0, "IDENTIFY"), Tuples.to(1, "SELECT_PROTOCOL"), Tuples.to(2, "READY"), Tuples.to(3, "HEARTBEAT"), Tuples.to(4, "SELECT_PROTOCOL_ACK"), Tuples.to(5, "SPEAKING"), Tuples.to(6, "HEARTBEAT_ACK"), Tuples.to(7, "RESUME"), Tuples.to(8, "HELLO"), Tuples.to(9, "RESUMED"), Tuples.to(12, "VIDEO"), Tuples.to(13, "CLIENT_DISCONNECT"), Tuples.to(14, "SESSION_UPDATE"), Tuples.to(15, "MEDIA_SINK_WANTS"));

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
