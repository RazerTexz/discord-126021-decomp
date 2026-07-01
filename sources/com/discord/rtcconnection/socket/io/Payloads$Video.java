package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Video {

    @b("audio_ssrc")
    private final int audioSsrc;

    @b("rtx_ssrc")
    private final int rtxSsrc;
    private final List<Payloads$Stream> streams;

    @b("user_id")
    private final Long userId;

    @b("video_ssrc")
    private final int videoSsrc;

    public Payloads$Video(int i, int i2, int i3, Long l, List<Payloads$Stream> list) {
        this.audioSsrc = i;
        this.videoSsrc = i2;
        this.rtxSsrc = i3;
        this.userId = l;
        this.streams = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Payloads$Video copy$default(Payloads$Video payloads$Video, int i, int i2, int i3, Long l, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = payloads$Video.audioSsrc;
        }
        if ((i4 & 2) != 0) {
            i2 = payloads$Video.videoSsrc;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = payloads$Video.rtxSsrc;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            l = payloads$Video.userId;
        }
        Long l2 = l;
        if ((i4 & 16) != 0) {
            list = payloads$Video.streams;
        }
        return payloads$Video.copy(i, i5, i6, l2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAudioSsrc() {
        return this.audioSsrc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getVideoSsrc() {
        return this.videoSsrc;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRtxSsrc() {
        return this.rtxSsrc;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getUserId() {
        return this.userId;
    }

    public final List<Payloads$Stream> component5() {
        return this.streams;
    }

    public final Payloads$Video copy(int audioSsrc, int videoSsrc, int rtxSsrc, Long userId, List<Payloads$Stream> streams) {
        return new Payloads$Video(audioSsrc, videoSsrc, rtxSsrc, userId, streams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Video)) {
            return false;
        }
        Payloads$Video payloads$Video = (Payloads$Video) other;
        return this.audioSsrc == payloads$Video.audioSsrc && this.videoSsrc == payloads$Video.videoSsrc && this.rtxSsrc == payloads$Video.rtxSsrc && m.areEqual(this.userId, payloads$Video.userId) && m.areEqual(this.streams, payloads$Video.streams);
    }

    public final int getAudioSsrc() {
        return this.audioSsrc;
    }

    public final int getRtxSsrc() {
        return this.rtxSsrc;
    }

    public final List<Payloads$Stream> getStreams() {
        return this.streams;
    }

    public final Long getUserId() {
        return this.userId;
    }

    public final int getVideoSsrc() {
        return this.videoSsrc;
    }

    public int hashCode() {
        int i = ((((this.audioSsrc * 31) + this.videoSsrc) * 31) + this.rtxSsrc) * 31;
        Long l = this.userId;
        int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        List<Payloads$Stream> list = this.streams;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Video(audioSsrc=");
        sbU.append(this.audioSsrc);
        sbU.append(", videoSsrc=");
        sbU.append(this.videoSsrc);
        sbU.append(", rtxSsrc=");
        sbU.append(this.rtxSsrc);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", streams=");
        return a.L(sbU, this.streams, ")");
    }

    public /* synthetic */ Payloads$Video(int i, int i2, int i3, Long l, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? null : l, list);
    }
}
