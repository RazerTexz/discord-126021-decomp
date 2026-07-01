package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.RtcConnection$StateChange;
import j0.k.b;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt$callAndLaunch$1$1<T, R> implements b<RtcConnection$StateChange, Boolean> {
    public static final PrivateCallLaunchUtilsKt$callAndLaunch$1$1 INSTANCE = new PrivateCallLaunchUtilsKt$callAndLaunch$1$1();

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(RtcConnection$StateChange rtcConnection$StateChange) {
        return Boolean.valueOf(rtcConnection$StateChange.state == RtcConnection$State$f.a);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(RtcConnection$StateChange rtcConnection$StateChange) {
        return call2(rtcConnection$StateChange);
    }
}
