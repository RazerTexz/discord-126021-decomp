package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.rtcconnection.RtcConnection$StateChange;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$onOverlayToggled$2<T1, T2, R> implements Func2<RtcConnection$StateChange, Channel, Pair<? extends RtcConnection$StateChange, ? extends Channel>> {
    public static final WidgetSettingsVoice$onOverlayToggled$2 INSTANCE = new WidgetSettingsVoice$onOverlayToggled$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends RtcConnection$StateChange, ? extends Channel> call(RtcConnection$StateChange rtcConnection$StateChange, Channel channel) {
        return call2(rtcConnection$StateChange, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<RtcConnection$StateChange, Channel> call2(RtcConnection$StateChange rtcConnection$StateChange, Channel channel) {
        return o.to(rtcConnection$StateChange, channel);
    }
}
