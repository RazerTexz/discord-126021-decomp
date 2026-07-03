package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p041q.p046n0.C1245a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.o */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1251o extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Boolean $isConnected;
    public final /* synthetic */ C1258p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1251o(C1258p c1258p, Boolean bool) {
        super(0);
        this.this$0 = c1258p;
        this.$isConnected = bool;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcConnection rtcConnection = this.this$0.f1868j;
        Boolean bool = this.$isConnected;
        C12238m.checkNotNullExpressionValue(bool, "isConnected");
        boolean zBooleanValue = bool.booleanValue();
        C1245a c1245a = rtcConnection.socket;
        if (c1245a == null) {
            RtcConnection.m8460o(rtcConnection, "handleConnectivityChange() socket was null.", null, null, 6);
        } else if (zBooleanValue) {
            c1245a.m343g(5000L, "network detected online", true);
        } else {
            c1245a.m343g(15000L, "network detected offline", false);
        }
        return Unit.f27425a;
    }
}
