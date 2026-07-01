package com.discord.widgets.voice.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallModel$Companion$get$1$1<T, R> implements b<Map<Long, ? extends EmbeddedActivity>, Observable<? extends CallModel>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ CallModel$Companion$get$1 this$0;

    public CallModel$Companion$get$1$1(CallModel$Companion$get$1 callModel$Companion$get$1, Channel channel) {
        this.this$0 = callModel$Companion$get$1;
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends CallModel> call(Map<Long, ? extends EmbeddedActivity> map) {
        return call2((Map<Long, EmbeddedActivity>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends CallModel> call2(Map<Long, EmbeddedActivity> map) {
        Set<Long> setKeySet = map.keySet();
        Observable observableAccess$observeChunk = CallModel$Companion.access$observeChunk(CallModel.Companion, this.$channel);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<StoreApplicationStreaming$ActiveApplicationStream> observableObserveActiveStream = storeStream$Companion.getApplicationStreaming().observeActiveStream();
        Observable<RtcConnection$Metadata> observableObserveRtcConnectionMetadata = storeStream$Companion.getRtcConnection().observeRtcConnectionMetadata();
        Observable<R> observableG = storeStream$Companion.getExperiments().observeUserExperiment("2019-12_android_call_feedback_sheet_sample_rate_denominator", true).G(CallModel$Companion$get$1$1$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n            …experiment?.bucket ?: 0 }");
        Observable<R> observableG2 = storeStream$Companion.getExperiments().observeUserExperiment("2020-09_stream_feedback_sheet_sample_rate_denominator", true).G(CallModel$Companion$get$1$1$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG2, "StoreStream\n            …experiment?.bucket ?: 0 }");
        return ObservableCombineLatestOverloadsKt.combineLatest(observableAccess$observeChunk, observableObserveActiveStream, observableObserveRtcConnectionMetadata, observableG, observableG2, VoiceChannelJoinabilityUtils.observeJoinability$default(VoiceChannelJoinabilityUtils.INSTANCE, this.this$0.$channelId, null, null, null, null, null, null, 126, null), storeStream$Companion.getGuilds().observeFromChannelId(this.this$0.$channelId), storeStream$Companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), StoreGuildScheduledEvents.observeGuildScheduledEvents$default(storeStream$Companion.getGuildScheduledEvents(), this.$channel.getGuildId(), false, 2, null), storeStream$Companion.getApplication().observeApplications(setKeySet), new CallModel$Companion$get$1$1$3(this, map));
    }
}
