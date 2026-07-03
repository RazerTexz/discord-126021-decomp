package p007b.p008a.p018d;

import com.discord.rtcconnection.RtcConnection;
import p637j0.p641k.InterfaceC12589b;

/* JADX INFO: renamed from: b.a.d.k0 */
/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0873k0<T, R> implements InterfaceC12589b<RtcConnection.StateChange, Boolean> {

    /* JADX INFO: renamed from: j */
    public static final C0873k0 f527j = new C0873k0();

    @Override // p637j0.p641k.InterfaceC12589b
    public Boolean call(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return Boolean.valueOf(((state instanceof RtcConnection.State.C5610d) || (state instanceof RtcConnection.State.C5614h)) ? false : true);
    }
}
