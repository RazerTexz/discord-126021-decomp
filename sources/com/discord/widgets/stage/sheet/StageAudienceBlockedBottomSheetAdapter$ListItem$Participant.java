package com.discord.widgets.stage.sheet;

import b.d.b.a.a;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageAudienceBlockedBottomSheetAdapter$ListItem$Participant extends StageAudienceBlockedBottomSheetAdapter$ListItem {
    private final boolean isSpeaker;
    private final String key;
    private final StoreVoiceParticipants$VoiceUser participant;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetAdapter$ListItem$Participant(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, boolean z2) {
        super(null);
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "participant");
        this.participant = storeVoiceParticipants$VoiceUser;
        this.isSpeaker = z2;
        this.type = 1;
        this.key = String.valueOf(storeVoiceParticipants$VoiceUser.getUser().getId());
    }

    public static /* synthetic */ StageAudienceBlockedBottomSheetAdapter$ListItem$Participant copy$default(StageAudienceBlockedBottomSheetAdapter$ListItem$Participant stageAudienceBlockedBottomSheetAdapter$ListItem$Participant, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            storeVoiceParticipants$VoiceUser = stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.participant;
        }
        if ((i & 2) != 0) {
            z2 = stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.isSpeaker;
        }
        return stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.copy(storeVoiceParticipants$VoiceUser, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreVoiceParticipants$VoiceUser getParticipant() {
        return this.participant;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSpeaker() {
        return this.isSpeaker;
    }

    public final StageAudienceBlockedBottomSheetAdapter$ListItem$Participant copy(StoreVoiceParticipants$VoiceUser participant, boolean isSpeaker) {
        m.checkNotNullParameter(participant, "participant");
        return new StageAudienceBlockedBottomSheetAdapter$ListItem$Participant(participant, isSpeaker);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageAudienceBlockedBottomSheetAdapter$ListItem$Participant)) {
            return false;
        }
        StageAudienceBlockedBottomSheetAdapter$ListItem$Participant stageAudienceBlockedBottomSheetAdapter$ListItem$Participant = (StageAudienceBlockedBottomSheetAdapter$ListItem$Participant) other;
        return m.areEqual(this.participant, stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.participant) && this.isSpeaker == stageAudienceBlockedBottomSheetAdapter$ListItem$Participant.isSpeaker;
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
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.participant;
        int iHashCode = (storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.hashCode() : 0) * 31;
        boolean z2 = this.isSpeaker;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isSpeaker() {
        return this.isSpeaker;
    }

    public String toString() {
        StringBuilder sbU = a.U("Participant(participant=");
        sbU.append(this.participant);
        sbU.append(", isSpeaker=");
        return a.O(sbU, this.isSpeaker, ")");
    }
}
