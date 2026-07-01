package b.a.d;

import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import j0.k.Func1;
import rx.Observable;

/* JADX INFO: renamed from: b.a.d.l0, reason: use source file name */
/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordConnectService4<T, R> implements Func1<Boolean, Observable<? extends RtcConnection.StateChange>> {
    public static final DiscordConnectService4 j = new DiscordConnectService4();

    @Override // j0.k.Func1
    public Observable<? extends RtcConnection.StateChange> call(Boolean bool) {
        return StoreStream.INSTANCE.getRtcConnection().getConnectionState().y(DiscordConnectService3.j);
    }
}
