package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.rtcconnection.mediaengine.MediaEngine$AudioInfo;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$trackVoiceConnectionSuccess$1$1 extends o implements Function1<MediaEngine$AudioInfo, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ StoreAnalytics$trackVoiceConnectionSuccess$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$trackVoiceConnectionSuccess$1$1(StoreAnalytics$trackVoiceConnectionSuccess$1 storeAnalytics$trackVoiceConnectionSuccess$1, Channel channel) {
        super(1);
        this.this$0 = storeAnalytics$trackVoiceConnectionSuccess$1;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MediaEngine$AudioInfo mediaEngine$AudioInfo) {
        invoke2(mediaEngine$AudioInfo);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MediaEngine$AudioInfo mediaEngine$AudioInfo) {
        m.checkNotNullParameter(mediaEngine$AudioInfo, "audioInfo");
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        StoreAnalytics$trackVoiceConnectionSuccess$1 storeAnalytics$trackVoiceConnectionSuccess$1 = this.this$0;
        analyticsTracker.voiceConnectionSuccess(storeAnalytics$trackVoiceConnectionSuccess$1.$properties, mediaEngine$AudioInfo, this.$channel, StoreAnalytics.access$getStores$p(storeAnalytics$trackVoiceConnectionSuccess$1.this$0).getRtcRegion().getPreferredRegion());
    }
}
