package com.discord.widgets.guilds.invite;

import android.content.Context;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.accessibility.AccessibilityUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$configureUI$3 extends o implements Function1<InviteSuggestionItem, Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInviteShareViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetGuildInviteShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShare$configureUI$3(WidgetGuildInviteShare widgetGuildInviteShare, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded, ModelInvite modelInvite) {
        super(1);
        this.this$0 = widgetGuildInviteShare;
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
        WidgetGuildInviteShare.access$sendInvite(this.this$0, inviteSuggestionItem, this.$viewState, this.$invite);
        AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
        Context context = WidgetGuildInviteShare.access$getAdapter$p(this.this$0).getContext();
        String string = this.this$0.getString(2131892322);
        m.checkNotNullExpressionValue(string, "getString(R.string.invite_sent)");
        accessibilityUtils.sendAnnouncement(context, string);
    }
}
