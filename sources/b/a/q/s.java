package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$State$b;
import java.net.URI;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s extends d0.z.d.o implements Function0<Unit> {
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
            b.a.q.n0.a aVar = rtcConnection.socket;
            if (aVar != null) {
                aVar.c();
            }
            rtcConnection.u(RtcConnection$State$b.a);
        } else {
            String strReplace$default = d0.g0.t.replace$default(str, ".gg", ".media", false, 4, (Object) null);
            String strY = b.d.b.a.a.y(str3, "://", strReplace$default);
            String strReplace$default2 = d0.g0.t.replace$default(strY, ":80", ":443", false, 4, (Object) null);
            b.a.q.n0.a aVar2 = rtcConnection.socket;
            if (aVar2 != null) {
                aVar2.c();
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
                    rtcConnection.logger.e(rtcConnection.loggingTag, "Failed to parse RTC endpoint", e, d0.t.g0.mapOf(d0.o.to("endpoint", strReplace$default)));
                }
                b.a.q.n0.a aVar3 = new b.a.q.n0.a(strReplace$default2, str2, sSLSocketFactory, rtcConnection.logger, rtcConnection.mediaEngine.c(), rtcConnection.clock, rtcConnection.loggingTag);
                h0 h0Var = rtcConnection.socketListener;
                d0.z.d.m.checkNotNullParameter(h0Var, "listener");
                aVar3.q.add(h0Var);
                aVar3.d();
                rtcConnection.socket = aVar3;
            }
        }
        return Unit.a;
    }
}
