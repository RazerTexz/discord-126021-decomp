package com.discord.widgets.chat.managereactions;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import d0.t.Maps6;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$guildMembersObservable$1, reason: use source file name */
/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModel3 extends Lambda implements Function0<Map<Long, ? extends GuildMember>> {
    public final /* synthetic */ ManageReactionsModel2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsModel3(ManageReactionsModel2 manageReactionsModel2) {
        super(0);
        this.this$0 = manageReactionsModel2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<Long, ? extends GuildMember> invoke() {
        Channel channel = this.this$0.storeChannels.getChannel(this.this$0.getChannelId());
        Map<Long, GuildMember> map = this.this$0.storeGuilds.getMembers().get(channel != null ? Long.valueOf(channel.getGuildId()) : null);
        return map != null ? map : Maps6.emptyMap();
    }
}
