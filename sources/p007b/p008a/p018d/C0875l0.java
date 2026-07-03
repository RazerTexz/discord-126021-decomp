package p007b.p008a.p018d;

import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.d.l0 */
/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0875l0<T, R> implements InterfaceC12589b<Boolean, Observable<? extends RtcConnection.StateChange>> {

    /* JADX INFO: renamed from: j */
    public static final C0875l0 f531j = new C0875l0();

    @Override // p637j0.p641k.InterfaceC12589b
    public Observable<? extends RtcConnection.StateChange> call(Boolean bool) {
        return StoreStream.INSTANCE.getRtcConnection().getConnectionState().m11118y(C0873k0.f527j);
    }
}
