package com.discord.widgets.servers.role_members;

import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import d0.f0.q;
import d0.t.n;
import d0.t.u;
import d0.z.d.o;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1 extends o implements Function0<ServerSettingsRoleMembersViewModel$StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $guildRoleId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUser $storeUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1(StoreGuilds storeGuilds, long j, long j2, StoreUser storeUser) {
        super(0);
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$guildRoleId = j2;
        this.$storeUser = storeUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsRoleMembersViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsRoleMembersViewModel$StoreState invoke() {
        List listEmptyList;
        Collection<GuildMember> collectionValues;
        Sequence sequenceAsSequence;
        Sequence sequenceFilter;
        Map<Long, GuildMember> map = this.$storeGuilds.getMembers().get(Long.valueOf(this.$guildId));
        if (map == null || (collectionValues = map.values()) == null || (sequenceAsSequence = u.asSequence(collectionValues)) == null || (sequenceFilter = q.filter(sequenceAsSequence, new ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1$guildMembers$1(this))) == null || (listEmptyList = q.toList(sequenceFilter)) == null) {
            listEmptyList = n.emptyList();
        }
        Map<Long, User> users = this.$storeUser.getUsers();
        Map<Long, GuildRole> map2 = this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId));
        return new ServerSettingsRoleMembersViewModel$StoreState(listEmptyList, users, map2 != null ? map2.get(Long.valueOf(this.$guildRoleId)) : null);
    }
}
