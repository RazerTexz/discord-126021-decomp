package com.discord.widgets.channels.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettingsViewModel extends d0<WidgetThreadSettingsViewModel$ViewState> {
    private final long channelId;
    private final PublishSubject<WidgetThreadSettingsViewModel$Event> eventSubject;

    public WidgetThreadSettingsViewModel(long j) {
        super(null, 1, null);
        this.channelId = j;
        this.eventSubject = PublishSubject.k0();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreChannels channels = storeStream$Companion.getChannels();
        StorePermissions permissions = storeStream$Companion.getPermissions();
        StoreUser users = storeStream$Companion.getUsers();
        Observable observableR = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{channels, permissions, users}, false, null, null, new WidgetThreadSettingsViewModel$1(this, channels, users, permissions), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetThreadSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadSettingsViewModel$2(this), 62, (Object) null);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetThreadSettingsViewModel widgetThreadSettingsViewModel) {
        return widgetThreadSettingsViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadSettingsViewModel widgetThreadSettingsViewModel, WidgetThreadSettingsViewModel$StoreState widgetThreadSettingsViewModel$StoreState) {
        widgetThreadSettingsViewModel.handleStoreState(widgetThreadSettingsViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(WidgetThreadSettingsViewModel$StoreState storeState) {
        Channel channel = storeState.getChannel();
        if ((channel != null ? channel.getName() : null) == null || !ChannelUtils.H(channel)) {
            updateViewState(WidgetThreadSettingsViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        boolean z2 = !channel.getNsfw() || StoreStream.Companion.getGuildsNsfw().isGuildNsfwGateAgreed(channel.getGuildId());
        WidgetThreadSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetThreadSettingsViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetThreadSettingsViewModel$ViewState$Valid widgetThreadSettingsViewModel$ViewState$Valid = (WidgetThreadSettingsViewModel$ViewState$Valid) viewState;
        if ((widgetThreadSettingsViewModel$ViewState$Valid != null ? widgetThreadSettingsViewModel$ViewState$Valid.getChannelNameDraft() : null) != null) {
            updateViewState(WidgetThreadSettingsViewModel$ViewState$Valid.copy$default(widgetThreadSettingsViewModel$ViewState$Valid, channel, null, 0, false, false, false, 62, null));
        } else {
            updateViewState(new WidgetThreadSettingsViewModel$ViewState$Valid(channel, channel.getName(), channel.getRateLimitPerUser(), false, storeState.getCanManageThread(), z2));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Observable<WidgetThreadSettingsViewModel$Event> observeEvents() {
        PublishSubject<WidgetThreadSettingsViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onChannelNameInputChanged(String value) {
        m.checkNotNullParameter(value, "value");
        WidgetThreadSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetThreadSettingsViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetThreadSettingsViewModel$ViewState$Valid widgetThreadSettingsViewModel$ViewState$Valid = (WidgetThreadSettingsViewModel$ViewState$Valid) viewState;
        if (widgetThreadSettingsViewModel$ViewState$Valid != null) {
            updateViewState(WidgetThreadSettingsViewModel$ViewState$Valid.copy$default(widgetThreadSettingsViewModel$ViewState$Valid, null, value, 0, true, false, false, 53, null));
        }
    }

    @MainThread
    public final void onSlowModeInputChanged(int cooldown) {
        WidgetThreadSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetThreadSettingsViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetThreadSettingsViewModel$ViewState$Valid widgetThreadSettingsViewModel$ViewState$Valid = (WidgetThreadSettingsViewModel$ViewState$Valid) viewState;
        if (widgetThreadSettingsViewModel$ViewState$Valid != null) {
            updateViewState(WidgetThreadSettingsViewModel$ViewState$Valid.copy$default(widgetThreadSettingsViewModel$ViewState$Valid, null, null, cooldown, true, false, false, 51, null));
        }
    }

    public final void onThreadDeleted(long channelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteChannel(channelId), false, 1, null), this, null, 2, null), WidgetThreadSettingsViewModel.class, (Context) null, (Function1) null, new WidgetThreadSettingsViewModel$onThreadDeleted$2(this), (Function0) null, (Function0) null, new WidgetThreadSettingsViewModel$onThreadDeleted$1(this), 54, (Object) null);
    }

    public final void saveThread() {
        WidgetThreadSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetThreadSettingsViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetThreadSettingsViewModel$ViewState$Valid widgetThreadSettingsViewModel$ViewState$Valid = (WidgetThreadSettingsViewModel$ViewState$Valid) viewState;
        if (widgetThreadSettingsViewModel$ViewState$Valid != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestAPI.editTextChannel$default(RestAPI.Companion.getApi(), this.channelId, m.areEqual(widgetThreadSettingsViewModel$ViewState$Valid.getChannel().getName(), widgetThreadSettingsViewModel$ViewState$Valid.getChannelNameDraft()) ^ true ? widgetThreadSettingsViewModel$ViewState$Valid.getChannelNameDraft() : null, null, null, null, widgetThreadSettingsViewModel$ViewState$Valid.getChannel().getRateLimitPerUser() != widgetThreadSettingsViewModel$ViewState$Valid.getSlowModeCooldownDraft() ? Integer.valueOf(widgetThreadSettingsViewModel$ViewState$Valid.getSlowModeCooldownDraft()) : null, null, 92, null), this, null, 2, null), WidgetThreadSettingsViewModel.class, (Context) null, (Function1) null, new WidgetThreadSettingsViewModel$saveThread$2(this), (Function0) null, (Function0) null, new WidgetThreadSettingsViewModel$saveThread$1(this), 54, (Object) null);
        }
    }
}
