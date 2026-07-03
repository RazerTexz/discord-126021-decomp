package p007b.p008a.p041q.p044m0.p045c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.webrtc.MediaStreamTrack;
import p000.C12922m;
import p007b.p008a.p041q.p044m0.C1221a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.d */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1226d implements Discord.ConnectToServerCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1227e f1697a;

    /* JADX INFO: renamed from: b.a.q.m0.c.d$a */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends AbstractC12240o implements Function0<Unit> {
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
            C1227e c1227e = C1226d.this.f1697a;
            Discord.ConnectionInfo connectionInfo = this.$connectionInfo;
            String str = this.$errorMessage;
            Logger.i$default(c1227e.f1709l, "MediaEngineConnectionLegacy", C1643a.m883w("handleConnection(). errorMessage: ", str), null, 4, null);
            if (connectionInfo != null) {
                if (str == null || str.length() == 0) {
                    String str2 = connectionInfo.localAddress;
                    C12238m.checkNotNullExpressionValue(str2, "connectionInfo.localAddress");
                    int i = connectionInfo.localPort;
                    String str3 = connectionInfo.protocol;
                    C12238m.checkNotNullExpressionValue(str3, "connectionInfo.protocol");
                    Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = str3.toUpperCase();
                    C12238m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                    MediaEngineConnection.TransportInfo transportInfo = new MediaEngineConnection.TransportInfo(str2, i, MediaEngineConnection.TransportInfo.Protocol.valueOf(upperCase));
                    MediaEngineConnection.ConnectionState connectionState = MediaEngineConnection.ConnectionState.CONNECTED;
                    c1227e.f1699b = connectionState;
                    c1227e.m318y(new C1223a(c1227e, connectionState));
                    C1221a c1221a = new C1221a("opus", 1, MediaStreamTrack.AUDIO_TRACK_KIND, 120, null);
                    c1227e.f1706i.clear();
                    c1227e.f1706i.add(c1221a);
                    c1227e.f1706i.addAll(c1227e.f1712o);
                    c1227e.m318y(new C12922m(0, c1227e, transportInfo));
                } else if (connectionInfo == null) {
                    c1227e.m318y(new C12922m(1, c1227e, str));
                } else {
                    c1227e.m318y(new C12922m(2, c1227e, str));
                }
            } else if (connectionInfo == null) {
                c1227e.m318y(new C12922m(1, c1227e, str));
            } else {
                c1227e.m318y(new C12922m(2, c1227e, str));
            }
            return Unit.f27425a;
        }
    }

    public C1226d(C1227e c1227e) {
        this.f1697a = c1227e;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.ConnectToServerCallback
    public final void onConnectToServer(Discord.ConnectionInfo connectionInfo, String str) {
        C12238m.checkNotNullParameter(connectionInfo, "connectionInfo");
        C12238m.checkNotNullParameter(str, "errorMessage");
        C1227e.m294x(this.f1697a, new a(connectionInfo, str));
    }
}
