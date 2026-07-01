package com.discord.widgets.guilds.invite;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1 extends o implements Function1<InviteSuggestionItem, Unit> {
    public static final WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1 INSTANCE = new WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1();

    public WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
        invoke2(inviteSuggestionItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
        m.checkNotNullParameter(inviteSuggestionItem, "it");
    }
}
