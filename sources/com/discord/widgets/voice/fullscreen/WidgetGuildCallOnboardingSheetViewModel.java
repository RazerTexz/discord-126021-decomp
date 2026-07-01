package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheetViewModel extends AppViewModel<ViewState> {
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private final StoreGuilds guildsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceStates voiceStatesStore;

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetGuildCallOnboardingSheetViewModel widgetGuildCallOnboardingSheetViewModel) {
            super(1, widgetGuildCallOnboardingSheetViewModel, WidgetGuildCallOnboardingSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((WidgetGuildCallOnboardingSheetViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        public static final /* data */ class LaunchGuildCallScreen extends Event {
            private final long channelId;
            private final Long guildId;

            public LaunchGuildCallScreen(long j, Long l) {
                super(null);
                this.channelId = j;
                this.guildId = l;
            }

            public static /* synthetic */ LaunchGuildCallScreen copy$default(LaunchGuildCallScreen launchGuildCallScreen, long j, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchGuildCallScreen.channelId;
                }
                if ((i & 2) != 0) {
                    l = launchGuildCallScreen.guildId;
                }
                return launchGuildCallScreen.copy(j, l);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            public final LaunchGuildCallScreen copy(long channelId, Long guildId) {
                return new LaunchGuildCallScreen(channelId, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchGuildCallScreen)) {
                    return false;
                }
                LaunchGuildCallScreen launchGuildCallScreen = (LaunchGuildCallScreen) other;
                return this.channelId == launchGuildCallScreen.channelId && Intrinsics3.areEqual(this.guildId, launchGuildCallScreen.guildId);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                Long l = this.guildId;
                return iA + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchGuildCallScreen(channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                return outline.G(sbU, this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        public static final class ShowGuildVideoCapacityDialog extends Event {
            public static final ShowGuildVideoCapacityDialog INSTANCE = new ShowGuildVideoCapacityDialog();

            private ShowGuildVideoCapacityDialog() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Long guildId;
        private final VoiceChannelJoinabilityUtils2 voiceChannelJoinability;

        public StoreState(Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
            Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "voiceChannelJoinability");
            this.guildId = l;
            this.voiceChannelJoinability = voiceChannelJoinabilityUtils2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = storeState.guildId;
            }
            if ((i & 2) != 0) {
                voiceChannelJoinabilityUtils2 = storeState.voiceChannelJoinability;
            }
            return storeState.copy(l, voiceChannelJoinabilityUtils2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public final StoreState copy(Long guildId, VoiceChannelJoinabilityUtils2 voiceChannelJoinability) {
            Intrinsics3.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
            return new StoreState(guildId, voiceChannelJoinability);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildId, storeState.guildId) && Intrinsics3.areEqual(this.voiceChannelJoinability, storeState.voiceChannelJoinability);
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public int hashCode() {
            Long l = this.guildId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2 = this.voiceChannelJoinability;
            return iHashCode + (voiceChannelJoinabilityUtils2 != null ? voiceChannelJoinabilityUtils2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildId=");
            sbU.append(this.guildId);
            sbU.append(", voiceChannelJoinability=");
            sbU.append(this.voiceChannelJoinability);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Long guildId;
            private final VoiceChannelJoinabilityUtils2 joinability;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
                super(null);
                Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "joinability");
                this.guildId = l;
                this.joinability = voiceChannelJoinabilityUtils2;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = loaded.guildId;
                }
                if ((i & 2) != 0) {
                    voiceChannelJoinabilityUtils2 = loaded.joinability;
                }
                return loaded.copy(l, voiceChannelJoinabilityUtils2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final VoiceChannelJoinabilityUtils2 getJoinability() {
                return this.joinability;
            }

            public final Loaded copy(Long guildId, VoiceChannelJoinabilityUtils2 joinability) {
                Intrinsics3.checkNotNullParameter(joinability, "joinability");
                return new Loaded(guildId, joinability);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.guildId, loaded.guildId) && Intrinsics3.areEqual(this.joinability, loaded.joinability);
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final VoiceChannelJoinabilityUtils2 getJoinability() {
                return this.joinability;
            }

            public int hashCode() {
                Long l = this.guildId;
                int iHashCode = (l != null ? l.hashCode() : 0) * 31;
                VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2 = this.joinability;
                return iHashCode + (voiceChannelJoinabilityUtils2 != null ? voiceChannelJoinabilityUtils2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guildId=");
                sbU.append(this.guildId);
                sbU.append(", joinability=");
                sbU.append(this.joinability);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VoiceChannelJoinabilityUtils2.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoiceChannelJoinabilityUtils2.CAN_JOIN.ordinal()] = 1;
            iArr[VoiceChannelJoinabilityUtils2.GUILD_VIDEO_AT_CAPACITY.ordinal()] = 2;
            iArr[VoiceChannelJoinabilityUtils2.PERMISSIONS_MISSING.ordinal()] = 3;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_FULL.ordinal()] = 4;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_DOES_NOT_EXIST.ordinal()] = 5;
        }
    }

    public /* synthetic */ WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 4) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        updateViewState(new ViewState.Loaded(storeState.getGuildId(), storeState.getVoiceChannelJoinability()));
    }

    private final Observable<StoreState> observeStoreState() {
        Observable<StoreState> observableJ = Observable.j(this.channelsStore.observeChannel(this.channelId), VoiceChannelJoinabilityUtils.INSTANCE.observeJoinability(this.channelId, (96 & 2) != 0 ? StoreStream.INSTANCE.getChannels() : this.channelsStore, (96 & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : this.guildsStore, (96 & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : this.permissionsStore, (96 & 16) != 0 ? StoreStream.INSTANCE.getVoiceStates() : this.voiceStatesStore, (96 & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : null, (96 & 64) != 0 ? StoreStream.INSTANCE.getStageInstances() : null), new Func2<Channel, VoiceChannelJoinabilityUtils2, StoreState>() { // from class: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel.observeStoreState.1
            @Override // rx.functions.Func2
            public final StoreState call(Channel channel, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
                Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
                Intrinsics3.checkNotNullExpressionValue(voiceChannelJoinabilityUtils2, "joinability");
                return new StoreState(lValueOf, voiceChannelJoinabilityUtils2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…dId, joinability)\n      }");
        return observableJ;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onConnectPressed() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            int iOrdinal = loaded.getJoinability().ordinal();
            if (iOrdinal == 0) {
                this.selectedVoiceChannelStore.selectVoiceChannel(this.channelId);
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(new Event.LaunchGuildCallScreen(this.channelId, loaded.getGuildId()));
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            PublishSubject<Event> publishSubject2 = this.eventSubject;
            publishSubject2.k.onNext(Event.ShowGuildVideoCapacityDialog.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        this.channelId = j;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.voiceStatesStore = storeVoiceStates;
        this.eventSubject = PublishSubject.k0();
        Observable<StoreState> observableR = observeStoreState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) WidgetGuildCallOnboardingSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
