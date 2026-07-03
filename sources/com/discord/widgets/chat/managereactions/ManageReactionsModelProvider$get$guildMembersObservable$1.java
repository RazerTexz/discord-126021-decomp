package com.discord.widgets.chat.managereactions;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$guildMembersObservable$1 extends AbstractC12240o implements Function0<Map<Long, ? extends GuildMember>> {
    public final /* synthetic */ ManageReactionsModelProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsModelProvider$get$guildMembersObservable$1(ManageReactionsModelProvider manageReactionsModelProvider) {
        super(0);
        this.this$0 = manageReactionsModelProvider;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<Long, ? extends GuildMember> invoke() {
        Channel channel = this.this$0.storeChannels.getChannel(this.this$0.getChannelId());
        Map<Long, GuildMember> map = this.this$0.storeGuilds.getMembers().get(channel != null ? Long.valueOf(channel.getGuildId()) : null);
        return map != null ? map : C12136h0.emptyMap();
    }
}
