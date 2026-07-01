package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ Boolean $isConnected;
    public final /* synthetic */ p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p pVar, Boolean bool) {
        super(0);
        this.this$0 = pVar;
        this.$isConnected = bool;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcConnection rtcConnection = this.this$0.j;
        Boolean bool = this.$isConnected;
        d0.z.d.m.checkNotNullExpressionValue(bool, "isConnected");
        boolean zBooleanValue = bool.booleanValue();
        b.a.q.n0.a aVar = rtcConnection.socket;
        if (aVar == null) {
            RtcConnection.o(rtcConnection, "handleConnectivityChange() socket was null.", null, null, 6);
        } else if (zBooleanValue) {
            aVar.g(5000L, "network detected online", true);
        } else {
            aVar.g(15000L, "network detected offline", false);
        }
        return Unit.a;
    }
}
