package com.discord.widgets.announcements;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.app.AppComponent;
import com.discord.restapi.RestAPIParams$ChannelFollowerPost;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel extends d0<WidgetChannelFollowSheetViewModel$ViewState> implements AppComponent {
    private final PublishSubject<WidgetChannelFollowSheetViewModel$Event> eventSubject;
    private final BehaviorSubject<Long> selectedChannelSubject;
    private final BehaviorSubject<Long> selectedGuildSubject;
    private final long sourceChannelId;
    private final long sourceGuildId;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;

    public /* synthetic */ WidgetChannelFollowSheetViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.Companion.getPermissions() : storePermissions);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
        return widgetChannelFollowSheetViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleChannelFollowError(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel, Error error) {
        widgetChannelFollowSheetViewModel.handleChannelFollowError(error);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel, WidgetChannelFollowSheetViewModel$ViewState widgetChannelFollowSheetViewModel$ViewState) {
        widgetChannelFollowSheetViewModel.updateViewState(widgetChannelFollowSheetViewModel$ViewState);
    }

    private final Observable<Map<Long, List<Channel>>> calculateChannelsWithPermissions() {
        return this.storePermissions.observePermissionsForAllChannels().r().Y(new WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1(this));
    }

    private final void handleChannelFollowError(Error error) {
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        int i = response.getCode() != 30007 ? 2131889043 : 2131889047;
        WidgetChannelFollowSheetViewModel$ViewState viewState = getViewState();
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.ViewState.Loaded");
        updateViewState(WidgetChannelFollowSheetViewModel$ViewState$Loaded.copy$default((WidgetChannelFollowSheetViewModel$ViewState$Loaded) viewState, null, null, null, null, null, null, Integer.valueOf(i), 63, null));
    }

    private final Observable<WidgetChannelFollowSheetViewModel$ViewState$Loaded> observeViewStateFromStores() {
        Observable<WidgetChannelFollowSheetViewModel$ViewState$Loaded> observableG = Observable.g(this.storeGuilds.observeGuild(this.sourceGuildId), this.storeChannels.observeChannel(this.sourceChannelId), calculateChannelsWithPermissions(), this.selectedGuildSubject.Y(new WidgetChannelFollowSheetViewModel$observeViewStateFromStores$1(this)), this.selectedChannelSubject.Y(new WidgetChannelFollowSheetViewModel$observeViewStateFromStores$2(this)), WidgetChannelFollowSheetViewModel$observeViewStateFromStores$3.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…  )\n\n      expected\n    }");
        return observableG;
    }

    public final void followChannel(long webhookChannelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().createChannelFollower(this.sourceChannelId, new RestAPIParams$ChannelFollowerPost(webhookChannelId)), false, 1, null), this, null, 2, null), WidgetChannelFollowSheetViewModel.class, (Context) null, (Function1) null, new WidgetChannelFollowSheetViewModel$followChannel$1(this), (Function0) null, (Function0) null, new WidgetChannelFollowSheetViewModel$followChannel$2(this), 54, (Object) null);
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StorePermissions getStorePermissions() {
        return this.storePermissions;
    }

    public final Observable<WidgetChannelFollowSheetViewModel$Event> observeEvents() {
        PublishSubject<WidgetChannelFollowSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void selectChannel(long channelId) {
        this.selectedChannelSubject.onNext(Long.valueOf(channelId));
    }

    public final void selectGuild(long guildId) {
        this.selectedGuildSubject.onNext(Long.valueOf(guildId));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheetViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
        super(WidgetChannelFollowSheetViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        this.sourceGuildId = j;
        this.sourceChannelId = j2;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.selectedGuildSubject = BehaviorSubject.l0(null);
        this.selectedChannelSubject = BehaviorSubject.l0(null);
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observeViewStateFromStores()), this, null, 2, null), WidgetChannelFollowSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelFollowSheetViewModel$1(this), 62, (Object) null);
    }
}
