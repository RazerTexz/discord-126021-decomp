package com.discord.widgets.servers.role_members;

import com.discord.models.member.GuildMember;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1$guildMembers$1 */
/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9573xc3c051d3 extends AbstractC12240o implements Function1<GuildMember, Boolean> {
    public final /* synthetic */ C9572x9be5b784 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9573xc3c051d3(C9572x9be5b784 c9572x9be5b784) {
        super(1);
        this.this$0 = c9572x9be5b784;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(GuildMember guildMember) {
        return Boolean.valueOf(invoke2(guildMember));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(GuildMember guildMember) {
        C12238m.checkNotNullParameter(guildMember, "it");
        return guildMember.getRoles().contains(Long.valueOf(this.this$0.$guildRoleId));
    }
}
