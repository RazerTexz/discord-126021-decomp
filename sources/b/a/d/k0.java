package b.a.d;

import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$State$h;
import com.discord.rtcconnection.RtcConnection$StateChange;

/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k0<T, R> implements j0.k.b<RtcConnection$StateChange, Boolean> {
    public static final k0 j = new k0();

    @Override // j0.k.b
    public Boolean call(RtcConnection$StateChange rtcConnection$StateChange) {
        RtcConnection$State rtcConnection$State = rtcConnection$StateChange.state;
        return Boolean.valueOf(((rtcConnection$State instanceof RtcConnection$State$d) || (rtcConnection$State instanceof RtcConnection$State$h)) ? false : true);
    }
}
