package com.discord.widgets.servers.community;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.role.GuildRole;
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
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func5;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel) {
            super(1, widgetServerSettingsEnableCommunityViewModel, WidgetServerSettingsEnableCommunityViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((WidgetServerSettingsEnableCommunityViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static final /* data */ class CommunityGuildConfig {
        private final boolean defaultMessageNotifications;
        private final boolean everyonePermissions;
        private final boolean explicitContentFilter;
        private final List<GuildFeature> features;
        private final Guild guild;
        private final boolean isPrivacyPolicyAccepted;
        private final Map<Long, GuildRole> roles;
        private final Channel rulesChannel;
        private final Long rulesChannelId;
        private final Channel updatesChannel;
        private final Long updatesChannelId;
        private final boolean verificationLevel;

        /* JADX WARN: Multi-variable type inference failed */
        public CommunityGuildConfig(Channel channel, Channel channel2, Long l, Long l2, boolean z2, boolean z3, boolean z4, boolean z5, Guild guild, boolean z6, List<? extends GuildFeature> list, Map<Long, GuildRole> map) {
            Intrinsics3.checkNotNullParameter(list, "features");
            this.rulesChannel = channel;
            this.updatesChannel = channel2;
            this.rulesChannelId = l;
            this.updatesChannelId = l2;
            this.isPrivacyPolicyAccepted = z2;
            this.defaultMessageNotifications = z3;
            this.verificationLevel = z4;
            this.explicitContentFilter = z5;
            this.guild = guild;
            this.everyonePermissions = z6;
            this.features = list;
            this.roles = map;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getRulesChannel() {
            return this.rulesChannel;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getEveryonePermissions() {
            return this.everyonePermissions;
        }

        public final List<GuildFeature> component11() {
            return this.features;
        }

        public final Map<Long, GuildRole> component12() {
            return this.roles;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getUpdatesChannel() {
            return this.updatesChannel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getRulesChannelId() {
            return this.rulesChannelId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getUpdatesChannelId() {
            return this.updatesChannelId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsPrivacyPolicyAccepted() {
            return this.isPrivacyPolicyAccepted;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getDefaultMessageNotifications() {
            return this.defaultMessageNotifications;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getVerificationLevel() {
            return this.verificationLevel;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final CommunityGuildConfig copy(Channel rulesChannel, Channel updatesChannel, Long rulesChannelId, Long updatesChannelId, boolean isPrivacyPolicyAccepted, boolean defaultMessageNotifications, boolean verificationLevel, boolean explicitContentFilter, Guild guild, boolean everyonePermissions, List<? extends GuildFeature> features, Map<Long, GuildRole> roles) {
            Intrinsics3.checkNotNullParameter(features, "features");
            return new CommunityGuildConfig(rulesChannel, updatesChannel, rulesChannelId, updatesChannelId, isPrivacyPolicyAccepted, defaultMessageNotifications, verificationLevel, explicitContentFilter, guild, everyonePermissions, features, roles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommunityGuildConfig)) {
                return false;
            }
            CommunityGuildConfig communityGuildConfig = (CommunityGuildConfig) other;
            return Intrinsics3.areEqual(this.rulesChannel, communityGuildConfig.rulesChannel) && Intrinsics3.areEqual(this.updatesChannel, communityGuildConfig.updatesChannel) && Intrinsics3.areEqual(this.rulesChannelId, communityGuildConfig.rulesChannelId) && Intrinsics3.areEqual(this.updatesChannelId, communityGuildConfig.updatesChannelId) && this.isPrivacyPolicyAccepted == communityGuildConfig.isPrivacyPolicyAccepted && this.defaultMessageNotifications == communityGuildConfig.defaultMessageNotifications && this.verificationLevel == communityGuildConfig.verificationLevel && this.explicitContentFilter == communityGuildConfig.explicitContentFilter && Intrinsics3.areEqual(this.guild, communityGuildConfig.guild) && this.everyonePermissions == communityGuildConfig.everyonePermissions && Intrinsics3.areEqual(this.features, communityGuildConfig.features) && Intrinsics3.areEqual(this.roles, communityGuildConfig.roles);
        }

        public final boolean getDefaultMessageNotifications() {
            return this.defaultMessageNotifications;
        }

        public final boolean getEveryonePermissions() {
            return this.everyonePermissions;
        }

        public final boolean getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        public final List<GuildFeature> getFeatures() {
            return this.features;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Channel getRulesChannel() {
            return this.rulesChannel;
        }

        public final Long getRulesChannelId() {
            return this.rulesChannelId;
        }

        public final Channel getUpdatesChannel() {
            return this.updatesChannel;
        }

        public final Long getUpdatesChannelId() {
            return this.updatesChannelId;
        }

        public final boolean getVerificationLevel() {
            return this.verificationLevel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12, types: [int] */
        /* JADX WARN: Type inference failed for: r2v14, types: [int] */
        /* JADX WARN: Type inference failed for: r2v16, types: [int] */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v34 */
        /* JADX WARN: Type inference failed for: r2v35 */
        /* JADX WARN: Type inference failed for: r2v36 */
        /* JADX WARN: Type inference failed for: r2v37 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            Channel channel = this.rulesChannel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Channel channel2 = this.updatesChannel;
            int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
            Long l = this.rulesChannelId;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            Long l2 = this.updatesChannelId;
            int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
            boolean z2 = this.isPrivacyPolicyAccepted;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode4 + r2) * 31;
            boolean z3 = this.defaultMessageNotifications;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            boolean z4 = this.verificationLevel;
            ?? r4 = z4;
            if (z4) {
                r4 = 1;
            }
            int i3 = (i2 + r4) * 31;
            boolean z5 = this.explicitContentFilter;
            ?? r5 = z5;
            if (z5) {
                r5 = 1;
            }
            int i4 = (i3 + r5) * 31;
            Guild guild = this.guild;
            int iHashCode5 = (i4 + (guild != null ? guild.hashCode() : 0)) * 31;
            boolean z6 = this.everyonePermissions;
            int i5 = (iHashCode5 + (z6 ? 1 : z6)) * 31;
            List<GuildFeature> list = this.features;
            int iHashCode6 = (i5 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map = this.roles;
            return iHashCode6 + (map != null ? map.hashCode() : 0);
        }

        public final boolean isPrivacyPolicyAccepted() {
            return this.isPrivacyPolicyAccepted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("CommunityGuildConfig(rulesChannel=");
            sbU.append(this.rulesChannel);
            sbU.append(", updatesChannel=");
            sbU.append(this.updatesChannel);
            sbU.append(", rulesChannelId=");
            sbU.append(this.rulesChannelId);
            sbU.append(", updatesChannelId=");
            sbU.append(this.updatesChannelId);
            sbU.append(", isPrivacyPolicyAccepted=");
            sbU.append(this.isPrivacyPolicyAccepted);
            sbU.append(", defaultMessageNotifications=");
            sbU.append(this.defaultMessageNotifications);
            sbU.append(", verificationLevel=");
            sbU.append(this.verificationLevel);
            sbU.append(", explicitContentFilter=");
            sbU.append(this.explicitContentFilter);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", everyonePermissions=");
            sbU.append(this.everyonePermissions);
            sbU.append(", features=");
            sbU.append(this.features);
            sbU.append(", roles=");
            return outline.M(sbU, this.roles, ")");
        }

        public /* synthetic */ CommunityGuildConfig(Channel channel, Channel channel2, Long l, Long l2, boolean z2, boolean z3, boolean z4, boolean z5, Guild guild, boolean z6, List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(channel, channel2, l, l2, z2, z3, z4, z5, guild, z6, (i & 1024) != 0 ? new ArrayList() : list, map);
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long guildId, StoreGuilds storeGuilds, final StoreChannels storeChannels, final StorePermissions storePermissions, final StoreUser storeUsers) {
            Observable observableY = storeGuilds.observeGuild(guildId).Y(new Func1<Guild, Observable<? extends StoreState>>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetServerSettingsEnableCommunityViewModel.StoreState> call(final Guild guild) {
                    if (guild == null) {
                        return new ScalarSynchronousObservable(WidgetServerSettingsEnableCommunityViewModel.StoreState.Invalid.INSTANCE);
                    }
                    Observable observableObserveMe$default = StoreUser.observeMe$default(storeUsers, false, 1, null);
                    Observable<Long> observableObservePermissionsForGuild = storePermissions.observePermissionsForGuild(guildId);
                    Observable<Map<Long, GuildRole>> observableObserveRoles = StoreStream.INSTANCE.getGuilds().observeRoles(guildId);
                    StoreChannels storeChannels2 = storeChannels;
                    Long rulesChannelId = guild.getRulesChannelId();
                    Observable<Channel> observableObserveChannel = storeChannels2.observeChannel(rulesChannelId != null ? rulesChannelId.longValue() : 0L);
                    StoreChannels storeChannels3 = storeChannels;
                    Long publicUpdatesChannelId = guild.getPublicUpdatesChannelId();
                    return Observable.g(observableObserveMe$default, observableObservePermissionsForGuild, observableObserveRoles, observableObserveChannel, storeChannels3.observeChannel(publicUpdatesChannelId != null ? publicUpdatesChannelId.longValue() : 0L), new Func5<MeUser, Long, Map<Long, ? extends GuildRole>, Channel, Channel, WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1.1
                        @Override // rx.functions.Func5
                        public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid call(MeUser meUser, Long l, Map<Long, ? extends GuildRole> map, Channel channel, Channel channel2) {
                            return call2(meUser, l, (Map<Long, GuildRole>) map, channel, channel2);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid call2(MeUser meUser, Long l, Map<Long, GuildRole> map, Channel channel, Channel channel2) {
                            Guild guild2 = guild;
                            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                            return new WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid(guild2, meUser, l, map, channel, channel2);
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeGuilds.observeGuild…      }\n        }\n      }");
            return observableY;
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

    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
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

    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final MeUser me;
            private final Long permissions;
            private final Map<Long, GuildRole> roles;
            private final Channel rulesChannel;
            private final Channel updatesChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, MeUser meUser, Long l, Map<Long, GuildRole> map, Channel channel, Channel channel2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(meUser, "me");
                this.guild = guild;
                this.me = meUser;
                this.permissions = l;
                this.roles = map;
                this.rulesChannel = channel;
                this.updatesChannel = channel2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, MeUser meUser, Long l, Map map, Channel channel, Channel channel2, int i, Object obj) {
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
                    map = valid.roles;
                }
                Map map2 = map;
                if ((i & 16) != 0) {
                    channel = valid.rulesChannel;
                }
                Channel channel3 = channel;
                if ((i & 32) != 0) {
                    channel2 = valid.updatesChannel;
                }
                return valid.copy(guild, meUser2, l2, map2, channel3, channel2);
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

            public final Map<Long, GuildRole> component4() {
                return this.roles;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public final Valid copy(Guild guild, MeUser me2, Long permissions, Map<Long, GuildRole> roles, Channel rulesChannel, Channel updatesChannel) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(me2, "me");
                return new Valid(guild, me2, permissions, roles, rulesChannel, updatesChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && Intrinsics3.areEqual(this.me, valid.me) && Intrinsics3.areEqual(this.permissions, valid.permissions) && Intrinsics3.areEqual(this.roles, valid.roles) && Intrinsics3.areEqual(this.rulesChannel, valid.rulesChannel) && Intrinsics3.areEqual(this.updatesChannel, valid.updatesChannel);
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

            public final Map<Long, GuildRole> getRoles() {
                return this.roles;
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
                Map<Long, GuildRole> map = this.roles;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Channel channel = this.rulesChannel;
                int iHashCode5 = (iHashCode4 + (channel != null ? channel.hashCode() : 0)) * 31;
                Channel channel2 = this.updatesChannel;
                return iHashCode5 + (channel2 != null ? channel2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", me=");
                sbU.append(this.me);
                sbU.append(", permissions=");
                sbU.append(this.permissions);
                sbU.append(", roles=");
                sbU.append(this.roles);
                sbU.append(", rulesChannel=");
                sbU.append(this.rulesChannel);
                sbU.append(", updatesChannel=");
                sbU.append(this.updatesChannel);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final CommunityGuildConfig communityGuildConfig;
            private final int currentPage;
            private final boolean isLoading;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(int i, boolean z2, CommunityGuildConfig communityGuildConfig) {
                super(null);
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "communityGuildConfig");
                this.currentPage = i;
                this.isLoading = z2;
                this.communityGuildConfig = communityGuildConfig;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, int i, boolean z2, CommunityGuildConfig communityGuildConfig, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = loaded.currentPage;
                }
                if ((i2 & 2) != 0) {
                    z2 = loaded.isLoading;
                }
                if ((i2 & 4) != 0) {
                    communityGuildConfig = loaded.communityGuildConfig;
                }
                return loaded.copy(i, z2, communityGuildConfig);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCurrentPage() {
                return this.currentPage;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsLoading() {
                return this.isLoading;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final CommunityGuildConfig getCommunityGuildConfig() {
                return this.communityGuildConfig;
            }

            public final Loaded copy(int currentPage, boolean isLoading, CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "communityGuildConfig");
                return new Loaded(currentPage, isLoading, communityGuildConfig);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.currentPage == loaded.currentPage && this.isLoading == loaded.isLoading && Intrinsics3.areEqual(this.communityGuildConfig, loaded.communityGuildConfig);
            }

            public final CommunityGuildConfig getCommunityGuildConfig() {
                return this.communityGuildConfig;
            }

            public final int getCurrentPage() {
                return this.currentPage;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v2, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r1v7 */
            public int hashCode() {
                int i = this.currentPage * 31;
                boolean z2 = this.isLoading;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i2 = (i + r1) * 31;
                CommunityGuildConfig communityGuildConfig = this.communityGuildConfig;
                return i2 + (communityGuildConfig != null ? communityGuildConfig.hashCode() : 0);
            }

            public final boolean isLoading() {
                return this.isLoading;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(currentPage=");
                sbU.append(this.currentPage);
                sbU.append(", isLoading=");
                sbU.append(this.isLoading);
                sbU.append(", communityGuildConfig=");
                sbU.append(this.communityGuildConfig);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$patchRole$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetServerSettingsEnableCommunityViewModel.this.handleGuildUpdateError();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$patchRole$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ ViewState.Loaded $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$currentViewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            WidgetServerSettingsEnableCommunityViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$currentViewState, 0, false, null, 5, null));
            WidgetServerSettingsEnableCommunityViewModel.this.eventSubject.k.onNext((T) Event.SaveSuccess.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$updateGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetServerSettingsEnableCommunityViewModel.this.handleGuildUpdateError();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$updateGuild$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public final /* synthetic */ CommunityGuildConfig $currentConfig;
        public final /* synthetic */ ViewState.Loaded $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CommunityGuildConfig communityGuildConfig, ViewState.Loaded loaded) {
            super(1);
            this.$currentConfig = communityGuildConfig;
            this.$currentViewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            GuildRole guildRole;
            Intrinsics3.checkNotNullParameter(guild, "it");
            if (this.$currentConfig.getEveryonePermissions()) {
                Map<Long, GuildRole> roles = this.$currentConfig.getRoles();
                WidgetServerSettingsEnableCommunityViewModel.this.patchRole(new RestAPIParams.Role(null, null, null, null, null, Long.valueOf((-1116960071743L) & ((roles == null || (guildRole = roles.get(Long.valueOf(WidgetServerSettingsEnableCommunityViewModel.this.getGuildId()))) == null) ? 0L : guildRole.getPermissions())), guild.getId(), null, Opcodes.IF_ICMPEQ, null));
            } else {
                WidgetServerSettingsEnableCommunityViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$currentViewState, 0, false, null, 5, null));
                WidgetServerSettingsEnableCommunityViewModel.this.eventSubject.k.onNext((T) Event.SaveSuccess.INSTANCE);
            }
        }
    }

    public /* synthetic */ WidgetServerSettingsEnableCommunityViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? Companion.observeStoreState$default(INSTANCE, j, null, null, null, null, 30, null) : observable);
    }

    @MainThread
    private final RestAPIParams.UpdateGuild getUpdatedGuildParams() {
        GuildVerificationLevel verificationLevel;
        GuildVerificationLevel guildVerificationLevel;
        GuildExplicitContentFilter explicitContentFilter;
        GuildExplicitContentFilter guildExplicitContentFilter;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            return new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }
        CommunityGuildConfig communityGuildConfig = loaded.getCommunityGuildConfig();
        List listPlus = _Collections.plus((Collection<? extends GuildFeature>) communityGuildConfig.getFeatures(), GuildFeature.COMMUNITY);
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
        return new RestAPIParams.UpdateGuild(null, null, null, Integer.valueOf(i), null, null, guildVerificationLevel, guildExplicitContentFilter, null, null, null, listPlus, communityGuildConfig.getRulesChannelId(), communityGuildConfig.getUpdatesChannelId(), null, 18231, null);
    }

    private final void handleGuildUpdateError() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, 0, false, null, 5, null));
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(Event.Error.INSTANCE);
        }
    }

    private final void handleStoreState(StoreState storeState) {
        GuildRole guildRole;
        GuildRole guildRole2;
        if (!(storeState instanceof StoreState.Valid)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        Guild guild = valid.getGuild();
        MeUser me2 = valid.getMe();
        if (!(guild.isOwner(me2.getId()) || PermissionUtils.canAndIsElevated(32L, valid.getPermissions(), me2.getMfaEnabled(), guild.getMfaLevel()))) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        Channel rulesChannel = valid.getRulesChannel();
        Channel updatesChannel = valid.getUpdatesChannel();
        boolean z2 = guild.getDefaultMessageNotifications() == 1;
        boolean z3 = guild.getVerificationLevel().compareTo(GuildVerificationLevel.NONE) > 0;
        boolean z4 = guild.getExplicitContentFilter().compareTo(GuildExplicitContentFilter.NONE) > 0;
        Map<Long, GuildRole> roles = valid.getRoles();
        long permissions = (-1116960071743L) & ((roles == null || (guildRole2 = roles.get(Long.valueOf(this.guildId))) == null) ? 0L : guildRole2.getPermissions());
        Map<Long, GuildRole> roles2 = valid.getRoles();
        updateViewState(new ViewState.Loaded(0, false, new CommunityGuildConfig(rulesChannel, updatesChannel, 1L, 1L, false, z2, z3, z4, guild, (roles2 == null || (guildRole = roles2.get(Long.valueOf(this.guildId))) == null || permissions != guildRole.getPermissions()) ? false : true, _Collections.toList(guild.getFeatures()), valid.getRoles())));
    }

    private final void patchRole(RestAPIParams.Role roleParams) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            long j = this.guildId;
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.updateRole(j, j, roleParams), false, 1, null), this, null, 2, null), (Class<?>) WidgetServerSettingsEnableCommunityViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(loaded));
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @MainThread
    public final void goBackToPreviousPage() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateCurrentPage(loaded.getCurrentPage() - 1);
        }
    }

    @MainThread
    public final void modifyGuildConfig(Function1<? super CommunityGuildConfig, CommunityGuildConfig> transform) {
        Intrinsics3.checkNotNullParameter(transform, "transform");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, 0, false, transform.invoke(loaded.getCommunityGuildConfig()), 3, null));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void updateCurrentPage(int currentPage) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, currentPage, false, null, 6, null));
        }
    }

    public final void updateGuild() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            CommunityGuildConfig communityGuildConfig = loaded.getCommunityGuildConfig();
            updateViewState(ViewState.Loaded.copy$default(loaded, 0, true, null, 5, null));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuild(this.guildId, getUpdatedGuildParams()), false, 1, null), this, null, 2, null), (Class<?>) WidgetServerSettingsEnableCommunityViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(communityGuildConfig, loaded));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunityViewModel(long j, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetServerSettingsEnableCommunityViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
