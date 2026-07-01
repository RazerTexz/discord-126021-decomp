package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Protocol$CodecInfo {
    private final String name;

    @b("payload_type")
    private final int payloadType;
    private final int priority;

    @b("rtx_payload_type")
    private final Integer rtxPayloadType;
    private final String type;

    public Payloads$Protocol$CodecInfo(String str, int i, String str2, int i2, Integer num) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(str2, "type");
        this.name = str;
        this.priority = i;
        this.type = str2;
        this.payloadType = i2;
        this.rtxPayloadType = num;
    }

    public static /* synthetic */ Payloads$Protocol$CodecInfo copy$default(Payloads$Protocol$CodecInfo payloads$Protocol$CodecInfo, String str, int i, String str2, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = payloads$Protocol$CodecInfo.name;
        }
        if ((i3 & 2) != 0) {
            i = payloads$Protocol$CodecInfo.priority;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            str2 = payloads$Protocol$CodecInfo.type;
        }
        String str3 = str2;
        if ((i3 & 8) != 0) {
            i2 = payloads$Protocol$CodecInfo.payloadType;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            num = payloads$Protocol$CodecInfo.rtxPayloadType;
        }
        return payloads$Protocol$CodecInfo.copy(str, i4, str3, i5, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPayloadType() {
        return this.payloadType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getRtxPayloadType() {
        return this.rtxPayloadType;
    }

    public final Payloads$Protocol$CodecInfo copy(String name, int priority, String type, int payloadType, Integer rtxPayloadType) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(type, "type");
        return new Payloads$Protocol$CodecInfo(name, priority, type, payloadType, rtxPayloadType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Protocol$CodecInfo)) {
            return false;
        }
        Payloads$Protocol$CodecInfo payloads$Protocol$CodecInfo = (Payloads$Protocol$CodecInfo) other;
        return m.areEqual(this.name, payloads$Protocol$CodecInfo.name) && this.priority == payloads$Protocol$CodecInfo.priority && m.areEqual(this.type, payloads$Protocol$CodecInfo.type) && this.payloadType == payloads$Protocol$CodecInfo.payloadType && m.areEqual(this.rtxPayloadType, payloads$Protocol$CodecInfo.rtxPayloadType);
    }

    public final String getName() {
        return this.name;
    }

    public final int getPayloadType() {
        return this.payloadType;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final Integer getRtxPayloadType() {
        return this.rtxPayloadType;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.priority) * 31;
        String str2 = this.type;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.payloadType) * 31;
        Integer num = this.rtxPayloadType;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CodecInfo(name=");
        sbU.append(this.name);
        sbU.append(", priority=");
        sbU.append(this.priority);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", payloadType=");
        sbU.append(this.payloadType);
        sbU.append(", rtxPayloadType=");
        return a.F(sbU, this.rtxPayloadType, ")");
    }
}
