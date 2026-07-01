package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: InviteSuggestionItemV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteSuggestionItemV2$UserItem extends InviteSuggestionItemV2 {
    private final boolean hasSent;
    private final String key;
    private final String searchQuery;
    private final int type;
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestionItemV2$UserItem(User user, boolean z2, String str) {
        super(null);
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(str, "searchQuery");
        this.user = user;
        this.hasSent = z2;
        this.searchQuery = str;
        this.type = 2;
        StringBuilder sbU = a.U("u");
        sbU.append(String.valueOf(user.getId()));
        sbU.append(str);
        this.key = sbU.toString();
    }

    public static /* synthetic */ InviteSuggestionItemV2$UserItem copy$default(InviteSuggestionItemV2$UserItem inviteSuggestionItemV2$UserItem, User user, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            user = inviteSuggestionItemV2$UserItem.user;
        }
        if ((i & 2) != 0) {
            z2 = inviteSuggestionItemV2$UserItem.hasSent;
        }
        if ((i & 4) != 0) {
            str = inviteSuggestionItemV2$UserItem.searchQuery;
        }
        return inviteSuggestionItemV2$UserItem.copy(user, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasSent() {
        return this.hasSent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final InviteSuggestionItemV2$UserItem copy(User user, boolean hasSent, String searchQuery) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(searchQuery, "searchQuery");
        return new InviteSuggestionItemV2$UserItem(user, hasSent, searchQuery);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteSuggestionItemV2$UserItem)) {
            return false;
        }
        InviteSuggestionItemV2$UserItem inviteSuggestionItemV2$UserItem = (InviteSuggestionItemV2$UserItem) other;
        return m.areEqual(this.user, inviteSuggestionItemV2$UserItem.user) && this.hasSent == inviteSuggestionItemV2$UserItem.hasSent && m.areEqual(this.searchQuery, inviteSuggestionItemV2$UserItem.searchQuery);
    }

    public final boolean getHasSent() {
        return this.hasSent;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    @Override // com.discord.widgets.guilds.invite.InviteSuggestionItemV2
    public boolean hasSentInvite() {
        return this.hasSent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        boolean z2 = this.hasSent;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        String str = this.searchQuery;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UserItem(user=");
        sbU.append(this.user);
        sbU.append(", hasSent=");
        sbU.append(this.hasSent);
        sbU.append(", searchQuery=");
        return a.J(sbU, this.searchQuery, ")");
    }
}
