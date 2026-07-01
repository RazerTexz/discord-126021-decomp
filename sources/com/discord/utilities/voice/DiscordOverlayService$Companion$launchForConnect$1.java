package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$StateChange;
import j0.k.b;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$Companion$launchForConnect$1<T, R> implements b<RtcConnection$StateChange, String> {
    public static final DiscordOverlayService$Companion$launchForConnect$1 INSTANCE = new DiscordOverlayService$Companion$launchForConnect$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(RtcConnection$StateChange rtcConnection$StateChange) {
        return call2(rtcConnection$StateChange);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(RtcConnection$StateChange rtcConnection$StateChange) {
        RtcConnection$State rtcConnection$State = rtcConnection$StateChange.state;
        return (!(rtcConnection$State instanceof RtcConnection$State$d) || ((RtcConnection$State$d) rtcConnection$State).a) ? "com.discord.actions.OVERLAY_OPEN" : "com.discord.actions.OVERLAY_SELECTOR";
    }
}
