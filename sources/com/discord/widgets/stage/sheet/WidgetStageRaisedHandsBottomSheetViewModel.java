package com.discord.widgets.stage.sheet;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.restapi.RestAPIParams$ChannelPermissionOverwrites;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.m;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel extends d0<WidgetStageRaisedHandsBottomSheetViewModel$ViewState> {
    public static final WidgetStageRaisedHandsBottomSheetViewModel$Companion Companion = new WidgetStageRaisedHandsBottomSheetViewModel$Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<WidgetStageRaisedHandsBottomSheetViewModel$Event> eventSubject;
    private Subscription lastRequestToSpeakSubscription;
    private final StoreUser usersStore;
    private final StoreVoiceParticipants voiceParticipants;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel(long j, StoreVoiceParticipants storeVoiceParticipants, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreStageChannels storeStageChannels, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreVoiceParticipants voiceParticipants = (i & 2) != 0 ? StoreStream.Companion.getVoiceParticipants() : storeVoiceParticipants;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreUser users = (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreStageChannels stageChannels = (i & 32) != 0 ? StoreStream.Companion.getStageChannels() : storeStageChannels;
        Clock clock2 = (i & 64) != 0 ? ClockFactory.get() : clock;
        this(j, voiceParticipants, channels, users, guilds, stageChannels, clock2, (i & 128) != 0 ? WidgetStageRaisedHandsBottomSheetViewModel$Companion.access$observeStoreState(Companion, j, voiceParticipants, channels, guilds, stageChannels, clock2) : observable);
    }

    public static final /* synthetic */ void access$emitError(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel, Error error) {
        widgetStageRaisedHandsBottomSheetViewModel.emitError(error);
    }

    public static final /* synthetic */ Subscription access$getLastRequestToSpeakSubscription$p(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
        return widgetStageRaisedHandsBottomSheetViewModel.lastRequestToSpeakSubscription;
    }

    public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$ViewState access$getViewState$p(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
        return widgetStageRaisedHandsBottomSheetViewModel.getViewState();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel$StoreState widgetStageRaisedHandsBottomSheetViewModel$StoreState) {
        widgetStageRaisedHandsBottomSheetViewModel.handleStoreState(widgetStageRaisedHandsBottomSheetViewModel$StoreState);
    }

    public static final /* synthetic */ void access$setLastRequestToSpeakSubscription$p(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel, Subscription subscription) {
        widgetStageRaisedHandsBottomSheetViewModel.lastRequestToSpeakSubscription = subscription;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel$ViewState widgetStageRaisedHandsBottomSheetViewModel$ViewState) {
        widgetStageRaisedHandsBottomSheetViewModel.updateViewState(widgetStageRaisedHandsBottomSheetViewModel$ViewState);
    }

    private final void emitDismiss() {
        PublishSubject<WidgetStageRaisedHandsBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetStageRaisedHandsBottomSheetViewModel$Event$Dismiss.INSTANCE);
    }

    private final void emitError(Error error) {
        PublishSubject<WidgetStageRaisedHandsBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetStageRaisedHandsBottomSheetViewModel$Event$Error(error));
    }

    @MainThread
    private final void handleStoreState(WidgetStageRaisedHandsBottomSheetViewModel$StoreState storeState) {
        updateViewState(new WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded(storeState.getChannel(), storeState.getRaisedHandsParticipants(), PermissionUtils.INSTANCE.canEveryoneRole(Permission.REQUEST_TO_SPEAK, storeState.getChannel(), storeState.getRoles()), StageRoles.m33isSpeakerimpl(storeState.m50getMyStageRoles1LxfuJo()), false, false, 48, null));
    }

    private final Observable<Void> setUserSuppressed(long userId, boolean isSuppressed) {
        Observable<R> observableG = this.channelsStore.observeChannel(this.channelId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableA = observableG.z().A(new WidgetStageRaisedHandsBottomSheetViewModel$setUserSuppressed$1(userId, isSuppressed));
        m.checkNotNullExpressionValue(observableA, "channelSingle\n        .f…stSubscribeOn()\n        }");
        return ObservableExtensionsKt.ui$default(observableA, this, null, 2, null);
    }

    public final void dismissRequestToSpeak(StoreVoiceParticipants$VoiceUser participant) {
        m.checkNotNullParameter(participant, "participant");
        ObservableExtensionsKt.appSubscribe$default(setUserSuppressed(participant.getUser().getId(), true), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetStageRaisedHandsBottomSheetViewModel$dismissRequestToSpeak$1.INSTANCE, 62, (Object) null);
    }

    public final void inviteToSpeak(StoreVoiceParticipants$VoiceUser participant) {
        m.checkNotNullParameter(participant, "participant");
        ObservableExtensionsKt.appSubscribe$default(setUserSuppressed(participant.getUser().getId(), false), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, (Function1) null, new WidgetStageRaisedHandsBottomSheetViewModel$inviteToSpeak$1(this), (Function0) null, (Function0) null, WidgetStageRaisedHandsBottomSheetViewModel$inviteToSpeak$2.INSTANCE, 54, (Object) null);
    }

    public final Observable<WidgetStageRaisedHandsBottomSheetViewModel$Event> observeEvents() {
        PublishSubject<WidgetStageRaisedHandsBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void setRequestToSpeakEnabled(boolean isEnabled) {
        WidgetStageRaisedHandsBottomSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded = (WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded) viewState;
        if (widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.copy$default(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded, null, null, false, false, true, false, 47, null));
            Pair<Long, Long> pairComputeAllowDenyUpdateBits = PermissionOverwriteUtilsKt.computeAllowDenyUpdateBits(ChannelUtils.f(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.getChannel(), widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.getChannel().getGuildId()), Permission.REQUEST_TO_SPEAK, isEnabled);
            long jLongValue = pairComputeAllowDenyUpdateBits.component1().longValue();
            long jLongValue2 = pairComputeAllowDenyUpdateBits.component2().longValue();
            Subscription subscription = this.lastRequestToSpeakSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updatePermissionOverwrites(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.getChannel().getId(), widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.getChannel().getGuildId(), RestAPIParams$ChannelPermissionOverwrites.Companion.createForRole(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.getChannel().getGuildId(), Long.valueOf(jLongValue), Long.valueOf(jLongValue2))), false, 1, null), this, null, 2, null), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, new WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$1(this), new WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$2(this), (Function0) null, (Function0) null, new WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$3(this, isEnabled), 50, (Object) null);
        }
    }

    public final void setSpeakingState(boolean isSuppressed) {
        WidgetStageRaisedHandsBottomSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded = (WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded) viewState;
        if (widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.copy$default(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded, null, null, false, false, false, true, 31, null));
            ObservableExtensionsKt.appSubscribe$default(setUserSuppressed(this.usersStore.getMeSnapshot().getId(), isSuppressed), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, (Function1) null, new WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$1(this), (Function0) null, new WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$2(this), WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$3.INSTANCE, 22, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetViewModel(long j, StoreVoiceParticipants storeVoiceParticipants, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreStageChannels storeStageChannels, Clock clock, Observable<WidgetStageRaisedHandsBottomSheetViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeVoiceParticipants, "voiceParticipants");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeUser, "usersStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.voiceParticipants = storeVoiceParticipants;
        this.channelsStore = storeChannels;
        this.usersStore = storeUser;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageRaisedHandsBottomSheetViewModel$1(this), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}
