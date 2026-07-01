package b.a.d;

import com.discord.rtcconnection.RtcConnection;
import j0.k.Func1;

/* JADX INFO: renamed from: b.a.d.k0, reason: use source file name */
/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordConnectService3<T, R> implements Func1<RtcConnection.StateChange, Boolean> {
    public static final DiscordConnectService3 j = new DiscordConnectService3();

    @Override // j0.k.Func1
    public Boolean call(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return Boolean.valueOf(((state instanceof RtcConnection.State.d) || (state instanceof RtcConnection.State.h)) ? false : true);
    }
}
