package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: InviteSuggestionItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteSuggestionItem$UserItem extends InviteSuggestionItem {
    private final boolean hasSent;
    private final String key;
    private final int type;
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestionItem$UserItem(User user, boolean z2) {
        super(null);
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.hasSent = z2;
        StringBuilder sbU = a.U("u");
        sbU.append(String.valueOf(user.getId()));
        this.key = sbU.toString();
    }

    public static /* synthetic */ InviteSuggestionItem$UserItem copy$default(InviteSuggestionItem$UserItem inviteSuggestionItem$UserItem, User user, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = inviteSuggestionItem$UserItem.user;
        }
        if ((i & 2) != 0) {
            z2 = inviteSuggestionItem$UserItem.hasSent;
        }
        return inviteSuggestionItem$UserItem.copy(user, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasSent() {
        return this.hasSent;
    }

    public final InviteSuggestionItem$UserItem copy(User user, boolean hasSent) {
        m.checkNotNullParameter(user, "user");
        return new InviteSuggestionItem$UserItem(user, hasSent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteSuggestionItem$UserItem)) {
            return false;
        }
        InviteSuggestionItem$UserItem inviteSuggestionItem$UserItem = (InviteSuggestionItem$UserItem) other;
        return m.areEqual(this.user, inviteSuggestionItem$UserItem.user) && this.hasSent == inviteSuggestionItem$UserItem.hasSent;
    }

    public final boolean getHasSent() {
        return this.hasSent;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
    public boolean hasSentInvite() {
        return this.hasSent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        boolean z2 = this.hasSent;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("UserItem(user=");
        sbU.append(this.user);
        sbU.append(", hasSent=");
        return a.O(sbU, this.hasSent, ")");
    }
}
