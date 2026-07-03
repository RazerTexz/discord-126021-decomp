package co.discord.media_engine.internal;

import com.discord.models.domain.ModelAuditLogEntry;
import org.webrtc.MediaStreamTrack;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Inbound {
    private final InboundAudio audio;
    private final String id;
    private final InboundPlayout playout;
    private final InboundVideo video;

    public Inbound(String str, InboundAudio inboundAudio, InboundVideo inboundVideo, InboundPlayout inboundPlayout) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(inboundAudio, MediaStreamTrack.AUDIO_TRACK_KIND);
        this.id = str;
        this.audio = inboundAudio;
        this.video = inboundVideo;
        this.playout = inboundPlayout;
    }

    public static /* synthetic */ Inbound copy$default(Inbound inbound, String str, InboundAudio inboundAudio, InboundVideo inboundVideo, InboundPlayout inboundPlayout, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inbound.id;
        }
        if ((i & 2) != 0) {
            inboundAudio = inbound.audio;
        }
        if ((i & 4) != 0) {
            inboundVideo = inbound.video;
        }
        if ((i & 8) != 0) {
            inboundPlayout = inbound.playout;
        }
        return inbound.copy(str, inboundAudio, inboundVideo, inboundPlayout);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InboundAudio getAudio() {
        return this.audio;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final InboundVideo getVideo() {
        return this.video;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final InboundPlayout getPlayout() {
        return this.playout;
    }

    public final Inbound copy(String id2, InboundAudio audio, InboundVideo video, InboundPlayout playout) {
        C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(audio, MediaStreamTrack.AUDIO_TRACK_KIND);
        return new Inbound(id2, audio, video, playout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Inbound)) {
            return false;
        }
        Inbound inbound = (Inbound) other;
        return C12238m.areEqual(this.id, inbound.id) && C12238m.areEqual(this.audio, inbound.audio) && C12238m.areEqual(this.video, inbound.video) && C12238m.areEqual(this.playout, inbound.playout);
    }

    public final InboundAudio getAudio() {
        return this.audio;
    }

    public final String getId() {
        return this.id;
    }

    public final InboundPlayout getPlayout() {
        return this.playout;
    }

    public final InboundVideo getVideo() {
        return this.video;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        InboundAudio inboundAudio = this.audio;
        int iHashCode2 = (iHashCode + (inboundAudio != null ? inboundAudio.hashCode() : 0)) * 31;
        InboundVideo inboundVideo = this.video;
        int iHashCode3 = (iHashCode2 + (inboundVideo != null ? inboundVideo.hashCode() : 0)) * 31;
        InboundPlayout inboundPlayout = this.playout;
        return iHashCode3 + (inboundPlayout != null ? inboundPlayout.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Inbound(id=");
        sbM833U.append(this.id);
        sbM833U.append(", audio=");
        sbM833U.append(this.audio);
        sbM833U.append(", video=");
        sbM833U.append(this.video);
        sbM833U.append(", playout=");
        sbM833U.append(this.playout);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
