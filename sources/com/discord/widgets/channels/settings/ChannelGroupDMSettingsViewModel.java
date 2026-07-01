package com.discord.widgets.channels.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$GroupDM;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel extends d0<ChannelGroupDMSettingsViewModel$ViewState> {
    public static final ChannelGroupDMSettingsViewModel$Companion Companion = new ChannelGroupDMSettingsViewModel$Companion(null);
    private final long channelId;
    private final PublishSubject<ChannelGroupDMSettingsViewModel$Event> eventSubject;
    private final RestAPI restApi;
    private final StoreUserGuildSettings storeUserGuildSettings;

    public /* synthetic */ ChannelGroupDMSettingsViewModel(long j, RestAPI restAPI, StoreUserGuildSettings storeUserGuildSettings, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 4) != 0 ? StoreStream.Companion.getUserGuildSettings() : storeUserGuildSettings, (i & 8) != 0 ? ChannelGroupDMSettingsViewModel$Companion.observeStoreState$default(Companion, j, null, null, 6, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel) {
        return channelGroupDMSettingsViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel, ChannelGroupDMSettingsViewModel$StoreState channelGroupDMSettingsViewModel$StoreState) {
        channelGroupDMSettingsViewModel.handleStoreState(channelGroupDMSettingsViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel, ChannelGroupDMSettingsViewModel$ViewState channelGroupDMSettingsViewModel$ViewState) {
        channelGroupDMSettingsViewModel.updateViewState(channelGroupDMSettingsViewModel$ViewState);
    }

    @MainThread
    private final void handleStoreState(ChannelGroupDMSettingsViewModel$StoreState storeState) {
        if (m.areEqual(storeState, ChannelGroupDMSettingsViewModel$StoreState$Invalid.INSTANCE)) {
            updateViewState(ChannelGroupDMSettingsViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        if (storeState instanceof ChannelGroupDMSettingsViewModel$StoreState$Valid) {
            ChannelGroupDMSettingsViewModel$StoreState$Valid channelGroupDMSettingsViewModel$StoreState$Valid = (ChannelGroupDMSettingsViewModel$StoreState$Valid) storeState;
            Channel channel = channelGroupDMSettingsViewModel$StoreState$Valid.getChannel();
            ChannelSettings channelSettingsCreateFromNotificationSettings = ChannelSettings.Companion.createFromNotificationSettings(channel, channelGroupDMSettingsViewModel$StoreState$Valid.getNotificationSettings());
            ChannelGroupDMSettingsViewModel$ViewState viewState = getViewState();
            updateViewState(viewState instanceof ChannelGroupDMSettingsViewModel$ViewState$Valid ? ChannelGroupDMSettingsViewModel$ViewState$Valid.copy$default((ChannelGroupDMSettingsViewModel$ViewState$Valid) viewState, channelSettingsCreateFromNotificationSettings, null, null, 6, null) : new ChannelGroupDMSettingsViewModel$ViewState$Valid(channelSettingsCreateFromNotificationSettings, IconUtils.getForChannel(channel, null), IconUtils.getForChannel(channel, null)));
        }
    }

    @MainThread
    public final void editGroup(long groupId, String name) {
        String originalIconUrl;
        ChannelGroupDMSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChannelGroupDMSettingsViewModel$ViewState$Valid)) {
            viewState = null;
        }
        ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid = (ChannelGroupDMSettingsViewModel$ViewState$Valid) viewState;
        if (channelGroupDMSettingsViewModel$ViewState$Valid != null) {
            if (channelGroupDMSettingsViewModel$ViewState$Valid.getHasUnsavedIconChange()) {
                originalIconUrl = channelGroupDMSettingsViewModel$ViewState$Valid.getEditedIconUrl();
                if (originalIconUrl == null) {
                    originalIconUrl = "";
                }
            } else {
                originalIconUrl = channelGroupDMSettingsViewModel$ViewState$Valid.getOriginalIconUrl();
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.editGroupDM(groupId, new RestAPIParams$GroupDM(name, originalIconUrl)), false, 1, null), this, null, 2, null), ChannelGroupDMSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelGroupDMSettingsViewModel$editGroup$1(this, channelGroupDMSettingsViewModel$ViewState$Valid), 62, (Object) null);
        }
    }

    @MainThread
    public final void leaveGroup() {
        ChannelGroupDMSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChannelGroupDMSettingsViewModel$ViewState$Valid)) {
            viewState = null;
        }
        ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid = (ChannelGroupDMSettingsViewModel$ViewState$Valid) viewState;
        if (channelGroupDMSettingsViewModel$ViewState$Valid != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.deleteChannel(channelGroupDMSettingsViewModel$ViewState$Valid.getChannelSettings().getChannel().getId()), false, 1, null), this, null, 2, null), ChannelGroupDMSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelGroupDMSettingsViewModel$leaveGroup$1(this), 62, (Object) null);
        }
    }

    @MainThread
    public final Observable<ChannelGroupDMSettingsViewModel$Event> observeEvents() {
        PublishSubject<ChannelGroupDMSettingsViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onIconEdited(String iconUrl) {
        m.checkNotNullParameter(iconUrl, "iconUrl");
        ChannelGroupDMSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChannelGroupDMSettingsViewModel$ViewState$Valid)) {
            viewState = null;
        }
        ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid = (ChannelGroupDMSettingsViewModel$ViewState$Valid) viewState;
        if (channelGroupDMSettingsViewModel$ViewState$Valid != null) {
            updateViewState(ChannelGroupDMSettingsViewModel$ViewState$Valid.copy$default(channelGroupDMSettingsViewModel$ViewState$Valid, null, null, iconUrl, 3, null));
        }
    }

    @MainThread
    public final void removeEditedIcon() {
        ChannelGroupDMSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChannelGroupDMSettingsViewModel$ViewState$Valid)) {
            viewState = null;
        }
        ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid = (ChannelGroupDMSettingsViewModel$ViewState$Valid) viewState;
        if (channelGroupDMSettingsViewModel$ViewState$Valid != null) {
            updateViewState(ChannelGroupDMSettingsViewModel$ViewState$Valid.copy$default(channelGroupDMSettingsViewModel$ViewState$Valid, null, null, null, 3, null));
        }
    }

    public final void unmute(Context context) {
        m.checkNotNullParameter(context, "context");
        this.storeUserGuildSettings.setChannelMuted(context, this.channelId, false, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel(long j, RestAPI restAPI, StoreUserGuildSettings storeUserGuildSettings, Observable<ChannelGroupDMSettingsViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(restAPI, "restApi");
        m.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.restApi = restAPI;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ChannelGroupDMSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelGroupDMSettingsViewModel$1(this), 62, (Object) null);
    }
}
