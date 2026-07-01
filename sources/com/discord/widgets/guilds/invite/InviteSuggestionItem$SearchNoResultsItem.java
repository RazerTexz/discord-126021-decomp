package com.discord.widgets.guilds.invite;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InviteSuggestionItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionItem$SearchNoResultsItem extends InviteSuggestionItem {
    private InviteSuggestionItem$SearchNoResultsItem() {
        super(null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return InviteSuggestionItem.access$getKey$cp();
    }

    @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
    public boolean hasSentInvite() {
        return true;
    }

    public /* synthetic */ InviteSuggestionItem$SearchNoResultsItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
