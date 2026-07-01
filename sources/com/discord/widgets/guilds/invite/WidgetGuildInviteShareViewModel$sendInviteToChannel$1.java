package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreStream;
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

/* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel$sendInviteToChannel$1 extends o implements Function1<MessageResult, Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ String $inviteLink;
    public final /* synthetic */ WidgetGuildInviteShareViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetGuildInviteShareViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareViewModel$sendInviteToChannel$1(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, ModelInvite modelInvite, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded, String str) {
        super(1);
        this.this$0 = widgetGuildInviteShareViewModel;
        this.$invite = modelInvite;
        this.$viewState = widgetGuildInviteShareViewModel$ViewState$Loaded;
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
            StoreStream.Companion.getAnalytics().inviteSent(this.$invite, messageResult$Success.getMessage(), "Guild Create Invite Suggestion");
            Map<String, Set<Long>> sentInvites = this.$viewState.getSentInvites();
            String str = this.$inviteLink;
            m.checkNotNullExpressionValue(str, "inviteLink");
            Set<Long> setEmptySet = sentInvites.get(str);
            if (setEmptySet == null) {
                setEmptySet = n0.emptySet();
            }
            WidgetGuildInviteShareViewModel.access$updateSentInvites(this.this$0, h0.plus(sentInvites, g0.mapOf(d0.o.to(this.$inviteLink, o0.plus(setEmptySet, Long.valueOf(messageResult$Success.getMessage().getChannelId()))))));
        }
    }
}
