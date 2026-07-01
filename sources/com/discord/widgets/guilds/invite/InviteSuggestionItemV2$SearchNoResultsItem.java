package com.discord.widgets.guilds.invite;


/* JADX INFO: compiled from: InviteSuggestionItemV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionItemV2$SearchNoResultsItem extends InviteSuggestionItemV2 {
    public static final InviteSuggestionItemV2$SearchNoResultsItem INSTANCE = new InviteSuggestionItemV2$SearchNoResultsItem();
    private static final int type = 1;
    private static final String key = "SEARCH_NO_RESULTS";

    private InviteSuggestionItemV2$SearchNoResultsItem() {
        super(null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return type;
    }

    @Override // com.discord.widgets.guilds.invite.InviteSuggestionItemV2
    public boolean hasSentInvite() {
        return true;
    }
}
