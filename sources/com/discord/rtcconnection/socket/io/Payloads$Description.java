package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import b.i.d.p.b;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Description {

    @b("audio_codec")
    private final String audioCodec;

    @b("media_session_id")
    private final String mediaSessionId;
    private final String mode;

    @b("secret_key")
    private final List<Integer> secretKey;

    @b("video_codec")
    private final String videoCodec;

    public Payloads$Description(List<Integer> list, String str, String str2, String str3, String str4) {
        m.checkNotNullParameter(list, "secretKey");
        m.checkNotNullParameter(str2, "audioCodec");
        m.checkNotNullParameter(str3, "videoCodec");
        m.checkNotNullParameter(str4, "mode");
        this.secretKey = list;
        this.mediaSessionId = str;
        this.audioCodec = str2;
        this.videoCodec = str3;
        this.mode = str4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Payloads$Description copy$default(Payloads$Description payloads$Description, List list, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = payloads$Description.secretKey;
        }
        if ((i & 2) != 0) {
            str = payloads$Description.mediaSessionId;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = payloads$Description.audioCodec;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = payloads$Description.videoCodec;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = payloads$Description.mode;
        }
        return payloads$Description.copy(list, str5, str6, str7, str4);
    }

    public final List<Integer> component1() {
        return this.secretKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAudioCodec() {
        return this.audioCodec;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVideoCodec() {
        return this.videoCodec;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final Payloads$Description copy(List<Integer> secretKey, String mediaSessionId, String audioCodec, String videoCodec, String mode) {
        m.checkNotNullParameter(secretKey, "secretKey");
        m.checkNotNullParameter(audioCodec, "audioCodec");
        m.checkNotNullParameter(videoCodec, "videoCodec");
        m.checkNotNullParameter(mode, "mode");
        return new Payloads$Description(secretKey, mediaSessionId, audioCodec, videoCodec, mode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Description)) {
            return false;
        }
        Payloads$Description payloads$Description = (Payloads$Description) other;
        return m.areEqual(this.secretKey, payloads$Description.secretKey) && m.areEqual(this.mediaSessionId, payloads$Description.mediaSessionId) && m.areEqual(this.audioCodec, payloads$Description.audioCodec) && m.areEqual(this.videoCodec, payloads$Description.videoCodec) && m.areEqual(this.mode, payloads$Description.mode);
    }

    public final String getAudioCodec() {
        return this.audioCodec;
    }

    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    public final String getMode() {
        return this.mode;
    }

    public final List<Integer> getSecretKey() {
        return this.secretKey;
    }

    public final String getVideoCodec() {
        return this.videoCodec;
    }

    public int hashCode() {
        List<Integer> list = this.secretKey;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.mediaSessionId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.audioCodec;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.videoCodec;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mode;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Description(secretKey=");
        sbU.append(this.secretKey);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", audioCodec=");
        sbU.append(this.audioCodec);
        sbU.append(", videoCodec=");
        sbU.append(this.videoCodec);
        sbU.append(", mode=");
        return a.J(sbU, this.mode, ")");
    }
}
