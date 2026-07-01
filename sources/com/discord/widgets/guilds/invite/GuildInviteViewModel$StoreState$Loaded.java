package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.models.domain.ModelInvite;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildInviteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildInviteViewModel$StoreState$Loaded extends GuildInviteViewModel$StoreState {
    private final ModelInvite invite;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteViewModel$StoreState$Loaded(ModelInvite modelInvite) {
        super(null);
        m.checkNotNullParameter(modelInvite, "invite");
        this.invite = modelInvite;
    }

    public static /* synthetic */ GuildInviteViewModel$StoreState$Loaded copy$default(GuildInviteViewModel$StoreState$Loaded guildInviteViewModel$StoreState$Loaded, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = guildInviteViewModel$StoreState$Loaded.invite;
        }
        return guildInviteViewModel$StoreState$Loaded.copy(modelInvite);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final GuildInviteViewModel$StoreState$Loaded copy(ModelInvite invite) {
        m.checkNotNullParameter(invite, "invite");
        return new GuildInviteViewModel$StoreState$Loaded(invite);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildInviteViewModel$StoreState$Loaded) && m.areEqual(this.invite, ((GuildInviteViewModel$StoreState$Loaded) other).invite);
        }
        return true;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        if (modelInvite != null) {
            return modelInvite.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(invite=");
        sbU.append(this.invite);
        sbU.append(")");
        return sbU.toString();
    }
}
