package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import p007b.p100d.p104b.p105a.C1643a;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.q.q */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1259q<T> implements Action1<Throwable> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ RtcConnection f1869j;

    public C1259q(RtcConnection rtcConnection) {
        this.f1869j = rtcConnection;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        RtcConnection rtcConnection = this.f1869j;
        StringBuilder sbM833U = C1643a.m833U("failed to handle connectivity change in ");
        sbM833U.append(this.f1869j.loggingTag);
        RtcConnection.m8460o(rtcConnection, sbM833U.toString(), th, null, 4);
    }
}
