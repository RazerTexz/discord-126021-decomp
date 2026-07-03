package com.discord.widgets.voice.fullscreen;

import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheetViewModel extends AbstractC0859d0<ViewState> {
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private final StoreGuilds guildsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceStates voiceStatesStore;

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel$1 */
    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static final /* synthetic */ class C105511 extends C12236k implements Function1<StoreState, Unit> {
        public C105511(WidgetGuildCallOnboardingSheetViewModel widgetGuildCallOnboardingSheetViewModel) {
            super(1, widgetGuildCallOnboardingSheetViewModel, WidgetGuildCallOnboardingSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
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
                return this.channelId == launchGuildCallScreen.channelId && C12238m.areEqual(this.guildId, launchGuildCallScreen.guildId);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                int iM3a = C0002b.m3a(this.channelId) * 31;
                Long l = this.guildId;
                return iM3a + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("LaunchGuildCallScreen(channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", guildId=");
                return C1643a.m819G(sbM833U, this.guildId, ")");
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
        private final VoiceChannelJoinability voiceChannelJoinability;

        public StoreState(Long l, VoiceChannelJoinability voiceChannelJoinability) {
            C12238m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
            this.guildId = l;
            this.voiceChannelJoinability = voiceChannelJoinability;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Long l, VoiceChannelJoinability voiceChannelJoinability, int i, Object obj) {
            if ((i & 1) != 0) {
                l = storeState.guildId;
            }
            if ((i & 2) != 0) {
                voiceChannelJoinability = storeState.voiceChannelJoinability;
            }
            return storeState.copy(l, voiceChannelJoinability);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final VoiceChannelJoinability getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public final StoreState copy(Long guildId, VoiceChannelJoinability voiceChannelJoinability) {
            C12238m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
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
            return C12238m.areEqual(this.guildId, storeState.guildId) && C12238m.areEqual(this.voiceChannelJoinability, storeState.voiceChannelJoinability);
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final VoiceChannelJoinability getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public int hashCode() {
            Long l = this.guildId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            VoiceChannelJoinability voiceChannelJoinability = this.voiceChannelJoinability;
            return iHashCode + (voiceChannelJoinability != null ? voiceChannelJoinability.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", voiceChannelJoinability=");
            sbM833U.append(this.voiceChannelJoinability);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Long guildId;
            private final VoiceChannelJoinability joinability;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Long l, VoiceChannelJoinability voiceChannelJoinability) {
                super(null);
                C12238m.checkNotNullParameter(voiceChannelJoinability, "joinability");
                this.guildId = l;
                this.joinability = voiceChannelJoinability;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Long l, VoiceChannelJoinability voiceChannelJoinability, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = loaded.guildId;
                }
                if ((i & 2) != 0) {
                    voiceChannelJoinability = loaded.joinability;
                }
                return loaded.copy(l, voiceChannelJoinability);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final VoiceChannelJoinability getJoinability() {
                return this.joinability;
            }

            public final Loaded copy(Long guildId, VoiceChannelJoinability joinability) {
                C12238m.checkNotNullParameter(joinability, "joinability");
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
                return C12238m.areEqual(this.guildId, loaded.guildId) && C12238m.areEqual(this.joinability, loaded.joinability);
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final VoiceChannelJoinability getJoinability() {
                return this.joinability;
            }

            public int hashCode() {
                Long l = this.guildId;
                int iHashCode = (l != null ? l.hashCode() : 0) * 31;
                VoiceChannelJoinability voiceChannelJoinability = this.joinability;
                return iHashCode + (voiceChannelJoinability != null ? voiceChannelJoinability.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", joinability=");
                sbM833U.append(this.joinability);
                sbM833U.append(")");
                return sbM833U.toString();
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
            VoiceChannelJoinability.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoiceChannelJoinability.CAN_JOIN.ordinal()] = 1;
            iArr[VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY.ordinal()] = 2;
            iArr[VoiceChannelJoinability.PERMISSIONS_MISSING.ordinal()] = 3;
            iArr[VoiceChannelJoinability.CHANNEL_FULL.ordinal()] = 4;
            iArr[VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST.ordinal()] = 5;
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
        Observable<StoreState> observableM11076j = Observable.m11076j(this.channelsStore.observeChannel(this.channelId), VoiceChannelJoinabilityUtils.INSTANCE.observeJoinability(this.channelId, (96 & 2) != 0 ? StoreStream.INSTANCE.getChannels() : this.channelsStore, (96 & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : this.guildsStore, (96 & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : this.permissionsStore, (96 & 16) != 0 ? StoreStream.INSTANCE.getVoiceStates() : this.voiceStatesStore, (96 & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : null, (96 & 64) != 0 ? StoreStream.INSTANCE.getStageInstances() : null), new Func2<Channel, VoiceChannelJoinability, StoreState>() { // from class: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel.observeStoreState.1
            @Override // p658rx.functions.Func2
            public final StoreState call(Channel channel, VoiceChannelJoinability voiceChannelJoinability) {
                Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
                C12238m.checkNotNullExpressionValue(voiceChannelJoinability, "joinability");
                return new StoreState(lValueOf, voiceChannelJoinability);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…dId, joinability)\n      }");
        return observableM11076j;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
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
                publishSubject.f27650k.onNext(new Event.LaunchGuildCallScreen(this.channelId, loaded.getGuildId()));
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            PublishSubject<Event> publishSubject2 = this.eventSubject;
            publishSubject2.f27650k.onNext(Event.ShowGuildVideoCapacityDialog.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates) {
        super(ViewState.Uninitialized.INSTANCE);
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        C12238m.checkNotNullParameter(storePermissions, "permissionsStore");
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        this.channelId = j;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.voiceStatesStore = storeVoiceStates;
        this.eventSubject = PublishSubject.m11133k0();
        Observable<StoreState> observableM11112r = observeStoreState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), (Class<?>) WidgetGuildCallOnboardingSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105511(this));
    }
}
