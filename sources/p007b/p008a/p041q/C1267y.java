package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.y */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1267y extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Throwable $throwable;
    public final /* synthetic */ RtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1267y(RtcConnection rtcConnection, Throwable th) {
        super(0);
        this.this$0 = rtcConnection;
        this.$throwable = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcConnection.m8459j(this.this$0, false, "Unable to prepare media engine.", this.$throwable, false, 8);
        return Unit.f27425a;
    }
}
