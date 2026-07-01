package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import d0.z.d.Intrinsics3;
import rx.functions.Action1;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p<T> implements Action1<Boolean> {
    public final /* synthetic */ RtcConnection j;

    public p(RtcConnection rtcConnection) {
        this.j = rtcConnection;
    }

    @Override // rx.functions.Action1
    public void call(Boolean bool) {
        Boolean bool2 = bool;
        this.j.s(new o(this, bool2));
        RtcConnection rtcConnection = this.j;
        Intrinsics3.checkNotNullExpressionValue(bool2, "isConnected");
        rtcConnection.networkLossTime = bool2.booleanValue() ? null : Long.valueOf(this.j.clock.currentTimeMillis());
    }
}
