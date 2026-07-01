package com.discord.widgets.servers.community;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams$Role;
import com.discord.restapi.RestAPIParams$UpdateGuild;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel extends d0<WidgetServerSettingsEnableCommunityViewModel$ViewState> {
    public static final WidgetServerSettingsEnableCommunityViewModel$Companion Companion = new WidgetServerSettingsEnableCommunityViewModel$Companion(null);
    private final PublishSubject<WidgetServerSettingsEnableCommunityViewModel$Event> eventSubject;
    private final long guildId;

    public /* synthetic */ WidgetServerSettingsEnableCommunityViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? WidgetServerSettingsEnableCommunityViewModel$Companion.observeStoreState$default(Companion, j, null, null, null, null, 30, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel) {
        return widgetServerSettingsEnableCommunityViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleGuildUpdateError(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel) {
        widgetServerSettingsEnableCommunityViewModel.handleGuildUpdateError();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel, WidgetServerSettingsEnableCommunityViewModel$StoreState widgetServerSettingsEnableCommunityViewModel$StoreState) {
        widgetServerSettingsEnableCommunityViewModel.handleStoreState(widgetServerSettingsEnableCommunityViewModel$StoreState);
    }

    public static final /* synthetic */ void access$patchRole(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel, RestAPIParams$Role restAPIParams$Role) {
        widgetServerSettingsEnableCommunityViewModel.patchRole(restAPIParams$Role);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel, WidgetServerSettingsEnableCommunityViewModel$ViewState widgetServerSettingsEnableCommunityViewModel$ViewState) {
        widgetServerSettingsEnableCommunityViewModel.updateViewState(widgetServerSettingsEnableCommunityViewModel$ViewState);
    }

    @MainThread
    private final RestAPIParams$UpdateGuild getUpdatedGuildParams() {
        GuildVerificationLevel verificationLevel;
        GuildVerificationLevel guildVerificationLevel;
        GuildExplicitContentFilter explicitContentFilter;
        GuildExplicitContentFilter guildExplicitContentFilter;
        WidgetServerSettingsEnableCommunityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded = (WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) viewState;
        if (widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded == null) {
            return new RestAPIParams$UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }
        WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig communityGuildConfig = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.getCommunityGuildConfig();
        List listPlus = u.plus((Collection<? extends GuildFeature>) communityGuildConfig.getFeatures(), GuildFeature.COMMUNITY);
        Guild guild = communityGuildConfig.getGuild();
        if (guild == null || (verificationLevel = guild.getVerificationLevel()) == null) {
            verificationLevel = GuildVerificationLevel.NONE;
        }
        GuildVerificationLevel guildVerificationLevel2 = GuildVerificationLevel.NONE;
        if (verificationLevel.compareTo(guildVerificationLevel2) <= 0 || communityGuildConfig.getVerificationLevel()) {
            if (verificationLevel == guildVerificationLevel2 && communityGuildConfig.getVerificationLevel()) {
                verificationLevel = GuildVerificationLevel.LOW;
            }
            guildVerificationLevel = verificationLevel;
        } else {
            guildVerificationLevel = guildVerificationLevel2;
        }
        Guild guild2 = communityGuildConfig.getGuild();
        if (guild2 == null || (explicitContentFilter = guild2.getExplicitContentFilter()) == null) {
            explicitContentFilter = GuildExplicitContentFilter.NONE;
        }
        GuildExplicitContentFilter guildExplicitContentFilter2 = GuildExplicitContentFilter.NONE;
        if (explicitContentFilter.compareTo(guildExplicitContentFilter2) <= 0 || communityGuildConfig.getExplicitContentFilter()) {
            if (explicitContentFilter == guildExplicitContentFilter2 && communityGuildConfig.getExplicitContentFilter()) {
                explicitContentFilter = GuildExplicitContentFilter.ALL;
            }
            guildExplicitContentFilter = explicitContentFilter;
        } else {
            guildExplicitContentFilter = guildExplicitContentFilter2;
        }
        boolean defaultMessageNotifications = communityGuildConfig.getDefaultMessageNotifications();
        int i = 1;
        if (!defaultMessageNotifications) {
            if (defaultMessageNotifications) {
                throw new NoWhenBranchMatchedException();
            }
            i = 0;
        }
        return new RestAPIParams$UpdateGuild(null, null, null, Integer.valueOf(i), null, null, guildVerificationLevel, guildExplicitContentFilter, null, null, null, listPlus, communityGuildConfig.getRulesChannelId(), communityGuildConfig.getUpdatesChannelId(), null, 18231, null);
    }

    private final void handleGuildUpdateError() {
        WidgetServerSettingsEnableCommunityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded = (WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) viewState;
        if (widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.copy$default(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, 0, false, null, 5, null));
            PublishSubject<WidgetServerSettingsEnableCommunityViewModel$Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(WidgetServerSettingsEnableCommunityViewModel$Event$Error.INSTANCE);
        }
    }

    private final void handleStoreState(WidgetServerSettingsEnableCommunityViewModel$StoreState storeState) {
        GuildRole guildRole;
        GuildRole guildRole2;
        if (!(storeState instanceof WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid)) {
            updateViewState(WidgetServerSettingsEnableCommunityViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid widgetServerSettingsEnableCommunityViewModel$StoreState$Valid = (WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid) storeState;
        Guild guild = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.getGuild();
        MeUser me2 = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.getMe();
        if (!(guild.isOwner(me2.getId()) || PermissionUtils.canAndIsElevated(32L, widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.getPermissions(), me2.getMfaEnabled(), guild.getMfaLevel()))) {
            updateViewState(WidgetServerSettingsEnableCommunityViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        Channel rulesChannel = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.getRulesChannel();
        Channel updatesChannel = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.getUpdatesChannel();
        boolean z2 = guild.getDefaultMessageNotifications() == 1;
        boolean z3 = guild.getVerificationLevel().compareTo(GuildVerificationLevel.NONE) > 0;
        boolean z4 = guild.getExplicitContentFilter().compareTo(GuildExplicitContentFilter.NONE) > 0;
        Map<Long, GuildRole> roles = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.getRoles();
        long permissions = (-1116960071743L) & ((roles == null || (guildRole2 = roles.get(Long.valueOf(this.guildId))) == null) ? 0L : guildRole2.getPermissions());
        Map<Long, GuildRole> roles2 = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.getRoles();
        updateViewState(new WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded(0, false, new WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig(rulesChannel, updatesChannel, 1L, 1L, false, z2, z3, z4, guild, (roles2 == null || (guildRole = roles2.get(Long.valueOf(this.guildId))) == null || permissions != guildRole.getPermissions()) ? false : true, u.toList(guild.getFeatures()), widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.getRoles())));
    }

    private final void patchRole(RestAPIParams$Role roleParams) {
        WidgetServerSettingsEnableCommunityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded = (WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) viewState;
        if (widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded != null) {
            RestAPI api = RestAPI.Companion.getApi();
            long j = this.guildId;
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.updateRole(j, j, roleParams), false, 1, null), this, null, 2, null), WidgetServerSettingsEnableCommunityViewModel.class, (Context) null, (Function1) null, new WidgetServerSettingsEnableCommunityViewModel$patchRole$1(this), (Function0) null, (Function0) null, new WidgetServerSettingsEnableCommunityViewModel$patchRole$2(this, widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded), 54, (Object) null);
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @MainThread
    public final void goBackToPreviousPage() {
        WidgetServerSettingsEnableCommunityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded = (WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) viewState;
        if (widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded != null) {
            updateCurrentPage(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.getCurrentPage() - 1);
        }
    }

    @MainThread
    public final void modifyGuildConfig(Function1<? super WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig> transform) {
        m.checkNotNullParameter(transform, "transform");
        WidgetServerSettingsEnableCommunityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded = (WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) viewState;
        if (widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.copy$default(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, 0, false, transform.invoke(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.getCommunityGuildConfig()), 3, null));
        }
    }

    public final Observable<WidgetServerSettingsEnableCommunityViewModel$Event> observeEvents() {
        PublishSubject<WidgetServerSettingsEnableCommunityViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void updateCurrentPage(int currentPage) {
        WidgetServerSettingsEnableCommunityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded = (WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) viewState;
        if (widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.copy$default(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, currentPage, false, null, 6, null));
        }
    }

    public final void updateGuild() {
        WidgetServerSettingsEnableCommunityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded = (WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) viewState;
        if (widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded != null) {
            WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig communityGuildConfig = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.getCommunityGuildConfig();
            updateViewState(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.copy$default(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, 0, true, null, 5, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateGuild(this.guildId, getUpdatedGuildParams()), false, 1, null), this, null, 2, null), WidgetServerSettingsEnableCommunityViewModel.class, (Context) null, (Function1) null, new WidgetServerSettingsEnableCommunityViewModel$updateGuild$1(this), (Function0) null, (Function0) null, new WidgetServerSettingsEnableCommunityViewModel$updateGuild$2(this, communityGuildConfig, widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded), 54, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunityViewModel(long j, Observable<WidgetServerSettingsEnableCommunityViewModel$StoreState> observable) {
        super(WidgetServerSettingsEnableCommunityViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetServerSettingsEnableCommunityViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEnableCommunityViewModel$1(this), 62, (Object) null);
    }
}
