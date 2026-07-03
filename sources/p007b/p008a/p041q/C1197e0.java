package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.e0 */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1197e0 extends AbstractC12240o implements Function1<Exception, Unit> {
    public final /* synthetic */ RtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1197e0(RtcConnection rtcConnection) {
        super(1);
        this.this$0 = rtcConnection;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Exception exc2 = exc;
        C12238m.checkNotNullParameter(exc2, "it");
        RtcConnection rtcConnection = this.this$0;
        StringBuilder sbM833U = C1643a.m833U("Error occurred while connecting to RTC server: ");
        sbM833U.append(exc2.getMessage());
        sbM833U.append('.');
        RtcConnection.m8459j(rtcConnection, true, sbM833U.toString(), null, false, 12);
        return Unit.f27425a;
    }
}
