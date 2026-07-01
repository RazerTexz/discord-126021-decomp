package com.discord.widgets.voice.fullscreen;

import com.discord.api.channel.Channel;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$toggleRequestToSpeak$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ boolean $isRaisingMyHand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$toggleRequestToSpeak$2(boolean z2, Channel channel) {
        super(1);
        this.$isRaisingMyHand = z2;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r3) {
        if (this.$isRaisingMyHand) {
            AnalyticsTracker.INSTANCE.requestToSpeakInitiated(this.$channel.getId());
        }
    }
}
