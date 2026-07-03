package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.collections.ShallowPartitionCollection;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.GlobalRoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import com.discord.widgets.chat.input.autocomplete.RoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.functions.Func8;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAutocompletableSource {
    private static final int PARTITION_HUGE_GUILD_SIZE = 3000;
    private static final int PARTITION_IDEAL_PARTITION_SIZE = 100;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUserPresence storePresences;
    private final StoreUser storeUsers;

    public UserAutocompletableSource(StoreUser storeUser, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreChannels storeChannels) {
        C12238m.checkNotNullParameter(storeUser, "storeUsers");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeUserPresence, "storePresences");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storePresences = storeUserPresence;
        this.storePermissions = storePermissions;
        this.storeChannels = storeChannels;
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createAutocompletablesForDmUsers(Map<Long, ? extends User> users, Map<Long, Presence> presences, List<ChannelRecipientNick> nicks) {
        ChannelRecipientNick channelRecipientNick;
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        for (User user : users.values()) {
            String nick = null;
            if (nicks != null) {
                int size = nicks.size();
                channelRecipientNick = null;
                for (int i = 0; i < size; i++) {
                    if (nicks.get(i).getId() == user.getId()) {
                        channelRecipientNick = nicks.get(i);
                    }
                }
            } else {
                channelRecipientNick = null;
            }
            if (channelRecipientNick != null) {
                nick = channelRecipientNick.getNick();
            }
            treeSet.add(new UserAutocompletable(user, null, nick, (Presence) C1643a.m849f(user, presences), false, 16, null));
        }
        return C12134g0.mapOf(C12116o.m10073to(LeadingIdentifier.MENTION, treeSet));
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createAutocompletablesForUsers(long myId, Channel channel, Channel parentChannel, long guildOwnerId, Map<Long, GuildRole> roles, Map<Long, GuildMember> members, Map<Long, ? extends User> users, Map<Long, Presence> presences, Long permissions) {
        Collection arrayList;
        boolean zCan;
        boolean zCan2;
        if (members.size() > 3000) {
            int size = members.size() / 100;
            arrayList = ShallowPartitionCollection.INSTANCE.withArrayListPartions(size, new C7805x8d4222e6(size));
        } else {
            arrayList = new ArrayList(members.size());
        }
        boolean zCanEveryone = PermissionUtils.canEveryone(Permission.VIEW_CHANNEL, channel, parentChannel, roles);
        for (Map.Entry<Long, GuildMember> entry : members.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            GuildMember value = entry.getValue();
            if (zCanEveryone || (zCan2 = PermissionUtils.can(Permission.VIEW_CHANNEL, Long.valueOf(PermissionUtils.computePermissions(jLongValue, channel, parentChannel, guildOwnerId, value, roles, null, true))))) {
                User user = users.get(Long.valueOf(jLongValue));
                if (user != null) {
                    arrayList.add(new UserAutocompletable(user, value, value.getNick(), presences.get(Long.valueOf(jLongValue)), false, 16, null));
                }
            } else {
                User user2 = users.get(Long.valueOf(jLongValue));
                if (user2 != null) {
                    arrayList.add(new UserAutocompletable(user2, value, value.getNick(), presences.get(Long.valueOf(jLongValue)), zCan2));
                }
            }
        }
        if (members.get(Long.valueOf(myId)) != null) {
            zCan = PermissionUtils.can(Permission.MENTION_EVERYONE, permissions);
            if (zCan) {
                GlobalRoleAutocompletable.Companion companion = GlobalRoleAutocompletable.INSTANCE;
                arrayList.add(companion.getHere());
                arrayList.add(companion.getEveryone());
            }
        } else {
            zCan = false;
        }
        for (GuildRole guildRole : roles.values()) {
            if (guildRole.getId() != channel.getGuildId()) {
                arrayList.add(new RoleAutocompletable(guildRole, guildRole.getMentionable() || zCan));
            }
        }
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        treeSet.addAll(arrayList);
        return C12134g0.mapOf(C12116o.m10073to(LeadingIdentifier.MENTION, treeSet));
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

    public final StoreUserPresence getStorePresences() {
        return this.storePresences;
    }

    public final StoreUser getStoreUsers() {
        return this.storeUsers;
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeUserAutocompletables(final Channel channel) {
        Observable observableM11099Y;
        C12238m.checkNotNullParameter(channel, "channel");
        long guildId = channel.getGuildId();
        if (UserMentionableSourceKt.isTextOrVoiceChannel(channel)) {
            Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(this.storeUsers.observeMeId());
            Observable<R> observableM11083G = this.storeGuilds.observeGuild(guildId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            Observable observableM11112r = observableM11083G.m11083G(new InterfaceC12589b<Guild, Long>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Long call(Guild guild) {
                    return Long.valueOf(guild.getOwnerId());
                }
            }).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "storeGuilds.observeGuild… }.distinctUntilChanged()");
            Observable observableComputationLatest2 = ObservableExtensionsKt.computationLatest(observableM11112r);
            Observable observableComputationLatest3 = ObservableExtensionsKt.computationLatest(this.storeGuilds.observeRoles(guildId));
            Observable<Map<Long, GuildMember>> observableObserveComputed = this.storeGuilds.observeComputed(guildId);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Observable observableComputationLatest4 = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(observableObserveComputed, 5L, timeUnit));
            Observable observableComputationLatest5 = ObservableExtensionsKt.computationLatest(this.storeUsers.observeAllUsers());
            Observable observableComputationLatest6 = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(this.storePresences.observeAllPresences(), 10L, timeUnit));
            Observable<Long> observableM11112r2 = this.storePermissions.observePermissionsForChannel(channel.getId()).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r2, "storePermissions.observe…d).distinctUntilChanged()");
            Observable observableComputationLatest7 = ObservableExtensionsKt.computationLatest(observableM11112r2);
            Observable<Channel> observableM11112r3 = this.storeChannels.observeChannel(channel.getParentId()).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r3, "storeChannels.observeCha…d).distinctUntilChanged()");
            observableM11099Y = Observable.m11067d(observableComputationLatest, observableComputationLatest2, observableComputationLatest3, observableComputationLatest4, observableComputationLatest5, observableComputationLatest6, observableComputationLatest7, ObservableExtensionsKt.computationLatest(observableM11112r3), new Func8<Long, Long, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Long, Channel, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.2
                @Override // p658rx.functions.Func8
                public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Long l, Long l2, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, ? extends Presence> map4, Long l3, Channel channel2) {
                    return call2(l, l2, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, map3, (Map<Long, Presence>) map4, l3, channel2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Long l, Long l2, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Long l3, Channel channel2) {
                    UserAutocompletableSource userAutocompletableSource = UserAutocompletableSource.this;
                    C12238m.checkNotNullExpressionValue(l, "myId");
                    long jLongValue = l.longValue();
                    Channel channel3 = channel;
                    C12238m.checkNotNullExpressionValue(l2, "guildOwnerId");
                    long jLongValue2 = l2.longValue();
                    C12238m.checkNotNullExpressionValue(map, "roles");
                    C12238m.checkNotNullExpressionValue(map2, "members");
                    C12238m.checkNotNullExpressionValue(map3, "users");
                    C12238m.checkNotNullExpressionValue(map4, "presences");
                    return userAutocompletableSource.createAutocompletablesForUsers(jLongValue, channel3, channel2, jLongValue2, map, map2, map3, map4, l3);
                }
            });
        } else {
            observableM11099Y = UserMentionableSourceKt.isDmOrGroupDm(channel) ? Observable.m11076j(Observable.m11058B(ChannelUtils.m7683g(channel)).m11083G(new InterfaceC12589b<User, Long>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.3
                @Override // p637j0.p641k.InterfaceC12589b
                public final Long call(User user) {
                    return Long.valueOf(user.getId());
                }
            }).m11105f0(), this.storeUsers.observeMeId(), new Func2<List<Long>, Long, List<Long>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.4
                @Override // p658rx.functions.Func2
                public final List<Long> call(List<Long> list, Long l) {
                    list.add(l);
                    return list;
                }
            }).m11099Y(new InterfaceC12589b<List<Long>, Observable<? extends Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.5
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends Map<LeadingIdentifier, TreeSet<Autocompletable>>> call(List<Long> list) {
                    StoreUser storeUsers = UserAutocompletableSource.this.getStoreUsers();
                    C12238m.checkNotNullExpressionValue(list, "recipientIds");
                    return Observable.m11076j(storeUsers.observeUsers(list), UserAutocompletableSource.this.getStorePresences().observePresencesForUsers(list), new Func2<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.5.1
                        @Override // p658rx.functions.Func2
                        public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2) {
                            return call2(map, (Map<Long, Presence>) map2);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Map<Long, ? extends User> map, Map<Long, Presence> map2) {
                            UserAutocompletableSource userAutocompletableSource = UserAutocompletableSource.this;
                            C12238m.checkNotNullExpressionValue(map, "users");
                            C12238m.checkNotNullExpressionValue(map2, "presences");
                            return userAutocompletableSource.createAutocompletablesForDmUsers(map, map2, channel.m7650q());
                        }
                    }).m11112r();
                }
            }) : new C12721k(C12136h0.emptyMap());
        }
        C12238m.checkNotNullExpressionValue(observableM11099Y, "when {\n      // Guild Ch…vable.just(mapOf())\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableM11112r4 = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r4, "when {\n      // Guild Ch…  .distinctUntilChanged()");
        return observableM11112r4;
    }
}
