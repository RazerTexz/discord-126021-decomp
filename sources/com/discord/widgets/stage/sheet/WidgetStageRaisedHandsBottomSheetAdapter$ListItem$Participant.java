package com.discord.widgets.stage.sheet;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant extends WidgetStageRaisedHandsBottomSheetAdapter$ListItem {
    private final String key;
    private final GuildMember member;
    private final StoreVoiceParticipants$VoiceUser participant;
    private final UtcDateTime requestToSpeakTimestamp;
    private final GuildRole role;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, UtcDateTime utcDateTime, GuildMember guildMember, GuildRole guildRole) {
        super(null);
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "participant");
        this.participant = storeVoiceParticipants$VoiceUser;
        this.requestToSpeakTimestamp = utcDateTime;
        this.member = guildMember;
        this.role = guildRole;
        this.key = String.valueOf(storeVoiceParticipants$VoiceUser.getUser().getId());
    }

    public static /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant copy$default(WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, UtcDateTime utcDateTime, GuildMember guildMember, GuildRole guildRole, int i, Object obj) {
        if ((i & 1) != 0) {
            storeVoiceParticipants$VoiceUser = widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.participant;
        }
        if ((i & 2) != 0) {
            utcDateTime = widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.requestToSpeakTimestamp;
        }
        if ((i & 4) != 0) {
            guildMember = widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.member;
        }
        if ((i & 8) != 0) {
            guildRole = widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.role;
        }
        return widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.copy(storeVoiceParticipants$VoiceUser, utcDateTime, guildMember, guildRole);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreVoiceParticipants$VoiceUser getParticipant() {
        return this.participant;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UtcDateTime getRequestToSpeakTimestamp() {
        return this.requestToSpeakTimestamp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    public final WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant copy(StoreVoiceParticipants$VoiceUser participant, UtcDateTime requestToSpeakTimestamp, GuildMember member, GuildRole role) {
        m.checkNotNullParameter(participant, "participant");
        return new WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant(participant, requestToSpeakTimestamp, member, role);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant)) {
            return false;
        }
        WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant = (WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant) other;
        return m.areEqual(this.participant, widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.participant) && m.areEqual(this.requestToSpeakTimestamp, widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.requestToSpeakTimestamp) && m.areEqual(this.member, widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.member) && m.areEqual(this.role, widgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant.role);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final GuildMember getMember() {
        return this.member;
    }

    public final StoreVoiceParticipants$VoiceUser getParticipant() {
        return this.participant;
    }

    public final UtcDateTime getRequestToSpeakTimestamp() {
        return this.requestToSpeakTimestamp;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.participant;
        int iHashCode = (storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.hashCode() : 0) * 31;
        UtcDateTime utcDateTime = this.requestToSpeakTimestamp;
        int iHashCode2 = (iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        GuildMember guildMember = this.member;
        int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        GuildRole guildRole = this.role;
        return iHashCode3 + (guildRole != null ? guildRole.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Participant(participant=");
        sbU.append(this.participant);
        sbU.append(", requestToSpeakTimestamp=");
        sbU.append(this.requestToSpeakTimestamp);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", role=");
        sbU.append(this.role);
        sbU.append(")");
        return sbU.toString();
    }
}
