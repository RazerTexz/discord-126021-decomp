package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection$StateChange;
import rx.functions.Func2;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt$callAndLaunch$1$3<T1, T2, R> implements Func2<RtcConnection$StateChange, Long, Long> {
    public static final PrivateCallLaunchUtilsKt$callAndLaunch$1$3 INSTANCE = new PrivateCallLaunchUtilsKt$callAndLaunch$1$3();

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(RtcConnection$StateChange rtcConnection$StateChange, Long l) {
        return l;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Long call(RtcConnection$StateChange rtcConnection$StateChange, Long l) {
        return call2(rtcConnection$StateChange, l);
    }
}
