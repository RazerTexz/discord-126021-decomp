package com.discord.widgets.servers.role_members;

import com.discord.models.member.GuildMember;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1$guildMembers$1 extends o implements Function1<GuildMember, Boolean> {
    public final /* synthetic */ ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1$guildMembers$1(ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1 serverSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1) {
        super(1);
        this.this$0 = serverSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(GuildMember guildMember) {
        return Boolean.valueOf(invoke2(guildMember));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(GuildMember guildMember) {
        m.checkNotNullParameter(guildMember, "it");
        return guildMember.getRoles().contains(Long.valueOf(this.this$0.$guildRoleId));
    }
}
