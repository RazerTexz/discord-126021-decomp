package com.discord.widgets.voice.fullscreen;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.utilities.voice.VoiceChannelJoinability;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheetViewModel$observeStoreState$1<T1, T2, R> implements Func2<Channel, VoiceChannelJoinability, WidgetGuildCallOnboardingSheetViewModel$StoreState> {
    public static final WidgetGuildCallOnboardingSheetViewModel$observeStoreState$1 INSTANCE = new WidgetGuildCallOnboardingSheetViewModel$observeStoreState$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGuildCallOnboardingSheetViewModel$StoreState call(Channel channel, VoiceChannelJoinability voiceChannelJoinability) {
        return call2(channel, voiceChannelJoinability);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildCallOnboardingSheetViewModel$StoreState call2(Channel channel, VoiceChannelJoinability voiceChannelJoinability) {
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        m.checkNotNullExpressionValue(voiceChannelJoinability, "joinability");
        return new WidgetGuildCallOnboardingSheetViewModel$StoreState(lValueOf, voiceChannelJoinability);
    }
}
