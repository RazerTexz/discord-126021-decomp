package com.discord.widgets.channels.permissions;

import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragmentViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final StoreGatewayConnection gatewaySocket;
    private final StoreGuilds guildsStore;
    private String query;
    private final HashMap<Long, PermissionOverwrite.Type> selected;
    private final boolean showRolesWithGuildPermission;
    private StoreState storeState;
    private final StoreUser userStore;

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    public static final class C75291 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C75291() {
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
            WidgetChannelSettingsAddMemberFragmentViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreChannels channelsStore, final StoreGuilds guildsStore, final StoreUser userStore) {
            Observable<R> observableM11083G = channelsStore.observeChannel(channelId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableM11099Y = observableM11083G.m11112r().m11099Y(new InterfaceC12589b<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetChannelSettingsAddMemberFragmentViewModel.StoreState> call(final Channel channel) {
                    return Observable.m11073h(guildsStore.observeGuild(channel.getGuildId()), guildsStore.observeRoles(channel.getGuildId()), guildsStore.observeComputed(channel.getGuildId()), userStore.observeAllUsers(), new Func4<Guild, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, WidgetChannelSettingsAddMemberFragmentViewModel.StoreState>() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1.1
                        @Override // p658rx.functions.Func4
                        public /* bridge */ /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel.StoreState call(Guild guild, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends User> map3) {
                            return call2(guild, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, map3);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetChannelSettingsAddMemberFragmentViewModel.StoreState call2(Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3) {
                            Map mapEmptyMap;
                            Channel channel2 = channel;
                            C12238m.checkNotNullExpressionValue(channel2, "channel");
                            List<PermissionOverwrite> listM7655v = channel.m7655v();
                            if (listM7655v != null) {
                                mapEmptyMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(listM7655v, 10)), 16));
                                for (T t : listM7655v) {
                                    mapEmptyMap.put(Long.valueOf(((PermissionOverwrite) t).m8131e()), t);
                                }
                            } else {
                                mapEmptyMap = C12136h0.emptyMap();
                            }
                            C12238m.checkNotNullExpressionValue(map, "roles");
                            C12238m.checkNotNullExpressionValue(map2, "members");
                            C12238m.checkNotNullExpressionValue(map3, "users");
                            return new WidgetChannelSettingsAddMemberFragmentViewModel.StoreState(guild, channel2, mapEmptyMap, map, map2, map3);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "channelsStore.observeCha…          }\n            }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Map<Long, PermissionOverwrite> channelPermissionOverwritesMap;
        private final Guild guild;
        private final Map<Long, GuildMember> members;
        private final Map<Long, GuildRole> roles;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Guild guild, Channel channel, Map<Long, PermissionOverwrite> map, Map<Long, GuildRole> map2, Map<Long, GuildMember> map3, Map<Long, ? extends User> map4) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(map, "channelPermissionOverwritesMap");
            C12238m.checkNotNullParameter(map2, "roles");
            C12238m.checkNotNullParameter(map3, "members");
            C12238m.checkNotNullParameter(map4, "users");
            this.guild = guild;
            this.channel = channel;
            this.channelPermissionOverwritesMap = map;
            this.roles = map2;
            this.members = map3;
            this.users = map4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, Channel channel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                map = storeState.channelPermissionOverwritesMap;
            }
            Map map5 = map;
            if ((i & 8) != 0) {
                map2 = storeState.roles;
            }
            Map map6 = map2;
            if ((i & 16) != 0) {
                map3 = storeState.members;
            }
            Map map7 = map3;
            if ((i & 32) != 0) {
                map4 = storeState.users;
            }
            return storeState.copy(guild, channel2, map5, map6, map7, map4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, PermissionOverwrite> component3() {
            return this.channelPermissionOverwritesMap;
        }

        public final Map<Long, GuildRole> component4() {
            return this.roles;
        }

        public final Map<Long, GuildMember> component5() {
            return this.members;
        }

        public final Map<Long, User> component6() {
            return this.users;
        }

        public final StoreState copy(Guild guild, Channel channel, Map<Long, PermissionOverwrite> channelPermissionOverwritesMap, Map<Long, GuildRole> roles, Map<Long, GuildMember> members, Map<Long, ? extends User> users) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(channelPermissionOverwritesMap, "channelPermissionOverwritesMap");
            C12238m.checkNotNullParameter(roles, "roles");
            C12238m.checkNotNullParameter(members, "members");
            C12238m.checkNotNullParameter(users, "users");
            return new StoreState(guild, channel, channelPermissionOverwritesMap, roles, members, users);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.channel, storeState.channel) && C12238m.areEqual(this.channelPermissionOverwritesMap, storeState.channelPermissionOverwritesMap) && C12238m.areEqual(this.roles, storeState.roles) && C12238m.areEqual(this.members, storeState.members) && C12238m.areEqual(this.users, storeState.users);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, PermissionOverwrite> getChannelPermissionOverwritesMap() {
            return this.channelPermissionOverwritesMap;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildMember> getMembers() {
            return this.members;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Map<Long, PermissionOverwrite> map = this.channelPermissionOverwritesMap;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map2 = this.roles;
            int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map3 = this.members;
            int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, User> map4 = this.users;
            return iHashCode5 + (map4 != null ? map4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", channelPermissionOverwritesMap=");
            sbM833U.append(this.channelPermissionOverwritesMap);
            sbM833U.append(", roles=");
            sbM833U.append(this.roles);
            sbM833U.append(", members=");
            sbM833U.append(this.members);
            sbM833U.append(", users=");
            return C1643a.m825M(sbM833U, this.users, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    public static final /* data */ class ViewState {
        private final Channel channel;
        private final Guild guild;
        private final List<AddMemberAdapter.Item> items;
        private final String query;
        private final Map<Long, PermissionOverwrite.Type> selected;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(Guild guild, Channel channel, String str, List<? extends AddMemberAdapter.Item> list, Map<Long, ? extends PermissionOverwrite.Type> map) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(str, "query");
            C12238m.checkNotNullParameter(list, "items");
            C12238m.checkNotNullParameter(map, "selected");
            this.guild = guild;
            this.channel = channel;
            this.query = str;
            this.items = list;
            this.selected = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, Guild guild, Channel channel, String str, List list, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = viewState.guild;
            }
            if ((i & 2) != 0) {
                channel = viewState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                str = viewState.query;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                list = viewState.items;
            }
            List list2 = list;
            if ((i & 16) != 0) {
                map = viewState.selected;
            }
            return viewState.copy(guild, channel2, str2, list2, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final List<AddMemberAdapter.Item> component4() {
            return this.items;
        }

        public final Map<Long, PermissionOverwrite.Type> component5() {
            return this.selected;
        }

        public final ViewState copy(Guild guild, Channel channel, String query, List<? extends AddMemberAdapter.Item> items, Map<Long, ? extends PermissionOverwrite.Type> selected) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(query, "query");
            C12238m.checkNotNullParameter(items, "items");
            C12238m.checkNotNullParameter(selected, "selected");
            return new ViewState(guild, channel, query, items, selected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(this.guild, viewState.guild) && C12238m.areEqual(this.channel, viewState.channel) && C12238m.areEqual(this.query, viewState.query) && C12238m.areEqual(this.items, viewState.items) && C12238m.areEqual(this.selected, viewState.selected);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<AddMemberAdapter.Item> getItems() {
            return this.items;
        }

        public final String getQuery() {
            return this.query;
        }

        public final Map<Long, PermissionOverwrite.Type> getSelected() {
            return this.selected;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            String str = this.query;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            List<AddMemberAdapter.Item> list = this.items;
            int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Long, PermissionOverwrite.Type> map = this.selected;
            return iHashCode4 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", query=");
            sbM833U.append(this.query);
            sbM833U.append(", items=");
            sbM833U.append(this.items);
            sbM833U.append(", selected=");
            return C1643a.m825M(sbM833U, this.selected, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel(long j, boolean z2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StoreGatewayConnection storeGatewayConnection, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreUser users = (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(j, z2, channels, guilds, users, (i & 32) != 0 ? StoreStream.INSTANCE.getGatewaySocket() : storeGatewayConnection, (i & 64) != 0 ? INSTANCE.observeStoreState(j, channels, guilds, users) : observable);
    }

    private final ViewState generateViewState(StoreState storeState) {
        return new ViewState(storeState.getGuild(), storeState.getChannel(), this.query, makeAdapterItems(storeState), this.selected);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        this.storeState = storeState;
        updateViewState(generateViewState(storeState));
    }

    private final boolean isPermissionOverrideAlreadyPresent(PermissionOverwrite overwrite, long permission) {
        return overwrite != null && (overwrite.getAllow() & permission) == permission;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0090  */
    private final List<AddMemberAdapter.Item> makeAdapterItems(StoreState storeState) {
        AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus cannotAdd;
        boolean z2;
        Guild guild = storeState.getGuild();
        Map<Long, PermissionOverwrite> channelPermissionOverwritesMap = storeState.getChannelPermissionOverwritesMap();
        String str = this.query;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        String string = C12106w.trim(str).toString();
        Collection<GuildRole> collectionValues = storeState.getRoles().values();
        ArrayList<GuildRole> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            GuildRole guildRole = (GuildRole) obj;
            if ((guildRole.getPermissions() & 8) == 0) {
                long id2 = guildRole.getId();
                if ((guild == null || id2 != guild.getId()) && ((this.showRolesWithGuildPermission || !PermissionUtils.INSTANCE.canRole(20971536L, guildRole, channelPermissionOverwritesMap.get(Long.valueOf(guildRole.getId())))) && !isPermissionOverrideAlreadyPresent(channelPermissionOverwritesMap.get(Long.valueOf(guildRole.getId())), 20971536L) && C12106w.contains((CharSequence) guildRole.getName(), (CharSequence) string, true))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        for (GuildRole guildRole2 : arrayList) {
            boolean zCanRole = PermissionUtils.INSTANCE.canRole(20971536L, guildRole2, channelPermissionOverwritesMap.get(Long.valueOf(guildRole2.getId())));
            PermissionOwner.Role role = new PermissionOwner.Role(guildRole2);
            boolean z3 = zCanRole || this.selected.containsKey(Long.valueOf(guildRole2.getId()));
            if (zCanRole) {
                cannotAdd = new AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd(AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd.Reason.HAS_GUILD_PERMISSIONS);
            } else {
                if (zCanRole) {
                    throw new NoWhenBranchMatchedException();
                }
                cannotAdd = AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE;
            }
            arrayList2.add(new AddMemberAdapter.Item.PermissionOwnerItem(role, z3, cannotAdd));
        }
        Set<Map.Entry<Long, GuildMember>> setEntrySet = storeState.getMembers().entrySet();
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            User user = storeState.getUsers().get(entry.getKey());
            Pair pair = user == null ? null : new Pair((GuildMember) entry.getValue(), user);
            if (pair != null) {
                arrayList3.add(pair);
            }
        }
        ArrayList<Pair> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            Pair pair2 = (Pair) obj2;
            GuildMember guildMember = (GuildMember) pair2.component1();
            User user2 = (User) pair2.component2();
            if (((guild != null ? guild.isOwner(user2.getId()) : false) || isPermissionOverrideAlreadyPresent((PermissionOverwrite) C1643a.m849f(user2, channelPermissionOverwritesMap), 20971536L) || (!C12106w.contains((CharSequence) user2.getUsername(), (CharSequence) string, true) && (guildMember.getNick() == null || !C12106w.contains((CharSequence) guildMember.getNick(), (CharSequence) string, true)))) ? false : true) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList4, 10));
        for (Pair pair3 : arrayList4) {
            GuildMember guildMember2 = (GuildMember) pair3.component1();
            User user3 = (User) pair3.component2();
            arrayList5.add(new AddMemberAdapter.Item.PermissionOwnerItem(new PermissionOwner.Member(user3, guildMember2.getNick(), guild != null && guild.isOwner(user3.getId())), this.selected.containsKey(Long.valueOf(user3.getId())), AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE));
        }
        return C12163u.plus((Collection) C12163u.plus((Collection) C12163u.plus((Collection) C12145m.listOf(new AddMemberAdapter.Item.CategoryItem(AddMemberAdapter.Item.CategoryItem.Companion.CategoryType.ROLE)), (Iterable) arrayList2), (Iterable) C12145m.listOf(new AddMemberAdapter.Item.CategoryItem(AddMemberAdapter.Item.CategoryItem.Companion.CategoryType.MEMBER))), (Iterable) arrayList5);
    }

    private final void requestMembers(String query) {
        Guild guild;
        StoreState storeState = this.storeState;
        if (storeState == null || (guild = storeState.getGuild()) == null) {
            return;
        }
        long id2 = guild.getId();
        StoreGatewayConnection storeGatewayConnection = this.gatewaySocket;
        Objects.requireNonNull(query, "null cannot be cast to non-null type kotlin.CharSequence");
        storeGatewayConnection.requestGuildMembers(id2, C12106w.trim(query).toString(), null, 20);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String str) {
        C12238m.checkNotNullParameter(str, "<set-?>");
        this.query = str;
    }

    public final void toggleItem(long id2, PermissionOverwrite.Type type) {
        C12238m.checkNotNullParameter(type, "type");
        if (this.selected.containsKey(Long.valueOf(id2))) {
            this.selected.remove(Long.valueOf(id2));
        } else {
            this.selected.put(Long.valueOf(id2), type);
        }
        StoreState storeState = this.storeState;
        if (storeState != null) {
            updateViewState(generateViewState(storeState));
        }
    }

    public final void updateQuery(String query) {
        C12238m.checkNotNullParameter(query, "query");
        this.query = query;
        StoreState storeState = this.storeState;
        if (storeState != null) {
            updateViewState(generateViewState(storeState));
        }
        requestMembers(query);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragmentViewModel(long j, boolean z2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StoreGatewayConnection storeGatewayConnection, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(storeUser, "userStore");
        C12238m.checkNotNullParameter(storeGatewayConnection, "gatewaySocket");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.showRolesWithGuildPermission = z2;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.userStore = storeUser;
        this.gatewaySocket = storeGatewayConnection;
        this.query = "";
        this.selected = new HashMap<>();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetChannelSettingsAddMemberFragmentViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75291());
    }
}
