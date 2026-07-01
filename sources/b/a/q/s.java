package b.a.q;

import b.a.q.n0.RtcControlSocket;
import b.d.b.a.outline;
import com.discord.rtcconnection.RtcConnection;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.net.URI;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s extends Lambda implements Function0<Unit> {
    public final /* synthetic */ t this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar) {
        super(0);
        this.this$0 = tVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        w wVar = this.this$0.j;
        RtcConnection rtcConnection = wVar.this$0;
        String str = wVar.$endpoint;
        String str2 = wVar.$token;
        SSLSocketFactory sSLSocketFactory = wVar.$sslSocketFactory;
        rtcConnection.reconnectBackoff.succeed();
        String str3 = sSLSocketFactory != null ? "wss" : "ws";
        if (str == null || str.length() == 0) {
            RtcControlSocket rtcControlSocket = rtcConnection.socket;
            if (rtcControlSocket != null) {
                rtcControlSocket.c();
            }
            rtcConnection.u(RtcConnection.State.b.a);
        } else {
            String strReplace$default = StringsJVM.replace$default(str, ".gg", ".media", false, 4, (Object) null);
            String strY = outline.y(str3, "://", strReplace$default);
            String strReplace$default2 = StringsJVM.replace$default(strY, ":80", ":443", false, 4, (Object) null);
            RtcControlSocket rtcControlSocket2 = rtcConnection.socket;
            if (rtcControlSocket2 != null) {
                rtcControlSocket2.c();
            }
            if (rtcConnection.destroyed) {
                RtcConnection.j(rtcConnection, false, "Connect called on destroyed instance.", null, false, 4);
            } else if (str2 == null) {
                RtcConnection.j(rtcConnection, false, "Connect called with no token.", null, false, 12);
            } else {
                rtcConnection.r("connecting via endpoint: " + strReplace$default + " token: " + str2);
                try {
                    URI uri = new URI(strY);
                    rtcConnection.hostname = uri.getHost();
                    rtcConnection.port = Integer.valueOf(uri.getPort());
                } catch (Exception e) {
                    rtcConnection.logger.e(rtcConnection.loggingTag, "Failed to parse RTC endpoint", e, MapsJVM.mapOf(Tuples.to("endpoint", strReplace$default)));
                }
                RtcControlSocket rtcControlSocket3 = new RtcControlSocket(strReplace$default2, str2, sSLSocketFactory, rtcConnection.logger, rtcConnection.mediaEngine.c(), rtcConnection.clock, rtcConnection.loggingTag);
                h0 h0Var = rtcConnection.socketListener;
                Intrinsics3.checkNotNullParameter(h0Var, "listener");
                rtcControlSocket3.q.add(h0Var);
                rtcControlSocket3.d();
                rtcConnection.socket = rtcControlSocket3;
            }
        }
        return Unit.a;
    }
}
