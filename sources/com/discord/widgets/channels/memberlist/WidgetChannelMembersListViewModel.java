package com.discord.widgets.channels.memberlist;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.panels.PanelState;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannelMembers;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMembers;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.memberlist.PrivateChannelMemberListService;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func5;
import rx.functions.Func9;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final GuildChannelSubscriber guildChannelSubscriber;
    private final StoreEmojiCustom storeCustomEmojis;
    private final StoreGuilds storeGuilds;

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetChannelMembersListViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final StoreGuilds storeGuilds, final StoreChannelMembers storeChannelMembers, final StoreThreadMembers storeThreadMembers, StoreChannelsSelected storeChannelsSelected, StoreNavigation storeNavigation, final PrivateChannelMemberListService privateChannelMemberListService, final StorePermissions storePermissions, final StoreUserRelationships storeUserRelationships, final StoreChannels storeChannels, final StoreUser storeUser, final StoreUserPresence storePresence, final StoreApplicationStreaming storeApplicationStreaming, final StoreThreadsJoined storeThreadsJoined) {
            final Observable<R> observableG = storeNavigation.observeRightPanelState().G(new Func1<PanelState, Boolean>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$isPanelOpenObservable$1
                @Override // j0.k.Func1
                public final Boolean call(PanelState panelState) {
                    return Boolean.valueOf(Intrinsics3.areEqual(panelState, PanelState.c.a));
                }
            });
            Observable observableY = storeChannelsSelected.observeSelectedChannel().Y(new Func1<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetChannelMembersListViewModel.StoreState> call(final Channel channel) {
                    if (channel == null) {
                        return observableG.G(new Func1<Boolean, WidgetChannelMembersListViewModel.StoreState.None>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1.1
                            @Override // j0.k.Func1
                            public final WidgetChannelMembersListViewModel.StoreState.None call(Boolean bool) {
                                Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                                return new WidgetChannelMembersListViewModel.StoreState.None(bool.booleanValue());
                            }
                        });
                    }
                    if (ChannelUtils.B(channel)) {
                        return Observable.j(privateChannelMemberListService.observeStateForGroupDm(channel), observableG, new Func2<PrivateChannelMemberListService.State, Boolean, WidgetChannelMembersListViewModel.StoreState.Private>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1.2
                            @Override // rx.functions.Func2
                            public final WidgetChannelMembersListViewModel.StoreState.Private call(PrivateChannelMemberListService.State state, Boolean bool) {
                                Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                                return new WidgetChannelMembersListViewModel.StoreState.Private(bool.booleanValue(), state.getChannel(), state.getUsers(), state.getPresences(), state.getApplicationStreams(), storeUserRelationships.getRelationships());
                            }
                        });
                    }
                    return ChannelUtils.H(channel) ? storeChannels.observeChannel(channel.getParentId()).Y(new Func1<Channel, Observable<? extends WidgetChannelMembersListViewModel.StoreState>>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1.3
                        @Override // j0.k.Func1
                        public final Observable<? extends WidgetChannelMembersListViewModel.StoreState> call(final Channel channel2) {
                            if (channel2 == null) {
                                return observableG.G(new Func1<Boolean, WidgetChannelMembersListViewModel.StoreState.None>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.Companion.observeStoreState.1.3.1
                                    @Override // j0.k.Func1
                                    public final WidgetChannelMembersListViewModel.StoreState.None call(Boolean bool) {
                                        Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                                        return new WidgetChannelMembersListViewModel.StoreState.None(bool.booleanValue());
                                    }
                                });
                            }
                            if (!ChannelUtils.i(channel2)) {
                                Observable<Set<Long>> observableObserveThreadMembers = storeThreadMembers.observeThreadMembers(channel.getId());
                                WidgetChannelMembersListViewModel2 widgetChannelMembersListViewModel2 = WidgetChannelMembersListViewModel2.this;
                                return Observable.c(observableObserveThreadMembers, observableG, storeGuilds.observeRoles(channel.getGuildId()), storeGuilds.observeGuildMembers(channel.getGuildId()), storeGuilds.observeGuild(channel.getGuildId()), storeUser.observeAllUsers(), storePresence.observeAllPresences(), storeApplicationStreaming.observeStreamsByUser(), storeThreadsJoined.observeJoinedThread(channel.getId()), new Func9<Set<? extends Long>, Boolean, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, StoreThreadsJoined.JoinedThread, WidgetChannelMembersListViewModel.StoreState.Thread>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.Companion.observeStoreState.1.3.3
                                    @Override // rx.functions.Func9
                                    public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Thread call(Set<? extends Long> set, Boolean bool, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, ? extends Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined.JoinedThread joinedThread) {
                                        return call2((Set<Long>) set, bool, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, guild, map3, (Map<Long, Presence>) map4, map5, joinedThread);
                                    }

                                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                                    public final WidgetChannelMembersListViewModel.StoreState.Thread call2(Set<Long> set, Boolean bool, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined.JoinedThread joinedThread) {
                                        Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                                        boolean zBooleanValue = bool.booleanValue();
                                        Channel channel3 = channel;
                                        Channel channel4 = channel2;
                                        Intrinsics3.checkNotNullExpressionValue(map, "roles");
                                        Intrinsics3.checkNotNullExpressionValue(map2, "guildMembers");
                                        Intrinsics3.checkNotNullExpressionValue(map3, "users");
                                        Intrinsics3.checkNotNullExpressionValue(map4, "presences");
                                        Intrinsics3.checkNotNullExpressionValue(map5, "streams");
                                        Intrinsics3.checkNotNullExpressionValue(set, "threadMembers");
                                        return new WidgetChannelMembersListViewModel.StoreState.Thread(zBooleanValue, channel3, channel4, guild, map, map2, map3, map4, map5, set, joinedThread);
                                    }
                                });
                            }
                            Observable<Long> observableObservePermissionsForChannel = storePermissions.observePermissionsForChannel(channel2.getId());
                            Observable<ChannelMemberList> observableObserveChannelMemberList = storeChannelMembers.observeChannelMemberList(channel2.getGuildId(), channel2.getId());
                            WidgetChannelMembersListViewModel2 widgetChannelMembersListViewModel3 = WidgetChannelMembersListViewModel2.this;
                            return Observable.g(observableObservePermissionsForChannel, observableObserveChannelMemberList, observableG, storeGuilds.observeRoles(channel.getGuildId()), storeGuilds.observeGuild(channel.getGuildId()), new Func5<Long, ChannelMemberList, Boolean, Map<Long, ? extends GuildRole>, Guild, WidgetChannelMembersListViewModel.StoreState.Guild>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.Companion.observeStoreState.1.3.2
                                @Override // rx.functions.Func5
                                public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Guild call(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, ? extends GuildRole> map, Guild guild) {
                                    return call2(l, channelMemberList, bool, (Map<Long, GuildRole>) map, guild);
                                }

                                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                                public final WidgetChannelMembersListViewModel.StoreState.Guild call2(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, GuildRole> map, Guild guild) {
                                    Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                                    boolean zBooleanValue = bool.booleanValue();
                                    Channel channel3 = channel2;
                                    Intrinsics3.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
                                    Intrinsics3.checkNotNullExpressionValue(map, "roles");
                                    return new WidgetChannelMembersListViewModel.StoreState.Guild(zBooleanValue, channel3, guild, channelMemberList, l, map);
                                }
                            });
                        }
                    }) : Observable.g(storeGuilds.observeGuild(channel.getGuildId()), storeGuilds.observeRoles(channel.getGuildId()), storePermissions.observePermissionsForChannel(channel.getId()), storeChannelMembers.observeChannelMemberList(channel.getGuildId(), channel.getId()), observableG, new Func5<Guild, Map<Long, ? extends GuildRole>, Long, ChannelMemberList, Boolean, WidgetChannelMembersListViewModel.StoreState.Guild>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1.4
                        @Override // rx.functions.Func5
                        public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Guild call(Guild guild, Map<Long, ? extends GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
                            return call2(guild, (Map<Long, GuildRole>) map, l, channelMemberList, bool);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetChannelMembersListViewModel.StoreState.Guild call2(Guild guild, Map<Long, GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
                            Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                            boolean zBooleanValue = bool.booleanValue();
                            Channel channel2 = channel;
                            Intrinsics3.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
                            Intrinsics3.checkNotNullExpressionValue(map, "guildRoles");
                            return new WidgetChannelMembersListViewModel.StoreState.Guild(zBooleanValue, channel2, guild, channelMemberList, l, map);
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannelsSelected\n  …            }\n          }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreGuilds storeGuilds, StoreChannelMembers storeChannelMembers, StoreThreadMembers storeThreadMembers, StoreChannelsSelected storeChannelsSelected, StoreNavigation storeNavigation, PrivateChannelMemberListService privateChannelMemberListService, StorePermissions storePermissions, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined, int i, Object obj) {
            return companion.observeStoreState((i & 1) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 2) != 0 ? StoreStream.INSTANCE.getChannelMembers() : storeChannelMembers, (i & 4) != 0 ? StoreStream.INSTANCE.getThreadMembers() : storeThreadMembers, (i & 8) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 16) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation, (i & 32) != 0 ? new PrivateChannelMemberListService(null, null, null, 7, null) : privateChannelMemberListService, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 128) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships, (i & 256) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 512) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 1024) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 2048) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 4096) != 0 ? StoreStream.INSTANCE.getThreadsJoined() : storeThreadsJoined);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Error extends Event {
            private final int code;

            public Error(int i) {
                super(null);
                this.code = i;
            }

            public static /* synthetic */ Error copy$default(Error error, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = error.code;
                }
                return error.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            public final Error copy(int code) {
                return new Error(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && this.code == ((Error) other).code;
                }
                return true;
            }

            public final int getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code;
            }

            public String toString() {
                return outline.B(outline.U("Error(code="), this.code, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final class ScrollToTop extends Event {
            public static final ScrollToTop INSTANCE = new ScrollToTop();

            private ScrollToTop() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final class UpdateRanges extends Event {
            public static final UpdateRanges INSTANCE = new UpdateRanges();

            private UpdateRanges() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public interface GuildChannelSubscriber {
        void subscribeToChannelRange(Channel channel, Ranges2 range);

        void subscribeToThread(Channel channel);
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public interface MemberList {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final MemberList EMPTY = new MemberList() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList$Companion$EMPTY$1
                private final String listId = "";
                private final int size;

                @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
                public ChannelMembersListAdapter.Item get(int index) {
                    throw new IllegalStateException("");
                }

                @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
                public Integer getHeaderPositionForItem(int itemPosition) {
                    return 0;
                }

                @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
                public String getListId() {
                    return this.listId;
                }

                @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
                public int getSize() {
                    return this.size;
                }
            };

            private Companion() {
            }

            public final MemberList getEMPTY() {
                return EMPTY;
            }
        }

        ChannelMembersListAdapter.Item get(int index);

        Integer getHeaderPositionForItem(int itemPosition);

        String getListId();

        int getSize();
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static abstract class StoreState {
        private final Channel channel;
        private final boolean isPanelOpen;

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Guild extends StoreState {
            private final Channel channel;
            private final ChannelMemberList channelMembers;
            private final Long channelPermissions;
            private final com.discord.models.guild.Guild guild;
            private final Map<Long, GuildRole> guildRoles;
            private final boolean isPanelOpen;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Guild(boolean z2, Channel channel, com.discord.models.guild.Guild guild, ChannelMemberList channelMemberList, Long l, Map<Long, GuildRole> map) {
                super(z2, channel, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(channelMemberList, "channelMembers");
                Intrinsics3.checkNotNullParameter(map, "guildRoles");
                this.isPanelOpen = z2;
                this.channel = channel;
                this.guild = guild;
                this.channelMembers = channelMemberList;
                this.channelPermissions = l;
                this.guildRoles = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Guild copy$default(Guild guild, boolean z2, Channel channel, com.discord.models.guild.Guild guild2, ChannelMemberList channelMemberList, Long l, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = guild.getIsPanelOpen();
                }
                if ((i & 2) != 0) {
                    channel = guild.getChannel();
                }
                Channel channel2 = channel;
                if ((i & 4) != 0) {
                    guild2 = guild.guild;
                }
                com.discord.models.guild.Guild guild3 = guild2;
                if ((i & 8) != 0) {
                    channelMemberList = guild.channelMembers;
                }
                ChannelMemberList channelMemberList2 = channelMemberList;
                if ((i & 16) != 0) {
                    l = guild.channelPermissions;
                }
                Long l2 = l;
                if ((i & 32) != 0) {
                    map = guild.guildRoles;
                }
                return guild.copy(z2, channel2, guild3, channelMemberList2, l2, map);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final Channel component2() {
                return getChannel();
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final ChannelMemberList getChannelMembers() {
                return this.channelMembers;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final Map<Long, GuildRole> component6() {
                return this.guildRoles;
            }

            public final Guild copy(boolean isPanelOpen, Channel channel, com.discord.models.guild.Guild guild, ChannelMemberList channelMembers, Long channelPermissions, Map<Long, GuildRole> guildRoles) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(channelMembers, "channelMembers");
                Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
                return new Guild(isPanelOpen, channel, guild, channelMembers, channelPermissions, guildRoles);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Guild)) {
                    return false;
                }
                Guild guild = (Guild) other;
                return getIsPanelOpen() == guild.getIsPanelOpen() && Intrinsics3.areEqual(getChannel(), guild.getChannel()) && Intrinsics3.areEqual(this.guild, guild.guild) && Intrinsics3.areEqual(this.channelMembers, guild.channelMembers) && Intrinsics3.areEqual(this.channelPermissions, guild.channelPermissions) && Intrinsics3.areEqual(this.guildRoles, guild.guildRoles);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            public Channel getChannel() {
                return this.channel;
            }

            public final ChannelMemberList getChannelMembers() {
                return this.channelMembers;
            }

            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                int i = isPanelOpen;
                if (isPanelOpen) {
                    i = 1;
                }
                int i2 = i * 31;
                Channel channel = getChannel();
                int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                com.discord.models.guild.Guild guild = this.guild;
                int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
                ChannelMemberList channelMemberList = this.channelMembers;
                int iHashCode3 = (iHashCode2 + (channelMemberList != null ? channelMemberList.hashCode() : 0)) * 31;
                Long l = this.channelPermissions;
                int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.guildRoles;
                return iHashCode4 + (map != null ? map.hashCode() : 0);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Guild(isPanelOpen=");
                sbU.append(getIsPanelOpen());
                sbU.append(", channel=");
                sbU.append(getChannel());
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", channelMembers=");
                sbU.append(this.channelMembers);
                sbU.append(", channelPermissions=");
                sbU.append(this.channelPermissions);
                sbU.append(", guildRoles=");
                return outline.M(sbU, this.guildRoles, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class None extends StoreState {
            private final boolean isPanelOpen;

            /* JADX WARN: Multi-variable type inference failed */
            public None(boolean z2) {
                super(z2, null, 0 == true ? 1 : 0);
                this.isPanelOpen = z2;
            }

            public static /* synthetic */ None copy$default(None none, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = none.getIsPanelOpen();
                }
                return none.copy(z2);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final None copy(boolean isPanelOpen) {
                return new None(isPanelOpen);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof None) && getIsPanelOpen() == ((None) other).getIsPanelOpen();
                }
                return true;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                if (isPanelOpen) {
                    return 1;
                }
                return isPanelOpen ? 1 : 0;
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbU = outline.U("None(isPanelOpen=");
                sbU.append(getIsPanelOpen());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Private extends StoreState {
            private final Map<Long, ModelApplicationStream> applicationStreams;
            private final Channel channel;
            private final boolean isPanelOpen;
            private final Map<Long, Presence> presences;
            private final Map<Long, Integer> relationships;
            private final Map<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Private(boolean z2, Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, Map<Long, Integer> map4) {
                super(z2, channel, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "users");
                Intrinsics3.checkNotNullParameter(map2, "presences");
                Intrinsics3.checkNotNullParameter(map3, "applicationStreams");
                Intrinsics3.checkNotNullParameter(map4, "relationships");
                this.isPanelOpen = z2;
                this.channel = channel;
                this.users = map;
                this.presences = map2;
                this.applicationStreams = map3;
                this.relationships = map4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Private copy$default(Private r4, boolean z2, Channel channel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = r4.getIsPanelOpen();
                }
                if ((i & 2) != 0) {
                    channel = r4.getChannel();
                }
                Channel channel2 = channel;
                if ((i & 4) != 0) {
                    map = r4.users;
                }
                Map map5 = map;
                if ((i & 8) != 0) {
                    map2 = r4.presences;
                }
                Map map6 = map2;
                if ((i & 16) != 0) {
                    map3 = r4.applicationStreams;
                }
                Map map7 = map3;
                if ((i & 32) != 0) {
                    map4 = r4.relationships;
                }
                return r4.copy(z2, channel2, map5, map6, map7, map4);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final Channel component2() {
                return getChannel();
            }

            public final Map<Long, User> component3() {
                return this.users;
            }

            public final Map<Long, Presence> component4() {
                return this.presences;
            }

            public final Map<Long, ModelApplicationStream> component5() {
                return this.applicationStreams;
            }

            public final Map<Long, Integer> component6() {
                return this.relationships;
            }

            public final Private copy(boolean isPanelOpen, Channel channel, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, Map<Long, Integer> relationships) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(presences, "presences");
                Intrinsics3.checkNotNullParameter(applicationStreams, "applicationStreams");
                Intrinsics3.checkNotNullParameter(relationships, "relationships");
                return new Private(isPanelOpen, channel, users, presences, applicationStreams, relationships);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Private)) {
                    return false;
                }
                Private r3 = (Private) other;
                return getIsPanelOpen() == r3.getIsPanelOpen() && Intrinsics3.areEqual(getChannel(), r3.getChannel()) && Intrinsics3.areEqual(this.users, r3.users) && Intrinsics3.areEqual(this.presences, r3.presences) && Intrinsics3.areEqual(this.applicationStreams, r3.applicationStreams) && Intrinsics3.areEqual(this.relationships, r3.relationships);
            }

            public final Map<Long, ModelApplicationStream> getApplicationStreams() {
                return this.applicationStreams;
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            public Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, Presence> getPresences() {
                return this.presences;
            }

            public final Map<Long, Integer> getRelationships() {
                return this.relationships;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                int i = isPanelOpen;
                if (isPanelOpen) {
                    i = 1;
                }
                int i2 = i * 31;
                Channel channel = getChannel();
                int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                Map<Long, User> map = this.users;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, Presence> map2 = this.presences;
                int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
                int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, Integer> map4 = this.relationships;
                return iHashCode4 + (map4 != null ? map4.hashCode() : 0);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Private(isPanelOpen=");
                sbU.append(getIsPanelOpen());
                sbU.append(", channel=");
                sbU.append(getChannel());
                sbU.append(", users=");
                sbU.append(this.users);
                sbU.append(", presences=");
                sbU.append(this.presences);
                sbU.append(", applicationStreams=");
                sbU.append(this.applicationStreams);
                sbU.append(", relationships=");
                return outline.M(sbU, this.relationships, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Thread extends StoreState {
            private final Channel channel;
            private final com.discord.models.guild.Guild guild;
            private final Map<Long, GuildMember> guildMembers;
            private final boolean isPanelOpen;
            private final StoreThreadsJoined.JoinedThread joinedThread;
            private final Channel parentChannel;
            private final Map<Long, Presence> presences;
            private final Map<Long, GuildRole> roles;
            private final Map<Long, ModelApplicationStream> streams;
            private final Set<Long> threadMembers;
            private final Map<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Thread(boolean z2, Channel channel, Channel channel2, com.discord.models.guild.Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, Set<Long> set, StoreThreadsJoined.JoinedThread joinedThread) {
                super(z2, channel, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "roles");
                Intrinsics3.checkNotNullParameter(map2, "guildMembers");
                Intrinsics3.checkNotNullParameter(map3, "users");
                Intrinsics3.checkNotNullParameter(map4, "presences");
                Intrinsics3.checkNotNullParameter(map5, "streams");
                Intrinsics3.checkNotNullParameter(set, "threadMembers");
                this.isPanelOpen = z2;
                this.channel = channel;
                this.parentChannel = channel2;
                this.guild = guild;
                this.roles = map;
                this.guildMembers = map2;
                this.users = map3;
                this.presences = map4;
                this.streams = map5;
                this.threadMembers = set;
                this.joinedThread = joinedThread;
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final Set<Long> component10() {
                return this.threadMembers;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final StoreThreadsJoined.JoinedThread getJoinedThread() {
                return this.joinedThread;
            }

            public final Channel component2() {
                return getChannel();
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildRole> component5() {
                return this.roles;
            }

            public final Map<Long, GuildMember> component6() {
                return this.guildMembers;
            }

            public final Map<Long, User> component7() {
                return this.users;
            }

            public final Map<Long, Presence> component8() {
                return this.presences;
            }

            public final Map<Long, ModelApplicationStream> component9() {
                return this.streams;
            }

            public final Thread copy(boolean isPanelOpen, Channel channel, Channel parentChannel, com.discord.models.guild.Guild guild, Map<Long, GuildRole> roles, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> streams, Set<Long> threadMembers, StoreThreadsJoined.JoinedThread joinedThread) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(roles, "roles");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(presences, "presences");
                Intrinsics3.checkNotNullParameter(streams, "streams");
                Intrinsics3.checkNotNullParameter(threadMembers, "threadMembers");
                return new Thread(isPanelOpen, channel, parentChannel, guild, roles, guildMembers, users, presences, streams, threadMembers, joinedThread);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Thread)) {
                    return false;
                }
                Thread thread = (Thread) other;
                return getIsPanelOpen() == thread.getIsPanelOpen() && Intrinsics3.areEqual(getChannel(), thread.getChannel()) && Intrinsics3.areEqual(this.parentChannel, thread.parentChannel) && Intrinsics3.areEqual(this.guild, thread.guild) && Intrinsics3.areEqual(this.roles, thread.roles) && Intrinsics3.areEqual(this.guildMembers, thread.guildMembers) && Intrinsics3.areEqual(this.users, thread.users) && Intrinsics3.areEqual(this.presences, thread.presences) && Intrinsics3.areEqual(this.streams, thread.streams) && Intrinsics3.areEqual(this.threadMembers, thread.threadMembers) && Intrinsics3.areEqual(this.joinedThread, thread.joinedThread);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            public Channel getChannel() {
                return this.channel;
            }

            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final StoreThreadsJoined.JoinedThread getJoinedThread() {
                return this.joinedThread;
            }

            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            public final Map<Long, Presence> getPresences() {
                return this.presences;
            }

            public final Map<Long, GuildRole> getRoles() {
                return this.roles;
            }

            public final Map<Long, ModelApplicationStream> getStreams() {
                return this.streams;
            }

            public final Set<Long> getThreadMembers() {
                return this.threadMembers;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                int i = isPanelOpen;
                if (isPanelOpen) {
                    i = 1;
                }
                int i2 = i * 31;
                Channel channel = getChannel();
                int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                Channel channel2 = this.parentChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                com.discord.models.guild.Guild guild = this.guild;
                int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.roles;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, GuildMember> map2 = this.guildMembers;
                int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, User> map3 = this.users;
                int iHashCode6 = (iHashCode5 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, Presence> map4 = this.presences;
                int iHashCode7 = (iHashCode6 + (map4 != null ? map4.hashCode() : 0)) * 31;
                Map<Long, ModelApplicationStream> map5 = this.streams;
                int iHashCode8 = (iHashCode7 + (map5 != null ? map5.hashCode() : 0)) * 31;
                Set<Long> set = this.threadMembers;
                int iHashCode9 = (iHashCode8 + (set != null ? set.hashCode() : 0)) * 31;
                StoreThreadsJoined.JoinedThread joinedThread = this.joinedThread;
                return iHashCode9 + (joinedThread != null ? joinedThread.hashCode() : 0);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Thread(isPanelOpen=");
                sbU.append(getIsPanelOpen());
                sbU.append(", channel=");
                sbU.append(getChannel());
                sbU.append(", parentChannel=");
                sbU.append(this.parentChannel);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", roles=");
                sbU.append(this.roles);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", users=");
                sbU.append(this.users);
                sbU.append(", presences=");
                sbU.append(this.presences);
                sbU.append(", streams=");
                sbU.append(this.streams);
                sbU.append(", threadMembers=");
                sbU.append(this.threadMembers);
                sbU.append(", joinedThread=");
                sbU.append(this.joinedThread);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState(boolean z2, Channel channel) {
            this.isPanelOpen = z2;
            this.channel = channel;
        }

        public Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
        public boolean getIsPanelOpen() {
            return this.isPanelOpen;
        }

        public /* synthetic */ StoreState(boolean z2, Channel channel, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, channel);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static abstract class ViewState {
        private final String listId;

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final class Empty extends ViewState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super("empty", null);
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final boolean isOpen;
            private final boolean isThreadJoined;
            private final MemberList listItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(MemberList memberList, boolean z2, Channel channel, boolean z3) {
                super(memberList.getListId(), null);
                Intrinsics3.checkNotNullParameter(memberList, "listItems");
                this.listItems = memberList;
                this.isOpen = z2;
                this.channel = channel;
                this.isThreadJoined = z3;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, MemberList memberList, boolean z2, Channel channel, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    memberList = loaded.listItems;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.isOpen;
                }
                if ((i & 4) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 8) != 0) {
                    z3 = loaded.isThreadJoined;
                }
                return loaded.copy(memberList, z2, channel, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MemberList getListItems() {
                return this.listItems;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsOpen() {
                return this.isOpen;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsThreadJoined() {
                return this.isThreadJoined;
            }

            public final Loaded copy(MemberList listItems, boolean isOpen, Channel channel, boolean isThreadJoined) {
                Intrinsics3.checkNotNullParameter(listItems, "listItems");
                return new Loaded(listItems, isOpen, channel, isThreadJoined);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.listItems, loaded.listItems) && this.isOpen == loaded.isOpen && Intrinsics3.areEqual(this.channel, loaded.channel) && this.isThreadJoined == loaded.isThreadJoined;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final MemberList getListItems() {
                return this.listItems;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                MemberList memberList = this.listItems;
                int iHashCode = (memberList != null ? memberList.hashCode() : 0) * 31;
                boolean z2 = this.isOpen;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                Channel channel = this.channel;
                int iHashCode2 = (i + (channel != null ? channel.hashCode() : 0)) * 31;
                boolean z3 = this.isThreadJoined;
                return iHashCode2 + (z3 ? 1 : z3);
            }

            public final boolean isOpen() {
                return this.isOpen;
            }

            public final boolean isThreadJoined() {
                return this.isThreadJoined;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(listItems=");
                sbU.append(this.listItems);
                sbU.append(", isOpen=");
                sbU.append(this.isOpen);
                sbU.append(", channel=");
                sbU.append(this.channel);
                sbU.append(", isThreadJoined=");
                return outline.O(sbU, this.isThreadJoined, ")");
            }
        }

        private ViewState(String str) {
            this.listId = str;
        }

        public final String getListId() {
            return this.listId;
        }

        public /* synthetic */ ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            PublishSubject publishSubject = WidgetChannelMembersListViewModel.this.eventSubject;
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            publishSubject.k.onNext((T) new Event.Error(response.getCode()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            PublishSubject publishSubject = WidgetChannelMembersListViewModel.this.eventSubject;
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            publishSubject.k.onNext((T) new Event.Error(response.getCode()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    public WidgetChannelMembersListViewModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelMembersListViewModel(GuildChannelSubscriber guildChannelSubscriber, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState$default;
        StoreEmojiCustom storeEmojiCustom2;
        GuildChannelSubscriber guildChannelSubscriber2 = (i & 1) != 0 ? new GuildChannelSubscriber() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.1
            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.GuildChannelSubscriber
            public void subscribeToChannelRange(Channel channel, Ranges2 range) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(range, "range");
                StoreStream.INSTANCE.getGuildSubscriptions().subscribeChannelRange(channel.getGuildId(), channel.getId(), range);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.GuildChannelSubscriber
            public void subscribeToThread(Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                StoreStream.INSTANCE.getGuildSubscriptions().subscribeThread(channel.getGuildId(), channel.getId());
            }
        } : guildChannelSubscriber;
        StoreGuilds guilds = (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreEmojiCustom customEmojis = (i & 4) != 0 ? StoreStream.INSTANCE.getCustomEmojis() : storeEmojiCustom;
        if ((i & 8) != 0) {
            observableObserveStoreState$default = Companion.observeStoreState$default(INSTANCE, guilds, null, null, null, null, null, null, null, null, null, null, null, null, 8190, null);
            storeEmojiCustom2 = customEmojis;
        } else {
            observableObserveStoreState$default = observable;
            storeEmojiCustom2 = customEmojis;
        }
        this(guildChannelSubscriber2, guilds, storeEmojiCustom2, observableObserveStoreState$default);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        MemberList memberListGenerateThreadMemberListItems;
        if (storeState instanceof StoreState.None) {
            updateViewState(ViewState.Empty.INSTANCE);
            return;
        }
        boolean z2 = false;
        if (storeState instanceof StoreState.Guild) {
            StoreState.Guild guild = (StoreState.Guild) storeState;
            memberListGenerateThreadMemberListItems = GuildMemberListItemGenerator.generateGuildMemberListItems(guild.getChannelMembers(), guild.getGuild(), guild.getChannel(), guild.getGuildRoles(), PermissionUtils.can(1L, guild.getChannelPermissions()), false, this.storeGuilds, this.storeCustomEmojis);
        } else if (storeState instanceof StoreState.Private) {
            StoreState.Private r0 = (StoreState.Private) storeState;
            Map<Long, Integer> relationships = r0.getRelationships();
            User userA = ChannelUtils.a(r0.getChannel());
            memberListGenerateThreadMemberListItems = PrivateChannelMemberListItemGenerator.generateGroupDmMemberListItems(r0.getChannel(), r0.getUsers(), r0.getPresences(), r0.getApplicationStreams(), ChannelUtils.p(r0.getChannel()) || ModelUserRelationship.isType(relationships.get(userA != null ? Long.valueOf(userA.getId()) : null), 1));
        } else {
            if (!(storeState instanceof StoreState.Thread)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreState.Thread thread = (StoreState.Thread) storeState;
            memberListGenerateThreadMemberListItems = ThreadMemberListItemGenerator.generateThreadMemberListItems(thread.getChannel(), thread.getRoles(), thread.getGuild(), thread.getGuildMembers(), thread.getUsers(), thread.getPresences(), thread.getStreams(), thread.getThreadMembers(), thread.getJoinedThread(), this.storeGuilds, this.storeCustomEmojis);
        }
        ViewState viewState = getViewState();
        boolean isPanelOpen = storeState.getIsPanelOpen();
        Channel channel = storeState.getChannel();
        if ((storeState instanceof StoreState.Thread) && ((StoreState.Thread) storeState).getJoinedThread() != null) {
            z2 = true;
        }
        ViewState.Loaded loaded = new ViewState.Loaded(memberListGenerateThreadMemberListItems, isPanelOpen, channel, z2);
        updateViewState(loaded);
        updateSubscriptions(viewState, loaded, storeState);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onThreadJoinLeaveClicked(long channelId, boolean isThreadJoined) {
        if (isThreadJoined) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channelId, "Thread Member List"), false, 1, null), this, null, 2, null), (Class<?>) WidgetChannelMembersListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass2.INSTANCE);
            StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinThread(channelId, "Thread Member List", new RestAPIParams.EmptyBody()), false, 1, null), (Class<?>) WidgetChannelMembersListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass4.INSTANCE);
        StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
    }

    public final void updateSubscriptions(ViewState prevViewState, ViewState.Loaded newViewState, StoreState storeState) {
        Intrinsics3.checkNotNullParameter(newViewState, "newViewState");
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        boolean z2 = (Intrinsics3.areEqual(prevViewState != null ? prevViewState.getListId() : null, newViewState.getListId()) ^ true) && storeState.getIsPanelOpen();
        Channel channel = newViewState.getChannel();
        if (channel != null && ChannelUtils.H(channel)) {
            if (z2) {
                this.eventSubject.k.onNext(Event.ScrollToTop.INSTANCE);
                updateSubscriptionsForThread(newViewState.getChannel());
                return;
            } else {
                if ((prevViewState instanceof ViewState.Loaded) && !((ViewState.Loaded) prevViewState).isOpen() && newViewState.isOpen()) {
                    updateSubscriptionsForThread(newViewState.getChannel());
                    return;
                }
                return;
            }
        }
        if (z2) {
            this.eventSubject.k.onNext(Event.ScrollToTop.INSTANCE);
            updateSubscriptionsForChannel(new Ranges2(0, 99));
        } else if ((prevViewState instanceof ViewState.Loaded) && !((ViewState.Loaded) prevViewState).isOpen() && newViewState.isOpen()) {
            this.eventSubject.k.onNext(Event.UpdateRanges.INSTANCE);
        }
    }

    @MainThread
    public final void updateSubscriptionsForChannel(Ranges2 range) {
        Intrinsics3.checkNotNullParameter(range, "range");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || loaded.getChannel() == null || !loaded.isOpen()) {
            return;
        }
        this.guildChannelSubscriber.subscribeToChannelRange(loaded.getChannel(), range);
    }

    public final void updateSubscriptionsForThread(Channel channel) {
        if (channel == null || ChannelUtils.j(channel)) {
            return;
        }
        Intrinsics3.checkNotNullParameter(channel, "$this$isAnnouncementThread");
        if (channel.getType() == 10) {
            return;
        }
        this.guildChannelSubscriber.subscribeToThread(channel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersListViewModel(GuildChannelSubscriber guildChannelSubscriber, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Observable<StoreState> observable) {
        super(ViewState.Empty.INSTANCE);
        Intrinsics3.checkNotNullParameter(guildChannelSubscriber, "guildChannelSubscriber");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "storeCustomEmojis");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildChannelSubscriber = guildChannelSubscriber;
        this.storeGuilds = storeGuilds;
        this.storeCustomEmojis = storeEmojiCustom;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetChannelMembersListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
