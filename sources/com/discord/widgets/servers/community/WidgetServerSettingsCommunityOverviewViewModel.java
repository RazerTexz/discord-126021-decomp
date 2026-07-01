package com.discord.widgets.servers.community;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppComponent;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams$UpdateGuild;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.o0;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverviewViewModel extends d0<WidgetServerSettingsCommunityOverviewViewModel$ViewState> implements AppComponent {
    public static final WidgetServerSettingsCommunityOverviewViewModel$Companion Companion = new WidgetServerSettingsCommunityOverviewViewModel$Companion(null);
    private final PublishSubject<WidgetServerSettingsCommunityOverviewViewModel$Event> eventSubject;
    private final long guildId;

    public /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? WidgetServerSettingsCommunityOverviewViewModel$Companion.observeStoreState$default(Companion, j, null, null, null, null, 30, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel) {
        return widgetServerSettingsCommunityOverviewViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleDisableCommunityButtonState(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel, boolean z2) {
        widgetServerSettingsCommunityOverviewViewModel.handleDisableCommunityButtonState(z2);
    }

    public static final /* synthetic */ void access$handleGuildUpdateError(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel) {
        widgetServerSettingsCommunityOverviewViewModel.handleGuildUpdateError();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel, WidgetServerSettingsCommunityOverviewViewModel$StoreState widgetServerSettingsCommunityOverviewViewModel$StoreState) {
        widgetServerSettingsCommunityOverviewViewModel.handleStoreState(widgetServerSettingsCommunityOverviewViewModel$StoreState);
    }

    public static final /* synthetic */ boolean access$isDisableCommunityTapped(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel, RestAPIParams$UpdateGuild restAPIParams$UpdateGuild) {
        return widgetServerSettingsCommunityOverviewViewModel.isDisableCommunityTapped(restAPIParams$UpdateGuild);
    }

    private final void handleDisableCommunityButtonState(boolean isLoading) {
        updateViewState(new WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading(isLoading));
    }

    private final void handleGuildUpdateError() {
        handleDisableCommunityButtonState(false);
        PublishSubject<WidgetServerSettingsCommunityOverviewViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetServerSettingsCommunityOverviewViewModel$Event$Error.INSTANCE);
    }

    private final void handleStoreState(WidgetServerSettingsCommunityOverviewViewModel$StoreState storeState) {
        if (!(storeState instanceof WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid)) {
            updateViewState(WidgetServerSettingsCommunityOverviewViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid = (WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid) storeState;
        Guild guild = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.getGuild();
        MeUser me2 = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.getMe();
        Long permissions = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.getPermissions();
        Channel rulesChannel = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.getRulesChannel();
        Channel updatesChannel = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.getUpdatesChannel();
        if (guild.isOwner(me2.getId()) || PermissionUtils.canAndIsElevated(32L, permissions, me2.getMfaEnabled(), guild.getMfaLevel())) {
            updateViewState(new WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded(guild, rulesChannel, updatesChannel));
        } else {
            updateViewState(WidgetServerSettingsCommunityOverviewViewModel$ViewState$Invalid.INSTANCE);
        }
    }

    private final boolean isDisableCommunityTapped(RestAPIParams$UpdateGuild updateGuild) {
        List<GuildFeature> features = updateGuild.getFeatures();
        return (features == null || features.contains(GuildFeature.COMMUNITY)) ? false : true;
    }

    private final void saveCommunityGuildSettings(RestAPIParams$UpdateGuild updateGuild) {
        handleDisableCommunityButtonState(isDisableCommunityTapped(updateGuild));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateGuild(this.guildId, updateGuild), false, 1, null), this, null, 2, null), WidgetServerSettingsCommunityOverviewViewModel.class, (Context) null, (Function1) null, new WidgetServerSettingsCommunityOverviewViewModel$saveCommunityGuildSettings$1(this), (Function0) null, (Function0) null, new WidgetServerSettingsCommunityOverviewViewModel$saveCommunityGuildSettings$2(this, updateGuild), 54, (Object) null);
    }

    @MainThread
    public final void disableCommunity() {
        WidgetServerSettingsCommunityOverviewViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded = (WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded) viewState;
        if (widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded != null) {
            saveCommunityGuildSettings(new RestAPIParams$UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, u.toList(o0.minus(widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded.getGuild().getFeatures(), GuildFeature.COMMUNITY)), null, null, null, 30719, null));
        }
    }

    public final Observable<WidgetServerSettingsCommunityOverviewViewModel$Event> observeEvents() {
        PublishSubject<WidgetServerSettingsCommunityOverviewViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveCommunityUpdatesChannel(long channelId) {
        saveCommunityGuildSettings(new RestAPIParams$UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(channelId), null, 24575, null));
    }

    public final void saveLocale(String locale) {
        m.checkNotNullParameter(locale, "locale");
        saveCommunityGuildSettings(new RestAPIParams$UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, null, null, locale, 16383, null));
    }

    public final void saveRulesChannel(long channelId) {
        saveCommunityGuildSettings(new RestAPIParams$UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(channelId), null, null, 28671, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityOverviewViewModel(long j, Observable<WidgetServerSettingsCommunityOverviewViewModel$StoreState> observable) {
        super(WidgetServerSettingsCommunityOverviewViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetServerSettingsCommunityOverviewViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsCommunityOverviewViewModel$1(this), 62, (Object) null);
    }
}
