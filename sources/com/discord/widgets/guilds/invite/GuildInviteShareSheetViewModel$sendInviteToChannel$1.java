package com.discord.widgets.guilds.invite;

import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$Success;
import d0.t.g0;
import d0.t.h0;
import d0.t.n0;
import d0.t.o0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel$sendInviteToChannel$1 extends o implements Function1<MessageResult, Unit> {
    public final /* synthetic */ GuildInvite $invite;
    public final /* synthetic */ String $inviteLink;
    public final /* synthetic */ GuildInviteShareSheetViewModel$ViewState $viewState;
    public final /* synthetic */ GuildInviteShareSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteShareSheetViewModel$sendInviteToChannel$1(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, GuildInvite guildInvite, GuildInviteShareSheetViewModel$ViewState guildInviteShareSheetViewModel$ViewState, String str) {
        super(1);
        this.this$0 = guildInviteShareSheetViewModel;
        this.$invite = guildInvite;
        this.$viewState = guildInviteShareSheetViewModel$ViewState;
        this.$inviteLink = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
        invoke2(messageResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageResult messageResult) {
        m.checkNotNullParameter(messageResult, "result");
        if (messageResult instanceof MessageResult$Success) {
            MessageResult$Success messageResult$Success = (MessageResult$Success) messageResult;
            GuildInviteShareSheetViewModel.access$getStoreAnalytics$p(this.this$0).inviteSent(this.$invite, this.$viewState.getChannel(), messageResult$Success.getMessage(), "Guild Create Invite Suggestion");
            Map<String, Set<Long>> sentInvites = this.$viewState.getSentInvites();
            Set<Long> setEmptySet = sentInvites.get(this.$inviteLink);
            if (setEmptySet == null) {
                setEmptySet = n0.emptySet();
            }
            GuildInviteShareSheetViewModel.access$updateSentInvites(this.this$0, h0.plus(sentInvites, g0.mapOf(d0.o.to(this.$inviteLink, o0.plus(setEmptySet, Long.valueOf(messageResult$Success.getMessage().getChannelId()))))));
        }
    }
}
