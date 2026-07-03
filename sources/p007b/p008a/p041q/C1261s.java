package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import java.net.URI;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p041q.p046n0.C1245a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12134g0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.s */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1261s extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ C1262t this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1261s(C1262t c1262t) {
        super(0);
        this.this$0 = c1262t;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        C1265w c1265w = this.this$0.f1871j;
        RtcConnection rtcConnection = c1265w.this$0;
        String str = c1265w.$endpoint;
        String str2 = c1265w.$token;
        SSLSocketFactory sSLSocketFactory = c1265w.$sslSocketFactory;
        rtcConnection.reconnectBackoff.succeed();
        String str3 = sSLSocketFactory != null ? "wss" : "ws";
        if (str == null || str.length() == 0) {
            C1245a c1245a = rtcConnection.socket;
            if (c1245a != null) {
                c1245a.m339c();
            }
            rtcConnection.m8478u(RtcConnection.State.C5608b.f18810a);
        } else {
            String strReplace$default = C12103t.replace$default(str, ".gg", ".media", false, 4, (Object) null);
            String strM886y = C1643a.m886y(str3, "://", strReplace$default);
            String strReplace$default2 = C12103t.replace$default(strM886y, ":80", ":443", false, 4, (Object) null);
            C1245a c1245a2 = rtcConnection.socket;
            if (c1245a2 != null) {
                c1245a2.m339c();
            }
            if (rtcConnection.destroyed) {
                RtcConnection.m8459j(rtcConnection, false, "Connect called on destroyed instance.", null, false, 4);
            } else if (str2 == null) {
                RtcConnection.m8459j(rtcConnection, false, "Connect called with no token.", null, false, 12);
            } else {
                rtcConnection.m8475r("connecting via endpoint: " + strReplace$default + " token: " + str2);
                try {
                    URI uri = new URI(strM886y);
                    rtcConnection.hostname = uri.getHost();
                    rtcConnection.port = Integer.valueOf(uri.getPort());
                } catch (Exception e) {
                    rtcConnection.logger.mo8363e(rtcConnection.loggingTag, "Failed to parse RTC endpoint", e, C12134g0.mapOf(C12116o.m10073to("endpoint", strReplace$default)));
                }
                C1245a c1245a3 = new C1245a(strReplace$default2, str2, sSLSocketFactory, rtcConnection.logger, rtcConnection.mediaEngine.mo323c(), rtcConnection.clock, rtcConnection.loggingTag);
                C1203h0 c1203h0 = rtcConnection.socketListener;
                C12238m.checkNotNullParameter(c1203h0, "listener");
                c1245a3.f1780q.add(c1203h0);
                c1245a3.m340d();
                rtcConnection.socket = c1245a3;
            }
        }
        return Unit.f27425a;
    }
}
