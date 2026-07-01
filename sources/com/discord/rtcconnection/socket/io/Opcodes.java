package com.discord.rtcconnection.socket.io;

import d0.o;
import d0.t.h0;
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
    private static final Map<Integer, String> nameLookup = h0.mapOf(o.to(0, "IDENTIFY"), o.to(1, "SELECT_PROTOCOL"), o.to(2, "READY"), o.to(3, "HEARTBEAT"), o.to(4, "SELECT_PROTOCOL_ACK"), o.to(5, "SPEAKING"), o.to(6, "HEARTBEAT_ACK"), o.to(7, "RESUME"), o.to(8, "HELLO"), o.to(9, "RESUMED"), o.to(12, "VIDEO"), o.to(13, "CLIENT_DISCONNECT"), o.to(14, "SESSION_UPDATE"), o.to(15, "MEDIA_SINK_WANTS"));

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
