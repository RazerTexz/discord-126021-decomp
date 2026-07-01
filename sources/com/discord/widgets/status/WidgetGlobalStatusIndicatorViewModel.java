package com.discord.widgets.status;

import a0.a.a.b;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel) {
            super(1, widgetGlobalStatusIndicatorViewModel, WidgetGlobalStatusIndicatorViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((WidgetGlobalStatusIndicatorViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final StreamContextService streamContextService, StoreVoiceChannelSelected storeVoiceChannelSelected, final StoreConnectivity storeConnectivity, final StoreChannelsSelected storeChannelsSelected, final StoreRtcConnection storeRtcConnection, final StoreGuilds storeGuilds, final StoreVoiceParticipants storeVoiceParticipants, final StoreStageChannels storeStageChannels, final StoreUserRelationships storeUserRelationships, final StoreStageInstances storeStageInstances, final ObservationDeck observationDeck) {
            return storeVoiceChannelSelected.observeSelectedChannel().Y(new Func1<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1

                /* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
                public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreConnectivity.DelayedState, WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(1, WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState.class, "<init>", "<init>(Lcom/discord/stores/StoreConnectivity$DelayedState;)V", 0);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState invoke(StoreConnectivity.DelayedState delayedState) {
                        Intrinsics3.checkNotNullParameter(delayedState, "p1");
                        return new WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState(delayedState);
                    }
                }

                /* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
                public static final class AnonymousClass2 extends Lambda implements Function0<Integer> {
                    public final /* synthetic */ Channel $channel;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass2(Channel channel) {
                        super(0);
                        this.$channel = channel;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Integer invoke() {
                        return Integer.valueOf(invoke2());
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final int invoke2() {
                        Map<Long, StageRoles> channelRoles = storeStageChannels.getChannelRoles(this.$channel.getId());
                        Map<Long, Integer> relationships = storeUserRelationships.getRelationships();
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Map.Entry<Long, Integer> entry : relationships.entrySet()) {
                            if (entry.getValue().intValue() == 2 && channelRoles != null && channelRoles.containsKey(Long.valueOf(entry.getKey().longValue()))) {
                                linkedHashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        return linkedHashMap.size();
                    }
                }

                /* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$3, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
                public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function10<Channel, Channel, RtcConnection.StateChange, RtcConnection.Quality, Guild, Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, StreamContext, StageRequestToSpeakState, Integer, StageInstance, WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing> {
                    public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

                    public AnonymousClass3() {
                        super(10, WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$StateChange;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/voice/state/StageRequestToSpeakState;ILcom/discord/api/stageinstance/StageInstance;)V", 0);
                    }

                    @Override // kotlin.jvm.functions.Function10
                    public /* bridge */ /* synthetic */ WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing invoke(Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, Integer num, StageInstance stageInstance) {
                        return invoke(channel, channel2, stateChange, quality, guild, (Map<Long, StoreVoiceParticipants.VoiceUser>) map, streamContext, stageRequestToSpeakState, num.intValue(), stageInstance);
                    }

                    public final WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing invoke(Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance) {
                        Intrinsics3.checkNotNullParameter(channel, "p1");
                        Intrinsics3.checkNotNullParameter(stateChange, "p3");
                        Intrinsics3.checkNotNullParameter(quality, "p4");
                        Intrinsics3.checkNotNullParameter(map, "p6");
                        Intrinsics3.checkNotNullParameter(stageRequestToSpeakState, "p8");
                        return new WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing(channel, channel2, stateChange, quality, guild, map, streamContext, stageRequestToSpeakState, i, stageInstance);
                    }
                }

                @Override // j0.k.Func1
                public final Observable<? extends WidgetGlobalStatusIndicatorViewModel.StoreState> call(Channel channel) {
                    Object obj;
                    if (channel != null) {
                        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(channel);
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n                        .just(channel)");
                        return ObservableCombineLatestOverloads2.combineLatest(scalarSynchronousObservable, storeChannelsSelected.observeSelectedChannel(), storeRtcConnection.getConnectionState(), storeRtcConnection.getQuality(), storeGuilds.observeGuild(channel.getGuildId()), storeVoiceParticipants.get(channel.getId()), streamContextService.getForActiveStream(), storeStageChannels.observeMyRequestToSpeakState(channel.getId()), ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeUserRelationships, storeStageChannels}, false, null, null, new AnonymousClass2(channel), 14, null), storeStageInstances.observeStageInstanceForChannel(channel.getId()), AnonymousClass3.INSTANCE);
                    }
                    Observable<StoreConnectivity.DelayedState> observableObserveState = storeConnectivity.observeState();
                    final AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
                    if (anonymousClass1 != null) {
                        obj = anonymousClass1;
                        obj = new Func1() { // from class: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$sam$rx_functions_Func1$0
                            @Override // j0.k.Func1
                            public final /* synthetic */ Object call(Object obj2) {
                                return anonymousClass1.invoke(obj2);
                            }
                        };
                    }
                    obj = anonymousClass1;
                    return observableObserveState.G((Func1) obj);
                }
            });
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StreamContextService streamContextService, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StoreStageChannels storeStageChannels, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances, ObservationDeck observationDeck, int i, Object obj) {
            return companion.observeStoreState(streamContextService, storeVoiceChannelSelected, storeConnectivity, storeChannelsSelected, storeRtcConnection, storeGuilds, storeVoiceParticipants, storeStageChannels, storeUserRelationships, storeStageInstances, (i & 1024) != 0 ? ObservationDeck4.get() : observationDeck);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class CallOngoing extends StoreState {
            private final int blockedUsersOnStage;
            private final RtcConnection.Quality connectionQuality;
            private final RtcConnection.StateChange connectionStateChange;
            private final Guild guild;
            private final Map<Long, StoreVoiceParticipants.VoiceUser> participants;
            private final StageRequestToSpeakState requestToSpeakState;
            private final Channel selectedTextChannel;
            private final Channel selectedVoiceChannel;
            private final StageInstance stageInstance;
            private final StreamContext streamContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallOngoing(Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(stateChange, "connectionStateChange");
                Intrinsics3.checkNotNullParameter(quality, "connectionQuality");
                Intrinsics3.checkNotNullParameter(map, "participants");
                Intrinsics3.checkNotNullParameter(stageRequestToSpeakState, "requestToSpeakState");
                this.selectedVoiceChannel = channel;
                this.selectedTextChannel = channel2;
                this.connectionStateChange = stateChange;
                this.connectionQuality = quality;
                this.guild = guild;
                this.participants = map;
                this.streamContext = streamContext;
                this.requestToSpeakState = stageRequestToSpeakState;
                this.blockedUsersOnStage = i;
                this.stageInstance = stageInstance;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final RtcConnection.StateChange getConnectionStateChange() {
                return this.connectionStateChange;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> component6() {
                return this.participants;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final StageRequestToSpeakState getRequestToSpeakState() {
                return this.requestToSpeakState;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            public final CallOngoing copy(Channel selectedVoiceChannel, Channel selectedTextChannel, RtcConnection.StateChange connectionStateChange, RtcConnection.Quality connectionQuality, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> participants, StreamContext streamContext, StageRequestToSpeakState requestToSpeakState, int blockedUsersOnStage, StageInstance stageInstance) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(connectionStateChange, "connectionStateChange");
                Intrinsics3.checkNotNullParameter(connectionQuality, "connectionQuality");
                Intrinsics3.checkNotNullParameter(participants, "participants");
                Intrinsics3.checkNotNullParameter(requestToSpeakState, "requestToSpeakState");
                return new CallOngoing(selectedVoiceChannel, selectedTextChannel, connectionStateChange, connectionQuality, guild, participants, streamContext, requestToSpeakState, blockedUsersOnStage, stageInstance);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CallOngoing)) {
                    return false;
                }
                CallOngoing callOngoing = (CallOngoing) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, callOngoing.selectedVoiceChannel) && Intrinsics3.areEqual(this.selectedTextChannel, callOngoing.selectedTextChannel) && Intrinsics3.areEqual(this.connectionStateChange, callOngoing.connectionStateChange) && Intrinsics3.areEqual(this.connectionQuality, callOngoing.connectionQuality) && Intrinsics3.areEqual(this.guild, callOngoing.guild) && Intrinsics3.areEqual(this.participants, callOngoing.participants) && Intrinsics3.areEqual(this.streamContext, callOngoing.streamContext) && Intrinsics3.areEqual(this.requestToSpeakState, callOngoing.requestToSpeakState) && this.blockedUsersOnStage == callOngoing.blockedUsersOnStage && Intrinsics3.areEqual(this.stageInstance, callOngoing.stageInstance);
            }

            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            public final RtcConnection.StateChange getConnectionStateChange() {
                return this.connectionStateChange;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> getParticipants() {
                return this.participants;
            }

            public final StageRequestToSpeakState getRequestToSpeakState() {
                return this.requestToSpeakState;
            }

            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.selectedTextChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                RtcConnection.StateChange stateChange = this.connectionStateChange;
                int iHashCode3 = (iHashCode2 + (stateChange != null ? stateChange.hashCode() : 0)) * 31;
                RtcConnection.Quality quality = this.connectionQuality;
                int iHashCode4 = (iHashCode3 + (quality != null ? quality.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode5 = (iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31;
                Map<Long, StoreVoiceParticipants.VoiceUser> map = this.participants;
                int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode7 = (iHashCode6 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                StageRequestToSpeakState stageRequestToSpeakState = this.requestToSpeakState;
                int iHashCode8 = (((iHashCode7 + (stageRequestToSpeakState != null ? stageRequestToSpeakState.hashCode() : 0)) * 31) + this.blockedUsersOnStage) * 31;
                StageInstance stageInstance = this.stageInstance;
                return iHashCode8 + (stageInstance != null ? stageInstance.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("CallOngoing(selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
                sbU.append(", selectedTextChannel=");
                sbU.append(this.selectedTextChannel);
                sbU.append(", connectionStateChange=");
                sbU.append(this.connectionStateChange);
                sbU.append(", connectionQuality=");
                sbU.append(this.connectionQuality);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", participants=");
                sbU.append(this.participants);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(", requestToSpeakState=");
                sbU.append(this.requestToSpeakState);
                sbU.append(", blockedUsersOnStage=");
                sbU.append(this.blockedUsersOnStage);
                sbU.append(", stageInstance=");
                sbU.append(this.stageInstance);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class ConnectivityState extends StoreState {
            private final StoreConnectivity.DelayedState connectivityState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConnectivityState(StoreConnectivity.DelayedState delayedState) {
                super(null);
                Intrinsics3.checkNotNullParameter(delayedState, "connectivityState");
                this.connectivityState = delayedState;
            }

            public static /* synthetic */ ConnectivityState copy$default(ConnectivityState connectivityState, StoreConnectivity.DelayedState delayedState, int i, Object obj) {
                if ((i & 1) != 0) {
                    delayedState = connectivityState.connectivityState;
                }
                return connectivityState.copy(delayedState);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final StoreConnectivity.DelayedState getConnectivityState() {
                return this.connectivityState;
            }

            public final ConnectivityState copy(StoreConnectivity.DelayedState connectivityState) {
                Intrinsics3.checkNotNullParameter(connectivityState, "connectivityState");
                return new ConnectivityState(connectivityState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ConnectivityState) && Intrinsics3.areEqual(this.connectivityState, ((ConnectivityState) other).connectivityState);
                }
                return true;
            }

            public final StoreConnectivity.DelayedState getConnectivityState() {
                return this.connectivityState;
            }

            public int hashCode() {
                StoreConnectivity.DelayedState delayedState = this.connectivityState;
                if (delayedState != null) {
                    return delayedState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ConnectivityState(connectivityState=");
                sbU.append(this.connectivityState);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    public static abstract class ViewState {
        private final boolean isSpeakingInOngoingCall;

        /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class CallOngoing extends ViewState {
            private final RtcConnection.Quality connectionQuality;
            private final RtcConnection.State connectionState;
            private final Guild guild;
            private final boolean hasVideo;
            private final boolean isSpeakingInOngoingCall;
            private final int participants;
            private final Channel selectedTextChannel;
            private final Channel selectedVoiceChannel;
            private final StreamContext streamContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallOngoing(Channel channel, Channel channel2, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, int i, boolean z2, StreamContext streamContext) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(state, "connectionState");
                Intrinsics3.checkNotNullParameter(quality, "connectionQuality");
                this.selectedVoiceChannel = channel;
                this.selectedTextChannel = channel2;
                this.connectionState = state;
                this.connectionQuality = quality;
                this.guild = guild;
                this.participants = i;
                this.hasVideo = z2;
                this.streamContext = streamContext;
                this.isSpeakingInOngoingCall = true;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final int getParticipants() {
                return this.participants;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final CallOngoing copy(Channel selectedVoiceChannel, Channel selectedTextChannel, RtcConnection.State connectionState, RtcConnection.Quality connectionQuality, Guild guild, int participants, boolean hasVideo, StreamContext streamContext) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
                Intrinsics3.checkNotNullParameter(connectionQuality, "connectionQuality");
                return new CallOngoing(selectedVoiceChannel, selectedTextChannel, connectionState, connectionQuality, guild, participants, hasVideo, streamContext);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CallOngoing)) {
                    return false;
                }
                CallOngoing callOngoing = (CallOngoing) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, callOngoing.selectedVoiceChannel) && Intrinsics3.areEqual(this.selectedTextChannel, callOngoing.selectedTextChannel) && Intrinsics3.areEqual(this.connectionState, callOngoing.connectionState) && Intrinsics3.areEqual(this.connectionQuality, callOngoing.connectionQuality) && Intrinsics3.areEqual(this.guild, callOngoing.guild) && this.participants == callOngoing.participants && this.hasVideo == callOngoing.hasVideo && Intrinsics3.areEqual(this.streamContext, callOngoing.streamContext);
            }

            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            public final int getParticipants() {
                return this.participants;
            }

            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r2v14, types: [int] */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r2v21 */
            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.selectedTextChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                RtcConnection.State state = this.connectionState;
                int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
                RtcConnection.Quality quality = this.connectionQuality;
                int iHashCode4 = (iHashCode3 + (quality != null ? quality.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode5 = (((iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31) + this.participants) * 31;
                boolean z2 = this.hasVideo;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode5 + r2) * 31;
                StreamContext streamContext = this.streamContext;
                return i + (streamContext != null ? streamContext.hashCode() : 0);
            }

            @Override // com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel.ViewState
            /* JADX INFO: renamed from: isSpeakingInOngoingCall, reason: from getter */
            public boolean getIsSpeakingInOngoingCall() {
                return this.isSpeakingInOngoingCall;
            }

            public String toString() {
                StringBuilder sbU = outline.U("CallOngoing(selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
                sbU.append(", selectedTextChannel=");
                sbU.append(this.selectedTextChannel);
                sbU.append(", connectionState=");
                sbU.append(this.connectionState);
                sbU.append(", connectionQuality=");
                sbU.append(this.connectionQuality);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", participants=");
                sbU.append(this.participants);
                sbU.append(", hasVideo=");
                sbU.append(this.hasVideo);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class Connecting extends ViewState {
            private final long delay;

            public Connecting(long j) {
                super(null);
                this.delay = j;
            }

            public static /* synthetic */ Connecting copy$default(Connecting connecting, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = connecting.delay;
                }
                return connecting.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getDelay() {
                return this.delay;
            }

            public final Connecting copy(long delay) {
                return new Connecting(delay);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Connecting) && this.delay == ((Connecting) other).delay;
                }
                return true;
            }

            public final long getDelay() {
                return this.delay;
            }

            public int hashCode() {
                return b.a(this.delay);
            }

            public String toString() {
                return outline.C(outline.U("Connecting(delay="), this.delay, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final class Inactive extends ViewState {
            public static final Inactive INSTANCE = new Inactive();

            private Inactive() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class Offline extends ViewState {
            private final boolean airplaneMode;
            private final long delay;

            public Offline(long j, boolean z2) {
                super(null);
                this.delay = j;
                this.airplaneMode = z2;
            }

            public static /* synthetic */ Offline copy$default(Offline offline, long j, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = offline.delay;
                }
                if ((i & 2) != 0) {
                    z2 = offline.airplaneMode;
                }
                return offline.copy(j, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getDelay() {
                return this.delay;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getAirplaneMode() {
                return this.airplaneMode;
            }

            public final Offline copy(long delay, boolean airplaneMode) {
                return new Offline(delay, airplaneMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Offline)) {
                    return false;
                }
                Offline offline = (Offline) other;
                return this.delay == offline.delay && this.airplaneMode == offline.airplaneMode;
            }

            public final boolean getAirplaneMode() {
                return this.airplaneMode;
            }

            public final long getDelay() {
                return this.delay;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iA = b.a(this.delay) * 31;
                boolean z2 = this.airplaneMode;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iA + r1;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Offline(delay=");
                sbU.append(this.delay);
                sbU.append(", airplaneMode=");
                return outline.O(sbU, this.airplaneMode, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class StageChannelOngoing extends ViewState {
            private final int blockedUsersOnStage;
            private final RtcConnection.Quality connectionQuality;
            private final RtcConnection.State connectionState;
            private final Guild guild;
            private final boolean isAckingInvitation;
            private final boolean isInvitedToSpeak;
            private final boolean isSpeaking;
            private final boolean isSpeakingInOngoingCall;
            private final Channel selectedVoiceChannel;
            private final StageInstance stageInstance;
            private final StreamContext streamContext;

            public /* synthetic */ StageChannelOngoing(Channel channel, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, state, quality, guild, streamContext, z2, stageInstance, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? 0 : i);
            }

            public static /* synthetic */ StageChannelOngoing copy$default(StageChannelOngoing stageChannelOngoing, Channel channel, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i, int i2, Object obj) {
                return stageChannelOngoing.copy((i2 & 1) != 0 ? stageChannelOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? stageChannelOngoing.connectionState : state, (i2 & 4) != 0 ? stageChannelOngoing.connectionQuality : quality, (i2 & 8) != 0 ? stageChannelOngoing.guild : guild, (i2 & 16) != 0 ? stageChannelOngoing.streamContext : streamContext, (i2 & 32) != 0 ? stageChannelOngoing.isSpeaking : z2, (i2 & 64) != 0 ? stageChannelOngoing.stageInstance : stageInstance, (i2 & 128) != 0 ? stageChannelOngoing.isInvitedToSpeak : z3, (i2 & 256) != 0 ? stageChannelOngoing.isAckingInvitation : z4, (i2 & 512) != 0 ? stageChannelOngoing.blockedUsersOnStage : i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsSpeaking() {
                return this.isSpeaking;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getIsInvitedToSpeak() {
                return this.isInvitedToSpeak;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final boolean getIsAckingInvitation() {
                return this.isAckingInvitation;
            }

            public final StageChannelOngoing copy(Channel selectedVoiceChannel, RtcConnection.State connectionState, RtcConnection.Quality connectionQuality, Guild guild, StreamContext streamContext, boolean isSpeaking, StageInstance stageInstance, boolean isInvitedToSpeak, boolean isAckingInvitation, int blockedUsersOnStage) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
                Intrinsics3.checkNotNullParameter(connectionQuality, "connectionQuality");
                return new StageChannelOngoing(selectedVoiceChannel, connectionState, connectionQuality, guild, streamContext, isSpeaking, stageInstance, isInvitedToSpeak, isAckingInvitation, blockedUsersOnStage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StageChannelOngoing)) {
                    return false;
                }
                StageChannelOngoing stageChannelOngoing = (StageChannelOngoing) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, stageChannelOngoing.selectedVoiceChannel) && Intrinsics3.areEqual(this.connectionState, stageChannelOngoing.connectionState) && Intrinsics3.areEqual(this.connectionQuality, stageChannelOngoing.connectionQuality) && Intrinsics3.areEqual(this.guild, stageChannelOngoing.guild) && Intrinsics3.areEqual(this.streamContext, stageChannelOngoing.streamContext) && this.isSpeaking == stageChannelOngoing.isSpeaking && Intrinsics3.areEqual(this.stageInstance, stageChannelOngoing.stageInstance) && this.isInvitedToSpeak == stageChannelOngoing.isInvitedToSpeak && this.isAckingInvitation == stageChannelOngoing.isAckingInvitation && this.blockedUsersOnStage == stageChannelOngoing.blockedUsersOnStage;
            }

            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r0v16, types: [int] */
            /* JADX WARN: Type inference failed for: r0v18, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v13, types: [int] */
            /* JADX WARN: Type inference failed for: r2v15 */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                RtcConnection.State state = this.connectionState;
                int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
                RtcConnection.Quality quality = this.connectionQuality;
                int iHashCode3 = (iHashCode2 + (quality != null ? quality.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode5 = (iHashCode4 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                boolean z2 = this.isSpeaking;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode5 + r2) * 31;
                StageInstance stageInstance = this.stageInstance;
                int iHashCode6 = (i + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
                boolean z3 = this.isInvitedToSpeak;
                ?? r1 = z3;
                if (z3) {
                    r1 = 1;
                }
                int i2 = (iHashCode6 + r1) * 31;
                boolean z4 = this.isAckingInvitation;
                return ((i2 + (z4 ? 1 : z4)) * 31) + this.blockedUsersOnStage;
            }

            public final boolean isAckingInvitation() {
                return this.isAckingInvitation;
            }

            public final boolean isInvitedToSpeak() {
                return this.isInvitedToSpeak;
            }

            public final boolean isSpeaking() {
                return this.isSpeaking;
            }

            @Override // com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel.ViewState
            /* JADX INFO: renamed from: isSpeakingInOngoingCall, reason: from getter */
            public boolean getIsSpeakingInOngoingCall() {
                return this.isSpeakingInOngoingCall;
            }

            public String toString() {
                StringBuilder sbU = outline.U("StageChannelOngoing(selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
                sbU.append(", connectionState=");
                sbU.append(this.connectionState);
                sbU.append(", connectionQuality=");
                sbU.append(this.connectionQuality);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(", isSpeaking=");
                sbU.append(this.isSpeaking);
                sbU.append(", stageInstance=");
                sbU.append(this.stageInstance);
                sbU.append(", isInvitedToSpeak=");
                sbU.append(this.isInvitedToSpeak);
                sbU.append(", isAckingInvitation=");
                sbU.append(this.isAckingInvitation);
                sbU.append(", blockedUsersOnStage=");
                return outline.B(sbU, this.blockedUsersOnStage, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StageChannelOngoing(Channel channel, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(state, "connectionState");
                Intrinsics3.checkNotNullParameter(quality, "connectionQuality");
                this.selectedVoiceChannel = channel;
                this.connectionState = state;
                this.connectionQuality = quality;
                this.guild = guild;
                this.streamContext = streamContext;
                this.isSpeaking = z2;
                this.stageInstance = stageInstance;
                this.isInvitedToSpeak = z3;
                this.isAckingInvitation = z4;
                this.blockedUsersOnStage = i;
                this.isSpeakingInOngoingCall = z2 || z3;
            }
        }

        private ViewState() {
        }

        /* JADX INFO: renamed from: isSpeakingInOngoingCall, reason: from getter */
        public boolean getIsSpeakingInOngoingCall() {
            return this.isSpeakingInOngoingCall;
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreConnectivity.State.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreConnectivity.State.ONLINE.ordinal()] = 1;
            iArr[StoreConnectivity.State.CONNECTING.ordinal()] = 2;
            iArr[StoreConnectivity.State.OFFLINE.ordinal()] = 3;
            iArr[StoreConnectivity.State.OFFLINE_AIRPLANE_MODE.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$ackStageInvitationToSpeak$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ boolean $accept;
        public final /* synthetic */ ViewState.StageChannelOngoing $stageState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, ViewState.StageChannelOngoing stageChannelOngoing) {
            super(1);
            this.$accept = z2;
            this.$stageState = stageChannelOngoing;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r14) {
            if (this.$accept) {
                AnalyticsTracker.INSTANCE.promotedToSpeaker(this.$stageState.getSelectedVoiceChannel().getId());
            }
            ViewState viewStateAccess$getViewState$p = WidgetGlobalStatusIndicatorViewModel.access$getViewState$p(WidgetGlobalStatusIndicatorViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.StageChannelOngoing)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.StageChannelOngoing stageChannelOngoing = (ViewState.StageChannelOngoing) viewStateAccess$getViewState$p;
            if (stageChannelOngoing != null) {
                WidgetGlobalStatusIndicatorViewModel.this.updateViewState(ViewState.StageChannelOngoing.copy$default(stageChannelOngoing, null, null, null, null, null, false, null, false, false, 0, 767, null));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGlobalStatusIndicatorViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ WidgetGlobalStatusIndicatorViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState$default;
        if ((i & 1) != 0) {
            Companion companion = INSTANCE;
            StreamContextService streamContextService = new StreamContextService(null, null, null, null, null, null, null, null, 255, null);
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState$default = Companion.observeStoreState$default(companion, streamContextService, companion2.getVoiceChannelSelected(), companion2.getConnectivity(), companion2.getChannelsSelected(), companion2.getRtcConnection(), companion2.getGuilds(), companion2.getVoiceParticipants(), companion2.getStageChannels(), companion2.getUserRelationships(), companion2.getStageInstances(), null, 1024, null);
            Intrinsics3.checkNotNullExpressionValue(observableObserveStoreState$default, "observeStoreState(\n     ….getStageInstances(),\n  )");
        } else {
            observableObserveStoreState$default = observable;
        }
        this(observableObserveStoreState$default);
    }

    public static final /* synthetic */ ViewState access$getViewState$p(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel) {
        return widgetGlobalStatusIndicatorViewModel.getViewState();
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        if (storeState instanceof StoreState.ConnectivityState) {
            StoreState.ConnectivityState connectivityState = (StoreState.ConnectivityState) storeState;
            int iOrdinal = connectivityState.getConnectivityState().getState().ordinal();
            if (iOrdinal == 0) {
                updateViewState(ViewState.Inactive.INSTANCE);
                return;
            }
            if (iOrdinal == 1) {
                updateViewState(new ViewState.Offline(connectivityState.getConnectivityState().getDelay(), false));
                return;
            } else if (iOrdinal == 2) {
                updateViewState(new ViewState.Offline(connectivityState.getConnectivityState().getDelay(), true));
                return;
            } else {
                if (iOrdinal != 3) {
                    return;
                }
                updateViewState(new ViewState.Connecting(connectivityState.getConnectivityState().getDelay()));
                return;
            }
        }
        if (storeState instanceof StoreState.CallOngoing) {
            StoreState.CallOngoing callOngoing = (StoreState.CallOngoing) storeState;
            if (!ChannelUtils.D(callOngoing.getSelectedVoiceChannel())) {
                int size = callOngoing.getParticipants().size();
                Collection<StoreVoiceParticipants.VoiceUser> collectionValues = callOngoing.getParticipants().values();
                if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                    z2 = false;
                } else {
                    Iterator<T> it = collectionValues.iterator();
                    while (it.hasNext()) {
                        VoiceState voiceState = ((StoreVoiceParticipants.VoiceUser) it.next()).getVoiceState();
                        if (voiceState != null && voiceState.getSelfVideo()) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                }
                updateViewState(new ViewState.CallOngoing(callOngoing.getSelectedVoiceChannel(), callOngoing.getSelectedTextChannel(), callOngoing.getConnectionStateChange().state, callOngoing.getConnectionQuality(), callOngoing.getGuild(), size, z2, callOngoing.getStreamContext()));
                return;
            }
            boolean z3 = callOngoing.getRequestToSpeakState() == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK;
            boolean z4 = callOngoing.getRequestToSpeakState() == StageRequestToSpeakState.ON_STAGE;
            ViewState viewState = getViewState();
            if (!(viewState instanceof ViewState.StageChannelOngoing)) {
                viewState = null;
            }
            ViewState.StageChannelOngoing stageChannelOngoing = (ViewState.StageChannelOngoing) viewState;
            if (stageChannelOngoing != null && !stageChannelOngoing.isInvitedToSpeak() && z3) {
                AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_RECONNECT());
            }
            updateViewState(new ViewState.StageChannelOngoing(callOngoing.getSelectedVoiceChannel(), callOngoing.getConnectionStateChange().state, callOngoing.getConnectionQuality(), callOngoing.getGuild(), callOngoing.getStreamContext(), z4, callOngoing.getStageInstance(), z3, false, callOngoing.getBlockedUsersOnStage(), 256, null));
        }
    }

    public final void ackStageInvitationToSpeak(boolean accept) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.StageChannelOngoing)) {
            viewState = null;
        }
        ViewState.StageChannelOngoing stageChannelOngoing = (ViewState.StageChannelOngoing) viewState;
        if (stageChannelOngoing != null) {
            updateViewState(ViewState.StageChannelOngoing.copy$default(stageChannelOngoing, null, null, null, null, null, false, null, false, true, 0, 767, null));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.INSTANCE.ackInvitationToSpeak(stageChannelOngoing.getSelectedVoiceChannel(), accept), false, 1, null), this, null, 2, null), (Class<?>) WidgetGlobalStatusIndicatorViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(accept, stageChannelOngoing));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel(Observable<StoreState> observable) {
        super(ViewState.Inactive.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) WidgetGlobalStatusIndicatorViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
