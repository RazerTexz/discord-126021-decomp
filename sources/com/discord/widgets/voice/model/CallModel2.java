package com.discord.widgets.voice.model;

import androidx.core.app.NotificationCompat;
import co.discord.media_engine.DeviceDescription4;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function10;
import rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.voice.model.CallModel$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallModel2<T, R> implements Func1<Channel, Observable<? extends CallModel>> {
    public final /* synthetic */ long $channelId;

    public CallModel2(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.Func1
    public final Observable<? extends CallModel> call(final Channel channel) {
        return channel == null ? new ScalarSynchronousObservable(null) : StoreStream.INSTANCE.getEmbeddedActivities().observeEmbeddedActivitiesForChannel(this.$channelId).Y(new Func1<Map<Long, ? extends EmbeddedActivity>, Observable<? extends CallModel>>() { // from class: com.discord.widgets.voice.model.CallModel$Companion$get$1.1

            /* JADX INFO: renamed from: com.discord.widgets.voice.model.CallModel$Companion$get$1$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: CallModel.kt */
            public static final class AnonymousClass3 extends Lambda implements Function10<CallModel.Companion.Chunk, StoreApplicationStreaming.ActiveApplicationStream, RtcConnection.Metadata, Integer, Integer, VoiceChannelJoinabilityUtils2, Guild, Long, List<? extends GuildScheduledEvent>, Map<Long, ? extends Application>, CallModel> {
                public final /* synthetic */ Map $embeddedActivities;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(Map map) {
                    super(10);
                    this.$embeddedActivities = map;
                }

                @Override // kotlin.jvm.functions.Function10
                public /* bridge */ /* synthetic */ CallModel invoke(CallModel.Companion.Chunk chunk, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection.Metadata metadata, Integer num, Integer num2, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, Guild guild, Long l, List<? extends GuildScheduledEvent> list, Map<Long, ? extends Application> map) {
                    return invoke(chunk, activeApplicationStream, metadata, num, num2, voiceChannelJoinabilityUtils2, guild, l.longValue(), (List<GuildScheduledEvent>) list, (Map<Long, Application>) map);
                }

                /* JADX WARN: Code duplicated, block: B:17:0x00a4  */
                /* JADX WARN: Code duplicated, block: B:23:0x00a7 A[SYNTHETIC] */
                public final CallModel invoke(CallModel.Companion.Chunk chunk, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection.Metadata metadata, Integer num, Integer num2, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, Guild guild, long j, List<GuildScheduledEvent> list, Map<Long, Application> map) {
                    Iterator<T> it;
                    boolean z2;
                    Intrinsics3.checkNotNullParameter(chunk, "chunk");
                    Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "voiceChannelJoinability");
                    Intrinsics3.checkNotNullParameter(list, "guildScheduledEvents");
                    Intrinsics3.checkNotNullParameter(map, "applications");
                    CallModel.Companion companion = CallModel.INSTANCE;
                    Channel channel = channel;
                    long myUserId = chunk.getMyUserId();
                    long timeConnectedMs = chunk.getTimeConnectedMs();
                    StoreMediaSettings.VoiceConfiguration voiceConfig = chunk.getVoiceConfig();
                    Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants = chunk.getVoiceParticipants();
                    Long channelPermissions = chunk.getChannelPermissions();
                    List<DeviceDescription4> videoDevices = chunk.getVideoDevices();
                    boolean z3 = channel.getId() == j;
                    DeviceDescription4 selectedVideoDevice = chunk.getSelectedVideoDevice();
                    Intrinsics3.checkNotNullExpressionValue(num, "callFeedbackTriggerRateDenominator");
                    int iIntValue = num.intValue();
                    Intrinsics3.checkNotNullExpressionValue(num2, "streamFeedbackTriggerRateDenominator");
                    int iIntValue2 = num2.intValue();
                    StoreAudioManagerV2.State audioManagerState = chunk.getAudioManagerState();
                    ArrayList arrayList = new ArrayList();
                    for (Iterator<T> it2 = list.iterator(); it2.hasNext(); it2 = it) {
                        T next = it2.next();
                        Long channelId = ((GuildScheduledEvent) next).getChannelId();
                        if (channelId == null) {
                            it = it2;
                        } else {
                            it = it2;
                            z2 = channelId.longValue() == CallModel2.this.$channelId;
                            if (z2) {
                                arrayList.add(next);
                            }
                        }
                        if (z2) {
                            arrayList.add(next);
                        }
                    }
                    Map map2 = this.$embeddedActivities;
                    Intrinsics3.checkNotNullExpressionValue(map2, "embeddedActivities");
                    return companion.create(channel, guild, myUserId, timeConnectedMs, voiceConfig, voiceParticipants, channelPermissions, videoDevices, z3, selectedVideoDevice, activeApplicationStream, metadata, iIntValue, iIntValue2, audioManagerState, voiceChannelJoinabilityUtils2, arrayList, map2, map);
                }
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends CallModel> call(Map<Long, ? extends EmbeddedActivity> map) {
                return call2((Map<Long, EmbeddedActivity>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends CallModel> call2(Map<Long, EmbeddedActivity> map) {
                Set<Long> setKeySet = map.keySet();
                Observable observableObserveChunk = CallModel.INSTANCE.observeChunk(channel);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<StoreApplicationStreaming.ActiveApplicationStream> observableObserveActiveStream = companion.getApplicationStreaming().observeActiveStream();
                Observable<RtcConnection.Metadata> observableObserveRtcConnectionMetadata = companion.getRtcConnection().observeRtcConnectionMetadata();
                Observable<R> observableG = companion.getExperiments().observeUserExperiment("2019-12_android_call_feedback_sheet_sample_rate_denominator", true).G(new Func1<Experiment, Integer>() { // from class: com.discord.widgets.voice.model.CallModel.Companion.get.1.1.1
                    @Override // j0.k.Func1
                    public final Integer call(Experiment experiment) {
                        return Integer.valueOf(experiment != null ? experiment.getBucket() : 0);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n            …experiment?.bucket ?: 0 }");
                Observable<R> observableG2 = companion.getExperiments().observeUserExperiment("2020-09_stream_feedback_sheet_sample_rate_denominator", true).G(new Func1<Experiment, Integer>() { // from class: com.discord.widgets.voice.model.CallModel.Companion.get.1.1.2
                    @Override // j0.k.Func1
                    public final Integer call(Experiment experiment) {
                        return Integer.valueOf(experiment != null ? experiment.getBucket() : 0);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableG2, "StoreStream\n            …experiment?.bucket ?: 0 }");
                return ObservableCombineLatestOverloads2.combineLatest(observableObserveChunk, observableObserveActiveStream, observableObserveRtcConnectionMetadata, observableG, observableG2, VoiceChannelJoinabilityUtils.INSTANCE.observeJoinability(CallModel2.this.$channelId, (96 & 2) != 0 ? StoreStream.INSTANCE.getChannels() : null, (96 & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : null, (96 & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : null, (96 & 16) != 0 ? StoreStream.INSTANCE.getVoiceStates() : null, (96 & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : null, (96 & 64) != 0 ? StoreStream.INSTANCE.getStageInstances() : null), companion.getGuilds().observeFromChannelId(CallModel2.this.$channelId), companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), StoreGuildScheduledEvents.observeGuildScheduledEvents$default(companion.getGuildScheduledEvents(), channel.getGuildId(), false, 2, null), companion.getApplication().observeApplications(setKeySet), new AnonymousClass3(map));
            }
        });
    }
}
