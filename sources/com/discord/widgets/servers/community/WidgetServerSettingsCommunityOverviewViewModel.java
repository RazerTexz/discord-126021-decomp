package com.discord.widgets.servers.community;

import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func4;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverviewViewModel extends AbstractC0859d0<ViewState> implements AppComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    public static final /* synthetic */ class C93691 extends C12236k implements Function1<StoreState, Unit> {
        public C93691(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel) {
            super(1, widgetServerSettingsCommunityOverviewViewModel, WidgetServerSettingsCommunityOverviewViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((WidgetServerSettingsCommunityOverviewViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long guildId, StoreGuilds storeGuilds, final StoreChannels storeChannels, final StorePermissions storePermissions, final StoreUser storeUsers) {
            Observable observableM11099Y = storeGuilds.observeGuild(guildId).m11099Y(new InterfaceC12589b<Guild, Observable<? extends StoreState>>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState> call(final Guild guild) {
                    if (guild == null) {
                        return new C12721k(WidgetServerSettingsCommunityOverviewViewModel.StoreState.Invalid.INSTANCE);
                    }
                    Observable observableObserveMe$default = StoreUser.observeMe$default(storeUsers, false, 1, null);
                    Observable<Long> observableObservePermissionsForGuild = storePermissions.observePermissionsForGuild(guildId);
                    StoreChannels storeChannels2 = storeChannels;
                    Long rulesChannelId = guild.getRulesChannelId();
                    Observable<Channel> observableObserveChannel = storeChannels2.observeChannel(rulesChannelId != null ? rulesChannelId.longValue() : 0L);
                    StoreChannels storeChannels3 = storeChannels;
                    Long publicUpdatesChannelId = guild.getPublicUpdatesChannelId();
                    return Observable.m11073h(observableObserveMe$default, observableObservePermissionsForGuild, observableObserveChannel, storeChannels3.observeChannel(publicUpdatesChannelId != null ? publicUpdatesChannelId.longValue() : 0L), new Func4<MeUser, Long, Channel, Channel, WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1.1
                        @Override // p658rx.functions.Func4
                        public final WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid call(MeUser meUser, Long l, Channel channel, Channel channel2) {
                            Guild guild2 = guild;
                            C12238m.checkNotNullExpressionValue(meUser, "me");
                            return new WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid(guild2, meUser, l, channel, channel2);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "storeGuilds.observeGuild…      }\n        }\n      }");
            return observableM11099Y;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, StoreUser storeUser, int i, Object obj) {
            if ((i & 2) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            StoreGuilds storeGuilds2 = storeGuilds;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            StorePermissions storePermissions2 = storePermissions;
            if ((i & 16) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            return companion.observeStoreState(j, storeGuilds2, storeChannels2, storePermissions2, storeUser);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        public static final class DisableCommunitySuccess extends Event {
            public static final DisableCommunitySuccess INSTANCE = new DisableCommunitySuccess();

            private DisableCommunitySuccess() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        public static final class SaveSuccess extends Event {
            public static final SaveSuccess INSTANCE = new SaveSuccess();

            private SaveSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final MeUser me;
            private final Long permissions;
            private final Channel rulesChannel;
            private final Channel updatesChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, MeUser meUser, Long l, Channel channel, Channel channel2) {
                super(null);
                C12238m.checkNotNullParameter(guild, "guild");
                C12238m.checkNotNullParameter(meUser, "me");
                this.guild = guild;
                this.me = meUser;
                this.permissions = l;
                this.rulesChannel = channel;
                this.updatesChannel = channel2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, MeUser meUser, Long l, Channel channel, Channel channel2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    meUser = valid.me;
                }
                MeUser meUser2 = meUser;
                if ((i & 4) != 0) {
                    l = valid.permissions;
                }
                Long l2 = l;
                if ((i & 8) != 0) {
                    channel = valid.rulesChannel;
                }
                Channel channel3 = channel;
                if ((i & 16) != 0) {
                    channel2 = valid.updatesChannel;
                }
                return valid.copy(guild, meUser2, l2, channel3, channel2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final MeUser getMe() {
                return this.me;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Long getPermissions() {
                return this.permissions;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public final Valid copy(Guild guild, MeUser me2, Long permissions, Channel rulesChannel, Channel updatesChannel) {
                C12238m.checkNotNullParameter(guild, "guild");
                C12238m.checkNotNullParameter(me2, "me");
                return new Valid(guild, me2, permissions, rulesChannel, updatesChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.guild, valid.guild) && C12238m.areEqual(this.me, valid.me) && C12238m.areEqual(this.permissions, valid.permissions) && C12238m.areEqual(this.rulesChannel, valid.rulesChannel) && C12238m.areEqual(this.updatesChannel, valid.updatesChannel);
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final MeUser getMe() {
                return this.me;
            }

            public final Long getPermissions() {
                return this.permissions;
            }

            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                MeUser meUser = this.me;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                Long l = this.permissions;
                int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
                Channel channel = this.rulesChannel;
                int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
                Channel channel2 = this.updatesChannel;
                return iHashCode4 + (channel2 != null ? channel2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", me=");
                sbM833U.append(this.me);
                sbM833U.append(", permissions=");
                sbM833U.append(this.permissions);
                sbM833U.append(", rulesChannel=");
                sbM833U.append(this.rulesChannel);
                sbM833U.append(", updatesChannel=");
                sbM833U.append(this.updatesChannel);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        public static final /* data */ class DisableCommunityLoading extends ViewState {
            private final boolean isLoading;

            public DisableCommunityLoading(boolean z2) {
                super(null);
                this.isLoading = z2;
            }

            public static /* synthetic */ DisableCommunityLoading copy$default(DisableCommunityLoading disableCommunityLoading, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = disableCommunityLoading.isLoading;
                }
                return disableCommunityLoading.copy(z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsLoading() {
                return this.isLoading;
            }

            public final DisableCommunityLoading copy(boolean isLoading) {
                return new DisableCommunityLoading(isLoading);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof DisableCommunityLoading) && this.isLoading == ((DisableCommunityLoading) other).isLoading;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isLoading;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isLoading() {
                return this.isLoading;
            }

            public String toString() {
                return C1643a.m827O(C1643a.m833U("DisableCommunityLoading(isLoading="), this.isLoading, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Guild guild;
            private final Channel rulesChannel;
            private final Channel updatesChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Guild guild, Channel channel, Channel channel2) {
                super(null);
                C12238m.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.rulesChannel = channel;
                this.updatesChannel = channel2;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Guild guild, Channel channel, Channel channel2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = loaded.guild;
                }
                if ((i & 2) != 0) {
                    channel = loaded.rulesChannel;
                }
                if ((i & 4) != 0) {
                    channel2 = loaded.updatesChannel;
                }
                return loaded.copy(guild, channel, channel2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public final Loaded copy(Guild guild, Channel rulesChannel, Channel updatesChannel) {
                C12238m.checkNotNullParameter(guild, "guild");
                return new Loaded(guild, rulesChannel, updatesChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.guild, loaded.guild) && C12238m.areEqual(this.rulesChannel, loaded.rulesChannel) && C12238m.areEqual(this.updatesChannel, loaded.updatesChannel);
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                Channel channel = this.rulesChannel;
                int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
                Channel channel2 = this.updatesChannel;
                return iHashCode2 + (channel2 != null ? channel2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", rulesChannel=");
                sbM833U.append(this.rulesChannel);
                sbM833U.append(", updatesChannel=");
                sbM833U.append(this.updatesChannel);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$saveCommunityGuildSettings$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    public static final class C93711 extends AbstractC12240o implements Function1<Error, Unit> {
        public C93711() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            WidgetServerSettingsCommunityOverviewViewModel.this.handleGuildUpdateError();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$saveCommunityGuildSettings$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    public static final class C93722 extends AbstractC12240o implements Function1<com.discord.api.guild.Guild, Unit> {
        public final /* synthetic */ RestAPIParams.UpdateGuild $updateGuild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C93722(RestAPIParams.UpdateGuild updateGuild) {
            super(1);
            this.$updateGuild = updateGuild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            C12238m.checkNotNullParameter(guild, "it");
            if (!WidgetServerSettingsCommunityOverviewViewModel.this.isDisableCommunityTapped(this.$updateGuild)) {
                WidgetServerSettingsCommunityOverviewViewModel.this.eventSubject.f27650k.onNext((T) Event.SaveSuccess.INSTANCE);
            } else {
                WidgetServerSettingsCommunityOverviewViewModel.this.handleDisableCommunityButtonState(false);
                WidgetServerSettingsCommunityOverviewViewModel.this.eventSubject.f27650k.onNext((T) Event.DisableCommunitySuccess.INSTANCE);
            }
        }
    }

    public /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? Companion.observeStoreState$default(INSTANCE, j, null, null, null, null, 30, null) : observable);
    }

    private final void handleDisableCommunityButtonState(boolean isLoading) {
        updateViewState(new ViewState.DisableCommunityLoading(isLoading));
    }

    private final void handleGuildUpdateError() {
        handleDisableCommunityButtonState(false);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.Error.INSTANCE);
    }

    private final void handleStoreState(StoreState storeState) {
        if (!(storeState instanceof StoreState.Valid)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        Guild guild = valid.getGuild();
        MeUser me2 = valid.getMe();
        Long permissions = valid.getPermissions();
        Channel rulesChannel = valid.getRulesChannel();
        Channel updatesChannel = valid.getUpdatesChannel();
        if (guild.isOwner(me2.getId()) || PermissionUtils.canAndIsElevated(32L, permissions, me2.getMfaEnabled(), guild.getMfaLevel())) {
            updateViewState(new ViewState.Loaded(guild, rulesChannel, updatesChannel));
        } else {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    private final boolean isDisableCommunityTapped(RestAPIParams.UpdateGuild updateGuild) {
        List<GuildFeature> features = updateGuild.getFeatures();
        return (features == null || features.contains(GuildFeature.COMMUNITY)) ? false : true;
    }

    private final void saveCommunityGuildSettings(RestAPIParams.UpdateGuild updateGuild) {
        handleDisableCommunityButtonState(isDisableCommunityTapped(updateGuild));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuild(this.guildId, updateGuild), false, 1, null), this, null, 2, null), (Class<?>) WidgetServerSettingsCommunityOverviewViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C93711()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93722(updateGuild));
    }

    @MainThread
    public final void disableCommunity() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            saveCommunityGuildSettings(new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, C12163u.toList(C12150o0.minus(loaded.getGuild().getFeatures(), GuildFeature.COMMUNITY)), null, null, null, 30719, null));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveCommunityUpdatesChannel(long channelId) {
        saveCommunityGuildSettings(new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(channelId), null, 24575, null));
    }

    public final void saveLocale(String locale) {
        C12238m.checkNotNullParameter(locale, "locale");
        saveCommunityGuildSettings(new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, null, null, locale, 16383, null));
    }

    public final void saveRulesChannel(long channelId) {
        saveCommunityGuildSettings(new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(channelId), null, null, 28671, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityOverviewViewModel(long j, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetServerSettingsCommunityOverviewViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93691(this));
    }
}
