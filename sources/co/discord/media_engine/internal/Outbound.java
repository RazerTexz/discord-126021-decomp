package co.discord.media_engine.internal;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Outbound {
    private final OutboundAudio audio;
    private final String id;
    private final OutboundVideo[] videos;

    public Outbound(String str, OutboundAudio outboundAudio, OutboundVideo[] outboundVideoArr) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        this.id = str;
        this.audio = outboundAudio;
        this.videos = outboundVideoArr;
    }

    public static /* synthetic */ Outbound copy$default(Outbound outbound, String str, OutboundAudio outboundAudio, OutboundVideo[] outboundVideoArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = outbound.id;
        }
        if ((i & 2) != 0) {
            outboundAudio = outbound.audio;
        }
        if ((i & 4) != 0) {
            outboundVideoArr = outbound.videos;
        }
        return outbound.copy(str, outboundAudio, outboundVideoArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OutboundAudio getAudio() {
        return this.audio;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OutboundVideo[] getVideos() {
        return this.videos;
    }

    public final Outbound copy(String id2, OutboundAudio audio, OutboundVideo[] videos) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        return new Outbound(id2, audio, videos);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Outbound)) {
            return false;
        }
        Outbound outbound = (Outbound) other;
        return Intrinsics3.areEqual(this.id, outbound.id) && Intrinsics3.areEqual(this.audio, outbound.audio) && Intrinsics3.areEqual(this.videos, outbound.videos);
    }

    public final OutboundAudio getAudio() {
        return this.audio;
    }

    public final String getId() {
        return this.id;
    }

    public final OutboundVideo[] getVideos() {
        return this.videos;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        OutboundAudio outboundAudio = this.audio;
        int iHashCode2 = (iHashCode + (outboundAudio != null ? outboundAudio.hashCode() : 0)) * 31;
        OutboundVideo[] outboundVideoArr = this.videos;
        return iHashCode2 + (outboundVideoArr != null ? Arrays.hashCode(outboundVideoArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Outbound(id=");
        sbU.append(this.id);
        sbU.append(", audio=");
        sbU.append(this.audio);
        sbU.append(", videos=");
        sbU.append(Arrays.toString(this.videos));
        sbU.append(")");
        return sbU.toString();
    }
}
