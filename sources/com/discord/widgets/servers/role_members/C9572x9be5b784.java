package com.discord.widgets.servers.role_members;

import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.Sequence;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1 */
/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9572x9be5b784 extends AbstractC12240o implements Function0<ServerSettingsRoleMembersViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $guildRoleId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUser $storeUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9572x9be5b784(StoreGuilds storeGuilds, long j, long j2, StoreUser storeUser) {
        super(0);
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$guildRoleId = j2;
        this.$storeUser = storeUser;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsRoleMembersViewModel.StoreState invoke() {
        List listEmptyList;
        Collection<GuildMember> collectionValues;
        Sequence sequenceAsSequence;
        Sequence sequenceFilter;
        Map<Long, GuildMember> map = this.$storeGuilds.getMembers().get(Long.valueOf(this.$guildId));
        if (map == null || (collectionValues = map.values()) == null || (sequenceAsSequence = C12163u.asSequence(collectionValues)) == null || (sequenceFilter = C12078q.filter(sequenceAsSequence, new C9573xc3c051d3(this))) == null || (listEmptyList = C12078q.toList(sequenceFilter)) == null) {
            listEmptyList = C12147n.emptyList();
        }
        Map<Long, User> users = this.$storeUser.getUsers();
        Map<Long, GuildRole> map2 = this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId));
        return new ServerSettingsRoleMembersViewModel.StoreState(listEmptyList, users, map2 != null ? map2.get(Long.valueOf(this.$guildRoleId)) : null);
    }
}
