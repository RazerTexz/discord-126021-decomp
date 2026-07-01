package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$configureUI$3 extends o implements Function1<InviteSuggestionItem, Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInviteShareViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetGuildInviteShareCompact this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareCompact$configureUI$3(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded, ModelInvite modelInvite) {
        super(1);
        this.this$0 = widgetGuildInviteShareCompact;
        this.$viewState = widgetGuildInviteShareViewModel$ViewState$Loaded;
        this.$invite = modelInvite;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
        invoke2(inviteSuggestionItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
        m.checkNotNullParameter(inviteSuggestionItem, "item");
        WidgetGuildInviteShareCompact.access$sendInvite(this.this$0, inviteSuggestionItem, this.$viewState, this.$invite);
    }
}
