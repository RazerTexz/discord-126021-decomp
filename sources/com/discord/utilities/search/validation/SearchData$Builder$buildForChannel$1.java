package com.discord.utilities.search.validation;

import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchData$Builder$buildForChannel$1 extends AbstractC12240o implements Function1<User, Unit> {
    public final /* synthetic */ Map $guildMembers;
    public final /* synthetic */ HashMap $usernameAndDiscriminatorIndex;
    public final /* synthetic */ HashMap $users;
    public final /* synthetic */ SearchData.Builder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchData$Builder$buildForChannel$1(SearchData.Builder builder, HashMap map, Map map2, HashMap map3) {
        super(1);
        this.this$0 = builder;
        this.$users = map;
        this.$guildMembers = map2;
        this.$usernameAndDiscriminatorIndex = map3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        C12238m.checkNotNullParameter(user, "recipient");
        this.$users.put(Long.valueOf(user.getId()), new UserGuildMember(user, (GuildMember) C1643a.m849f(user, this.$guildMembers)));
        this.$usernameAndDiscriminatorIndex.put(this.this$0.getUsernameWithDiscrim(user), Long.valueOf(user.getId()));
    }
}
