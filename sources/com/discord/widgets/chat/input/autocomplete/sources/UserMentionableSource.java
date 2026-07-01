package com.discord.widgets.chat.input.autocomplete.sources;

import b.d.b.a.outline;
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
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.GlobalRoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import com.discord.widgets.chat.input.autocomplete.RoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func8;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource, reason: use source file name */
/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserMentionableSource {
    private static final int PARTITION_HUGE_GUILD_SIZE = 3000;
    private static final int PARTITION_IDEAL_PARTITION_SIZE = 100;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUserPresence storePresences;
    private final StoreUser storeUsers;

    public UserMentionableSource(StoreUser storeUser, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreChannels storeChannels) {
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storePresences");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
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
            treeSet.add(new UserAutocompletable(user, null, nick, (Presence) outline.f(user, presences), false, 16, null));
        }
        return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.MENTION, treeSet));
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createAutocompletablesForUsers(long myId, Channel channel, Channel parentChannel, long guildOwnerId, Map<Long, GuildRole> roles, Map<Long, GuildMember> members, Map<Long, ? extends User> users, Map<Long, Presence> presences, Long permissions) {
        Collection arrayList;
        boolean zCan;
        boolean zCan2;
        if (members.size() > 3000) {
            int size = members.size() / 100;
            arrayList = ShallowPartitionCollection.INSTANCE.withArrayListPartions(size, new UserMentionableSource2(size));
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
        return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.MENTION, treeSet));
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
        Observable observableY;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        long guildId = channel.getGuildId();
        if (UserMentionableSource3.isTextOrVoiceChannel(channel)) {
            Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(this.storeUsers.observeMeId());
            Observable<R> observableG = this.storeGuilds.observeGuild(guildId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable observableR = observableG.G(new Func1<Guild, Long>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.1
                @Override // j0.k.Func1
                public final Long call(Guild guild) {
                    return Long.valueOf(guild.getOwnerId());
                }
            }).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "storeGuilds.observeGuild… }.distinctUntilChanged()");
            Observable observableComputationLatest2 = ObservableExtensionsKt.computationLatest(observableR);
            Observable observableComputationLatest3 = ObservableExtensionsKt.computationLatest(this.storeGuilds.observeRoles(guildId));
            Observable<Map<Long, GuildMember>> observableObserveComputed = this.storeGuilds.observeComputed(guildId);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Observable observableComputationLatest4 = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(observableObserveComputed, 5L, timeUnit));
            Observable observableComputationLatest5 = ObservableExtensionsKt.computationLatest(this.storeUsers.observeAllUsers());
            Observable observableComputationLatest6 = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(this.storePresences.observeAllPresences(), 10L, timeUnit));
            Observable<Long> observableR2 = this.storePermissions.observePermissionsForChannel(channel.getId()).r();
            Intrinsics3.checkNotNullExpressionValue(observableR2, "storePermissions.observe…d).distinctUntilChanged()");
            Observable observableComputationLatest7 = ObservableExtensionsKt.computationLatest(observableR2);
            Observable<Channel> observableR3 = this.storeChannels.observeChannel(channel.getParentId()).r();
            Intrinsics3.checkNotNullExpressionValue(observableR3, "storeChannels.observeCha…d).distinctUntilChanged()");
            observableY = Observable.d(observableComputationLatest, observableComputationLatest2, observableComputationLatest3, observableComputationLatest4, observableComputationLatest5, observableComputationLatest6, observableComputationLatest7, ObservableExtensionsKt.computationLatest(observableR3), new Func8<Long, Long, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Long, Channel, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.2
                @Override // rx.functions.Func8
                public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Long l, Long l2, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, ? extends Presence> map4, Long l3, Channel channel2) {
                    return call2(l, l2, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, map3, (Map<Long, Presence>) map4, l3, channel2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Long l, Long l2, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Long l3, Channel channel2) {
                    UserMentionableSource userMentionableSource = UserMentionableSource.this;
                    Intrinsics3.checkNotNullExpressionValue(l, "myId");
                    long jLongValue = l.longValue();
                    Channel channel3 = channel;
                    Intrinsics3.checkNotNullExpressionValue(l2, "guildOwnerId");
                    long jLongValue2 = l2.longValue();
                    Intrinsics3.checkNotNullExpressionValue(map, "roles");
                    Intrinsics3.checkNotNullExpressionValue(map2, "members");
                    Intrinsics3.checkNotNullExpressionValue(map3, "users");
                    Intrinsics3.checkNotNullExpressionValue(map4, "presences");
                    return userMentionableSource.createAutocompletablesForUsers(jLongValue, channel3, channel2, jLongValue2, map, map2, map3, map4, l3);
                }
            });
        } else {
            observableY = UserMentionableSource3.isDmOrGroupDm(channel) ? Observable.j(Observable.B(ChannelUtils.g(channel)).G(new Func1<User, Long>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.3
                @Override // j0.k.Func1
                public final Long call(User user) {
                    return Long.valueOf(user.getId());
                }
            }).f0(), this.storeUsers.observeMeId(), new Func2<List<Long>, Long, List<Long>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.4
                @Override // rx.functions.Func2
                public final List<Long> call(List<Long> list, Long l) {
                    list.add(l);
                    return list;
                }
            }).Y(new Func1<List<Long>, Observable<? extends Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.5
                @Override // j0.k.Func1
                public final Observable<? extends Map<LeadingIdentifier, TreeSet<Autocompletable>>> call(List<Long> list) {
                    StoreUser storeUsers = UserMentionableSource.this.getStoreUsers();
                    Intrinsics3.checkNotNullExpressionValue(list, "recipientIds");
                    return Observable.j(storeUsers.observeUsers(list), UserMentionableSource.this.getStorePresences().observePresencesForUsers(list), new Func2<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource.observeUserAutocompletables.5.1
                        @Override // rx.functions.Func2
                        public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2) {
                            return call2(map, (Map<Long, Presence>) map2);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Map<Long, ? extends User> map, Map<Long, Presence> map2) {
                            UserMentionableSource userMentionableSource = UserMentionableSource.this;
                            Intrinsics3.checkNotNullExpressionValue(map, "users");
                            Intrinsics3.checkNotNullExpressionValue(map2, "presences");
                            return userMentionableSource.createAutocompletablesForDmUsers(map, map2, channel.q());
                        }
                    }).r();
                }
            }) : new ScalarSynchronousObservable(Maps6.emptyMap());
        }
        Intrinsics3.checkNotNullExpressionValue(observableY, "when {\n      // Guild Ch…vable.just(mapOf())\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableR4 = ObservableExtensionsKt.computationLatest(observableY).r();
        Intrinsics3.checkNotNullExpressionValue(observableR4, "when {\n      // Guild Ch…  .distinctUntilChanged()");
        return observableR4;
    }
}
