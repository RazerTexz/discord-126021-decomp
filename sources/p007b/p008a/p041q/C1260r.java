package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.r */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1260r extends RtcConnection.AbstractC5616b {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ RtcConnection f1870j;

    public C1260r(RtcConnection rtcConnection) {
        this.f1870j = rtcConnection;
    }

    @Override // com.discord.rtcconnection.RtcConnection.AbstractC5616b, com.discord.rtcconnection.RtcConnection.InterfaceC5617c
    public void onStateChange(RtcConnection.StateChange stateChange) {
        C12238m.checkNotNullParameter(stateChange, "stateChange");
        this.f1870j.connectionStateSubject.onNext(stateChange);
    }
}
