package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(RtcConnection rtcConnection) {
        super(0);
        this.this$0 = rtcConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.this$0.s(new c0(this));
        return Unit.a;
    }
}
