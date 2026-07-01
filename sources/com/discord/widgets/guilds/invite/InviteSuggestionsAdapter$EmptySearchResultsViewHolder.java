package com.discord.widgets.guilds.invite;

import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: InviteSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsAdapter$EmptySearchResultsViewHolder extends MGRecyclerViewHolder<InviteSuggestionsAdapter, InviteSuggestionItemV2> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestionsAdapter$EmptySearchResultsViewHolder(InviteSuggestionsAdapter inviteSuggestionsAdapter) {
        super(R$layout.guild_invite_empty_search_results_item, inviteSuggestionsAdapter);
        m.checkNotNullParameter(inviteSuggestionsAdapter, "adapter");
    }
}
