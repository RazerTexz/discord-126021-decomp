package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallParticipantsAdapter$ListItem$VoiceUser extends CallParticipantsAdapter$ListItem {
    private final boolean canRing;
    private final boolean isSpectatingSameStream;
    private final String key;
    private final StoreVoiceParticipants$VoiceUser participant;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ListItem$VoiceUser(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "participant");
        this.participant = storeVoiceParticipants$VoiceUser;
        this.canRing = z2;
        this.isSpectatingSameStream = z3;
        this.key = String.valueOf(storeVoiceParticipants$VoiceUser.getUser().getId());
    }

    public static /* synthetic */ CallParticipantsAdapter$ListItem$VoiceUser copy$default(CallParticipantsAdapter$ListItem$VoiceUser callParticipantsAdapter$ListItem$VoiceUser, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            storeVoiceParticipants$VoiceUser = callParticipantsAdapter$ListItem$VoiceUser.participant;
        }
        if ((i & 2) != 0) {
            z2 = callParticipantsAdapter$ListItem$VoiceUser.canRing;
        }
        if ((i & 4) != 0) {
            z3 = callParticipantsAdapter$ListItem$VoiceUser.isSpectatingSameStream;
        }
        return callParticipantsAdapter$ListItem$VoiceUser.copy(storeVoiceParticipants$VoiceUser, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreVoiceParticipants$VoiceUser getParticipant() {
        return this.participant;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanRing() {
        return this.canRing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSpectatingSameStream() {
        return this.isSpectatingSameStream;
    }

    public final CallParticipantsAdapter$ListItem$VoiceUser copy(StoreVoiceParticipants$VoiceUser participant, boolean canRing, boolean isSpectatingSameStream) {
        m.checkNotNullParameter(participant, "participant");
        return new CallParticipantsAdapter$ListItem$VoiceUser(participant, canRing, isSpectatingSameStream);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallParticipantsAdapter$ListItem$VoiceUser)) {
            return false;
        }
        CallParticipantsAdapter$ListItem$VoiceUser callParticipantsAdapter$ListItem$VoiceUser = (CallParticipantsAdapter$ListItem$VoiceUser) other;
        return m.areEqual(this.participant, callParticipantsAdapter$ListItem$VoiceUser.participant) && this.canRing == callParticipantsAdapter$ListItem$VoiceUser.canRing && this.isSpectatingSameStream == callParticipantsAdapter$ListItem$VoiceUser.isSpectatingSameStream;
    }

    public final boolean getCanRing() {
        return this.canRing;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final StoreVoiceParticipants$VoiceUser getParticipant() {
        return this.participant;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.participant;
        int iHashCode = (storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.hashCode() : 0) * 31;
        boolean z2 = this.canRing;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isSpectatingSameStream;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isSpectatingSameStream() {
        return this.isSpectatingSameStream;
    }

    public String toString() {
        StringBuilder sbU = a.U("VoiceUser(participant=");
        sbU.append(this.participant);
        sbU.append(", canRing=");
        sbU.append(this.canRing);
        sbU.append(", isSpectatingSameStream=");
        return a.O(sbU, this.isSpectatingSameStream, ")");
    }
}
