package com.discord.widgets.chat.managereactions;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$guildMembersObservable$1 extends o implements Function0<Map<Long, ? extends GuildMember>> {
    public final /* synthetic */ ManageReactionsModelProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsModelProvider$get$guildMembersObservable$1(ManageReactionsModelProvider manageReactionsModelProvider) {
        super(0);
        this.this$0 = manageReactionsModelProvider;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends GuildMember> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends GuildMember> invoke2() {
        Channel channel = ManageReactionsModelProvider.access$getStoreChannels$p(this.this$0).getChannel(this.this$0.getChannelId());
        Map<Long, GuildMember> map = ManageReactionsModelProvider.access$getStoreGuilds$p(this.this$0).getMembers().get(channel != null ? Long.valueOf(channel.getGuildId()) : null);
        return map != null ? map : h0.emptyMap();
    }
}
