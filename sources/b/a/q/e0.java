package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends d0.z.d.o implements Function1<Exception, Unit> {
    public final /* synthetic */ RtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(RtcConnection rtcConnection) {
        super(1);
        this.this$0 = rtcConnection;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Exception exc2 = exc;
        d0.z.d.m.checkNotNullParameter(exc2, "it");
        RtcConnection rtcConnection = this.this$0;
        StringBuilder sbU = b.d.b.a.a.U("Error occurred while connecting to RTC server: ");
        sbU.append(exc2.getMessage());
        sbU.append('.');
        RtcConnection.j(rtcConnection, true, sbU.toString(), null, false, 12);
        return Unit.a;
    }
}
