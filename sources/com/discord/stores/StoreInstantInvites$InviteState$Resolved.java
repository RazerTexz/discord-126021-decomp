package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelInvite;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreInstantInvites$InviteState$Resolved extends StoreInstantInvites$InviteState {
    private final ModelInvite invite;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInstantInvites$InviteState$Resolved(ModelInvite modelInvite) {
        super(null);
        m.checkNotNullParameter(modelInvite, "invite");
        this.invite = modelInvite;
    }

    public static /* synthetic */ StoreInstantInvites$InviteState$Resolved copy$default(StoreInstantInvites$InviteState$Resolved storeInstantInvites$InviteState$Resolved, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = storeInstantInvites$InviteState$Resolved.invite;
        }
        return storeInstantInvites$InviteState$Resolved.copy(modelInvite);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final StoreInstantInvites$InviteState$Resolved copy(ModelInvite invite) {
        m.checkNotNullParameter(invite, "invite");
        return new StoreInstantInvites$InviteState$Resolved(invite);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreInstantInvites$InviteState$Resolved) && m.areEqual(this.invite, ((StoreInstantInvites$InviteState$Resolved) other).invite);
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
        StringBuilder sbU = a.U("Resolved(invite=");
        sbU.append(this.invite);
        sbU.append(")");
        return sbU.toString();
    }
}
