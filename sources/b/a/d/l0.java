package b.a.d;

import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.stores.StoreStream;
import rx.Observable;

/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l0<T, R> implements j0.k.b<Boolean, Observable<? extends RtcConnection$StateChange>> {
    public static final l0 j = new l0();

    @Override // j0.k.b
    public Observable<? extends RtcConnection$StateChange> call(Boolean bool) {
        return StoreStream.Companion.getRtcConnection().getConnectionState().y(k0.j);
    }
}
