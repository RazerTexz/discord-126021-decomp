package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.q.p */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1258p<T> implements Action1<Boolean> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ RtcConnection f1868j;

    public C1258p(RtcConnection rtcConnection) {
        this.f1868j = rtcConnection;
    }

    @Override // p658rx.functions.Action1
    public void call(Boolean bool) {
        Boolean bool2 = bool;
        this.f1868j.m8476s(new C1251o(this, bool2));
        RtcConnection rtcConnection = this.f1868j;
        C12238m.checkNotNullExpressionValue(bool2, "isConnected");
        rtcConnection.networkLossTime = bool2.booleanValue() ? null : Long.valueOf(this.f1868j.clock.currentTimeMillis());
    }
}
