package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: InviteSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteSuggestion$UserSuggestion extends InviteSuggestion {
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestion$UserSuggestion(User user) {
        super(null);
        m.checkNotNullParameter(user, "user");
        this.user = user;
    }

    public static /* synthetic */ InviteSuggestion$UserSuggestion copy$default(InviteSuggestion$UserSuggestion inviteSuggestion$UserSuggestion, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            user = inviteSuggestion$UserSuggestion.user;
        }
        return inviteSuggestion$UserSuggestion.copy(user);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final InviteSuggestion$UserSuggestion copy(User user) {
        m.checkNotNullParameter(user, "user");
        return new InviteSuggestion$UserSuggestion(user);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof InviteSuggestion$UserSuggestion) && m.areEqual(this.user, ((InviteSuggestion$UserSuggestion) other).user);
        }
        return true;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        if (user != null) {
            return user.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("UserSuggestion(user=");
        sbU.append(this.user);
        sbU.append(")");
        return sbU.toString();
    }
}
