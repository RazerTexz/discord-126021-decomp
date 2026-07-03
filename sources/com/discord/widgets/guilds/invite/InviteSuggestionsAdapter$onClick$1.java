package com.discord.widgets.guilds.invite;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InviteSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsAdapter$onClick$1 extends AbstractC12240o implements Function1<InviteSuggestionItemV2, Unit> {
    public static final InviteSuggestionsAdapter$onClick$1 INSTANCE = new InviteSuggestionsAdapter$onClick$1();

    public InviteSuggestionsAdapter$onClick$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItemV2 inviteSuggestionItemV2) {
        invoke2(inviteSuggestionItemV2);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InviteSuggestionItemV2 inviteSuggestionItemV2) {
        C12238m.checkNotNullParameter(inviteSuggestionItemV2, "it");
    }
}
