package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$trackVoiceAudioOutputModeSelected$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ DiscordAudioManager$DeviceTypes $fromAudioOutputMode;
    public final /* synthetic */ DiscordAudioManager$DeviceTypes $toAudioOutputMode;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$trackVoiceAudioOutputModeSelected$1(StoreAnalytics storeAnalytics, long j, DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes, DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes2) {
        super(0);
        this.this$0 = storeAnalytics;
        this.$channelId = j;
        this.$fromAudioOutputMode = discordAudioManager$DeviceTypes;
        this.$toAudioOutputMode = discordAudioManager$DeviceTypes2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        long id2 = StoreAnalytics.access$getStores$p(this.this$0).getUsers().getMe().getId();
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(this.this$0).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            RtcConnection$Metadata rtcConnectionMetadata = StoreAnalytics.access$getStores$p(this.this$0).getRtcConnection().getRtcConnectionMetadata();
            AnalyticsTracker.INSTANCE.voiceAudioOutputModeSelected(id2, rtcConnectionMetadata != null ? rtcConnectionMetadata.rtcConnectionId : null, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, channelFindChannelByIdInternal$app_productionGoogleRelease, this.$fromAudioOutputMode, this.$toAudioOutputMode);
        }
    }
}
