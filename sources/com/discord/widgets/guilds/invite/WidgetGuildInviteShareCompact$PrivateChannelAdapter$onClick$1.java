package com.discord.widgets.guilds.invite;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1 extends AbstractC12240o implements Function1<InviteSuggestionItem, Unit> {
    public static final WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1 INSTANCE = new WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1();

    public WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
        invoke2(inviteSuggestionItem);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
        C12238m.checkNotNullParameter(inviteSuggestionItem, "it");
    }
}
