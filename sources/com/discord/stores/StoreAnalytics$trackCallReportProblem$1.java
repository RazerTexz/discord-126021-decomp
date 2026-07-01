package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.rtcconnection.audio.DiscordAudioManager$AudioDevice;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.voice.feedback.PendingFeedback$CallFeedback;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$trackCallReportProblem$1 extends o implements Function0<Unit> {
    public final /* synthetic */ PendingFeedback$CallFeedback $pendingCallFeedback;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$trackCallReportProblem$1(StoreAnalytics storeAnalytics, PendingFeedback$CallFeedback pendingFeedback$CallFeedback) {
        super(0);
        this.this$0 = storeAnalytics;
        this.$pendingCallFeedback = pendingFeedback$CallFeedback;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        long id2 = StoreAnalytics.access$getStores$p(this.this$0).getUsers().getMe().getId();
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(this.this$0).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$pendingCallFeedback.getChannelId());
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            StoreMediaSettings mediaSettings = StoreAnalytics.access$getStores$p(this.this$0).getMediaSettings();
            DiscordAudioManager$AudioDevice lastActiveAudioDevice = StoreAnalytics.access$getStores$p(this.this$0).getAudioManagerV2().getLastActiveAudioDevice();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            String rtcConnectionId = this.$pendingCallFeedback.getRtcConnectionId();
            Map<Long, VoiceState> mapEmptyMap = (Map) a.c(channelFindChannelByIdInternal$app_productionGoogleRelease, StoreAnalytics.access$getStores$p(this.this$0).getVoiceStates().get());
            if (mapEmptyMap == null) {
                mapEmptyMap = h0.emptyMap();
            }
            analyticsTracker.callReportProblem(id2, rtcConnectionId, channelFindChannelByIdInternal$app_productionGoogleRelease, mapEmptyMap, this.$pendingCallFeedback.getDurationMs(), this.$pendingCallFeedback.getMediaSessionId(), this.$pendingCallFeedback.getFeedbackRating(), this.$pendingCallFeedback.getReasonCode(), this.$pendingCallFeedback.getReasonDescription(), mediaSettings.getVoiceConfigurationBlocking(), lastActiveAudioDevice, mediaSettings.getVideoHardwareScalingBlocking(), this.$pendingCallFeedback.getIssueDetails());
        }
    }
}
