package com.discord.widgets.chat.input.autocomplete.sources;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
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
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.GlobalRoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.GlobalRoleAutocompletable$Companion;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import com.discord.widgets.chat.input.autocomplete.RoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAutocompletableSource {
    public static final UserAutocompletableSource$Companion Companion = new UserAutocompletableSource$Companion(null);
    private static final int PARTITION_HUGE_GUILD_SIZE = 3000;
    private static final int PARTITION_IDEAL_PARTITION_SIZE = 100;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUserPresence storePresences;
    private final StoreUser storeUsers;

    public UserAutocompletableSource(StoreUser storeUser, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreChannels storeChannels) {
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUserPresence, "storePresences");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storePresences = storeUserPresence;
        this.storePermissions = storePermissions;
        this.storeChannels = storeChannels;
    }

    public static final /* synthetic */ Map access$createAutocompletablesForDmUsers(UserAutocompletableSource userAutocompletableSource, Map map, Map map2, List list) {
        return userAutocompletableSource.createAutocompletablesForDmUsers(map, map2, list);
    }

    public static final /* synthetic */ Map access$createAutocompletablesForUsers(UserAutocompletableSource userAutocompletableSource, long j, Channel channel, Channel channel2, long j2, Map map, Map map2, Map map3, Map map4, Long l) {
        return userAutocompletableSource.createAutocompletablesForUsers(j, channel, channel2, j2, map, map2, map3, map4, l);
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
            treeSet.add(new UserAutocompletable(user, null, nick, (Presence) a.f(user, presences), false, 16, null));
        }
        return g0.mapOf(o.to(LeadingIdentifier.MENTION, treeSet));
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createAutocompletablesForUsers(long myId, Channel channel, Channel parentChannel, long guildOwnerId, Map<Long, GuildRole> roles, Map<Long, GuildMember> members, Map<Long, ? extends User> users, Map<Long, Presence> presences, Long permissions) {
        Collection arrayList;
        boolean zCan;
        boolean zCan2;
        if (members.size() > 3000) {
            int size = members.size() / 100;
            arrayList = ShallowPartitionCollection.Companion.withArrayListPartions(size, new UserAutocompletableSource$createAutocompletablesForUsers$mentions$1(size));
        } else {
            arrayList = new ArrayList(members.size());
        }
        boolean zCanEveryone = PermissionUtils.canEveryone(Permission.VIEW_CHANNEL, channel, parentChannel, roles);
        for (Map$Entry<Long, GuildMember> map$Entry : members.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            GuildMember value = map$Entry.getValue();
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
                GlobalRoleAutocompletable$Companion globalRoleAutocompletable$Companion = GlobalRoleAutocompletable.Companion;
                arrayList.add(globalRoleAutocompletable$Companion.getHere());
                arrayList.add(globalRoleAutocompletable$Companion.getEveryone());
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
        return g0.mapOf(o.to(LeadingIdentifier.MENTION, treeSet));
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

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeUserAutocompletables(Channel channel) {
        Observable observableY;
        m.checkNotNullParameter(channel, "channel");
        long guildId = channel.getGuildId();
        if (UserMentionableSourceKt.access$isTextOrVoiceChannel(channel)) {
            Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(this.storeUsers.observeMeId());
            Observable<R> observableG = this.storeGuilds.observeGuild(guildId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable observableR = observableG.G(UserAutocompletableSource$observeUserAutocompletables$1.INSTANCE).r();
            m.checkNotNullExpressionValue(observableR, "storeGuilds.observeGuild… }.distinctUntilChanged()");
            Observable observableComputationLatest2 = ObservableExtensionsKt.computationLatest(observableR);
            Observable observableComputationLatest3 = ObservableExtensionsKt.computationLatest(this.storeGuilds.observeRoles(guildId));
            Observable<Map<Long, GuildMember>> observableObserveComputed = this.storeGuilds.observeComputed(guildId);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Observable observableComputationLatest4 = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(observableObserveComputed, 5L, timeUnit));
            Observable observableComputationLatest5 = ObservableExtensionsKt.computationLatest(this.storeUsers.observeAllUsers());
            Observable observableComputationLatest6 = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(this.storePresences.observeAllPresences(), 10L, timeUnit));
            Observable<Long> observableR2 = this.storePermissions.observePermissionsForChannel(channel.getId()).r();
            m.checkNotNullExpressionValue(observableR2, "storePermissions.observe…d).distinctUntilChanged()");
            Observable observableComputationLatest7 = ObservableExtensionsKt.computationLatest(observableR2);
            Observable<Channel> observableR3 = this.storeChannels.observeChannel(channel.getParentId()).r();
            m.checkNotNullExpressionValue(observableR3, "storeChannels.observeCha…d).distinctUntilChanged()");
            observableY = Observable.d(observableComputationLatest, observableComputationLatest2, observableComputationLatest3, observableComputationLatest4, observableComputationLatest5, observableComputationLatest6, observableComputationLatest7, ObservableExtensionsKt.computationLatest(observableR3), new UserAutocompletableSource$observeUserAutocompletables$2(this, channel));
        } else {
            observableY = UserMentionableSourceKt.access$isDmOrGroupDm(channel) ? Observable.j(Observable.B(ChannelUtils.g(channel)).G(UserAutocompletableSource$observeUserAutocompletables$3.INSTANCE).f0(), this.storeUsers.observeMeId(), UserAutocompletableSource$observeUserAutocompletables$4.INSTANCE).Y(new UserAutocompletableSource$observeUserAutocompletables$5(this, channel)) : new k(h0.emptyMap());
        }
        m.checkNotNullExpressionValue(observableY, "when {\n      // Guild Ch…vable.just(mapOf())\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableR4 = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR4, "when {\n      // Guild Ch…  .distinctUntilChanged()");
        return observableR4;
    }
}
