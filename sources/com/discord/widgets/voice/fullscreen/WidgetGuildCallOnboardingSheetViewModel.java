package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheetViewModel extends d0<WidgetGuildCallOnboardingSheetViewModel$ViewState> {
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<WidgetGuildCallOnboardingSheetViewModel$Event> eventSubject;
    private final StoreGuilds guildsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceStates voiceStatesStore;

    public /* synthetic */ WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 4) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 8) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 32) != 0 ? StoreStream.Companion.getVoiceStates() : storeVoiceStates);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildCallOnboardingSheetViewModel widgetGuildCallOnboardingSheetViewModel, WidgetGuildCallOnboardingSheetViewModel$StoreState widgetGuildCallOnboardingSheetViewModel$StoreState) {
        widgetGuildCallOnboardingSheetViewModel.handleStoreState(widgetGuildCallOnboardingSheetViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(WidgetGuildCallOnboardingSheetViewModel$StoreState storeState) {
        updateViewState(new WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded(storeState.getGuildId(), storeState.getVoiceChannelJoinability()));
    }

    private final Observable<WidgetGuildCallOnboardingSheetViewModel$StoreState> observeStoreState() {
        Observable<WidgetGuildCallOnboardingSheetViewModel$StoreState> observableJ = Observable.j(this.channelsStore.observeChannel(this.channelId), VoiceChannelJoinabilityUtils.observeJoinability$default(VoiceChannelJoinabilityUtils.INSTANCE, this.channelId, this.channelsStore, this.guildsStore, this.permissionsStore, this.voiceStatesStore, null, null, 96, null), WidgetGuildCallOnboardingSheetViewModel$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…dId, joinability)\n      }");
        return observableJ;
    }

    public final Observable<WidgetGuildCallOnboardingSheetViewModel$Event> observeEvents() {
        PublishSubject<WidgetGuildCallOnboardingSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onConnectPressed() {
        WidgetGuildCallOnboardingSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded = (WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded) viewState;
        if (widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded != null) {
            int iOrdinal = widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded.getJoinability().ordinal();
            if (iOrdinal == 0) {
                this.selectedVoiceChannelStore.selectVoiceChannel(this.channelId);
                PublishSubject<WidgetGuildCallOnboardingSheetViewModel$Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(new WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen(this.channelId, widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded.getGuildId()));
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            PublishSubject<WidgetGuildCallOnboardingSheetViewModel$Event> publishSubject2 = this.eventSubject;
            publishSubject2.k.onNext(WidgetGuildCallOnboardingSheetViewModel$Event$ShowGuildVideoCapacityDialog.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates) {
        super(WidgetGuildCallOnboardingSheetViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        this.channelId = j;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.voiceStatesStore = storeVoiceStates;
        this.eventSubject = PublishSubject.k0();
        Observable<WidgetGuildCallOnboardingSheetViewModel$StoreState> observableR = observeStoreState().r();
        m.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetGuildCallOnboardingSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildCallOnboardingSheetViewModel$1(this), 62, (Object) null);
    }
}
