package b.a.q.n0;

import com.discord.rtcconnection.socket.io.Payloads$Resume;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.WebSocket;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$k extends o implements Function0<Unit> {
    public final /* synthetic */ WebSocket $webSocket;
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$k(a aVar, WebSocket webSocket) {
        super(0);
        this.this$0 = aVar;
        this.$webSocket = webSocket;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        boolean z2 = true;
        if (!(!m.areEqual(this.$webSocket, this.this$0.f275s))) {
            a aVar = this.this$0;
            a$c a_c = aVar.B;
            if (a_c == a$c.CONNECTING) {
                aVar.H.a();
                for (a$d a_d : aVar.q) {
                    m.checkNotNullExpressionValue(a_d, "it");
                    a_d.i();
                }
            } else if (a_c == a$c.RECONNECTING) {
                String str = aVar.u;
                String str2 = aVar.t;
                String str3 = aVar.E;
                Long l = aVar.f277y;
                if (l != null && aVar.I.currentTimeMillis() - l.longValue() > 60000) {
                    z2 = false;
                }
                if (str == null || str2 == null || !aVar.C || !z2) {
                    StringBuilder sbU = b.d.b.a.a.U("Cannot resume connection. resumable: ");
                    sbU.append(aVar.C);
                    sbU.append(" -- isHeartbeatRecentEnough: ");
                    sbU.append(z2);
                    aVar.f(false, 4801, sbU.toString());
                } else {
                    aVar.i("[RESUME] resuming session. serverId=" + str2 + " sessionId=" + str);
                    aVar.H.a();
                    for (a$d a_d2 : aVar.q) {
                        m.checkNotNullExpressionValue(a_d2, "it");
                        a_d2.h();
                    }
                    aVar.B = a$c.RESUMING;
                    aVar.n(7, new Payloads$Resume(str3, str, str2));
                }
            }
            a aVar2 = this.this$0;
            aVar2.B = a$c.CONNECTED;
            long jCurrentTimeMillis = aVar2.I.currentTimeMillis();
            Long l2 = this.this$0.A;
            long jLongValue = jCurrentTimeMillis - (l2 != null ? l2.longValue() : 0L);
            a aVar3 = this.this$0;
            StringBuilder sbU2 = b.d.b.a.a.U("[CONNECTED] to ");
            sbU2.append(this.this$0.D);
            aVar3.i(sbU2.toString());
            a aVar4 = this.this$0;
            aVar4.H.a();
            for (a$d a_d3 : aVar4.q) {
                m.checkNotNullExpressionValue(a_d3, "it");
                a_d3.g(jLongValue / ((long) 2));
            }
        }
        return Unit.a;
    }
}
