package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.rtcconnection.RtcConnection$b;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r extends RtcConnection$b {
    public final /* synthetic */ RtcConnection j;

    public r(RtcConnection rtcConnection) {
        this.j = rtcConnection;
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onStateChange(RtcConnection$StateChange rtcConnection$StateChange) {
        d0.z.d.m.checkNotNullParameter(rtcConnection$StateChange, "stateChange");
        this.j.connectionStateSubject.onNext(rtcConnection$StateChange);
    }
}
