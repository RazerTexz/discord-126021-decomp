package com.discord.widgets.status;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager$Provider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.stage.StageChannelAPI;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel extends d0<WidgetGlobalStatusIndicatorViewModel$ViewState> {
    public static final WidgetGlobalStatusIndicatorViewModel$Companion Companion = new WidgetGlobalStatusIndicatorViewModel$Companion(null);

    public WidgetGlobalStatusIndicatorViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetGlobalStatusIndicatorViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState$default;
        if ((i & 1) != 0) {
            WidgetGlobalStatusIndicatorViewModel$Companion widgetGlobalStatusIndicatorViewModel$Companion = Companion;
            StreamContextService streamContextService = new StreamContextService(null, null, null, null, null, null, null, null, 255, null);
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableObserveStoreState$default = WidgetGlobalStatusIndicatorViewModel$Companion.observeStoreState$default(widgetGlobalStatusIndicatorViewModel$Companion, streamContextService, storeStream$Companion.getVoiceChannelSelected(), storeStream$Companion.getConnectivity(), storeStream$Companion.getChannelsSelected(), storeStream$Companion.getRtcConnection(), storeStream$Companion.getGuilds(), storeStream$Companion.getVoiceParticipants(), storeStream$Companion.getStageChannels(), storeStream$Companion.getUserRelationships(), storeStream$Companion.getStageInstances(), null, 1024, null);
            m.checkNotNullExpressionValue(observableObserveStoreState$default, "observeStoreState(\n     ….getStageInstances(),\n  )");
        } else {
            observableObserveStoreState$default = observable;
        }
        this(observableObserveStoreState$default);
    }

    public static final /* synthetic */ WidgetGlobalStatusIndicatorViewModel$ViewState access$getViewState$p(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel) {
        return widgetGlobalStatusIndicatorViewModel.getViewState();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel, WidgetGlobalStatusIndicatorViewModel$StoreState widgetGlobalStatusIndicatorViewModel$StoreState) {
        widgetGlobalStatusIndicatorViewModel.handleStoreState(widgetGlobalStatusIndicatorViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel, WidgetGlobalStatusIndicatorViewModel$ViewState widgetGlobalStatusIndicatorViewModel$ViewState) {
        widgetGlobalStatusIndicatorViewModel.updateViewState(widgetGlobalStatusIndicatorViewModel$ViewState);
    }

    @MainThread
    private final void handleStoreState(WidgetGlobalStatusIndicatorViewModel$StoreState storeState) {
        boolean z2;
        if (storeState instanceof WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState) {
            WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState widgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState = (WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState) storeState;
            int iOrdinal = widgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState.getConnectivityState().getState().ordinal();
            if (iOrdinal == 0) {
                updateViewState(WidgetGlobalStatusIndicatorViewModel$ViewState$Inactive.INSTANCE);
                return;
            }
            if (iOrdinal == 1) {
                updateViewState(new WidgetGlobalStatusIndicatorViewModel$ViewState$Offline(widgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState.getConnectivityState().getDelay(), false));
                return;
            } else if (iOrdinal == 2) {
                updateViewState(new WidgetGlobalStatusIndicatorViewModel$ViewState$Offline(widgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState.getConnectivityState().getDelay(), true));
                return;
            } else {
                if (iOrdinal != 3) {
                    return;
                }
                updateViewState(new WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting(widgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState.getConnectivityState().getDelay()));
                return;
            }
        }
        if (storeState instanceof WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing) {
            WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing = (WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing) storeState;
            if (ChannelUtils.D(widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getSelectedVoiceChannel())) {
                boolean z3 = widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getRequestToSpeakState() == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK;
                boolean z4 = widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getRequestToSpeakState() == StageRequestToSpeakState.ON_STAGE;
                WidgetGlobalStatusIndicatorViewModel$ViewState viewState = getViewState();
                if (!(viewState instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing)) {
                    viewState = null;
                }
                WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing = (WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing) viewState;
                if (widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing != null && !widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.isInvitedToSpeak() && z3) {
                    AppSoundManager$Provider.INSTANCE.get().play(AppSound.Companion.getSOUND_RECONNECT());
                }
                updateViewState(new WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing(widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getSelectedVoiceChannel(), widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getConnectionStateChange().state, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getConnectionQuality(), widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getGuild(), widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getStreamContext(), z4, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getStageInstance(), z3, false, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getBlockedUsersOnStage(), 256, null));
                return;
            }
            int size = widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getParticipants().size();
            Collection<StoreVoiceParticipants$VoiceUser> collectionValues = widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getParticipants().values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = collectionValues.iterator();
                while (it.hasNext()) {
                    VoiceState voiceState = ((StoreVoiceParticipants$VoiceUser) it.next()).getVoiceState();
                    if (voiceState != null && voiceState.getSelfVideo()) {
                        z2 = true;
                    }
                }
                z2 = false;
            }
            updateViewState(new WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing(widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getSelectedVoiceChannel(), widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getSelectedTextChannel(), widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getConnectionStateChange().state, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getConnectionQuality(), widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getGuild(), size, z2, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.getStreamContext()));
        }
    }

    public final void ackStageInvitationToSpeak(boolean accept) {
        WidgetGlobalStatusIndicatorViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing)) {
            viewState = null;
        }
        WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing = (WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing) viewState;
        if (widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing != null) {
            updateViewState(WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.copy$default(widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing, null, null, null, null, null, false, null, false, true, 0, 767, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.INSTANCE.ackInvitationToSpeak(widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.getSelectedVoiceChannel(), accept), false, 1, null), this, null, 2, null), WidgetGlobalStatusIndicatorViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGlobalStatusIndicatorViewModel$ackStageInvitationToSpeak$1(this, accept, widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing), 62, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel(Observable<WidgetGlobalStatusIndicatorViewModel$StoreState> observable) {
        super(WidgetGlobalStatusIndicatorViewModel$ViewState$Inactive.INSTANCE);
        m.checkNotNullParameter(observable, "storeStateObservable");
        Observable<WidgetGlobalStatusIndicatorViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetGlobalStatusIndicatorViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGlobalStatusIndicatorViewModel$1(this), 62, (Object) null);
    }
}
