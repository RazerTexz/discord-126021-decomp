package com.discord.widgets.voice.fullscreen;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.experiments.domain.Experiment;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.stores.StoreConnectivity$DelayedState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageCallModel;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$observeStoreState$1$1<T, R> implements b<CallModel, Observable<? extends WidgetCallFullscreenViewModel$StoreState>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetCallFullscreenViewModel$observeStoreState$1 this$0;

    public WidgetCallFullscreenViewModel$observeStoreState$1$1(WidgetCallFullscreenViewModel$observeStoreState$1 widgetCallFullscreenViewModel$observeStoreState$1, Channel channel) {
        this.this$0 = widgetCallFullscreenViewModel$observeStoreState$1;
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetCallFullscreenViewModel$StoreState> call(CallModel callModel) {
        return call2(callModel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetCallFullscreenViewModel$StoreState> call2(CallModel callModel) {
        Observable<StageCallModel> observableObserveStageCallModel = StageCallModel.Companion.observeStageCallModel(WidgetCallFullscreenViewModel.access$getChannelId$p(this.this$0.this$0));
        Observable<Long> observableObservePermissionsForChannel = WidgetCallFullscreenViewModel.access$getPermissionsStore$p(this.this$0.this$0).observePermissionsForChannel(WidgetCallFullscreenViewModel.access$getChannelId$p(this.this$0.this$0));
        Observable<Float> observableR = WidgetCallFullscreenViewModel.access$getStreamRtcConnectionStore$p(this.this$0.this$0).observeStreamVolume().r();
        m.checkNotNullExpressionValue(observableR, "streamRtcConnectionStore…().distinctUntilChanged()");
        Observable<RtcConnection$Quality> observableR2 = WidgetCallFullscreenViewModel.access$getStreamRtcConnectionStore$p(this.this$0.this$0).observeConnectionQuality().r();
        m.checkNotNullExpressionValue(observableR2, "streamRtcConnectionStore…().distinctUntilChanged()");
        Observable<Boolean> observableObserveScreenreaderEnabled = WidgetCallFullscreenViewModel.access$getAccessibilityStore$p(this.this$0.this$0).observeScreenreaderEnabled();
        Observable<Integer> observableObserveTotalMentions = WidgetCallFullscreenViewModel.access$getMentionsStore$p(this.this$0.this$0).observeTotalMentions();
        Observable<StoreConnectivity$DelayedState> observableObserveState = WidgetCallFullscreenViewModel.access$getConnectivityStore$p(this.this$0.this$0).observeState();
        Observable<StageRoles> observableR3 = WidgetCallFullscreenViewModel.access$getStageStore$p(this.this$0.this$0).observeMyRoles(WidgetCallFullscreenViewModel.access$getChannelId$p(this.this$0.this$0)).r();
        m.checkNotNullExpressionValue(observableR3, "stageStore.observeMyRole…d).distinctUntilChanged()");
        Observable<Experiment> observableObserveUserExperiment = WidgetCallFullscreenViewModel.access$getExperimentsStore$p(this.this$0.this$0).observeUserExperiment("2021-03_stop_offscreen_video_streams", true);
        TextInVoiceFeatureFlag instance = TextInVoiceFeatureFlag.Companion.getINSTANCE();
        Channel channel = this.$channel;
        Observable<Boolean> observableObserveEnabled = instance.observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null);
        Observable<Channel> observableObserveSelectedChannel = WidgetCallFullscreenViewModel.access$getChannelsSelectedStore$p(this.this$0.this$0).observeSelectedChannel();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveStageCallModel, observableObservePermissionsForChannel, observableR, observableR2, observableObserveScreenreaderEnabled, observableObserveTotalMentions, observableObserveState, observableR3, observableObserveUserExperiment, observableObserveEnabled, observableObserveSelectedChannel, storeStream$Companion.getMentions().observeMentionCounts(), storeStream$Companion.getReadStates().observeUnreadCountForChannel(WidgetCallFullscreenViewModel.access$getChannelId$p(this.this$0.this$0), new UtcDateTime(callModel != null ? callModel.getTimeConnectedMs() : 0L)), WidgetCallFullscreenViewModel.access$getApplicationAssetsStore$p(this.this$0.this$0).observeEmbeddedAppBackgrounds(), new WidgetCallFullscreenViewModel$observeStoreState$1$1$1(this, callModel));
    }
}
