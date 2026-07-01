package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.RtcConnection$StateChange;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$onOverlayToggled$1<T, R> implements b<RtcConnection$StateChange, Boolean> {
    public static final WidgetSettingsVoice$onOverlayToggled$1 INSTANCE = new WidgetSettingsVoice$onOverlayToggled$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(RtcConnection$StateChange rtcConnection$StateChange) {
        return call2(rtcConnection$StateChange);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(RtcConnection$StateChange rtcConnection$StateChange) {
        return Boolean.valueOf(m.areEqual(rtcConnection$StateChange.state, RtcConnection$State$f.a));
    }
}
