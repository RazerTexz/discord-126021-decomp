package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: InviteSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsAdapter$InviteSuggestionViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ InviteSuggestionItemV2 $data;
    public final /* synthetic */ InviteSuggestionsAdapter$InviteSuggestionViewHolder this$0;

    public InviteSuggestionsAdapter$InviteSuggestionViewHolder$onConfigure$1(InviteSuggestionsAdapter$InviteSuggestionViewHolder inviteSuggestionsAdapter$InviteSuggestionViewHolder, InviteSuggestionItemV2 inviteSuggestionItemV2) {
        this.this$0 = inviteSuggestionsAdapter$InviteSuggestionViewHolder;
        this.$data = inviteSuggestionItemV2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        InviteSuggestionsAdapter$InviteSuggestionViewHolder.access$getAdapter$p(this.this$0).getOnClick().invoke(this.$data);
    }
}
