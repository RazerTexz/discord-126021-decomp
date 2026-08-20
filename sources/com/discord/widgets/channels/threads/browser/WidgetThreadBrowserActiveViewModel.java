package com.discord.widgets.channels.threads.browser;

import androidx.annotation.MainThread;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long guildId;
    private final StoreChannels storeChannels;
    private final StoreGuildMemberRequester storeGuildMemberRequester;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreThreadMessages storeThreadMessages;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreThreadsActiveJoined storeThreadsActiveJoined;
    private final StoreUser storeUser;

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
    public static final class C76481 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C76481() {
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
            WidgetThreadBrowserActiveViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long guildId, final long channelId, final StoreUser storeUser, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, final StoreThreadMessages storeThreadMessages, final StoreGuilds storeGuilds, final StoreChannels storeChannels, final StorePermissions storePermissions) {
            Observable<StoreState> observableM11099Y = Observable.m11076j(storeThreadsActiveJoined.observeActiveJoinedThreadsForChannel(guildId, channelId).m11083G(new InterfaceC12589b<Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Map<Long, ? extends Channel>>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map) {
                    return call2((Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Map<Long, Channel> call2(Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map) {
                    C12238m.checkNotNullExpressionValue(map, "threadMap");
                    LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(map.size()));
                    Iterator<T> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        linkedHashMap.put(entry.getKey(), ((StoreThreadsActiveJoined.ActiveJoinedThread) entry.getValue()).getChannel());
                    }
                    return linkedHashMap;
                }
            }), storeThreadsActive.observeActiveThreadsForChannel(guildId, Long.valueOf(channelId)), new Func2<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>>>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$2
                @Override // p658rx.functions.Func2
                public /* bridge */ /* synthetic */ Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Channel> map2) {
                    return call2((Map<Long, Channel>) map, (Map<Long, Channel>) map2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Pair<Map<Long, Channel>, Map<Long, Channel>> call2(Map<Long, Channel> map, Map<Long, Channel> map2) {
                    return new Pair<>(map, map2);
                }
            }).m11099Y(new InterfaceC12589b<Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>>, Observable<? extends StoreState>>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3

                /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3$2 */
                /* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
                public static final class C76492 extends AbstractC12240o implements Function10<MeUser, Map<Long, ? extends User>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends String>, Long, Map<Long, ? extends Integer>, Channel, Guild, WidgetThreadBrowserActiveViewModel.StoreState> {
                    public final /* synthetic */ Map $activeJoinedThreads;
                    public final /* synthetic */ Map $activeThreads;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C76492(Map map, Map map2) {
                        super(10);
                        this.$activeJoinedThreads = map;
                        this.$activeThreads = map2;
                    }

                    @Override // kotlin.jvm.functions.Function10
                    public /* bridge */ /* synthetic */ WidgetThreadBrowserActiveViewModel.StoreState invoke(MeUser meUser, Map<Long, ? extends User> map, Map<Long, ? extends StoreThreadMessages.ThreadState> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Map<Long, ? extends String> map5, Long l, Map<Long, ? extends Integer> map6, Channel channel, Guild guild) {
                        return invoke2(meUser, map, (Map<Long, StoreThreadMessages.ThreadState>) map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, (Map<Long, String>) map5, l, (Map<Long, Integer>) map6, channel, guild);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final WidgetThreadBrowserActiveViewModel.StoreState invoke2(MeUser meUser, Map<Long, ? extends User> map, Map<Long, StoreThreadMessages.ThreadState> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, String> map5, Long l, Map<Long, Integer> map6, Channel channel, Guild guild) {
                        C12238m.checkNotNullParameter(meUser, "meUser");
                        C12238m.checkNotNullParameter(map, "users");
                        C12238m.checkNotNullParameter(map2, "threadStates");
                        C12238m.checkNotNullParameter(map4, "guildRoles");
                        C12238m.checkNotNullParameter(map5, "channelNames");
                        C12238m.checkNotNullParameter(map6, "blockedUsers");
                        Map map7 = this.$activeJoinedThreads;
                        C12238m.checkNotNullExpressionValue(map7, "activeJoinedThreads");
                        Map map8 = this.$activeThreads;
                        C12238m.checkNotNullExpressionValue(map8, "activeThreads");
                        C12238m.checkNotNullExpressionValue(map3, "guildMembers");
                        return new WidgetThreadBrowserActiveViewModel.StoreState(meUser, map7, map8, map2, map3, map, map4, map5, l, map6, channel, guild);
                    }
                }

                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState> call(Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>> pair) {
                    return call2((Pair<? extends Map<Long, Channel>, ? extends Map<Long, Channel>>) pair);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState> call2(Pair<? extends Map<Long, Channel>, ? extends Map<Long, Channel>> pair) {
                    Map<Long, Channel> mapComponent1 = pair.component1();
                    Map<Long, Channel> mapComponent2 = pair.component2();
                    Observable observableObserveMe$default = StoreUser.observeMe$default(storeUser, false, 1, null);
                    StoreUser storeUser2 = storeUser;
                    HashSet hashSet = new HashSet();
                    C12238m.checkNotNullExpressionValue(mapComponent1, "activeJoinedThreads");
                    Iterator<Map.Entry<Long, Channel>> it = mapComponent1.entrySet().iterator();
                    while (it.hasNext()) {
                        hashSet.add(Long.valueOf(it.next().getValue().getOwnerId()));
                    }
                    C12238m.checkNotNullExpressionValue(mapComponent2, "activeThreads");
                    Iterator<Map.Entry<Long, Channel>> it2 = mapComponent2.entrySet().iterator();
                    while (it2.hasNext()) {
                        hashSet.add(Long.valueOf(it2.next().getValue().getOwnerId()));
                    }
                    Observable<Map<Long, User>> observableObserveUsers = storeUser2.observeUsers(hashSet);
                    Observable<Map<Long, StoreThreadMessages.ThreadState>> observableObserveThreadCountAndLatestMessage = storeThreadMessages.observeThreadCountAndLatestMessage();
                    Observable<Map<Long, GuildMember>> observableObserveGuildMembers = storeGuilds.observeGuildMembers(guildId);
                    C12238m.checkNotNullExpressionValue(observableObserveGuildMembers, "storeGuilds\n            …erveGuildMembers(guildId)");
                    Observable<T> observableM11112r = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMembers, 1L, TimeUnit.SECONDS).m11112r();
                    C12238m.checkNotNullExpressionValue(observableM11112r, "storeGuilds\n            …  .distinctUntilChanged()");
                    return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMe$default, observableObserveUsers, observableObserveThreadCountAndLatestMessage, observableM11112r, storeGuilds.observeRoles(guildId), storeChannels.observeNames(), storePermissions.observePermissionsForChannel(channelId), StoreStream.INSTANCE.getUserRelationships().observeForType(2), storeChannels.observeChannel(channelId), storeGuilds.observeGuild(guildId), new C76492(mapComponent1, mapComponent2));
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "Observable.combineLatest…            }\n          }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, Channel> activeJoinedThreads;
        private final Map<Long, Channel> activeThreads;
        private final Map<Long, Integer> blockedUsers;
        private final Channel channel;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final Map<Long, GuildMember> guildMembers;
        private final Map<Long, GuildRole> guildRoles;
        private final MeUser meUser;
        private final Long permissions;
        private final Map<Long, StoreThreadMessages.ThreadState> threadStates;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(MeUser meUser, Map<Long, Channel> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3, Map<Long, GuildMember> map4, Map<Long, ? extends User> map5, Map<Long, GuildRole> map6, Map<Long, String> map7, Long l, Map<Long, Integer> map8, Channel channel, Guild guild) {
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(map, "activeJoinedThreads");
            C12238m.checkNotNullParameter(map2, "activeThreads");
            C12238m.checkNotNullParameter(map3, "threadStates");
            C12238m.checkNotNullParameter(map4, "guildMembers");
            C12238m.checkNotNullParameter(map5, "users");
            C12238m.checkNotNullParameter(map6, "guildRoles");
            C12238m.checkNotNullParameter(map7, "channelNames");
            C12238m.checkNotNullParameter(map8, "blockedUsers");
            this.meUser = meUser;
            this.activeJoinedThreads = map;
            this.activeThreads = map2;
            this.threadStates = map3;
            this.guildMembers = map4;
            this.users = map5;
            this.guildRoles = map6;
            this.channelNames = map7;
            this.permissions = l;
            this.blockedUsers = map8;
            this.channel = channel;
            this.guild = guild;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Map<Long, Integer> component10() {
            return this.blockedUsers;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, Channel> component2() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Channel> component3() {
            return this.activeThreads;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> component4() {
            return this.threadStates;
        }

        public final Map<Long, GuildMember> component5() {
            return this.guildMembers;
        }

        public final Map<Long, User> component6() {
            return this.users;
        }

        public final Map<Long, GuildRole> component7() {
            return this.guildRoles;
        }

        public final Map<Long, String> component8() {
            return this.channelNames;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        public final StoreState copy(MeUser meUser, Map<Long, Channel> activeJoinedThreads, Map<Long, Channel> activeThreads, Map<Long, StoreThreadMessages.ThreadState> threadStates, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Long permissions, Map<Long, Integer> blockedUsers, Channel channel, Guild guild) {
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
            C12238m.checkNotNullParameter(activeThreads, "activeThreads");
            C12238m.checkNotNullParameter(threadStates, "threadStates");
            C12238m.checkNotNullParameter(guildMembers, "guildMembers");
            C12238m.checkNotNullParameter(users, "users");
            C12238m.checkNotNullParameter(guildRoles, "guildRoles");
            C12238m.checkNotNullParameter(channelNames, "channelNames");
            C12238m.checkNotNullParameter(blockedUsers, "blockedUsers");
            return new StoreState(meUser, activeJoinedThreads, activeThreads, threadStates, guildMembers, users, guildRoles, channelNames, permissions, blockedUsers, channel, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.meUser, storeState.meUser) && C12238m.areEqual(this.activeJoinedThreads, storeState.activeJoinedThreads) && C12238m.areEqual(this.activeThreads, storeState.activeThreads) && C12238m.areEqual(this.threadStates, storeState.threadStates) && C12238m.areEqual(this.guildMembers, storeState.guildMembers) && C12238m.areEqual(this.users, storeState.users) && C12238m.areEqual(this.guildRoles, storeState.guildRoles) && C12238m.areEqual(this.channelNames, storeState.channelNames) && C12238m.areEqual(this.permissions, storeState.permissions) && C12238m.areEqual(this.blockedUsers, storeState.blockedUsers) && C12238m.areEqual(this.channel, storeState.channel) && C12238m.areEqual(this.guild, storeState.guild);
        }

        public final Map<Long, Channel> getActiveJoinedThreads() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Channel> getActiveThreads() {
            return this.activeThreads;
        }

        public final Map<Long, Integer> getBlockedUsers() {
            return this.blockedUsers;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> getThreadStates() {
            return this.threadStates;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Map<Long, Channel> map = this.activeJoinedThreads;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Channel> map2 = this.activeThreads;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, StoreThreadMessages.ThreadState> map3 = this.threadStates;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map4 = this.guildMembers;
            int iHashCode5 = (iHashCode4 + (map4 != null ? map4.hashCode() : 0)) * 31;
            Map<Long, User> map5 = this.users;
            int iHashCode6 = (iHashCode5 + (map5 != null ? map5.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map6 = this.guildRoles;
            int iHashCode7 = (iHashCode6 + (map6 != null ? map6.hashCode() : 0)) * 31;
            Map<Long, String> map7 = this.channelNames;
            int iHashCode8 = (iHashCode7 + (map7 != null ? map7.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
            Map<Long, Integer> map8 = this.blockedUsers;
            int iHashCode10 = (iHashCode9 + (map8 != null ? map8.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode11 = (iHashCode10 + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            return iHashCode11 + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(", activeJoinedThreads=");
            sbM833U.append(this.activeJoinedThreads);
            sbM833U.append(", activeThreads=");
            sbM833U.append(this.activeThreads);
            sbM833U.append(", threadStates=");
            sbM833U.append(this.threadStates);
            sbM833U.append(", guildMembers=");
            sbM833U.append(this.guildMembers);
            sbM833U.append(", users=");
            sbM833U.append(this.users);
            sbM833U.append(", guildRoles=");
            sbM833U.append(this.guildRoles);
            sbM833U.append(", channelNames=");
            sbM833U.append(this.channelNames);
            sbM833U.append(", permissions=");
            sbM833U.append(this.permissions);
            sbM833U.append(", blockedUsers=");
            sbM833U.append(this.blockedUsers);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean canCreateThread;
        private final List<WidgetThreadBrowserAdapter.Item> listItems;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<? extends WidgetThreadBrowserAdapter.Item> list, boolean z2) {
            C12238m.checkNotNullParameter(list, "listItems");
            this.listItems = list;
            this.canCreateThread = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.listItems;
            }
            if ((i & 2) != 0) {
                z2 = viewState.canCreateThread;
            }
            return viewState.copy(list, z2);
        }

        public final List<WidgetThreadBrowserAdapter.Item> component1() {
            return this.listItems;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final ViewState copy(List<? extends WidgetThreadBrowserAdapter.Item> listItems, boolean canCreateThread) {
            C12238m.checkNotNullParameter(listItems, "listItems");
            return new ViewState(listItems, canCreateThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(this.listItems, viewState.listItems) && this.canCreateThread == viewState.canCreateThread;
        }

        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final List<WidgetThreadBrowserAdapter.Item> getListItems() {
            return this.listItems;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            List<WidgetThreadBrowserAdapter.Item> list = this.listItems;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z2 = this.canCreateThread;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(listItems=");
            sbM833U.append(this.listItems);
            sbM833U.append(", canCreateThread=");
            return C1643a.m827O(sbM833U, this.canCreateThread, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetThreadBrowserActiveViewModel(long j, long j2, StoreUser storeUser, StoreGuildMemberRequester storeGuildMemberRequester, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuildMemberRequester guildMemberRequester = (i & 8) != 0 ? StoreStream.INSTANCE.getGuildMemberRequester() : storeGuildMemberRequester;
        StoreThreadsActive threadsActive = (i & 16) != 0 ? StoreStream.INSTANCE.getThreadsActive() : storeThreadsActive;
        StoreThreadsActiveJoined threadsActiveJoined = (i & 32) != 0 ? StoreStream.INSTANCE.getThreadsActiveJoined() : storeThreadsActiveJoined;
        StoreThreadMessages threadMessages = (i & 64) != 0 ? StoreStream.INSTANCE.getThreadMessages() : storeThreadMessages;
        StoreGuilds guilds = (i & 128) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreChannels channels = (i & 256) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i & 512) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        this(j, j2, users, guildMemberRequester, threadsActive, threadsActiveJoined, threadMessages, guilds, channels, permissions, (i & 1024) != 0 ? INSTANCE.observeStoreState(j, j2, users, threadsActive, threadsActiveJoined, threadMessages, guilds, channels, permissions) : observable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    private final void handleStoreState(StoreState storeState) {
        int i;
        com.discord.api.user.User author;
        com.discord.api.user.User author2;
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 1;
        List listListOf = C12147n.listOf((Object[]) new Triple[]{new Triple("joined", Integer.valueOf(C5419R.string.thread_browser_joined_header), storeState.getActiveJoinedThreads()), new Triple("other", Integer.valueOf(C5419R.string.thread_browser_other_header), storeState.getActiveThreads())});
        Channel channel = storeState.getChannel();
        Message message = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (channel != null && channel.getType() == 15) {
            arrayList.add(new WidgetThreadBrowserAdapter.Item.Warning(objArr2 == true ? 1 : 0, i2, objArr == true ? 1 : 0));
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            String str = (String) triple.component1();
            int iIntValue = ((Number) triple.component2()).intValue();
            Map map = (Map) triple.component3();
            if (map.isEmpty()) {
                i = 0;
            } else {
                Iterator it2 = map.entrySet().iterator();
                i = 0;
                while (it2.hasNext()) {
                    if (((linkedHashSet.contains(Long.valueOf(((Number) ((Map.Entry) it2.next()).getKey()).longValue())) ? 1 : 0) ^ i2) != 0) {
                        i++;
                    }
                }
            }
            if (i != 0) {
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Header(str, iIntValue, i));
                Iterator it3 = map.entrySet().iterator();
                while (it3.hasNext()) {
                    Map.Entry entry = (Map.Entry) it3.next();
                    long jLongValue = ((Number) entry.getKey()).longValue();
                    Channel channel2 = (Channel) entry.getValue();
                    if (linkedHashSet.contains(Long.valueOf(jLongValue))) {
                        it = it;
                        it3 = it3;
                    } else {
                        User user = storeState.getUsers().get(Long.valueOf(channel2.getOwnerId()));
                        if (user == null || !storeState.getGuildMembers().containsKey(Long.valueOf(channel2.getOwnerId()))) {
                            this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), channel2.getOwnerId());
                        }
                        StoreThreadMessages.ThreadState threadState = storeState.getThreadStates().get(Long.valueOf(jLongValue));
                        Message mostRecentMessage = threadState != null ? threadState.getMostRecentMessage() : message;
                        if (mostRecentMessage != null && (author2 = mostRecentMessage.getAuthor()) != null && !storeState.getGuildMembers().containsKey(Long.valueOf(author2.getId()))) {
                            this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), author2.getId());
                        }
                        arrayList.add(new WidgetThreadBrowserAdapter.Item.Thread(new ThreadBrowserThreadView.ThreadData.ActiveThread(channel2, user, mostRecentMessage, storeState.getMeUser().getId(), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannelNames(), storeState.getBlockedUsers().containsKey((mostRecentMessage == null || (author = mostRecentMessage.getAuthor()) == null) ? null : Long.valueOf(author.getId())))));
                        linkedHashSet.add(Long.valueOf(jLongValue));
                    }
                    it = it;
                    it3 = it3;
                    message = null;
                }
            }
            it = it;
            i2 = 1;
            message = null;
        }
        if (linkedHashSet.isEmpty()) {
            arrayList.clear();
        }
        this.storeGuildMemberRequester.performQueuedRequests();
        updateViewState(new ViewState(arrayList, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActiveViewModel(long j, long j2, StoreUser storeUser, StoreGuildMemberRequester storeGuildMemberRequester, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeGuildMemberRequester, "storeGuildMemberRequester");
        C12238m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        C12238m.checkNotNullParameter(storeThreadsActiveJoined, "storeThreadsActiveJoined");
        C12238m.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = j2;
        this.storeUser = storeUser;
        this.storeGuildMemberRequester = storeGuildMemberRequester;
        this.storeThreadsActive = storeThreadsActive;
        this.storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.storeThreadMessages = storeThreadMessages;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetThreadBrowserActiveViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76481());
    }
}
