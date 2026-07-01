package com.discord.widgets.guilds.invite;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteSuggestionsAdapter$onClick$1, reason: use source file name */
/* JADX INFO: compiled from: InviteSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsAdapter3 extends Lambda implements Function1<InviteSuggestionItemV2, Unit> {
    public static final InviteSuggestionsAdapter3 INSTANCE = new InviteSuggestionsAdapter3();

    public InviteSuggestionsAdapter3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItemV2 inviteSuggestionItemV2) {
        invoke2(inviteSuggestionItemV2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InviteSuggestionItemV2 inviteSuggestionItemV2) {
        Intrinsics3.checkNotNullParameter(inviteSuggestionItemV2, "it");
    }
}
