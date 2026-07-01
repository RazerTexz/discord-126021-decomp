package com.discord.widgets.settings;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.utilities.voice.DiscordOverlayService;
import d0.z.d.o;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$onOverlayToggled$3 extends o implements Function1<Pair<? extends RtcConnection$StateChange, ? extends Channel>, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsVoice$onOverlayToggled$3(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends RtcConnection$StateChange, ? extends Channel> pair) {
        invoke2((Pair<RtcConnection$StateChange, Channel>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<RtcConnection$StateChange, Channel> pair) {
        DiscordOverlayService.Companion.launchForVoice(this.$context);
    }
}
