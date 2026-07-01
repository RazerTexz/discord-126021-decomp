package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.models.domain.ModelInvite;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InviteGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteGenerator$InviteGenerationState {
    private final ModelInvite lastGeneratedInvite;
    private final InviteGenerator$GenerationState state;

    public InviteGenerator$InviteGenerationState() {
        this(null, null, 3, null);
    }

    public InviteGenerator$InviteGenerationState(ModelInvite modelInvite, InviteGenerator$GenerationState inviteGenerator$GenerationState) {
        m.checkNotNullParameter(inviteGenerator$GenerationState, "state");
        this.lastGeneratedInvite = modelInvite;
        this.state = inviteGenerator$GenerationState;
    }

    public static /* synthetic */ InviteGenerator$InviteGenerationState copy$default(InviteGenerator$InviteGenerationState inviteGenerator$InviteGenerationState, ModelInvite modelInvite, InviteGenerator$GenerationState inviteGenerator$GenerationState, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = inviteGenerator$InviteGenerationState.lastGeneratedInvite;
        }
        if ((i & 2) != 0) {
            inviteGenerator$GenerationState = inviteGenerator$InviteGenerationState.state;
        }
        return inviteGenerator$InviteGenerationState.copy(modelInvite, inviteGenerator$GenerationState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getLastGeneratedInvite() {
        return this.lastGeneratedInvite;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InviteGenerator$GenerationState getState() {
        return this.state;
    }

    public final InviteGenerator$InviteGenerationState copy(ModelInvite lastGeneratedInvite, InviteGenerator$GenerationState state) {
        m.checkNotNullParameter(state, "state");
        return new InviteGenerator$InviteGenerationState(lastGeneratedInvite, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteGenerator$InviteGenerationState)) {
            return false;
        }
        InviteGenerator$InviteGenerationState inviteGenerator$InviteGenerationState = (InviteGenerator$InviteGenerationState) other;
        return m.areEqual(this.lastGeneratedInvite, inviteGenerator$InviteGenerationState.lastGeneratedInvite) && m.areEqual(this.state, inviteGenerator$InviteGenerationState.state);
    }

    public final ModelInvite getLastGeneratedInvite() {
        return this.lastGeneratedInvite;
    }

    public final InviteGenerator$GenerationState getState() {
        return this.state;
    }

    public int hashCode() {
        ModelInvite modelInvite = this.lastGeneratedInvite;
        int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
        InviteGenerator$GenerationState inviteGenerator$GenerationState = this.state;
        return iHashCode + (inviteGenerator$GenerationState != null ? inviteGenerator$GenerationState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("InviteGenerationState(lastGeneratedInvite=");
        sbU.append(this.lastGeneratedInvite);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ InviteGenerator$InviteGenerationState(ModelInvite modelInvite, InviteGenerator$GenerationState inviteGenerator$GenerationState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : modelInvite, (i & 2) != 0 ? InviteGenerator$GenerationState.INIT : inviteGenerator$GenerationState);
    }
}
