package com.discord.widgets.guilds.invite;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel$sendInviteToUser$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ GuildInviteShareSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteShareSheetViewModel$sendInviteToUser$1(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel) {
        super(1);
        this.this$0 = guildInviteShareSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        GuildInviteShareSheetViewModel.access$sendInviteToChannel(this.this$0, channel.getId());
    }
}
