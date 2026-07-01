package com.discord.widgets.guildcommunicationdisabled.start;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DisableGuildCommunicationViewModel$StoreState {
    private final Guild guild;
    private final User user;

    public DisableGuildCommunicationViewModel$StoreState(User user, Guild guild) {
        this.user = user;
        this.guild = guild;
    }

    public static /* synthetic */ DisableGuildCommunicationViewModel$StoreState copy$default(DisableGuildCommunicationViewModel$StoreState disableGuildCommunicationViewModel$StoreState, User user, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            user = disableGuildCommunicationViewModel$StoreState.user;
        }
        if ((i & 2) != 0) {
            guild = disableGuildCommunicationViewModel$StoreState.guild;
        }
        return disableGuildCommunicationViewModel$StoreState.copy(user, guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final DisableGuildCommunicationViewModel$StoreState copy(User user, Guild guild) {
        return new DisableGuildCommunicationViewModel$StoreState(user, guild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisableGuildCommunicationViewModel$StoreState)) {
            return false;
        }
        DisableGuildCommunicationViewModel$StoreState disableGuildCommunicationViewModel$StoreState = (DisableGuildCommunicationViewModel$StoreState) other;
        return m.areEqual(this.user, disableGuildCommunicationViewModel$StoreState.user) && m.areEqual(this.guild, disableGuildCommunicationViewModel$StoreState.guild);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        Guild guild = this.guild;
        return iHashCode + (guild != null ? guild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(user=");
        sbU.append(this.user);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
