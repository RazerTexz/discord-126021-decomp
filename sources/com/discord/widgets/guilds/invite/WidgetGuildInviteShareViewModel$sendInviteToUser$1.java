package com.discord.widgets.guilds.invite;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel$sendInviteToUser$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInviteShareViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetGuildInviteShareViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareViewModel$sendInviteToUser$1(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded, ModelInvite modelInvite) {
        super(1);
        this.this$0 = widgetGuildInviteShareViewModel;
        this.$viewState = widgetGuildInviteShareViewModel$ViewState$Loaded;
        this.$invite = modelInvite;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.this$0.sendInviteToChannel(channel.getId(), this.$viewState, this.$invite);
    }
}
