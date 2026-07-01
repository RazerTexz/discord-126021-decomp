package com.discord.widgets.servers.role_members;

import com.discord.models.member.GuildMember;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1$guildMembers$1, reason: use source file name */
/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel3 extends Lambda implements Function1<GuildMember, Boolean> {
    public final /* synthetic */ ServerSettingsRoleMembersViewModel2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel3(ServerSettingsRoleMembersViewModel2 serverSettingsRoleMembersViewModel2) {
        super(1);
        this.this$0 = serverSettingsRoleMembersViewModel2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(GuildMember guildMember) {
        return Boolean.valueOf(invoke2(guildMember));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(guildMember, "it");
        return guildMember.getRoles().contains(Long.valueOf(this.this$0.$guildRoleId));
    }
}
