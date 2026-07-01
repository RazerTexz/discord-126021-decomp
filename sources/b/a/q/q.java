package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import rx.functions.Action1;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class q<T> implements Action1<Throwable> {
    public final /* synthetic */ RtcConnection j;

    public q(RtcConnection rtcConnection) {
        this.j = rtcConnection;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        RtcConnection rtcConnection = this.j;
        StringBuilder sbU = b.d.b.a.a.U("failed to handle connectivity change in ");
        sbU.append(this.j.loggingTag);
        RtcConnection.o(rtcConnection, sbU.toString(), th, null, 4);
    }
}
