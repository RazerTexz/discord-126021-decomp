package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Speaking {
    public static final Payloads$Speaking$Companion Companion = new Payloads$Speaking$Companion(null);
    public static final int NOT_SPEAKING = 0;
    public static final int SPEAKING = 1;
    private final Integer delay;
    private final Integer speaking;
    private final int ssrc;

    @b("user_id")
    private final Long userId;

    public Payloads$Speaking(int i, Integer num, Integer num2, Long l) {
        this.ssrc = i;
        this.speaking = num;
        this.delay = num2;
        this.userId = l;
    }

    public static /* synthetic */ Payloads$Speaking copy$default(Payloads$Speaking payloads$Speaking, int i, Integer num, Integer num2, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = payloads$Speaking.ssrc;
        }
        if ((i2 & 2) != 0) {
            num = payloads$Speaking.speaking;
        }
        if ((i2 & 4) != 0) {
            num2 = payloads$Speaking.delay;
        }
        if ((i2 & 8) != 0) {
            l = payloads$Speaking.userId;
        }
        return payloads$Speaking.copy(i, num, num2, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSpeaking() {
        return this.speaking;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDelay() {
        return this.delay;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getUserId() {
        return this.userId;
    }

    public final Payloads$Speaking copy(int ssrc, Integer speaking, Integer delay, Long userId) {
        return new Payloads$Speaking(ssrc, speaking, delay, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Speaking)) {
            return false;
        }
        Payloads$Speaking payloads$Speaking = (Payloads$Speaking) other;
        return this.ssrc == payloads$Speaking.ssrc && m.areEqual(this.speaking, payloads$Speaking.speaking) && m.areEqual(this.delay, payloads$Speaking.delay) && m.areEqual(this.userId, payloads$Speaking.userId);
    }

    public final Integer getDelay() {
        return this.delay;
    }

    public final Integer getSpeaking() {
        return this.speaking;
    }

    public final int getSsrc() {
        return this.ssrc;
    }

    public final Long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int i = this.ssrc * 31;
        Integer num = this.speaking;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.delay;
        int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Long l = this.userId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Speaking(ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", speaking=");
        sbU.append(this.speaking);
        sbU.append(", delay=");
        sbU.append(this.delay);
        sbU.append(", userId=");
        return a.G(sbU, this.userId, ")");
    }

    public /* synthetic */ Payloads$Speaking(int i, Integer num, Integer num2, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : l);
    }
}
