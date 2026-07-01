package b.a.q.m0.c;

import b.a.q.m0.Codec2;
import b.d.b.a.outline;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: renamed from: b.a.q.m0.c.d, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy4 implements Discord.ConnectToServerCallback {
    public final /* synthetic */ MediaEngineConnectionLegacy5 a;

    /* JADX INFO: renamed from: b.a.q.m0.c.d$a */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Discord.ConnectionInfo $connectionInfo;
        public final /* synthetic */ String $errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Discord.ConnectionInfo connectionInfo, String str) {
            super(0);
            this.$connectionInfo = connectionInfo;
            this.$errorMessage = str;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0087 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:14:0x0089  */
        /* JADX WARN: Code duplicated, block: B:15:0x0092  */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5 = MediaEngineConnectionLegacy4.this.a;
            Discord.ConnectionInfo connectionInfo = this.$connectionInfo;
            String str = this.$errorMessage;
            Logger.i$default(mediaEngineConnectionLegacy5.l, "MediaEngineConnectionLegacy", outline.w("handleConnection(). errorMessage: ", str), null, 4, null);
            if (connectionInfo != null) {
                if (str == null || str.length() == 0) {
                    String str2 = connectionInfo.localAddress;
                    Intrinsics3.checkNotNullExpressionValue(str2, "connectionInfo.localAddress");
                    int i = connectionInfo.localPort;
                    String str3 = connectionInfo.protocol;
                    Intrinsics3.checkNotNullExpressionValue(str3, "connectionInfo.protocol");
                    Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = str3.toUpperCase();
                    Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                    MediaEngineConnection.TransportInfo transportInfo = new MediaEngineConnection.TransportInfo(str2, i, MediaEngineConnection.TransportInfo.Protocol.valueOf(upperCase));
                    MediaEngineConnection.ConnectionState connectionState = MediaEngineConnection.ConnectionState.CONNECTED;
                    mediaEngineConnectionLegacy5.f270b = connectionState;
                    mediaEngineConnectionLegacy5.y(new MediaEngineConnectionLegacy(mediaEngineConnectionLegacy5, connectionState));
                    Codec2 codec2 = new Codec2("opus", 1, MediaStreamTrack.AUDIO_TRACK_KIND, 120, null);
                    mediaEngineConnectionLegacy5.i.clear();
                    mediaEngineConnectionLegacy5.i.add(codec2);
                    mediaEngineConnectionLegacy5.i.addAll(mediaEngineConnectionLegacy5.o);
                    mediaEngineConnectionLegacy5.y(new defpackage.m(0, mediaEngineConnectionLegacy5, transportInfo));
                } else if (connectionInfo == null) {
                    mediaEngineConnectionLegacy5.y(new defpackage.m(1, mediaEngineConnectionLegacy5, str));
                } else {
                    mediaEngineConnectionLegacy5.y(new defpackage.m(2, mediaEngineConnectionLegacy5, str));
                }
            } else if (connectionInfo == null) {
                mediaEngineConnectionLegacy5.y(new defpackage.m(1, mediaEngineConnectionLegacy5, str));
            } else {
                mediaEngineConnectionLegacy5.y(new defpackage.m(2, mediaEngineConnectionLegacy5, str));
            }
            return Unit.a;
        }
    }

    public MediaEngineConnectionLegacy4(MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5) {
        this.a = mediaEngineConnectionLegacy5;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.ConnectToServerCallback
    public final void onConnectToServer(Discord.ConnectionInfo connectionInfo, String str) {
        Intrinsics3.checkNotNullParameter(connectionInfo, "connectionInfo");
        Intrinsics3.checkNotNullParameter(str, "errorMessage");
        MediaEngineConnectionLegacy5.x(this.a, new a(connectionInfo, str));
    }
}
