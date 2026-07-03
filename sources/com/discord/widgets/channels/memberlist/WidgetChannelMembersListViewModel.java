package com.discord.widgets.channels.memberlist;

import androidx.annotation.MainThread;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.channels.memberlist.PrivateChannelMemberListService;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.functions.Func5;
import p658rx.functions.Func9;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final GuildChannelSubscriber guildChannelSubscriber;
    private final StoreEmojiCustom storeCustomEmojis;
    private final StoreGuilds storeGuilds;

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$2 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C74952 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C74952() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            WidgetChannelMembersListViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final StoreGuilds storeGuilds, final StoreChannelMembers storeChannelMembers, final StoreThreadMembers storeThreadMembers, StoreChannelsSelected storeChannelsSelected, StoreNavigation storeNavigation, final PrivateChannelMemberListService privateChannelMemberListService, final StorePermissions storePermissions, final StoreUserRelationships storeUserRelationships, final StoreChannels storeChannels, final StoreUser storeUser, final StoreUserPresence storePresence, final StoreApplicationStreaming storeApplicationStreaming, final StoreThreadsJoined storeThreadsJoined) {
            final Observable<R> observableM11083G = storeNavigation.observeRightPanelState().m11083G(new InterfaceC12589b<PanelState, Boolean>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$isPanelOpenObservable$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(PanelState panelState) {
                    return Boolean.valueOf(C12238m.areEqual(panelState, PanelState.C5580c.f18642a));
                }
            });
            Observable observableM11099Y = storeChannelsSelected.observeSelectedChannel().m11099Y(new InterfaceC12589b<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetChannelMembersListViewModel.StoreState> call(final Channel channel) {
                    if (channel == null) {
                        return observableM11083G.m11083G(new InterfaceC12589b<Boolean, WidgetChannelMembersListViewModel.StoreState.None>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final WidgetChannelMembersListViewModel.StoreState.None call(Boolean bool) {
                                C12238m.checkNotNullExpressionValue(bool, "isPanelOpen");
                                return new WidgetChannelMembersListViewModel.StoreState.None(bool.booleanValue());
                            }
                        });
                    }
                    if (ChannelUtils.m7667B(channel)) {
                        return Observable.m11076j(privateChannelMemberListService.observeStateForGroupDm(channel), observableM11083G, new Func2<PrivateChannelMemberListService.State, Boolean, WidgetChannelMembersListViewModel.StoreState.Private>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1.2
                            @Override // p658rx.functions.Func2
                            public final WidgetChannelMembersListViewModel.StoreState.Private call(PrivateChannelMemberListService.State state, Boolean bool) {
                                C12238m.checkNotNullExpressionValue(bool, "isPanelOpen");
                                return new WidgetChannelMembersListViewModel.StoreState.Private(bool.booleanValue(), state.getChannel(), state.getUsers(), state.getPresences(), state.getApplicationStreams(), storeUserRelationships.getRelationships());
                            }
                        });
                    }
                    return ChannelUtils.m7673H(channel) ? storeChannels.observeChannel(channel.getParentId()).m11099Y(new InterfaceC12589b<Channel, Observable<? extends WidgetChannelMembersListViewModel.StoreState>>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1.3
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Observable<? extends WidgetChannelMembersListViewModel.StoreState> call(final Channel channel2) {
                            if (channel2 == null) {
                                return observableM11083G.m11083G(new InterfaceC12589b<Boolean, WidgetChannelMembersListViewModel.StoreState.None>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.Companion.observeStoreState.1.3.1
                                    @Override // p637j0.p641k.InterfaceC12589b
                                    public final WidgetChannelMembersListViewModel.StoreState.None call(Boolean bool) {
                                        C12238m.checkNotNullExpressionValue(bool, "isPanelOpen");
                                        return new WidgetChannelMembersListViewModel.StoreState.None(bool.booleanValue());
                                    }
                                });
                            }
                            if (!ChannelUtils.m7685i(channel2)) {
                                Observable<Set<Long>> observableObserveThreadMembers = storeThreadMembers.observeThreadMembers(channel.getId());
                                WidgetChannelMembersListViewModel$Companion$observeStoreState$1 widgetChannelMembersListViewModel$Companion$observeStoreState$1 = WidgetChannelMembersListViewModel$Companion$observeStoreState$1.this;
                                return Observable.m11066c(observableObserveThreadMembers, observableM11083G, storeGuilds.observeRoles(channel.getGuildId()), storeGuilds.observeGuildMembers(channel.getGuildId()), storeGuilds.observeGuild(channel.getGuildId()), storeUser.observeAllUsers(), storePresence.observeAllPresences(), storeApplicationStreaming.observeStreamsByUser(), storeThreadsJoined.observeJoinedThread(channel.getId()), new Func9<Set<? extends Long>, Boolean, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, StoreThreadsJoined.JoinedThread, WidgetChannelMembersListViewModel.StoreState.Thread>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.Companion.observeStoreState.1.3.3
                                    @Override // p658rx.functions.Func9
                                    public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Thread call(Set<? extends Long> set, Boolean bool, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, ? extends Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined.JoinedThread joinedThread) {
                                        return call2((Set<Long>) set, bool, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, guild, map3, (Map<Long, Presence>) map4, map5, joinedThread);
                                    }

                                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                                    public final WidgetChannelMembersListViewModel.StoreState.Thread call2(Set<Long> set, Boolean bool, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined.JoinedThread joinedThread) {
                                        C12238m.checkNotNullExpressionValue(bool, "isPanelOpen");
                                        boolean zBooleanValue = bool.booleanValue();
                                        Channel channel3 = channel;
                                        Channel channel4 = channel2;
                                        C12238m.checkNotNullExpressionValue(map, "roles");
                                        C12238m.checkNotNullExpressionValue(map2, "guildMembers");
                                        C12238m.checkNotNullExpressionValue(map3, "users");
                                        C12238m.checkNotNullExpressionValue(map4, "presences");
                                        C12238m.checkNotNullExpressionValue(map5, "streams");
                                        C12238m.checkNotNullExpressionValue(set, "threadMembers");
                                        return new WidgetChannelMembersListViewModel.StoreState.Thread(zBooleanValue, channel3, channel4, guild, map, map2, map3, map4, map5, set, joinedThread);
                                    }
                                });
                            }
                            Observable<Long> observableObservePermissionsForChannel = storePermissions.observePermissionsForChannel(channel2.getId());
                            Observable<ChannelMemberList> observableObserveChannelMemberList = storeChannelMembers.observeChannelMemberList(channel2.getGuildId(), channel2.getId());
                            WidgetChannelMembersListViewModel$Companion$observeStoreState$1 widgetChannelMembersListViewModel$Companion$observeStoreState$2 = WidgetChannelMembersListViewModel$Companion$observeStoreState$1.this;
                            return Observable.m11072g(observableObservePermissionsForChannel, observableObserveChannelMemberList, observableM11083G, storeGuilds.observeRoles(channel.getGuildId()), storeGuilds.observeGuild(channel.getGuildId()), new Func5<Long, ChannelMemberList, Boolean, Map<Long, ? extends GuildRole>, Guild, WidgetChannelMembersListViewModel.StoreState.Guild>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.Companion.observeStoreState.1.3.2
                                @Override // p658rx.functions.Func5
                                public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Guild call(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, ? extends GuildRole> map, Guild guild) {
                                    return call2(l, channelMemberList, bool, (Map<Long, GuildRole>) map, guild);
                                }

                                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                                public final WidgetChannelMembersListViewModel.StoreState.Guild call2(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, GuildRole> map, Guild guild) {
                                    C12238m.checkNotNullExpressionValue(bool, "isPanelOpen");
                                    boolean zBooleanValue = bool.booleanValue();
                                    Channel channel3 = channel2;
                                    C12238m.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
                                    C12238m.checkNotNullExpressionValue(map, "roles");
                                    return new WidgetChannelMembersListViewModel.StoreState.Guild(zBooleanValue, channel3, guild, channelMemberList, l, map);
                                }
                            });
                        }
                    }) : Observable.m11072g(storeGuilds.observeGuild(channel.getGuildId()), storeGuilds.observeRoles(channel.getGuildId()), storePermissions.observePermissionsForChannel(channel.getId()), storeChannelMembers.observeChannelMemberList(channel.getGuildId(), channel.getId()), observableM11083G, new Func5<Guild, Map<Long, ? extends GuildRole>, Long, ChannelMemberList, Boolean, WidgetChannelMembersListViewModel.StoreState.Guild>() { // from class: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1.4
                        @Override // p658rx.functions.Func5
                        public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Guild call(Guild guild, Map<Long, ? extends GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
                            return call2(guild, (Map<Long, GuildRole>) map, l, channelMemberList, bool);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetChannelMembersListViewModel.StoreState.Guild call2(Guild guild, Map<Long, GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
                            C12238m.checkNotNullExpressionValue(bool, "isPanelOpen");
                            boolean zBooleanValue = bool.booleanValue();
                            Channel channel2 = channel;
                            C12238m.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
                            C12238m.checkNotNullExpressionValue(map, "guildRoles");
                            return new WidgetChannelMembersListViewModel.StoreState.Guild(zBooleanValue, channel2, guild, channelMemberList, l, map);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "storeChannelsSelected\n  …            }\n          }");
            return observableM11099Y;
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
                return C1643a.m814B(C1643a.m833U("Error(code="), this.code, ")");
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
        void subscribeToChannelRange(Channel channel, IntRange range);

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
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(channelMemberList, "channelMembers");
                C12238m.checkNotNullParameter(map, "guildRoles");
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
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(channelMembers, "channelMembers");
                C12238m.checkNotNullParameter(guildRoles, "guildRoles");
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
                return getIsPanelOpen() == guild.getIsPanelOpen() && C12238m.areEqual(getChannel(), guild.getChannel()) && C12238m.areEqual(this.guild, guild.guild) && C12238m.areEqual(this.channelMembers, guild.channelMembers) && C12238m.areEqual(this.channelPermissions, guild.channelPermissions) && C12238m.areEqual(this.guildRoles, guild.guildRoles);
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
                StringBuilder sbM833U = C1643a.m833U("Guild(isPanelOpen=");
                sbM833U.append(getIsPanelOpen());
                sbM833U.append(", channel=");
                sbM833U.append(getChannel());
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", channelMembers=");
                sbM833U.append(this.channelMembers);
                sbM833U.append(", channelPermissions=");
                sbM833U.append(this.channelPermissions);
                sbM833U.append(", guildRoles=");
                return C1643a.m825M(sbM833U, this.guildRoles, ")");
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
                StringBuilder sbM833U = C1643a.m833U("None(isPanelOpen=");
                sbM833U.append(getIsPanelOpen());
                sbM833U.append(")");
                return sbM833U.toString();
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
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(map, "users");
                C12238m.checkNotNullParameter(map2, "presences");
                C12238m.checkNotNullParameter(map3, "applicationStreams");
                C12238m.checkNotNullParameter(map4, "relationships");
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
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(users, "users");
                C12238m.checkNotNullParameter(presences, "presences");
                C12238m.checkNotNullParameter(applicationStreams, "applicationStreams");
                C12238m.checkNotNullParameter(relationships, "relationships");
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
                return getIsPanelOpen() == r3.getIsPanelOpen() && C12238m.areEqual(getChannel(), r3.getChannel()) && C12238m.areEqual(this.users, r3.users) && C12238m.areEqual(this.presences, r3.presences) && C12238m.areEqual(this.applicationStreams, r3.applicationStreams) && C12238m.areEqual(this.relationships, r3.relationships);
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
                StringBuilder sbM833U = C1643a.m833U("Private(isPanelOpen=");
                sbM833U.append(getIsPanelOpen());
                sbM833U.append(", channel=");
                sbM833U.append(getChannel());
                sbM833U.append(", users=");
                sbM833U.append(this.users);
                sbM833U.append(", presences=");
                sbM833U.append(this.presences);
                sbM833U.append(", applicationStreams=");
                sbM833U.append(this.applicationStreams);
                sbM833U.append(", relationships=");
                return C1643a.m825M(sbM833U, this.relationships, ")");
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
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(map, "roles");
                C12238m.checkNotNullParameter(map2, "guildMembers");
                C12238m.checkNotNullParameter(map3, "users");
                C12238m.checkNotNullParameter(map4, "presences");
                C12238m.checkNotNullParameter(map5, "streams");
                C12238m.checkNotNullParameter(set, "threadMembers");
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
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(roles, "roles");
                C12238m.checkNotNullParameter(guildMembers, "guildMembers");
                C12238m.checkNotNullParameter(users, "users");
                C12238m.checkNotNullParameter(presences, "presences");
                C12238m.checkNotNullParameter(streams, "streams");
                C12238m.checkNotNullParameter(threadMembers, "threadMembers");
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
                return getIsPanelOpen() == thread.getIsPanelOpen() && C12238m.areEqual(getChannel(), thread.getChannel()) && C12238m.areEqual(this.parentChannel, thread.parentChannel) && C12238m.areEqual(this.guild, thread.guild) && C12238m.areEqual(this.roles, thread.roles) && C12238m.areEqual(this.guildMembers, thread.guildMembers) && C12238m.areEqual(this.users, thread.users) && C12238m.areEqual(this.presences, thread.presences) && C12238m.areEqual(this.streams, thread.streams) && C12238m.areEqual(this.threadMembers, thread.threadMembers) && C12238m.areEqual(this.joinedThread, thread.joinedThread);
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
                StringBuilder sbM833U = C1643a.m833U("Thread(isPanelOpen=");
                sbM833U.append(getIsPanelOpen());
                sbM833U.append(", channel=");
                sbM833U.append(getChannel());
                sbM833U.append(", parentChannel=");
                sbM833U.append(this.parentChannel);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", roles=");
                sbM833U.append(this.roles);
                sbM833U.append(", guildMembers=");
                sbM833U.append(this.guildMembers);
                sbM833U.append(", users=");
                sbM833U.append(this.users);
                sbM833U.append(", presences=");
                sbM833U.append(this.presences);
                sbM833U.append(", streams=");
                sbM833U.append(this.streams);
                sbM833U.append(", threadMembers=");
                sbM833U.append(this.threadMembers);
                sbM833U.append(", joinedThread=");
                sbM833U.append(this.joinedThread);
                sbM833U.append(")");
                return sbM833U.toString();
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
                C12238m.checkNotNullParameter(memberList, "listItems");
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
                C12238m.checkNotNullParameter(listItems, "listItems");
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
                return C12238m.areEqual(this.listItems, loaded.listItems) && this.isOpen == loaded.isOpen && C12238m.areEqual(this.channel, loaded.channel) && this.isThreadJoined == loaded.isThreadJoined;
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
                StringBuilder sbM833U = C1643a.m833U("Loaded(listItems=");
                sbM833U.append(this.listItems);
                sbM833U.append(", isOpen=");
                sbM833U.append(this.isOpen);
                sbM833U.append(", channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", isThreadJoined=");
                return C1643a.m827O(sbM833U, this.isThreadJoined, ")");
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

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$1 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C75011 extends AbstractC12240o implements Function1<Error, Unit> {
        public C75011() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            PublishSubject publishSubject = WidgetChannelMembersListViewModel.this.eventSubject;
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            publishSubject.f27650k.onNext((T) new Event.Error(response.getCode()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$2 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C75022 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C75022 INSTANCE = new C75022();

        public C75022() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$3 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C75033 extends AbstractC12240o implements Function1<Error, Unit> {
        public C75033() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            PublishSubject publishSubject = WidgetChannelMembersListViewModel.this.eventSubject;
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            publishSubject.f27650k.onNext((T) new Event.Error(response.getCode()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$4 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C75044 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C75044 INSTANCE = new C75044();

        public C75044() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
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
            public void subscribeToChannelRange(Channel channel, IntRange range) {
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(range, "range");
                StoreStream.INSTANCE.getGuildSubscriptions().subscribeChannelRange(channel.getGuildId(), channel.getId(), range);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.GuildChannelSubscriber
            public void subscribeToThread(Channel channel) {
                C12238m.checkNotNullParameter(channel, "channel");
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
            memberListGenerateThreadMemberListItems = GuildMemberListItemGeneratorKt.generateGuildMemberListItems(guild.getChannelMembers(), guild.getGuild(), guild.getChannel(), guild.getGuildRoles(), PermissionUtils.can(1L, guild.getChannelPermissions()), false, this.storeGuilds, this.storeCustomEmojis);
        } else if (storeState instanceof StoreState.Private) {
            StoreState.Private r0 = (StoreState.Private) storeState;
            Map<Long, Integer> relationships = r0.getRelationships();
            User userM7677a = ChannelUtils.m7677a(r0.getChannel());
            memberListGenerateThreadMemberListItems = PrivateChannelMemberListItemGeneratorKt.generateGroupDmMemberListItems(r0.getChannel(), r0.getUsers(), r0.getPresences(), r0.getApplicationStreams(), ChannelUtils.m7692p(r0.getChannel()) || ModelUserRelationship.isType(relationships.get(userM7677a != null ? Long.valueOf(userM7677a.getId()) : null), 1));
        } else {
            if (!(storeState instanceof StoreState.Thread)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreState.Thread thread = (StoreState.Thread) storeState;
            memberListGenerateThreadMemberListItems = ThreadMemberListItemGeneratorKt.generateThreadMemberListItems(thread.getChannel(), thread.getRoles(), thread.getGuild(), thread.getGuildMembers(), thread.getUsers(), thread.getPresences(), thread.getStreams(), thread.getThreadMembers(), thread.getJoinedThread(), this.storeGuilds, this.storeCustomEmojis);
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
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onThreadJoinLeaveClicked(long channelId, boolean isThreadJoined) {
        if (isThreadJoined) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channelId, "Thread Member List"), false, 1, null), this, null, 2, null), (Class<?>) WidgetChannelMembersListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C75011()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C75022.INSTANCE);
            StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinThread(channelId, "Thread Member List", new RestAPIParams.EmptyBody()), false, 1, null), (Class<?>) WidgetChannelMembersListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C75033()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C75044.INSTANCE);
        StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
    }

    public final void updateSubscriptions(ViewState prevViewState, ViewState.Loaded newViewState, StoreState storeState) {
        C12238m.checkNotNullParameter(newViewState, "newViewState");
        C12238m.checkNotNullParameter(storeState, "storeState");
        boolean z2 = (C12238m.areEqual(prevViewState != null ? prevViewState.getListId() : null, newViewState.getListId()) ^ true) && storeState.getIsPanelOpen();
        Channel channel = newViewState.getChannel();
        if (channel != null && ChannelUtils.m7673H(channel)) {
            if (z2) {
                this.eventSubject.f27650k.onNext(Event.ScrollToTop.INSTANCE);
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
            this.eventSubject.f27650k.onNext(Event.ScrollToTop.INSTANCE);
            updateSubscriptionsForChannel(new IntRange(0, 99));
        } else if ((prevViewState instanceof ViewState.Loaded) && !((ViewState.Loaded) prevViewState).isOpen() && newViewState.isOpen()) {
            this.eventSubject.f27650k.onNext(Event.UpdateRanges.INSTANCE);
        }
    }

    @MainThread
    public final void updateSubscriptionsForChannel(IntRange range) {
        C12238m.checkNotNullParameter(range, "range");
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
        if (channel == null || ChannelUtils.m7686j(channel)) {
            return;
        }
        C12238m.checkNotNullParameter(channel, "$this$isAnnouncementThread");
        if (channel.getType() == 10) {
            return;
        }
        this.guildChannelSubscriber.subscribeToThread(channel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersListViewModel(GuildChannelSubscriber guildChannelSubscriber, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Observable<StoreState> observable) {
        super(ViewState.Empty.INSTANCE);
        C12238m.checkNotNullParameter(guildChannelSubscriber, "guildChannelSubscriber");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeEmojiCustom, "storeCustomEmojis");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildChannelSubscriber = guildChannelSubscriber;
        this.storeGuilds = storeGuilds;
        this.storeCustomEmojis = storeEmojiCustom;
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetChannelMembersListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74952());
    }
}
